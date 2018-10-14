package business;

import java.io.Serializable;

public class User implements Serializable {

    private String fullname;
    private String username;
    private String emailAddress;
    private String password;
    private String birthdate;  
    private String questionNo;
    private String answer;
    

    public User() {
        fullname = "";
        username = "";
        emailAddress = "";
        password = "";
        birthdate = "";
        questionNo = "";
        answer = "";
    }

    public User(String fullname, String username, String emailAddress, String password, 
            String birthdate, String questionNo, String answer) {
        this.fullname = fullname;
        this.username = username;
        this.emailAddress = emailAddress;
        this.password = password;
        this.birthdate = birthdate;
        this.questionNo = questionNo;
        this.answer = answer;
        
    }

    public String getEmail() {
        return emailAddress;
    }

    public void setEmail(String email) {
        this.emailAddress = email;
    }
    
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
     
    public String getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(String questionNo) {
        this.questionNo = questionNo;
    }
    
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}