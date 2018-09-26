package dal;

import java.util.*;
import java.sql.*;
import model.*;
import connection.DBconnection;


public class StudentDAL {
	
    private Connection con = null;
    private PreparedStatement pStmt = null;

    
    // Connecting to database, runs preparedStatement, executing query and collecting resultset.
    
    private ResultSet runExecuteQuery(String sqlString) throws SQLException {
        con = DBconnection.getConnection();
        pStmt = con.prepareStatement(sqlString);
        ResultSet rs = pStmt.executeQuery();
        con.close();
        return rs;
        
}
    //Starting connection and update DB.
    
    private void runExecuteUpdate(String sqlString) throws SQLException {
        con = DBconnection.getConnection();
        pStmt = con.prepareStatement(sqlString);
        pStmt.executeUpdate();
        
    }
    
    // Find all information from student by searching for ssn
    
    public Student getStudent(String ssn) throws SQLException {
        Student tempStudent;
        String sqlString = "SELECT * FROM Student WHERE ssn = '" + ssn + "'";
        ResultSet rs = runExecuteQuery(sqlString);
        if (rs.next()) {
            ssn = rs.getString(1);
            String studentName = rs.getString(2);
            String address = rs.getString(3);
            String phoneNumber = rs.getString(4);
            
            tempStudent = new Student(ssn, studentName, address, phoneNumber);
            con.close();
            return tempStudent;
        }
        return null;
    }
    
    //Get all students and all information
    
    public ArrayList <Student> getAllStudents() throws SQLException {
        ArrayList <Student> allStudents = new ArrayList <Student>();
        Student tempStudent;
        String sqlString = "SELECT * FROM Student";
                ResultSet rs = runExecuteQuery(sqlString);
                if (rs.next()) {
                    String ssn = rs.getString(1);
                    String studentName = rs.getString(2);
                    String address = rs.getString(3);
                    String phoneNumber = rs.getString(4);
                    tempStudent = new Student(ssn, studentName, address, phoneNumber);
                    allStudents.add(tempStudent);
                    
                }
                con.close();
                return allStudents;
    }
    
    // Add new student to the system
    
    public void addStudent (String ssn, String studentName, String address, String phoneNumber)throws SQLException{
    String sqlString = "INSERT INTO Student VALUES ( '" + ssn + "' , '" + studentName + "' , '" + address + "' , '" + phoneNumber + "');";    
    runExecuteUpdate(sqlString);
    con.close();
    }

    //Delete student from system
    
    public void deleteStudent (String ssn) throws SQLException {
        String sqlString = "DELETE FROM Student WHERE ssn = '" + ssn + "';";
        runExecuteUpdate(sqlString);
        con.close();
    }
}

        


