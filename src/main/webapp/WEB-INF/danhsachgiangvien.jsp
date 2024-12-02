<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách Giảng viên</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1 class="my-4">Danh sách Giảng viên</h1>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Tên</th>
                    <th>Chức danh</th>
                    <th>Email</th>
                    <th>Số điện thoại</th>
                </tr>
            </thead>
            <tbody id="giangVienTable"></tbody>
        </table>
    </div>
    <script>
        fetch('/api/giangvien')
            .then(response => response.json())
            .then(data => {
                const table = document.getElementById('giangVienTable');
                data.forEach(giangVien => {
                    const row = `<tr>
                        <td>${giangVien.id}</td>
                        <td>${giangVien.ten}</td>
                        <td>${giangVien.chucDanh}</td>
                        <td>${giangVien.email}</td>
                        <td>${giangVien.soDienThoai}</td>
                    </tr>`;
                    table.innerHTML += row;
                });
            });
    </script>
</body>
</html>