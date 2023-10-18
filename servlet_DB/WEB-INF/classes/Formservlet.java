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

//out.println("Before try");
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","31415"); 
Statement stmt=con.createStatement(); 
String stm = String.format("INSERT INTO DATA VALUES('%s','%s','%s','%s')",name,mail,phno,pass);
stmt.executeUpdate(stm);
//out.println("After insertion");
ResultSet rs=stmt.executeQuery("SELECT * FROM DATA WHERE NAME='"+name+"' LIMIT 1");   
//out.println(rs.getString(1)+"  "+rs.getString(2)+" "+rs.getString(3)+"  "+rs.getString(4)); 
while(rs.next()){
 out.println("<html>");
        out.println("<head>");
        out.println("<title>Form submission </title>");
        out.println("<style>body{margin:15px;} h1{margin-left:30px;} table,th,td {margin-left:100px;border: 1px solid black; border-collapse:collapse} th,td{text-align:center;padding:15px;}</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>INFO RECEIVED FROM FORM PAGE:</h1>");
        out.println("<table>");
        out.println("<tr><th>Name:</th><td>" + rs.getString(1) + "</td></tr>" );
        out.println("<tr><th>Email:</th><td>" + rs.getString(2) + "</td></tr>" );
        out.println("<tr><th>Ph No.:</th><td>" + rs.getString(3)+ "</td></tr>" );
        out.println("<tr><th>Password:</th><td>" + rs.getString(4) + "</td></tr>" );
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
        }
con.close();  
}catch(Exception e){ out.println(e);}  
//out.println("After try");


  
out.close();  
}}  
