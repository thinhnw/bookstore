<%--
  Created by IntelliJ IDEA.
  User: thinhnw
  Date: 04/02/2021
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <jsp:include page="header.jsp" />
    <div>
        <h2>Please Login:</h2>
        <form action="">
            Email: <input type="text" size="10" /><br/>
            Password: <input type="password" size="16" /><br/>
            <input type="submit" value="Login" />
        </form>
    </div>
    <jsp:include page="footer.jsp" />
</body>
</html>
