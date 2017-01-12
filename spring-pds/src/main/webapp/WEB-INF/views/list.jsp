<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title></title>
</head>
<body>
    <div>��ü���� �� : ${totalRowCount}/${list.size()}</div>
    <table border="1">
        <thead>
            <tr>
                <th>File Title</th>
                <th>File Auth</th>
                <th>File Name</th>
                <th>File Path</th>
                <th>File Extention</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="f" items="${list}">
                <tr>
                    <td><a href="<%=request.getContextPath()%>/view?fileName=${f.fileName}">${f.title}</a></td>
                    <td>${f.auth}</td>
                    <td>${f.fileName}</td>
                    <td>${f.filePath}</td>
                    <td>${f.extention}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
 
    <div>
        <a href="<%=request.getContextPath()%>/add">�����߰�</a>
    </div>
    <div>
        <c:if test="${currentPage>1}">
            <a href="<c:url value='/list?currentPage=${currentPage-1}'/>">����</a>
        </c:if>
        <c:if test="${currentPage < lastPage}"> 
            <a href="<c:url value='/list?currentPage=${currentPage+1}'/>">����</a>
        </c:if>
 
    </div>
</body>
</html>