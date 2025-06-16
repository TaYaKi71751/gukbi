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
//현재 날씨
//https://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst?serviceKey=0tXbH6JvI1tTqh%2FIC4yGcvnQCWTTGWPvDTPz4qFSOQo7ICrF5dqRWBhFy5fscHKz%2FJmA67kl7lHX0%2FHYweDcYA%3D%3D&pageNo=1&numOfRows=1000&dataType=JSON&base_date=20240726&base_time=0600&nx=55&ny=127
var url="https://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst?serviceKey=0tXbH6JvI1tTqh%2FIC4yGcvnQCWTTGWPvDTPz4qFSOQo7ICrF5dqRWBhFy5fscHKz%2FJmA67kl7lHX0%2FHYweDcYA%3D%3D&pageNo=1&numOfRows=1000&dataType=JSON&base_date=20240726&base_time=0600&nx=55&ny=127";		
$.getJSON(url,function(data){
	console.log(data);
	console.log("온도:"+ data.response.body.items.item[3].obsrValue);
	
	var item =data.response.body.items.item[3];
	var content="";
	content+="날짜:"+item.baseDate+" 시간:"+item.baseTime
	+ " 온도:"+item.obsrValue;
	
	$(".result").text(content);
	
})		

</script>

</head>
<body>

<div class="result"></div>

</body>
</html>