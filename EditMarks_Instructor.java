package CourseManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextPane;

public class EditMarks_Instructor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField stid;
	private JTextField fn;
	private JTextField ln;
	private JTextField modulename;
	private JTextField level;
	private JTextField sem;
	private JTable table;
	private JTextField marks;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditMarks_Instructor frame = new EditMarks_Instructor();
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
	public EditMarks_Instructor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 527);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 253, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setBounds(217, 10, 1, 1);
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(new Color(230, 253, 225));
		contentPane.add(contentPane_1);
		
		JLabel lblModuleName_1 = new JLabel("Insert Marks");
		lblModuleName_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblModuleName_1.setBounds(163, 24, 135, 26);
		contentPane_1.add(lblModuleName_1);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFirstName.setBounds(10, 296, 101, 20);
		contentPane_1.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastName.setBounds(10, 327, 101, 20);
		contentPane_1.add(lblLastName);
		
		JLabel lblStudentid = new JLabel("Student_Id");
		lblStudentid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStudentid.setBounds(10, 265, 138, 20);
		contentPane_1.add(lblStudentid);
		
		JLabel lblLevel = new JLabel("Level");
		lblLevel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLevel.setBounds(309, 281, 101, 20);
		contentPane_1.add(lblLevel);
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSemester.setBounds(309, 312, 118, 20);
		contentPane_1.add(lblSemester);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(121, 267, 151, 20);
		contentPane_1.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(121, 298, 151, 20);
		contentPane_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(122, 329, 151, 20);
		contentPane_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(383, 283, 151, 20);
		contentPane_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(383, 314, 151, 20);
		contentPane_1.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(122, 360, 151, 20);
		contentPane_1.add(textField_5);
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBounds(47, 464, 94, 37);
		contentPane_1.add(btnBack);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.setForeground(Color.BLACK);
		btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnInsert.setBounds(214, 408, 114, 37);
		contentPane_1.add(btnInsert);
		
		JLabel lblModulename = new JLabel("ModuleName");
		lblModulename.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModulename.setBounds(10, 358, 101, 20);
		contentPane_1.add(lblModulename);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 80, 513, 164);
		contentPane_1.add(scrollPane);
		
		JLabel lblModuleName_1_1 = new JLabel("Edit Marks");
		lblModuleName_1_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblModuleName_1_1.setBounds(228, 21, 135, 26);
		contentPane.add(lblModuleName_1_1);
		
		JLabel lblStudentid_1 = new JLabel("Student_Id");
		lblStudentid_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStudentid_1.setBounds(29, 236, 138, 20);
		contentPane.add(lblStudentid_1);
		
		stid = new JTextField();
		stid.setColumns(10);
		stid.setBounds(140, 238, 151, 20);
		contentPane.add(stid);
		
		JLabel lblFirstName_1 = new JLabel("First Name");
		lblFirstName_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFirstName_1.setBounds(29, 267, 101, 20);
		contentPane.add(lblFirstName_1);
		
		fn = new JTextField();
		fn.setColumns(10);
		fn.setBounds(140, 269, 151, 20);
		contentPane.add(fn);
		
		JLabel lblLastName_1 = new JLabel("Last Name");
		lblLastName_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastName_1.setBounds(29, 298, 101, 20);
		contentPane.add(lblLastName_1);
		
		ln = new JTextField();
		ln.setColumns(10);
		ln.setBounds(141, 300, 151, 20);
		contentPane.add(ln);
		
		JLabel lblModulename_1 = new JLabel("ModuleName");
		lblModulename_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModulename_1.setBounds(29, 329, 101, 20);
		contentPane.add(lblModulename_1);
		
		modulename = new JTextField();
		modulename.setColumns(10);
		modulename.setBounds(141, 331, 151, 20);
		contentPane.add(modulename);
		
		JLabel lblLevel_1 = new JLabel("Level");
		lblLevel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLevel_1.setBounds(328, 252, 101, 20);
		contentPane.add(lblLevel_1);
		
		level = new JTextField();
		level.setColumns(10);
		level.setBounds(402, 254, 151, 20);
		contentPane.add(level);
		
		JLabel lblSemester_1 = new JLabel("Semester");
		lblSemester_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSemester_1.setBounds(328, 283, 118, 20);
		contentPane.add(lblSemester_1);
		
		sem = new JTextField();
		sem.setColumns(10);
		sem.setBounds(402, 285, 151, 20);
		contentPane.add(sem);
		
		marks = new JTextField();
		marks.setColumns(10);
		marks.setBounds(402, 318, 151, 20);
		contentPane.add(marks);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setForeground(Color.BLACK);
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEdit.setBounds(233, 379, 114, 37);
		contentPane.add(btnEdit);
		JLabel lblSemester_1_1 = new JLabel("Marks");
		lblSemester_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSemester_1_1.setBounds(328, 316, 118, 20);
		contentPane.add(lblSemester_1_1);
		
		JButton btnBack_1 = new JButton("Back");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new MarkInsert_Tutor();
			}
		});
		
		
		btnBack_1.setForeground(Color.BLACK);
		btnBack_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack_1.setBounds(66, 435, 94, 37);
		contentPane.add(btnBack_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(29, 68, 533, 153);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Student Id", "First Name", "Last Name", "Module Name", "Level", "Semester", "Marks"
			}
		));
		
		
		scrollPane_1.setViewportView(table);
		try{
	    	Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
		        
		        String qry = "SELECT Student_ID, First_Name, Last_Name, Module_Name, Level, Semester, Marks FROM result";
	//"select ID, module_code, module_name,level, semester, optional from course where course_name = ? and level = ?";
		        
		        Statement pstat = con.createStatement();
		        
		        ResultSet rs = pstat.executeQuery(qry);
		        
		        DefaultTableModel model = (DefaultTableModel)table.getModel();
		        
		        while(rs.next()) {
		        	String Student_ID = rs.getString("Student_ID");
		        	String First_Name = rs.getString("First_Name");
		        	String Last_Name = rs.getString("Last_Name");
		        	String Module_Name = rs.getString("Module_Name");
		        	String Level = rs.getString("Level");
		        	String Semester = rs.getString("Semester");
		        	String Marks = rs.getString("Marks");
		        	
		        	String[] row = {Student_ID,First_Name,Last_Name,Module_Name,Level,Semester,Marks};
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

