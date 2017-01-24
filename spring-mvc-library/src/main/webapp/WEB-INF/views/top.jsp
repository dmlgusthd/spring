<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class="w3-top">
<ul class="w3-navbar w3-black w3-card-2 w3-left-align">
	<li class="w3-hide-medium w3-hide-large w3-opennav w3-right">
		<a class="w3-padding-large" href="javascript:void(0)" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
	</li>
	<li><a href="/" class="w3-hover-none w3-hover-text-grey w3-padding-large">HOME</a></li>
	<li class="w3-hide-small w3-dropdown-hover">
		<a href="javascript:void(0)" class="w3-hover-none w3-padding-large">회원관리 <i class="fa fa-caret-down"></i></a>     
		<div class="w3-dropdown-content w3-white w3-card-4">
			<a href="InsertMember">회원등록</a>
			<a href="MemberList">회원목록</a>
		</div>
	</li>
	<li class="w3-hide-small w3-dropdown-hover">
		<a href="javascript:void(0)" class="w3-hover-none w3-padding-large">도서관리 <i class="fa fa-caret-down"></i></a>     
		<div class="w3-dropdown-content w3-white w3-card-4">
			<a href="InsertRental">도서등록</a>
			<a href="BookList">도서목록</a>
		</div>
	</li>
</ul>
</div><br><br>
</body>
</html>
