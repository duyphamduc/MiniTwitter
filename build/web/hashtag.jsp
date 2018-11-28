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
                <h5 class="title is-5">Who to follow</h5>
                <c:forEach var="user" items="${users}">
                    <article class="media">
                        <div class="media-left" >
                            <figure class="image is-48x48">
                                <img src="${user.profileURL}">
                            </figure>
                        </div>
                        <div class="media-content">
                            <div class="content">
                                <strong>${user.fullname}</strong><small> @${user.username}</small><br>
                                <a class="button is-info is-small is-outlined">Follow</a>
                            </div>
                        </div>
                        <div class="media-right">
                          <button class="delete"></button>
                        </div>
                    </article>
                </c:forEach>
            </div>
            <div class="box">
                <h5 class="title is-5">Trends for you</h5>
                <c:forEach var="trend" items="${topTrends}">
                    <div class="trendsitem">
                        <a href="hashtag?action=viewTweets&hashtagText=${trend.hashtagText}"><strong>#${trend.hashtagText}</strong></a> <br>
                        <small>${trend.hashtagCount} tweets</small>
                    </div>
                </c:forEach>
            </div>
        </div>
                            
        <div class="column is-half">
             <c:forEach var="tweet" items="${hashtagTweets}">
                <div class="box is-marginless">
                    <div class="media">
                        <div class="media-left">
                            <figure class="image is-64x64">
                                <img src="${tweet.profileURL}" alt="Image">
                            </figure>
                        </div>
                        <div class="media-content">
                            <div class="content">
                                <p>
                                    <strong>${tweet.fullname}</strong> <small>@${tweet.username}</small>
                                    <br>
                                    ${tweet.twit}
                                </p>
                            </div>
                            <nav class="level is-mobile">
                                <div class="level-left">
                                    <a class="level-item" aria-label="reply">
                                        <span class="icon is-small">
                                          <i class="fas fa-reply" aria-hidden="true"></i>
                                        </span>
                                    </a>
                                    <a class="level-item" aria-label="retweet">
                                        <span class="icon is-small">
                                          <i class="fas fa-retweet" aria-hidden="true"></i>
                                        </span>
                                    </a>
                                    <a class="level-item" aria-label="like">
                                        <span class="icon is-small">
                                          <i class="fas fa-heart" aria-hidden="true"></i>
                                        </span>
                                    </a>
                                    <c:if test="${user.userID == tweet.tweetUserID}">
                                        <a class="level-item" aria-label="delete" href="tweet?action=deleteTweet&tweetID=${tweet.tweetID}">
                                            <span class="icon is-small">
                                              <i class="fas fa-trash-alt" aria-hidden="true"></i>
                                            </span>
                                        </a>
                                    </c:if>
                                </div>
                            </nav>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="column"></div>
    </div>
</body>
<%@ include file="parts/main_footer.jsp" %> 
