package CourseManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AssignedModule_Tutor extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AssignedModule_Tutor frame = new AssignedModule_Tutor();
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
	public AssignedModule_Tutor() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 502, 393);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(107, 211, 241));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModuleName_1_1 = new JLabel("Assigned Modules:");
		lblModuleName_1_1.setForeground(new Color(0, 0, 0));
		lblModuleName_1_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblModuleName_1_1.setBounds(146, 39, 217, 26);
		contentPane.add(lblModuleName_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 81, 457, 184);
		contentPane.add(scrollPane);
		
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Module Code", "Module Name", "Lecturer", "Year", "Semester"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnBack_1 = new JButton("Back");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Instructor_Dashboard();
			}
		});
		btnBack_1.setForeground(Color.BLACK);
		btnBack_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack_1.setBounds(192, 290, 94, 37);
		contentPane.add(btnBack_1);
		
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
		
		setVisible(true);
	}
}
