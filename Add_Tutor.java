package CourseManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.jdbc.PreparedStatement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;

public class Add_Tutor extends JFrame {

	private JPanel contentPane;
	private JTextField FN;
	private JTextField LN;
	private JTextField Sub;
	private JTextField Gmail;
	private JTextField Phn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Tutor frame = new Add_Tutor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame 
	 */
	public Add_Tutor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 419, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddTutor = new JLabel("Add Tutor");
		lblAddTutor.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddTutor.setBounds(127, 27, 118, 20);
		contentPane.add(lblAddTutor);
		
		JLabel lblFullName = new JLabel("Full Name");
		lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFullName.setBounds(27, 77, 101, 20);
		contentPane.add(lblFullName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastName.setBounds(27, 109, 101, 20);
		contentPane.add(lblLastName);
		
		JLabel lblTeachingModule = new JLabel("Teaching Module");
		lblTeachingModule.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTeachingModule.setBounds(27, 142, 138, 20);
		contentPane.add(lblTeachingModule);
		
		JLabel lblGmail = new JLabel("Gmail");
		lblGmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGmail.setBounds(27, 173, 101, 20);
		contentPane.add(lblGmail);
		
		JLabel lblContactNumber = new JLabel("Contact Number");
		lblContactNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContactNumber.setBounds(27, 204, 118, 20);
		contentPane.add(lblContactNumber);
		
		FN = new JTextField();
		FN.setColumns(10);
		FN.setBounds(171, 77, 151, 20);
		contentPane.add(FN);
		
		LN = new JTextField();
		LN.setColumns(10);
		LN.setBounds(171, 109, 151, 20);
		contentPane.add(LN);
		
		Sub = new JTextField();
		Sub.setColumns(10);
		Sub.setBounds(171, 142, 151, 20);
		contentPane.add(Sub);
		
		Gmail = new JTextField();
		Gmail.setColumns(10);
		Gmail.setBounds(171, 173, 151, 20);
		contentPane.add(Gmail);
		
		Phn = new JTextField();
		Phn.setColumns(10);
		Phn.setBounds(171, 204, 151, 20);
		contentPane.add(Phn);
		
		JButton btnSubmit = new JButton("Add");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
					
					//creating a statement to add the tutor in column add_tutor ---- ? is used to pass the parameters
					String query = "INSERT INTO add_tutor(Full_Name, Last_Name, Teaching_Module, Gmail, Mobile_Number) VALUES(?,?,?,?,?)";
				        PreparedStatement pstat =  (PreparedStatement) con.prepareStatement(query);
				        pstat.setString(1, FN.getText());
				        pstat.setString(2, LN.getText());
				        pstat.setString(3, Sub.getText());
				        pstat.setString(4, Gmail.getText());
				        pstat.setString(5, Phn.getText());
				        
					pstat.executeUpdate();
					JOptionPane.showMessageDialog(null, "Tutor added");
					con.close();
				} catch (Exception e1) {
					e1.printStackTrace();
					
				}
			}
		});
		btnSubmit.setForeground(Color.BLACK);
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSubmit.setBounds(171, 261, 114, 37);
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
		btnBack.setBounds(27, 261, 114, 37);
		contentPane.add(btnBack);
		setVisible(true);
	}
	
}
