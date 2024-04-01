package CourseManagementSystem;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class Delete_Module extends JFrame {

	private JPanel contentPane;
	private JTable Delete_Module;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete_Module frame = new Delete_Module();
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
	public Delete_Module() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 535);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 226, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDelete = new JButton("Erase");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
			}
		);
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDelete.setBounds(199, 435, 114, 37);
		contentPane.add(btnDelete);
		
		JLabel lblDeleteModule = new JLabel("Delete Module");
		lblDeleteModule.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDeleteModule.setBounds(161, 22, 137, 20);
		contentPane.add(lblDeleteModule);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Current_Module();
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBounds(78, 435, 96, 37);
		contentPane.add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 61, 436, 194);
		contentPane.add(scrollPane);
		
		Delete_Module = new JTable();
		Delete_Module.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Module Code", "Module Name", "Lecturer", "Year", "Semester"
			}
		));
		scrollPane.setViewportView(Delete_Module);
		
		JLabel lblModuleName = new JLabel("Module Code");
		lblModuleName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModuleName.setBounds(48, 283, 114, 20);
		contentPane.add(lblModuleName);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(48, 314, 96, 20);
		contentPane.add(textField);
		
		JLabel lblModuleName_1 = new JLabel("Module Name");
		lblModuleName_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModuleName_1.setBounds(48, 343, 114, 20);
		contentPane.add(lblModuleName_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(48, 374, 96, 20);
		contentPane.add(textField_1);
		
		JLabel lblModuleName_1_2 = new JLabel("Lecturer");
		lblModuleName_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModuleName_1_2.setBounds(199, 283, 90, 20);
		contentPane.add(lblModuleName_1_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(193, 314, 96, 20);
		contentPane.add(textField_2);
		
		JLabel lblModuleName_1_1 = new JLabel("Year");
		lblModuleName_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModuleName_1_1.setBounds(226, 343, 33, 20);
		contentPane.add(lblModuleName_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(214, 374, 69, 20);
		contentPane.add(textField_3);
		
		JLabel lblModuleName_1_1_1 = new JLabel("Semester");
		lblModuleName_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModuleName_1_1_1.setBounds(338, 326, 76, 20);
		contentPane.add(lblModuleName_1_1_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(338, 357, 69, 20);
		contentPane.add(textField_4);
		try{
	    	Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
		        
		        String qry = "SELECT Module_Code, Module_Name, Lecturer, year, Semester FROM modules";
	//"select ID, module_code, module_name,level, semester, optional from course where course_name = ? and level = ?";
		        
		        Statement pstat = con.createStatement();
		        
		        ResultSet rs = pstat.executeQuery(qry);
		        
		        DefaultTableModel model = (DefaultTableModel)Delete_Module.getModel();
		        
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
