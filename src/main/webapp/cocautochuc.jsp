<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="model.Member" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cơ cấu tổ chức</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center mb-4">Cơ cấu tổ chức</h1>

        <%
            // Lấy danh sách thành viên đã nhóm từ Servlet
            List<Map.Entry<String, List<Member>>> groupedMembers = 
                (List<Map.Entry<String, List<Member>>>) request.getAttribute("groupedMembers");
            if (groupedMembers != null) {
                for (Map.Entry<String, List<Member>> group : groupedMembers) {
        %>
            <!-- Hiển thị tên nhóm (department) -->
            <h3><%= group.getKey() %></h3>
            <div class="row">
                <%
                    List<Member> members = group.getValue();
                    for (Member member : members) {
                %>
                    <div class="col-md-4 mb-4">
                        <div class="card">
                            <img src="<%= member.getImageUrl() %>" class="card-img-top" alt="<%= member.getName() %>">
                            <div class="card-body">
                                <h5 class="card-title"><%= member.getName() %></h5>
                                <p class="card-text"><%= member.getTitle() %></p>
                                <p class="card-text"><small class="text-muted"><%= member.getEmail() %></small></p>
                            </div>
                        </div>
                    </div>
                <%
                    }
                %>
            </div>
        <%
                }
            } else {
        %>
            <p class="text-center">Không có dữ liệu.</p>
        <%
            }
        %>
    </div>
</body>
</html>
