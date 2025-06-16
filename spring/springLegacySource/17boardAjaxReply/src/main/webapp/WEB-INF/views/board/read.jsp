<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false" %>
<%@include file="../include/header.jsp"%>
<style>
	#modDiv, #reReplyMod{
		width:400px;
		height:150px;
		background-color:gray;
		position:fixed;
		top:20%;
		left:50%;
		margin-top:-50px;
		magin-left:-150px;
		padding:10px;
		z-index:1000; 
	}
</style>
<script>
var bId="${boardDto.bId}";
var page=1;
$(document).ready(function() {
	var fObject=$(".form");
	console.log(fObject);
	getPageList(page);
	
	/*댓글 등록 완료 후 실행*/
	function getPageList(page){
		$.ajax({
			type: 'GET',
			url: '/ex/replies/'+bId+'/'+page,
			dataType: 'json',
			success: function(data) {
				console.log(data);
				var str="";				
				$(data.list).each(function() {
					var indent=this.rIndent*30;
					str+="<div data-rId='"+this.rId+"' class='replyLi' style='margin-left:" + indent + "px'>"+
					 	 this.rId+" : "+
						 this.rName+"<br>"+
						 this.rContent+
				     	 "<br><button>수정/삭제</button></div>"+
				     	 "<div data-rId='"+this.rId+"' class='reReplyLi' style='margin-left:" + indent + "px'>"+
				     	 "<button>댓글</button></div>"
				});
				$("#replies").html(str);
				
				var pagination="";
				if (data.pageMaker.prev) {
					pagination += "<a href='" + (data.pageMaker.startPage - 1) + "'> &laquo; </a>";
				}
	            for (var i = data.pageMaker.startPage; i <= data.pageMaker.endPage; i++) {
					var strClass = data.pageMaker.page == i ? 'class="active"' : '';
					pagination += "<a " + strClass + " href='" + i + "'>" + i + "</a>";
	            }
	            if (data.pageMaker.next) {
	            	pagination += "<a href='" + (data.pageMaker.endPage + 1) + "'> &raquo; </a>";
	            }
	            console.log(str)
	            $(".pagination").html(pagination);
			},
			error: function(xhr, status, error) {
				console.error("Error: ", error);
			}
		});
	}
	
	/*댓글 mod 수정/삭제 버튼 .on(click 이벤트시 replyLi button만 실행시켜라)*/
	$("#replies").on("click",".replyLi button",function(){
		var rId=$(this).parent().attr("data-rId");
		var rContent=$(this).parent().text();
		$(".modal-title").html(rId);
		$("#modContent").val(rContent);
		$("#modDiv").show("slow");
	})	
	
	/*댓글 창닫기 버튼*/
	$("#closeBtn").on("click",function(){
		$("#modDiv").hide("slow");
	})
	
	/*댓글 수정 버튼*/
	$("#replyModBtn").on("click",function(){
		
		var rId=$(".modal-title").html();
		var rContent = $("#modContent").val();
	
		$.ajax({
			type:'PUT',
			url:'/ex/replies/'+rId,
			headers:{
				"Content-Type":"application/json"
			},
			data:JSON.stringify({rContent:rContent}),
			dataType:'text',
			success:function(result){
				if(result=='SUCCESS'){
					alert("수정 되었습니다.");
					$("#modDiv").hide("slow");
					getPageList(page);
				}
			}
		})
	})
	
	$("#replies").on("click",".reReplyLi button",function(){
		var rId=$(this).parent().attr("data-rId");
		$(".re-modal-title").html(rId);
		$("#reReplyMod").show("slow");
	})
	
	$("#reReplyCloseBtn").on("click",function(){
		$("#reReplyMod").hide("slow");
	})
	
	/*대댓글 등록 버튼*/
	$("#reReplyAddBtn").on("click",function(){	
		var rId=$(".re-modal-title").html();
		var rName=$("#reReplyName").val();
		var rContent=$("#reReplyText").val();
		
		$.ajax({
			type:'POST',
			url:'/ex/replies/'+rId,
			headers:{
				"Content-Type":"application/json"
			},
			dataType:'text',
			data:JSON.stringify({
				bId:bId,
				rContent:rContent,
				rName:rName,
				rId:rId,
			}),
			success:function(result){
				if(result == 'SUCCESS'){
					alert("댓글이 등록됐습니다.");
					$("#reReplyMod").hide("slow");
					getPageList(page);
				}
			},
			error: function(xhr, status, error) {
	        	console.error("Error: ", error);
	        }
		});
	});
	
	/*댓글 등록 버튼*/
	$("#replyAddBtn").on("click",function(){		
		var rName=$("#newReplyWriter").val();
		var rContent=$("#newReplyText").val();
		
		$.ajax({
			type:'POST',
			url:'/ex/replies',
			headers:{
				"Content-Type":"application/json"
			},
			dataType:'text',
			data:JSON.stringify({
				bId:bId,
				rContent:rContent,
				rName:rName
			}),
			success:function(result){
				if(result == 'SUCCESS'){
					alert("댓글이 등록됐습니다.");
					getPageList(page);
				}
			},
			error: function(xhr, status, error) {
	        	console.error("Error: ", error);
	        }
		});
	});

	/*댓글 삭제 버튼*/
	$("#replyDelBtn").on("click",function(){
		var rId=$(".modal-title").html();
		$.ajax({
			type:'delete',
			url:'/ex/replies/'+rId,
			headers:{
				"Content-Type":"application/json"
			},
			dataType:'text',
			success:function(result){
				if(result=='SUCCESS'){
					alert("삭제 되었습니다.");
					$("#modDiv").hide("slow");
					getPageList(page);
				}
			}
		})
	})
		
	var fObject=$(".form");
	$(".pagination").on("click","a",function(event){
		event.preventDefault();
		page=$(this).attr("href");
		getPageList(page);
		
	})
	
	$(".btnList").on("click",function(){
		fObject.attr("method","get");
		fObject.attr("action","/ex/sboard/list");
		fObject.submit();
	})	
	
	$(".btnRemove").on("click",function(){
		fObject.attr("action","/ex/sboard/remove");
		fObject.submit();
	})
	
	$(".btnModify").on("click",function(){
		fObject.attr("method","get");
		fObject.attr("action","/ex/sboard/modify");
		fObject.submit();
	})
	
	$(".btnReply").on("click",function(){
		fObject.attr("method","get");	
		fObject.attr("action","/ex/sboard/writeRep");
		fObject.submit();
	})
	
	$(".btnLike").on("click",function(){
		fObject.attr("action","/ex/sboard/like");
		fObject.submit();
	})
	
	$(".btnDislike").on("click",function(){
		fObject.attr("action","/ex/sboard/dislike");
		fObject.submit();
	})
	
});

