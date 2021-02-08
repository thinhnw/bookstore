<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:if test="${category != null}">
        <title>Edit Category</title>
    </c:if>
    <c:if test="${category == null}">
        <title>Create New Category</title>
    </c:if>
</head>
<body>
<jsp:include page="header.jsp" />

<div align="center">
    <h2>
        <c:if test="${category != null}">
            Edit Category
        </c:if>
        <c:if test="${category == null}">
            Create New Category
        </c:if>
    </h2>
</div>
<div align="center">
    <c:if test="${category != null}">
        <c:set var="formAction" value="update_category"/>
    </c:if>
    <c:if test="${category == null}">
        <c:set var="formAction" value="create_category"/>
    </c:if>
    <form action="${formAction}" method="post" onsubmit="return validateFormInput()">

        <c:if test="${category != null}">
            <input type="hidden" name="categoryId" value="${category.categoryId}">
        </c:if>
        <table>
            <tr>
                <td>Name:</td>
                <td>
                    <input type="text"
                           id="name"
                           name="name"
                           size="20"
                           value="${category.name}"
                           required />
                </td>
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
        let fieldName = document.getElementById("name");

        if (fieldName.value.length === 0) {
            alert("Name is required!");
            fieldName.focus();
            return false;
        }
        return true;
    }
</script>
</html>
