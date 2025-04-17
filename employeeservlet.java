import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class EmployeeServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String empId = request.getParameter("empId");
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourdb", "root", "password");

      PreparedStatement ps;
      if (empId != null && !empId.isEmpty()) {
        ps = con.prepareStatement("SELECT * FROM employees WHERE id = ?");
        ps.setString(1, empId);
      } else {
        ps = con.prepareStatement("SELECT * FROM employees");
      }

      ResultSet rs = ps.executeQuery();
      out.println("<h2>Employee Details:</h2>");
      while (rs.next()) {
        out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + "<br/>");
      }

      con.close();
    } catch (Exception e) {
      out.println("Error: " + e.getMessage());
    }
  }
}
