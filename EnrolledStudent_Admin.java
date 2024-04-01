package CourseManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EnrolledStudent_Admin extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnrolledStudent_Admin frame = new EnrolledStudent_Admin();
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
	public EnrolledStudent_Admin() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 509, 423);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRecentlyEnrolledStudents = new JLabel("Recently Enrolled Students");
		lblRecentlyEnrolledStudents.setBounds(140, 44, 240, 37);
		lblRecentlyEnrolledStudents.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblRecentlyEnrolledStudents);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 90, 473, 194);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"First Name", "Last Name", "Course", "level", "Semester", "Gmail", "Contact Number"
			}
		));
		try{
	    	Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
		        
		        String qry = "SELECT First_Name, Last_Name, Course, Level, Semester, Gmail, Contact_Number FROM enrolled_student";
	//"select ID, module_code, module_name,level, semester, optional from course where course_name = ? and level = ?";
		        
		        Statement pstat = con.createStatement();
		        
		        ResultSet rs = pstat.executeQuery(qry);
		        
		        DefaultTableModel model = (DefaultTableModel)table.getModel();
		        
		        while(rs.next()) {
		        	String First_Name = rs.getString("First_Name");
		        	String Last_Name = rs.getString("Last_Name");
		        	String Course = rs.getString("Course");
		        	String Level = rs.getString("Level");
		        	String Semester = rs.getString("Semester");
		        	String Gmail = rs.getString("Gmail");
		        	String Contact_Number = rs.getString("Contact_Number");
		        	
		        	String[] row = {First_Name,Last_Name,Course,Level,Semester,Gmail,Contact_Number};
		        	model.addRow(row);
		        	
		        }

		        
		        pstat.close();
		        con.close();
	    }catch (Exception exp){
	        System.out.println(exp);
	    }
		
		scrollPane.setViewportView(table);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Admin_DashBoard();
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBounds(62, 305, 157, 37);
		contentPane.add(btnBack);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new EnrollStudent_Admin();
			}
		});
		btnInsert.setForeground(Color.BLACK);
		btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnInsert.setBounds(229, 305, 157, 37);
		contentPane.add(btnInsert);
		setVisible(true);
	}
}
