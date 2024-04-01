package CourseManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import com.mysql.cj.jdbc.PreparedStatement;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
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

public class Delete_Tutor extends JFrame {

	private JPanel contentPane;
	private JTextField firstname;
	private JTextField lastname;
	private JTextField teachingmodule;
	private JTextField gmail;
	private JTextField contact;
	private JTable table_1;
	private JTable add_table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete_Tutor frame = new Delete_Tutor();
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
	public Delete_Tutor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeleteTutor = new JLabel("Delete Tutor");
		lblDeleteTutor.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDeleteTutor.setBounds(167, 25, 118, 20);
		contentPane.add(lblDeleteTutor);
		
		JLabel lblFullName = new JLabel("Full Name");
		lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFullName.setBounds(78, 273, 101, 20);
		contentPane.add(lblFullName);
		
		firstname = new JTextField();
		firstname.setColumns(10);
		firstname.setBounds(222, 273, 151, 20);
		contentPane.add(firstname);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastName.setBounds(78, 305, 101, 20);
		contentPane.add(lblLastName);
		
		lastname = new JTextField();
		lastname.setColumns(10);
		lastname.setBounds(222, 305, 151, 20);
		contentPane.add(lastname);
		
		JLabel lblTeachingModule = new JLabel("Teaching Module");
		lblTeachingModule.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTeachingModule.setBounds(78, 338, 138, 20);
		contentPane.add(lblTeachingModule);
		
		teachingmodule = new JTextField();
		teachingmodule.setColumns(10);
		teachingmodule.setBounds(222, 338, 151, 20);
		contentPane.add(teachingmodule);
		
		JLabel lblGmail = new JLabel("Gmail");
		lblGmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGmail.setBounds(78, 369, 101, 20);
		contentPane.add(lblGmail);
		
		gmail = new JTextField();
		gmail.setColumns(10);
		gmail.setBounds(222, 369, 151, 20);
		contentPane.add(gmail);
		
		JLabel lblContactNumber = new JLabel("Contact Number");
		lblContactNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContactNumber.setBounds(78, 400, 118, 20);
		contentPane.add(lblContactNumber);
		
		contact = new JTextField();
		contact.setColumns(10);
		contact.setBounds(222, 400, 151, 20);
		contentPane.add(contact);
		
		JButton btnSubmit = new JButton("Delete");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
					
					//creating a statement
					String query = "DELETE FROM add_tutor SET Full_Name=?,Last_Name=?,Teaching_Module=?,Gmail=?,Mobile_Number=?";
				        PreparedStatement pstat =  (PreparedStatement) con.prepareStatement(query);
				        pstat.setString(1, firstname.getText());
				        pstat.setString(2, lastname.getText());
				        pstat.setString(3, teachingmodule.getText());
				        pstat.setString(4, gmail.getText());
				        pstat.setString(5, contact.getText());
					pstat.executeUpdate();
					System.out.println("Table created");
					JOptionPane.showMessageDialog(null, "Edited");
					con.close();
//					pstat.close();
				} catch (Exception e1) {
					e1.printStackTrace();
					
				}
			}
		});
		btnSubmit.setForeground(Color.BLACK);
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSubmit.setBounds(222, 457, 114, 37);
		contentPane.add(btnSubmit);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Tutorinfo();
			}
			
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBounds(78, 457, 114, 37);
		contentPane.add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 64, 464, 186);
		contentPane.add(scrollPane);
		
		add_table = new JTable();
		add_table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"First Name", "Last Name", "Subject", "Gmail", "Mobile Number"
			}
		));
		scrollPane.setViewportView(add_table);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Full Name", "last name", "subject", "gmail", "Mobile Number"
			}
		));
		
		 
    
    try{
    	Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
	        
	        String qry = "SELECT Full_Name, Last_Name, Teaching_Module, Gmail, Mobile_Number FROM add_tutor";
//"select ID, module_code, module_name,level, semester, optional from course where course_name = ? and level = ?";
	        
	        Statement pstat = con.createStatement();
	        
	        ResultSet rs = pstat.executeQuery(qry);
	        
	        DefaultTableModel model = (DefaultTableModel)add_table.getModel();
	        
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
    
    setVisible(true);
		
		
		
	}

}
