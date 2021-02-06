package com.bookstore.controller.admin;

import com.bookstore.entity.UsersEntity;
import com.bookstore.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListUserServlet", value = "/admin/list_users")
public class ListUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserService userService = new UserService();
        List<UsersEntity> listUsers = userService.listUser();
        request.setAttribute("listUsers", listUsers);

        String listPage = "user_list.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(listPage);
        rd.forward(request, response);
    }

}
