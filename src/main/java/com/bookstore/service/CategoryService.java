package com.bookstore.service;

import com.bookstore.dao.CategoryDAO;
import com.bookstore.dao.UserDAO;
import com.bookstore.entity.CategoryEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CategoryService {
    private EntityManager entityManager;
    private CategoryDAO categoryDAO;
    private HttpServletRequest request;
    private HttpServletResponse response;

    public CategoryService(EntityManager entityManager,
                           HttpServletRequest request, HttpServletResponse response) {
        this.entityManager = entityManager;
        this.request = request;
        this.response = response;

        categoryDAO = new CategoryDAO(entityManager);
    }


    public void listCategory() throws ServletException, IOException {
        listCategory(null);
    }

    public void listCategory(String message) throws ServletException, IOException {
        List<CategoryEntity> listCategory = categoryDAO.listAll();
        request.setAttribute("listCategory", listCategory);
        if (message != null) {
            request.setAttribute("message", message);
        }
        RequestDispatcher rd = request.getRequestDispatcher("category_list.jsp");
        rd.forward(request, response);
    }

    public void createCategory() throws ServletException, IOException {
        String name = request.getParameter("name");
        CategoryEntity ctg = categoryDAO.findByName(name);
        if (ctg != null) {
            String message = "Could not create category. This category already exists!";
            request.setAttribute("message", message);
            RequestDispatcher rd = request.getRequestDispatcher("message.jsp");
            rd.forward(request, response);
        } else {
            categoryDAO.create(new CategoryEntity(name));
            String message = "Category created successfully";
            listCategory(message);
        }
    }
}
