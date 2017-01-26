<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="top.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>대여 정보</title>
</head>
<body>
<div class="container">
	<h2>대여 정보</h2>
	<form action="RentInfo" method="post">
		<div class="form-group">
			<label>도서명:</label>
			<input type="text" name="bmName" class="form-control" style=width:250px value='${library.bmName}' readonly>
		</div>
		<div class="form-group">
			<label>대여자:</label>
			<input type="text" name="mName" class="form-control" style=width:150px value='${library.mName}' readonly>
		</div>
		<div class="form-group">
			<label>대여 시작:</label>
			<input type="text" name="brStart" class="form-control" style=width:150px value='${library.brStart}' readonly>
		</div>
		<div class="form-group">
			<label>대여 종료:</label>
			<input type="text" name="brEnd" class="form-control" style=width:150px value='${library.brEnd}' readonly>
		</div>
		<div class="form-group">
			<label>선입금:</label>
			<input type="text" name="brPay" class="form-control" style=width:150px value='${library.brPay}' readonly>
		</div>
		<div class="form-group">
			<label>결제금:</label>
			<input type="text" class="form-control" style=width:150px value='' readonly>
		</div>
		<input type="submit" value="반납">
		<input type="button" value="목록" onclick="location='RentList'">
	</form>
</div>
</body>
</html>