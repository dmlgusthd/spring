<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="top.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>도서 목록</title>
</head>
<body>
<div class="container" align=center>
	<h2>도서 목록</h2>           
	<table class="table table-hover">
		<thead align=center>
			<tr>
				<td width="100px"><label>번호</label></td>
				<td><label>제목</label></td>
				<td width="200px"><label>대여상태</label></td>
			</tr>
		</thead>
		<tbody align=center>
		<c:forEach var="b" items="${list}">
			<tr>
				<td><label>${b.bmSn}</label></td>
				<td>${b.bmName}</td>
				<td><label>${b.bmCheck}</label></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div>
        <c:if test="${currentPage>1}">
        	<input type="button" value="이전" onclick="location='/BookList?currentPage=${currentPage-1}'">
        </c:if>
        <c:if test="${currentPage < lastPage}"> 
            <input type="button" value="다음" onclick="location='/BookList?currentPage=${currentPage+1}'">
        </c:if>
 
    </div>
</div>
</body>
</html>