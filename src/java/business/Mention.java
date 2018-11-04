/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

public class Mention {
    String mentionID;
    String tweetID;
    String userID;
    
    public Mention()
    {
        mentionID = "";
        tweetID = "";
        userID = "";
    }
    
    public Mention(String mentionID, String tweetID, String userID)
    {
        this.mentionID = mentionID;
        this.tweetID = tweetID;
        this.userID = userID;
    }
    
    public Mention(String tweetID, String userID)
    {
        this.tweetID = tweetID;
        this.userID = userID;
    }
    
    public void setMentionID(String mentionID)
    {
        this.mentionID = mentionID;
    }
    public void setTweetID(String tweetID)
    {
        this.tweetID = tweetID;
    }
    public void setUserID(String userID)
    {
        this.userID = userID;
    }
    
    public String getMentionID()
    {
        return this.mentionID;
    }
    
    public String getTweetID()
    {
        return this.tweetID;
    }
    
    public String getUserID()
    {
        return this.userID;
    }
}
