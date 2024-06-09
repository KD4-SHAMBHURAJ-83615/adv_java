package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processResqust(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processResqust(req, resp);	
	}
	
	
protected void processResqust(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String passwd = req.getParameter("passwd");
		try (UserDao userDao = new UserDaoImpl()){
			User user = userDao.findByEmail(email);
			if (user!=null && user.getPassword().equals(passwd) ) {
				//login successfully
				if(user.getRole().equals("voter")) {
					resp.sendRedirect("candlist");
					
					
				}else if (user.getRole().equals("admin")) {
					resp.sendRedirect("nomine");
					}
				
				
				else {
					resp.sendRedirect("result");
				}
				
				
				
			}
			else {
				//login failed
				resp.setContentType("text/html");
				PrintWriter out = resp.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Login Failed</title>");
				out.println("</head>");
				out.println("<body>");
				
				out.println("Invalid email or password </br> </br>");
				out.println("<a href='index.html'>Login Again</a>");
				out.println("</body>");
				out.println("</html>");
			}
		} catch (Exception e) {
             e.printStackTrace();
             throw new ServletException(e);
		}
	}

}
