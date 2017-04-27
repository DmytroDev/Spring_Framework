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
    <div class="upload-title">
        <p>Upload</p>
    </div>
    <div class="container">
        <form class="upload-form">
            <div class="form-group">
                <label for="exampleInputEmail1">Application name</label>
                <input type="text" class="form-control" id="exampleInputEmail1" placeholder="Name">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Description</label>
                <input type="text" class="form-control" id="exampleInputPassword1" placeholder="Description">
            </div>
            <div class="form-group">
                <label for="exampleInputFile">File input (ZIP-archive)</label>
                <input type="file" id="exampleInputFile">
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
        </form>
    </div>
</div>


<c:import url="../fragments/footer.jsp"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="../../../resources/vendor/js/bootstrap.min.js"></script>

</body>
</html>