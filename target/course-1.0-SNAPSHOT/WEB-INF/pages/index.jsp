
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
                    <th>Tên khóa học</th>
                    <th></th>
                </tr>
                <c:forEach items="${courses}" var="p">
                    <tr id="course${p.id}">
                        <td>${p.name}</td>
                        <td>
                            <c:url value="/courses/${p.id}" var="u" />
                            <a href="${u}" class="btn btn-success">&orarr;</a>

                            <c:url value="/api/courses/${p.id}" var="uD" />
                            <button onclick="deleteCourse('${uD}', ${p.id})" class="btn btn-danger">&times;</button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</section>
