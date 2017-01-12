<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>filedView</title>
</head>
<body>
<h1>FILE VIEW</h1>
	<div>File Title :</div>
    <div>${fileboard.title}</div>
    <div>File Auth :</div>
    <div>${fileboard.auth}</div>
    <div>File Name :</div>
    <div>${fileboard.fileName}</div>
    <div>File Path :</div>
    <div>${fileboard.filePath}</div>
    <div>File Extention :</div>
    <div>${fileboard.extention}</div>
    <div>
        <a name="fileName" href="<c:url value='/modify?fileName=${fileboard.fileName}'/>">수정</a>
        <a href="<c:url value='/remove?fileName=${fileboard.fileName}'/>">삭제</a>
    </div>
</body>
</html>