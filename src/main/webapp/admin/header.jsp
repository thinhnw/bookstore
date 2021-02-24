<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div align="center">
    <div>
        <img src="../images/BookstoreAdminLogo.png" alt="Bookstore Admin Logo">
    </div>
    <div>
        Welcome, <c:out value="${sessionScope.userEmail}" /> | <a href="logout">Logout</a>
    </div>
    <div id="header_menu">
        <div>
            <a href="list_users">
                <img src="../images/users.png" alt="">
                <br>
                Users
            </a>
        </div>
        <div>
            <a href="list_category">
                <img src="../images/category.png" alt="">
                <br>
                Categories
            </a>
        </div>
        <div>
            <a href="books">
                <img src="../images/bookstack.png" alt="">
                <br>
                Books
            </a>
        </div>
        <div>
            <a href="customer">
                <img src="../images/customer.png" alt="">
                <br>
                Customers
            </a>
        </div>
        <div>
            <a href="reviews">
                <img src="../images/review.png" alt="">
                <br>
                Reviews
            </a>
        </div>
        <div>
            <a href="orders">
                <img src="../images/order.png" alt="">
                <br>
                Orders
            </a>
        </div>
    </div>
</div>