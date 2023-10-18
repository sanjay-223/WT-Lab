<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java" %>


<html>
<head>
<title>Form submission </title>
<style>body{margin:15px;} h1{margin-left:30px;} table,th,td {margin-left:100px;border: 1px solid black; border-collapse:collapse} th,td{text-align:center;padding:15px;}</style>
</head>
<body>
<h1>INFO RECEIVED FROM FORM PAGE:</h1>
<table>
<%
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String phno = request.getParameter("phno");
    String pass = request.getParameter("pass");

    Connection conn = null;
    PreparedStatement stmt = null;

        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","31415");
        String sql = "INSERT INTO DATA (name, email, phno, pass) VALUES (?, ?, ?, ?)";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.setString(2, email);
        stmt.setString(3, phno);
        stmt.setString(4, pass);
        stmt.executeUpdate();
        sql = "SELECT * FROM DATA WHERE NAME = "+"'"+name+"' LIMIT 1";
        stmt = conn.prepareStatement(sql);
        ResultSet rs=stmt.executeQuery();
        rs.next();
        out.println("Data inserted successfully!");
        out.println("<tr><th>Name:</th><td>" + rs.getString(1) + "</td></tr>" );
        out.println("<tr><th>Email:</th><td>" + rs.getString(2) + "</td></tr>" );
        out.println("<tr><th>Ph No.:</th><td>" + rs.getString(3) + "</td></tr>" );
        out.println("<tr><th>Password:</th><td>" + rs.getString(4) + "</td></tr>" );
        conn.close();
        out.close();
        stmt.close();

%>
</table>
</body>
</html>
