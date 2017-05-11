<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="content">
    <div class="details-page-div">
        <div class="element-title-img">
            <p class="software-title">${software.name}</p>
            <img class="media-object" src="/imgController512/getImg${software.id}" alt="Logo">
        </div>
        <div class="element-description">
            <p>${software.description}</p>
            <button id="download-btn" class="download-btn">
                <a id="download-archive-link" class="download-btn-href" href="/download/archive/${software.id}">Download</a>
            </button>
            <button id="back-to-index-from-details-btn" class="back-to-index-from-details-btn">Back</button>
        </div>
    </div>
</div>

