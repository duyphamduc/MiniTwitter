<%-- 
    Document   : home.jsp
    Created on : Sep 24, 2015, 6:47:02 PM
    Author     : xl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/header.jsp" %>
<%@ include file="/footer.jsp" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mini Twitter</title>
        <link rel="stylesheet" href="/styles/main.css">
    </head>
    <a href="/MyTwitter"><button type="button">Log Out</button></a>
    <body>
        <h1>HOME PAGE</h1>
     
       
        <p> <%= request.getParameter("username") %></p>
        <p> <%= request.getParameter("email") %></p>
        <p> <%= request.getParameter("password") %></p>
        

    </body>
</html>


