

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-primary mt-1">QUẢN LÝ KHÓA HỌC</h1>
<c:url value="/courses" var="action" />
<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>
<form:form method="post" enctype="multipart/form-data" action="${action}" modelAttribute="course">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />
    
    <div class="mb-3 mt-3">
        <label for="name" class="form-label">Tên sản phẩm:</label>
        <form:input path="name" type="text" class="form-control" id="name" placeholder="Tên sản phẩm..." name="name" />
        
    </div>
    <div class="mb-3 mt-3">
        <label for="browser" class="form-label">Danh mục: </label>
        <form:select class="form-select" path="categoryId" >
            
        </form:select>
    </div>
    <div class="mb-3 mt-3">
        <form:hidden path="id" />
        <button class="btn btn-success" type="submit">
            
        </button>
    </div>
</form:form>

