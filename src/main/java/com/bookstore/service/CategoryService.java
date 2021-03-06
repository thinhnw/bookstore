package com.bookstore.service;

import com.bookstore.dao.CategoryDAO;
import com.bookstore.dao.UserDAO;
import com.bookstore.entity.CategoryEntity;
import com.bookstore.entity.UsersEntity;

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
        System.out.println(name);
        CategoryEntity ctg = categoryDAO.findByName(name);

        if (ctg != null) {
            String message = "Could not create category. This category already exists!";
            request.setAttribute("message", message);
            RequestDispatcher rd = request.getRequestDispatcher("message.jsp");
            rd.forward(request, response);
        } else {
            CategoryEntity category = new CategoryEntity(name);
            categoryDAO.create(category);
            String message = "Category created successfully";
            listCategory(message);
        }
    }

    public void editCategory() throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        CategoryEntity ctg = categoryDAO.get(id);

        String destPage = "category_form.jsp";

        if (ctg != null) {
            request.setAttribute("category", ctg);
        } else {
            String message = "Could not find category with ID " + id;
            request.setAttribute("message", message);
            destPage = "message.jsp";
        }
        RequestDispatcher rd = request.getRequestDispatcher(destPage);
        rd.forward(request, response);
    }

    public void updateCategory() throws ServletException, IOException {

        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        String categoryName  = request.getParameter("name");

        CategoryEntity categoryById = categoryDAO.get(categoryId);
        CategoryEntity categoryByName = categoryDAO.findByName(categoryName);

        if (categoryById == null) {

            String message = "Could not update category. A category with ID " + categoryId + " no longer exists.";
            request.setAttribute("message", message);
            RequestDispatcher rd = request.getRequestDispatcher("message.jsp");
            rd.forward(request, response);
        }

        if (categoryByName != null && categoryById.getCategoryId() != categoryByName.getCategoryId()) {

            String message = "Could not update category. A category with name " + categoryName + " already exists.";
            request.setAttribute("message", message);
            RequestDispatcher rd = request.getRequestDispatcher("message.jsp");
            rd.forward(request, response);
        } else {
            categoryById.setName(categoryName);
            categoryDAO.update(categoryById);
            String message = "Category has been updated successfully!";
            listCategory(message);
        }

    }

    public void deleteCategory() throws ServletException, IOException {

        int categoryId = Integer.parseInt(request.getParameter("id"));

        CategoryEntity category = categoryDAO.get(categoryId);
        String message = "User has been deleted successfully";

        if (category == null) {
            message = "Could not find category with ID " + categoryId
                    + ", or it might have been deleted by another admin";

            request.setAttribute("message", message);
            request.getRequestDispatcher("message.jsp").forward(request, response);
        } else {
            categoryDAO.delete(categoryId);
            listCategory(message);
        }
    }

}
