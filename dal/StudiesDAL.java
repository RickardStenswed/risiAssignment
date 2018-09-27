package dal;

import java.util.*;
import java.sql.*;
import model.*;
import connection.DBconnection;

public class StudiesDAL {

	private Connection con = null;
	private PreparedStatement pStmt = null;

	CourseDAL courseDAL = new CourseDAL();
	HasStudiedDAL hasStudiedDAL = new HasStudiedDAL();

	// Connecting to database, runs preparedStatement, executing query and
	// collecting resultset.

	private ResultSet runExecuteQuery(String sqlString) throws SQLException {
		con = DBconnection.getConnection();
		pStmt = con.prepareStatement(sqlString);
		ResultSet rs = pStmt.executeQuery();
		// con.close();
		return rs;
	}

	//
	private void runExecuteUpdate(String sqlString) throws SQLException {
		con = DBconnection.getConnection();
		pStmt = con.prepareStatement(sqlString);
		pStmt.executeUpdate();
	}

	// Gets all courses a student is studying

	public ArrayList<Course> getAllCoursesStudies(String ssn) throws SQLException {
		ArrayList<Course> allCoursesStudies = new ArrayList<Course>();

		String sqlString = "SELECT courseCode FROM Studies WHERE ssn  = '" + ssn + "';";
		ResultSet rs = runExecuteQuery(sqlString);

		while (rs.next()) {
			String courseCode = rs.getString(1);
			Course tempCourse = courseDAL.getCourse(courseCode);

			// courseDAL.getCourse(courseCode); // Kommer nog funka med fullständiga koden
			allCoursesStudies.add(tempCourse);
			// pStmt.close();
			// con.close();
		}
		// pStmt.close();
		// con.close();
		return allCoursesStudies;
	}

	// Gets all students studying a course

	public ArrayList<Student> getAllStudentsStudiesCourse(String courseCode) throws SQLException {
		ArrayList<Student> allStudentsStudiesCourse = new ArrayList<Student>();
		String sqlString = "SELECT s.ssn, studentName, address, phoneNumber FROM Student s JOIN Studies st ON s.ssn = st.ssn WHERE st.courseCode = '"
				+ courseCode + "' AND s.ssn = st.ssn;";
		ResultSet rs = runExecuteQuery(sqlString);
		while (rs.next()) {
			String ssn = rs.getString(1);
			String studentName = rs.getString(2);
			String address = rs.getString(3);
			String phoneNumber = rs.getString(4);
			Student tempStudent = new Student(ssn, studentName, address, phoneNumber);
			allStudentsStudiesCourse.add(tempStudent);
		}
		con.close();
		return allStudentsStudiesCourse;
	}

	// Gets student if student is studying that course

	public Student getStudentStudiesCourse(String ssn, String courseCode) throws SQLException {
		String sqlString = "SELECT s.ssn, s.studentName, s.address, s.phoneNumber FROM Student s JOIN Studies st ON s.ssn = st.ssn WHERE st.courseCode = '"
				+ courseCode + "' AND st.ssn = '" + ssn + "';";
		ResultSet rs = runExecuteQuery(sqlString);
		Student tempStudent = null;
		if (rs.next()) {
			ssn = rs.getString(1); // This string is already used
			String studentName = rs.getString(2);
			String address = rs.getString(3);
			String phoneNumber = rs.getString(4);
			tempStudent = new Student(ssn, studentName, address, phoneNumber);

		}
		return tempStudent;

	}

	// Delete student from studies

	public void deleteStudentStudies(String courseCode, String ssn) throws SQLException {
		String sqlString = "DELETE FROM Studies WHERE ssn = '" + ssn + "' AND courseCode = '" + courseCode + "';";
		runExecuteUpdate(sqlString);
		con.close();
	}

	public void addStudentStudies(String courseCode, String ssn, String semester) throws SQLException, RuntimeException {
		
		double totCreditsSemester = hasStudiedDAL.controlTotalCreditsSemester(ssn, semester); 
		double tempCredits = courseDAL.getCourse(courseCode).getCredit();
		double totCredits = tempCredits + totCreditsSemester;
		HasStudied tempHasStudied = hasStudiedDAL.getStudentGradeCourse(ssn, courseCode);
		if (totCredits <= 45) {
			if (tempHasStudied == null) {
				String sqlString = "INSERT INTO Studies VALUES ('" + courseCode + "', '" + ssn + "', '" + semester
						+ "');";
				
				runExecuteUpdate(sqlString);
			} else {
				
				throw new SQLException();
			}
		} else {
			
			throw new RuntimeException();
		}
		con.close();
	}
}
