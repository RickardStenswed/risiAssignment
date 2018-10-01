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
	private JTextField textFieldFindStudentSsn;
	private JTextField textFieldFindCourseCourseCode;
	
	// Halloj!
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
		        tabbedPane_1.addTab("Register / Add", null, panelRegisterAdd, null);
		        panelRegisterAdd.setLayout(null);
		        
		        JLabel lblNewLabel = new JLabel("Register student");
		        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		        lblNewLabel.setBounds(164, 0, 119, 45);
		        panelRegisterAdd.add(lblNewLabel);
		        
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
		        
		        JButton btnRegStudentDelete = new JButton("Delete");
		        btnRegStudentDelete.setBounds(270, 170, 89, 23);
		        panelRegisterAdd.add(btnRegStudentDelete);
		        
		        JLabel lblCredits = new JLabel("Credits:");
		        lblCredits.setBounds(60, 310, 46, 14);
		        panelRegisterAdd.add(lblCredits);
		        
		        JButton btnRegCourseAdd = new JButton("Add");
		        btnRegCourseAdd.setBounds(164, 371, 89, 23);
		        panelRegisterAdd.add(btnRegCourseAdd);
		        
		        JButton btnRegCourseDelete = new JButton("Delete");
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
		        textFieldRegStudentStudiesSsn.setBounds(561, 40, 136, 20);
		        panelRegisterAdd.add(textFieldRegStudentStudiesSsn);
		        textFieldRegStudentStudiesSsn.setColumns(10);
		        
		        textFieldRegStudentStudiesCourseCode = new JTextField();
		        textFieldRegStudentStudiesCourseCode.setBounds(561, 71, 136, 20);
		        panelRegisterAdd.add(textFieldRegStudentStudiesCourseCode);
		        textFieldRegStudentStudiesCourseCode.setColumns(10);
		        
		        JLabel lblCourseCode_1 = new JLabel("Course code:");
		        lblCourseCode_1.setBounds(474, 74, 79, 14);
		        panelRegisterAdd.add(lblCourseCode_1);
		        
		        textFieldRegStudentStudiesSemester = new JTextField();
		        textFieldRegStudentStudiesSemester.setBounds(561, 102, 136, 20);
		        panelRegisterAdd.add(textFieldRegStudentStudiesSemester);
		        textFieldRegStudentStudiesSemester.setColumns(10);
		        
		        JLabel lblSemester = new JLabel("Semester:");
		        lblSemester.setBounds(474, 105, 62, 14);
		        panelRegisterAdd.add(lblSemester);
		        
		        JButton btnRegStudentStudiesAdd = new JButton("Add");
		        btnRegStudentStudiesAdd.setBounds(561, 140, 89, 23);
		        panelRegisterAdd.add(btnRegStudentStudiesAdd);
		        
		        JButton btnRegStudentStudiesDelete = new JButton("Delete");
		        btnRegStudentStudiesDelete.setBounds(672, 140, 89, 23);
		        panelRegisterAdd.add(btnRegStudentStudiesDelete);
		        
		        JLabel lblRegisterStudentTo_1 = new JLabel("Register student to finished course");
		        lblRegisterStudentTo_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		        lblRegisterStudentTo_1.setBounds(561, 216, 263, 17);
		        panelRegisterAdd.add(lblRegisterStudentTo_1);
		        
		        textFieldRegStudentHasStudiedSsn = new JTextField();
		        textFieldRegStudentHasStudiedSsn.setBounds(561, 245, 136, 20);
		        panelRegisterAdd.add(textFieldRegStudentHasStudiedSsn);
		        textFieldRegStudentHasStudiedSsn.setColumns(10);
		        
		        textFieldRegStudentHasStudiedCourseCode = new JTextField();
		        textFieldRegStudentHasStudiedCourseCode.setBounds(561, 276, 136, 20);
		        panelRegisterAdd.add(textFieldRegStudentHasStudiedCourseCode);
		        textFieldRegStudentHasStudiedCourseCode.setColumns(10);
		        
		        textFieldRegStudentHasStudiedSemester = new JTextField();
		        textFieldRegStudentHasStudiedSemester.setBounds(561, 307, 136, 20);
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
		        lblGrade_1.setBounds(474, 344, 46, 14);
		        panelRegisterAdd.add(lblGrade_1);
		        
		        JButton btnRegStudentHasStudiedAdd = new JButton("Add");
		        btnRegStudentHasStudiedAdd.setBounds(561, 371, 89, 23);
		        panelRegisterAdd.add(btnRegStudentHasStudiedAdd);
		        
		        JButton btnRegStudentHasStudiedDelete = new JButton("Delete");
		        btnRegStudentHasStudiedDelete.setBounds(672, 371, 89, 23);
		        panelRegisterAdd.add(btnRegStudentHasStudiedDelete);
		        
		        JList list = new JList();
		        list.setBounds(392, 276, -50, -41);
		        panelRegisterAdd.add(list);
		        
		        JScrollBar scrollBarRegStudentHasStudiedGrade = new JScrollBar();
		        scrollBarRegStudentHasStudiedGrade.setBounds(565, 329, 17, 29);
		        panelRegisterAdd.add(scrollBarRegStudentHasStudiedGrade);
		
		JLabel lblSsn = new JLabel("Ssn:");
		lblSsn.setBounds(60, 43, 46, 14);
		panelRegisterAdd.add(lblSsn);
		
		JLabel lblCourseCode = new JLabel("Course code:");
		lblCourseCode.setBounds(60, 248, 94, 14);
		panelRegisterAdd.add(lblCourseCode);
		
		JButton btnRegStudentAdd = new JButton("Add");
		btnRegStudentAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRegStudentAdd.setBounds(164, 170, 89, 23);
		panelRegisterAdd.add(btnRegStudentAdd);
		
		JLabel responseLabelRegAdd = new JLabel("*");
		responseLabelRegAdd.setBounds(402, 416, 46, 14);
		panelRegisterAdd.add(responseLabelRegAdd);
		
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
		
		textFieldFindStudentSsn = new JTextField();
		textFieldFindStudentSsn.setBounds(54, 78, 86, 20);
		panelFind.add(textFieldFindStudentSsn);
		textFieldFindStudentSsn.setColumns(10);
		
		textFieldFindCourseCourseCode = new JTextField();
		textFieldFindCourseCourseCode.setColumns(10);
		textFieldFindCourseCourseCode.setBounds(561, 75, 86, 20);
		panelFind.add(textFieldFindCourseCourseCode);
		
		JButton btnFindCourseFind = new JButton("Find");
		btnFindCourseFind.setBounds(462, 126, 89, 23);
		panelFind.add(btnFindCourseFind);
		
		JButton btnFindStudentFind = new JButton("Find");
		btnFindStudentFind.setBounds(54, 126, 89, 23);
		panelFind.add(btnFindStudentFind);
		
		JLabel lblSsn_3 = new JLabel("Ssn:");
		lblSsn_3.setBounds(10, 81, 46, 14);
		panelFind.add(lblSsn_3);
		
		JLabel lblCourseCode_3 = new JLabel("Course code:");
		lblCourseCode_3.setBounds(462, 78, 89, 14);
		panelFind.add(lblCourseCode_3);
		
		JLabel lblCheckIfStudent = new JLabel("Check if Student studies a course");
		lblCheckIfStudent.setBounds(209, 44, 166, 23);
		panelFind.add(lblCheckIfStudent);
		
		textFieldFindStudentCheckSsn = new JTextField();
		textFieldFindStudentCheckSsn.setColumns(10);
		textFieldFindStudentCheckSsn.setBounds(301, 78, 86, 20);
		panelFind.add(textFieldFindStudentCheckSsn);
		
		JButton btnFindStudentCheck = new JButton("Check");
		btnFindStudentCheck.setBounds(302, 160, 89, 23);
		panelFind.add(btnFindStudentCheck);
		
		JLabel label = new JLabel("Ssn:");
		label.setBounds(209, 81, 46, 14);
		panelFind.add(label);
		
		JLabel lblCourseCode_4 = new JLabel("Course code:");
		lblCourseCode_4.setBounds(209, 112, 71, 14);
		panelFind.add(lblCourseCode_4);
		
		textFieldFindStudentCheckCourseCode = new JTextField();
		textFieldFindStudentCheckCourseCode.setColumns(10);
		textFieldFindStudentCheckCourseCode.setBounds(301, 109, 86, 20);
		panelFind.add(textFieldFindStudentCheckCourseCode);
		
		JLabel responseLabelFind = new JLabel("*");
		responseLabelFind.setBounds(403, 404, 46, 14);
		panelFind.add(responseLabelFind);
		
		JButton btnFindStudentFindAll = new JButton("Find all");
		btnFindStudentFindAll.setBounds(54, 160, 89, 23);
		panelFind.add(btnFindStudentFindAll);
		
		JButton btnFindCourseFindAll = new JButton("Find all");
		btnFindCourseFindAll.setBounds(462, 160, 89, 23);
		panelFind.add(btnFindCourseFindAll);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(86, 358, 301, -134);
		panelFind.add(scrollPane);
		
		JScrollPane scrollPaneFindStudent = new JScrollPane();
		scrollPaneFindStudent.setBounds(65, 211, 337, 147);
		panelFind.add(scrollPaneFindStudent);
		
		JScrollPane scrollPaneFindCourse = new JScrollPane();
		scrollPaneFindCourse.setBounds(487, 211, 346, 147);
		panelFind.add(scrollPaneFindCourse);
		
		JPanel panel = new JPanel();
		tabbedPane_1.addTab("Course result", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblCourseResult = new JLabel("Course result");
		lblCourseResult.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCourseResult.setBounds(410, 36, 115, 23);
		panel.add(lblCourseResult);
		
		textFieldCourseResultCourseCode = new JTextField();
		textFieldCourseResultCourseCode.setBounds(203, 98, 86, 20);
		panel.add(textFieldCourseResultCourseCode);
		textFieldCourseResultCourseCode.setColumns(10);
		
		JLabel lblCourseCode_5 = new JLabel("Course code:");
		lblCourseCode_5.setBounds(72, 101, 78, 14);
		panel.add(lblCourseCode_5);
		
		JLabel lblFeatures = new JLabel("Features:");
		lblFeatures.setBounds(72, 151, 63, 14);
		panel.add(lblFeatures);
		
		JButton btnCourseResultGetResult = new JButton("Get result");
		btnCourseResultGetResult.setBounds(72, 204, 89, 23);
		panel.add(btnCourseResultGetResult);
		
		JButton btnGet = new JButton("Get");
		btnGet.setBounds(606, 147, 89, 23);
		panel.add(btnGet);
		
		JScrollPane scrollPaneCourseResultSearchCourseCode = new JScrollPane();
		scrollPaneCourseResultSearchCourseCode.setBounds(72, 250, 325, 148);
		panel.add(scrollPaneCourseResultSearchCourseCode);
		
		JLabel lblHighestThroughput = new JLabel("Highest throughput:");
		lblHighestThroughput.setBounds(606, 101, 129, 14);
		panel.add(lblHighestThroughput);
		
		JScrollPane scrollPaneCourseResultHighestThroughput = new JScrollPane();
		scrollPaneCourseResultHighestThroughput.setBounds(499, 250, 325, 148);
		panel.add(scrollPaneCourseResultHighestThroughput);
		
		JLabel labelCourseResultRespons = new JLabel("*");
		labelCourseResultRespons.setBounds(445, 422, 46, 14);
		panel.add(labelCourseResultRespons);
		
		JComboBox comboBoxCourseResultFeatures = new JComboBox();
		comboBoxCourseResultFeatures.setBounds(203, 148, 86, 20);
		panel.add(comboBoxCourseResultFeatures);
		
		JPanel panel_11 = new JPanel();
		tabbedPane_1.addTab("Student result", null, panel_11, null);
		panel_11.setLayout(null);
		
		JLabel lblStudentResult = new JLabel("Student result");
		lblStudentResult.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStudentResult.setBounds(95, 11, 100, 14);
		panel_11.add(lblStudentResult);
		
		textFieldStudentResultSsn = new JTextField();
		textFieldStudentResultSsn.setBounds(164, 51, 86, 20);
		panel_11.add(textFieldStudentResultSsn);
		textFieldStudentResultSsn.setColumns(10);
		
		JLabel lblSsn_4 = new JLabel("Ssn:");
		lblSsn_4.setBounds(43, 54, 46, 14);
		panel_11.add(lblSsn_4);
		
		JLabel lblFeatures_1 = new JLabel("Features:");
		lblFeatures_1.setBounds(43, 92, 65, 14);
		panel_11.add(lblFeatures_1);
		
		JButton btnStudentResultGetResult = new JButton("Get result");
		btnStudentResultGetResult.setBounds(43, 154, 89, 23);
		panel_11.add(btnStudentResultGetResult);
		
		JScrollPane scrollPaneStudentResult = new JScrollPane();
		scrollPaneStudentResult.setBounds(43, 208, 302, 165);
		panel_11.add(scrollPaneStudentResult);
		
		JLabel labelStudentResultResponse = new JLabel("*");
		labelStudentResultResponse.setBounds(428, 412, 46, 14);
		panel_11.add(labelStudentResultResponse);
		
		JComboBox comboBoxStudentResultFeatures = new JComboBox();
		comboBoxStudentResultFeatures.setBounds(164, 89, 86, 17);
		panel_11.add(comboBoxStudentResultFeatures);
		
		JPanel panel_9 = new JPanel();
		tabbedPane_2.addTab("Assignment 2", null, panel_9, null);
		panel_9.setLayout(null);
		
		JPanel panel_10 = new JPanel();
		tabbedPane_2.addTab("Assignment 3", null, panel_10, null);
	}
}
