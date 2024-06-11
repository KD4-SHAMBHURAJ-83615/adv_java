<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="com.sunbeam.beans.CandidateBeans" %>
<%@ page import="com.sunbeam.pojos.Candidate" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Candidates list</title>
</head>
<body>
	
	
	<h3>Online Voting</h3>
	
	Hello, ${lb.user.firstName} ${lb.user.lastName} <hr/>
	<jsp:useBean id="clb" class="com.sunbeam.beans.CandidateBeans"/>
	${ clb.fetchCandidates() }
	<form method="post" action="vote.jsp">
		<c:forEach var="c" items="${clb.candidateList}">
			<input type="radio" name="candidate" value="${c.id}"/> ${c.name} -${c.party}  <br/>
		</c:forEach>
		<br/> <input type="submit" value="Vote"/>
	</form>
   
</body>
</html>