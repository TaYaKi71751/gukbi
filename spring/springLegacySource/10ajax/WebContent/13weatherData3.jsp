<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- jQuery Framework 참조하기 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

<script>
$(function(){
	$("button").click(function(){
		alert($("#weatherTime").val());//2024-07-09T18:08
		var now=new Date($("#weatherTime").val());
		
		var year=now.getFullYear(); //2024
		var month='0'+(now.getMonth()+1);//1월 0 
		var month=month.substr(-2);//항상 뒤에서 부터 2자리로 만든다.
		var day ='0'+now.getDate();
		var day=day.substr(-2);
		
		var time = $("#weatherTime").val().substr(-5,2)+$("#weatherTime").val().substr(-2);
		alert(month);
		alert(day);
		alert(time);
		
		
	})

});





//현재 날씨
//https://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst?serviceKey=0tXbH6JvI1tTqh%2FIC4yGcvnQCWTTGWPvDTPz4qFSOQo7ICrF5dqRWBhFy5fscHKz%2FJmA67kl7lHX0%2FHYweDcYA%3D%3D&pageNo=1&numOfRows=1000&dataType=JSON&base_date=20240726&base_time=0500&nx=55&ny=127

/* var url="https://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst?serviceKey=0tXbH6JvI1tTqh%2FIC4yGcvnQCWTTGWPvDTPz4qFSOQo7ICrF5dqRWBhFy5fscHKz%2FJmA67kl7lHX0%2FHYweDcYA%3D%3D&pageNo=1&numOfRows=1000&dataType=JSON&base_date=20240726&base_time=0500&nx=55&ny=127";
$.ajax({
		url:url,
		success: function(data){
			console.log(data);
			console.log("온도:"+ data.response.body.items.item[3].obsrValue);
		
			var item =data.response.body.items.item[3];
			var content="";
			content+="날짜:"+item.baseDate+" 시간:"+item.baseTime
			+ " 온도:"+item.obsrValue;
		
			$(".result").text(content);
		}
});	 */
/* $.getJSON(url,function(data){
	console.log(data);
	console.log("온도:"+ data.response.body.items.item[3].obsrValue);
	
	var item =data.response.body.items.item[3];
	var content="";
	content+="날짜:"+item.baseDate+" 시간:"+item.baseTime
	+ " 온도:"+item.obsrValue;
	
	$(".result").text(content);
	
})	 */	

</script>

</head>
<body>
원하는 예보의 날짜입력
<form >
  <input type="datetime-local" id='weatherTime'/>
</form>
<button>날씨 얻어오기</button>

<div class="result"></div>

</body>
</html>