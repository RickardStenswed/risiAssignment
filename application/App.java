package application;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.sql.*;
import java.util.*;

import model.*;
import dal.*;
import controller.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {

	private JFrame frame;
	private JTextField textFieldFindStudentSsn;
	private JTextField textFieldFindCourseCourseCode;
	private Controller controller = new Controller();

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

	private JTable tableHighestThroughput;
	private JTable tableSsnStudent;
	private JTable tableCourseCode;
	private JTable tableStudentResult;
	// Default model

	private DefaultTableModel dataModelHighestThroughput;
	private DefaultTableModel dataModelSsnStudent;
	private DefaultTableModel dataModelCourseCode;
	private DefaultTableModel dataModelStudentResult;


	private JScrollPane scrollPaneFindStudent;
	private JTextField textFieldStudentResultCourseCode;
	private JTextField textFieldStudentResultSsn2;

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

		JComboBox<String> comboBoxGrade = new JComboBox<String>();
		comboBoxGrade.addItem("A");
		comboBoxGrade.addItem("B");
		comboBoxGrade.addItem("C");
		comboBoxGrade.addItem("D");
		comboBoxGrade.addItem("F");
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
		responseLabelRegAdd.setBounds(164, 417, 295, 14);
		panelRegisterAdd.add(responseLabelRegAdd);

		JLabel labelErrorMessage = new JLabel("System response:");
		labelErrorMessage.setBounds(60, 417, 94, 14);
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

		JButton btnRegStudentDelete = new JButton("Delete");
		btnRegStudentDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String ssn = textFieldRegStudentSsn.getText();
				responseLabelRegAdd.setForeground(Color.BLACK);

				if (ssn.isEmpty()) {
					responseLabelRegAdd.setForeground(Color.RED);
					responseLabelRegAdd.setText("Please enter student ssn");
				} else {
					try {
						controller.deleteStudent(ssn);
						responseLabelRegAdd.setForeground(Color.GREEN);
						responseLabelRegAdd.setText("Student removed");
						textFieldRegStudentSsn.setText(null);
						textFieldRegStudentName.setText(null);
						textFieldRegStudentAddress.setText(null);
						textFieldRegStudentPhoneNumber.setText(null);
					} catch (SQLException sq) {
						responseLabelRegAdd.setForeground(Color.RED);
						// responseLabelRegAdd.setText(ErrorCodeMapper.getMessageForErrorCode(sq.getErrorCode(),
						// "Studenten"));
					}
				}
			}
		});
		btnRegStudentDelete.setBounds(270, 170, 89, 23);
		panelRegisterAdd.add(btnRegStudentDelete);

		JLabel lblCredits = new JLabel("Credits:");
		lblCredits.setBounds(60, 310, 46, 14);
		panelRegisterAdd.add(lblCredits);

		JButton btnRegCourseAdd = new JButton("Add");
		btnRegCourseAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String courseCode = textFieldRegCourseCourseCode.getText();
				String courseName = textFieldRegCourseName.getText();
				String credit = textFieldRegCourseCredits.getText();
				responseLabelRegAdd.setForeground(Color.BLACK);

				if (courseCode.isEmpty() || courseName.isEmpty() || credit.isEmpty()) {
					responseLabelRegAdd.setForeground(Color.RED);
					responseLabelRegAdd.setText("All fields must be filled in");
				} else {
					try {

						double cred = Double.parseDouble(credit);
						cred = Double.parseDouble(credit);

						controller.addCourse(courseCode, courseName, cred);
						responseLabelRegAdd.setForeground(Color.GREEN);
						responseLabelRegAdd.setText("Course registered");
						textFieldRegCourseCourseCode.setText(null);
						textFieldRegCourseName.setText(null);
						textFieldRegCourseCredits.setText(null);
					} catch (SQLException sq) {
						responseLabelRegAdd.setForeground(Color.RED);
						// responseLabelRegAdd.setText(ErrorCodeMapper.getMessageForErrorCode(sq.getErrorCode(),
						// "Studenten"));
					}
				}
			}
		});
		btnRegCourseAdd.setBounds(164, 371, 89, 23);
		panelRegisterAdd.add(btnRegCourseAdd);

		JButton btnRegCourseDelete = new JButton("Delete");
		btnRegCourseDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String courseCode = textFieldRegCourseCourseCode.getText();
				responseLabelRegAdd.setForeground(Color.BLACK);

				if (courseCode.isEmpty()) {
					responseLabelRegAdd.setForeground(Color.RED);
					responseLabelRegAdd.setText("Please enter course code");
				} else {
					try {
						controller.deleteCourse(courseCode);
						responseLabelRegAdd.setForeground(Color.GREEN);
						responseLabelRegAdd.setText("Course removed");
						textFieldRegCourseCourseCode.setText(null);
						textFieldRegCourseName.setText(null);
						textFieldRegCourseCredits.setText(null);
					} catch (SQLException sq) {
						responseLabelRegAdd.setForeground(Color.RED);
						// responseLabelRegAdd.setText(ErrorCodeMapper.getMessageForErrorCode(sq.getErrorCode(),
						// "Studenten")); Hola
					}
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
		
		//Button for addying a student

		JButton btnRegStudentStudiesAdd = new JButton("Add");
		btnRegStudentStudiesAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String ssn = textFieldRegStudentStudiesSsn.getText();
				String courseCode = textFieldRegStudentStudiesCourseCode.getText();
				String semester = textFieldRegStudentStudiesSemester.getText();
				responseLabelRegAdd.setForeground(Color.BLACK);

				if (ssn.isEmpty() || courseCode.isEmpty() || semester.isEmpty()) {
					responseLabelRegAdd.setForeground(Color.RED);
					responseLabelRegAdd.setText("All fields must be filled in");
				} else {
					try {

						controller.addStudentStudies(ssn, courseCode, semester);
						responseLabelRegAdd.setForeground(Color.GREEN);
						responseLabelRegAdd.setText("Student registered");
						textFieldRegStudentStudiesSsn.setText(null);
						textFieldRegStudentStudiesCourseCode.setText(null);
						textFieldRegStudentStudiesSemester.setText(null);
					} catch (SQLException sq) {
						responseLabelRegAdd.setForeground(Color.RED);
						// responseLabelRegAdd.setText(ErrorCodeMapper.getMessageForErrorCode(sq.getErrorCode(),
						// "Studenten"));
					}
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

				if (ssn.isEmpty() || courseCode.isEmpty()) {
					responseLabelRegAdd.setForeground(Color.RED);
					responseLabelRegAdd.setText("Ssn and Course code must be filled in");
				} else {
					try {

						controller.deleteStudentStudies(ssn, courseCode);
						responseLabelRegAdd.setForeground(Color.GREEN);
						responseLabelRegAdd.setText("Student removed");
						textFieldRegStudentStudiesSsn.setText(null);
						textFieldRegStudentStudiesCourseCode.setText(null);
					} catch (SQLException sq) {
						responseLabelRegAdd.setForeground(Color.RED);
						// responseLabelRegAdd.setText(ErrorCodeMapper.getMessageForErrorCode(sq.getErrorCode(),
						// "Studenten"));
					}
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
		lblGrade_1.setBounds(474, 341, 46, 14);
		panelRegisterAdd.add(lblGrade_1);

		
		// Button for regestrating a student that has completed a course.
		JButton btnRegStudentHasStudiedAdd = new JButton("Add");
		btnRegStudentHasStudiedAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String ssn = textFieldRegStudentHasStudiedSsn.getText();
				String courseCode = textFieldRegStudentHasStudiedCourseCode.getText();
				String semester = textFieldRegStudentHasStudiedSemester.getText();
				String grade = (String) comboBoxGrade.getSelectedItem();

				responseLabelRegAdd.setForeground(Color.BLACK);

				if (ssn.isEmpty() || courseCode.isEmpty() || semester.isEmpty()) {
					responseLabelRegAdd.setForeground(Color.RED);
					responseLabelRegAdd.setText("All fields must be filled in");

					// NOTE TO SELF: M�ste g�ra s� att "Grade" blir obligatorisk att fylla i.

				} else {
					try {

						controller.addStudentHasStudied(ssn, courseCode, semester, grade);

						responseLabelRegAdd.setForeground(Color.GREEN);
						responseLabelRegAdd.setText("Student registered");
						textFieldRegStudentHasStudiedSsn.setText(null);
						textFieldRegStudentHasStudiedCourseCode.setText(null);
						textFieldRegStudentHasStudiedSemester.setText(null);
					} catch (SQLException sq) {
						responseLabelRegAdd.setForeground(Color.RED);
						// responseLabelRegAdd.setText(ErrorCodeMapper.getMessageForErrorCode(sq.getErrorCode(),
						// "Studenten"));
					}
				}
			}
		});
		btnRegStudentHasStudiedAdd.setBounds(561, 371, 89, 23);
		panelRegisterAdd.add(btnRegStudentHasStudiedAdd);

		JList list = new JList();
		list.setBounds(392, 276, -50, -41);
		panelRegisterAdd.add(list);

		JLabel lblSsn = new JLabel("Ssn:");
		lblSsn.setBounds(60, 43, 46, 14);
		panelRegisterAdd.add(lblSsn);

		JLabel lblCourseCode = new JLabel("Course code:");
		lblCourseCode.setBounds(60, 248, 94, 14);
		panelRegisterAdd.add(lblCourseCode);

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
						// responseLabelRegAdd.setText(ErrorCodeMapper.getMessageForErrorCode(sq.getErrorCode(),
						// "Studenten"));
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
		responseLabelFind.setBounds(178, 398, 286, 20);
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

		JButton btnFindCourseFind = new JButton("Find");
		btnFindCourseFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String courseCode = textFieldFindCourseCourseCode.getText();
				responseLabelFind.setText(""); // viktigt att responselabelFind (new button delen) sitter ovan denna
												// metod
				responseLabelFind.setForeground(Color.BLACK);
				dataModelCourseCode.setRowCount(0);// datamodelcoursecodecourse heter tabellen, m�ste skrivas som en
													// private d�r uppe
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
						} else {
							responseLabelFind.setForeground(Color.RED);
							responseLabelFind.setText("Course does not exits");
						}
					}
				} catch (SQLException sqlException) {
					// responseLabelFind.setForeground(Color.RED);
					// responseLabelFind.setText(ErrorCodeMapper.getMessageForErrorCode(sqlException.getErrorCode(),
					// ""));

				}
			}
		});
		btnFindCourseFind.setBounds(462, 126, 89, 23);
		panelFind.add(btnFindCourseFind);

	

		dataModelSsnStudent = new DefaultTableModel();
		tableSsnStudent = new JTable(dataModelSsnStudent);

		JButton btnFindStudentFind = new JButton("Find");
		btnFindStudentFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String ssn = textFieldFindStudentSsn.getText();
				responseLabelFind.setText(""); // viktigt att responselabelFind (new button delen) sitter ovan denna
												// metod
				responseLabelFind.setForeground(Color.BLACK);
				dataModelSsnStudent.setRowCount(0);// datamodelssnstudent heter tabellen, m�ste skrivas som en private
													// d�r uppe
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
							dataModelSsnStudent.addRow(new Object[] { s.getSsn(), s.getStudentName(), s.getAddress() });
						} else {
							responseLabelFind.setForeground(Color.RED);
							responseLabelFind.setText("Student does not exists");
						}
					}
				} catch (SQLException sqlException) {
					// responseLabelFind.setForeground(Color.RED);
					// responseLabelFind.setText(ErrorCodeMapper.getMessageForErrorCode(sqlException.getErrorCode(),
					// ""));
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
		lblCheckIfStudent.setBounds(209, 44, 166, 23);
		panelFind.add(lblCheckIfStudent);

		textFieldFindStudentCheckSsn = new JTextField();
		textFieldFindStudentCheckSsn.setColumns(10);
		textFieldFindStudentCheckSsn.setBounds(301, 78, 86, 20);
		panelFind.add(textFieldFindStudentCheckSsn);

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
                    } else { 
                    responseLabelFind.setText("");
                    }
                    } catch (SQLException sqlException) {
                        //responseLabelFind.setText(
                                //ErrorCodeMapper.getMessageForErrorCode(sqlException.getErrorCode(), "Kursen/Studenten"));
                    	/*;*/
                    }
            }}
                );
		btnFindStudentCheck.setBounds(301, 160, 89, 23);
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

		/*
		 * String ssn = textFieldFindStudentSsn.getText();
		 * responseLabelFind.setText(""); //viktigt att responselabelFind (new button
		 * delen) sitter ovan denna metod responseLabelFind.setForeground(Color.BLACK);
		 * dataModelSsnStudent.setRowCount(0);//datamodelssnstudent heter tabellen,
		 * m�ste skrivas som en private d�r uppe String[] headerFindStudent = {"SSN",
		 * "Name", "Address", "Phone number"};
		 * dataModelSsnStudent.setColumnIdentifiers(headerFindStudent); try { if
		 * (ssn.isEmpty()) {
		 */

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

					}

				} catch (SQLException sqlException) {
					// responseLabelFind.setForeground(Color.RED);
					// responseLabelFind.setText(ErrorCodeMapper.getMessageForErrorCode(sqlException.getErrorCode(),
					// ""));
				}
			}
		});
		
		/* JButton btnFindCourseFindAll = new JButton("Find all");
		btnFindCourseFindAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				responseLabelFind.setText("");
				responseLabelFind.setForeground(Color.BLACK);
				dataModelCourseCode.setRowCount(0);
				String[] headerFindCourse = { "Course Code", "Course Name", "Credits" };
				dataModelCourseCode.setColumnIdentifiers(headerFindCourse);
				try {

					ArrayList<Course> allCourses = controller.getAllCourses();
					for (Course temp : allCourses) {
						dataModelSsnStudent.addRow(new Object[] { temp.getCourseCode(), temp.getCourseName(),
								temp.getCredit() });
								*/
		btnFindStudentFindAll.setBounds(54, 160, 89, 23);
		panelFind.add(btnFindStudentFindAll);

		JButton btnFindCourseFindAll = new JButton("Find all");
		btnFindCourseFindAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//responseLabelFind.setText("All courses collected"); Vara konsekventa med systemrespones. Ska den alltid finnas kvar?
				//responseLabelFind.setForeground(Color.BLACK);
				dataModelCourseCode.setRowCount(0);
				String[] headerFindCourse = { "Course Code", "Course Name", "Credits" };
				dataModelCourseCode.setColumnIdentifiers(headerFindCourse);
				try {

					ArrayList<Course> allCourses = controller.getAllCourses();
					for (Course temp : allCourses) {
						dataModelCourseCode.addRow(new Object[] { temp.getCourseCode(), temp.getCourseName(),
								temp.getCredit() });

					}

				} catch (SQLException sqlException) {
					// responseLabelFind.setForeground(Color.RED);
					// responseLabelFind.setText(ErrorCodeMapper.getMessageForErrorCode(sqlException.getErrorCode(),
					// ""));
				}
			}
		});
				
		btnFindCourseFindAll.setBounds(462, 160, 89, 23);
		panelFind.add(btnFindCourseFindAll);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(86, 358, 301, -134);
		panelFind.add(scrollPane);

		// kOLLAR OM DENNA LIGGER P� R�TT PLATS
		JScrollPane scrollPaneFindStudent = new JScrollPane(tableSsnStudent);
		scrollPaneFindStudent.setBounds(65, 211, 337, 147);
		panelFind.add(scrollPaneFindStudent);

		JScrollPane scrollPaneFindCourse = new JScrollPane(tableCourseCode);
		scrollPaneFindCourse.setBounds(487, 211, 346, 147);
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
		textFieldCourseResultCourseCode.setBounds(186, 98, 145, 20);
		panelCourseResult.add(textFieldCourseResultCourseCode);
		textFieldCourseResultCourseCode.setColumns(10);

		JLabel lblCourseCode_5 = new JLabel("Course code:");
		lblCourseCode_5.setBounds(72, 101, 78, 14);
		panelCourseResult.add(lblCourseCode_5);
		
		/*dataModelSsnStudent = new DefaultTableModel();
		tableSsnStudent = new JTable(dataModelSsnStudent);*/
		
		

		JButton btnCourseResultGetAllGrades = new JButton("Get all grades");
		btnCourseResultGetAllGrades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//try {
					//if (comboBoxCourseResultFeatures)
				}
			//}
		});
		btnCourseResultGetAllGrades.setBounds(186, 147, 145, 23);
		panelCourseResult.add(btnCourseResultGetAllGrades);

		dataModelHighestThroughput = new DefaultTableModel();
		tableHighestThroughput = new JTable(dataModelHighestThroughput);

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
					// lblShowFlow.setText(ErrorCodeMapper.getMessageForErrorCode(sqlException.getErrorCode(),
					// ""));
				}
			}
		});

		btnGet.setBounds(606, 147, 89, 23);
		panelCourseResult.add(btnGet);

		JScrollPane scrollPaneCourseResultSearchCourseCode = new JScrollPane();
		scrollPaneCourseResultSearchCourseCode.setBounds(72, 250, 325, 148);
		panelCourseResult.add(scrollPaneCourseResultSearchCourseCode);

		JLabel lblHighestThroughput = new JLabel("Highest throughput:");
		lblHighestThroughput.setBounds(606, 101, 129, 14);
		panelCourseResult.add(lblHighestThroughput);

		JScrollPane scrollPaneCourseResultHighestThroughput = new JScrollPane(tableHighestThroughput);
		scrollPaneCourseResultHighestThroughput.setBounds(499, 250, 325, 148);
		panelCourseResult.add(scrollPaneCourseResultHighestThroughput);

		JLabel labelCourseResultRespons = new JLabel("*");
		labelCourseResultRespons.setBounds(160, 422, 331, 14);
		panelCourseResult.add(labelCourseResultRespons);
		
		JLabel lblSystemRespons_1 = new JLabel("System respons:");
		lblSystemRespons_1.setBounds(60, 422, 90, 14);
		panelCourseResult.add(lblSystemRespons_1);
		
		JButton btnCourseResultGetGradePercentage = new JButton("Get grade %");
		btnCourseResultGetGradePercentage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCourseResultGetGradePercentage.setBounds(186, 181, 145, 23);
		panelCourseResult.add(btnCourseResultGetGradePercentage);
		
		JButton btnCourseResultGetAllCurrent = new JButton("Get all current students");
		btnCourseResultGetAllCurrent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCourseResultGetAllCurrent.setBounds(186, 216, 145, 23);
		panelCourseResult.add(btnCourseResultGetAllCurrent);
		

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
		
		JLabel labelStudentResultResponse = new JLabel("*");
		labelStudentResultResponse.setBounds(164, 406, 313, 20);
		panel_11.add(labelStudentResultResponse);

		JLabel lblSsn_4 = new JLabel("Ssn:");
		lblSsn_4.setBounds(43, 54, 46, 14);
		panel_11.add(lblSsn_4);

		//Method to find all grades a student have
		JButton btnStudentResultGetGrades = new JButton("Get grades");
		btnStudentResultGetGrades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ssn = textFieldStudentResultSsn.getText();
				dataModelStudentResult.setRowCount(0);
                labelStudentResultResponse.setText("");
                labelStudentResultResponse.setForeground(Color.BLACK);
                
	            try {
	            	if (ssn.isEmpty()) {
	            		labelStudentResultResponse.setForeground(Color.RED);
	            		labelStudentResultResponse.setText("Fill in ssn");
	            	}
	            	else {ArrayList<HasStudied> hs = controller.getStudentAllGrades(ssn); 
	            		if (hs == null) {
	            		labelStudentResultResponse.setText("The student has no grades");
	            		}
	            		else {dataModelStudentResult.addRow(new Object[]{hs.get(0)});
	            		}
	            	}
	            }catch (SQLException sqlException) {labelStudentResultResponse.setText("error");
	            }
			}});
		
		btnStudentResultGetGrades.setBounds(87, 88, 108, 23);
		panel_11.add(btnStudentResultGetGrades);
	
		dataModelStudentResult = new DefaultTableModel();
		tableStudentResult = new JTable(dataModelStudentResult);
		
		JScrollPane scrollPaneStudentResult = new JScrollPane(tableStudentResult); //Vilken JTable ska in h�r??
		scrollPaneStudentResult.setBounds(66, 217, 330, 165);
		panel_11.add(scrollPaneStudentResult);
		
		//Method to find all courses a student currently studies
		JButton btnStudentResultGetCurrentCourses = new JButton("Get current courses");
		btnStudentResultGetCurrentCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String ssn = textFieldStudentResultSsn.getText();
				dataModelStudentResult.setRowCount(0);
				String [] headerStudentResult = {"SSN", "Course Name", "Semester"};
				dataModelStudentResult.setColumnIdentifiers(headerStudentResult);
				labelStudentResultResponse.setText("");
	            labelStudentResultResponse.setForeground(Color.BLACK);			    	   
				       
	}

});
			
		btnStudentResultGetCurrentCourses.setBounds(216, 88, 142, 23);
		panel_11.add(btnStudentResultGetCurrentCourses);
		
		textFieldStudentResultCourseCode = new JTextField();
		textFieldStudentResultCourseCode.setBounds(673, 106, 86, 20);
		panel_11.add(textFieldStudentResultCourseCode);
		textFieldStudentResultCourseCode.setColumns(10);
		
		JLabel lblCourseCode_6 = new JLabel("Course Code");
		lblCourseCode_6.setBounds(505, 109, 89, 14);
		panel_11.add(lblCourseCode_6);
		
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
                            labelStudentResultResponse.setText("The student does not study the course");
                    }  else if (s != null) {
                       //String studentName = controller.getStudent(s.getSsn()).getStudentName();
                       // String courseName = controller.getCourse(s.getCourseCode()).getCourseName();
                    	HasStudied st =controller.getStudentGradeCourse(ssn, courseCode);
                        dataModelStudentResult.addRow(new Object[] {st.getSsn(),st.getCourseCode(), st.getSemester(), st.getGrade()});
                        //labelStudentResultResponse.setText("Hej");
                    } else {
                        responseLabelFind.setText("");
                        }
                        } catch (SQLException sqlException) {
                            //responseLabelFind.setText(
                                    //ErrorCodeMapper.getMessageForErrorCode(sqlException.getErrorCode(), "Kursen/Studenten"));
                            /*;*/
                        }
                    }}
                    );
         
		btnStudentResultGetGradeCourse.setBounds(628, 161, 184, 23);
		panel_11.add(btnStudentResultGetGradeCourse);
		
		textFieldStudentResultSsn2 = new JTextField();
		textFieldStudentResultSsn2.setBounds(673, 64, 86, 20);
		panel_11.add(textFieldStudentResultSsn2);
		textFieldStudentResultSsn2.setColumns(10);
		
		JLabel lblSsn_5 = new JLabel("Ssn:");
		lblSsn_5.setBounds(518, 67, 46, 14);
		panel_11.add(lblSsn_5);
		
		JLabel lblGradeForCourse = new JLabel("Student grade on course");
		lblGradeForCourse.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGradeForCourse.setBounds(628, 12, 184, 23);
		panel_11.add(lblGradeForCourse);
		
		JLabel lblSystemRespons = new JLabel("System respons:");
		lblSystemRespons.setBounds(43, 412, 111, 14);
		panel_11.add(lblSystemRespons);

		JPanel panel_9 = new JPanel();
		tabbedPane_2.addTab("Assignment 2", null, panel_9, null);
		panel_9.setLayout(null);

		JPanel panel_10 = new JPanel();
		tabbedPane_2.addTab("Assignment 3", null, panel_10, null);
	}
}
