package com.bookstore.service;

import com.bookstore.dao.UserDAO;
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

public class UserService {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private UserDAO userDAO;

    public UserService() {
        entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
        entityManager = entityManagerFactory.createEntityManager();
        userDAO = new UserDAO(entityManager);
    }

    public void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<UsersEntity> listUsers = userDAO.listAll();
        request.setAttribute("listUsers", listUsers);

        String listPage = "user_list.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(listPage);
        rd.forward(request, response);
    }

    public void createUser(String email, String fullName, String password) {

        UsersEntity user = new UsersEntity(email, fullName, password);
        userDAO.create(user);
    }
}
