/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;
import business.User;
import java.sql.*;
import java.util.ArrayList;
import business.User;

public class UserDB {
    public static int insert(User user)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
//        if(user.getFullname()!= null)
//        {
//            System.out.println("fullname: ");
//            System.out.println(user.getFullname());
//            return 5;
//        }

        String query
                = "INSERT INTO user(emailAddress, fullname, password, username, birthdate, questionNo, answer) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getFullname());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getUsername());
            ps.setString(5, user.getBirthdate());
            ps.setString(6, user.getQuestionNo());
            ps.setString(7, user.getAnswer());
            
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("catch exception");
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    public static boolean search(String emailAddress) 
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT emailAddress FROM User "
                + "WHERE emailAddress = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, emailAddress);
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static User selectUser(String email_or_username) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM user "
                + "WHERE emailAddress = ?";
        String query2 = "SELECT * FROM user "
                + "WHERE username = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email_or_username);
            rs = ps.executeQuery();
            User user = null;
            if (rs.next()) {
                user = new User();
                user.setFullname(rs.getString("fullname"));
                user.setEmail(rs.getString("emailAddress"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setQuestionNo(rs.getString("questionNo"));
                user.setBirthdate(rs.getString("birthdate"));
                user.setAnswer(rs.getString("answer"));
            }
            else{
                ps = connection.prepareStatement(query2);
                ps.setString(1, email_or_username);
                rs = ps.executeQuery();
                if (rs.next()) {
                    user = new User();
                    user.setFullname(rs.getString("fullname"));
                    user.setEmail(rs.getString("emailAddress"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setQuestionNo(rs.getString("questionNo"));
                    user.setBirthdate(rs.getString("birthdate"));
                    user.setAnswer(rs.getString("answer"));
                }
            }
            
            return user;
        }
        catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

    
    }
}
