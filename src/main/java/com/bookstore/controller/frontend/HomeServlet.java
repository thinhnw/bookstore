package com.bookstore.controller.frontend;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "HomeServlet", value = "/HomeServlet")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String homepage = "frontend/index.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(homepage);
        rd.forward(request, response);
    }

}
