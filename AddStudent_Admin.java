package CourseManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class AddStudent_Admin extends JFrame {

	private JPanel contentPane;
	private JTextField fn;
	private JTextField ln;
	private JTextField stdid;
	private JTextField level;
	private JTextField sem;
	private JTextField gmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudent_Admin frame = new AddStudent_Admin();
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
	public AddStudent_Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 426);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(222, 179, 242));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddStudent = new JLabel("Add Student");
		lblAddStudent.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddStudent.setBounds(140, 28, 119, 20);
		contentPane.add(lblAddStudent);
		
		JLabel lblFullName = new JLabel("First Name");
		lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFullName.setBounds(70, 77, 101, 20);
		contentPane.add(lblFullName);
		
		fn = new JTextField();
		fn.setColumns(10);
		fn.setBounds(208, 79, 151, 20);
		contentPane.add(fn);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastName.setBounds(67, 114, 101, 20);
		contentPane.add(lblLastName);
		
		JLabel lblStudentid = new JLabel("Student_Id");
		lblStudentid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStudentid.setBounds(69, 148, 138, 20);
		contentPane.add(lblStudentid);
		
		JLabel lblGmail = new JLabel("Level");
		lblGmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGmail.setBounds(68, 184, 101, 20);
		contentPane.add(lblGmail);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new EnrollStudent_Admin();
				
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBounds(70, 315, 114, 37);
		contentPane.add(btnBack);
		
		JButton btnSubmit = new JButton("Add");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
					
					//creating a statement
					String query = "INSERT INTO student_details(First_Name, Last_Name, Student_ID, Level, Semester, Gmail) VALUES(?,?,?,?,?,?)";
				        PreparedStatement pstat =  (PreparedStatement) con.prepareStatement(query);
				        pstat.setString(1, fn.getText());
				        pstat.setString(2, ln.getText());
				        pstat.setString(3, stdid.getText());
				        pstat.setString(4, level.getText());
				        pstat.setString(5, sem.getText());
				        pstat.setString(6, gmail.getText());
					pstat.executeUpdate();
					JOptionPane.showMessageDialog(null, "Student added");
					con.close();
				} catch (Exception e1) {
					e1.printStackTrace();
					
				}
			}
		});
		btnSubmit.setForeground(Color.BLACK);
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSubmit.setBounds(214, 315, 114, 37);
		contentPane.add(btnSubmit);
		
		JLabel lblLevel = new JLabel("Semester");
		lblLevel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLevel.setBounds(67, 217, 101, 20);
		contentPane.add(lblLevel);
		
		JLabel lblSemester = new JLabel("Gmail");
		lblSemester.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSemester.setBounds(66, 255, 118, 20);
		contentPane.add(lblSemester);
		
		ln = new JTextField();
		ln.setColumns(10);
		ln.setBounds(208, 114, 151, 20);
		contentPane.add(ln);
		
		stdid = new JTextField();
		stdid.setColumns(10);
		stdid.setBounds(206, 150, 151, 20);
		contentPane.add(stdid);
		
		level = new JTextField();
		level.setColumns(10);
		level.setBounds(207, 185, 151, 20);
		contentPane.add(level);
		
		sem = new JTextField();
		sem.setColumns(10);
		sem.setBounds(205, 217, 151, 20);
		contentPane.add(sem);
		
		gmail = new JTextField();
		gmail.setColumns(10);
		gmail.setBounds(206, 251, 151, 20);
		contentPane.add(gmail);
		setVisible(true);
	}
}
