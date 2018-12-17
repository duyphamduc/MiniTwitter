/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import business.Notification;
import business.Search;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Duy Pham
 */
public class SearchDB {
    public static List<Notification> getSearchResults(String keyword)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        keyword = "%" + keyword + "%";
        
        String query = "SELECT s.* from (select @keyword:=? p) parm, search s;";
        
        List results = new LinkedList();
        try{
            ps = connection.prepareStatement(query);
            ps.setString(1, keyword);
            rs = ps.executeQuery();
            Search result = null;
            
            while(rs.next()){
                result = new Search();
                result.setTablename(rs.getString("table_name"));
                if((rs.getString("table_name")).equals("usr")){
                    result.setUsername(rs.getString("username"));
                    result.setFullname(rs.getString("fullname"));
                    result.setProfileURL(rs.getString("profileURL"));
                }else if((rs.getString("table_name")).equals("tweet")){
                    result.setUsername(rs.getString("username"));
                    result.setFullname(rs.getString("fullname"));
                    result.setProfileURL(rs.getString("profileURL"));
                    result.setTwit(rs.getString("twit"));
                }else{
                    result.setHashtagText(rs.getString("hashtagText"));
                }
                results.add(result);
            }
            return results;
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
