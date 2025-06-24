<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>Test Page</title>
</head>
<body>
<h1> c:if </h1>
<c:if test="${age>=20}">
    <p>성인입니다</p>
</c:if>
<c:if test="${age<20}">
    <p>미성년자입니다.</p>
</c:if>
<h1> c:choose</h1>
<c:choose>
    <c:when test="${name == 'admin'}">
        <p>관리자</p>
    </c:when>
    <c:when test="${name == null}">
        <p>이름 미입력</p>
    </c:when>
    <c:otherwise>
        <p>일반유저</p>
    </c:otherwise>
</c:choose>

<h1> c:forEach </h1>
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

<a href="${pageContext.request.contextPath}/04model?name=John&age=25&height=175.5&birthday=2023-09-11T15:30">전송</a>
</body>
</html>
