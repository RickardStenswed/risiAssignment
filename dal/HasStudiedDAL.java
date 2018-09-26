package dal;

import java.util.*;
import java.sql.*;
import model.*;
import connection.DBconnection;


    public class HasStudiedDAL {

        private Connection con = null;
        private PreparedStatement pStmt = null;
        CourseDAL courseDAL = new CourseDAL();

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
        
        
        //Get a specific student and its grade from a specific course
        
        public HasStudied getStudentGradeCourse(String ssn, String courseCode)throws SQLException {
            
            String sqlString = "SELECT s.ssn, hs.courseCode, hs.semester, hs.grade FROM Student s JOIN HasStudied hs ON s.ssn = hs.ssn WHERE hs.courseCode = '" + courseCode + "' AND hs.ssn = '" + ssn + "';";
           ResultSet rs = runExecuteQuery(sqlString);
           HasStudied tempStudent = null;
            if (rs.next()) {
                ssn = rs.getString(1);
                courseCode = rs.getString(2);
                String semester = rs.getString(3);
                String grade = rs.getString(4);
                tempStudent = new HasStudied (ssn, courseCode, semester, grade);
                
            }
            //con.close();
            return tempStudent;
            
                    
            }
            
        
        //Gets all students and their grade from a specific course
        
        public ArrayList<HasStudied>getAllStudentsGradesCourse (String courseCode)throws SQLException {
            ArrayList<HasStudied> studentsGrades = new ArrayList <HasStudied>();
            String sqlString = "SELECT * FROM HasStudied WHERE courseCode = '" + courseCode + "'";
            ResultSet rs = runExecuteQuery(sqlString);
            while (rs.next()) {
                String ssn = rs.getString(1);
                courseCode = rs.getString(2);
                String semester = rs.getString(3);
                String grade = rs.getString(4);
                HasStudied tempStudent = new HasStudied (ssn, courseCode, semester, grade);
                studentsGrades.add(tempStudent);
            }
            con.close();
            return studentsGrades;
            
                    
            }
            
            //Gets all grades a specific student has
        
        public ArrayList<HasStudied>getStudentAllGrades (String ssn)throws SQLException {
            ArrayList<HasStudied> studentAllGrades = new ArrayList <HasStudied>();
            String sqlString = "SELECT * FROM HasStudied WHERE ssn = '" + ssn + "'";
            ResultSet rs = runExecuteQuery(sqlString);
            while (rs.next()) {
                ssn = rs.getString(1);
                String courseCode = rs.getString(2);
                String semester = rs.getString(3);
                String grade = rs.getString(4);
                HasStudied tempStudent = new HasStudied (ssn, courseCode, semester, grade);
                studentAllGrades.add(tempStudent);
            }
            con.close();
            return studentAllGrades;
            
        }
        
     // Gets grades % from a certain course
        
        public HashMap<String, String> getGradePercentage (String courseCode) throws SQLException {
            HashMap<String, String> map = new HashMap<String, String>();
            
            String sqlString = "SELECT grade, (COUNT(grade)* 100 / (SELECT COUNT (*) FROM HasStudied WHERE courseCode ='" + courseCode + "'))as 'percentage' FROM HasStudied WHERE courseCode = '" + courseCode + "' GROUP BY grade";
            ResultSet rs = runExecuteQuery(sqlString);
            while (rs.next()) {
                String grade = rs.getString(1);
                String percent = rs.getString(2);
                map.put(grade, percent);
                
            }
            pStmt.close();
            con.close();
            return map;
            
        }
        
        //Get top 10 throughput (which courses have the most passed students)
        
        public HashMap<String, String>getHighestThroughput() throws SQLException {
            HashMap<String, String> map = new HashMap<String, String>();
            
            String sqlString = "SELECT TOP 10 UPPER (courseCode) AS 'Course Code', (SUM(CASE WHEN grade != 'U' THEN 1 ELSE 0 END)*100/ COUNT (courseCode) AS 'Percent Passed' " + "FROM HasStudied" + "GROUP BY courseCode" + "ORDER BY 'Percent Passed' DESC";
            ResultSet rs = runExecuteQuery(sqlString);
            while (rs.next()) {
                String courseCode = rs.getString(1);
                String percent = rs.getString(2);
                map.put(courseCode, percent);
                
            }
            
            return map;
            
        }
        
        public double controlTotalCreditsSemester(String ssn, String semester) throws SQLException {
            
            //Gets total credits from Studies
        	
            String sqlString1 = "SELECT SUM(c.credit) FROM Course c WHERE c.code IN (SELECT s.courseCode FROM Studies s WHERE s.ssn = '" + ssn + "' and s.semester = '" + semester + "')";
            ResultSet rs = runExecuteQuery(sqlString1);
            rs.next();
            double studiesCredit = rs.getFloat(1);
            
            //Gets total credits from HasStudied
            
            String sqlString2 = "SELECT SUM (c.credit) FROM Course c WHERE c.courseCode IN (SELECT s.courseCode FROM HasStudied hs WHERE hs.ssn ='" + ssn + "' and hs.semester = '" + semester + "')";
            ResultSet rs2 = runExecuteQuery(sqlString2);
            rs2.next();
            double hasStudiedCredit = rs2.getFloat(1);
            
            double totalCredit = studiesCredit + hasStudiedCredit;
            
            con.close();
            return totalCredit;
       }
   
        
    
    //Register student to a completed course AND eliminates student from the course he or she has ended
    
    public void addStudentHasStudied (String ssn, String courseCode, String semester, String grade) throws SQLException, RuntimeException {
       
    	double totalCreditThisSemester = this.controlTotalCreditsSemester(ssn, semester);
        double credit = courseDAL.getCourse(courseCode).getCredit();
        double totalCredit = credit + totalCreditThisSemester;
        
        //Checking if the student is allowed to take the course (must be less than 45 p)
        
        if (totalCredit <=45) {
            String sqlString = "INSERT INTO HasStudied VALUES ('" + ssn + "', '" + courseCode + "', '" + semester + "', '" + grade + "');";
            runExecuteUpdate(sqlString);
            
            String sqlString2 = "DELETE FROM Studies WHERE ssn = '" + ssn + "' AND courseCode = '" + courseCode + "';";
            runExecuteUpdate(sqlString2);
        }
        else {
            throw new RuntimeException();
            
             }
         
        con.close();
    } }


