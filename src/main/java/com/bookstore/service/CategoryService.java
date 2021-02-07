package com.bookstore.service;

import com.bookstore.dao.CategoryDAO;
import com.bookstore.dao.UserDAO;
import com.bookstore.entity.CategoryEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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


    public void listCategory() {
        List<CategoryEntity> listCategory = categoryDAO.listAll();
        request.setAttribute("listCategory", listCategory);

    }
}
