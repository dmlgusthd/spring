<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="top.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>회원등록</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<h2>회원등록</h2>
<p>등록할 회원의 정보를 입력하세요.</p>
	<form action="InsertMember" Method="post">
		<div class="form-group">
			<label>이름:</label>
			<input name="mName" type="text" class="form-control" style=width:120px>
		</div>
		<div class="form-group">
			<label>전화번호:</label>
			<div>
				<input type="text" name="phone1" style=width:120px>- 
				<input type="text" name="phone2" style=width:120px>- 
				<input type="text" name="phone3" style=width:120px>
			</div>
		</div>
		<div class="form-group">
			<label>주소:</label>
			<input name="mAddress" type="text" class="form-control" style=width:500px>
		</div>
		<div class="form-group">
			<label>회비납부:</label>
			<select name="mSpecial" class="form-control" style=width:120px>
		    	<option>:::선택:::</option>
		        <option>O</option>
		        <option>X</option>
		    </select>
		</div>
		<input type="submit" value="등록">
		<input type="button" value="취소" onclick="location='/'">
	</form>
</div>

</body>
</html>
