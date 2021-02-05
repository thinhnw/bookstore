package com.bookstore.controller.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminHomeServlet", value = "/admin/")
public class AdminHomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String homepage = "/admin/index.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(homepage);
        rd.forward(request, response);

    }

}