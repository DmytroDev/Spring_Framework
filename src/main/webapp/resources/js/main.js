$(function () {
    $('a#all-software-link, a#upload-link').click(function (event) {
        event.preventDefault();
        $.ajax({
            url: $(this).attr('href'), success: function (result) {
                console.log(this);
                document.getElementById("content").innerHTML = result;
            }
        });
    });

    $(document).on("click", "input#back-to-index-page-btn", function (event) {
        $.get("/view/index", function (data) {
            $("#content").html(data);
        });
    });

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
