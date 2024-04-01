package CourseManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class CourseChoose_Student extends JFrame {

	private JPanel contentPane;
	private JTable module;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CourseChoose_Student frame = new CourseChoose_Student();
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
	
	//dispose on close is used to exit from the selsected page only 
	public CourseChoose_Student() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 529, 543);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(137, 228, 157));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBschonsComputing = new JLabel("Welcome to Herald College Kathmandu");
		lblBschonsComputing.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBschonsComputing.setBounds(73, 42, 348, 20);
		contentPane.add(lblBschonsComputing);
		
		JLabel lblNewLabel = new JLabel("Level: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(36, 94, 66, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Under Graduate/Post Graduate");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(171, 94, 194, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblEntryRequirements = new JLabel("Entry Requirements");
		lblEntryRequirements.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEntryRequirements.setBounds(36, 140, 157, 21);
		contentPane.add(lblEntryRequirements);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Requirements();
			}
		});
		btnView.setForeground(Color.BLACK);
		btnView.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnView.setBounds(203, 139, 108, 23);
		contentPane.add(btnView);
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Student_Dashboard(lblEntryRequirements.getText());
			}
		});
		back.setForeground(Color.BLACK);
		back.setFont(new Font("Tahoma", Font.PLAIN, 16));
		back.setBounds(94, 443, 126, 28);
		contentPane.add(back);
		
		JButton btnEnroll_1 = new JButton("Enroll");
		btnEnroll_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new EnrolledStudent_Student();
			}
		});
		btnEnroll_1.setForeground(Color.BLACK);
		btnEnroll_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEnroll_1.setBounds(230, 443, 126, 28);
		contentPane.add(btnEnroll_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 259, 495, 158);
		contentPane.add(scrollPane);
		module = new JTable();
		
		//create table according to the following column
		module.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Module code", "Available Module", "Lecturer", "Year", "Semester"
			}
		));
		try{
	    	Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
		        
		        String qry = "SELECT Module_Code, Module_Name, Lecturer, year, Semester FROM modules";
	//"select ID, module_code, module_name,level, semester, optional from course where course_name = ? and level = ?";
		        
		        Statement pstat = con.createStatement();
		        
		        ResultSet rs = pstat.executeQuery(qry);
		        
		        DefaultTableModel model = (DefaultTableModel)module.getModel();
		        
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
		scrollPane.setViewportView(module);
		
		JLabel lblCurrentModules = new JLabel("Available Modules");
		lblCurrentModules.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCurrentModules.setBounds(171, 215, 225, 21);
		contentPane.add(lblCurrentModules);
		setVisible(true);
	}

}
