<%-- 
    Document   : tweet_body
    Created on : Nov 29, 2018, 10:50:29 AM
    Author     : duypham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
                        <strong>${tweet.fullname}</strong> <small>@${tweet.username}</small> &middot; <small class="timeAgo">${tweet.time}</small>
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
    
</html>
