/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;
import business.User;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDB {

    public static int insert(User user) throws IOException 
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query
                = "INSERT INTO user (fullname, username, emailAddress, birthdate, password, questionNo, answer) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try{
            String password = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getFullname());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getBirthdate());
            ps.setString(5, password);
            ps.setString(6, user.getQuestionNo());
            ps.setString(7, user.getAnswer());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    public static User searchEmail(String emailAddress) 
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM user WHERE emailAddress = ?";
        
        try{
            ps = connection.prepareStatement(query);
            ps.setString(1, emailAddress);
            rs = ps.executeQuery();
            User user = null;
            
            if(rs.next()){
                user = new User();
                user.setFullname(rs.getString("fullname"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("emailAddress"));
                user.setBirthdate(rs.getString("birthdate"));
                user.setPassword(rs.getString("password"));
                user.setQuestionNo(rs.getString("questionNo"));
                user.setAnswer(rs.getString("answer"));
            }
            return user;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static User searchUsername(String username) 
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM user WHERE username = ?";
        
        try{
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            User user = null;
            
            if(rs.next()){
                user = new User();
                user.setFullname(rs.getString("fullname"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("emailAddress"));
                user.setBirthdate(rs.getString("birthdate"));
                user.setPassword(rs.getString("password"));
                user.setQuestionNo(rs.getString("questionNo"));
                user.setAnswer(rs.getString("answer"));
            }
            return user;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
}
