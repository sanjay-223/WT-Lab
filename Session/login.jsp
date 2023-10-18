<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ page import="java.util.*" %>
<%
String user = request.getParameter("user");
String pwd = request.getParameter("pwd");

if (user != null && pwd != null) {
    boolean isValidUser = user.equals("User123") && pwd.equals("password");

    if (isValidUser) {
        
        session = request.getSession(true);
        session.setAttribute("username",user);
        Cookie usernameCookie = new Cookie("user", user);
        usernameCookie.setMaxAge(10); 
        response.addCookie(usernameCookie);

        response.sendRedirect("loginsuccess.jsp");


    } else {
        response.sendRedirect("login.html?error=1");
    }
} 
else {
    response.sendRedirect("login.html?error=1");
}

%>
