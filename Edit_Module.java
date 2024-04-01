package CourseManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Edit_Module extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable edit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Edit_Module frame = new Edit_Module();
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
	public Edit_Module() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 446);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 226, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModuleName = new JLabel("Module Code");
		lblModuleName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModuleName.setBounds(72, 205, 114, 20);
		contentPane.add(lblModuleName);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(72, 236, 96, 20);
		contentPane.add(textField);
		
		JLabel lblModuleName_1 = new JLabel("Module Name");
		lblModuleName_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModuleName_1.setBounds(72, 265, 114, 20);
		contentPane.add(lblModuleName_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(72, 296, 96, 20);
		contentPane.add(textField_1);
		
		JLabel lblModuleName_1_2 = new JLabel("Lecturer");
		lblModuleName_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModuleName_1_2.setBounds(223, 205, 90, 20);
		contentPane.add(lblModuleName_1_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(217, 236, 96, 20);
		contentPane.add(textField_2);
		
		JLabel lblModuleName_1_1 = new JLabel("Year");
		lblModuleName_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModuleName_1_1.setBounds(250, 265, 33, 20);
		contentPane.add(lblModuleName_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(362, 279, 69, 20);
		contentPane.add(textField_3);
		
		JLabel lblModuleName_1_1_1 = new JLabel("Semester");
		lblModuleName_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModuleName_1_1_1.setBounds(362, 248, 76, 20);
		contentPane.add(lblModuleName_1_1_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(238, 296, 69, 20);
		contentPane.add(textField_4);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
					
					//creating a statement
					String query = "UPDATE modules SET Module_Code=?,Module_Name=?,Lecturer=?,year=?,Semester=?";
				        PreparedStatement pstat =  (PreparedStatement) con.prepareStatement(query);
				        pstat.setString(1, textField.getText());
				        pstat.setString(2, textField_1.getText());
				        pstat.setString(3, textField_2.getText());
				        pstat.setString(4, textField_3.getText());
				        pstat.setString(5, textField_4.getText());
					pstat.executeUpdate();
					System.out.println("Table created");
					JOptionPane.showMessageDialog(null, "Edited");
					con.close();
				} catch (Exception e1) {
					e1.printStackTrace();
					
				}
			}
			});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdate.setBounds(217, 352, 96, 37);
		contentPane.add(btnUpdate);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Current_Module();
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBounds(49, 352, 96, 37);
		contentPane.add(btnBack);
		
		JLabel lblEditModule = new JLabel("Edit Module");
		lblEditModule.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEditModule.setBounds(195, 11, 122, 20);
		contentPane.add(lblEditModule);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 46, 494, 148);
		contentPane.add(scrollPane);
		edit = new JTable();
		edit.setModel(new DefaultTableModel(
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
		        
		        DefaultTableModel model = (DefaultTableModel)edit.getModel();
		        
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
		
		scrollPane.setViewportView(edit);
		setVisible(true);
		
		
	}
}
