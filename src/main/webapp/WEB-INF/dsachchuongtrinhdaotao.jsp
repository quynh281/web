<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.ChuongTrinhDaoTao" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh Sách Chương Trình Đào Tạo</title>
</head>
<body>
    <h2>Danh Sách Chương Trình Đào Tạo</h2>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Tên Chương Trình</th>
                <th>Mô Tả</th>
                <th>Hành Động</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="chuongTrinh" items="${chuongTrinhDaoTaoList}">
                <tr>
                    <td>${chuongTrinh.id}</td>
                    <td>${chuongTrinh.tenChuongTrinh}</td>
                    <td>${chuongTrinh.moTa}</td>
                    <td>
                        <a href="edit?id=${chuongTrinh.id}">Sửa</a>
                        <a href="delete?id=${chuongTrinh.id}">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
