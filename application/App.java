package application;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

import model.*;
import controller.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class App {

	private JFrame frame;
	private JTextField textFieldStudentSsn;
	private JTextField textFieldCoursecode;
	private JTable table;
	
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	

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
		frame.setBounds(100, 100, 929, 497);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_2.setBackground(SystemColor.activeCaption);
		tabbedPane_2.setBounds(0, 0, 913, 458);
		frame.getContentPane().add(tabbedPane_2);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBackground(SystemColor.activeCaption);
		tabbedPane_2.addTab("Assignment 1", null, tabbedPane_1, null);
		

		  JPanel panel_13 = new JPanel();
		        tabbedPane_1.addTab("Register / Add", null, panel_13, null);
		        panel_13.setLayout(null);
		        
		        JLabel lblNewLabel = new JLabel("Register student");
		        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		        lblNewLabel.setBounds(164, 0, 119, 45);
		        panel_13.add(lblNewLabel);
		        
		        textField = new JTextField();
		        textField.setBounds(164, 40, 119, 20);
		        panel_13.add(textField);
		        textField.setColumns(10);
		        
		        textField_1 = new JTextField();
		        textField_1.setBounds(164, 71, 119, 20);
		        panel_13.add(textField_1);
		        textField_1.setColumns(10);
		        
		        textField_2 = new JTextField();
		        textField_2.setBounds(164, 102, 119, 20);
		        panel_13.add(textField_2);
		        textField_2.setColumns(10);
		        
		        textField_3 = new JTextField();
		        textField_3.setBounds(164, 133, 119, 20);
		        panel_13.add(textField_3);
		        textField_3.setColumns(10);
		        
		        JLabel lblName = new JLabel("Name:");
		        lblName.setBounds(60, 74, 46, 14);
		        panel_13.add(lblName);
		        
		        JLabel lblAddress = new JLabel("Address:");
		        lblAddress.setBounds(60, 105, 71, 14);
		        panel_13.add(lblAddress);
		        
		        JLabel lblPhoneNumber = new JLabel("Phone number:");
		        lblPhoneNumber.setBounds(60, 136, 94, 14);
		        panel_13.add(lblPhoneNumber);
		        
		        JLabel lblRegisterCourse = new JLabel("Register course");
		        lblRegisterCourse.setFont(new Font("Tahoma", Font.BOLD, 13));
		        lblRegisterCourse.setBounds(164, 214, 119, 20);
		        panel_13.add(lblRegisterCourse);
		        
		        textField_4 = new JTextField();
		        textField_4.setBounds(164, 245, 119, 20);
		        panel_13.add(textField_4);
		        textField_4.setColumns(10);
		        
		        textField_5 = new JTextField();
		        textField_5.setBounds(164, 276, 119, 20);
		        panel_13.add(textField_5);
		        textField_5.setColumns(10);
		        
		        JLabel lblName_1 = new JLabel("Name:");
		        lblName_1.setBounds(60, 279, 46, 14);
		        panel_13.add(lblName_1);
		        
		        textField_6 = new JTextField();
		        textField_6.setBounds(164, 307, 119, 20);
		        panel_13.add(textField_6);
		        textField_6.setColumns(10);
		        
		        JButton btnDelete = new JButton("Delete");
		        btnDelete.setBounds(270, 170, 89, 23);
		        panel_13.add(btnDelete);
		        
		        JLabel lblCredits = new JLabel("Credits:");
		        lblCredits.setBounds(60, 310, 46, 14);
		        panel_13.add(lblCredits);
		        
		        JButton btnAdd_1 = new JButton("Add");
		        btnAdd_1.setBounds(164, 345, 89, 23);
		        panel_13.add(btnAdd_1);
		        
		        JButton btnDelete_1 = new JButton("Delete");
		        btnDelete_1.setBounds(270, 345, 89, 23);
		        panel_13.add(btnDelete_1);
		        
		        JLabel lblRegisterStudentTo = new JLabel("Register student to ongoing course");
		        lblRegisterStudentTo.setFont(new Font("Tahoma", Font.BOLD, 13));
		        lblRegisterStudentTo.setBounds(561, 12, 253, 20);
		        panel_13.add(lblRegisterStudentTo);
		        
		        JLabel lblSsn_1 = new JLabel("Ssn:");
		        lblSsn_1.setBounds(474, 43, 46, 14);
		        panel_13.add(lblSsn_1);
		        
		        textField_7 = new JTextField();
		        textField_7.setBounds(561, 40, 136, 20);
		        panel_13.add(textField_7);
		        textField_7.setColumns(10);
		        
		        textField_8 = new JTextField();
		        textField_8.setBounds(561, 71, 136, 20);
		        panel_13.add(textField_8);
		        textField_8.setColumns(10);
		        
		        JLabel lblCourseCode_1 = new JLabel("Course code:");
		        lblCourseCode_1.setBounds(474, 74, 79, 14);
		        panel_13.add(lblCourseCode_1);
		        
		        textField_9 = new JTextField();
		        textField_9.setBounds(561, 102, 136, 20);
		        panel_13.add(textField_9);
		        textField_9.setColumns(10);
		        
		        JLabel lblSemester = new JLabel("Semester:");
		        lblSemester.setBounds(474, 105, 62, 14);
		        panel_13.add(lblSemester);
		        
		        JButton btnAdd_2 = new JButton("Add");
		        btnAdd_2.setBounds(561, 140, 89, 23);
		        panel_13.add(btnAdd_2);
		        
		        JButton btnDelete_2 = new JButton("Delete");
		        btnDelete_2.setBounds(672, 140, 89, 23);
		        panel_13.add(btnDelete_2);
		        
		        JLabel lblRegisterStudentTo_1 = new JLabel("Register student to finished course");
		        lblRegisterStudentTo_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		        lblRegisterStudentTo_1.setBounds(561, 183, 263, 17);
		        panel_13.add(lblRegisterStudentTo_1);
		        
		        textField_10 = new JTextField();
		        textField_10.setBounds(561, 211, 136, 20);
		        panel_13.add(textField_10);
		        textField_10.setColumns(10);
		        
		        textField_11 = new JTextField();
		        textField_11.setBounds(561, 242, 136, 20);
		        panel_13.add(textField_11);
		        textField_11.setColumns(10);
		        
		        textField_12 = new JTextField();
		        textField_12.setBounds(561, 273, 136, 20);
		        panel_13.add(textField_12);
		        textField_12.setColumns(10);
		        
		        JLabel lblSsn_2 = new JLabel("Ssn:");
		        lblSsn_2.setBounds(474, 218, 46, 14);
		        panel_13.add(lblSsn_2);
		        
		        JLabel lblCourseCode_2 = new JLabel("Course code:");
		        lblCourseCode_2.setBounds(474, 248, 79, 14);
		        panel_13.add(lblCourseCode_2);
		        
		        JLabel lblGrade = new JLabel("Semester:");
		        lblGrade.setBounds(474, 279, 62, 14);
		        panel_13.add(lblGrade);
		        
		        JLabel lblGrade_1 = new JLabel("Grade:");
		        lblGrade_1.setBounds(474, 310, 46, 14);
		        panel_13.add(lblGrade_1);
		        
		        JButton btnAdd_3 = new JButton("Add");
		        btnAdd_3.setBounds(561, 345, 89, 23);
		        panel_13.add(btnAdd_3);
		        
		        JButton btnDelete_3 = new JButton("Delete");
		        btnDelete_3.setBounds(672, 345, 89, 23);
		        panel_13.add(btnDelete_3);
		        
		        JList list = new JList();
		        list.setBounds(392, 276, -50, -41);
		        panel_13.add(list);
		        
		        JScrollBar scrollBar = new JScrollBar();
		        scrollBar.setBounds(561, 304, 17, 29);
		        panel_13.add(scrollBar);
		
		JPanel panel_11 = new JPanel();
		tabbedPane_1.addTab("View Results", null, panel_11, null);
		
		JPanel panel_12 = new JPanel();
		tabbedPane_1.addTab("Find", null, panel_12, null);
		panel_12.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Find Student");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(161, 0, 122, 33);
		panel_12.add(lblNewLabel);
		
		JLabel lblFindCuurse = new JLabel("Find Course");
		lblFindCuurse.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFindCuurse.setBounds(593, 0, 96, 33);
		panel_12.add(lblFindCuurse);
		
		JLabel lblSearchForStudent = new JLabel("Search for Student");
		lblSearchForStudent.setBounds(54, 55, 145, 23);
		panel_12.add(lblSearchForStudent);
		
		JLabel lblSsn2 = new JLabel("SSN:");
		panel_12.add(lblSsn2);
		
		JLabel lblSearchForCourse = new JLabel("Search for Course");
		lblSearchForCourse.setBounds(462, 55, 145, 23);
		panel_12.add(lblSearchForCourse);
		
		JLabel lblCourseCode2 = new JLabel("Course Code:");
		
		JLabel lblSsn = new JLabel("Ssn:");
		lblSsn.setBounds(60, 43, 46, 14);
		panel_13.add(lblSsn);
		
		JLabel lblCourseCode = new JLabel("Course code:");
		lblCourseCode.setBounds(60, 248, 94, 14);
		panel_13.add(lblCourseCode);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(164, 170, 89, 23);
		panel_13.add(btnAdd);
		panel_12.add(lblCourseCode2);
		
		textFieldStudentSsn = new JTextField();
		textFieldStudentSsn.setBounds(99, 90, 86, 20);
		panel_12.add(textFieldStudentSsn);
		textFieldStudentSsn.setColumns(10);
		
		textFieldCoursecode = new JTextField();
		textFieldCoursecode.setColumns(10);
		textFieldCoursecode.setBounds(561, 90, 86, 20);
		panel_12.add(textFieldCoursecode);
		
		JButton btnFindCourse = new JButton("Find");
		btnFindCourse.setBounds(462, 143, 89, 23);
		panel_12.add(btnFindCourse);
		
		JScrollPane ResultSetFindStudent = new JScrollPane();
		ResultSetFindStudent.setBounds(54, 194, 337, 157);
		panel_12.add(ResultSetFindStudent);
		
		table = new JTable();
		ResultSetFindStudent.setViewportView(table);
		
		JScrollPane ResultSetFindCourse = new JScrollPane();
		ResultSetFindCourse.setBounds(462, 194, 337, 157);
		panel_12.add(ResultSetFindCourse);
		
		JButton btnFindStudent = new JButton("Find");
		btnFindStudent.setBounds(54, 143, 89, 23);
		panel_12.add(btnFindStudent);
		
		JLabel lblSsn_3 = new JLabel("Ssn:");
		lblSsn_3.setBounds(54, 93, 46, 14);
		panel_12.add(lblSsn_3);
		
		JLabel lblCourseCode_3 = new JLabel("Course code:");
		lblCourseCode_3.setBounds(462, 93, 89, 14);
		panel_12.add(lblCourseCode_3);
		
		JLabel lblCheckIfStudent = new JLabel("Check if Student studies a course");
		lblCheckIfStudent.setBounds(209, 44, 166, 23);
		panel_12.add(lblCheckIfStudent);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(301, 78, 86, 20);
		panel_12.add(textField_13);
		
		JButton btnCheck = new JButton("Check");
		btnCheck.setBounds(302, 143, 89, 23);
		panel_12.add(btnCheck);
		
		JLabel label = new JLabel("Ssn:");
		label.setBounds(209, 81, 46, 14);
		panel_12.add(label);
		
		JLabel lblCourseCode_4 = new JLabel("Course code:");
		lblCourseCode_4.setBounds(209, 112, 71, 14);
		panel_12.add(lblCourseCode_4);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(301, 109, 86, 20);
		panel_12.add(textField_14);
		
		JPanel panel_9 = new JPanel();
		tabbedPane_2.addTab("Assignment 2", null, panel_9, null);
		panel_9.setLayout(null);
		
		JPanel panel_10 = new JPanel();
		tabbedPane_2.addTab("Assignment 3", null, panel_10, null);
	}
}
