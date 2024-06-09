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
import com.sunbeam.pojos.Candidate;

public class NomineListServlet extends HttpServlet {

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
		out.println("<h3>Nomine</h3>");
		out.println("<table>");
		out.println("<tr>"
				+ "<td><b> ID </b></td>"
				+ "<td><b> Name </b></td>"
				+"<td><b> Party Name </b></td>"
				+ "<td><b> Votes </b></td>"
				+ "</tr>");
		
		for (Candidate c : list) {
			
			
			out.printf("<tr>"
					+ "<td>%d</td> "
					+ "<td>%s</td> "
					+ "<td>%s</td>"
					+ "<td>%d</td> "
					+ "</tr> ",+
					c.getId(),c.getName(),c.getParty(),c.getVotes());
		
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		
		
	}
}
