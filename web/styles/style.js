$(document).on('click', '.notification > button.delete', function() {
    $(this).parent().addClass('is-hidden');
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


$(document).on('click', '.navbar-item', function() {
    $('navbar-item').removeClass('is-active is-tab');
});

