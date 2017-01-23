<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="top.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HOME</title>
</head>
<body>
<img src="/resources/ddd.png" width="100%">
<!-- LOGIN FORM -->
  <div class="w3-display-middle w3-text-white w3-center">
    <h1 class="w3-jumbo">LOGIN</h1>
    <form>
    	<div class="form-group">
    		<div>ID</div>
    		<input type="text" name="id" style="text-align:center;">
    	</div>
    	<div class="form-group">
    		<div>PW</div>
    		<input type="password" name="pw" style="text-align:center;">
    	</div>
    	<button type="submit" class="btn btn-default">로그인</button>
    </form>

</body>
</html>