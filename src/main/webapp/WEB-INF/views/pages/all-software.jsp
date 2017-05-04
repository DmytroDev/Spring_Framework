<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="content">
    <div class="container">

        <ul class="nav nav-pills nav-stacked">
            <div class="navbar-title">
                <h4>Games Education</h4>
            </div>

            <c:if test="${!empty categories}">
                <c:forEach items="${categories}" var="category">
                    <li><a href="#">${category}</a></li>
                    <%--                    <a id="ribbon-img-link" href="/view/details">
                                            <img src="/imgController128/getImg${software.id}"/>
                                        </a>--%>
                </c:forEach>
            </c:if>
            <%--            <li class="active"><a href="#">Home</a></li>
                        <li><a href="#">Menu 1</a></li>
                        <li><a href="#">Menu 2</a></li>
                        <li><a href="#">Menu 3</a></li>--%>
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
