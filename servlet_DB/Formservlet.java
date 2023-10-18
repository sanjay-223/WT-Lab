import javax.servlet.http.*;  
import javax.servlet.*;  
import java.io.*;  
import java.sql.*;
public class Formservlet extends HttpServlet{  
public void doPost(HttpServletRequest req,HttpServletResponse res)  
throws ServletException,IOException  
{  
res.setContentType("text/html");  
PrintWriter out=res.getWriter();
String name=req.getParameter("name");
String mail=req.getParameter("email");
String phno=req.getParameter("phno");
String pass=req.getParameter("pass");

try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","31415"); 
Statement stmt=con.createStatement();  
stmt.executeQuery("INSERT INTO DATA VALUES('"+name+","+mail+","+phno+","+pass+")");  
ResultSet result = stmt.executeQuery("SELECT * FROM DATA WHERE NAME="+name); 
while(result.next())
{

out.println(result.getString(1)+"  "+result.getString(2)+" "+result.getString(3)+"  "+result.getString(4));  

  
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Form submission </title>");
        out.println("<style>body{margin:15px;} h1{margin-left:30px;} table,th,td {margin-left:100px;border: 1px solid black; border-collapse:collapse} th,td{text-align:center;padding:15px;}</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>INFO RECEIVED FROM FORM PAGE:</h1>");
        out.println("<table>");
        out.println("<tr><th>Name:</th><td>" + result.getString(1) + "</td></tr>" );
        out.println("<tr><th>Email:</th><td>" + result.getString(2) + "</td></tr>" );
        out.println("<tr><th>Ph No.:</th><td>" + result.getString(3) + "</td></tr>" );
        out.println("<tr><th>Password:</th><td>" + result.getString(4) + "</td></tr>" );
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
}
out.close();  
con.close();  
}catch(Exception e){ System.out.println(e);}  

} 
};

