package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import business.User;
import business.Tweet;
import dataaccess.TweetDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public class TweetServlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String url = "/home.jsp";
        
        if(action == null){
            action = "viewTweet";
        }
        
        if(action.equals("viewTweet")){
            viewTweet(request, response);
        }
        
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
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
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String url = "/home.jsp";
        
        if(action == null){
            action = "viewTweet";
        }
        
        if(action.equals("viewTweet")){
            viewTweet(request, response);
        }
        
        else if(action.equals("postTweet")){
            postTweet(request, response);
            viewTweet(request, response);
        }
        else if(action.equals("deleteTweet")){
            deleteTweet(request, response);
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);

    }
    
    protected void viewTweet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        
        List tweets = TweetDB.viewTweet(user.getUserID());
        if(tweets != null){
            request.setAttribute("tweets", tweets);
        }
    }
    
    protected void postTweet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String tweet = request.getParameter("tweet");
        User user = (User) session.getAttribute("user");
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();
        String time= (String) dtf.format(now);
        
        Tweet twit = new Tweet(user.getUserID(), tweet, time);
        TweetDB.insert(twit);
    
    }
    protected void deleteTweet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
