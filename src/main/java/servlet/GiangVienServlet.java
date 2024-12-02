package servlet;

import dao.GiangVienDAO;
import model.GiangVien;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.SQLException;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;  // Đảm bảo đã thêm Jackson vào build path

public class GiangVienServlet extends HttpServlet {

    private GiangVienDAO giangVienDAO;

    @Override
    public void init() throws ServletException {
        // Khởi tạo GiangVienDAO
        giangVienDAO = new GiangVienDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy danh sách giảng viên và trả về dưới dạng JSON
        response.setContentType("application/json");
        try {
            List<GiangVien> giangViens = giangVienDAO.getAll();
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(response.getOutputStream(), giangViens);
        } catch (SQLException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Nhận dữ liệu giảng viên từ request và thêm vào cơ sở dữ liệu
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        // Đọc dữ liệu JSON từ request body
        ObjectMapper mapper = new ObjectMapper();
        GiangVien giangVien = mapper.readValue(request.getReader(), GiangVien.class);

        try {
            giangVienDAO.addGiangVien(giangVien);
            response.setStatus(HttpServletResponse.SC_CREATED);  // Trả về mã trạng thái 201 (Created)
        } catch (SQLException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Cập nhật giảng viên
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        // Đọc dữ liệu JSON từ request body
        ObjectMapper mapper = new ObjectMapper();
        GiangVien giangVien = mapper.readValue(request.getReader(), GiangVien.class);

        try {
            giangVienDAO.updateGiangVien(giangVien);
            response.setStatus(HttpServletResponse.SC_OK);  // Trả về mã trạng thái 200 (OK)
        } catch (SQLException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Xóa giảng viên theo ID
        String idString = request.getParameter("id");
        if (idString != null) {
            int id = Integer.parseInt(idString);
            try {
                giangVienDAO.deleteGiangVien(id);
                response.setStatus(HttpServletResponse.SC_NO_CONTENT);  // Trả về mã trạng thái 204 (No Content)
            } catch (SQLException e) {
                e.printStackTrace();
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);  // Trả về mã trạng thái 400 (Bad Request)
        }
    }

    @Override
    public void destroy() {
        // Đóng kết nối khi Servlet được hủy
        try {
            if (giangVienDAO != null) {
                giangVienDAO = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
