$(function () {
    $('a#all-software-link, a#upload-link, a#ribbon-img-link, a#download-archive-link').click(function (event) {
        event.preventDefault();
        $.ajax({
            url: $(this).attr('href'), success: function (result) {
                console.log(this);
                $("#content").html(result);
                /*document.getElementById("content").innerHTML = result;*/  // alternative syntax for line above
            }
        });
    });

    $('a#logout-link').click(function (event) {
        event.preventDefault();
        $.ajax({
            url: $(this).attr('href'), success: function (result) {
                console.log(this);
                $("#content").html(result);
            }
        });
        $.get("/view/updateUser/guest", function (data) {
            console.log(this);
            $("#username-div").html(data);
        });
    });

    $(document).on("click", "a#category-active-link, a#category-link", function () {
        event.preventDefault();
        $.ajax({
            url: $(this).attr('href'), success: function (result) {
                console.log(this);
                $("#categories-content").html(result);
            }
        });
    });

    $(document).on("click", "a#details-link", function () {
        event.preventDefault();
        $.ajax({
            url: $(this).attr('href'), success: function (result) {
                console.log(this);
                $("#content").html(result);
            }
        });
    });

    $(document).on("click", "input#back-to-index-page-btn, #cancel-btn, #back-to-index-from-details-btn", function () {
        $.get("/view/index", function (data) {
            console.log(this);
            $("#content").html(data);
        });
    });
    
    $(document).on("click", "#login-btn", function (event) {
        event.preventDefault();
        var formData = {
            'username': $('input[name=username]').val(),
            'password': $('input[name=password]').val()
        };
        $.post("/view/login", formData, function (data) {
            console.log(this);
            $("#content").html(data);
        });

        $.get("/view/updateUser", function (data) {
            console.log(this);
            $("#username-div").html(data);
        });
    });

    /* upload form with Zip-archive */
    $(document).on("submit", "#upload-form", function (event) {
        var formData = new FormData($('form')[0]);
        event.preventDefault();
        $.ajax({
            type: "POST",
            processData: false,
            contentType: false,
            url: "/view/upload",
            data: formData
        }).done(function (data) {
            console.log(this);
            document.getElementById("content").innerHTML = data;
        });
    });

});
