function validateForm(){
    var errorMsg=new Array();
    var errorDiv = document.getElementById("errorMessage");
    errorDiv.innerHTML = "";
    
    //Check matching password and strong password
    var checkPassword = function(){
        var password = document.getElementById("password");
        var confirmPassword = document.getElementById("confirm_password");
        var passwordContain = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])");
        
        //Password must contains [a-z][A-Z][0-9]
        if(!passwordContain.test(password.value)){
            password.style.backgroundColor = "#ffbaba";
            errorMsg.push("Password must contains at least one capital letter, one lowercase letter, and one number");
        }
        else{
            password.style.backgroundColor = "white";
        }
        
        //Confirm password must match 
        if (password.value !== confirmPassword.value){
            confirmPassword.style.backgroundColor = "#ffbaba";
            errorMsg.push("Confirm password does not match");
        }
        else{
            confirmPassword.style.backgroundColor = "white";
        }
       
    };
    
    //Check full name has two words or more
    var checkFullname = function(){
        var fullname = document.getElementById("fullname");
        var str = fullname.value;
        var str = str.trim();
        if (str.indexOf(' ') === -1) {
            fullname.style.backgroundColor = "#ffbaba";
            errorMsg.push("Fullname should contains at least two words.");
        }
        else{
            fullname.style.backgroundColor = "white";
        }
    };
    
    // Check all inputs if it has single quote and 1=1
    var sqlInjectionCheck = function(){
        var tagName = ['fullname', "username", "email", "password", "confirm_password", "birthdate", "answer"];
        var field;
        for(var i = 0; i < tagName.length; i++){
            field = document.getElementById(tagName[i]);
            var str = field.value;
            if ((str.indexOf('\'') !== -1) || (str.indexOf("1=1") !== -1)) {
                errorMsg.push(tagName[i] + " contains invalid characters. Please Try again");
                field.style.backgroundColor = "#ffbaba";
            }
            else{
                field.style.backgroundColor = "white";
            }
        }
    };
    
    sqlInjectionCheck();
    checkFullname();
    checkPassword();
    
    
    if(errorMsg.length !== 0){
        for(var i = 0;i <= errorMsg.length - 1; i++){
            errorDiv.innerHTML+="<li>"+errorMsg[i]+"</li>";
        }   
        return false;
    }else{
        return true;
    }
}

function securityQuestionValidation(){
    var questionList=  document.getElementById("securityQuestion");
    var questionNo = questionList.options[questionList.selectedIndex].value;
    var answer =  document.getElementById("answer");

    if(questionNo !== '0')
    {   
        answer.className = "";
    }
    else{
        answer.className = "notVisible";
        answer.value = "";
    }    
}
  