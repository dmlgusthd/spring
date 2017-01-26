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
<title>회원 목록</title>
</head>
<body>
<div class="container" align=center>
	<h2>회원 목록</h2>           
	<table class="table table-hover">
		<thead align=center>
			<tr>
				<td width="100px"><label>번호</label></td>
				<td width="100px"><label>이름</label></td>
				<td><label>주소</label></td>
				<td width="200px"><label>전화번호</label></td>
				<td width="100px"><label>회비납부</label></td>
			</tr>
		</thead>
		<tbody align=center>
		<c:forEach var="m" items="${list}">
			<tr>
				<td>${m.mNo}</td>
				<td>${m.mName}</td>
				<td>${m.mAddress}</td>
				<td>${m.mPhone}</td>
				<td>${m.mSpecial}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<div>
        <c:if test="${currentPage>1}">
        	<input type="button" value="이전" onclick="location='/MemberList?currentPage=${currentPage-1}'">
        </c:if>
        <c:if test="${currentPage < lastPage}"> 
            <input type="button" value="다음" onclick="location='/MemberList?currentPage=${currentPage+1}'">
        </c:if>
 
    </div>
	
</div>
</body>
</html>