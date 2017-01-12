<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>FILE MODIFY FORM</title>
</head>
<body>
<h1>FILE MODIFY</h1>    
    <form action="<c:url value='/modify'/>" method="post">
        <div>FILE TITLE : </div>
        <div><input name="title" value="${fileboard.title}" type="text"/></div>
        <div>FILE AUTH : </div>
        <div><input name="auth" value="${fileboard.auth}" id="auth" type="text"/></div>
        <div>FILE NAME : </div>
        <div><input name="fileName" value="${fileboard.fileName}" id="fileName" type="text" readonly/></div>
        <div>FILE PATH : </div>
        <div><input type="text" value='${fileboard.filePath}' name="filePath" id="filePath" readonly></div>
        <div>FILE EXTENTION : </div>
        <div><input type="text" value='${fileboard.extention}' name="extention" id="extention" readonly></div>
        <div>
            <input type="submit" value="글수정"/>
            <input type="reset" value="초기화"/>
        </div>
    </form>
</body>
</html>