import javax.servlet.http.*;  
import javax.servlet.*;  
import java.io.*;  
public class Formservlet extends HttpServlet{  
public void doGet(HttpServletRequest req,HttpServletResponse res)  
throws ServletException,IOException  
{  
res.setContentType("text/html");  
PrintWriter out=res.getWriter();  
  
String name=req.getParameter("name");
String mail=req.getParameter("email");
String phno=req.getParameter("phno");
String pass=req.getParameter("pass");

 out.println("<html>");
        out.println("<head>");
        out.println("<title>Form submission </title>");
        out.println("<style>body{margin:15px;} h1{margin-left:30px;} table,th,td {margin-left:100px;border: 1px solid black; border-collapse:collapse} th,td{text-align:center;padding:15px;}</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>INFO RECEIVED FROM FORM PAGE:</h1>");
        out.println("<table>");
        out.println("<tr><th>Name:</th><td>" + name + "</td></tr>" );
        out.println("<tr><th>Email:</th><td>" + mail + "</td></tr>" );
        out.println("<tr><th>Ph No.:</th><td>" + phno + "</td></tr>" );
        out.println("<tr><th>Password:</th><td>" + pass + "</td></tr>" );
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
  
out.close();  
}}  
