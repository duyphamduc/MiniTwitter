<%-- 
    Document   : footer
    Created on : Oct 13, 2018, 3:21:45 PM
    Author     : vinh1993
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.GregorianCalendar, java.util.Calendar" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%  
            GregorianCalendar currentDate = new GregorianCalendar();
            int currentYear = currentDate.get(Calendar.YEAR);
            int currentMonth = currentDate.get(Calendar.MONTH);
            int currentDay = currentDate.get(Calendar.DATE);
        %>

        <h1>&copy; Copyright <%= currentYear %>-<%= currentMonth %>-<%= currentDay %> </h1>
    </body>
</html>
