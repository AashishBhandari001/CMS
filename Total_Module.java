package CourseManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Total_Module extends JFrame {

	private JPanel contentPane;
	private JTable Moduleassigned;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Total_Module frame = new Total_Module();
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
	public Total_Module() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAssignedModule = new JLabel("Assigned Module");
		lblAssignedModule.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAssignedModule.setBounds(255, 52, 158, 20);
		contentPane.add(lblAssignedModule);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(157, 122, 404, 197);
		contentPane.add(scrollPane);
		
		Moduleassigned = new JTable();
		Moduleassigned.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Module Code", "Module Name", "Lecturer", "Year", "Sem"
			}
		));
		
		
		scrollPane.setViewportView(Moduleassigned);
		
		try{
	    	Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
		        
		        String qry = "SELECT Module_Code, Module_Name, Lecturer, year, Semester FROM modules";
	//"select ID, module_code, module_name,level, semester, optional from course where course_name = ? and level = ?";
		        
		        Statement pstat = con.createStatement();
		        
		        ResultSet rs = pstat.executeQuery(qry);
		        
		        DefaultTableModel model = (DefaultTableModel)Moduleassigned.getModel();
		        
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
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Instructor_Dashboard();
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBounds(10, 266, 114, 37);
		contentPane.add(btnBack);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Add_Module();
			}
		});
		btnAdd.setForeground(Color.BLACK);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdd.setBounds(10, 122, 114, 37);
		contentPane.add(btnAdd);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setForeground(Color.BLACK);
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEdit.setBounds(10, 170, 114, 37);
		contentPane.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDelete.setBounds(10, 218, 114, 37);
		contentPane.add(btnDelete);
		setVisible(true);
	}
}
