$(function () {
    /*    $('a#all-software-link, a#upload-link, a#ribbon-img-link, a#download-archive-link').click(function (event) {
     event.preventDefault();
     $.ajax({
     url: $(this).attr('href'), success: function (result) {
     console.log(this);
     $("#content").html(result);
     /!*document.getElementById("content").innerHTML = result;*!/  // alternative syntax for line above
     }
     });
     });*/
    

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
                //console.log(this);
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

    /* upload form with Zip-archive */
    $(document).on("submit", "#upload-form", function (event) {

        var csrfParameter = $("meta[name='_csrf_parameter']").attr("content");
        var csrfHeader = $("meta[name='_csrf_header']").attr("content");
        var csrfToken = $("meta[name='_csrf']").attr("content");
        var headers = {};
        headers[csrfHeader] = csrfToken;
        console.log(csrfParameter, csrfHeader, csrfToken, headers[0]);

        var formData = new FormData($('form')[0]);
        event.preventDefault();
        $.ajax({
            type: "POST",
            processData: false,
            contentType: false,
            url: "/view/upload",
            headers: headers,
            data: formData
        }).done(function (data) {
            console.log(this);
            document.getElementById("content").innerHTML = data;
        });
    });

});
