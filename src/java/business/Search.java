/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author Duy Pham
 */
public class Search {
    String tablename;
    String username;
    String fullname;
    String profileURL;
    String twit;
    String hashtagText;
    
    public Search()
    {
        tablename = "";
        username = "";
        fullname = "";
        profileURL = "";
        twit = "";
        hashtagText = "";
    }
    
    public void setTablename(String tablename){
        this.tablename = tablename;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setFullname(String fullname){
        this.fullname = fullname;
    }
    public void setProfileURL(String profileURL){
        this.profileURL = profileURL;
    }
    public void setTwit(String twit){
        this.twit = twit;
    }
    public void setHashtagText(String hashtagText){
        this.hashtagText = hashtagText;
    }
    
    public String getTablename(){
        return this.tablename;
    }
    public String getUsername(){
        return this.username;
    }
    public String getFullname(){
        return this.fullname;
    }
    public String getProfileURL(){
        return this.profileURL;
    }
    public String getTwit(){
        return this.twit;
    }
    public String getHashtagText(){
        return this.hashtagText;
    }
}
