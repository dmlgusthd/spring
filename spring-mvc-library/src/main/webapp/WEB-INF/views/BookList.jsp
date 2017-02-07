<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<c:choose>
    <c:when test="${not empty sessionScope.manager}">
	<%@ include file="top.jsp" %>
	<div class="container">
		<h2 align=center>도서 목록</h2>           
		<input type ="button" value="등록하기" onclick="location='InsertBook'">
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
					<td><a href="BookInfo?bmName=${b.bmName}">${b.bmName}</a></td>
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
	</c:when>
	<c:otherwise>
		<div class="container">
			<h2 align=center>도서 목록</h2>           
			<input type ="button" value="홈으로" onclick="location='/'">
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
						<td><label>${b.bmName}</label></td>
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
	</c:otherwise>
</c:choose>

</body>
</html>