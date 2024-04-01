package CourseManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

public class EnrollStudent_Admin extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnrollStudent_Admin frame = new EnrollStudent_Admin();
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
	public EnrollStudent_Admin() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 628, 544);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(222, 179, 242));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Enroll = new JLabel("Enroll Student");
		Enroll.setFont(new Font("Tahoma", Font.BOLD, 25));
		Enroll.setBounds(271, 74, 208, 41);
		contentPane.add(Enroll);
		
		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new AddStudent_Admin();
			}
		});
		btnAddStudent.setForeground(Color.BLACK);
		btnAddStudent.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddStudent.setBounds(38, 228, 157, 37);
		contentPane.add(btnAddStudent);
		
		JButton btnEditStudent = new JButton("Edit Student");
		btnEditStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Edit_Student();
			}
		});
		btnEditStudent.setForeground(Color.BLACK);
		btnEditStudent.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEditStudent.setBounds(38, 291, 157, 37);
		contentPane.add(btnEditStudent);
		
		JButton btnDeleteStudent = new JButton("Delete Student");
		btnDeleteStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Delete_Student();
			}
		});
		btnDeleteStudent.setForeground(Color.BLACK);
		btnDeleteStudent.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDeleteStudent.setBounds(38, 355, 157, 37);
		contentPane.add(btnDeleteStudent);
		
		JLabel lblStudentDetails = new JLabel("Student Details");
		lblStudentDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblStudentDetails.setBounds(312, 168, 167, 41);
		contentPane.add(lblStudentDetails);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Admin_DashBoard();
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBounds(38, 421, 157, 37);
		contentPane.add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(224, 220, 368, 247);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"First Name", "Last Name", "Student Id", "Level","Semester", "Gmail" 
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(EnrollStudent_Admin.class.getResource("/CourseManagementSystem/Image/Enroll.jpg")));
		lblNewLabel.setBounds(45, 43, 150, 145);
		contentPane.add(lblNewLabel);
		try{
	    	Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
		        
		        String qry = "SELECT First_Name, Last_Name, Student_ID, Level, Semester, Gmail FROM student_details";
	//"select ID, module_code, module_name,level, semester, optional from course where course_name = ? and level = ?";
		        
		        Statement pstat = con.createStatement();
		        
		        ResultSet rs = pstat.executeQuery(qry);
		        
		        DefaultTableModel model = (DefaultTableModel)table.getModel();
		        
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
