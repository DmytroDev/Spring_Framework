%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>SoftwareStore</title>
    <link href="../../../resources/vendor/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../../../resources/css/style.css">
</head>
<body>
<c:import url="../fragments/header.jsp"/>;


<div class="content-wrap">
    <div class="details-page-div">
        <div class="element-title-img">
            <p class="software-title">Twitter</p>
            <img class="media-object"
                 src="http://icons.iconarchive.com/icons/sicons/basic-round-social/512/google-icon.png"
                 alt="Logo">
        </div>
        <div class="element-description">
            <p>The embedded database concept is very helpful during the development phase, because they are lightweight,
                fast, quick start time, improve testability, ease of configuration,
                it lets developer focus more on the development instead of how to configure a data source to the database,
                or waste time to start a heavyweight database to just test a few lines of code.
                P.S This embedded database feature has been available since Spring 3.</p>
            <button class="download-btn">
                <a class="download-btn-href" href="/download">Download</a>
            </button>
        </div>
    </div>
</div>


<c:import url="../fragments/footer.jsp"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="../../../resources/vendor/js/bootstrap.min.js"></script>

</body>
</html>