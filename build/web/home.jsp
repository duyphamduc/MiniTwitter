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
    <div class="columns is-desktop">
        <!--Left Colum-->
        <div class="column">
            <div class="box is-paddingless">
                <div class="card">
                    <div class="card-image has-bg-img">
                        <figure class="image is-3by2">
                            <img src="${user.coverURL}" alt="Placeholder image">
                        </figure>
                    </div>
                    <div class="card-content">
                        <div class="media">
                            <div class="media-left">
                              <figure class="image is-48x48">
                                <img src="${user.profileURL}">
                              </figure>
                            </div>
                            <div class="media-content">
                              <p class="title is-5">${user.fullname}</p>
                              <p class="subtitle is-6">@${user.username}</p>
                            </div>
                        </div>
                        <div class="content is-small">
                            <a><strong>Tweets</strong></a><br>
                            <strong>${tweetCount}</strong> 
                        </div>
                    </div>
                </div>
            </div>
            <div class="box">
                <%@ include file="parts/trend.jsp" %>  
            </div>
        </div>
        <!--Center Column-->
        <div class="column is-half">
            <!--Post Tweet box-->
            <div class="box is-marginless" style="background-color: #e2f4ff;">
                <div class="media">
                    <div class="media-left">
                        <figure class="image is-48x48">
                            <img src="${user.profileURL}" alt="Image">
                        </figure>
                    </div>
                    <div class="media-content">
                        <form action="tweet" method="post">
                            <input type="hidden" name="action" value="postTweet">
                            <div class="content">
                                <textarea id="tweetBox" class="textarea" name="tweet" placeholder="Hello world" rows="3" ></textarea>
                            </div>
                            <nav class="level is-mobile">
                                <div class="level-left"></div>
                                <div class="level-right">
                                    <input type="submit" class="button is-link" value="Tweet">
                                </div>
                            </nav>
                        </form>
                    </div>
                </div>
            </div>
            <!--View Tweet-->
            <c:forEach var="tweet" items="${tweets}">
                <%@ include file="parts/tweet_body.jsp" %>
            </c:forEach>
            
        </div>
        <!--Right Column-->
        <div class="column followbox">
            <div class="box">
                <%@ include file="parts/follow.jsp" %>
            </div>
        </div>
    </div>
</body>
<%@ include file="parts/main_footer.jsp" %> 