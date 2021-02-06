<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Evergreen Bookstore Administration</title>
</head>
<body>
    <jsp:include page="header.jsp" />

    <div align="center">
        <h2>Administrative Dashboard</h2>
    </div>
    <div align="center">
        <hr/>
        <h2>Quick Actions</h2>
        <a href="create_book">New Book</a>
        <a href="create_user">New User</a>
        <a href="create_category">New Category</a>
        <a href="create_customer">New Customer</a>
    </div>

    <div>
        <hr/>
        <h2>Recent Sales</h2>
    </div>

    <div>
        <hr/>
        <h2>Recent Reviews</h2>
    </div>
    <div>
        <hr/>
        <h2>Statistics</h2>
        <hr/>
    </div>
    <jsp:include page="footer.jsp" />
</body>
</html>
