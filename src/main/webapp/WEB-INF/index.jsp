<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang Chủ - Khoa Tin Học</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEJmB4l7pJd1RW2pJiy1hdFsp8k6zC5E2z1b5eO2Hg1oImr1A6/4n1w3MzOxF" crossorigin="anonymous">
    <link rel="stylesheet" href="styles.css">
</head>
<body>

    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Khoa Tin Học</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link active" href="#">Trang Chủ</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Giới Thiệu</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Khóa Học</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Giảng Viên</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Liên Hệ</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Main Content -->
    <section class="hero bg-primary text-white text-center py-5">
        <div class="container">
            <h1 class="display-4">Chào mừng đến với Khoa Tin Học</h1>
            <p class="lead">Khám phá các khóa học và chương trình đào tạo tốt nhất tại khoa của chúng tôi.</p>
        </div>
    </section>

    <!-- About Section -->
    <section class="about py-5">
        <div class="container">
            <h2 class="text-center mb-4">Giới Thiệu Về Khoa</h2>
            <p class="lead text-center">Khoa Tin học cung cấp các chương trình đào tạo chất lượng, giúp sinh viên phát triển kỹ năng và tiếp cận công nghệ mới nhất.</p>
        </div>
    </section>

    <!-- Courses Section -->
    <section class="courses bg-light py-5">
        <div class="container">
            <h2 class="text-center mb-4">Khóa Học Của Chúng Tôi</h2>
            <div class="row">
                <div class="col-md-4">
                    <div class="card">
                        <img src="https://via.placeholder.com/300" class="card-img-top" alt="Course 1">
                        <div class="card-body">
                            <h5 class="card-title">Khóa Học Lập Trình Java</h5>
                            <p class="card-text">Khóa học Java giúp bạn xây dựng nền tảng vững chắc trong lập trình và phát triển phần mềm.</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card">
                        <img src="https://via.placeholder.com/300" class="card-img-top" alt="Course 2">
                        <div class="card-body">
                            <h5 class="card-title">Khóa Học Cơ Sở Dữ Liệu</h5>
                            <p class="card-text">Khóa học về cơ sở dữ liệu, giúp bạn hiểu rõ về quản lý dữ liệu và tối ưu hóa truy vấn.</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card">
                        <img src="https://via.placeholder.com/300" class="card-img-top" alt="Course 3">
                        <div class="card-body">
                            <h5 class="card-title">Khóa Học Web Development</h5>
                            <p class="card-text">Khóa học phát triển web, cung cấp kỹ năng xây dựng trang web với HTML, CSS, JavaScript và các công nghệ tiên tiến.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- Footer -->
    <footer class="bg-dark text-white text-center py-4">
        <p>&copy; 2024 Khoa Tin Học - Đại học XYZ</p>
    </footer>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-pzjw8f+ua7Kw1TIq0wAqf8c74Vt74edFfJZmd5F40XY0pE0EZf3R8eK0Jx8VJX0m" crossorigin="anonymous"></script>
</body>
</html>
