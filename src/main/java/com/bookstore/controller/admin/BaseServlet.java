package com.bookstore.controller.admin;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public abstract class BaseServlet extends HttpServlet {

    protected EntityManagerFactory entityManagerFactory;
    protected EntityManager entityManager;

    @Override
    public void init() throws ServletException {
        super.init();
        entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
        entityManager = entityManagerFactory.createEntityManager();
    }
    @Override
    public void destroy() {
        super.destroy();
        entityManager.close();
        entityManagerFactory.close();
    }

}
