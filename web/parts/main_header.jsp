<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Mini Twitter</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.2/css/bulma.min.css">
        <link rel="stylesheet" type="text/css" href="/MyTwitter/styles/home.css">
        <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
        <script type="text/javascript" src="/MyTwitter/styles/style.js"></script>
    </head>
    <body>
        <nav class="navbar" role="navigation" aria-label="main navigation">
            <div class="navbar-menu">
                <div class="navbar-start">
                    <a href="/MyTwitter/tweet" id="home" class="navbar-item"><i class="fas fa-home"></i>&nbsp;Home</a>
                    <a href="/MyTwitter/#" id="notification" class="navbar-item"><i class="fas fa-bell"></i></i>&nbsp;Notification</a>
                    <a href="/MyTwitter/profile.jsp" id="profile" class="navbar-item"><i class="fas fa-user"></i>&nbsp;Profile</a>
                </div>
                <div class="navbar-end">
                    <div class="navbar-item">
                        <div class="buttons">
                            <a href="/MyTwitter/membership?action=logout" class="button is-info">Logout</a>
                        </div>
                    </div>
                </div>
            </div>
        </nav>
    </body>
    <hr>
</html>


