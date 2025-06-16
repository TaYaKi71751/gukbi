<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false" %>
<html>
<head>
    <title>Home</title>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script>
    
    function formatDate(dateString) {
        var formattedDate = new Date(dateString);
        var year = formattedDate.getFullYear();
        var month = (formattedDate.getMonth() + 1).toString().padStart(2, '0');
        var day = formattedDate.getDate().toString().padStart(2, '0');
        var hour = formattedDate.getHours().toString().padStart(2, '0');
        var minute = formattedDate.getMinutes().toString().padStart(2, '0');
        return year + '-' + month + '-' + day + ' ' + hour + ':' + minute;
    }
    
    
    $(document).ready(function() {
        var result = '${msg}';
        if (result == 'success') {
            alert("처리가 완료되었습니다.");
        }

        // 댓글 등록(테이블에 추가)
        $("#add").on("click", function() {
            var name = $("#newName").val();
            var age = $("#newAge").val();
            var height = $("#newHeight").val();
            var birthday = $("#newBirthday").val();

            $.ajax({
                type: 'post',
                url: '/ex/rest',
                headers: {
                    "Content-Type": "application/json"
                },
                dataType: 'text',
                data: JSON.stringify({
                    name: name,
                    age: age,
                    height: height,
                    birthday: birthday
                }),
                success: function(result) {
                    if (result == 'SUCCESS') {
                        alert("댓글이 등록됐습니다.");

                        var newRow = "<tr>" +
                            "<td><a href='/ex/selectName?name=" + name + "'>" + name + "</a></td>" +
                            "<td>" + age + "</td>" +
                            "<td>" + height + "</td>" +
                            "<td>" + formatDate(birthday) + "</td>" +
                            "</tr>";
                        $("#customers tbody").append(newRow);  //jquery 사용
                    }
                }
            });
        });

        // 댓글 수정(테이블에 수정되서 들어감)
        $("#modify").on("click", function() {
            var name = $("#newName").val();
            var age = $("#newAge").val();
            var height = $("#newHeight").val();
            var birthday = $("#newBirthday").val();

            $.ajax({
                type: 'put',
                url: '/ex/rest/' + name,
                headers: {
                    "Content-Type": "application/json"
                },
                data: JSON.stringify({
                    name: name,
                    age: age,
                    height: height,
                    birthday: birthday
                }),
                dataType: 'text',
                success: function(result) {
                    if (result == 'SUCCESS') {
                        alert("수정 되었습니다.");
                        
                        // 테이블에서 해당 행 찾아서 업데이트
                        var rowToUpdate = $("#customers tbody tr:contains('" + name + "')");
                        rowToUpdate.find("td:eq(1)").text(age);
                        rowToUpdate.find("td:eq(2)").text(height);
                        rowToUpdate.find("td:eq(3)").text(formatDate(birthday));
                    }
                }
            });
        });
    });
    //댓글 삭제
   $(document).ready(function() {
    // ... 다른 코드 ...

    // 댓글 삭제
    $("#remove").on("click", function(){
        var name = $("#newName").val();
        $.ajax({
            type:'delete',
            url:'/ex/rest/'+name,
            headers:{
                "Content-Type":"application/json"
            },
            dataType:'text',
            success:function(result){
                if(result=='SUCCESS'){
                    alert("삭제 되었습니다.");
                    
                    // 새로 고침 안하고 바로 삭제되게하기
                    var rowToRemove = $("#customers tbody tr:contains('" + name + "')");
                    rowToRemove.remove();
                }
            }
        });
    });
});
    </script>

    <style>
        #customers {
            font-family: Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #customers td, #customers th {
            border: 1px solid #ddd;
            padding: 8px;
        }

        #customers tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        #customers tr:hover {
            background-color: #ddd;
        }

        #customers th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: #04AA6D;
            color: white;
        }
    </style>
</head>
<body>
    select
    <table id='customers' width=100% border="1">
        <tr>
            <th style="width: 10px">name</th>
            <th style="width: 100px">age</th>
            <th style="width: 200px">height</th>
            <th style="width: 40px">birthday</th>
        </tr>
        <c:forEach items="${list}" var="dto">
            <tr>
                <td><a href="/ex/selectName?name=${dto.name}">${dto.name}</a></td>
                <td>${dto.age}</td>
                <td>${dto.height }</td>
                <td>
                    <fmt:parseDate value="${dto.birthday }" pattern="yyyy-MM-dd'T'HH:mm" var="now" type="both" />
                    <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${now}" />
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="/ex/insert">새글</a>

    <div>
        <div>이름: <input type="text" name="name" id="newName" /></div>
        <div>나이: <input type="text" name="age" id="newAge" /></div>
        <div>키: <input type="text" name="height" id="newHeight" /></div>
        <div>생일: <input type="datetime-local" name="birthday" id="newBirthday" /></div>

        <br>
        <button id="add">등록</button>
        <button type="button" id="modify">수정</button>
        <button type="button" id="remove">삭제</button>
    </div>
</body>
</html>
