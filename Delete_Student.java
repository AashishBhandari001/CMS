package CourseManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class Delete_Student extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable Delete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete_Student frame = new Delete_Student();
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
	public Delete_Student() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 508);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(222, 179, 242));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeleteStudent = new JLabel("Delete Student");
		lblDeleteStudent.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDeleteStudent.setBounds(166, 30, 127, 20);
		contentPane.add(lblDeleteStudent);
		
		JLabel lblFullName = new JLabel("Full Name");
		lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFullName.setBounds(10, 247, 101, 20);
		contentPane.add(lblFullName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastName.setBounds(10, 276, 101, 20);
		contentPane.add(lblLastName);
		
		JLabel lblStudentid = new JLabel("Student_Id");
		lblStudentid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStudentid.setBounds(10, 307, 138, 20);
		contentPane.add(lblStudentid);
		
		JLabel lblGmail = new JLabel("Gmail");
		lblGmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGmail.setBounds(10, 338, 101, 20);
		contentPane.add(lblGmail);
		
		JLabel lblLevel = new JLabel("Level");
		lblLevel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLevel.setBounds(10, 369, 101, 20);
		contentPane.add(lblLevel);
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSemester.setBounds(10, 400, 118, 20);
		contentPane.add(lblSemester);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(107, 247, 151, 20);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(107, 276, 151, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(107, 307, 151, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(107, 338, 151, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(107, 369, 151, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(107, 400, 151, 20);
		contentPane.add(textField_5);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
					
					//creating a statement
					String query = "DELETE FROM student_details SET First_Name=?,Last_Name=?,Student_ID=?,Level=?,Semester=?,Gmail=?";
				        PreparedStatement pstat =  (PreparedStatement) con.prepareStatement(query);
				        pstat.setString(1, textField.getText());
				        pstat.setString(2, textField_1.getText());
				        pstat.setString(3, textField_2.getText());
				        pstat.setString(4, textField_3.getText());
				        pstat.setString(5, textField_4.getText());
				        pstat.setString(6, textField_5.getText());
					pstat.executeUpdate();
					System.out.println("Table created");
					JOptionPane.showMessageDialog(null, "Edited");
					con.close();
//					pstat.close();
				} catch (Exception e1) {
					e1.printStackTrace();
					
				}
			}
		});
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDelete.setBounds(310, 330, 114, 37);
		contentPane.add(btnDelete);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new EnrollStudent_Admin();
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBounds(310, 378, 114, 37);
		contentPane.add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 67, 399, 151);
		contentPane.add(scrollPane);
		
		Delete = new JTable();
		Delete.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"First Name", "Last Name", "Student Id", "Level","Semester", "Gmail" 
				}
			));
		try{
	    	Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
		        
		        String qry = "SELECT First_Name, Last_Name, Student_ID, Level, Semester, Gmail FROM student_details";
	//"select ID, module_code, module_name,level, semester, optional from course where course_name = ? and level = ?";
		        
		        Statement pstat = con.createStatement();
		        
		        ResultSet rs = pstat.executeQuery(qry);
		        
		        DefaultTableModel model = (DefaultTableModel)Delete.getModel();
		        
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
	
		scrollPane.setViewportView(Delete);
		setVisible(true);
	}
}
