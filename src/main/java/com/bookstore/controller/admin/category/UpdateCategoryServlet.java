package com.bookstore.controller.admin.category;

import com.bookstore.controller.admin.BaseServlet;
import com.bookstore.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateCategoryServlet", value = "/admin/update_category")
public class UpdateCategoryServlet extends BaseServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CategoryService categoryService = new CategoryService(entityManager, request, response);
        categoryService.updateCategory();
    }
}
