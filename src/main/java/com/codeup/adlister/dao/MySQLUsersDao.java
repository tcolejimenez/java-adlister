package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.SQLException;
import java.sql.*;

public class MySQLUsersDao implements Users {
    private Connection connection;

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

    @Override
    public User findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return createUserObj(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Long insert(User user) {
        String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?);";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            ResultSet id = stmt.getGeneratedKeys();
            id.next(); 
            return id.getLong(1);
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public User createUserObj(ResultSet rs) {
        try {
            return new User(rs.getLong("id"), rs.getString("username"), rs.getString("email"), rs.getString("password"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
