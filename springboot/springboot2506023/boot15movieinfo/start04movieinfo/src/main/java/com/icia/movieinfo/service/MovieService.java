package com.icia.movieinfo.service;

import com.icia.movieinfo.dao.MovieDao;
import com.icia.movieinfo.dto.MovieDto;
import com.icia.movieinfo.util.PagingUtil;
import jakarta.servlet.http.HttpSession;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Log
public class MovieService {
    @Autowired
    private MovieDao mDao; // MovieDao 객체를 의존성 주입받아 사용

    private ModelAndView mv; // 결과를 담아 반환할 ModelAndView 객체

    private int listCnt = 5; // 페이지 당 출력할 게시글 개수

    // 영화 목록을 가져오는 메소드
    public ModelAndView getMovieList(Integer pageNum, HttpSession session) {
        log.info("getMovieList()");
        mv = new ModelAndView();

        // 페이지 번호가 null일 경우 1로 초기화
        if (pageNum == null) {
            pageNum = 1;
        }

        // 페이지네이션에 필요한 값 설정
        Map<String, Integer> pmap = new HashMap<>();
        pmap.put("pageNum", (pageNum - 1) * listCnt); // 현재 페이지의 시작 인덱스
        pmap.put("listCnt", listCnt); // 한 페이지 당 게시글 개수

        // 데이터베이스에서 영화 목록 가져오기
        List<MovieDto> mList = mDao.getMovieList(pmap);
        mv.addObject("mList", mList); // 영화 목록을 ModelAndView에 추가

        // 페이징 처리 HTML 생성 및 추가
        String pageHtml = getPaging(pageNum);
        mv.addObject("paging", pageHtml);

        // 현재 페이지 번호를 세션에 저장
        session.setAttribute("pageNum", pageNum);
        mv.setViewName("list"); // 반환할 뷰 이름 설정

        return mv; // ModelAndView 반환
    }

    // 페이징 HTML을 생성하는 메소드
    private String getPaging(Integer pageNum) {
        String pageHtml = null;

        // 전체 게시글 개수 가져오기
        int maxNum = mDao.cntMovie();
        int pageCnt = 5; // 한 페이지 당 보여질 페이지 번호의 개수

        // 페이징 유틸 객체를 사용하여 페이징 HTML 생성
        PagingUtil paging = new PagingUtil(maxNum, pageNum, listCnt, pageCnt);
        pageHtml = paging.makePaging();

        return pageHtml;
    }

    // 영화 정보를 데이터베이스에 추가하는 메소드
    public String insertMovie(List<MultipartFile> files, MovieDto movie, HttpSession session, RedirectAttributes rttr) {
        log.info("insertMovie()");
        String msg = null; // 성공 또는 실패 메시지
        String view = null; // 리다이렉트할 URL
        String upFile = files.get(0).getOriginalFilename(); // 첫 번째 파일의 원본 이름

        try {
            // 파일이 존재할 경우 업로드 처리
            if (!upFile.equals("")) {
                fileUpload(files, session, movie);
            }
            mDao.movieInsert(movie); // 영화 정보 데이터베이스에 추가
            view = "redirect:/?pageNum=1"; // 첫 페이지로 리다이렉트
            msg = "작성 성공";
        } catch (Exception e) {
            e.printStackTrace();
            view = "redirect:writeFrm"; // 작성 폼으로 리다이렉트
            msg = "작성 실패";
        }

        rttr.addFlashAttribute("msg", msg); // 메시지를 리다이렉트 속성에 추가
        return view; // 리다이렉트 URL 반환
    }

    // 파일 업로드를 처리하는 메소드
    private void fileUpload(List<MultipartFile> files, HttpSession session, MovieDto movie) throws Exception {
        log.info("fileUpload()");
        String sysname = null; // 시스템 파일명
        String oriname = null; // 원본 파일명

        // 업로드 폴더 경로 설정
        String realPath = session.getServletContext().getRealPath("/");
        realPath += "upload/";
        File folder = new File(realPath);
        System.out.println("파일 업로드 경로: " + realPath);
        // 업로드 폴더가 없으면 생성
        if (!folder.isDirectory()) {
            folder.mkdir();
        }

        // 업로드할 파일 처리
        MultipartFile mf = files.get(0);
        oriname = mf.getOriginalFilename(); // 원본 파일명 가져오기

        // 시스템 파일명 생성 (현재 시간 + 확장자)
        sysname = System.currentTimeMillis() + oriname.substring(oriname.lastIndexOf("."));
        File file = new File(realPath + sysname);

        mf.transferTo(file); // 파일 저장

        // MovieDto에 파일 정보 설정
        movie.setP_oriname(oriname);
        movie.setP_sysname(sysname);
    }

    // 특정 영화를 조회하는 메소드
    public ModelAndView getMovie(Integer m_code) {
        log.info("getMovie()");
        mv = new ModelAndView();

        MovieDto movie = mDao.movieSelect(m_code); // 영화 정보 가져오기
        mv.addObject("movie", movie); // ModelAndView에 영화 정보 추가
        return mv; // ModelAndView 반환
    }

    // 영화 정보를 수정하는 메소드
    public String movieUpdate(List<MultipartFile> files, MovieDto movie, HttpSession session, RedirectAttributes rttr) {
        log.info("movieUpdate()");
        String msg = null; // 성공 또는 실패 메시지
        String view = null; // 리다이렉트할 URL
        String poster = movie.getP_sysname(); // 기존 포스터 파일명
        String upFile = files.get(0).getOriginalFilename(); // 새 파일의 원본 이름

        try {
            // 새 파일이 존재할 경우 업로드 처리
            if (!upFile.equals("")) {
                fileUpload(files, session, movie);
            }
            mDao.movieUpdate(movie); // 영화 정보 업데이트

            // 기존 포스터 파일 삭제
            if (poster != null && !upFile.equals("")) {
                fileDelete(poster, session);
            }

            view = "redirect:detail?m_code=" + movie.getM_code(); // 상세 페이지로 리다이렉트
            msg = "수정 성공";
        } catch (Exception e) {
            e.printStackTrace();
            view = "redirect:updateFrm?m_code=" + movie.getM_code(); // 수정 폼으로 리다이렉트
            msg = "수정 실패";
        }

        rttr.addFlashAttribute("msg", msg); // 메시지를 리다이렉트 속성에 추가
        return view; // 리다이렉트 URL 반환
    }

    // 파일을 삭제하는 메소드
    private void fileDelete(String poster, HttpSession session) throws Exception {
        log.info("fileDelete()");

        String realPath = session.getServletContext().getRealPath("/");
        realPath += "upload/" + poster; // 삭제할 파일 경로 설정
        File file = new File(realPath);

        // 파일이 존재하면 삭제
        if (file.exists()) {
            file.delete();
        }
    }

    // 영화를 삭제하는 메소드
    public void movieDelete(Integer m_code) {
        mDao.movieDelete(m_code); // 영화 정보 데이터베이스에서 삭제
    }
}
