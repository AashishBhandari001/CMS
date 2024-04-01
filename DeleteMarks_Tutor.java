package CourseManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class DeleteMarks_Tutor extends JFrame {

	private JPanel contentPane;
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
					DeleteMarks_Tutor frame = new DeleteMarks_Tutor();
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
	public DeleteMarks_Tutor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 548);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 253, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModuleName_1 = new JLabel("Delete Marks");
		lblModuleName_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblModuleName_1.setBounds(163, 23, 165, 26);
		contentPane.add(lblModuleName_1);
		
		JLabel lblStudentid = new JLabel("Student_Id");
		lblStudentid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStudentid.setBounds(10, 264, 138, 20);
		contentPane.add(lblStudentid);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFirstName.setBounds(10, 295, 101, 20);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastName.setBounds(10, 326, 101, 20);
		contentPane.add(lblLastName);
		
		JLabel lblModulename = new JLabel("ModuleName");
		lblModulename.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModulename.setBounds(10, 357, 101, 20);
		contentPane.add(lblModulename);
		
		stid = new JTextField();
		stid.setColumns(10);
		stid.setBounds(121, 266, 151, 20);
		contentPane.add(stid);
		
		fn = new JTextField();
		fn.setColumns(10);
		fn.setBounds(121, 297, 151, 20);
		contentPane.add(fn);
		
		ln = new JTextField();
		ln.setColumns(10);
		ln.setBounds(122, 328, 151, 20);
		contentPane.add(ln);
		
		modulename = new JTextField();
		modulename.setColumns(10);
		modulename.setBounds(122, 359, 151, 20);
		contentPane.add(modulename);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
					
					//creating a statement
					String query = "DELETE FROM result SET Student_ID=?, First_Name=?, Last_Name=?, Module_Name=?, Level=?, Semester=?, marks=?";
				        PreparedStatement pstat =  (PreparedStatement) con.prepareStatement(query);
				        pstat.setString(1, stid.getText());
				        pstat.setString(2, fn.getText());
				        pstat.setString(3, ln.getText());
				        pstat.setString(4, modulename.getText());
				        pstat.setString(5, level.getText());
				        pstat.setString(6, sem.getText());
				        pstat.setString(7, marks.getText());

					pstat.executeUpdate();
					JOptionPane.showMessageDialog(null, "Deleted");
					con.close();
				} catch (Exception e1) {
					e1.printStackTrace();
					
				}
			}
		});
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDelete.setBounds(214, 407, 114, 37);
		contentPane.add(btnDelete);
		
		JLabel lblLevel = new JLabel("Level");
		lblLevel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLevel.setBounds(309, 280, 101, 20);
		contentPane.add(lblLevel);
		
		level = new JTextField();
		level.setColumns(10);
		level.setBounds(383, 282, 151, 20);
		contentPane.add(level);
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSemester.setBounds(309, 311, 118, 20);
		contentPane.add(lblSemester);
		
		sem = new JTextField();
		sem.setColumns(10);
		sem.setBounds(383, 313, 151, 20);
		contentPane.add(sem);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new MarkInsert_Tutor();
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBounds(47, 463, 94, 37);
		contentPane.add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 64, 514, 189);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Student Id", "First Name", "Last Name", "Module Name", "Level", "Semester", "Marks"
			}
		));
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
		scrollPane.setViewportView(table);
		
		JLabel lblMarks = new JLabel("Marks");
		lblMarks.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMarks.setBounds(309, 344, 118, 20);
		contentPane.add(lblMarks);
		
		marks = new JTextField();
		marks.setColumns(10);
		marks.setBounds(383, 346, 151, 20);
		contentPane.add(marks);
		
		setVisible(true);
	}

}
