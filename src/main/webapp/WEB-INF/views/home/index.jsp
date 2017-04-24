<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

<div id="content">
    <div class="container">

        <ul class="nav nav-pills nav-stacked">
            <div class="navbar-title">
                <h4>Games Education</h4>
            </div>
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#">Menu 1</a></li>
            <li><a href="#">Menu 2</a></li>
            <li><a href="#">Menu 3</a></li>
        </ul>

        <div class="titles-list">
            <ul class="media-list">
                <li class="media">
                    <div class="media-left">
                        <a href="#">
                            <img class="media-object"
                                 src="http://icons.iconarchive.com/icons/blackvariant/button-ui-requests-15/512/Downie-icon.png"
                                 alt="Logo">
                        </a>
                    </div>
                    <div class="media-body">
                        <h4 class="media-heading">Title 1</h4>
                    </div>
                </li>
                <hr>
                <li class="media">
                    <div class="media-left">
                        <a href="#">
                            <img class="media-object"
                                 src="http://icons.iconarchive.com/icons/blackvariant/button-ui-requests-15/512/WJoy-icon.png"
                                 alt="Logo">
                        </a>
                    </div>
                    <div class="media-body">
                        <h4 class="media-heading">Title 2</h4>
                    </div>
                </li>
                <hr>
                <li class="media">
                    <div class="media-left">
                        <a href="#">
                            <img class="media-object"
                                 src="http://icons.iconarchive.com/icons/blackvariant/button-ui-requests-15/512/Panorama-Sticher-icon.png"
                                 alt="Logo">
                        </a>
                    </div>
                    <div class="media-body">
                        <h4 class="media-heading">Title 3</h4>
                    </div>
                </li>
                <hr>
            </ul>
        </div>
    </div>
</div>
<c:import url="../fragments/footer.jsp"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="../../../resources/vendor/js/bootstrap.min.js"></script>

</body>
</html>