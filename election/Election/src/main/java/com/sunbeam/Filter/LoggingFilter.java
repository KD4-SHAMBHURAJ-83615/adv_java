package com.sunbeam.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;



public class LoggingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest rq = (HttpServletRequest) req;
		System.out.println("Log BEFORE: " + rq.getRequestURI());
		chain.doFilter(req, resp);
		System.out.println("Log AFTER: " + rq.getRequestURI());		
		
	}

}
