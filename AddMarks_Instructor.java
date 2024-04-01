package CourseManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
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
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class AddMarks_Instructor extends JFrame {

	private JPanel contentPane;
	private JTextField stdid;
	private JTextField fn;
	private JTextField ln;
	private JTextField level;
	private JTextField sem;
	private JTextField modulename;
	private JTable table;
	private JTextField Marks;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMarks_Instructor frame = new AddMarks_Instructor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame to give access to the tutor AddMarks_Instructor to add the marks
	 */
	public AddMarks_Instructor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 549);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 253, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModuleName_1 = new JLabel("Insert Marks");
		lblModuleName_1.setBounds(163, 24, 135, 26);
		lblModuleName_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		contentPane.add(lblModuleName_1);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFirstName.setBounds(10, 296, 101, 20);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastName.setBounds(10, 327, 101, 20);
		contentPane.add(lblLastName);
		
		JLabel lblStudentid = new JLabel("Student_Id");
		lblStudentid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStudentid.setBounds(10, 265, 138, 20);
		contentPane.add(lblStudentid);
		
		JLabel lblLevel = new JLabel("Level");
		lblLevel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLevel.setBounds(309, 281, 101, 20);
		contentPane.add(lblLevel);
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSemester.setBounds(309, 312, 118, 20);
		contentPane.add(lblSemester);
		
		stdid = new JTextField();
		stdid.setColumns(10);
		stdid.setBounds(121, 267, 151, 20);
		contentPane.add(stdid);
		
		fn = new JTextField();
		fn.setColumns(10);
		fn.setBounds(121, 298, 151, 20);
		contentPane.add(fn);
		
		ln = new JTextField();
		ln.setColumns(10);
		ln.setBounds(122, 329, 151, 20);
		contentPane.add(ln);
		
		level = new JTextField();
		level.setColumns(10);
		level.setBounds(383, 283, 151, 20);
		contentPane.add(level);
		
		sem = new JTextField();
		sem.setColumns(10);
		sem.setBounds(383, 314, 151, 20);
		contentPane.add(sem);
		
		modulename = new JTextField();
		modulename.setColumns(10);
		modulename.setBounds(122, 360, 151, 20);
		contentPane.add(modulename);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new MarkInsert_Tutor();
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBounds(47, 464, 94, 37);
		contentPane.add(btnBack);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// connect to the data base using database driver
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
					
					/*
					 The tutor will add the marks and the grade pannel will evaluate if 
					 the marks is more than 70 it generate first class honor, if less than 60 then second
					 class and less then 50 is lower class and lower marks than 40 is third class 
					 and is less than 40 it is fail.. Overall grade is calculated as well
					 */
					
					int  marks = Integer.parseInt(Marks.getText());
					String Grade ="";
		            
		            if (marks >= 70) {
		                Grade = "First-Class Honours";
		               
		            } else if (marks >= 60) {
		                Grade = "Upper Second-Class Honours";
		               
		            } else if (marks >= 50) {
		                Grade = "Lower Second-Class Honours";
		               
		            } else if (marks >= 40) {
		                Grade = "Third Class Honours";
		               
		            } else {
		                Grade = "Fail";
		               
		            }
					//creating a statement to insert the datails in result table
					String query = "INSERT INTO result(Student_ID, First_Name, Last_Name, Module_Name, Level, Semester, Marks,grade) VALUES(?,?,?,?,?,?,?,?)";
				        PreparedStatement pstat =  (PreparedStatement) con.prepareStatement(query);
				        pstat.setString(1, stdid.getText());
				        pstat.setString(2, fn.getText());
				        pstat.setString(3, ln.getText());
				        pstat.setString(4, modulename.getText());
				        pstat.setString(5, level.getText());
				        pstat.setString(6, sem.getText());
				        pstat.setString(7, Marks.getText());
				        pstat.setString(8, Grade);
					pstat.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Marks added");
					con.close();
				} catch (Exception e1) {
					e1.printStackTrace();
					
				}
			}
			
		});
		btnInsert.setForeground(Color.BLACK);
		btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnInsert.setBounds(214, 408, 114, 37);
		contentPane.add(btnInsert);
		
		JLabel lblModulename = new JLabel("ModuleName");
		lblModulename.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModulename.setBounds(10, 358, 101, 20);
		contentPane.add(lblModulename);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 80, 513, 164);
		contentPane.add(scrollPane);
		
		//create table to show data from databases
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Student Id", "First Name", "Last Name", "Module Name", "Level", "Semester", "Marks"
			}
		));
		
		//connecting to the table from database 
		try{
	    	Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
		        
		        String qry = "SELECT Student_ID, First_Name, Last_Name, Module_Name, Level, Semester, Marks FROM result";
	//"select ID, module_code, module_name,level, semester, optional from course where course_name = ? and level = ?";
		        
		        Statement pstat = con.createStatement();
		        
		        ResultSet rs = pstat.executeQuery(qry);
		        
		        DefaultTableModel model = (DefaultTableModel)table.getModel();
		        
		        while(rs.next()) {
		        	String Student_ID = rs.getString("Student_ID");
		        	String First_Name = rs.getString("First_Name");
		        	String Last_Name = rs.getString("Last_Name");
		        	String Module_Name = rs.getString("Module_Name");
		        	String Level = rs.getString("Level");
		        	String Semester = rs.getString("Semester");
		        	String Marks = rs.getString("Marks");
		        	
		        	String[] row = {Student_ID,First_Name,Last_Name,Module_Name,Level,Semester,Marks};
		        	model.addRow(row);
		        	
		        }

		        
		        pstat.close();
		        con.close();
	    }catch (Exception exp){
	        System.out.println(exp);
	    }
		scrollPane.setViewportView(table);
		
		JLabel lblMarks = new JLabel("Marks");
		lblMarks.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMarks.setBounds(309, 345, 118, 20);
		contentPane.add(lblMarks);
		
		Marks = new JTextField();
		Marks.setColumns(10);
		Marks.setBounds(383, 347, 151, 20);
		contentPane.add(Marks);
		setVisible(true);
	}

}
