package com.bookstore.controller.admin.category;

import com.bookstore.controller.BaseServlet;
import com.bookstore.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteCategoryServlet", value = "/admin/delete_category")
public class DeleteCategoryServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CategoryService categoryService = new CategoryService(entityManager, request, response);
        categoryService.deleteCategory();
    }
}
