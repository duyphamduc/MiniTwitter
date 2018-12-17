/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.Hashtag;
import dataaccess.HashtagDB;
import dataaccess.SearchDB;
import dataaccess.TweetHashtagDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Duy Pham
 */
@WebServlet(name = "SearchServlet", urlPatterns = {"/search"})
public class SearchServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String url = "/search.jsp";
        String errorMessage = "";
        
        if(action == null){
            action = "search";
        }
        
        if(action.equals("search")){
            viewSearchResults(request, response);
        }
        
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
    
    protected void viewSearchResults(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String searchKeyword = request.getParameter("search_keyword");
        session.setAttribute("searchKeyword", searchKeyword);
        List results = SearchDB.getSearchResults(searchKeyword);
        if(results != null){
            session.setAttribute("results", results);
        }
    }

}
