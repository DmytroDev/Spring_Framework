<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec"
          uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>SoftwareStore</title>
    <link href="../../../resources/vendor/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../../../resources/css/style.css">

    <%--  TODO: investigate it later --%>
    <%-- tags for Spring Security--%>
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
</head>

<body>
<c:import url="../fragments/header.jsp"/>

<div id="content">
    <sec:authorize access="!isAuthenticated()">
        <c:import url="../pages/login.jsp"/>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <c:import url="../pages/all-software.jsp"/>
    </sec:authorize>
</div>

<c:import url="../fragments/footer.jsp"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="../../../resources/vendor/js/bootstrap.min.js"></script>
<script src="../../../resources/js/main.js"></script>

</body>
</html>