<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="top.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>대여 등록</title>
</head>
<body>
<div class="container">
	<h2>대여 등록</h2>
	<form action="InsertRental" method="post">
		<div class="form-group">
			<label>도서명:</label>
			<input type="text" name="bmName" class="form-control" style=width:250px>
		</div>
		<div class="form-group">
			<label>대여자:</label>
			<select name="mName" class="form-control" style=width:120px>
			<c:forEach var="member" items="${name}">
				<option>${member.mName}</option>
			</c:forEach>
			</select>
		</div>
		<div class="form-group">
			<label>대여 시작:</label>
			<input type="date" name="brStart" class="form-control" style=width:150px>
		</div>
		<div class="form-group">
			<label>대여 종료:</label>
			<input type="date" name="brEnd" class="form-control" style=width:150px>
		</div>
		<div class="form-group">
			<label>선입금:</label>
			<input type="text" name="brPay" class="form-control" style=width:150px value=0>
		</div>
		<input type="submit" value="등록">
		<input type="button" value="취소" onclick="location='/'">
	</form>
</div>
</body>
</html>