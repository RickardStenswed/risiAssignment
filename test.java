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
		
	//System.out.println(cDAL.getAllCourses());
	
	//cDAL.addCourse("c4", "Matte", 15);	
	
	System.out.println(cDAL.getAllCourses());
	}
		

		
	}

//testtesttest
		
	


