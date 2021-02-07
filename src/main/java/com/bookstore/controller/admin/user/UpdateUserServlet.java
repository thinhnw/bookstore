package com.bookstore.controller.admin.user;

import com.bookstore.controller.admin.BaseServlet;
import com.bookstore.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateUserServlet", value = "/admin/update_user")
public class UpdateUserServlet extends BaseServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserService userService = new UserService(entityManager, request, response);
        userService.updateUser();
    }
}
