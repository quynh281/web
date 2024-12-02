package servlet;

import model.ChuongTrinhDaoTao;
import dao.ChuongTrinhDaoTaoDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/chuong-trinh-dao-tao")
public class ChuongTrinhDaoTaoServlet extends HttpServlet {
    private ChuongTrinhDaoTaoDAO chuongTrinhDaoTaoDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        // Initialize ChuongTrinhDaoTaoDAO
        chuongTrinhDaoTaoDAO = new ChuongTrinhDaoTaoDAO();
    }

    // DoGET method to display all ChuongTrinhDaoTao records
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<ChuongTrinhDaoTao> chuongTrinhDaoTaoList = chuongTrinhDaoTaoDAO.getAll();
            request.setAttribute("chuongTrinhDaoTaoList", chuongTrinhDaoTaoList);
            request.getRequestDispatcher("/viewChuongTrinhDaoTao.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error fetching data.");
        }
    }

    // DoPOST method to handle add/update operations for ChuongTrinhDaoTao
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            if ("add".equals(action)) {
                addChuongTrinhDaoTao(request, response);
            } else if ("update".equals(action)) {
                updateChuongTrinhDaoTao(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error processing data.");
        }
    }

    // Method to handle adding new ChuongTrinhDaoTao
    private void addChuongTrinhDaoTao(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String ten = request.getParameter("ten");
        String moTa = request.getParameter("moTa");

        ChuongTrinhDaoTao chuongTrinhDaoTao = new ChuongTrinhDaoTao(0, ten, moTa);
        chuongTrinhDaoTaoDAO.addChuongTrinhDaoTao(chuongTrinhDaoTao);

        response.sendRedirect(request.getContextPath() + "/chuong-trinh-dao-tao");
    }

    // Method to handle updating ChuongTrinhDaoTao
    private void updateChuongTrinhDaoTao(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String ten = request.getParameter("ten");
        String moTa = request.getParameter("moTa");

        ChuongTrinhDaoTao chuongTrinhDaoTao = new ChuongTrinhDaoTao(id, ten, moTa);
        chuongTrinhDaoTaoDAO.updateChuongTrinhDaoTao(chuongTrinhDaoTao);

        response.sendRedirect(request.getContextPath() + "/chuong-trinh-dao-tao");
    }
}
