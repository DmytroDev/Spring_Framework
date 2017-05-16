<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="content">
    <div class="container">
        <ul class="nav nav-pills nav-stacked">
            <div class="navbar-title">
                <h4>Games Education</h4>
            </div>
            <c:if test="${!empty categories}">
                <c:forEach items="${categories}" var="category" varStatus="myIndex">
                    <li><a id="category-link" href="/view/category/${category}">${category}</a></li>
                </c:forEach>
            </c:if>
        </ul>

        <div id="categories-content" class="titles-list">

            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <h2>User : ${pageContext.request.userPrincipal.name}</h2>
            </c:if>

            <div class="categories-initial-title">Please select a category from the section <span>Games Education</span></div>
            <img class="left-arrow-img" src="../../../resources/images/arrow1.png" alt="Left arrow logo">
        </div>
    </div>
</div>
