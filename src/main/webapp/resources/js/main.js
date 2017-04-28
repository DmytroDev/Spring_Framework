$(function () {
    $(document).ready(function () {
        $.get("/view" + window.location.pathname, function (data) {
            $("#content").html(data);
        });
    });

    $(document).on("click", "a#all-software-link", function (event) {
        event.preventDefault();
        $.get("/view/index", function (data) {
            $("#content").html(data);
        });
    });

    $(document).on("click", "a#upload-link", function (event) {
        event.preventDefault();
        $.get("/view/upload", function (data) {
            $("#content").html(data);
        });
    });

});
