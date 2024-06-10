<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Jsx syntax</title>
</head>
<body>
	<h1>JSP SYNTAX DEMO</h1>
	<!--Html comment-->
	<%--jsp comment --%>
	
	<%!
	
	int count =0;
	 public void jspInit(){
		 System.out.println("demo1 jspInit() called.");
	 }
	 
	 public void jspdestroy(){
		 System.out.println("demo1 jspdestroy() called.");
	 }
	%>
	
	<% 
	Date now = new Date();
	out.println("Server time: "+ now);
	%>
	
	<br/><br/>
	
	<%count++; %>
	
	<%  if(count % 2 == 0){%>
	Even Count: <%=count %>
	<%}else{ %>
	Odd count: <%=count %>
	<%} %>
	
	<br/><br/>
	
	
	<%
	 if (count %2 ==0){
		 out.println("Even count: "+count);
	 }else{
		 out.println("Odd count: "+count);
	 }
	%>
	
	
	
	
	
</body>
</html>