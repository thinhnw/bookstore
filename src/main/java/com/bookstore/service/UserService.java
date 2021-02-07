package com.bookstore.service;

import com.bookstore.dao.UserDAO;
import com.bookstore.entity.BookEntity;
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

    private EntityManager entityManager;
    private UserDAO userDAO;
    private HttpServletRequest request;
    private HttpServletResponse response;

    public UserService(EntityManager entityManager,
                       HttpServletRequest request, HttpServletResponse response) {
        this.entityManager = entityManager;
        this.request = request;
        this.response = response;

        userDAO = new UserDAO(entityManager);
    }

    public void listUser() throws ServletException, IOException {
        listUser(null);
    }

    public void listUser(String message) throws ServletException, IOException {

        List<UsersEntity> listUsers = userDAO.listAll();
        request.setAttribute("listUsers", listUsers);

        if (message != null) {
            request.setAttribute("message", message);
        }

        String listPage = "user_list.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(listPage);
        rd.forward(request, response);
    }

    public void createUser() throws IOException, ServletException {

        String email = request.getParameter("email");
        String fullName = request.getParameter("fullname");
        String password = request.getParameter("password");

        UsersEntity existUser = userDAO.findByEmail(email);

        if (existUser != null) {
            String message = "Could not create user. An user with email " + email + " already exists.";
            request.setAttribute("message", message);
            RequestDispatcher rd = request.getRequestDispatcher("message.jsp");
            rd.forward(request, response);
        } else {
            UsersEntity user = new UsersEntity(email, fullName, password);
            userDAO.create(user);
            listUser("New user created successfully!");
        }
    }

    public void editUser() throws ServletException, IOException {

        Integer userId = Integer.parseInt(request.getParameter("id"));
        UsersEntity user = userDAO.get(userId);
        if (user != null) {
            request.setAttribute("user", user);
            String editPage = "user_form.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(editPage);
            rd.forward(request, response);
        } else {
            String message = "Could not find user with " + userId + ".";
            request.setAttribute("message", message);
            RequestDispatcher rd = request.getRequestDispatcher("message.jsp");
            rd.forward(request, response);
        }

    }

    public void updateUser() throws ServletException, IOException {

        Integer userId = Integer.parseInt(request.getParameter("userId"));
        String email = request.getParameter("email");
        String fullName = request.getParameter("fullname");
        String password = request.getParameter("password");

        UsersEntity userById = userDAO.get(userId);
        UsersEntity userByEmail = userDAO.findByEmail(email);

        if (userByEmail != null && userByEmail.getUserId() != userById.getUserId()) {

            String message = "Could not update the user. User with email "
                            + email + " already exists.";
            request.setAttribute("message", message);
            RequestDispatcher rd = request.getRequestDispatcher("message.jsp");
            rd.forward(request, response);
        } else {
            UsersEntity user = new UsersEntity(userId, email, fullName, password);
            userDAO.update(user);

            String message = "User has been updated successfully!";
            listUser(message);
        }

    }

    public void deleteUser() throws ServletException, IOException {

        int userId = Integer.parseInt(request.getParameter("id"));

        UsersEntity user = userDAO.get(userId);
        String message = "User has been deleted successfully";

        if (userId == 1) {
            message = "The default admin user account cannot be deleted.";

            request.setAttribute("message", message);
            request.getRequestDispatcher("message.jsp").forward(request, response);
            return;
        }

        if (user == null) {
            message = "Could not find user with ID " + userId
                    + ", or it might have been deleted by another admin";

            request.setAttribute("message", message);
            request.getRequestDispatcher("message.jsp").forward(request, response);
        } else {
            userDAO.delete(userId);
            listUser(message);
        }
    }
}
