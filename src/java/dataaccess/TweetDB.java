/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import business.Tweet;
import business.User;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author duypham
 */
public class TweetDB {
    public static int insert(Tweet tweet) throws IOException 
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query
                = "INSERT INTO tweet (userID, twit, time) "
                + "VALUES (?, ?, ?)";
        
        try{
            ps = connection.prepareStatement(query);
            ps.setString(1, tweet.getTweetUserID());
            ps.setString(2, tweet.getTwit());
            ps.setString(3, tweet.getTime());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static List viewTweet(String userID) throws IOException 
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query
                = "SELECT tweetID, tweetUserID, MAX(tweetMentionID) as tweetMentionID, twit, time, username, fullname "
                + "FROM view_tweet "
                + "WHERE tweetUserID = ? or tweetMentionID = ?  "
                + "GROUP BY tweetID "
                + "ORDER BY time DESC;";
        
        List tweets = new LinkedList();
        try{
            ps = connection.prepareStatement(query);
            ps.setString(1, userID);
            ps.setString(2, userID);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Tweet tweet = new Tweet();
                tweet.setTweetID(rs.getString("tweetID"));
                tweet.setTweetUserID(rs.getString("tweetUserID"));
                tweet.setTweetMentionID(rs.getString("tweetMentionID"));
                tweet.setTwit(rs.getString("twit"));
                tweet.setTime(rs.getString("time"));
                tweet.setUsername(rs.getString("username"));
                tweet.setFullname(rs.getString("fullname"));
                
                tweets.add(tweet);
            }
            return tweets;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
}
