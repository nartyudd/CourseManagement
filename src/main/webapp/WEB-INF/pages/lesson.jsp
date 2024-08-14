<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="<c:url value='/css/course.css'/>">


<div class="container mt-5">
    <h1 class="text-center text-primary mb-4">QUẢN LÝ BÀI GIẢNG</h1>

    <c:url value="/lessons" var="action" />

    <c:if test="${errMsg != null}">
        <div class="alert alert-danger mb-3">
            ${errMsg}
        </div>
    </c:if>

    <form:form method="post" enctype="multipart/form-data" action="${action}" modelAttribute="lesson">
        <form:errors path="*" element="div" cssClass="alert alert-danger mb-3" />

        <div class="form-group mb-4">
            <label for="name" class="form-label">Tên Bài Giảng:</label>
            <form:input path="name" type="text" class="form-control" id="name" placeholder="Tên Bài Giảng..." name="name" />
        </div>
        
        <div class="form-group mb-4">
            <label for="name" class="form-label">Danh mục khóa học: </label>
            <form:select class="form-control" path="courseId">
                <c:forEach items="${Course}" var="c">
                    <c:choose>
                        <c:when test="${c.id == lesson.courseId.id}">
                            <option value="${c.id}" selected>${c.name}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${c.id}">${c.name}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </form:select>
        </div>
        
        <div class="form-group mb-4">
            <label for="lessonContent" class="form-label">Nội Dung:</label>
            <textarea class="form-control" id="lessonContent" name="content" placeholder="Nội dung bài giảng...">${lesson.content}</textarea>
        </div>

        <div class="form-group mb-4">
            <form:hidden path="id" />
            <button class="btn btn-success btn-block" type="submit">
                <c:choose>
                    <c:when test="${lesson.id != null}">
                        Cập nhật Bài Giảng
                    </c:when>
                    <c:otherwise>
                        Thêm Bài Giảng
                    </c:otherwise>
                </c:choose>
            </button>
        </div>
    </form:form>

</div>