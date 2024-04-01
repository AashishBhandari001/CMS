package CourseManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

public class Current_Module extends JFrame {

	private JPanel contentPane;
	private JTable module_table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Current_Module frame = new Current_Module();
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
	public Current_Module() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 560, 524);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 226, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddModule = new JLabel("Current Module");
		lblAddModule.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddModule.setBounds(250, 83, 152, 20);
		contentPane.add(lblAddModule);
		
		JButton btnSubmit = new JButton("Add");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Add_Module();
			}
		});
		btnSubmit.setForeground(Color.BLACK);
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSubmit.setBounds(59, 414, 114, 37);
		contentPane.add(btnSubmit);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Edit_Module();
				
			}
		});
		btnEdit.setForeground(Color.BLACK);
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEdit.setBounds(211, 414, 114, 37);
		contentPane.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Delete_Module();
			}
		});
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDelete.setBounds(361, 414, 114, 37);
		contentPane.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 171, 526, 194);
		contentPane.add(scrollPane);
		
		module_table = new JTable();
		module_table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Module code", "Module Name", "Lecturer", "Year", "Semester"
			}
		));
		scrollPane.setViewportView(module_table);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Current_Module.class.getResource("/CourseManagementSystem/Image/Course.jpg")));
		lblNewLabel.setBounds(28, 25, 172, 123);
		contentPane.add(lblNewLabel);
		
		try{
	    	Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
		        
		        String qry = "SELECT Module_Code, Module_Name, Lecturer, year, Semester FROM modules";
	//"select ID, module_code, module_name,level, semester, optional from course where course_name = ? and level = ?";
		        
		        Statement pstat = con.createStatement();
		        
		        ResultSet rs = pstat.executeQuery(qry);
		        
		        DefaultTableModel model = (DefaultTableModel)module_table.getModel();
		        
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
