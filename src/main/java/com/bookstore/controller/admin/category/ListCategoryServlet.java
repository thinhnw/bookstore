package com.bookstore.controller.admin.category;

import com.bookstore.service.CategoryService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ListCategoryServlet", value = "/admin/list_category")
public class ListCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CategoryService categoryService = new CategoryService(request, response);
        categoryService.listCategory();

        String listPage = "category_list.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(listPage);

        rd.forward(request, response);
    }
}