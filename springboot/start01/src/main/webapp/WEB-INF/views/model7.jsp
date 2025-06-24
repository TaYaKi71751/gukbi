<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>JSTL Control</title>
</head>
<body>
<h1>JSTL Control</h1>


<h2>c:if</h2>
<!-- JSTL에서 조건 처리 -->
<c:choose>
    <c:when test="${str != null}">
        <p>메시지 : ${str}</p>
    </c:when>
    <c:otherwise>
        <p>메시지가 없습니다.</p>
    </c:otherwise>
</c:choose>


<p>str 값: ${str}</p>


<c:if test="${age >= 20}">
    <p>성인입니다.</p>
</c:if>
<c:if test="${age < 20}">
    <p>미성년자입니다.</p>
</c:if>


<hr>


<h2>c:choose</h2>
<!-- JSTL의 switch-case 구조 -->
<c:choose>
    <c:when test="${str == 'control1'}">
        <p>컨트롤1 입니다.</p>
    </c:when>
    <c:when test="${str == 'control2'}">
        <p>컨트롤2 입니다.</p>
    </c:when>
    <c:otherwise>
        <p>기타입니다.</p>
    </c:otherwise>
</c:choose>


<hr>


<h2>c:forEach</h2>
<table border="1">
    <thead>
    <tr>
        <th width="100">이름</th>
        <th width="50">나이</th>
        <th width="100">키</th>
        <th width="150">생일</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="human" items="${list}">
        <tr>
            <td>${human.name}</td>
            <td>${human.age}</td>
            <td>${human.height}</td>
             <td>
                                 <fmt:parseDate value="${human.birthday}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDate" />
                                    <fmt:formatDate value="${parsedDate}" pattern="yyyy-MM-dd HH:mm" />
                                </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<hr>


<h2>DTO 데이터 출력</h2>
<!-- JSTL에서 DTO 객체의 필드 출력 -->
<p>이름: ${dto.name}</p>
<p>나이: ${dto.age}</p>
<p>주소: ${dto.height}</p>
<p>주소: ${dto.birthday}</p>


<hr>


<table border="1">
    <thead>
    <tr>
        <th>순번 (index)</th>
        <th>반복 횟수 (count)</th>
        <th>이름</th>
        <th>나이</th>
        <th>키</th>
        <th>생일</th>
        <th>첫 번째 항목 여부</th>
        <th>마지막 항목 여부</th>
        <th>홀수 여부</th>
        <th>짝수 여부</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="human" items="${list}" varStatus="stat">
        <tr>
            <td>${stat.index}</td> <!-- 목록의 순번 (0부터 시작) -->
            <td>${stat.count}</td> <!-- 반복 횟수 (1부터 시작) -->
            <td>${human.name}</td> <!-- 이름 -->
            <td>${human.age}</td> <!-- 나이 -->
            <td>${human.height}</td> <!-- 키 -->
            <td>      <fmt:parseDate value="${human.birthday}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDate" />
                                                    <fmt:formatDate value="${parsedDate}" pattern="yyyy-MM-dd HH:mm" /></td> <!-- 생일 -->
            <td><c:if test="${stat.first}">첫 번째 항목</c:if></td> <!-- 첫 번째 항목 여부 -->
            <td><c:if test="${stat.last}">마지막 항목</c:if></td> <!-- 마지막 항목 여부 -->
            <td><c:if test="${stat.index % 2 == 0}">짝수 번째</c:if></td> <!-- 짝수 여부 -->
            <td><c:if test="${stat.index % 2 != 0}">홀수 번째</c:if></td> <!-- 홀수 여부 -->
        </tr>
    </c:forEach>
    </tbody>
</table>


<hr>
<!-- JSTL에서 링크 생성 -->
<a href="${pageContext.request.contextPath}/sendData">데이터전송 ></a>
<a href="${pageContext.request.contextPath}/a_send?num1=10&num2=20">전송</a>


<p>/a_send?num1=10&num2=20</p>


</body>
</html>
