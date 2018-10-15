/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;
import java.io.Serializable;

/**
 *
 * @javabean for User Entity
 */
public class User implements Serializable {
    private String fullname;
    private String email;
    private String username;
    private String birthdate;
    private String password;
    private String questionNo;
    private String answer;
    
    public User()
    {
        fullname = "";
        email = "";
        username = "";
        birthdate = "";
        password = "";
        questionNo = "";
        answer = "";
    }
    public User(String fromString){
        String[] data = fromString.replace("[", "").split(",");
        this.setFullname(data[0]);
        this.setUsername(data[1]);
        this.setEmail(data[2]);
        this.setPassword(data[3]);
        this.setBirthdate(data[4]);
        this.setQuestionNo(data[5]);
        this.setAnswer(data[6]);
    }
    
    public User(String fullname, String username, String email, String password, String birthdate, String questionNo, String answer){
        this.fullname = fullname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.birthdate = birthdate;
        this.questionNo = questionNo;
        this.answer = answer;
    }
    
    @Override
    public String toString()
    {
      StringBuilder sb = new StringBuilder();
      sb.append(String.format("[%s,%s]", this.getFullname(), this.getEmail()));
      return sb.toString();
    }
    
    
    
    public String getFullname(){
        return this.fullname;
    }
    public void setFullname(String fullname){
        this.fullname = fullname;
    }
    
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getUsername(){
        return this.username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    
    public String getBirthdate(){
        return this.birthdate;
    }
    public void setBirthdate(String birthdate){
        this.birthdate = birthdate;
    }
    
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getQuestionNo(){
        return this.questionNo;
    }
    public void setQuestionNo(String questionNo){
        this.questionNo = questionNo;
    }
    
    public String getAnswer(){
        return this.answer;
    }
    public void setAnswer(String answer){
        this.answer = answer;
    }
    
}
