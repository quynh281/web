package dao;

import model.Member;
import java.sql.*;
import java.util.*;

public class MemberDAO {

    // Kết nối với cơ sở dữ liệu
    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/khoatinhoc";  // Đổi với tên cơ sở dữ liệu của bạn
        String username = "root";  // Tên người dùng MySQL
        String password = "28112004";  // Mật khẩu MySQL
        return DriverManager.getConnection(url, username, password);
    }

    // Lấy danh sách tất cả thành viên
    public List<Member> getAllMembers() {
        List<Member> members = new ArrayList<>();
        String sql = "SELECT * FROM Members";  // Câu lệnh SQL truy vấn dữ liệu từ bảng Members

        // Sử dụng try-with-resources để tự động đóng kết nối, statement và resultset
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                // Đọc dữ liệu từ ResultSet và tạo đối tượng Member
                Member member = new Member();
                member.setId(rs.getInt("id"));
                member.setName(rs.getString("name"));
                member.setTitle(rs.getString("title"));
                member.setEmail(rs.getString("email"));
                member.setDepartment(rs.getString("department"));
                member.setImageUrl(rs.getString("image_url"));
                members.add(member);  // Thêm vào danh sách
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Xử lý lỗi nếu có
        }
        return members;  // Trả về danh sách thành viên
    }
}
