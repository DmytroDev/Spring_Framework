<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="content">
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

