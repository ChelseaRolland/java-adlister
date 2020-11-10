package com.codeup.adlister.controllers;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        // TODO: show the registration form
        try {
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // TODO: ensure the submitted information is valid
        // TODO: create a new user based off of the submitted information
        // TODO: if a user was successfully created, send them to their profile
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        boolean validTry = false;

        HttpSession session = request.getSession();
        //session.getAttribute("username") == username;
        boolean testing = DaoFactory.getUsersDao().findByUsername(username) == null;
        System.out.println("testing = " + testing);

        if (request.getMethod().equalsIgnoreCase("post")){
            validTry = DaoFactory.getUsersDao().findByUsername(username) == null;
            System.out.println("validTry = " + validTry);
            if (validTry) {
                User user = new User (
                        2,
                        username,
                        email,
                        password
                );
                DaoFactory.getUsersDao().insert(user);
                response.sendRedirect("/profile");
            }


        }



    }
}
