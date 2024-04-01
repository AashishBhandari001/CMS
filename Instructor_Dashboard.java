package CourseManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class Instructor_Dashboard extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Instructor_Dashboard frame = new Instructor_Dashboard();
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
	public Instructor_Dashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 454);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 253, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInstructor = new JLabel("Welcome To Instructor Dshboard");
		lblInstructor.setBounds(277, 34, 320, 50);
		lblInstructor.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lblInstructor);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new login_page();
			}
		});
		btnLogOut.setForeground(Color.BLACK);
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogOut.setBounds(324, 378, 114, 23);
		contentPane.add(btnLogOut);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(267, 133, 330, 222);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"First Name", "Last Name", "Subject", "Gmail", "Mobile Number"
			}
		));
		try{
	    	Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
		        
		        String qry = "SELECT Full_Name, Last_Name, Teaching_Module, Gmail, Mobile_Number FROM add_tutor";
	//"select ID, module_code, module_name,level, semester, optional from course where course_name = ? and level = ?";
		        
		        Statement pstat = con.createStatement();
		        
		        ResultSet rs = pstat.executeQuery(qry);
		        
		        DefaultTableModel model = (DefaultTableModel)table.getModel();
		        
		        while(rs.next()) {
		        	String Full_Name = rs.getString("Full_Name");
		        	String Last_Name = rs.getString("Last_Name");
		        	String Teaching_Module = rs.getString("Teaching_Module");
		        	String Gmail = rs.getString("Gmail");
		        	String Mobile_Number = rs.getString("Mobile_Number");
		        	
		        	String[] row = {Full_Name,Last_Name,Teaching_Module,Gmail,Mobile_Number};
		        	model.addRow(row);
		        	
		        }

		        
		        pstat.close();
		        con.close();
	    }catch (Exception exp){
	        System.out.println(exp);
	    }
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(131, 175, 155));
		panel.setBounds(0, 0, 248, 420);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(28, 11, 199, 207);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(Instructor_Dashboard.class.getResource("/CourseManagementSystem/Image/dashboard.jpg")));
		
		JButton btnRegisteredStudents = new JButton("Generate Result");
		btnRegisteredStudents.setBounds(28, 342, 185, 29);
		panel.add(btnRegisteredStudents);
		btnRegisteredStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new MarkInsert_Tutor();
			}
		});
		btnRegisteredStudents.setForeground(Color.BLACK);
		btnRegisteredStudents.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnRegisteredStudents_1 = new JButton("Registered Students");
		btnRegisteredStudents_1.setBounds(28, 291, 185, 29);
		panel.add(btnRegisteredStudents_1);
		btnRegisteredStudents_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(true);
				new EnrollStudent_Instructor();
			}
		});
		btnRegisteredStudents_1.setForeground(Color.BLACK);
		btnRegisteredStudents_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton Module = new JButton("Modules");
		Module.setBounds(28, 242, 185, 29);
		panel.add(Module);
		Module.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(true);
				new AssignedModule_Tutor();
			}
		});
		Module.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Module.setForeground(Color.BLACK);
		
		JLabel lblModuleName_1 = new JLabel("Assigned Tutors");
		lblModuleName_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModuleName_1.setBounds(348, 102, 149, 20);
		contentPane.add(lblModuleName_1);
		setVisible(true);
	}

}
