package servlet;

import dao.LopHocDAO;
import model.LopHoc;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/lop-hoc")
public class LopHocServlet extends HttpServlet {
    private LopHocDAO lopHocDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        // Initialize LopHocDAO
        lopHocDAO = new LopHocDAO();
    }

    // DoGET method to display all LopHoc records
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<LopHoc> lopHocList = lopHocDAO.getAll();
            request.setAttribute("lopHocList", lopHocList);
            request.getRequestDispatcher("/viewLopHoc.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error fetching data.");
        }
    }

    // DoPOST method to handle add/update operations for LopHoc
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            if ("add".equals(action)) {
                addLopHoc(request, response);
            } else if ("update".equals(action)) {
                updateLopHoc(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error processing data.");
        }
    }

    // Method to handle adding new LopHoc
    private void addLopHoc(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String tenLop = request.getParameter("tenLop");
        String moTa = request.getParameter("moTa");
        String giangVien = request.getParameter("giangVien");

        LopHoc lopHoc = new LopHoc(0, tenLop, moTa, giangVien);
        lopHocDAO.addLopHoc(lopHoc);

        response.sendRedirect(request.getContextPath() + "/lop-hoc");
    }

    // Method to handle updating LopHoc
    private void updateLopHoc(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String tenLop = request.getParameter("tenLop");
        String moTa = request.getParameter("moTa");
        String giangVien = request.getParameter("giangVien");

        LopHoc lopHoc = new LopHoc(id, tenLop, moTa, giangVien);
        lopHocDAO.updateLopHoc(lopHoc);

        response.sendRedirect(request.getContextPath() + "/lop-hoc");
    }
}
