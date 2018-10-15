
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Mini Twitter</title>
    </head>
    <header>
        <%@ include file="parts/header.jsp" %>  
    </header>
    <body>
        <c:if test="${user != null}">
            <c:redirect url="/home.jsp"></c:redirect>
        </c:if>
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
                        <span class="errorMessage">${errorMessage}</span><br>
                        <input type="text" id="loginID" name="loginID" placeholder="Email or username" required><br>
                        <input type="password" id="password" name="password" placeholder="Password" required><br>
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
