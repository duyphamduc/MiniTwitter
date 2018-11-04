/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.Mention;
import business.Tweet;
import business.User;
import dataaccess.MentionDB;
import dataaccess.UserDB;

/**
 *
 * @author Duy Pham
 */
public class TweetUtil {
    
    public static String highlightMention(String twit){
        String newTwit = twit;
        int startInd = 0;
        while(twit.indexOf("@", startInd) != -1){
            int indexOf = twit.indexOf("@", startInd);
            int indexOfSpace = twit.indexOf(" ", indexOf + 1);
            if(indexOfSpace == -1){
                indexOfSpace = twit.length();
            }
            String mention = twit.substring(indexOf, indexOfSpace);
            newTwit = newTwit.replace(mention, "<a class='mention'>" + mention + "</a>");
            startInd = indexOf+1;
        }
        return newTwit;
    }
    
    public static void linkUserToMention(Tweet tweet)
    {
        int startInd = 0;
        String twit = tweet.getTwit();
        while(twit.indexOf("@", startInd) != -1){
            int indexOf = twit.indexOf("@", startInd);
            int indexOfEnd = twit.indexOf("<", indexOf + 1);
            if(indexOfEnd == -1){
                indexOfEnd = twit.length();
            }
            String mentionUser = twit.substring(indexOf+1, indexOfEnd);
            //Find user that is mentioned
            User user = UserDB.searchUsername(mentionUser);
            if(user != null){
                Mention mention = new Mention();
                mention.setTweetID(tweet.getTweetID());
                mention.setUserID(user.getUserID());
                MentionDB.insert(mention);
            }
            startInd = indexOf+4;
        }
    }
}
