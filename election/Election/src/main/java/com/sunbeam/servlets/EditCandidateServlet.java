package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;



@WebServlet("/editcand")
public class EditCandidateServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idStr= req.getParameter("id");
		int id = Integer.parseInt(idStr);
		Candidate c=null;
		try (CandidateDao candDao=new CandidateDaoImpl()){
			c=candDao.findById(id);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Edit Candidate</title>");
		
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>Edit Candidate</h3>");
		out.println("<form method='post' action='editcand'>");
		
//		out.printf("ID: <input type='text'name='id' value='%d' readonly/>"
//				+ "<br/><br/>", c.getId());
		
		out.printf("<input type='text'name='id' value='%d' />"
				+ "<br/><br/>", c.getId());
		out.printf("NAME: <input type='text'name='name' value='%s' />"
				+ "<br/><br/>", c.getName());
		out.printf("PARTY: <input type='text'name='party' value='%s' />"
				+ "<br/><br/>", c.getParty());
		out.printf("VOTES: <input type='text'name='votes' value='%d' readonly/>"
				+ "<br/><br/>", c.getVotes());
		out.println("<input type='submit' value='Update Candidate'/>");
		out.println("</form>");
		out.println("</body>");
		
		out.println("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idStr= req.getParameter("id");
		int id = Integer.parseInt(idStr);
		String name= req.getParameter("name");
		String party = req.getParameter("party");
		String VotesStr = req.getParameter("votes");
		int votes = Integer.parseInt(VotesStr);
		Candidate c = new Candidate(id, name, party, votes);
		try (CandidateDao candDao = new CandidateDaoImpl()){
			int count = candDao.update(c);
			String msg ="Candidate Edited: "+count;
			req.setAttribute("message", msg);
			RequestDispatcher rd = req.getRequestDispatcher("result");
			rd.forward(req, resp);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}
