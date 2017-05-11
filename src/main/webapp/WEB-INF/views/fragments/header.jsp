<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="site-header" class="site-header">
    <div class="header-top">
        <div class="header-msg">SoftwareStore
        </div>
        <div id="username-div" class="header-right-part">
            Welcome, <span>${sessionScope.username}</span>
        </div>
        <div class="navigation-div">
            <ul class="main-menu">
                <li><a id="upload-link" href="/view/upload">Upload</a></li>
                <li><a id="all-software-link" href="/view/index">Home</a></li>
            </ul>
        </div>
    </div>
    <div class="header-bottom">
        <div>
            <p class="header-title">Most Popular</p>
        </div>
        <div class="header-ribbon">
            <c:if test="${!empty softwareList}">
                <c:forEach items="${softwareList}" var="software">
                    <a id="ribbon-img-link" href="/view/details/${software.id}">
                        <img src="/imgController128/getImg${software.id}" onerror="this.src='../../../resources/images/no_image_available.png'"/>
                    </a>
                </c:forEach>
            </c:if>
        </div>
    </div>
</div>