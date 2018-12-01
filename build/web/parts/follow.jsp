<%-- 
    Document   : follow
    Created on : Nov 29, 2018, 10:36:06 AM
    Author     : duypham
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
                    <c:set var="contains" value="false" />
                    <c:forEach var="follow" items="${followedList}">
                        <c:if test="${follow.userID eq user.userID}">
                            <c:set var="contains" value="true" />
                        </c:if>
                    </c:forEach>
                    <c:choose>
                        <c:when test="${contains eq true}">
                            <a href="" class="button is-info is-small follow" onmouseover="follow('unfollow','${user.username}');">Unfollow</a>
                        </c:when>
                        <c:otherwise>
                            <a href="" class="button is-info is-small is-outlined follow" onmouseover="follow('follow','${user.username}');">Follow</a>
                        </c:otherwise>
                    </c:choose> 
                </div>
            </div>
        </article>
    </c:forEach>
</html>
