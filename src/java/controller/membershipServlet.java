/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.User;
import dataaccess.UserDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "membershipServlet", urlPatterns = {"/membership"})
public class membershipServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "checkuser";  // default action
        }

        // perform action and set URL to appropriate page
        String url = "/login.jsp";
        if (action.equals("checkuser")) {
            if(checkUser(request, response)){
                url = "/home.jsp";
            }else{
                url = "/login.jsp";
            }
        }
        else if(action.equals("logout")){
            userLogout(request, response);
            url = "/login.jsp";
        }
        
        // forward to the view
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String action = request.getParameter("action");
        String url = "/login.jsp";
        String errorMessage = "";
        
        if(action.equals("login"))
        {
            url = "/login.jsp";
            int errorCode = userLogin(request, response);
            if(errorCode != 0){
                errorMessage = "Username/Email or password does not match with our record. Please try again.";
            }else{
                errorMessage = "";
                url = "/home.jsp";
            }
        }
        else if(action.equals("signup")){
            url = "/signup.jsp";
            int errorCode = userSignup(request, response);
            switch(errorCode){
                case 0:
                    url = "/home.jsp";
                    errorMessage = "";
                    break;
                case 201:
                    errorMessage = "Error " + errorCode + ": One of the fields are empty";
                    break;
                case 202:
                    errorMessage = "Error " + errorCode + ": Confirm password mismatch";
                    break;
                case 203:
                    errorMessage = "Error " + errorCode + ": Username already exist";
                    break;
                case 204:
                    errorMessage = "Error " + errorCode + ": Email already exist";
                    break;
                case 205:
                    errorMessage = "Error " + errorCode + ": Request cannot be complete. Please try again later.";
                    break;
                default:
                    url = "/signup.jsp";
                    errorMessage = "";
                    break;
            }
        }
        request.setAttribute("errorMessage", errorMessage);
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
    
    
    
    /*
    method userLogin:
    param: HttpServletRequest request, HttpServletResponse response
    return: errorCode
        - errorCode 0: login success
        - errorCode 101: wrong Password
        - errorCode 102: email not found
        - errorCode 103: username not found
    
    */
    protected int userLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String loginID = request.getParameter("loginID");
        String password = request.getParameter("password");
        String[] remember = request.getParameterValues("remember");
        HttpSession session = request.getSession();
        
        if(loginID.indexOf('@') != -1){ //login ID is an email address
            User user = UserDB.searchEmail(loginID);
            if(user != null){ //user exist
                if(password.equals(user.getPassword())){
                    session.setAttribute("user", user);
                    setCookie(request, response, user);
                    return 0; //login success
                }else{
                    return 101; // wrong password
                }
            }else{ //user not found
                return 102; // email not found
            }
        }else{ // login ID is an username
            User user = UserDB.searchUsername(loginID);
            if(user != null){ //user exist
                if(password.equals(user.getPassword())){
                    session.setAttribute("user", user);
                    setCookie(request, response, user);
                    return 0; //login success
                }else{
                    return 101; // wrong password
                }
            }else{ //user not found
                return 103; // username not found
            }
        }     
    }
    
    protected void userLogout(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        deleteCookies(request, response);
        session.removeAttribute("user");
    }
    
    /*
    method userSignup:
    param: HttpServletRequest request, HttpServletResponse response
    return: errorCode
        - errorCode 0: signup success
        - errorCode 201: one of the field is empty
        - errorCode 202: confirm password mismatch
        - errorCode 203: username already exist
        - errorCode 204: email already exist
        - errorCode 205: SQL query error
    
    */
    protected int userSignup(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String fullname = request.getParameter("fullname");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String birthdate = request.getParameter("birthdate");
        String password = request.getParameter("password");
        String confirm_password = request.getParameter("confirm_password");
        String questionNo = request.getParameter("securityQuestion");
        String answer = request.getParameter("answer");
        
        System.out.println(fullname);
        System.out.println(username);
        System.out.println(email);
        System.out.println(birthdate);
        System.out.println(password);
        System.out.println(confirm_password);
        System.out.println(questionNo);
        System.out.println(answer);
        
        User user= new User(fullname, username, email, password, birthdate, questionNo, answer);
        session.setAttribute("user", user);
        
        if(fullname == null || username == null || email == null || birthdate == null || password == null || confirm_password == null || answer == null
                || fullname.isEmpty() || username.isEmpty() || email.isEmpty() || birthdate.isEmpty() || password.isEmpty() || confirm_password.isEmpty() || answer.isEmpty()){
            return 201; // one of the field is empty
        }else if(!password.equals(confirm_password)){
            return 202; // confirm password mismatch
        }else{
            if(UserDB.searchUsername(username) != null){
                return 203; //username already exist
            }else if(UserDB.searchUsername(email) != null){
                return 204; // email already exist
            }else{
                int isInserted = UserDB.insert(user);
                System.out.println("SQL: " + isInserted);
                if(isInserted == 0){
                    return 205; // SQL query error
                }else{
                    setCookie(request, response, user);
                    return 0; // signup success
                }
            }
        }
    }
    
     /*
    method userSignup:
    param: HttpServletRequest request, HttpServletResponse response
    return: boolean
        - true: user exist in this session
        - false: user doesn't exist in this session
    */
    private boolean checkUser(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        User user = (User) request.getAttribute("user");

        // if User object doesn't exist, check loginID cookie
        if (user == null) {
            Cookie[] cookies = request.getCookies();
            String loginID = CookieUtil.getCookieValue(cookies, "miniTwitterLoginID");

            // if cookie doesn't exist
            if (loginID == null || loginID.equals("")) {
                return false;
            } 
            // if cookie exists, create User object
            else {
                user = UserDB.searchUsername(loginID);
                session.setAttribute("user", user);
                return true;
            }
        } 
        // if User object exists, go to Downloads page
        else {
            return true;
        }
    }

    private void setCookie(HttpServletRequest request, HttpServletResponse response, User user) {

        // add a cookie that stores the user's loginID to browser
        Cookie loginIDCookie = new Cookie("miniTwitterLoginID", user.getUsername());
        loginIDCookie.setMaxAge(60 * 60 * 24 * 30); // set age to 1 month
        loginIDCookie.setPath("/");                 // allow entire app to access it
        response.addCookie(loginIDCookie);
   }
    
    private void deleteCookies(HttpServletRequest request,
            HttpServletResponse response) {

        Cookie[] cookies = request.getCookies();
        
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("miniTwitterLoginID")) {
                cookie.setMaxAge(0); //delete the cookie
                cookie.setPath("/"); //allow the download application to access it
                response.addCookie(cookie);
            }
        }
    }
}
