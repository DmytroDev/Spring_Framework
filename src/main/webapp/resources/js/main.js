$(function () {
    
    $(document).on("click", "a#category-active-link, a#category-link", function () {
        event.preventDefault();
        $.ajax({
            url: $(this).attr('href'), success: function (result) {
                console.log(this);
                $("#categories-content").html(result);
            }
        });
    });

    $(document).on("click", "a#details-link, a#all-software-link, a#upload-link, a#ribbon-img-link", function () {
        event.preventDefault();
        $.ajax({
            url: $(this).attr('href'), success: function (result) {
                $("#content").html(result);
            }
        });
    });

    $(document).on("click", "input#back-to-index-page-btn, #back-to-index-from-details-btn", function () {
        $.get("/view/index", function (data) {
            console.log(this);
            $("#content").html(data);
        });
    });

    /* upload form with Zip-archive */
    $(document).on("submit", "#upload-form", function (event) {
        var formData = new FormData($('form')[0]);
        event.preventDefault();
        $.ajax({
            type: "POST",
            enctype: 'multipart/form-data',
            processData: false,
            contentType: false,
            url: "/view/upload",
            data: formData,
            success: function (result) {
                $("#content").html(result);
            }
        });
    });

});
