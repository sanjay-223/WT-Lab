<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>

<%
Cookie[] cookies = request.getCookies();
    	if(cookies != null){
    	for(Cookie cookie : cookies){
    		if(cookie.getName().equals("JSESSIONID")){
    			out.println("JSESSIONID="+cookie.getValue());
    			break;
    		}
    	}
    	}	
    	
    	if(session != null){
    		session.invalidate();
    	}
    response.sendRedirect("login.jsp");
%>