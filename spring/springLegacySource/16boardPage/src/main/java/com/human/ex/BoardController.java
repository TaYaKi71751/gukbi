package com.human.ex;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.human.dto.BoardDto;
//import org.zerock.domain.Criteria;
//import org.zerock.domain.PageMaker;
import com.human.model.BoardService;
import com.human.vo.BoardVo;

@Controller
@RequestMapping("/board/*")
public class BoardController {

  private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

  @Autowired
  private BoardService service;

  //���Ϲ��ڿ��� ������ ��û �ֻ簡 view��ΰ� �ȴ�.
  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public void registerGET(BoardDto board, Model model) throws Exception {

    logger.info("register get ...........");
  }

  // @RequestMapping(value = "/register", method = RequestMethod.POST)
  // public String registPOST(BoardVO board, Model model) throws Exception {
  //
  // logger.info("regist post ...........");
  // logger.info(board.toString());
  //
  // service.regist(board);
  //
  // model.addAttribute("result", "success");
  //
  // //return "/board/success";
  // return "redirect:/board/listAll";
  // }
	@RequestMapping(value = "/reply", method = RequestMethod.GET)
	public void replyGet(@RequestParam("bId") int bId, Model model) throws Exception {
		logger.info("register get ...........");
		model.addAttribute(service.read(bId));
	}
	
	@RequestMapping(value="/reply", method=RequestMethod.POST)
	public String replyPost(@RequestParam("bId") int bId, Model model, BoardDto board,BoardDto vo, RedirectAttributes rttr) throws Exception {		
		BoardDto originalBoard = service.read(bId); // 원본 글 정보를 가져옴
		service.replyUpdate(vo);
		service.reply(board); // 답글 작12315498132165116515121651561584984211322124356484dfkfdsd성
		
	    return "redirect:/board/listAll";
	}

  @RequestMapping(value = "/register", method = RequestMethod.POST)
  public String registPOST(BoardDto board, Model model,RedirectAttributes rttr) throws Exception {

    logger.info("regist post ...........");
    logger.info(board.toString());

    service.regist(board);
    
   rttr.addFlashAttribute("msg", "success");
    
   return "redirect:/board/listAll";
    
  }

  @RequestMapping(value = "/listAll", method = RequestMethod.GET)
  public void listAll(@RequestParam(value="bGroupKind", required=false)String bGroupKind,BoardVo vo, Model model) throws Exception  {
	  
	  
    logger.info("show all list......................");
    System.out.println("--list pm " + vo);
    
    if(bGroupKind==null) {
    	List<BoardDto> serchList = service.listSearchCriteria(vo);
    	model.addAttribute("list", serchList);
		
	}else {
		model.addAttribute("list", service.listMenu(bGroupKind));
		List<BoardDto> serchList = service.listSearchCriteria(vo);
    	model.addAttribute("list", serchList);
		
	    	}
    model.addAttribute("category",service.menuKind());
    vo.setTotalCount(service.listSearchCount(vo));
    model.addAttribute("bGroupKind", vo.getPage());
    model.addAttribute("page", vo.getPage());
    model.addAttribute("perPageNum", vo.getPerPageNum());
    model.addAttribute("searchType", vo.getSearchType());
    model.addAttribute("keyword", vo.getKeyword());
    model.addAttribute("categoryType", vo.getCategoryType());
   
    
  }
  @RequestMapping(value = "/read", method = RequestMethod.GET)
  public void read(@RequestParam("bId") int bId, Model model) throws Exception {
	    logger.info("read......................"+bId);
    model.addAttribute(service.read(bId));
    BoardDto board = service.read(bId);
    service.bHitUpdate(bId);
  }
//  @RequestMapping(value = "/bHitUpdate", method = RequestMethod.GET)
//  public void bHitUpdate(BoardDto dto, Model model) throws Exception {
//	    logger.info("bHitUpdate.................");
//    service.bHitUpdate(dto);
//    System.out.println(dto);
//  }
  @RequestMapping(value = "/bLike", method = RequestMethod.GET)
  public String bLike(@RequestParam("bId") int bId, Model model) throws Exception {
	    logger.info("bLike......................"+bId);
    service.bLike(bId);
    return "forward:/board/listAll";
  }
  @RequestMapping(value = "/bHitUpdate", method = RequestMethod.GET)
  public String bHitUpdate(@RequestParam("bId") int bId, RedirectAttributes rttr) throws Exception {
      service.bHitUpdate(bId);
      rttr.addFlashAttribute("msg", "success");
      return "redirect:/board/listAll";
  }
  @RequestMapping(value = "/remove", method = RequestMethod.POST)
  public String remove(@RequestParam("bId") int bId, RedirectAttributes rttr) throws Exception {
    service.remove(bId);
    rttr.addFlashAttribute("msg", "success");
    return "redirect:/board/listAll";
  }

  @RequestMapping(value = "/modify", method = RequestMethod.GET)
  public void modifyGET(int bId, Model model) throws Exception {

    model.addAttribute(service.read(bId));
  }
  
  @RequestMapping(value = "/modify", method = RequestMethod.POST)
  public String modifyPOST(BoardDto board, RedirectAttributes rttr) throws Exception {

    logger.info("mod post............");

    service.modify(board);
    rttr.addFlashAttribute("msg", "success");

    return "redirect:/board/listAll";
  }

  
  
	/*
	 * @RequestMapping(value = "/bHitUpdate", method = RequestMethod.GET) public
	 * void String bHitUpdate(BoardDto board, Model model) throws Exception {
	 * 
	 * service.bHitUpdate(board); }
	 */

//  @RequestMapping(value = "/listCri", method = RequestMethod.GET)
//  public void listAll(Criteria cri, Model model) throws Exception {
//
//    logger.info("show list Page with Criteria......................");
//
//    model.addAttribute("list", service.listCriteria(cri));
//  }
//
//  @RequestMapping(value = "/listPage", method = RequestMethod.GET)
//  public void listPage(@ModelAttribute("cri") Criteria cri, Model model) throws Exception {
//
//    logger.info(cri.toString());
//
//    model.addAttribute("list", service.listCriteria(cri));
//    PageMaker pageMaker = new PageMaker();
//    pageMaker.setCri(cri);
//    // pageMaker.setTotalCount(131);
//
//    pageMaker.setTotalCount(service.listCountCriteria(cri));
//
//    model.addAttribute("pageMaker", pageMaker);
//  }
//
//  @RequestMapping(value = "/readPage", method = RequestMethod.GET)
//  public void read(@RequestParam("bId") int bId, @ModelAttribute("cri") Criteria cri, Model model) throws Exception {
//
//    model.addAttribute(service.read(bId));
//  }
//
//  @RequestMapping(value = "/removePage", method = RequestMethod.POST)
//  public String remove(@RequestParam("bId") int bId, Criteria cri, RedirectAttributes rttr) throws Exception {
//
//    service.remove(bId);
//
//    rttr.addAttribute("page", cri.getPage());
//    rttr.addAttribute("perPageNum", cri.getPerPageNum());
//    rttr.addFlashAttribute("msg", "SUCCESS");
//
//    return "redirect:/board/listPage";
//  }
//
//  @RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
//  public void modifyPagingGET(@RequestParam("bId") int bId, @ModelAttribute("cri") Criteria cri, Model model)
//      throws Exception {
//
//    model.addAttribute(service.read(bId));
//  }

}
