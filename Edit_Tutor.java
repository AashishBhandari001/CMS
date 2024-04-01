package CourseManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.jdbc.PreparedStatement;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class Edit_Tutor extends JFrame {

	private JPanel contentPane;
	private JTextField cm;
	private JTextField gmail;
	private JTextField tm;
	private JTextField ln;
	private JTextField fn;
	private JTable Edit_Tutor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Edit_Tutor frame = new Edit_Tutor();
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
	public Edit_Tutor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblEditTutor = new JLabel("Edit Tutor");
		lblEditTutor.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEditTutor.setBounds(155, 20, 118, 20);
		contentPane.add(lblEditTutor);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//update the table from taking input from the user
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
					
					//creating a statement
					String query = "UPDATE add_tutor SET Full_Name=?,Last_Name=?,Teaching_Module=?,Gmail=?,Mobile_Number=?";
				        PreparedStatement pstat =  (PreparedStatement) con.prepareStatement(query);
				        pstat.setString(1, fn.getText());
				        pstat.setString(2, ln.getText());
				        pstat.setString(3, tm.getText());
				        pstat.setString(4, gmail.getText());
				        pstat.setString(5, cm.getText());
					pstat.executeUpdate();
					System.out.println("Table created");
					JOptionPane.showMessageDialog(null, "Edited");
					con.close();
				} catch (Exception e1) {
					e1.printStackTrace();
					
				}
			}
		});
		btnEdit.setForeground(Color.BLACK);
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEdit.setBounds(206, 427, 114, 37);
		contentPane.add(btnEdit);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Tutorinfo();
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBounds(62, 427, 114, 37);
		contentPane.add(btnBack);
		
		JLabel lblContactNumber = new JLabel("Contact Number");
		lblContactNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContactNumber.setBounds(62, 370, 118, 20);
		contentPane.add(lblContactNumber);
		
		cm = new JTextField();
		cm.setColumns(10);
		cm.setBounds(206, 370, 151, 20);
		contentPane.add(cm);
		
		gmail = new JTextField();
		gmail.setColumns(10);
		gmail.setBounds(206, 339, 151, 20);
		contentPane.add(gmail);
		
		tm = new JTextField();
		tm.setColumns(10);
		tm.setBounds(206, 308, 151, 20);
		contentPane.add(tm);
		
		ln = new JTextField();
		ln.setColumns(10);
		ln.setBounds(206, 275, 151, 20);
		contentPane.add(ln);
		
		fn = new JTextField();
		fn.setColumns(10);
		fn.setBounds(206, 243, 151, 20);
		contentPane.add(fn);
		
		JLabel lblFullName = new JLabel("Full Name");
		lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFullName.setBounds(62, 243, 101, 20);
		contentPane.add(lblFullName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastName.setBounds(62, 275, 101, 20);
		contentPane.add(lblLastName);
		
		JLabel lblTeachingModule = new JLabel("Teaching Module");
		lblTeachingModule.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTeachingModule.setBounds(62, 308, 138, 20);
		contentPane.add(lblTeachingModule);
		
		JLabel lblGmail = new JLabel("Gmail");
		lblGmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGmail.setBounds(62, 339, 101, 20);
		contentPane.add(lblGmail);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 443, 177);
		contentPane.add(scrollPane);
		
		Edit_Tutor = new JTable();
		Edit_Tutor.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"First Name", "Last Name", "Subject", "Gmail", "Mobile"
			}
		));
		try{
	    	Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
		        
		        String qry = "SELECT Full_Name, Last_Name, Teaching_Module, Gmail, Mobile_Number FROM add_tutor";
	//"select ID, module_code, module_name,level, semester, optional from course where course_name = ? and level = ?";
		        
		        Statement pstat = con.createStatement();
		        
		        ResultSet rs = pstat.executeQuery(qry);
		        
		        DefaultTableModel model = (DefaultTableModel)Edit_Tutor.getModel();
		        
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
		scrollPane.setViewportView(Edit_Tutor);
		setVisible(true);
	}
}
