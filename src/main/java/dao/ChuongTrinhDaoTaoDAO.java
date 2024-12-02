package dao;

import model.ChuongTrinhDaoTao;
import servlet.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChuongTrinhDaoTaoDAO {
    private Connection conn;

    // Constructor
    public ChuongTrinhDaoTaoDAO() {
        this.conn = DBConnection.getConnection();
    }

    // Phương thức lấy tất cả chương trình đào tạo
    public List<ChuongTrinhDaoTao> getAll() throws SQLException {
        List<ChuongTrinhDaoTao> list = new ArrayList<>();
        String query = "SELECT * FROM ChuongTrinhDaoTao";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                ChuongTrinhDaoTao chuongTrinhDaoTao = new ChuongTrinhDaoTao(
                        rs.getInt("id"),
                        rs.getString("ten"),
                        rs.getString("moTa")
                );
                list.add(chuongTrinhDaoTao);
            }
        }
        return list;
    }

    // Phương thức thêm chương trình đào tạo
    public void addChuongTrinhDaoTao(ChuongTrinhDaoTao chuongTrinhDaoTao) throws SQLException {
        String query = "INSERT INTO ChuongTrinhDaoTao (ten, moTa) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, chuongTrinhDaoTao.getTen());
            stmt.setString(2, chuongTrinhDaoTao.getMoTa());
            stmt.executeUpdate();
        }
    }

    // Phương thức cập nhật chương trình đào tạo
    public void updateChuongTrinhDaoTao(ChuongTrinhDaoTao chuongTrinhDaoTao) throws SQLException {
        String query = "UPDATE ChuongTrinhDaoTao SET ten = ?, moTa = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, chuongTrinhDaoTao.getTen());
            stmt.setString(2, chuongTrinhDaoTao.getMoTa());
            stmt.setInt(3, chuongTrinhDaoTao.getId());
            stmt.executeUpdate();
        }
    }
}
