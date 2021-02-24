<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:if test="${user != null}">
        <title>Edit User</title>
    </c:if>
    <c:if test="${user == null}">
        <title>Create New User</title>
    </c:if>
    <link rel="stylesheet" href="../css/style.css">
    <script src="../js/jquery-3.5.1.min.js"></script>
    <script src="../js/jquery.validate.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp" />

<div align="center">
    <h2>
        <c:if test="${user != null}">
            Edit User
        </c:if>
        <c:if test="${user == null}">
            Create New User
        </c:if>
    </h2>
</div>
<div align="center">
    <c:if test="${user != null}">
        <c:set var="formAction" value="update_user"/>
    </c:if>
    <c:if test="${user == null}">
        <c:set var="formAction" value="create_user"/>
    </c:if>
    <form action="${formAction}" method="post" id="user_form">

        <c:if test="${user != null}">
            <input type="hidden" name="userId" value="${user.userId}">
        </c:if>
        <table>
            <tr>
                <td>Email:</td>
                <td>
                    <input type="email"
                           id="email"
                           name="email"
                           size="20"
                           value="${user.email}"
                           />
                </td>
            </tr>
            <tr>
                <td>Full Name:</td>
                <td>
                    <input type="text"
                           id="fullname"
                           name="fullname"
                           size="20"
                           value="${user.fullName}"
                            /js>
                </td>
            </tr>
            <tr>
                <td>Password:</td>
                <td>
                    <input type="password"
                           id="password"
                           name="password"
                           size="20"
                           value="${user.password}"
                           />
                </td>
            </tr>
            <tr><td>&nbsp;</td></tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save">
                    <input type="button" value="Cancel" id="cancel">
                </td>
            </tr>
        </table>
    </form>
    <script src="../js/main.js"></script>
</div>
<jsp:include page="footer.jsp" />

<script type="text/javascript">
    $(document).ready(function(){
        $("#user_form").validate({
            rules: {
                email: {
                    required: true,
                    email: true
                },
                fullname: "required",
                password: "required"
            },
            messages: {
                email: {
                    required: "Please enter email",
                    email: "Please enter a valid email address"
                },
                fullname: "Please enter full name",
                password: "Please enter password"
            }
        });
        $("#cancel").click(function() {
            history.go(-1);
        })
    })
</script>
</body>
</html>
