<!DOCTYPE html>
<html>
<head><title>Student Attendance</title></head>
<body>
  <h2>Enter Attendance</h2>
  <form method="post" action="AttendanceServlet">
    Student ID: <input type="text" name="studentId"/><br/>
    Date: <input type="date" name="date"/><br/>
    Status: 
    <select name="status">
      <option value="Present">Present</option>
      <option value="Absent">Absent</option>
    </select><br/>
    <input type="submit" value="Submit"/>
  </form>
</body>
</html>
