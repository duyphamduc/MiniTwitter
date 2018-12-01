$(document).on('click', '.notification > button.delete', function() {
    $(this).parent().addClass('is-hidden');
    return false;
});

$(document).on('click', '#change-cover', function() {
    $(".modal").addClass('is-active');
    return false;
});

$(document).on('click', '.modal-card-head > button.delete', function() {
    $(this).closest(".modal").removeClass('is-active');
    return false;
});

function profileUpdate(type){
    $('.notification').addClass('is-hidden');
    if(type === 'profile'){
        $('#updateProfile').removeClass('is-hidden');
        $('#changePassword').addClass('is-hidden');
    }else if(type === 'password'){
        $('#updateProfile').addClass('is-hidden');
        $('#changePassword').removeClass('is-hidden');
    }
    return false;
};

function follow(action, username){
    if(action === 'follow'){
        $(".follow").attr("href", "follow?action=follow&username=" + username);
    }else{
        $(".follow").attr("href", "follow?action=unfollow&username=" + username);
    }
    
};

$(document).ready(function(){
    $("#hashtag").mouseover(function(){
        var hashtag = $("#hashtag").text();
        hashtag = hashtag.substring(1);
        $("#hashtag").attr("href","hashtag?action=viewTweets&hashtagText=" + hashtag);
    });
});


$(document).on('click', '.navbar-item', function() {
    $('navbar-item').removeClass('is-active is-tab');
});

