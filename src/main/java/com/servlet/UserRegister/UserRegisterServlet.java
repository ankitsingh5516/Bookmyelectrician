package com.servlet.UserRegister;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/BME/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String address = request.getParameter("address");
        String password = request.getParameter("password");

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        try {
            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bme", "root", "root");

            // Prepare SQL query
            String query = "INSERT INTO user (name, dob, email, mobile, address, password) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, dob);
            ps.setString(3, email);
            ps.setString(4, mobile);
            ps.setString(5, address);
            ps.setString(6, password);

            // Execute update
            int rowCount = ps.executeUpdate();
            if (rowCount > 0) {
                out.println("<h1>User Register Successful!</h1>");
            } else {
                out.println("<h1>Registration Failed!</h1>");
            }

            // Close connection
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h1>Error: " + e.getMessage() + "</h1>");
        }
    }
}

