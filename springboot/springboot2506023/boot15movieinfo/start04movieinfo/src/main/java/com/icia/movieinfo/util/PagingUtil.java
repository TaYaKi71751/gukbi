package com.icia.movieinfo.util;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PagingUtil {//페이지 만드는 클래스
	private int maxNum;//전체 글 개수를 저장하는 변수
	private int pageNum;//현재 보이는 페이지의 번호 저장 변수
	private int listCnt;//한 페이지 당 보일 게시글의 개수 저장 변수
	private int pageCnt;//한 페이지 당 보여줄 페이지의 개수 저장 변수
	
	//페이징용 html 코드를 만드는 메소드
	public String makePaging() {
		String pageStr = null;
		StringBuffer sb = new StringBuffer();
		
		//1. 전체 페이지 개수 구하기(페이지 당 listCnt(5개) 만큼 출력)
		//전체 게시글 9개 : 2 페이지
		//전체 게시글 11개 : 3 페이지
		int totalPage = (maxNum % listCnt) > 0 ?
				maxNum / listCnt + 1 :
				maxNum / listCnt;
		//2. 현재 페이지가 속해 있는 그룹 번호 구하기
		int curGroup = (pageNum % pageCnt) > 0 ?
				pageNum / pageCnt + 1 :
				pageNum / pageCnt;
		//3. 현재 보이는 페이지 그룹의 시작 번호 구하기
		int start = (curGroup * pageCnt) - (pageCnt - 1);
		//두번째 그룹 시작번호 = pageCnt(5) * 2 - (5 - 1) = 6
		
		//4. 현재 보이는 페이지 그룹의 마지막 번호 구하기
		int end = (curGroup * pageCnt) >= totalPage ?
				totalPage : curGroup * pageCnt;
		
		//이전 버튼 처리
		if(start != 1) {
			sb.append("<a class='pno' href='./?pageNum="
					+ (start - 1) + "'>");
			sb.append("◀</a>");
		}//<a class='pno' herf='./?pageNum=5'> 이전 </a>
		//페이지 번호를 5개씩 보여주는 경우,
		//6페이지가 보이는 화면에서 이전 버튼이 보이게 되고
		//그 이전 버튼의 링크는 5페이지가 된다.
		
		//중간 페이지 번호 버튼 처리
		for(int i = start; i <= end; i++) {
			if(pageNum != i) {//현재 페이지가 아닌 페이지 번호
				sb.append("<a class='pno' href='./?pageNum="
						+ i + "'>");
				sb.append(i + "</a>");
			}//<a class='pno' href='./?pageNum=3> 3 </a>
			else {//현재 보이는 페이지
				//현재 보이는 페이지 번호에는 링크를 걸지 않는다.
				sb.append("<font class='pno'>");
				sb.append(i + "</font>");
			}//<font class='pno' style='color: red;'> 2 </font>
		}
		
		//다음 버튼 처리
		if(end != totalPage) {
			sb.append("<a class='pno' href='./?pageNum="
					+ (end + 1) + "'>");
			sb.append("▶</a>");
		}//<a class='pno' href='./?pageNum=6'> 다음 </a>
		
		//StringBuffer에 저장된 내용을 문자열로 변환
		pageStr = sb.toString();
		
		return pageStr;
	}
}//class end



