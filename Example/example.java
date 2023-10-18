import jakarta.servlet.http.*;
import jakarata.servlet.*;
import java.io.*;
public class FormServlet extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
        res.setContentType('text/html');
        PrintWriter out=res.getWriter();
        String name = req.getParameter("name");
        String mail = req.getParameter("mail");
        String phno = req.getParameter("phno");
        String pass = req.getParameter("pass");
        out.println("<head><title>Form Submission</title></head>");
        out.println("<body>INFO RECEIVED FROM FORM PAGE :</h1>");
        out.println("<p>"+name+mail+phno+pass+"</p>");
        out.println("</body></html>");
    }
};