package com.sunbeam.servlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;


@WebServlet("/register")
public class RegistrationServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fname= req.getParameter("fname");
		String lname= req.getParameter("lname");
		String strDob= req.getParameter("dob");
		Date birth = Date.valueOf(strDob);
		String email= req.getParameter("email");
		String passwd= req.getParameter("passwd");
		String role = "voter";
		
				
		try (UserDao userDao = new UserDaoImpl()){
			
			User user = new User();
			user.setFirstName(fname);
			user.setLastName(fname);
			user.setBirth(birth);
			user.setEmail(email);
			user.setPassword(passwd);
			user.setRole(role);
			int saved= userDao.save(user);
			resp.sendRedirect("index.html");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}
