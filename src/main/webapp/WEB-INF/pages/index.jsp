
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<section class="container">
    <h1 class="text-center text-info m-1">COURSES LIST</h1>
    <div class="row">
        <div class="col-md-2 col-12 bg-secondary">
            <c:url value="/"  var="action" />
            <form action="${action}">
                <div class="mb-3 mt-3">
                    <label for="kw" class="form-label">Name Course:</label>
                    <input type="text" class="form-control" >
                </div>
                <div class="mb-3 mt-3">
                    <button class="btn btn-info" type="submit">Tìm kiếm</button>
                </div>
            </form>
        </div>
        <div class="col-md-10 col-12">
            <a class="btn btn-info m-1" href="<c:url value="/courses" />">Thêm khóa học</a>
            <table class="table table-striped">
                <tr>
                    <th>Loại khóa học</th>
                    <th></th>
                </tr>
                <c:forEach items="${categories}" var="cat">
                    <tr id="category${cat.id}">
                        <td >${cat.name}</td>
                        <td>
                            <c:url value="/categories/${cat.id}" var="u" />
                            <a href="${u}" class="btn btn-success">&orarr;</a>

                            <c:url value="/api/categories/${cat.id}" var="uD" />
                            <button onclick="deleteCourse('${uD}', ${cat.id})" class="btn btn-danger">&times;</button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</section>
