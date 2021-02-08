package com.bookstore.controller.admin.user;

import com.bookstore.controller.BaseServlet;
import com.bookstore.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CreateUserServlet", value = "/admin/create_user")
public class CreateUserServlet extends BaseServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserService userService = new UserService(entityManager, request, response);
        userService.createUser();
    }
}
