package com.bookstore.controller.admin;

import com.bookstore.controller.BaseServlet;
import com.bookstore.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminLoginServlet", value = "/admin/login")
public class AdminLoginServlet extends BaseServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserService userService = new UserService(entityManager, request, response);
        userService.login();
    }
}
