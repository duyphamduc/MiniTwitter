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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "membershipServlet", urlPatterns = {"/membership"})
public class membershipServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String action = request.getParameter("action");
        String url = "/signup.jsp";
        HttpSession session = request.getSession();
        if(action.equals("login"))
        {
            String emailAddress = request.getParameter("emailAddress");
            String password = request.getParameter("password");
              
            User user1 = UserDB.selectUser(emailAddress);
            if(user1!=null)
            {   
                String tempPassword = user1.getPassword();
                if(password.equals(tempPassword))
                {
                    url="/home.jsp";
                }
                else
                {
                    url="/login.jsp";
                }
            }
            else
            {
                url="/login.jsp";
            }
            
        }
        else if(action.equals("signup")){
            //perform signup
            String fullname = request.getParameter("fullname");
            String username = request.getParameter("username");
            String emailAddress = request.getParameter("email");
            String password = request.getParameter("password");
            String confirm_password = request.getParameter("confirm_password");
            String birthdate = request.getParameter("birthdate");
            String questionNo = request.getParameter("securityQuestion");
            String answer = request.getParameter("answer");
            
            //check if email is exists
            if(UserDB.search(emailAddress) == true)
            {
                
                User user= new User(fullname, username, emailAddress, password, birthdate, questionNo, answer);

                session.setAttribute("user", user);
                url="/signup.jsp";
            }
            
            //check if password are equal
            else if(password.equals("confirm_password"))
            {
                url="/signup.jsp";
            }
            else if(fullname==null || username==null || emailAddress== null || password == null 
                    || confirm_password==null || birthdate==null || questionNo==null || answer==null)
            {
                url="/signup.jsp";
            }
            else
            {
                User user= new User(fullname, username, emailAddress, password, birthdate, questionNo, answer);

                request.setAttribute("User", user);
                UserDB.insert(user);
                url="/home.jsp";
            }   
            
            
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}
