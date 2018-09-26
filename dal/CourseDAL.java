package dal;

import java.util.*;
import java.sql.*;
import model.*;
import connection.DBconnection;


public class CourseDAL {
	
    private Connection con = null;
    private PreparedStatement pStmt = null;
    
    
    // Connecting to database, runs preparedStatement, executing query and collecting resultset.
    
    private ResultSet runExecuteQuery(String sqlString) throws SQLException {
        con = DBconnection.getConnection();
        pStmt = con.prepareStatement(sqlString);
        ResultSet rs = pStmt.executeQuery();
        return rs;
    }    
    
    // Start connection. Run PreparedStatement. ExecuteUpdate.
    
    private void runExecuteUpdate(String sqlString) throws SQLException {
        con = DBconnection.getConnection();
        pStmt = con.prepareStatement(sqlString);
        pStmt.executeUpdate();
    
    }

    // Get a course and its attributes
    
public Course getCourse(String courseCode) throws SQLException {
    String sqlString = "SELECT * FROM Course WHERE courseCode = '" + courseCode + "';";
    ResultSet rs = runExecuteQuery(sqlString);
    if (rs.next()) {
        courseCode = rs.getString(1);
        String courseName = rs.getString(2);
        double credit = rs.getFloat(3);
        Course tempCourse = new Course(courseCode, courseName, credit);
        pStmt.close();
        con.close();
        return tempCourse;
    }
    pStmt.close();
    con.close();
    return null;
}

    // Add new course

public void addCourse(String courseCode, String courseName, double credit) throws SQLException {
    String sqlString = "INSERT INTO Course VALUES ( '" + courseCode + "', '" + courseName + "', " + credit + ");";
    runExecuteUpdate(sqlString);
    pStmt.close();
    con.close();
}

    // Delete course

public void deleteCourse(String courseCode) throws SQLException {
    String sqlString = "DELETE FROM Course WHERE courseCode = '" + courseCode + "';";
    runExecuteUpdate(sqlString);
    pStmt.close();
    con.close();
}

    // Gets all courses

public ArrayList<Course> getAllCourses() throws SQLException {

    ArrayList<Course> allCourses = new ArrayList<Course>();
String sqlString = "SELECT * FROM Course";

ResultSet rs = runExecuteQuery(sqlString);
while (rs.next()) {
    
    String courseCode = rs.getString(1);
    String courseName = rs.getString(2);
    double credit = rs.getFloat(3);
    Course tempCourse = new Course(courseCode, courseName, credit);
    allCourses.add(tempCourse);
}
pStmt.close();
con.close();
return allCourses;

}
}



