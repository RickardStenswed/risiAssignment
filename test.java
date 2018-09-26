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
		
	//sDAL.addStudent("123", "Apa", "Hej", "1010");
	
	//Add + Delete and Get course is working
		//cDAL.addCourse("c4", "Matte", 15);	
	//cDAL.deleteCourse("c4");
	
	//System.out.println(cDAL.getAllCourses());
	}
		

		
	}
		
	


