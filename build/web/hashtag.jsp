<%-- 
    Document   : home.jsp
    Created on : Sep 24, 2015, 6:47:02 PM
    Author     : xl
--%>

<%@ include file="parts/main_header.jsp" %>  
<body>
    <section class="hero is-info">
        <div class="hero-body">
            <div class="container">
                <h1 class="title">
                    ${activeHashtag}
                </h1>
            </div>
        </div>
    </section>
    <div class="columns is-desktop">
        <div class="column followbox">
            <div class="box followbox">
                <%@ include file="parts/follow.jsp" %>
            </div>
            <div class="box">
                <%@ include file="parts/trend.jsp" %>  
            </div>
        </div>
                            
        <div class="column is-half">
             <c:forEach var="tweet" items="${hashtagTweets}">
                <%@ include file="parts/tweet_body.jsp" %>
            </c:forEach>
        </div>
        <div class="column"></div>
    </div>
</body>
<%@ include file="parts/main_footer.jsp" %> 
