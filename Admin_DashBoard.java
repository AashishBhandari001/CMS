package CourseManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Admin_DashBoard extends JFrame {

	private JPanel contentPane;
	private JTextField message;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_DashBoard frame = new Admin_DashBoard();
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
	public Admin_DashBoard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(249, 205, 173));
		panel.setBounds(0, 0, 617, 518);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(131, 175, 155));
		panel_1.setBounds(0, 0, 230, 518);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Modules");
		btnNewButton.setBounds(32, 247, 148, 29);
		panel_1.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setForeground(new Color(0, 0, 0));
		
		JButton btnEditStudent_1 = new JButton("Report");
		btnEditStudent_1.setBounds(34, 295, 148, 29);
		panel_1.add(btnEditStudent_1);
		btnEditStudent_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(true);
				new Student_MarkSheet();
			}
		});
		btnEditStudent_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEditStudent_1.setForeground(Color.BLACK);
		
		JButton btnTutor = new JButton("Tutor");
		btnTutor.setBounds(32, 345, 148, 29);
		panel_1.add(btnTutor);
		btnTutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(true);
				new Tutorinfo();
			}
		});
		btnTutor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTutor.setForeground(Color.BLACK);
		
		JButton btnEditStudent = new JButton("Student");
		btnEditStudent.setBounds(32, 396, 148, 29);
		panel_1.add(btnEditStudent);
		btnEditStudent.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEditStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(true);
				new EnrollStudent_Admin();
			}
		});
		btnEditStudent.setForeground(Color.BLACK);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setBounds(62, 24, 105, 20);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JButton btnEnrolledStudent = new JButton("Enrolled Student");
		btnEnrolledStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(true);
				new EnrolledStudent_Admin();
			}
		});
		btnEnrolledStudent.setBounds(34, 449, 148, 29);
		panel_1.add(btnEnrolledStudent);
		btnEnrolledStudent.setForeground(Color.BLACK);
		btnEnrolledStudent.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Admin_DashBoard.class.getResource("/CourseManagementSystem/Image/Admin.jpg")));
		lblNewLabel_1.setBounds(45, 74, 148, 149);
		panel_1.add(lblNewLabel_1);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(343, 467, 148, 29);
		panel.add(btnLogOut);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new login_page();
			}
		});
		btnLogOut.setForeground(Color.BLACK);
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(82, 82, 82));
		panel_2.setBounds(228, 0, 389, 124);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(66, 11, 256, 82);
		lblNewLabel_2.setIcon(new ImageIcon(Admin_DashBoard.class.getResource("/CourseManagementSystem/Image/HCKING.jpg")));
		panel_2.add(lblNewLabel_2);
		
		JLabel lblStudentInformation = new JLabel("Student Information");
		lblStudentInformation.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStudentInformation.setBounds(351, 167, 174, 20);
		panel.add(lblStudentInformation);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(256, 200, 332, 249);
		panel.add(scrollPane);
		
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
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
		
		scrollPane.setViewportView(table);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(true);
				new Current_Module();
			}
		});
		
		setVisible(true);
	}
}
