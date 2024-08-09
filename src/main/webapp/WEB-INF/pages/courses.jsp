<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="<c:url value='/css/course.css'/>">

<div class="container mt-5">
    <h1 class="text-center text-primary mb-4">QUẢN LÝ KHÓA HỌC</h1>

    <c:url value="/courses" var="action" />

    <c:if test="${errMsg != null}">
        <div class="alert alert-danger mb-3">
            ${errMsg}
        </div>
    </c:if>

    <form:form method="post" enctype="multipart/form-data" action="${action}" modelAttribute="course">
        <form:errors path="*" element="div" cssClass="alert alert-danger mb-3" />

        <div class="form-group mb-4">
            <label for="name" class="form-label">Tên khóa học:</label>
            <form:input path="name" type="text" class="form-control" id="name" placeholder="Tên khóa học..." name="name" />
        </div>

        <div class="form-group mb-4">
            <label for="name" class="form-label">Danh mục khóa học: </label>
            <form:select class="form-control" path="cateId">
                <c:forEach items="${categories}" var="c">
                    <c:choose>
                        <c:when test="${c.id == course.cateId.id}">
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
            <label for="name" class="form-label">Bài Giảng</label>
            <div class="card mb-4">
                <div class="card-body">
                    <ul class="list-group list-group-flush">
                        <c:set var="hasLessons" value="false" />
                        <c:forEach var="les" items="${lesson}">
                            <c:if test="${les.courseId.name == course.name}">
                                <c:set var="hasLessons" value="true" />
                                <li class="list-group-item d-flex justify-content-between align-items-center">
                                    <span style="color: blue"> Nội dung bài giảng "${les.name}" : </span>
                                    <a href="#" class="btn btn-sm btn-outline-primary">Chi Tiết</a>
                                </li>
                                <li class="list-group-item content-indent">
                                    ${les.content}
                                </li>
                            </c:if>
                        </c:forEach>
                        <c:if test="${not hasLessons}">
                            <li class="list-group-item">CHƯA CÓ BÀI GIẢNG NÀO</li>
                            </c:if>
                    </ul>
                    <button class="btn btn-info mt-3 d-block mx-auto">Thêm Bài Giảng Mới</button>
                </div>
            </div>
        </div>


        <div class="form-group mb-4">
            <button class="btn btn-success btn-block" type="submit">
                <c:choose>
                    <c:when test="${course.id != null}">
                        Cập nhật khóa học
                    </c:when>
                    <c:otherwise>
                        Thêm khóa học
                    </c:otherwise>
                </c:choose>
            </button>
        </div>
    </form:form>
</div>
