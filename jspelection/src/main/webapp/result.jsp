<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
</head>
<body>
   <h3>${ initParam.appTitle }</h3>
  <jsp:useBean id="res" class="com.sunbeam.beans.CandidateBeans"/>
  ${res.fetchCandidates() }
  <table border="1">
     <thead>
     	<th>ID</th>
     	<th>NAME</th>
     	<th>PARTY</th>
     	<th>VOTES</th>
     	<th>ACTION</th>
     </thead>
     <tbody>
     
     	<c:forEach var="c" items="${res.candidateList }">
     	
     	  <tr>
     	  		<td>${c.id }</td>
     	  		<td>${c.name }</td>
     	  		<td>${c.party }</td>
     	  		<td>${c.votes }</td>
     	  		<td>
     	  		  <a href="editcand.jsp?id=${c.id }">
     	  		    <img alt="Edit" src="images/edit.png" width="24" height="24"/>
     	  		  </a>
     	  		  <a href="deletecand.jsp?id=${c.id }">
     	  		    <img alt="delete" src="images/delete.png" width="24" height="24"/>
     	  		  </a>
     	  		</td>
     	  
     	  </tr>
     	
     	</c:forEach>
     
     </tbody>
     
  
  
  
  </table>
  <br/><br/>
  <a href="logout.jsp">Sign Out</a>
	
</body>
</html>