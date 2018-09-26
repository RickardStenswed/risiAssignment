package controller;

import java.util.*;
import java.sql.*;
import model.*;
import dal.*;


public class Controller {
	
	CourseDAL courseDAL = new CourseDAL();
	StudentDAL studentDAL = new StudentDAL();
	HasStudiedDAL hasStudiedDAL = new HasStudiedDAL();
	StudiesDAL studiesDAL = new StudiesDAL();
	
	// ADD METHODS
		
	public void addStudent(String ssn, String studentName, String address, String phoneNumber) throws SQLException {
		studentDAL.addStudent(ssn, studentName, address, phoneNumber);
	} 
	
	public void addCourse(String courseCode, String courseName, double credit) throws SQLException {
		courseDAL.addCourse(courseCode, courseName, credit);
	}
	
	public void addStudentStudies(String ssn, String courseCode, String semester) throws SQLException {
		studiesDAL.addStudentStudies(ssn, courseCode, semester);
	}
	
	public void addStudentHasStudied(String ssn, String courseCode, String semester, String grade) throws SQLException {
		hasStudiedDAL.addStudentHasStudied(ssn, courseCode, semester, grade);
	}
	
	// DELETE METHODS
	
	public void deleteStudent(String ssn) throws SQLException {
		studentDAL.deleteStudent(ssn);
	}
	
	public void deleteCourse(String courseCode) throws SQLException {
		courseDAL.deleteCourse(courseCode);
	}
	
	public void deleteStudentStudies(String ssn, String courseCode) throws SQLException {
		studiesDAL.deleteStudentStudies(ssn, courseCode);
	}
	
	
	// GET METHODS
	
		public Student getStudent(String ssn) throws SQLException {
			
			return studentDAL.getStudent(ssn);
		}
		
		public ArrayList<Student> getAllStudents() throws SQLException {
			
			return studentDAL.getAllStudents();
		}
		
		public Course getCourse(String courseCode) throws SQLException {
			
			return courseDAL.getCourse(courseCode);
		}
		
		public ArrayList<Course> getAllCourses() throws SQLException {
			
			return courseDAL.getAllCourses();
		}
		
		public ArrayList<Course> getAllCoursesStudies(String ssn) throws SQLException {
			
			return studiesDAL.getAllCoursesStudies(ssn);
		}
		
		public ArrayList<Student> getAllStudentsStudiesCourse(String courseCode) throws SQLException {
			
			return studiesDAL.getAllStudentsStudiesCourse(courseCode);
		}
		
		public Student getStudentStudiesCourse(String ssn, String courseCode) throws SQLException {
			
			return studiesDAL.getStudentStudiesCourse(ssn, courseCode);
		}
		
		public ArrayList<HasStudied> getAllStudentsGradesCourse(String courseCode) throws SQLException {
			
			return hasStudiedDAL.getAllStudentsGradesCourse(courseCode);
		}
		
		public HasStudied getStudentGradeCourse(String ssn, String courseCode) throws SQLException {
			return hasStudiedDAL.getStudentGradeCourse(ssn, courseCode);
		}
		
		public ArrayList<HasStudied> getStudentAllGrades(String ssn) throws SQLException {
			return hasStudiedDAL.getStudentAllGrades(ssn);
		}
		
		public HashMap<String, String> getGradePercentage(String courseCode) throws SQLException {
			return hasStudiedDAL.getGradePercentage(courseCode);
		}
		
		public HashMap<String, String> getHighestThroughput() throws SQLException {
			return hasStudiedDAL.getHighestThroughput();	
		}	
} 

