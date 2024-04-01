package CourseManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class Tutorinfo extends JFrame {

	private JPanel contentPane;
	private JTable Tutors;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tutorinfo frame = new Tutorinfo();
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
	public Tutorinfo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 564, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTutorInformation = new JLabel("Tutor Information");
		lblTutorInformation.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTutorInformation.setBounds(158, 11, 163, 20);
		contentPane.add(lblTutorInformation);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Admin_DashBoard();
			}
		
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBounds(10, 230, 114, 37);
		contentPane.add(btnBack);
		
		JButton btnSubmit = new JButton("Add");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Add_Tutor();
			}
		});
		btnSubmit.setForeground(Color.BLACK);
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSubmit.setBounds(146, 230, 114, 37);
		contentPane.add(btnSubmit);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Edit_Tutor();
			}
		});
		btnEdit.setForeground(Color.BLACK);
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEdit.setBounds(275, 230, 114, 37);
		contentPane.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Delete_Tutor();
			}
		});
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDelete.setBounds(399, 230, 114, 37);
		contentPane.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 52, 508, 167);
		contentPane.add(scrollPane);
		
		Tutors = new JTable();
		Tutors.setModel(new DefaultTableModel(
			new Object[][] {
			},
			
			new String[] {
				"Full Name", "Last Name", "Subject", "Gmail", "Mobile Number"
			}
		));
		//-------------------------------------------------------------------------------
		
		//select the data from the add_tutor and show it in respected columns
		try{
	    	Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
		        
		        String qry = "SELECT Full_Name, Last_Name, Teaching_Module, Gmail, Mobile_Number FROM add_tutor";
	//"select ID, module_code, module_name,level, semester, optional from course where course_name = ? and level = ?";
		        
		        Statement pstat = con.createStatement();
		        
		        ResultSet rs = pstat.executeQuery(qry);
		        
		        DefaultTableModel model = (DefaultTableModel)Tutors.getModel();
		        
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
		
		scrollPane.setViewportView(Tutors);
		setVisible(true);
}
}
