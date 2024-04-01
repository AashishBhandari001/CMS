package CourseManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class MarkInsert_Tutor extends JFrame {

	private JPanel contentPane;
	private JTable Std;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MarkInsert_Tutor frame = new MarkInsert_Tutor();
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
	public MarkInsert_Tutor() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 529, 382);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 253, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModuleName_1 = new JLabel("Insert Marks");
		lblModuleName_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblModuleName_1.setBounds(195, 51, 163, 20);
		contentPane.add(lblModuleName_1);
		
		JButton btnSubmit = new JButton("Add");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new AddMarks_Instructor();
				
			}
		});
		btnSubmit.setForeground(Color.BLACK);
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSubmit.setBounds(25, 141, 114, 37);
		contentPane.add(btnSubmit);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new EditMarks_Instructor();
			}
		});
		btnEdit.setForeground(Color.BLACK);
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEdit.setBounds(25, 189, 114, 37);
		contentPane.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new DeleteMarks_Tutor();
			}
		});
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDelete.setBounds(25, 237, 114, 37);
		contentPane.add(btnDelete);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Instructor_Dashboard();
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBounds(25, 285, 114, 37);
		contentPane.add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(152, 146, 342, 163);
		contentPane.add(scrollPane);
		
		
		Std = new JTable();
		Std.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"First Name", "Last Name", "Student Id", "Level","Semester", "Gmail" 
				}
			));
		try{
	    	Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
		        
		        String qry = "SELECT First_Name, Last_Name, Student_ID, Level, Semester, Gmail FROM student_details";
	//"select ID, module_code, module_name,level, semester, optional from course where course_name = ? and level = ?";
		        
		        Statement pstat = con.createStatement();
		        
		        ResultSet rs = pstat.executeQuery(qry);
		        
		        DefaultTableModel model = (DefaultTableModel)Std.getModel();
		        
		        while(rs.next()) {
		        	String First_Name = rs.getString("First_Name");
		        	String Last_Name = rs.getString("Last_Name");
		        	String Student_ID = rs.getString("Student_ID");
		        	String Level = rs.getString("Level");
		        	String Semester = rs.getString("Semester");
		        	String Gmail = rs.getString("Gmail");

		        	String[] row = {First_Name,Last_Name,Student_ID,Level,Semester,Gmail};
		        	model.addRow(row);
		        	
		        }

		        
		        pstat.close();
		        con.close();
	    }catch (Exception exp){
	        System.out.println(exp);
	    }
			
		
		
		scrollPane.setViewportView(Std);
		
		JLabel lblModuleName_1_3_1 = new JLabel("Student Details");
		lblModuleName_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModuleName_1_3_1.setBounds(261, 115, 114, 20);
		contentPane.add(lblModuleName_1_3_1);
		setVisible(true);
		
	}

}
