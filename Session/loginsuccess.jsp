<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Login Success Page</title>
</head>
<body>
<%
//allow access only if session exists
String user = (String) session.getAttribute("username");
String userName = null;
String sessionID = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("user")) userName = cookie.getValue();
	if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
}
}
/*else{
	userName=request.getParameter("user");
    sessionID=request.getParameter("id");
}*/
%>
<h3>Hi <%=userName %>, Login successful.</h3>
<br>
<h4>Your Username User=<%=user %></h4>
<br>
<br>
<h4> Your Session ID=<%=sessionID %></h4>
<br>

<form action="logout.jsp" method="post">
<input type="submit" value="Logout">
</form>
</body>
</html>