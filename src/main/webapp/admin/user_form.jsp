<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create New User</title>
</head>
<body>
<jsp:include page="header.jsp" />

<div align="center">
    <h2>Create New User</h2>
</div>
<div align="center">
    <form action="create_user" method="post" onsubmit="return validateFormInput()">
        <table>
            <tr>
                <td>Email:</td>
                <td><input type="email" id="email" name="email" size="20" required /></td>
            </tr>
            <tr>
                <td>Full Name:</td>
                <td><input type="text" id="fullname" name="fullname" size="20" required /></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" id="password" name="password" size="20" required/></td>
            </tr>
            <tr><td>&nbsp;</td></tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save">
                    <input type="button" value="Cancel" onclick="javascript:history.go(-1);">
                </td>
            </tr>
        </table>
    </form>
</div>
<jsp:include page="footer.jsp" />
</body>
<script type="text/javascript">
    function validateFormInput() {
        let fieldEmail = document.getElementById("email");
        let fieldFullname = document.getElementById("fullname");
        let fieldPassword = document.getElementById("password");

        if (fieldEmail.value.length === 0) {
            alert("Email is required!");
            fieldEmail.focus();
            return false;
        }
        if (fieldFullname.value.length === 0) {
            alert("Full Name is required!");
            fieldFullname.focus();
            return false;
        }
        if (fieldPassword.value.length === 0) {
            alert("Password is required!");
            fieldPassword.focus();
            return false;
        }
        return true;
    }
</script>
</html>
