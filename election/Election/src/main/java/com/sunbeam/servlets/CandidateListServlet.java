package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.Candidate;
import com.sunbeam.pojos.User;

public class CandidateListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processResqust(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processResqust(req, resp);	
	}
	
	
protected void processResqust(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Candidate> list =new ArrayList<Candidate>();
		try(CandidateDao candDao = new CandidateDaoImpl()){
			list = candDao.findAll();			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>candidates</title>");
		
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>Online Voting</h3>");
		out.println("<form method='post'  action='vote'>" );
		for (Candidate c : list) {
			
			out.printf("<input type='radio' name='candidate' value='%d'/> %s (%s) <br/>\n",+
					c.getId(),c.getName(),c.getParty());
		
		}
		out.println("<input type='submit' value='vote'/>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
		
	}

}