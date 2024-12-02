package servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() {
        try {
            // Thay thế các thông tin kết nối phù hợp với cơ sở dữ liệu của bạn
            String url = "jdbc:mysql://localhost:3306/3011";  // URL của cơ sở dữ liệu
            String username = "root";  // Tên người dùng
            String password = "28112004";  // Mật khẩu

            // Tải driver MySQL nếu cần
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Trả về kết nối
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;  // Trả về null nếu kết nối thất bại
        }
    }
}
