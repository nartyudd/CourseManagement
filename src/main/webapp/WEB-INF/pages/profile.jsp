<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<section class="container">
    <h1 class="text-center text-info m-1">QUẢN LÝ GIẢNG VIÊN</h1>
    
    <c:url value="/profile" var="searchAction" />
    <form action="${searchAction}" method="get">
        <div class="mb-3 mt-3">
            <label for="kw" class="form-label"></label>
            <input type="text" class="form-control" id="kw" placeholder="Tìm kiếm theo tên, email hoặc sđt" name="q">
        </div>
        <div class="mb-3 mt-3">
            <button class="btn btn-info" type="submit">Tìm kiếm</button>
        </div>
    </form>

    <c:url value="/profile/save" var="saveAction" />
    <form action="${saveAction}" method="post">
        <input type="hidden" name="action" value="add" />

        <div class="mb-3">
            <input type="text" class="form-control" placeholder="Tên người dùng" name="fullName" required>
        </div>
        <div class="mb-3">
            <input type="email" class="form-control" placeholder="Email" name="email" required>
        </div>
        <div class="mb-3">
            <input type="text" class="form-control" placeholder="Số điện thoại" name="phone" required>
        </div>
        <div class="mb-3">
            <button class="btn btn-success" type="submit">Thêm Giảng Viên</button>
        </div>
    </form>
    
    <table class="table table-striped">
        <tr>
            <th>Tên người dùng</th>
            <th>Email</th>       
            <th>Số điện thoại</th>
            <th>Hành động</th>
        </tr>
        <c:forEach items="${profiles}" var="c">
            <tr id="profile${c.id}">
                <td>${c.fullName}</td>
                <td>${c.email}</td>
                <td>${c.phone}</td>
                <td>
                    <c:url value="/profile/save" var="saveAction" />
                    <form action="${saveAction}" method="post">
                        <input type="hidden" name="action" value="edit" />
                        <input type="hidden" name="id" value="${c.id}" /> <!-- Sửa profile.id thành c.id -->

                        <div class="mb-3">
                            <input type="text" class="form-control" placeholder="Tên người dùng" name="fullName" value="${c.fullName}" required> <!-- Sửa profile.fullName thành c.fullName -->
                        </div>
                        <div class="mb-3">
                            <input type="email" class="form-control" placeholder="Email" name="email" value="${c.email}" required> <!-- Sửa profile.email thành c.email -->
                        </div>
                        <div class="mb-3">
                            <input type="text" class="form-control" placeholder="Số điện thoại" name="phone" value="${c.phone}" required> <!-- Sửa profile.phone thành c.phone -->
                        </div>
                        <div class="mb-3">
                            <button class="btn btn-success" type="submit">Cập Nhật Giảng Viên</button>
                        </div>
                    </form>


                    
                    <c:url value="/profile/delete/${c.id}" var="deleteAction" />
                    <a href="${deleteAction}" class="btn btn-danger" 
                       onclick="return confirm('Bạn có chắc chắn muốn xóa giảng viên này?');">Xóa</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</section>
