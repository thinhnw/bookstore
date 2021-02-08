<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Manage Users - Evergreen Bookstore Administration</title>
    <link rel="stylesheet" href="../css/style.css">
    <script src="../js/jquery-3.5.1.min.js"></script>
    <script src="../js/jquery.validate.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp" />

<div align="center">
    <h2>Users Management</h2>
    <a href="user_form.jsp">Create New User</a>

    <c:if test="${message != null}">
        <h4><em>${message}</em></h4>
    </c:if>

    <table border="1" cellpadding="5">
        <tr>
            <th>Index</th>
            <th>ID</th>
            <th>Email</th>
            <th>Full Name</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="user" items="${listUsers}" varStatus="status">
            <tr>
                <td>${status.index+1}</td>
                <td>${user.userId}</td>
                <td>${user.email}</td>
                <td>${user.fullName}</td>
                <td>
                    <a href="edit_user?id=${user.userId}">Edit</a>
                    |
<%--                    <a href="delete_user?id=${user.userId}" onclick="">Delete</a>--%>
                    <a href="javascript:void(0)" class="delete_link" id="${user.userId}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<jsp:include page="footer.jsp" />
<script>
    $(document).ready(function() {
        $(".delete_link").each(function() {
            $(this).on("click", function() {
                let userId = $(this).attr("id");
                if (confirm('Are you sure you want to delete the use with ID ' + userId + ' ?')) {
                    window.location = 'delete_user?id=' + userId;
                }
            });
        })
    })
</script>
</body>
</html>
