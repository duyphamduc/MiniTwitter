<%-- 
    Document   : trend
    Created on : Nov 29, 2018, 10:35:49 AM
    Author     : duypham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <h5 class="title is-5">Trends for you</h5>
    <c:forEach var="trend" items="${topTrends}">
        <div class="trendsitem">
            <a href="hashtag?action=viewTweets&hashtagText=${trend.hashtagText}"><strong>#${trend.hashtagText}</strong></a> <br>
            <small>${trend.hashtagCount} tweets</small>
        </div>
    </c:forEach>
</html>
