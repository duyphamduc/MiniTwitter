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
        <div class="column">
            <div class="box is-paddingless">
                <div class="card">
                    <div class="card-image">
                        <figure class="image is-3by1">
                            <img src="https://bulma.io/images/placeholders/1280x960.png" alt="Placeholder image">
                        </figure>
                    </div>
                    <div class="card-content">
                        <div class="media">
                            <div class="media-left">
                              <figure class="image is-48x48">
                                <img src="https://bulma.io/images/placeholders/96x96.png" alt="Placeholder image">
                              </figure>
                            </div>
                            <div class="media-content">
                              <p class="title is-5">${user.fullname}</p>
                              <p class="subtitle is-6">@${user.username}</p>
                            </div>
                        </div>
                        <div class="content is-small">
                            <a><strong>Tweets</strong></a><br>
                            <strong>12.3k</strong> 
                        </div>
                    </div>
                  </div>
            </div>
            <div class="box">
                <h5 class="title is-5">Trends for you</h5>
                <div class="trendsitem">
                    <a><strong>#trendA</strong></a> <br>
                    <small>1234 tweets</small>
                </div>
                <div class="trendsitem">
                    <a><strong>John Doe</strong></a> <br>
                    <small>1234 tweets</small>
                </div>
                <div class="trendsitem">
                    <a><strong>#trendB</strong></a> <br>
                    <small>1234 tweets</small>
                </div>
                
                
            </div>
        </div>
        <div class="column is-half">
            <div class="box is-marginless" style="background-color: #e2f4ff;">
                <div class="media">
                    <div class="media-left">
                        <figure class="image is-48x48">
                            <img src="https://bulma.io/images/placeholders/64x64.png" alt="Image">
                        </figure>
                    </div>
                    <div class="media-content">
                        <div class="content">
                            <textarea class="textarea" placeholder="Hello world" rows="3" ></textarea>
                        </div>
                        <nav class="level is-mobile">
                            <div class="level-left"></div>
                            <div class="level-right">
                                <a class="button is-info">Tweet</a>
                            </div>
                        </nav>
                    </div>
                </div>
            </div>
            
            <div class="box is-marginless">
                <div class="media">
                    <div class="media-left">
                        <figure class="image is-64x64">
                            <img src="https://bulma.io/images/placeholders/64x64.png" alt="Image">
                        </figure>
                    </div>
                    <div class="media-content">
                        <div class="content">
                            <p>
                                <strong>John Smith</strong> <small>@johnsmith</small> <small>31m</small>
                                <br>
                                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean efficitur sit amet massa fringilla egestas. Nullam condimentum luctus turpis.
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
                            </div>
                        </nav>
                    </div>
                    
                </div>
            </div>
            <div class="box is-marginless">
                <div class="media">
                    <div class="media-left">
                        <figure class="image is-64x64">
                            <img src="https://bulma.io/images/placeholders/64x64.png" alt="Image">
                        </figure>
                    </div>
                    <div class="media-content">
                        <div class="content">
                            <p>
                                <strong>John Smith</strong> <small>@johnsmith</small> <small>31m</small>
                                <br>
                                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean efficitur sit amet massa fringilla egestas. Nullam condimentum luctus turpis.
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
                            </div>
                        </nav>
                    </div>
                    
                </div>
            </div>
            <div class="box is-marginless">
                <div class="media">
                    <div class="media-left">
                        <figure class="image is-64x64">
                            <img src="https://bulma.io/images/placeholders/64x64.png" alt="Image">
                        </figure>
                    </div>
                    <div class="media-content">
                        <div class="content">
                            <p>
                                <strong>John Smith</strong> <small>@johnsmith</small> <small>31m</small>
                                <br>
                                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean efficitur sit amet massa fringilla egestas. Nullam condimentum luctus turpis.
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
                            </div>
                        </nav>
                    </div>
                    
                </div>
            </div>
            <div class="box is-marginless">
                <div class="media">
                    <div class="media-left">
                        <figure class="image is-64x64">
                            <img src="https://bulma.io/images/placeholders/64x64.png" alt="Image">
                        </figure>
                    </div>
                    <div class="media-content">
                        <div class="content">
                            <p>
                                <strong>John Smith</strong> <small>@johnsmith</small> <small>31m</small>
                                <br>
                                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean efficitur sit amet massa fringilla egestas. Nullam condimentum luctus turpis.
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
                            </div>
                        </nav>
                    </div>
                    
                </div>
            </div>
        </div>
        <div class="column followbox">
            <div class="box">
                <h5 class="title is-5">Who to follow</h5>
                <article class="media">
                    <div class="media-left" >
                        <figure class="image is-48x48">
                            <img src="https://bulma.io/images/placeholders/64x64.png">
                        </figure>
                    </div>
                    <div class="media-content">
                        <div class="content">
                            <strong>John Smith</strong><small>@johnsmithjohnsmith</small><br>
                            <a class="button is-info is-small is-outlined">Follow</a>
                        </div>
                    </div>
                    <div class="media-right">
                      <button class="delete"></button>
                    </div>
                </article>
                <article class="media">
                    <div class="media-left" >
                        <figure class="image is-48x48">
                            <img src="https://bulma.io/images/placeholders/64x64.png">
                        </figure>
                    </div>
                    <div class="media-content">
                        <div class="content">
                            <strong>John Smith</strong><small>@johnsmithjohnsmith</small><br>
                            <a class="button is-info is-small is-outlined">Follow</a>
                        </div>
                    </div>
                    <div class="media-right">
                      <button class="delete"></button>
                    </div>
                </article>
                <article class="media">
                    <div class="media-left" >
                        <figure class="image is-48x48">
                            <img src="https://bulma.io/images/placeholders/64x64.png">
                        </figure>
                    </div>
                    <div class="media-content">
                        <div class="content">
                            <strong>John Smith</strong><small>@johnsmithjohnsmith</small><br>
                            <a class="button is-info is-small is-outlined">Follow</a>
                        </div>
                    </div>
                    <div class="media-right">
                      <button class="delete"></button>
                    </div>
                </article>
            </div>
        </div>
    </div>
</body>