<%-- 
    Document   : user_profile
    Created on : Dec 1, 2018, 9:25:06 AM
    Author     : duypham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
            <nav class="level">
                <div class="level-item has-text-centered">
                    <div>
                        <a><strong>Tweets</strong></a><br>
                        <strong>${tweetCount}</strong> 
                    </div>
                </div>
                <div class="level-item has-text-centered">
                    <div>
                        <a><strong>Following</strong></a><br>
                        <strong>${followingCount}</strong> 
                    </div>
                </div>
                <div class="level-item has-text-centered">
                    <div>
                        <a><strong>Followers</strong></a><br>
                        <strong>${followersCount}</strong> 
                    </div>
                </div>
            </nav>
        </div>
    </div>
</html>
