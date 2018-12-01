<%-- 
    Document   : home.jsp
    Created on : Sep 24, 2015, 6:47:02 PM
    Author     : xl
--%>

<%@ include file="parts/main_header.jsp" %>  
<body>
    <c:if test="${user == null}">
        <c:redirect url="/login.jsp"></c:redirect>
    </c:if>
    <section class="hero is-medium has-bg-img">
        <div class="hero-body"></div>
    </section>
    <div class="modal">
        <div class="modal-background"></div>
        <div class="modal-card">
            <header class="modal-card-head">
              <p class="modal-card-title">Upload Image</p>
              <button class="delete" aria-label="close"></button>
            </header>
            <form method="post" action="uploadFile" enctype="multipart/form-data">
                <section class="modal-card-body">
                    <input type="file" name="profile_file" />
                    <% session.setAttribute("uploadType", "profile"); %>
                </section>
                <footer class="modal-card-foot">
                    <input class="button is-success" type="submit" value="Upload" />
                </footer>
            </form>
        </div>
    </div>
    <div class="columns is-desktop">
        <div class="column">
            <div class="box is-paddingless">
                <div class="card">
                    <%@ include file="parts/user_profile.jsp" %>  
                </div>
            </div>
            <aside class="menu">
                <p class="menu-label">
                  Profile
                </p>
                <ul class="menu-list">
                    <li><a onclick="profileUpdate('profile');">Update profile</a></li>
                    <li><a onclick="profileUpdate('password');">Change Password</a></li>
                    <li><a id="change-cover">
                            <span>Change profile photo</span>
                        </a>
                    </li>
                </ul>
            </aside>
        </div>
                            
        <div class="column is-half">
            <div class="notification is-info 
                 <c:if test="${empty notification}">
                     is-hidden
                 </c:if>">
                
                <button class="delete"></button>
                ${notification}
            </div>
            
            <form action="membership" method="post" id="updateProfile"
                  <c:choose>
                        <c:when test="${formActive == 'changePassword'}">
                            class="is-hidden"
                        </c:when>
                        <c:otherwise>
                            class=""
                        </c:otherwise>
                    </c:choose>>
                <h4 class="title is-4">Update Profile</h4>
                <input type="hidden" name="action" value="updateProfile">
                <div class="box">
                    <div class="field">
                        <label class="label">Userame</label>
                        <div class="control">
                            <input class="input" type="text" value="${user.username}" readonly>
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Email</label>
                        <div class="control">
                            <input class="input" type="text" value="${user.email}" readonly>
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Full Name</label>
                        <div class="control">
                            <input class="input" type="text" name="fullname" value="${user.fullname}">
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Date of birth</label>
                        <div class="control">
                            <input class="input" type="date" id="birthdate" name="birthdate" value="${user.birthdate}">
                        </div>
                    </div>
                    <div class="field has-addons">
                        <div class="control is-expanded">
                            <label class="label">Security Question</label>
                            <div class="select is-fullwidth">
                                <select id="securityQuestion" name="securityQuestion" value="${user.questionNo}">
                                    <option value="0" selected>Choose one of the options below</option>
                                    <option value="1" >What was your first pet?</option>
                                    <option value="2">What was your first car?</option>
                                    <option value="3">What was your first school?</option>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="field">
                        <label class="label">Answer</label>
                        <div class="control">
                            <input class="input" type="text" name="answer" placeholder="Answer">
                        </div>
                    </div>

                    <div class="field is-grouped">
                        <div class="control">
                            <input type="submit" class="button is-link" value="Update">
                        </div>
                        <div class="control">
                            <a href="home.jsp"><button class="button is-text">Cancel</button></a>
                        </div>
                    </div>
                </div>
            </form>
                    
                <form action="membership" method="post" id="changePassword"
                    <c:choose>
                        <c:when test="${formActive == 'changePassword'}">
                            class=""
                        </c:when>
                        <c:otherwise>
                            class="is-hidden"
                        </c:otherwise>
                    </c:choose>">
                <h4 class="title is-4">Change Password</h4>
                <input type="hidden" name="action" value="changePassword">
                <div class="box">
                    <div class="field">
                        <label class="label">Old Password</label>
                        <div class="control">
                            <input class="input" type="password" name="old_password" placeholder="********">
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">New Password</label>
                        <div class="control">
                            <input class="input" type="password" name="new_password" placeholder="********">
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Confirm Password</label>
                        <div class="control">
                            <input class="input" type="password" name="confirm_password" placeholder="********">
                        </div>
                    </div>

                    <div class="notification is-hidden">
                         <button class="delete"></button>
                         ${notification}
                    </div>

                    <div class="field is-grouped">
                        <div class="control">
                            <input type="submit" class="button is-link" value="Update">
                        </div>
                        <div class="control">
                            <a href="home.jsp"><button class="button is-text">Cancel</button></a>
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <div class="column followbox">
            <div class="box followbox">
                <%@ include file="parts/follow.jsp" %>
            </div>
            <div class="box">
                <%@ include file="parts/trend.jsp" %>
            </div>
        </div>
    </div>
</body>
<%@ include file="parts/main_footer.jsp" %> 
