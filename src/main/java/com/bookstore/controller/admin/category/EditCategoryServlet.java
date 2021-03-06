package com.bookstore.controller.admin.category;

import com.bookstore.controller.BaseServlet;
import com.bookstore.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditCategoryServlet", value = "/admin/edit_category")
public class EditCategoryServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CategoryService categoryService = new CategoryService(entityManager, request, response);
        categoryService.editCategory();
        response.getWriter().println("Edit category with ID of " + request.getParameter("id"));
    }
}
