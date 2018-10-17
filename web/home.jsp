<%-- 
    Document   : home.jsp
    Created on : Sep 24, 2015, 6:47:02 PM
    Author     : xl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mini Twitter</title>
        <link rel="stylesheet" href="/styles/main.css">
    </head>
    <header>
        <%@ include file="parts/header.jsp" %>  
    </header>
    <body>
        <c:if test="${user == null}">
            <c:redirect url="/login.jsp"></c:redirect>
        </c:if>
        <h1>Hello, ${user.fullname}</h1>
        <a href="/MyTwitter/membership?action=logout">
            <button type="button">Logout</button>
        </a>
        
    </body>
</html>
