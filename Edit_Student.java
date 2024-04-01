package CourseManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Edit_Student extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable Edit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Edit_Student frame = new Edit_Student();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Edit_Student() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 524);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(222, 179, 242));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFullName = new JLabel("Full Name");
		lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFullName.setBounds(22, 258, 101, 20);
		contentPane.add(lblFullName);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(119, 258, 151, 20);
		contentPane.add(textField);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastName.setBounds(22, 287, 101, 20);
		contentPane.add(lblLastName);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(119, 287, 151, 20);
		contentPane.add(textField_1);
		
		JLabel lblStudentid = new JLabel("Student_Id");
		lblStudentid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStudentid.setBounds(22, 318, 138, 20);
		contentPane.add(lblStudentid);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(119, 318, 151, 20);
		contentPane.add(textField_2);
		
		JLabel lblGmail = new JLabel("Gmail");
		lblGmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGmail.setBounds(22, 349, 101, 20);
		contentPane.add(lblGmail);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(119, 349, 151, 20);
		contentPane.add(textField_3);
		
		JLabel lblLevel = new JLabel("Level");
		lblLevel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLevel.setBounds(22, 380, 101, 20);
		contentPane.add(lblLevel);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(119, 380, 151, 20);
		contentPane.add(textField_4);
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSemester.setBounds(22, 411, 118, 20);
		contentPane.add(lblSemester);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(119, 411, 151, 20);
		contentPane.add(textField_5);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new EnrollStudent_Admin();
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBounds(322, 403, 114, 37);
		contentPane.add(btnBack);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
					
					//creating a statement
					String query = "UPDATE student_details SET First_Name=?,Last_Name=?,Student_ID=?,Level=?,Semester=?,Gmail=?";
				        PreparedStatement pstat =  (PreparedStatement) con.prepareStatement(query);
				        pstat.setString(1, textField.getText());
				        pstat.setString(2, textField_1.getText());
				        pstat.setString(3, textField_2.getText());
				        pstat.setString(4, textField_3.getText());
				        pstat.setString(5, textField_4.getText());
				        pstat.setString(6, textField_5.getText());
					pstat.executeUpdate();
					JOptionPane.showMessageDialog(null, "Edited");
					con.close();
				} catch (Exception e1) {
					e1.printStackTrace();
					
				}
			
			}
		});
		btnEdit.setForeground(Color.BLACK);
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEdit.setBounds(322, 341, 114, 37);
		contentPane.add(btnEdit);
		
		JLabel lblEditStudent = new JLabel("Edit Student");
		lblEditStudent.setBounds(183, 22, 99, 20);
		contentPane.add(lblEditStudent);
		lblEditStudent.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 60, 421, 148);
		contentPane.add(scrollPane);
		
		
		
		Edit = new JTable();
	
		Edit.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"First Name", "Last Name", "Student Id", "Level","Semester", "Gmail" 
			}
		));
		scrollPane.setViewportView(Edit);
		try{
	    	Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
		        
		        String qry = "SELECT First_Name, Last_Name, Student_ID, Level, Semester, Gmail FROM student_details";
	//"select ID, module_code, module_name,level, semester, optional from course where course_name = ? and level = ?";
		        
		        Statement pstat = con.createStatement();
		        
		        ResultSet rs = pstat.executeQuery(qry);
		        
		        DefaultTableModel model = (DefaultTableModel)Edit.getModel();
		        
		        while(rs.next()) {
		        	String First_Name = rs.getString("First_Name");
		        	String Last_Name = rs.getString("Last_Name");
		        	String Student_ID = rs.getString("Student_ID");
		        	String Level = rs.getString("Level");
		        	String Semester = rs.getString("Semester");
		        	String Gmail = rs.getString("Gmail");

		        	String[] row = {First_Name,Last_Name,Student_ID,Level,Semester,Gmail};
		        	model.addRow(row);
		        	
		        }

		        
		        pstat.close();
		        con.close();
	    }catch (Exception exp){
	        System.out.println(exp);
	    }
		
		setVisible(true);
		
	}

}
