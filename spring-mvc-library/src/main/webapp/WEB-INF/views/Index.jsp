<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>HOME</title>
</head>
<body>
<img src="/resources/ddd.png" width="100%">
<c:choose>
    <c:when test="${not empty sessionScope.manager}">
	<%@ include file="top.jsp" %>
        <div class="w3-display-middle w3-text-white w3-center">
        <h1>어서오세요.</h1>
        <button onclick="location='logout'">로그아웃</button>
        </div>
    </c:when>
    <c:otherwise>
        <!-- LOGIN FORM -->
		<div class="w3-display-middle w3-text-white w3-center">
		<h1 class="w3-jumbo">LOGIN</h1>
	    <form action="loginProcess" method="post">
	    	<div class="form-group">
	    		<div>ID</div>
	    		<input type="text" name="id" style="text-align:center;">
	    	</div>
	    	<div class="form-group">
	    		<div>PW</div>
	    		<input type="password" name="pw" style="text-align:center;">
	    	</div>
                <input type="submit" value="로그인" align="middle"><br>
           	<div>
           		<input type="button" value="도서목록" onclick="location='BookList'">
           	</div>
        </form>
        </div>
    </c:otherwise>
</c:choose>
</body>
</html>