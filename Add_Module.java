package CourseManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class Add_Module extends JFrame {

	private JPanel contentPane;
	private JTextField mcode;
	private JTextField modulename;
	private JTextField lecturer;
	private JTextField year;
	private JTextField semester;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Module frame = new Add_Module();
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
	public Add_Module() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 373);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 226, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddModules = new JLabel("Add modules");
		lblAddModules.setBounds(174, 33, 143, 20);
		lblAddModules.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblAddModules);
		
		JLabel lblModuleName = new JLabel("Module Code");
		lblModuleName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModuleName.setBounds(10, 79, 114, 20);
		contentPane.add(lblModuleName);
		
		mcode = new JTextField();
		mcode.setColumns(10);
		mcode.setBounds(10, 110, 96, 20);
		contentPane.add(mcode);
		
		JLabel lblModuleName_1 = new JLabel("Module Name");
		lblModuleName_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModuleName_1.setBounds(166, 84, 114, 20);
		contentPane.add(lblModuleName_1);
		
		modulename = new JTextField();
		modulename.setColumns(10);
		modulename.setBounds(166, 110, 96, 20);
		contentPane.add(modulename);
		
		JLabel lblModuleName_1_2 = new JLabel("Lecturer");
		lblModuleName_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModuleName_1_2.setBounds(332, 84, 114, 20);
		contentPane.add(lblModuleName_1_2);
		
		lecturer = new JTextField();
		lecturer.setColumns(10);
		lecturer.setBounds(330, 110, 96, 20);
		contentPane.add(lecturer);
		
		JLabel lblModuleName_1_1 = new JLabel("Year");
		lblModuleName_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModuleName_1_1.setBounds(116, 152, 53, 20);
		contentPane.add(lblModuleName_1_1);
		
		JLabel lblModuleName_1_1_1 = new JLabel("Semester");
		lblModuleName_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModuleName_1_1_1.setBounds(211, 152, 76, 20);
		contentPane.add(lblModuleName_1_1_1);
		
		// Connected to the databases in the table name modules 
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
					
					//creating a statement to insert the data (? is used to pass the parameters)
					String query = "INSERT INTO modules(Module_Code, Module_Name, Lecturer, year, Semester) VALUES(?,?,?,?,?)";
				        PreparedStatement pstat =  (PreparedStatement) con.prepareStatement(query);
				        pstat.setString(1, mcode.getText());
				        pstat.setString(2, modulename.getText());
				        pstat.setString(3, lecturer.getText());
				        pstat.setString(4, year.getText());
				        pstat.setString(5, semester.getText());
					pstat.executeUpdate();
					System.out.println("Table created");
					JOptionPane.showMessageDialog(null, "Module added");
					con.close();
				} catch (Exception e1) {
					e1.printStackTrace();
					
				}
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdd.setBounds(151, 227, 96, 37);
		contentPane.add(btnAdd);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Current_Module();
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBounds(28, 273, 96, 37);
		contentPane.add(btnBack);
		
		year = new JTextField();
		year.setColumns(10);
		year.setBounds(101, 183, 69, 20);
		contentPane.add(year);
		
		semester = new JTextField();
		semester.setColumns(10);
		semester.setBounds(211, 183, 69, 20);
		contentPane.add(semester);
		setVisible(true);
	}
}
