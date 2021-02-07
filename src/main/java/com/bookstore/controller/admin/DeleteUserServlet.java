package com.bookstore.controller.admin;

import com.bookstore.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteUserServlet", value = "/admin/delete_user")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer userId = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("userId", userId);

        UserService userService = new UserService(request, response);
        userService.deleteUser();
    }
}
