package com.bookstore.controller.admin.user;

import com.bookstore.controller.BaseServlet;
import com.bookstore.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ListUserServlet", value = "/admin/list_users")
public class ListUserServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserService userService = new UserService(entityManager, request, response);
        userService.listUser();
    }

}
