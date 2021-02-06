package com.bookstore.service;

import com.bookstore.dao.UserDAO;
import com.bookstore.entity.UsersEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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

    public List<UsersEntity> listUser() {
        return userDAO.listAll();
    }
}
