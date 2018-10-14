<%-- 
    Document   : login.jsp
    Created on : Sep 24, 2015, 6:44:58 PM
    Author     : xl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/header.jsp" %>
<%@ include file="/footer.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Mini Twitter</title>
    </head>
    <header>
        <%@ include file="parts/header.jsp" %>  
    </header>
    <body>
        <div class="container">
            <div class="left">
                <div class="companyName"><h1>Mini Twitter</h1></div>
            </div>
            <div class="right">
                <a href="/MyTwitter"><img src="/MyTwitter/img/ostrich.svg" class="logo"></a>
                <h1>Login</h1>
                <div class="formBox">
                    <form action="membership" method="post" onsubmit="">
                        <input type="hidden" name="action" value="login">
                        <input type="text" name="emailAddress" placeholder="Email or Username" required><br>
                        <input type="password" name="password" placeholder="Password" required><br>
                        <a href="/MyTwitter/forgotpassword.jsp">Forgot password</a>
                        <input type="checkbox" name="remember" value="rememberMe">Remember me<br>
                        <input type="submit" value="Login"><br>
                    </form>
                </div>
                <div class="divider_line"><img src="/MyTwitter/img/divider_line.svg"></div>
                <div class="signup">
                    <h1>Join Mini Twitter today.</h1>
                    <a href="/MyTwitter/signup.jsp">
                        <button type="button">Sign Up</button>
                    </a>
                </div>
            </div>
        </div>
    </body>
    <footer>
        <%@ include file="parts/footer.jsp" %> 
    </footer>
</html>
