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
                <h1>Sign Up</h1>
                <div class="formBox">
                    <form action="membership" method="post" onsubmit="return validateForm();">
                        <div class="errorMessage">
                            <ul id="errorMessage"></ul>
                        </div>
                        <span class="errorMessage">${errorMessage}</span>
                        <input type="hidden" name="action" value="signup">

                        <h2>Account</h2>
                        <input type="text" id="fullname" name="fullname" placeholder="Full Name" value="${user.fullname}" required>
                        <input type="text" id="username" name="username" placeholder="User Name" value="${user.username}" required><br>
                        <input type="email" id="email" name="email" placeholder="Email" value="${user.email}" required><br>
                        <input type="password" id="password" name="password" placeholder="Password" required>
                        <input type="password" id="confirm_password" name="confirm_password" placeholder="Confirm Password" required>

                        <h2>Date of Birth</h2>
                        <input type="date" id="birthdate" name="birthdate" value="${user.birthdate}" required>

                        <h2>Security Question</h2>
                        <select id="securityQuestion" name="securityQuestion" value="${user.questionNo}" onchange="securityQuestionValidation();">
                            <option value="0" selected>Choose one of the options below</option>
                            <option value="1" >What was your first pet?</option>
                            <option value="2">What was your first car?</option>
                            <option value="3">What was your first school?</option>
                        </select>
                        <input type="text" id="answer" name="answer" value="${user.answer}" class="notVisible" placeholder="Answer" required><br>

                        <input type="submit" value="Submit" class="subminbtn"><br>
                    </form>
                    <a href="/MyTwitter"><button type="button">Back</button></a>
                </div>
            </div>
        </div>
    </body>
    <footer>
        <%@ include file="parts/footer.jsp" %> 
    </footer>
</html>