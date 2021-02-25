<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin Login</title>
    <link rel="stylesheet" href="../css/style.css">
    <script src="../js/jquery-3.5.1.min.js"></script>
    <script src="../js/jquery.validate.min.js"></script>
</head>
<body>
    <div align="center">
        <h1>Bookstore Administration</h1>
        <h2>Admin Login</h2>

        <c:if test="${message != null}">
            <h4><em>${message}</em></h4>
        </c:if>

        <form id="loginForm" action="login" method="post">
            <table>
                <tr>
                    <td>Email:</td>
                    <td><input type="text" name="email" id="email" size="20"></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="password" id="password" size="20"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <button type="submit">Login</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>

    <script type="text/javascript">
        $(document).ready(function(){
            $("#loginForm").validate({
                rules: {
                    email: {
                        required: true,
                        email: true
                    },
                    password: "required"
                },
                messages: {
                    email: {
                        required: "Please enter email",
                        email: "Please enter a valid email address"
                    },
                    password: "Please enter password"
                }
            });
        })
    </script>
</body>
</html>
