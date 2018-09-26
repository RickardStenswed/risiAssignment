import model.*;
import dal.*;
import java.util.*;
import java.sql.*;
import controller.*;
import connection.*;

public class test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		Controller cont = new Controller();
		CourseDAL cDAL = new CourseDAL();
		StudentDAL sDAL = new StudentDAL();
		HasStudiedDAL hsDAL = new HasStudiedDAL();
		StudiesDAL csDAL = new StudiesDAL();
	
		//	T
	
	
	//Add + Delete and Get course is working
		//cDAL.addCourse("c4", "Matte", 15);	
	//cDAL.deleteCourse("c4");
	
		//Testmethod to find all students grades from a specific course
		//hsDAL.getAllStudentsGradesCourse("c1")
		
		//Testmethod to find all grades for a student
		//hsDAL.getStudentAllGrades("950218")
		
		//Testmethod for getting grade percentage for a course
		//hsDAL.getGradePercentage("c1")
	
		//Testmethod deleta a student
		//sDAL.deleteStudent("123");
		
		                             //sDAL.addStudent("555", "Jerker", "Hej", "1010");
		                              //cDAL.addCourse("c10", "english", 6);
		
		//Testmethod for getting all courses that a student currently studies
		//csDAL.getAllCoursesStudies("950218")
		
		//Testmethod for getting all students that are studying a specific course
		//csDAL.getAllStudentsStudiesCourse("c1")
		
		//Testmethod to check if a student is studying a specific course
		//csDAL.getStudentStudiesCourse("950218", "c1");
		
		//Method for getting student by ssn
		//sDAL.getStudent("555")
		
		//TestMethod for getting all students
		//sDAL.getAllStudents()
		
		System.out.println(hsDAL.getStudentGradeCourse("960317", "c3"));
	}
		

		
	}
		
	


