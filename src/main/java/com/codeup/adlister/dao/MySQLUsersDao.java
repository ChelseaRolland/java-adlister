package com.codeup.adlister.dao;

import com.codeup.adlister.Config;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLUsersDao implements Users {
    private Connection connection = null;


    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    public User findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username LIKE ?";
        String searchWithWildcards = "%" + username + "%";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, searchWithWildcards);
            ResultSet rs = stmt.executeQuery();
            return extractUser(rs);

        } catch (SQLException e) {
            throw new RuntimeException("Error in finding user.", e);
        }
    };

    public Long insert(User user){
        try {
            PreparedStatement stmt = connection.prepareStatement(createInsertQuery(user), Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);

        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new user.", e);
        }
    };

    private String createInsertQuery(User user) {
        return "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
    }

    private User extractUser(ResultSet rs) throws SQLException {
        return new User(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password")
        );
    }

    private List<User> createUserFromResults(ResultSet rs) throws SQLException {
        List<User> users = new ArrayList<>();
        while (rs.next()) {
            users.add(extractUser(rs));
        }
        return users;
    }

}
