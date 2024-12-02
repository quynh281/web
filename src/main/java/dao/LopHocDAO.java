package dao;

import model.LopHoc;
import servlet.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LopHocDAO {
    private Connection conn;

    // Constructor
    public LopHocDAO() {
        this.conn = DBConnection.getConnection();
    }

    // Method to get all LopHoc
    public List<LopHoc> getAll() throws SQLException {
        List<LopHoc> list = new ArrayList<>();
        String query = "SELECT * FROM LopHoc";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                LopHoc lopHoc = new LopHoc(
                        rs.getInt("id"),
                        rs.getString("tenLop"),
                        rs.getString("moTa"),
                        rs.getString("giangVien")
                );
                list.add(lopHoc);
            }
        }
        return list;
    }

    // Method to add a new LopHoc
    public void addLopHoc(LopHoc lopHoc) throws SQLException {
        String query = "INSERT INTO LopHoc (tenLop, moTa, giangVien) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, lopHoc.getTenLop());
            stmt.setString(2, lopHoc.getMoTa());
            stmt.setString(3, lopHoc.getGiangVien());
            stmt.executeUpdate();
        }
    }

    // Method to update an existing LopHoc
    public void updateLopHoc(LopHoc lopHoc) throws SQLException {
        String query = "UPDATE LopHoc SET tenLop = ?, moTa = ?, giangVien = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, lopHoc.getTenLop());
            stmt.setString(2, lopHoc.getMoTa());
            stmt.setString(3, lopHoc.getGiangVien());
            stmt.setInt(4, lopHoc.getId());
            stmt.executeUpdate();
        }
    }
}
