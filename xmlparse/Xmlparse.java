import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import javax.servlet.http.*;  
import javax.servlet.*;  
import java.io.*; 

public class Xmlparse extends HttpServlet {
  
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      // creating a constructor of file class and parsing an XML file
      File file = new File("C:\\studentxmlparser.xml");
      // an instance of factory that gives a document builder
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      // an instance of builder to parse the specified xml file
      DocumentBuilder db = dbf.newDocumentBuilder();
      Document doc = db.parse(file);
      doc.getDocumentElement().normalize();
      
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      out.println("<html><head><style>table,tr,th,td{border:1px solid black;border-collapse: collapse;}</style></head><body>");
      out.println("<table>");
	out.println("<tr><th>Student id</th><th>First Name</th><th> LastName</th><th>Subject</th><th>Marks</th></tr>");
      NodeList nodeList = doc.getElementsByTagName("student");
      // nodeList is not iterable, so we are using for loop
      for (int itr = 0; itr < nodeList.getLength(); itr++) {
	Node node = nodeList.item(itr);
        if (node.getNodeType() == Node.ELEMENT_NODE) {
          Element eElement = (Element) node;
	  String id=eElement.getElementsByTagName("id").item(0).getTextContent();
	  String firstname=eElement.getElementsByTagName("firstname").item(0).getTextContent();
	  String lastname=eElement.getElementsByTagName("lastname").item(0).getTextContent();
	  String subject=eElement.getElementsByTagName("subject").item(0).getTextContent();
	  String marks=eElement.getElementsByTagName("marks").item(0).getTextContent();
	  out.println("<tr>");
          out.println("<td>"+id+"</td>");
          out.println("<td>"+firstname+"</td>");
          out.println("<td>"+lastname+"</td>");
          out.println("<td>"+subject+" </td>");
          out.println("<td>"+marks+ "</td>");
	  out.println("</tr>");
        }
      }
	out.println("</table>");

      
      out.println("</body></html>");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}