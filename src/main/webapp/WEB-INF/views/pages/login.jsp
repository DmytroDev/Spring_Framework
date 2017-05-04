<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="content">

    <form method="post" class="login-form" action="/view/login">
        <div class="imgcontainer">
            <img src="../../../resources/images/img_avatar2.png" alt="Avatar" class="avatar">
        </div>
        <div class="login-container">
            <label><b>Username</b></label>
            <input class="form-field" type="text" placeholder="Enter Username" name="username" required>

            <label><b>Password</b></label>
            <input class="form-field" type="password" placeholder="Enter Password" name="password" required>

            <button id="login-btn" class="login-btn" type="submit">Login</button>
            <button id="cancel-btn" class="cancel-btn" type="button" >Skip</button>
        </div>
    </form>
</div>