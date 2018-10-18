package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet  {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: show the registration form
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // TODO: ensure the submitted information is valid


        //after getting form, save inputs
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //validate inputs
        if ((email.indexOf('@') == -1) || (!email.substring(email.length() - 4).equals(".com") &&
                !email.substring(email.length() - 4).equals(".net") &&
                !email.substring(email.length() - 4).equals(".org"))) {
            System.out.println(email.substring(email.length() - 4));
            response.sendRedirect("/register");
            System.out.println("Failed email domain test...");
            return;
        }
//
//        if (username.contains("%") || username.contains("&") || username.contains("(") || username.contains(")")) {
//            response.sendRedirect("/register");
//            System.out.println("Failed username test...");
//
//            return;
//        }
//        if (password.equals(username)) {
//            response.sendRedirect("/register");
//            System.out.println("Failed password test...");
//
//            return;
//        }

        response.sendRedirect("/login");

        // TODO: create a new user based off of the submitted information
        DaoFactory.getUsersDao().insert(new User(username, email, password));

        // TODO: if a user was successfully created, send them to their profile
    }
}
