import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AttendanceServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String studentId = request.getParameter("studentId");
    String date = request.getParameter("date");
    String status = request.getParameter("status");

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourdb", "root", "password");

      PreparedStatement ps = con.prepareStatement("INSERT INTO attendance(student_id, date, status) VALUES (?, ?, ?)");
      ps.setString(1, studentId);
      ps.setString(2, date);
      ps.setString(3, status);

      int result = ps.executeUpdate();
      if (result > 0) {
        out.println("<h3>Attendance recorded successfully.</h3>");
      } else {
        out.println("<h3>Failed to record attendance.</h3>");
      }

      con.close();
    } catch (Exception e) {
      out.println("Error: " + e.getMessage());
    }
  }
}
