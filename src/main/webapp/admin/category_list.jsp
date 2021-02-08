<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Manage Categories - Evergreen Bookstore Administration</title>
    <link rel="stylesheet" href="../css/style.css">
    <script src="../js/jquery-3.5.1.min.js"></script>
    <script src="../js/jquery.validate.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp" />

<div align="center">
    <h2>Category Management</h2>
    <a href="category_form.jsp">Create New Category</a>

    <c:if test="${message != null}">
        <h4><em>${message}</em></h4>
    </c:if>

    <table border="1" cellpadding="5">
        <tr>
            <th>Index</th>
            <th>ID</th>
            <th>Name</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="ctg" items="${listCategory}" varStatus="status">
            <tr>
                <td>${status.index+1}</td>
                <td>${ctg.categoryId}</td>
                <td>${ctg.name}</td>
                <td>
                    <a href="edit_category?id=${ctg.categoryId}">Edit</a>
                    |
                    <a href="javascript:void(0)" class="delete_link" id="${ctg.categoryId}">Delete</a>
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
                let ctgId = $(this).attr("id");
                if (confirm('Are you sure you want to delete the category with ID ' + ctgId + ' ?')) {
                    window.location = 'delete_category?id=' + ctgId;
                }
            })
        })
    })
</script>
</body>
</html>
