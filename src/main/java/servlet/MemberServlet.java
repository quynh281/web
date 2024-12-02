package servlet;

import java.io.IOException;
import java.util.*;
import jakarta.servlet.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Member;
import dao.MemberDAO;
@WebServlet("/Member")
public class MemberServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MemberDAO memberDAO = new MemberDAO();
        List<Member> members = memberDAO.getAllMembers();
     // Truyền danh sách members vào request
        request.setAttribute("Members", members);
        // Nhóm thành viên theo department
        Map<String, List<Member>> groupedMembers = new LinkedHashMap<>();
        for (Member member : members) {
            groupedMembers.computeIfAbsent(member.getDepartment(), k -> new ArrayList<>()).add(member);
        }

        // Chuẩn bị dữ liệu để gửi sang JSP
        List<Map.Entry<String, List<Member>>> groupedMembersList = new ArrayList<>(groupedMembers.entrySet());
        request.setAttribute("groupedMembers", groupedMembersList);
        
        System.out.println( groupedMembers);

        // Forward tới trang JSP
        request.getRequestDispatcher("cocautochuc.jsp").forward(request, response);
    }
}
