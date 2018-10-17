<%-- 
    Document   : footer.jsp
    Created on : Sep 24, 2015, 6:47:16 PM
    Author     : xl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.GregorianCalendar, java.util.Calendar" %>
<!DOCTYPE html>
<script type="text/javascript" src="/MyTwitter/includes/main.js"></script>
<%  
    GregorianCalendar currentDate = new GregorianCalendar();
    int currentYear = currentDate.get(Calendar.YEAR);
%>
<hr>
<p>
    <a href="#">About</a> &nbsp;
    &copy; Copyright <%= currentYear %> Mini Twitter
</p>