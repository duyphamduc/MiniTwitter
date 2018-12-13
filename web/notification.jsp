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
                    <%@ include file="parts/user_profile.jsp" %>  
                </div>
            </div>
            <div class="box">
                <%@ include file="parts/trend.jsp" %>  
            </div>
        </div>
        <!--Center Column-->
        <div class="column is-half">
            <nav class="breadcrumb has-bullet-separator is-medium" aria-label="breadcrumbs">
                <ul>
                  <li><a href="#">Notifications</a></li>
                </ul>
            </nav>
            <!--View Notification-->
            <c:if test="${empty notifications}">
                <p>No new notification.</p>
            </c:if>
            <c:forEach var="notification" items="${notifications}">
                <article class="media">
                    <figure class="media-left">
                        <p class="image is-64x64">
                            <img src="${notification.profileURL}">
                        </p>
                    </figure>
                    <div class="media-content">
                        <div class="content">
                            <strong>${notification.fullname}</strong> <small>@${notification.username}</small>
                            <c:choose>
                                <c:when test="${notification.tablename eq 'mention'}">
                                    <br>
                                    <p>
                                        ${notification.twit}
                                        <br>
                                        <small class="timeAgo">${notification.date}</small>
                                    </p>
                                </c:when>
                                <c:otherwise>
                                    is following you!
                                    <br>
                                    <small class="timeAgo">${notification.date}</small>
                                </c:otherwise>
                            </c:choose> 
                            
                        </div>
                    </div>
                </article>
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