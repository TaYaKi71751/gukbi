<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Page Title</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="/ex/resources/css/template.css"/>
</head>
<body>

<div class="header">
  <h1>Board Website</h1>
  <p>A board website created by me.</p>
</div>

<div class="navbar">
    <c:forEach items="${category}" var="item">
        <a href="/ex/board/listAll?bGroupKind=${item}">${item}</a>
    </c:forEach>
    <a href="/ex/board/listAll" class="right">All Category</a>
</div>


<div class="row">
  <div class="side">
    <a href="/ex/board/listAll" class="right">All Category</a><br>
    <c:forEach items="${category}" var="item">
        <a href="/ex/board/listAll?bGroupKind=${item}">${item}</a><br>
    </c:forEach>
   
  </div>