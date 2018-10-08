package application;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.sql.*;
import java.util.*;

import model.*;
import dal.*;
import controller.*;
import errorhandling.ErrorResponse;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {

	private JFrame frame;
	private JTextField textFieldFindStudentSsn;
	private JTextField textFieldFindCourseCourseCode;
	private JTextField textFieldRegStudentSsn;
	private JTextField textFieldRegStudentName;
	private JTextField textFieldRegStudentAddress;
	private JTextField textFieldRegStudentPhoneNumber;
	private JTextField textFieldRegCourseCourseCode;
	private JTextField textFieldRegCourseName;
	private JTextField textFieldRegCourseCredits;
	private JTextField textFieldRegStudentStudiesSsn;
	private JTextField textFieldRegStudentStudiesCourseCode;
	private JTextField textFieldRegStudentStudiesSemester;
	private JTextField textFieldRegStudentHasStudiedSsn;
	private JTextField textFieldRegStudentHasStudiedCourseCode;
	private JTextField textFieldRegStudentHasStudiedSemester;
	private JTextField textFieldFindStudentCheckSsn;
	private JTextField textFieldFindStudentCheckCourseCode;
	private JTextField textFieldCourseResultCourseCode;
	private JTextField textFieldStudentResultSsn;
	private JTextField textFieldStudentResultCourseCode;
	private JTextField textFieldStudentResultSsn2;

	private JTable tableHighestThroughput;
	private JTable tableSsnStudent;
	private JTable tableCourseCode;
	private JTable tableStudentResult;
	private JTable tableCourseResult;
	private JTable tableAss2;
	
	// Default model
	private DefaultTableModel dataModelHighestThroughput;
	private DefaultTableModel dataModelSsnStudent;
	private DefaultTableModel dataModelCourseCode;
	private DefaultTableModel dataModelStudentResult;
	private DefaultTableModel dataModelCourseResult;
	private DefaultTableModel dataModelAss2;

	private Controller controller = new Controller();
	private Controller2 controller2 = new Controller2();
	private Controller3 controller3 = new Controller3();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 929, 564);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_2.setBackground(SystemColor.activeCaption);
		tabbedPane_2.setBounds(0, 0, 913, 514);
		frame.getContentPane().add(tabbedPane_2);

		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBackground(SystemColor.activeCaption);
		tabbedPane_2.addTab("Assignment 1", null, tabbedPane_1, null);

		JPanel panelRegisterAdd = new JPanel();
		tabbedPane_1.addTab("Register / Delete", null, panelRegisterAdd, null);
		panelRegisterAdd.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register student");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(164, 0, 119, 45);
		panelRegisterAdd.add(lblNewLabel);

		JComboBox<String> comboBoxGrade = new JComboBox<String>();
		comboBoxGrade.addItem("");
		comboBoxGrade.addItem("A");
		comboBoxGrade.addItem("B");
		comboBoxGrade.addItem("C");
		comboBoxGrade.addItem("D");
		comboBoxGrade.addItem("F");
		comboBoxGrade.addItem("U");
		comboBoxGrade.setBounds(561, 338, 154, 20);
		panelRegisterAdd.add(comboBoxGrade);

		textFieldRegStudentSsn = new JTextField();
		textFieldRegStudentSsn.setBounds(164, 40, 119, 20);
		panelRegisterAdd.add(textFieldRegStudentSsn);
		textFieldRegStudentSsn.setColumns(10);

		textFieldRegStudentName = new JTextField();
		textFieldRegStudentName.setBounds(164, 71, 119, 20);
		panelRegisterAdd.add(textFieldRegStudentName);
		textFieldRegStudentName.setColumns(10);

		textFieldRegStudentAddress = new JTextField();
		textFieldRegStudentAddress.setBounds(164, 102, 119, 20);
		panelRegisterAdd.add(textFieldRegStudentAddress);
		textFieldRegStudentAddress.setColumns(10);

		textFieldRegStudentPhoneNumber = new JTextField();
		textFieldRegStudentPhoneNumber.setBounds(164, 133, 119, 20);
		panelRegisterAdd.add(textFieldRegStudentPhoneNumber);
		textFieldRegStudentPhoneNumber.setColumns(10);

		JLabel responseLabelRegAdd = new JLabel("");
		responseLabelRegAdd.setBounds(185, 417, 678, 14);
		panelRegisterAdd.add(responseLabelRegAdd);

		JLabel labelErrorMessage = new JLabel("System response:");
		labelErrorMessage.setBounds(60, 417, 113, 14);
		panelRegisterAdd.add(labelErrorMessage);

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(60, 74, 46, 14);
		panelRegisterAdd.add(lblName);

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(60, 105, 71, 14);
		panelRegisterAdd.add(lblAddress);

		JLabel lblPhoneNumber = new JLabel("Phone number:");
		lblPhoneNumber.setBounds(60, 136, 94, 14);
		panelRegisterAdd.add(lblPhoneNumber);

		JLabel lblRegisterCourse = new JLabel("Register course");
		lblRegisterCourse.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRegisterCourse.setBounds(164, 214, 119, 20);
		panelRegisterAdd.add(lblRegisterCourse);

		textFieldRegCourseCourseCode = new JTextField();
		textFieldRegCourseCourseCode.setBounds(164, 245, 119, 20);
		panelRegisterAdd.add(textFieldRegCourseCourseCode);
		textFieldRegCourseCourseCode.setColumns(10);

		textFieldRegCourseName = new JTextField();
		textFieldRegCourseName.setBounds(164, 276, 119, 20);
		panelRegisterAdd.add(textFieldRegCourseName);
		textFieldRegCourseName.setColumns(10);

		JLabel lblName_1 = new JLabel("Name:");
		lblName_1.setBounds(60, 279, 46, 14);
		panelRegisterAdd.add(lblName_1);

		textFieldRegCourseCredits = new JTextField();
		textFieldRegCourseCredits.setBounds(164, 307, 119, 20);
		panelRegisterAdd.add(textFieldRegCourseCredits);
		textFieldRegCourseCredits.setColumns(10);

		//Button to delete student
		JButton btnRegStudentDelete = new JButton("Delete");
		btnRegStudentDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String ssn = textFieldRegStudentSsn.getText();
				responseLabelRegAdd.setForeground(Color.BLACK);
				
				try {
					
				if (ssn.isEmpty()) {
					responseLabelRegAdd.setForeground(Color.RED);
					responseLabelRegAdd.setText("Please enter student ssn");
				
				} else {	
					controller.deleteStudent(ssn);
					responseLabelRegAdd.setForeground(Color.GREEN);
					responseLabelRegAdd.setText("Student removed");
					textFieldRegStudentSsn.setText(null);
					textFieldRegStudentName.setText(null);
					textFieldRegStudentAddress.setText(null);
					textFieldRegStudentPhoneNumber.setText(null);
				}
					} catch (SQLException sq) {
						responseLabelRegAdd.setForeground(Color.RED);
						 responseLabelRegAdd.setText(ErrorResponse.getMessageForErrorCode(sq.getErrorCode(), "Student"));
					}
				}
		});
		btnRegStudentDelete.setBounds(270, 170, 89, 23);
		panelRegisterAdd.add(btnRegStudentDelete);

		JLabel lblCredits = new JLabel("Credits:");
		lblCredits.setBounds(60, 310, 46, 14);
		panelRegisterAdd.add(lblCredits);

		//Button to add course
		JButton btnRegCourseAdd = new JButton("Add");
		btnRegCourseAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String courseCode = textFieldRegCourseCourseCode.getText();
				String courseName = textFieldRegCourseName.getText();
				String credit = textFieldRegCourseCredits.getText();
				responseLabelRegAdd.setForeground(Color.BLACK);
				
				try {
					double cred = Double.parseDouble(credit);
					cred = Double.parseDouble(credit);
					
				if (courseCode.isEmpty() || courseName.isEmpty() || credit.isEmpty()) {
					responseLabelRegAdd.setForeground(Color.RED);
					responseLabelRegAdd.setText("All fields must be filled in");
				
				} else if (cred > 45) {
					responseLabelRegAdd.setText("Course can not have more than 45 credits");
					responseLabelRegAdd.setForeground(Color.RED);
				
				} else {
						controller.addCourse(courseCode, courseName, cred);
						responseLabelRegAdd.setForeground(Color.GREEN);
						responseLabelRegAdd.setText("Course registered");
						textFieldRegCourseCourseCode.setText(null);
						textFieldRegCourseName.setText(null);
						textFieldRegCourseCredits.setText(null);
				}
					} catch (SQLException sq) {
						responseLabelRegAdd.setForeground(Color.RED);
						responseLabelRegAdd.setText(ErrorResponse.getMessageForErrorCode(sq.getErrorCode(), "Course"));
					
					} catch (NumberFormatException nrE) {
							responseLabelRegAdd.setForeground(Color.RED);
							responseLabelRegAdd.setText("Credits can only be numbers and '.'	");
				}
				}
			
		});
		btnRegCourseAdd.setBounds(164, 371, 89, 23);
		panelRegisterAdd.add(btnRegCourseAdd);

		//Button to delete course
		JButton btnRegCourseDelete = new JButton("Delete");
		btnRegCourseDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String courseCode = textFieldRegCourseCourseCode.getText();
				responseLabelRegAdd.setForeground(Color.BLACK);

				try {
					Course c = controller.getCourse(courseCode);
					
				if (courseCode.isEmpty()) {
					responseLabelRegAdd.setForeground(Color.RED);
					responseLabelRegAdd.setText("Please enter course code");
				} else if (c == null){
					responseLabelRegAdd.setForeground(Color.RED);
					responseLabelRegAdd.setText("Course code does not exist");
				} else {	
						controller.deleteCourse(courseCode);
						responseLabelRegAdd.setForeground(Color.GREEN);
						responseLabelRegAdd.setText("Course removed");
						textFieldRegCourseCourseCode.setText(null);
						textFieldRegCourseName.setText(null);
						textFieldRegCourseCredits.setText(null);
				}	
					} catch (SQLException sq) {
						responseLabelRegAdd.setForeground(Color.RED);
						responseLabelRegAdd.setText(ErrorResponse.getMessageForErrorCode(sq.getErrorCode(), "Course"));
					}
			}
		});
		btnRegCourseDelete.setBounds(270, 371, 89, 23);
		panelRegisterAdd.add(btnRegCourseDelete);

		JLabel lblRegisterStudentTo = new JLabel("Register student to ongoing course");
		lblRegisterStudentTo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRegisterStudentTo.setBounds(561, 12, 253, 20);
		panelRegisterAdd.add(lblRegisterStudentTo);

		JLabel lblSsn_1 = new JLabel("Ssn:");
		lblSsn_1.setBounds(474, 43, 46, 14);
		panelRegisterAdd.add(lblSsn_1);

		textFieldRegStudentStudiesSsn = new JTextField();
		textFieldRegStudentStudiesSsn.setBounds(561, 40, 127, 20);
		panelRegisterAdd.add(textFieldRegStudentStudiesSsn);
		textFieldRegStudentStudiesSsn.setColumns(10);

		textFieldRegStudentStudiesCourseCode = new JTextField();
		textFieldRegStudentStudiesCourseCode.setBounds(561, 71, 127, 20);
		panelRegisterAdd.add(textFieldRegStudentStudiesCourseCode);
		textFieldRegStudentStudiesCourseCode.setColumns(10);

		JLabel lblCourseCode_1 = new JLabel("Course code:");
		lblCourseCode_1.setBounds(474, 74, 79, 14);
		panelRegisterAdd.add(lblCourseCode_1);

		textFieldRegStudentStudiesSemester = new JTextField();
		textFieldRegStudentStudiesSemester.setBounds(561, 102, 127, 20);
		panelRegisterAdd.add(textFieldRegStudentStudiesSemester);
		textFieldRegStudentStudiesSemester.setColumns(10);

		JLabel lblSemester = new JLabel("Semester:");
		lblSemester.setBounds(474, 105, 62, 14);
		panelRegisterAdd.add(lblSemester);
		
		//Button for adding a student to a ongoing course
		JButton btnRegStudentStudiesAdd = new JButton("Add");
		btnRegStudentStudiesAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String ssn = textFieldRegStudentStudiesSsn.getText();
				String courseCode = textFieldRegStudentStudiesCourseCode.getText();
				String semester = textFieldRegStudentStudiesSemester.getText();
				responseLabelRegAdd.setForeground(Color.BLACK);
				
				try {
					Student s = controller.getStudent(ssn);
					Course c = controller.getCourse(courseCode);
					
				if (ssn.isEmpty() || courseCode.isEmpty() || semester.isEmpty()) {
					responseLabelRegAdd.setForeground(Color.RED);
					responseLabelRegAdd.setText("SSN and Course Code must be filled in");
				
				} else if (s == null ) {
					responseLabelRegAdd.setForeground(Color.RED);
					responseLabelRegAdd.setText("Student does not exist");
					
				} else if (c == null ) {
					responseLabelRegAdd.setForeground(Color.RED);
					responseLabelRegAdd.setText("Course does not exist");
				
				} else {
					controller.addStudentStudies(courseCode, ssn, semester);
						responseLabelRegAdd.setText("Student registered");
						responseLabelRegAdd.setForeground(Color.GREEN);
						textFieldRegStudentStudiesSsn.setText(null);
						textFieldRegStudentStudiesCourseCode.setText(null);
						textFieldRegStudentStudiesSemester.setText(null);
				}	
					} catch (SQLException sq) {
						responseLabelRegAdd.setForeground(Color.RED);
						responseLabelRegAdd.setText(ErrorResponse.getMessageForErrorCode(sq.getErrorCode(),
						 "Student"));
					} catch (RuntimeException rtException) {
						responseLabelRegAdd.setForeground(Color.RED);
						responseLabelRegAdd.setText("Student is studying to many credits ");
					}
			}
		});
		btnRegStudentStudiesAdd.setBounds(561, 140, 89, 23);
		panelRegisterAdd.add(btnRegStudentStudiesAdd);

		//Button for deleting a student from studies
		JButton btnRegStudentStudiesDelete = new JButton("Delete");
		btnRegStudentStudiesDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String ssn = textFieldRegStudentStudiesSsn.getText();
				String courseCode = textFieldRegStudentStudiesCourseCode.getText();
				responseLabelRegAdd.setForeground(Color.BLACK);
				
				try {
					Student s = controller.getStudent(ssn);
					Course c = controller.getCourse(courseCode);
					Student st = controller.getStudentStudiesCourse(ssn, courseCode);
					
				if (ssn.isEmpty() || courseCode.isEmpty()) {
					responseLabelRegAdd.setForeground(Color.RED);
					responseLabelRegAdd.setText("SSN and Course Code must be filled in");
					
				} else if (s == null) {
					responseLabelRegAdd.setForeground(Color.RED);
					responseLabelRegAdd.setText("Student does not exixst");
					
				} else if (c == null) {
					responseLabelRegAdd.setForeground(Color.RED);
					responseLabelRegAdd.setText("Course does not exist");
					
				} else if (st == null) {
					responseLabelRegAdd.setForeground(Color.RED);
					responseLabelRegAdd.setText("Student is not registered on this course");
					
				} else {
						controller.deleteStudentStudies(courseCode, ssn);
						responseLabelRegAdd.setForeground(Color.GREEN);
						responseLabelRegAdd.setText("Student removed");
						textFieldRegStudentStudiesSsn.setText(null);
						textFieldRegStudentStudiesCourseCode.setText(null);
						textFieldRegStudentStudiesSemester.setText(null);
				}
					} catch (SQLException sq) {
						responseLabelRegAdd.setForeground(Color.RED);
						responseLabelRegAdd.setText(ErrorResponse.getMessageForErrorCode(sq.getErrorCode(),
						"Student"));
					}
			}
		});
		btnRegStudentStudiesDelete.setBounds(672, 140, 89, 23);
		panelRegisterAdd.add(btnRegStudentStudiesDelete);

		JLabel lblRegisterStudentTo_1 = new JLabel("Register student to finished course");
		lblRegisterStudentTo_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRegisterStudentTo_1.setBounds(561, 216, 263, 17);
		panelRegisterAdd.add(lblRegisterStudentTo_1);

		textFieldRegStudentHasStudiedSsn = new JTextField();
		textFieldRegStudentHasStudiedSsn.setBounds(561, 245, 127, 20);
		panelRegisterAdd.add(textFieldRegStudentHasStudiedSsn);
		textFieldRegStudentHasStudiedSsn.setColumns(10);

		textFieldRegStudentHasStudiedCourseCode = new JTextField();
		textFieldRegStudentHasStudiedCourseCode.setBounds(561, 276, 127, 20);
		panelRegisterAdd.add(textFieldRegStudentHasStudiedCourseCode);
		textFieldRegStudentHasStudiedCourseCode.setColumns(10);

		textFieldRegStudentHasStudiedSemester = new JTextField();
		textFieldRegStudentHasStudiedSemester.setBounds(561, 307, 127, 20);
		panelRegisterAdd.add(textFieldRegStudentHasStudiedSemester);
		textFieldRegStudentHasStudiedSemester.setColumns(10);

		JLabel lblSsn_2 = new JLabel("Ssn:");
		lblSsn_2.setBounds(474, 248, 46, 14);
		panelRegisterAdd.add(lblSsn_2);

		JLabel lblCourseCode_2 = new JLabel("Course code:");
		lblCourseCode_2.setBounds(474, 279, 79, 14);
		panelRegisterAdd.add(lblCourseCode_2);

		JLabel lblGrade = new JLabel("Semester:");
		lblGrade.setBounds(474, 310, 62, 14);
		panelRegisterAdd.add(lblGrade);

		JLabel lblGrade_1 = new JLabel("Grade:");
		lblGrade_1.setBounds(474, 341, 46, 14);
		panelRegisterAdd.add(lblGrade_1);
		
		// Button to register that a student that has completed a course.
		JButton btnRegStudentHasStudiedAdd = new JButton("Add");
		btnRegStudentHasStudiedAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String ssn = textFieldRegStudentHasStudiedSsn.getText();
				String courseCode = textFieldRegStudentHasStudiedCourseCode.getText();
				String semester = textFieldRegStudentHasStudiedSemester.getText();
				String grade = (String) comboBoxGrade.getSelectedItem();
				responseLabelRegAdd.setForeground(Color.BLACK);
				
				try {
				if ( courseCode.isEmpty() || ssn.isEmpty() || grade.isEmpty() || semester.isEmpty() ) {
					responseLabelRegAdd.setForeground(Color.RED);
					responseLabelRegAdd.setText("All fields must be filled in");
					
				} else {	
					controller.addStudentHasStudied(courseCode, ssn, grade, semester);
						responseLabelRegAdd.setForeground(Color.GREEN);
						responseLabelRegAdd.setText("Student registered");
						textFieldRegStudentHasStudiedSsn.setText(null);
						textFieldRegStudentHasStudiedCourseCode.setText(null);
						textFieldRegStudentHasStudiedSemester.setText(null);
				}	
					} catch (SQLException sq) {
						responseLabelRegAdd.setForeground(Color.RED);
						responseLabelRegAdd.setText(ErrorResponse.getMessageForErrorCode(sq.getErrorCode(),
					 "Student"));
					}
				}
		});
		btnRegStudentHasStudiedAdd.setBounds(561, 371, 89, 23);
		panelRegisterAdd.add(btnRegStudentHasStudiedAdd);

		JLabel lblSsn = new JLabel("Ssn:");
		lblSsn.setBounds(60, 43, 46, 14);
		panelRegisterAdd.add(lblSsn);

		JLabel lblCourseCode = new JLabel("Course code:");
		lblCourseCode.setBounds(60, 248, 94, 14);
		panelRegisterAdd.add(lblCourseCode);

		//Button to register a new student
		JButton btnRegStudentAdd = new JButton("Add");
		btnRegStudentAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String ssn = textFieldRegStudentSsn.getText();
				String studentName = textFieldRegStudentName.getText();
				String studentAddress = textFieldRegStudentAddress.getText();
				String phoneNumber = textFieldRegStudentPhoneNumber.getText();
				responseLabelRegAdd.setForeground(Color.BLACK);

				if (ssn.isEmpty() || studentName.isEmpty() || studentAddress.isEmpty() || phoneNumber.isEmpty()) {
					responseLabelRegAdd.setForeground(Color.RED);
					responseLabelRegAdd.setText("All fields must be filled in");
				} else {
					try {
						controller.addStudent(ssn, studentName, studentAddress, phoneNumber);
						responseLabelRegAdd.setForeground(Color.GREEN);
						responseLabelRegAdd.setText("Student registered");
						textFieldRegStudentSsn.setText(null);
						textFieldRegStudentName.setText(null);
						textFieldRegStudentAddress.setText(null);
						textFieldRegStudentPhoneNumber.setText(null);
					} catch (SQLException sq) {
						responseLabelRegAdd.setForeground(Color.RED);
						responseLabelRegAdd.setText(ErrorResponse.getMessageForErrorCode(sq.getErrorCode(),
						"Student"));
					}
				}
			}
		});
		btnRegStudentAdd.setBounds(164, 170, 89, 23);
		panelRegisterAdd.add(btnRegStudentAdd);

		JPanel panelFind = new JPanel();
		tabbedPane_1.addTab("Find", null, panelFind, null);
		panelFind.setLayout(null);

		JLabel lblFindStudent = new JLabel("Find Student");
		lblFindStudent.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFindStudent.setBounds(161, 0, 122, 33);
		panelFind.add(lblFindStudent);

		JLabel lblFindCuurse = new JLabel("Find Course");
		lblFindCuurse.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFindCuurse.setBounds(593, 0, 96, 33);
		panelFind.add(lblFindCuurse);

		JLabel lblSearchForStudent = new JLabel("Search for Student");
		lblSearchForStudent.setBounds(54, 44, 145, 23);
		panelFind.add(lblSearchForStudent);

		JLabel lblSsn2 = new JLabel("SSN:");
		panelFind.add(lblSsn2);

		JLabel lblSearchForCourse = new JLabel("Search for Course");
		lblSearchForCourse.setBounds(462, 44, 145, 23);
		panelFind.add(lblSearchForCourse);

		JLabel lblCourseCode2 = new JLabel("Course Code:");
		panelFind.add(lblCourseCode2);

		JLabel responseLabelFind = new JLabel("");
		responseLabelFind.setBounds(178, 398, 633, 20);
		panelFind.add(responseLabelFind);

		textFieldFindStudentSsn = new JTextField();
		textFieldFindStudentSsn.setBounds(54, 78, 86, 20);
		panelFind.add(textFieldFindStudentSsn);
		textFieldFindStudentSsn.setColumns(10);

		textFieldFindCourseCourseCode = new JTextField();
		textFieldFindCourseCourseCode.setColumns(10);
		textFieldFindCourseCourseCode.setBounds(561, 75, 86, 20);
		panelFind.add(textFieldFindCourseCourseCode);

		dataModelCourseCode = new DefaultTableModel();
		tableCourseCode = new JTable(dataModelCourseCode);
		
		//Button to find a course
		JButton btnFindCourseFind = new JButton("Find");
		btnFindCourseFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String courseCode = textFieldFindCourseCourseCode.getText();
				responseLabelFind.setText("");
				responseLabelFind.setForeground(Color.BLACK);
				dataModelCourseCode.setRowCount(0);
				String[] headerFindCourse = { "Course Code", "Course Name", "Credits" };
				dataModelCourseCode.setColumnIdentifiers(headerFindCourse);
				
				try {
					if (courseCode.isEmpty()) {	
						responseLabelFind.setForeground(Color.RED);
						responseLabelFind.setText("Fill in blank");
					} else {
						responseLabelFind.setText(null);
						Course c = controller.getCourse(courseCode);
						if (c != null) {
							dataModelCourseCode
									.addRow(new Object[] { c.getCourseCode(), c.getCourseName(), c.getCredit() });
							responseLabelFind.setText("Course collected");
							responseLabelFind.setForeground(Color.GREEN);
						} else {
							responseLabelFind.setForeground(Color.RED);
							responseLabelFind.setText("Course does not exits");
						}
					}
				} catch (SQLException sqlException) {
					responseLabelFind.setForeground(Color.RED);
					responseLabelFind.setText(ErrorResponse.getMessageForErrorCode(sqlException.getErrorCode(),
					 ""));
				}
			}
		});
		btnFindCourseFind.setBounds(462, 126, 89, 23);
		panelFind.add(btnFindCourseFind);

	

		dataModelSsnStudent = new DefaultTableModel();
		tableSsnStudent = new JTable(dataModelSsnStudent);

		//Button to find a student
		JButton btnFindStudentFind = new JButton("Find");
		btnFindStudentFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String ssn = textFieldFindStudentSsn.getText();
				responseLabelFind.setText("");
				responseLabelFind.setForeground(Color.BLACK);
				dataModelSsnStudent.setRowCount(0);	
				String[] headerFindStudent = { "SSN", "Name", "Address", "Phone number" };
				dataModelSsnStudent.setColumnIdentifiers(headerFindStudent);
				
				try {
					if (ssn.isEmpty()) {					
						responseLabelFind.setForeground(Color.RED);
						responseLabelFind.setText("Fill in blanks");
					} else {
						responseLabelFind.setText(null);
						Student s = controller.getStudent(ssn);
						if (s != null) {
							dataModelSsnStudent.addRow(new Object[] { s.getSsn(), s.getStudentName(), s.getAddress(), s.getPhoneNumber() });
							responseLabelFind.setText("Student collected");
							responseLabelFind.setForeground(Color.GREEN);
						} else {
							responseLabelFind.setForeground(Color.RED);
							responseLabelFind.setText("Student does not exists");
						}
					}
				} catch (SQLException sqlException) {
					responseLabelFind.setForeground(Color.RED);
					responseLabelFind.setText(ErrorResponse.getMessageForErrorCode(sqlException.getErrorCode(),
					""));
				}
			}
		});
		btnFindStudentFind.setBounds(54, 126, 89, 23);
		panelFind.add(btnFindStudentFind);

		JLabel lblSsn_3 = new JLabel("Ssn:");
		lblSsn_3.setBounds(10, 81, 46, 14);
		panelFind.add(lblSsn_3);

		JLabel lblCourseCode_3 = new JLabel("Course code:");
		lblCourseCode_3.setBounds(462, 78, 89, 14);
		panelFind.add(lblCourseCode_3);

		JLabel lblCheckIfStudent = new JLabel("Check if Student studies a course");
		lblCheckIfStudent.setBounds(195, 44, 237, 23);
		panelFind.add(lblCheckIfStudent);

		textFieldFindStudentCheckSsn = new JTextField();
		textFieldFindStudentCheckSsn.setColumns(10);
		textFieldFindStudentCheckSsn.setBounds(301, 78, 86, 20);
		panelFind.add(textFieldFindStudentCheckSsn);
		
		//Button to check if a student studies a specific course
		JButton btnFindStudentCheck = new JButton("Check");
		btnFindStudentCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ssn = textFieldFindStudentCheckSsn.getText();
                String courseCode = textFieldFindStudentCheckCourseCode.getText();
                
                try {
                	Student s = controller.getStudentStudiesCourse(ssn, courseCode);
                    if (ssn.isEmpty()|| courseCode.isEmpty() ){  
                    	responseLabelFind.setForeground(Color.RED);
                    	responseLabelFind.setText("Fill in all blanks");
                    } else if  (s == null){
                    	responseLabelFind.setForeground(Color.RED);
                            responseLabelFind.setText("The student does not study the course");
                    }  else if (s != null) {
                    	responseLabelFind.setForeground(Color.GREEN);
                        responseLabelFind.setText("The student studies the course");
                    } 
                  } catch (SQLException sqlException) {
                        responseLabelFind.setText(ErrorResponse.getMessageForErrorCode(sqlException.getErrorCode(), "Kursen/Studenten"));
                    }
            }} );
		btnFindStudentCheck.setBounds(301, 160, 89, 23);
		panelFind.add(btnFindStudentCheck);

		JLabel label = new JLabel("Ssn:");
		label.setBounds(195, 81, 46, 14);
		panelFind.add(label);

		JLabel lblCourseCode_4 = new JLabel("Course code:");
		lblCourseCode_4.setBounds(195, 112, 103, 14);
		panelFind.add(lblCourseCode_4);

		textFieldFindStudentCheckCourseCode = new JTextField();
		textFieldFindStudentCheckCourseCode.setColumns(10);
		textFieldFindStudentCheckCourseCode.setBounds(301, 109, 86, 20);
		panelFind.add(textFieldFindStudentCheckCourseCode);

		//Button to find all students (extension)
		JButton btnFindStudentFindAll = new JButton("Find all");
		btnFindStudentFindAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				responseLabelFind.setText("");
				responseLabelFind.setForeground(Color.BLACK);
				dataModelSsnStudent.setRowCount(0);
				String[] headerFindStudent = { "SSN", "Name", "Address", "Phone number" };
				dataModelSsnStudent.setColumnIdentifiers(headerFindStudent);
				
				try {
					ArrayList<Student> allStudents = controller.getAllStudents();
					for (Student temp : allStudents) {
						dataModelSsnStudent.addRow(new Object[] { temp.getSsn(), temp.getStudentName(),
						temp.getAddress(), temp.getPhoneNumber() });
						responseLabelFind.setText("All Students collected");
						responseLabelFind.setForeground(Color.GREEN);
					}
				} catch (SQLException sqlException) {
					responseLabelFind.setForeground(Color.RED);
					responseLabelFind.setText(ErrorResponse.getMessageForErrorCode(sqlException.getErrorCode(),
					""));
				}
			}
		});
		btnFindStudentFindAll.setBounds(54, 160, 89, 23);
		panelFind.add(btnFindStudentFindAll);

		//Button to find all courses (extension)
		JButton btnFindCourseFindAll = new JButton("Find all");
		btnFindCourseFindAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dataModelCourseCode.setRowCount(0);
				String[] headerFindCourse = { "Course Code", "Course Name", "Credits" };
				dataModelCourseCode.setColumnIdentifiers(headerFindCourse);
				
				try {
					ArrayList<Course> allCourses = controller.getAllCourses();
					for (Course temp : allCourses) {
						dataModelCourseCode.addRow(new Object[] { temp.getCourseCode(), temp.getCourseName(),
								temp.getCredit() });
						responseLabelFind.setText("All Courses collected");
						responseLabelFind.setForeground(Color.GREEN);
					}
				} catch (SQLException sqlException) {
					responseLabelFind.setForeground(Color.RED);
					responseLabelFind.setText(ErrorResponse.getMessageForErrorCode(sqlException.getErrorCode(),
				 ""));
				}
			}
		});	
		btnFindCourseFindAll.setBounds(462, 160, 89, 23);
		panelFind.add(btnFindCourseFindAll);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(86, 358, 301, -134);
		panelFind.add(scrollPane);

		JScrollPane scrollPaneFindStudent = new JScrollPane(tableSsnStudent);
		scrollPaneFindStudent.setBounds(65, 211, 337, 147);
		panelFind.add(scrollPaneFindStudent);

		JScrollPane scrollPaneFindCourse = new JScrollPane(tableCourseCode);
		scrollPaneFindCourse.setBounds(462, 211, 349, 147);
		panelFind.add(scrollPaneFindCourse);
		
		JLabel lblSystemResponse = new JLabel("System response:");
		lblSystemResponse.setBounds(65, 401, 103, 14);
		panelFind.add(lblSystemResponse);

		JPanel panelCourseResult = new JPanel();
		tabbedPane_1.addTab("Course result", null, panelCourseResult, null);
		panelCourseResult.setLayout(null);

		JLabel lblCourseResult = new JLabel("Course result");
		lblCourseResult.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCourseResult.setBounds(410, 36, 115, 23);
		panelCourseResult.add(lblCourseResult);

		textFieldCourseResultCourseCode = new JTextField();
		textFieldCourseResultCourseCode.setBounds(180, 98, 89, 20);
		panelCourseResult.add(textFieldCourseResultCourseCode);
		textFieldCourseResultCourseCode.setColumns(10);

		JLabel lblCourseCode_5 = new JLabel("Course code:");
		lblCourseCode_5.setBounds(72, 101, 78, 14);
		panelCourseResult.add(lblCourseCode_5);
		
		JLabel labelCourseResultResponse = new JLabel("");
		labelCourseResultResponse.setBounds(172, 422, 688, 14);
		panelCourseResult.add(labelCourseResultResponse);
		
		//Get all grades from a specific student
		JButton btnCourseResultGetAllGrades = new JButton("Get all grades");
		btnCourseResultGetAllGrades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String courseCode = textFieldCourseResultCourseCode.getText();
                dataModelHighestThroughput.setRowCount(0);
                
                String[] headerCourseResult = {"Course Code", "SSN", "Grade", "Semester" };
                dataModelHighestThroughput.setColumnIdentifiers(headerCourseResult);
                labelCourseResultResponse.setText("");
                labelCourseResultResponse.setForeground(Color.BLACK);
                   
                   try {  
                       ArrayList<HasStudied> hs = controller.getAllStudentsGradesCourse(courseCode);
                   if (courseCode.isEmpty()) {
                       labelCourseResultResponse.setText("Course Code must be filled in");
                       labelCourseResultResponse.setForeground(Color.RED);
                   } else if (hs.isEmpty()) {
                       labelCourseResultResponse.setText("Course does not have any grades");
                       labelCourseResultResponse.setForeground(Color.RED);
                   } else {
                       for (HasStudied temp : hs)
                       dataModelHighestThroughput.addRow(new Object[]{temp.getCourseCode(), temp.getSsn(), temp.getGrade(), temp.getSemester()});
                       labelCourseResultResponse.setText("All grades collected");
                       labelCourseResultResponse.setForeground(Color.GREEN);
                   }
                   } catch (SQLException sq) {
                       responseLabelRegAdd.setForeground(Color.RED);
                       responseLabelRegAdd.setText(ErrorResponse.getMessageForErrorCode(sq.getErrorCode(), "vem �r h�r?"));
                   }
           }
       });		
		btnCourseResultGetAllGrades.setBounds(180, 132, 176, 23);
		panelCourseResult.add(btnCourseResultGetAllGrades);

		dataModelHighestThroughput = new DefaultTableModel();
		tableHighestThroughput = new JTable(dataModelHighestThroughput);
		
		//Button to get highest throughput
		JButton btnGet = new JButton("Get");
		btnGet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dataModelHighestThroughput.setRowCount(0);
				String[] headerHighestThroughput = { "Course code", "Percent passed" };
				dataModelHighestThroughput.setColumnIdentifiers(headerHighestThroughput);

				try {
					HashMap<String, String> highestTP = controller.getHighestThroughput();

					for (Map.Entry<String, String> entry : highestTP.entrySet()) {
						String courseCode = entry.getKey();
						String percent = entry.getValue();
						dataModelHighestThroughput.addRow(new Object[] { courseCode, percent + "%" });
					}
				} catch (SQLException sqlException) {
					sqlException.printStackTrace();
					 labelCourseResultResponse.setText(ErrorResponse.getMessageForErrorCode(sqlException.getErrorCode(),
					""));
				}
			}
		});
		btnGet.setBounds(603, 132, 89, 23);
		panelCourseResult.add(btnGet);

		JLabel lblHighestThroughput = new JLabel("Highest throughput:");
		lblHighestThroughput.setBounds(603, 101, 129, 14);
		panelCourseResult.add(lblHighestThroughput);

		JScrollPane scrollPaneCourseResultHighestThroughput = new JScrollPane(tableHighestThroughput);
		scrollPaneCourseResultHighestThroughput.setBounds(180, 249, 515, 148);
		panelCourseResult.add(scrollPaneCourseResultHighestThroughput);
		
		JLabel lblSystemRespons_1 = new JLabel("System response:");
		lblSystemRespons_1.setBounds(60, 422, 104, 14);
		panelCourseResult.add(lblSystemRespons_1);
		
		dataModelCourseResult = new DefaultTableModel();
		tableCourseResult = new JTable(dataModelCourseResult);
		
		//Button to get grade % from a specific course
		JButton btnCourseResultGetGradePercentage = new JButton("Get grade %");
		btnCourseResultGetGradePercentage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			dataModelHighestThroughput.setRowCount(0);
		    labelCourseResultResponse.setText("");
		    String courseCode = textFieldCourseResultCourseCode.getText();
		    String[] headerShowFlow = { "Grade", "Percentage" };
		    dataModelHighestThroughput.setColumnIdentifiers(headerShowFlow);
		    
		    try {
		    	HashMap<String, String> tmp = controller.getGradePercentage(courseCode);
		    	if (courseCode.isEmpty()) {
		            labelCourseResultResponse.setText("Fill in course code");
		            labelCourseResultResponse.setForeground(Color.RED);
		        } else {
		            if (tmp.isEmpty()) {
		                labelCourseResultResponse.setText("The course does not exist or no student have completed the course yet");
		                labelCourseResultResponse.setForeground(Color.RED);
		            } else {
		                for (Map.Entry<String, String> entry : tmp.entrySet()) {
		                    
		                    dataModelHighestThroughput.addRow(new Object[] { entry.getKey(), entry.getValue() + "%" });
		                    labelCourseResultResponse.setText("Grade percentage collected");
		                    labelCourseResultResponse.setForeground(Color.GREEN);
		                }
		            }
		        }
		    } catch (SQLException sqlException) {
		       labelCourseResultResponse.setText(ErrorResponse.getMessageForErrorCode(sqlException.getErrorCode(), ""));
		    }
		}
		}); 
		btnCourseResultGetGradePercentage.setBounds(180, 166, 176, 23);
		panelCourseResult.add(btnCourseResultGetGradePercentage);
		
		//Button to get all current students from a course
		JButton btnCourseResultGetAllCurrent = new JButton("Get all current students");
		btnCourseResultGetAllCurrent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String courseCode = textFieldCourseResultCourseCode.getText();
                dataModelHighestThroughput.setRowCount(0);
                String [] headerCourseResults = {"Ssn", "Student Name", "Address", "Phone Number"};
                dataModelHighestThroughput.setColumnIdentifiers(headerCourseResults);
                labelCourseResultResponse.setText("");
                labelCourseResultResponse.setForeground(Color.BLACK);
                
                try { ArrayList<Student> studiesCourse = controller.getAllStudentsStudiesCourse(courseCode);
                    if (courseCode.isEmpty()) {
                        labelCourseResultResponse.setText("Fill in course code");
                        labelCourseResultResponse.setForeground(Color.RED);
                        }
                    else if (studiesCourse.isEmpty()) {
                        labelCourseResultResponse.setText("No students are studying the course");
                        labelCourseResultResponse.setForeground(Color.RED);
                    } else {
                        for (Student temp : studiesCourse) {
                            dataModelHighestThroughput.addRow(new Object []  { temp.getSsn(), temp.getStudentName(), temp.getAddress( ), temp.getPhoneNumber()});
                            labelCourseResultResponse.setText("All current students collected");
                            labelCourseResultResponse.setForeground(Color.GREEN);
                        }
                    }
                }
                    catch (SQLException sqlException) {
                      labelCourseResultResponse.setText(ErrorResponse.getMessageForErrorCode(sqlException.getErrorCode(), "Kursen/Studenten"));
                    }
                    }});
		btnCourseResultGetAllCurrent.setBounds(180, 200, 176, 23);
		panelCourseResult.add(btnCourseResultGetAllCurrent);
		
		JPanel panel_11 = new JPanel();
		tabbedPane_1.addTab("Student result", null, panel_11, null);
		panel_11.setLayout(null);

		JLabel lblStudentResult = new JLabel("Student result");
		lblStudentResult.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStudentResult.setBounds(377, 16, 100, 14);
		panel_11.add(lblStudentResult);

		textFieldStudentResultSsn = new JTextField();
		textFieldStudentResultSsn.setBounds(185, 86, 100, 20);
		panel_11.add(textFieldStudentResultSsn);
		textFieldStudentResultSsn.setColumns(10);
		
		JLabel labelStudentResultResponse = new JLabel("");
		labelStudentResultResponse.setBounds(164, 406, 652, 20);
		panel_11.add(labelStudentResultResponse);

		JLabel lblSsn_4 = new JLabel("Ssn:");
		lblSsn_4.setBounds(129, 89, 46, 14);
		panel_11.add(lblSsn_4);

		//Button to find all grades a student have
		JButton btnStudentResultGetGrades = new JButton("Get grades");
		btnStudentResultGetGrades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ssn = textFieldStudentResultSsn.getText();
                dataModelStudentResult.setRowCount(0);
                String [] headerGetGrades = {"Course Code", "SSN", "Grade", "Semester"};
                dataModelStudentResult.setColumnIdentifiers(headerGetGrades);
                labelStudentResultResponse.setText("");
                labelStudentResultResponse.setForeground(Color.BLACK);
                
                try { ArrayList<HasStudied> hs = controller.getStudentAllGrades(ssn);  
                if (ssn.isEmpty()) {
                        labelStudentResultResponse.setForeground(Color.RED);
                        labelStudentResultResponse.setText("Fill in SSN");
                    }
                    else if (hs.isEmpty())  {
                        labelStudentResultResponse.setText("The student has no grades");
                        labelStudentResultResponse.setForeground(Color.RED);
                    }  
                    else {
                            for (HasStudied temp : hs)
                            dataModelStudentResult.addRow(new Object[]{temp.getCourseCode(), temp.getSsn(), temp.getGrade(), temp.getSemester()});
                            labelStudentResultResponse.setText("All grades collected");
                            labelStudentResultResponse.setForeground(Color.GREEN);
                    }
                    //Bug in the system, can not get response specifically if the student does not exist compared to if the student does not study any courses
                }catch (SQLException sqlException) {labelStudentResultResponse.setText("error");
                }
            }});
		btnStudentResultGetGrades.setBounds(184, 127, 180, 23);
		panel_11.add(btnStudentResultGetGrades);
	
		dataModelStudentResult = new DefaultTableModel();
		tableStudentResult = new JTable(dataModelStudentResult);
		
		JScrollPane scrollPaneStudentResult = new JScrollPane(tableStudentResult); //Vilken JTable ska in h�r??
		scrollPaneStudentResult.setBounds(184, 214, 544, 165);
		panel_11.add(scrollPaneStudentResult);
		
		//Button to find all courses a student currently studies
		JButton btnStudentResultGetCurrentCourses = new JButton("Get current courses");
		btnStudentResultGetCurrentCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String ssn = textFieldStudentResultSsn.getText();
				dataModelStudentResult.setRowCount(0);
                String [] headerStudentResult = {"Course Code", "Course Name", "Credit"};
                dataModelStudentResult.setColumnIdentifiers(headerStudentResult);
                labelStudentResultResponse.setText("");
                labelStudentResultResponse.setForeground(Color.BLACK);
               
                try { ArrayList<Course> studies = controller.getAllCoursesStudies(ssn);
                    if (ssn.isEmpty()) {
                        labelStudentResultResponse.setText("Fill in SSN");
                        labelStudentResultResponse.setForeground(Color.RED);
                    }
                    else if (studies.isEmpty()) {
                        labelStudentResultResponse.setText("Student does not study any courses");
                        labelStudentResultResponse.setForeground(Color.RED);
                    } else {
                        for (Course temp : studies) {
                            dataModelStudentResult.addRow(new Object []  { temp.getCourseCode(), temp.getCourseName(), temp.getCredit()});
                            labelStudentResultResponse.setText("All current courses collected");
                            labelStudentResultResponse.setForeground(Color.GREEN);
                            
                        }
                    }
                   }    
                    catch (SQLException sqlException) {
                    labelStudentResultResponse.setText(ErrorResponse.getMessageForErrorCode(sqlException.getErrorCode(), "Kursen/Studenten"));
                    }
                
                    }
			});
		
		btnStudentResultGetCurrentCourses.setBounds(184, 161, 180, 23);
		panel_11.add(btnStudentResultGetCurrentCourses);
		
		textFieldStudentResultCourseCode = new JTextField();
		textFieldStudentResultCourseCode.setBounds(628, 128, 100, 20);
		panel_11.add(textFieldStudentResultCourseCode);
		textFieldStudentResultCourseCode.setColumns(10);
		
		JLabel lblCourseCode_6 = new JLabel("Course Code");
		lblCourseCode_6.setBounds(546, 131, 81, 14);
		panel_11.add(lblCourseCode_6);
		
		//Button to find a specific students grade from a specific (finished) course
		JButton btnStudentResultGetGradeCourse = new JButton("Get grade on course");
		btnStudentResultGetGradeCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ssn = textFieldStudentResultSsn2.getText();
                String courseCode = textFieldStudentResultCourseCode.getText();
                dataModelStudentResult.setRowCount(0);
                String [] headerGetGradeCourse = {"Course Code", "SSN", "Grade", "Semester"} ;
                dataModelStudentResult.setColumnIdentifiers(headerGetGradeCourse);
                labelStudentResultResponse.setText("");
                labelStudentResultResponse.setForeground(Color.BLACK);
              
                try {
                    HasStudied s = controller.getStudentGradeCourse(ssn, courseCode);
                    if (ssn.isEmpty()|| courseCode.isEmpty() ){  
                        labelStudentResultResponse.setForeground(Color.RED);
                        labelStudentResultResponse.setText("Fill in all blanks"); 
                    } else if  (s == null){
                        labelStudentResultResponse.setForeground(Color.RED);
                            labelStudentResultResponse.setText("The student have not completed the course");
                    }  else if (s != null) {
                    	HasStudied st =controller.getStudentGradeCourse(ssn, courseCode);
                        dataModelStudentResult.addRow(new Object[] {st.getSsn(),st.getCourseCode(), st.getSemester(), st.getGrade()});
                        labelStudentResultResponse.setText("Grade for the completed course collected");
                        labelStudentResultResponse.setForeground(Color.GREEN);
                    }
                        } catch (SQLException sqlException) {
                            responseLabelFind.setText(ErrorResponse.getMessageForErrorCode(sqlException.getErrorCode(), "Kursen/Studenten"));
                        }
                    }});
		btnStudentResultGetGradeCourse.setBounds(546, 161, 184, 23);
		panel_11.add(btnStudentResultGetGradeCourse);
		
		textFieldStudentResultSsn2 = new JTextField();
		textFieldStudentResultSsn2.setBounds(627, 86, 101, 20);
		panel_11.add(textFieldStudentResultSsn2);
		textFieldStudentResultSsn2.setColumns(10);
		
		JLabel lblSsn_5 = new JLabel("Ssn:");
		lblSsn_5.setBounds(548, 89, 46, 14);
		panel_11.add(lblSsn_5);
		
		JLabel lblGradeForCourse = new JLabel("Student grade on course");
		lblGradeForCourse.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblGradeForCourse.setBounds(593, 40, 184, 23);
		panel_11.add(lblGradeForCourse);
		
		JLabel lblSystemRespons = new JLabel("System response:");
		lblSystemRespons.setBounds(43, 412, 111, 14);
		panel_11.add(lblSystemRespons);

		JPanel panel_9 = new JPanel();
		tabbedPane_2.addTab("Assignment 2", null, panel_9, null);
		panel_9.setLayout(null);
		
		JComboBox <String >comboBoxAss2EmployeeTable = new JComboBox<String>();
		comboBoxAss2EmployeeTable.addItem("");
		comboBoxAss2EmployeeTable.addItem("Employee");
		comboBoxAss2EmployeeTable.addItem("Employee Relatives");
		comboBoxAss2EmployeeTable.addItem("Employee Absence");
		comboBoxAss2EmployeeTable.addItem("Employee Qualification");
		comboBoxAss2EmployeeTable.addItem("Statistics Group");
		comboBoxAss2EmployeeTable.addItem("Portal Setup ");
		comboBoxAss2EmployeeTable.setBounds(72, 87, 348, 35);
		panel_9.add(comboBoxAss2EmployeeTable); //Riley har n�n j�vla string h�r inne
		
		/*JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(549, 159, 259, -37);
		panel_9.add(comboBox_1);*/
		
		JLabel labelAss2Response = new JLabel("");
		labelAss2Response.setBounds(164, 450, 682, 14);
		panel_9.add(labelAss2Response);
		
		JComboBox <String> comboBoxAss2Metadata = new JComboBox <String>();
		comboBoxAss2Metadata.addItem("");
		comboBoxAss2Metadata.addItem("All Keys");
		comboBoxAss2Metadata.addItem("All Indexes");
		comboBoxAss2Metadata.addItem("All Constraints");
		comboBoxAss2Metadata.addItem("All tables in the database: Option 1");
		comboBoxAss2Metadata.addItem("All tables in the database: Option 2");
		comboBoxAss2Metadata.addItem("All columns for Employee Table: Option 1");
		comboBoxAss2Metadata.addItem("All columns for Employee Table: Option 2");
		comboBoxAss2Metadata.addItem("Table with highest number of rows");
		comboBoxAss2Metadata.setBounds(491, 87, 348, 35);
		panel_9.add(comboBoxAss2Metadata);
		
		dataModelAss2 = new DefaultTableModel();
		tableAss2 = new JTable(dataModelAss2);
		
		
		JButton btnAss2FindEmployeeTable = new JButton("Get table");
		btnAss2FindEmployeeTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String chosenTable = (String) comboBoxAss2EmployeeTable.getSelectedItem();
				dataModelAss2.setRowCount(0);
				labelAss2Response.setText(null);
				if (chosenTable.equals("")) {
					labelAss2Response.setText("Choose a table");
					labelAss2Response.setForeground(Color.RED);
				} else {
					try {
						if (chosenTable == "Employee" ) { 
							controller2.updateEmployee(dataModelAss2);
							labelAss2Response.setText("Table collected");
							labelAss2Response.setForeground(Color.GREEN);
						
						} else if (chosenTable == "Employee Relatives") {
							controller2.updateRelatives(dataModelAss2);
							labelAss2Response.setText("Table collected");
							labelAss2Response.setForeground(Color.GREEN);
						
						} else if (chosenTable == "Employee Absence") {
							controller2.updateAbsence(dataModelAss2);
							labelAss2Response.setText("Table collected");
							labelAss2Response.setForeground(Color.GREEN);
						
						} else if (chosenTable == "Employee Qualification") {
							controller2.updateQualification(dataModelAss2);
							labelAss2Response.setText("Table collected");
							labelAss2Response.setForeground(Color.GREEN);
				        
						} else if (chosenTable == "Statistics Group") {
							controller2.updateStatisticsGroup(dataModelAss2);
							labelAss2Response.setText("Table collected");
							labelAss2Response.setForeground(Color.GREEN);
							
						} else if (chosenTable == "Portal Setup") {
								controller2.updatePortalSetup(dataModelAss2);
								labelAss2Response.setText("Table collected");
								labelAss2Response.setForeground(Color.GREEN);
						}
					} catch (SQLException sqlException) {
						labelAss2Response.setText(ErrorResponse.getMessageForErrorCode(sqlException.getErrorCode(), "System failure"));
					}
			}
			}
		});
				
		btnAss2FindEmployeeTable.setBounds(72, 146, 89, 23);
		panel_9.add(btnAss2FindEmployeeTable);
		
		JButton btnFindAss2FindMetadata = new JButton("Get metadata");
		btnFindAss2FindMetadata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String chosenMetadata = (String)comboBoxAss2Metadata.getSelectedItem();
				labelAss2Response.setText("");
				dataModelAss2.setRowCount(0);
				if (chosenMetadata.equals("")) {
					labelAss2Response.setText("Choose Metadata");
					labelAss2Response.setForeground(Color.RED);
				} else {
					try {
						if (chosenMetadata == "All Keys") {
							controller2.updateAllKeys(dataModelAss2);
							labelAss2Response.setText("Metadata collected");
							labelAss2Response.setForeground(Color.GREEN);
							
						} else if (chosenMetadata == "All Indexes") {
							controller2.updateIndexes(dataModelAss2);
							labelAss2Response.setText("Metadata collected");
							labelAss2Response.setForeground(Color.GREEN);
							
						} else if (chosenMetadata == "All Constraints") {
							controller2.updateConstraints(dataModelAss2);
							labelAss2Response.setText("Metadata collected");
							labelAss2Response.setForeground(Color.GREEN);
							
						} else if (chosenMetadata == "All tables in the database: Option 1") {
							controller2.updateTables(dataModelAss2);
							labelAss2Response.setText("Metadata collected");
							labelAss2Response.setForeground(Color.GREEN);
							
						} else if (chosenMetadata == "All tables in the database: Option 2") {
							controller2.updateTablesTwo(dataModelAss2);
							labelAss2Response.setText("Metadata collected");
							labelAss2Response.setForeground(Color.GREEN);
							
						} else if (chosenMetadata == "All columns for Employee Table: Option 1") {
							controller2.updateColumns(dataModelAss2);
							labelAss2Response.setText("Metadata collected");
							labelAss2Response.setForeground(Color.GREEN);
							
						} else if (chosenMetadata == "All columns for Employee Table: Option 2") {
							controller2.updateColumnsTwo(dataModelAss2);
							labelAss2Response.setText("Metadata collected");
							labelAss2Response.setForeground(Color.GREEN);
							
						} else if (chosenMetadata == "Table with highest number of rows") {
							controller2.updateTableNameMostRows(dataModelAss2);
							labelAss2Response.setText("Metadata collected");
							labelAss2Response.setForeground(Color.GREEN);
						}
					} catch (SQLException sqlException) {
						//labelAss2Response.setText(errorResponse.getMessageForErrorCode(sqlException.getErrorCode()));
						
						
						
					}
				}
			}
		});
		btnFindAss2FindMetadata.setBounds(491, 146, 114, 23);
		panel_9.add(btnFindAss2FindMetadata);
		
		
		JLabel lblSystemResponse_1 = new JLabel("System response:");
		lblSystemResponse_1.setBounds(31, 450, 114, 14);
		panel_9.add(lblSystemResponse_1);
		
		JScrollPane scrollPaneAssignment2 = new JScrollPane(tableAss2);
		scrollPaneAssignment2.setBounds(72, 193, 776, 218);
		panel_9.add(scrollPaneAssignment2);
		
		JLabel lblEmployeeAndRelational = new JLabel("Content and metadata of Employee and related tables");
		lblEmployeeAndRelational.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmployeeAndRelational.setBounds(72, 41, 348, 14);
		panel_9.add(lblEmployeeAndRelational);
		
		JLabel lblMetadataForCronus = new JLabel("Metadata of Cronus");
		lblMetadataForCronus.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMetadataForCronus.setBounds(491, 41, 132, 14);
		panel_9.add(lblMetadataForCronus);
		
		JButton btnNewButton = new JButton("Get metadata");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String choosenTableMetaData = (String) comboBoxAss2EmployeeTable.getSelectedItem();
				labelAss2Response.setText(null);
				dataModelAss2.setRowCount(0);
				if (choosenTableMetaData.equals("")) {
					labelAss2Response.setText("Choose a table for metadata");
					labelAss2Response.setForeground(Color.RED);
					
				} else {
					try {
						if (choosenTableMetaData.equals ("Employee")) {
							controller2.updateEmployeeMetaData(dataModelAss2, "");
							labelAss2Response.setText("Metadata collected");
							labelAss2Response.setForeground(Color.GREEN);
						} else { 
							controller2.updateEmployeeMetaData(dataModelAss2, choosenTableMetaData);
							labelAss2Response.setText("Metadata collected");
							labelAss2Response.setForeground(Color.GREEN);
							}
						}  catch (SQLException sqlException) {
							labelAss2Response.setText(ErrorResponse.getMessageForErrorCode(sqlException.getErrorCode(), "System failure"));
						}
					}
				}
				
			
		});
		btnNewButton.setBounds(189, 146, 114, 23);
		panel_9.add(btnNewButton);

		JPanel panel_10 = new JPanel();
		tabbedPane_2.addTab("Assignment 3", null, panel_10, null);
		panel_10.setLayout(null);
    
    
	    JLabel labelTask3Response = new JLabel("");
	    labelTask3Response.setBounds(156, 427, 666, 14);
	    panel_10.add(labelTask3Response);
	    
	
	    JLabel lblSelectQuestionAnd = new JLabel("Select question and choose a program to open file with");
	    lblSelectQuestionAnd.setFont(new Font("Tahoma", Font.BOLD, 12));
	    lblSelectQuestionAnd.setBounds(21, 91, 364, 14);
	    panel_10.add(lblSelectQuestionAnd);
	    
	    JComboBox<String> comboBoxTask3 = new JComboBox<String>();
	    comboBoxTask3.addItem("1. How much is 100 NOK?");
		comboBoxTask3.addItem("2. What value is traded for the most amount of SEK?");
		comboBoxTask3.addItem("3. At which address and in what city is Fotograferna AB located?");
		comboBoxTask3.addItem("4. Names of all employees who have been ill/sick.");
		comboBoxTask3.addItem("5. Name and family relation for all employees' relatives.");
		comboBoxTask3.addItem("6. What customers are handled bby (employee) Andreas Berglund?");
		comboBoxTask3.addItem("7. What bank accounts belong to the customer with customer number 10 000?");
	    comboBoxTask3.setBounds(21, 128, 462, 31);
	    panel_10.add(comboBoxTask3);
    
	    JButton btnExcelQuestion = new JButton("Excel");
	    btnExcelQuestion.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent arg0) {
	            
	        	int index = comboBoxTask3.getSelectedIndex();
	            labelTask3Response.setText("");
	            String fileName = "Excel" + (index + 1) + ".xlsx";
	            
	            try {
	                controller3.openFile(fileName);
	            } catch (Exception exception) {
	            	labelTask3Response.setText("File does not exist");
	            }    
	        }
	    });
	    btnExcelQuestion.setBounds(151, 194, 97, 31);
	    panel_10.add(btnExcelQuestion);
    
	    JButton btnAccessQuestion = new JButton("Access");
	    btnAccessQuestion.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	            
	    		int index = comboBoxTask3.getSelectedIndex();
	            labelTask3Response.setText("");
	            String fileName = "Access" + (index + 1) + ".accdb";
	            
	            try {
	                controller3.openFile(fileName);
	            } catch (Exception exception) {
	            	labelTask3Response.setText("File does not exist");
	            }    
	        }
	    });    
	    btnAccessQuestion.setBounds(21, 194, 97, 31);
	    panel_10.add(btnAccessQuestion);
	    
	    JButton btnExcelReportEmployees = new JButton("Excel");
	    btnExcelReportEmployees.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	labelTask3Response.setText("");
	              String fileName = "EmployeeReportExcel" + ".xlsx";
	              
	              try {
	                  controller3.openFile(fileName);
	              } catch (Exception exception) {
	              	labelTask3Response.setText("File does not exist");
	              }  
	    	}
	    });
	    btnExcelReportEmployees.setBounds(672, 140, 97, 31);
	    panel_10.add(btnExcelReportEmployees);
    
	    JButton btnAccessReportEmployees = new JButton("Access");
	    btnAccessReportEmployees.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		  labelTask3Response.setText("");
	              String fileName = "EmployeeReportAccess" + ".accdb";
	              
	              try {
	                  controller3.openFile(fileName);
	              } catch (Exception exception) {
	              	labelTask3Response.setText("File does not exist");
	              }    
	    	}
	    });
	    btnAccessReportEmployees.setBounds(541, 140, 97, 31);
	    panel_10.add(btnAccessReportEmployees);
	    
	    JButton btnExcelReportCustomer = new JButton("Excel");
	    btnExcelReportCustomer.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	labelTask3Response.setText("");
	              String fileName = "CustomerReportExcel" + ".xlsx";
	              
	              try {
	                  controller3.openFile(fileName);
	              } catch (Exception exception) {
	              	labelTask3Response.setText("File does not exist");
	              }  
	    	}
	    });
	    btnExcelReportCustomer.setBounds(672, 294, 97, 31);
	    panel_10.add(btnExcelReportCustomer);
		    
	    JButton btnAccessReportCustomers = new JButton("Access");
	    btnAccessReportCustomers.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	labelTask3Response.setText("");    
	              String fileName = "CustomerReportAccess" + ".accdb";
	              
	              try {
	                  controller3.openFile(fileName);
	              } catch (Exception exception) {
	              	labelTask3Response.setText("File does not exist");
	              }  
	    	}
	    });
	    btnAccessReportCustomers.setBounds(541, 294, 97, 31);
	    panel_10.add(btnAccessReportCustomers);
		    
	    JLabel lblChooseProgramTo = new JLabel("Choose program to open file All Employees:");
	    lblChooseProgramTo.setFont(new Font("Tahoma", Font.BOLD, 12));
	    lblChooseProgramTo.setBounds(541, 91, 283, 14);
	    panel_10.add(lblChooseProgramTo);
	    
	    JLabel lblChooseProgramTo_1 = new JLabel("Choose program to open file All Customers:");
	    lblChooseProgramTo_1.setFont(new Font("Tahoma", Font.BOLD, 12));
	    lblChooseProgramTo_1.setBounds(541, 248, 268, 14);
	    panel_10.add(lblChooseProgramTo_1);
	    
	    JLabel lblSystemMessage = new JLabel("System response:");
	    lblSystemMessage.setBounds(49, 427, 103, 14);
	    panel_10.add(lblSystemMessage);
    
  
}
}
