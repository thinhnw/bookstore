<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div align="center">
    <div>
        <img src="images/BookstoreLogo.png" alt="" />
    </div>
    <div>
        <input type="text" name="keyword" size="50">
        <input type="button" value="Search">

        <a href="login">Sign In</a>
        <a href="register">Register</a>
        <a href="view_cart">Cart</a>
    </div>
    <br>
    <div>
        <c:forEach var="ctg" items="${listCategory}">
            <a href="">
                <font size="+1">
                    <b>
                        <c:out value="${ctg.name}" />
                    </b>
                </font>
            </a>
            |
        </c:forEach>
    </div>
</div>