package com.bookstore.controller.frontend;

import com.bookstore.controller.BaseServlet;
import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.CategoryEntity;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet", value = "")
public class HomeServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CategoryDAO categoryDAO = new CategoryDAO(entityManager);
        List<CategoryEntity> listCategory = categoryDAO.listAll();
        request.setAttribute("listCategory", listCategory);

        String homepage = "/frontend/index.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(homepage);
        rd.forward(request, response);
    }

}