</script>
			
<div class="main">
	
	<form class="form" method="post">
		<input type='hidden' name='bId' value="${boardDto.bId}"> 
		<input type='hidden' name='page' value="${pageMaker.page}"> 
		<input type='hidden' name='perPageNum' value="${pageMaker.perPageNum}">
		<input type='hidden' name='searchType' value="${pageMaker.searchType}">
		<input type='hidden' name='keyword' value="${pageMaker.keyword}">
	</form>
	
	<h2>카테고리
		<input type="text" style="width:100%" name='bGroupKind' value="${boardDto.bGroupKind}" readonly="readonly">
	</h2>
	<h2>제목
		<input type="text" style="width:100%" name='bTitle' value="${boardDto.bTitle}" readonly="readonly">
	</h2>
	<h2>작성자 
		<input type="text" name="bName" style="width:100%" value="${boardDto.bName}" readonly="readonly">
	</h2>
	<h2>내용
		<textarea  style="width:100%" name="bContent" rows="3" readonly="readonly">${boardDto.bContent}</textarea>
	</h2>
	<c:if test="${not empty boardDto.bUpdateTime}">
		<h2>수정된 날짜
			<input type="text" style="width:100%" name='bUpdateTime' value="${boardDto.bUpdateTime}" readonly="readonly">
		</h2>
	</c:if>
		
	<!-- /.box-body -->
	<div class="box-footer">
		<button type="submit" class="btnLike">좋아요: ${boardDto.bLike }</button>
		<button type="submit" class="btnDislike">싫어요: ${boardDto.bDislike }</button><br><br>
		<button type="submit" class="btnModify">수정</button>
		<button type="submit" class="btnRemove">삭제</button>
		<button type="submit" class="btnReply">답글</button>
		<button type="submit" class="btnList">LIST page로 이동</button>
	</div>
	
	<!-- 댓글 입력 창 -->
	<h2>Reply</h2>
	<div>
		<div>작성자 : <input type="text" id="newReplyWriter"/></div><br>
		<div>내용 : <input type="text" id="newReplyText"/></div><br>
		<button id="replyAddBtn">댓글 등록</button><br>
	</div>
	<ul id="replies"></ul>
	<div class="pagination"></div>

<!-- Mod 버튼 댓글이 달려있지 않으면 display:none 상태이다 -->
<div id='modDiv' style="display:none">
	<div class="modal-title"></div>
	<div>
		내용 : <input type='text' id='modContent'>
	</div>
	<div>
		<button type="button" id="replyModBtn">수정</button>
		<button type="button" id="replyDelBtn">삭제</button>
		<button type="button" id="closeBtn">창 닫기</button>
	</div>
</div>
<div id='reReplyMod' style="display:none">
	<div class="re-modal-title"></div>
	<div>
		작성자 : <input type='text' id='reReplyName'>
	</div>
	<div>
		내용 : <input type='text' id='reReplyText'>
	</div>
	<div>
		<button type="button" id="reReplyAddBtn">등록</button>
		<button type="button" id="reReplyCloseBtn">창 닫기</button>
	</div>
</div>
</div>

<%@include file="../include/footer.jsp"%>


