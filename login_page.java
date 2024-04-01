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
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class login_page extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private String password;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_page frame = new login_page();
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
	public login_page() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 11, 704, 443);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 0, 355, 443);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(login_page.class.getResource("/CourseManagementSystem/Image/Login.jpg")));
		lblNewLabel.setBounds(-11, 0, 356, 443);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(186, 79, 84));
		panel_2.setBounds(365, 0, 339, 443);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		username = new JTextField();
		username.setForeground(new Color(255, 255, 255));
		username.setBackground(new Color(186, 79, 84));
		username.setBounds(131, 145, 186, 28);
		panel_2.add(username);
		username.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel(" User Name");
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setBounds(20, 154, 101, 19);
		panel_2.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("password");
		lblNewLabel_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1.setBounds(20, 199, 101, 28);
		panel_2.add(lblNewLabel_1_1_1);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(186, 79, 84));
		passwordField.setForeground(new Color(255, 255, 255));
		passwordField.setBounds(131, 201, 186, 28);
		panel_2.add(passwordField);
		
		JLabel SignInpage = new JLabel("Log In ");
		SignInpage.setForeground(new Color(255, 255, 255));
		SignInpage.setBounds(131, 58, 89, 31);
		panel_2.add(SignInpage);
		SignInpage.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		// The combo box is taken in order to login from three users i.e admin, student, Instructor
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(254, 226, 249));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Student", "Instructor"}));
		comboBox.setBounds(131, 249, 186, 22);
		panel_2.add(comboBox);
		
		JButton btnNewButton = new JButton("Log In");
		btnNewButton.setBounds(115, 316, 129, 40);
		panel_2.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			/*
			 Firstly, the login button is connected with database, i have provided the login id 
			 for all third parties, this condition check from the database and if it match then only it provides
			 the user access
			 */
			
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
					
					//creating a statement
					String query = "SELECT User_Mode, User_Name, Password FROM userlogin WHERE User_Name=? and Password=? and User_Mode=?"
							+ "";
						String userType = (String) comboBox.getSelectedItem();
				        PreparedStatement pstat =  (PreparedStatement) con.prepareStatement(query);
				        pstat.setString(1, username.getText());
				        pstat.setString(2, new String(passwordField.getPassword()).strip());
				        pstat.setString(3, userType);
				        
				        ResultSet results = pstat.executeQuery();
				        
				        results.next();
				        
				        if (new String(passwordField.getPassword()).equals(results.getString("Password"))) {
				        	if (userType.equals("Student")) new Student_Dashboard(username.getText());
				        	if (userType.equals("Admin")) new Admin_DashBoard();
				        	if (userType.equals("Instructor")) new Instructor_Dashboard();
				        	dispose(); // It close the window when cross is pressed
                        }
					
					JOptionPane.showMessageDialog(null, "loged in");
					con.close();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Invalid Password or Username");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBackground(new Color(242, 238, 242));
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("User Mode");
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_1.setBounds(20, 247, 101, 28);
		panel_2.add(lblNewLabel_1_1_1_1);
		
		
		
		
		setVisible(true);
	}
}
