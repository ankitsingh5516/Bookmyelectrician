package com.servlet.query;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/QueryServlet")
public class QueryServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final String INSERT_QUERY = "INSERT INTO QUERY(NAME, MOBILE, EMAIL, MESSAGE) VALUES(?,?,?,?)";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//read value
		String name=req.getParameter("name");
		String mobile=req.getParameter("mobile");
		String email=req.getParameter("email");
		String message=req.getParameter("message");
		
		// load jdbc driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// create the connection
		try{
			Connection con=DriverManager.getConnection("jdbc:mysql:///bme","root","root");
				PreparedStatement ps=con.prepareStatement(INSERT_QUERY);{
						ps.setString(1,name);
						ps.setString(2, mobile);
						ps.setString(3, email);
						ps.setString(4, message);
				
					}
				int count=ps.executeUpdate();
				if(count==0) {
					pw.println("Your Query is not Submit due to technical issue..");
				}else {
					pw.println("Your Query Submited Sucessfully..");
					
				}
		}catch(SQLException se) {
			pw.println(se.getMessage());
			se.printStackTrace();
			
		}catch(Exception e){
			pw.println(e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("Name- "+name +" Mobile no- " +mobile+" email- " +email +" messege- "+message);
		pw.close();
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//read value
		String name=req.getParameter("name");
		String mobile=req.getParameter("mobile");
		String email=req.getParameter("email");
		String messege=req.getParameter("messege");
		
		// load jdbc driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// create the connection
		try{
			Connection con=DriverManager.getConnection("jdbc:mysql:///bme","root","root");
				PreparedStatement ps=con.prepareStatement(INSERT_QUERY);{
						ps.setString(1,name);
						ps.setString(2, mobile);
						ps.setString(3, email);
						ps.setString(4, messege);
				
					}
				int count=ps.executeUpdate();
				if(count==0) {
					pw.println("Your Query is not Submit due to technical issue..");
				}else {
					pw.println("Your Query Submited Sucessfully..");
					
				}
		}catch(SQLException se) {
			pw.println(se.getMessage());
			se.printStackTrace();
			
		}catch(Exception e){
			pw.println(e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("Name- "+name +" Mobile no- " +mobile+" email- " +email +" messege- "+messege);
		pw.close();
		
		

	}
	

}
