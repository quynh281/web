package dao;

import model.GiangVien;
import servlet.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GiangVienDAO {
    private Connection conn;

    // Constructor sử dụng kết nối từ DBConnection
    public GiangVienDAO() {
        this.conn = DBConnection.getConnection(); // Kết nối CSDL
        if (this.conn == null) {
            System.out.println("Failed to establish database connection.");
        }
    }

    // Hàm lấy danh sách giảng viên
    public List<GiangVien> getAll() throws SQLException {
        String query = "SELECT * FROM GiangVien";
        List<GiangVien> list = new ArrayList<>();
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                list.add(new GiangVien(
                        rs.getInt("id"),
                        rs.getString("ten"),
                        rs.getString("chucDanh"),
                        rs.getString("email"),
                        rs.getString("soDienThoai")
                ));
            }
        }
        return list;
    }

    // Hàm thêm giảng viên
    public void addGiangVien(GiangVien giangVien) throws SQLException {
        String query = "INSERT INTO GiangVien (ten, chucDanh, email, soDienThoai) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, giangVien.getTen());
            stmt.setString(2, giangVien.getChucDanh());
            stmt.setString(3, giangVien.getEmail());
            stmt.setString(4, giangVien.getSoDienThoai());
            stmt.executeUpdate();
        }
    }

    // Hàm cập nhật giảng viên
    public void updateGiangVien(GiangVien giangVien) throws SQLException {
        String query = "UPDATE GiangVien SET ten = ?, chucDanh = ?, email = ?, soDienThoai = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, giangVien.getTen());
            stmt.setString(2, giangVien.getChucDanh());
            stmt.setString(3, giangVien.getEmail());
            stmt.setString(4, giangVien.getSoDienThoai());
            stmt.setInt(5, giangVien.getId());
            stmt.executeUpdate();
        }
    }

    // Hàm xóa giảng viên
    public void deleteGiangVien(int id) throws SQLException {
        String query = "DELETE FROM GiangVien WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
