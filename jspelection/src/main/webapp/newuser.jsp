<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
     <h3>${ initParam.appTitle }</h3>
   <form method="post" action=" register.jsp">
   First Name: <input type="text" name="firstname"> <br/><br/>
   last name: <input type="text" name="lastname"> <br/><br/>
    Date of Birth: <input type="date" name="date"> <br/><br/>
   email: <input type="text" name="email"> <br/><br/>
   Password: <input type="password" name="password">  <br/><br/>
  
  <input type="submit" value="Register"/>
  <a href="index.jsp">Sign In</a>
   </form>
</body>
</html>