<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script>
	$(function(){
		$("button").click(function(){
			/* alert("Test"); */
			event.preventDefault();
			/* $("#displayHobby").html($("#displayHobby").html()
					+"<div><input type=text name=hobbys ><button>X</button></div>"); */
			//append,prepend    after before
			$("#displayHobby").append("<div><input type=text name=hobbys ><button>X</button></div>");
		})
		
		$("#displayHobby").on("click","button",function(){
			event.preventDefault();
			//alert("test");
			$(this).parent().remove();
		})
	})

</script>
</head>
<body>
<form action="/jsp20CustommerHobby/customerHobby/insertDB.customerHobby" method="get">
	이름:<input type=text name=name ><br>
	키:<input type=text name=height ><br>
	생일:<input type="datetime-local" name=birthday ><br>
	하비:
	<!-- <input type=text name=hobbys >
	<input type=text name=hobbys >
	<input type=text name=hobbys ><br> -->
	<div id='displayHobby'>
	
	</div>
	<button>하비 추가</button>
	<input type="submit" value=전송 >
</form>
</body>
</html>