<%-- 
    Document   : home.jsp
    Created on : Sep 24, 2015, 6:47:02 PM
    Author     : xl
--%>

<%@ include file="parts/main_header.jsp" %>  
<body>
    <section class="hero is-info is-small">
        <div class="hero-body">
            <div class="container">
                <h1 class="title">
                    ${searchKeyword}
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
            <c:if test="${empty results}">
                <p>Can't find any result with this keyword.</p>
            </c:if>
            <c:forEach var="result" items="${results}">
                <c:choose>
                    <c:when test="${result.tablename eq 'hashtag'}">
                        <article class="media">
                            <div class="media-content">
                                <div class="content">
                                    <strong>Hashtag</strong>
                                    <a href="" id="hashtag" class="hashtag">#${result.hashtagText}</a>
                                </div>
                            </div>
                        </article>
                    </c:when>
                    <c:when test="${result.tablename eq 'usr'}">
                        <article class="media">
                            <figure class="media-left">
                                <p class="image is-64x64">
                                    <img src="${result.profileURL}">
                                </p>
                            </figure>
                            <div class="media-content">
                                <div class="content">
                                    <strong>${result.fullname}</strong> <small>@${result.username}</small>
                                </div>
                            </div>
                        </article>
                    </c:when>
                    <c:otherwise>
                        <article class="media">
                            <figure class="media-left">
                                <p class="image is-64x64">
                                    <img src="${result.profileURL}">
                                </p>
                            </figure>
                            <div class="media-content">
                                <div class="content">
                                    <p>
                                        <strong>${result.fullname}</strong> <small>@${result.username}</small>
                                        <br>
                                        ${result.twit}
                                    </p>
                                </div>
                            </div>
                        </article>
                    </c:otherwise>
                </c:choose> 
            </c:forEach>
        </div>
        <div class="column"></div>
    </div>
</body>
<%@ include file="parts/main_footer.jsp" %> 
