package CourseManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EnrolledStudent_Student extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField fn;
	private JTextField ln;
	private JTextField course;
	private JTextField gmail;
	private JTextField cn;
	private JTextField level;
	private JTextField sem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnrolledStudent_Student frame = new EnrolledStudent_Student();
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
	public EnrolledStudent_Student() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 588);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 247, 156));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLetsBeTogether = new JLabel("Let's be Together");
		lblLetsBeTogether.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblLetsBeTogether.setBounds(143, 22, 247, 41);
		contentPane.add(lblLetsBeTogether);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 148, 471, 164);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Module Code", "Module Name", "Lecturer", "Year", "Semester"
			}
		));
		
		try{
	    	Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
		        
		        String qry = "SELECT Module_Code, Module_Name, Lecturer, year, Semester FROM modules";
	//"select ID, module_code, module_name,level, semester, optional from course where course_name = ? and level = ?";
		        
		        Statement pstat = con.createStatement();
		        
		        ResultSet rs = pstat.executeQuery(qry);
		        
		        DefaultTableModel model = (DefaultTableModel)table.getModel();
		        
		        while(rs.next()) {
		        	String Module_Code = rs.getString("Module_Code");
		        	String Module_Name = rs.getString("Module_Name");
		        	String Lecturer = rs.getString("Lecturer");
		        	String year = rs.getString("year");
		        	String Semester = rs.getString("Semester");
		        	
		        	String[] row = {Module_Code,Module_Name,Lecturer,year,Semester};
		        	model.addRow(row);
		        	
		        }

		        
		        pstat.close();
		        con.close();
	    }catch (Exception exp){
	        System.out.println(exp);
	    }
		scrollPane.setViewportView(table);
		
		JLabel lblCurrentlyAvailableModules = new JLabel("Currently Available Modules");
		lblCurrentlyAvailableModules.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCurrentlyAvailableModules.setBounds(132, 94, 258, 41);
		contentPane.add(lblCurrentlyAvailableModules);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFirstName.setBounds(20, 323, 101, 20);
		contentPane.add(lblFirstName);
		
		fn = new JTextField();
		fn.setColumns(10);
		fn.setBounds(116, 325, 112, 20);
		contentPane.add(fn);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastName.setBounds(20, 354, 101, 20);
		contentPane.add(lblLastName);
		
		ln = new JTextField();
		ln.setColumns(10);
		ln.setBounds(116, 354, 112, 20);
		contentPane.add(ln);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCourse.setBounds(20, 385, 101, 20);
		contentPane.add(lblCourse);
		
		course = new JTextField();
		course.setColumns(10);
		course.setBounds(116, 385, 112, 20);
		contentPane.add(course);
		
		JLabel lblGmail_1 = new JLabel("Gmail");
		lblGmail_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGmail_1.setBounds(258, 354, 101, 20);
		contentPane.add(lblGmail_1);
		
		gmail = new JTextField();
		gmail.setColumns(10);
		gmail.setBounds(385, 354, 97, 20);
		contentPane.add(gmail);
		
		JLabel lblGmail_1_1 = new JLabel("Contact Number");
		lblGmail_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGmail_1_1.setBounds(258, 385, 140, 20);
		contentPane.add(lblGmail_1_1);
		
		cn = new JTextField();
		cn.setColumns(10);
		cn.setBounds(385, 385, 96, 20);
		contentPane.add(cn);
		
		JLabel lblLevel = new JLabel("Level");
		lblLevel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLevel.setBounds(20, 416, 101, 20);
		contentPane.add(lblLevel);
		
		level = new JTextField();
		level.setColumns(10);
		level.setBounds(116, 416, 112, 20);
		contentPane.add(level);
		
		JLabel lblCourse_1_1 = new JLabel("Semester");
		lblCourse_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCourse_1_1.setBounds(20, 447, 101, 20);
		contentPane.add(lblCourse_1_1);
		
		sem = new JTextField();
		sem.setColumns(10);
		sem.setBounds(116, 447, 112, 20);
		contentPane.add(sem);
		
		JButton btnBack_1 = new JButton("Enroll");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
					
					//creating a statement
					String query = "INSERT INTO enrolled_student(First_Name, Last_Name, Course, Level, Semester, Gmail, Contact_Number) VALUES(?,?,?,?,?,?,?)";
				        PreparedStatement pstat =  (PreparedStatement) con.prepareStatement(query);
				        pstat.setString(1, fn.getText());
				        pstat.setString(2, ln.getText());
				        pstat.setString(3, course.getText());
				        pstat.setString(4, level.getText());
				        pstat.setString(5, sem.getText());
				        pstat.setString(6, gmail.getText());
				        pstat.setString(7, cn.getText());
					pstat.executeUpdate();
					JOptionPane.showMessageDialog(null, "Enrolled");
					con.close();
				} catch (Exception e1) {
					e1.printStackTrace();
					
				}
			}
		});
		btnBack_1.setForeground(Color.BLACK);
		btnBack_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack_1.setBounds(210, 491, 94, 37);
		contentPane.add(btnBack_1);
		
		JButton btnBack_1_1 = new JButton("Back");
		btnBack_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new CourseChoose_Student();
			}
		});
		btnBack_1_1.setForeground(Color.BLACK);
		btnBack_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack_1_1.setBounds(103, 491, 94, 37);
		contentPane.add(btnBack_1_1);
		setVisible(true);
	}
}
