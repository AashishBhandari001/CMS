package CourseManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Student_MarkSheet extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField search; 
	private ArrayList<Integer> mark ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_MarkSheet frame = new Student_MarkSheet();
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
	public Student_MarkSheet() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 642);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Student_MarkSheet.class.getResource("/CourseManagementSystem/Image/Wlv.jpg")));
		lblNewLabel.setBounds(335, 20, 279, 99);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Student_MarkSheet.class.getResource("/CourseManagementSystem/Image/Hck.jpg")));
		lblNewLabel_1.setBounds(10, 21, 315, 96);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblGradeSheet = new JLabel("Grade Sheet");
		lblGradeSheet.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblGradeSheet.setBounds(238, 130, 177, 41);
		contentPane.add(lblGradeSheet);
		
		JLabel lblModuleName_1 = new JLabel("Student Name");
		lblModuleName_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModuleName_1.setBounds(36, 247, 101, 20);
		contentPane.add(lblModuleName_1);
		
		JLabel lblModuleName_1_1 = new JLabel("Student ID");
		lblModuleName_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModuleName_1_1.setBounds(330, 248, 114, 20);
		contentPane.add(lblModuleName_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 311, 571, 176);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Module Name", "Level", "Semester", "Marks", "Grade"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblModuleName_1_2 = new JLabel("Total");
		lblModuleName_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModuleName_1_2.setBounds(55, 507, 70, 20);
		contentPane.add(lblModuleName_1_2);
		
		JLabel lblModuleName_1_2_1 = new JLabel("Percentage");
		lblModuleName_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModuleName_1_2_1.setBounds(369, 557, 86, 20);
		contentPane.add(lblModuleName_1_2_1);
		
		JLabel lblModuleName_1_2_2 = new JLabel("Grade");
		lblModuleName_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModuleName_1_2_2.setBounds(369, 507, 70, 20);
		contentPane.add(lblModuleName_1_2_2);
		
		search = new JTextField();
		search.setBounds(139, 178, 164, 38);
		contentPane.add(search);
		search.setColumns(10);
		
		
		JLabel stdname = new JLabel("");
		stdname.setBounds(149, 247, 156, 19);
		contentPane.add(stdname);
		
		JLabel stdid = new JLabel("");
		stdid.setBounds(435, 248, 130, 19);
		contentPane.add(stdid);
		
		JLabel total = new JLabel("");
		total.setBounds(108, 508, 130, 20);
		contentPane.add(total);
		
		JLabel grade1 = new JLabel("");
		grade1.setBounds(436, 507, 114, 20);
		contentPane.add(grade1);
		
		JLabel percentage1 = new JLabel("");
		percentage1.setBounds(465, 559, 114, 20);
		contentPane.add(percentage1);
		
		//---------------------------------------------------------------------
		JButton searchbtn = new JButton("Search");
		searchbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mark = new ArrayList<>();
				try{
			    	Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
				        
				        String qry = "SELECT Student_ID, First_Name, Last_Name, "
				        		+ "Module_Name, Level, Semester, Marks, grade FROM result WHERE Student_ID = ?";
				        PreparedStatement pstat = con.prepareStatement(qry);
				        pstat.setString(1, search.getText());
				        ResultSet rs = pstat.executeQuery();
				        
				        if(rs.next()) {
				        	
				        	stdname.setText(rs.getString("First_Name")+" "+rs.getString("Last_Name"));
				        	stdid.setText(rs.getString("Student_ID"));
				        	
				        	 String qry1 = "SELECT Module_Name, Level, Semester, Marks, grade FROM result WHERE Student_ID = ?";
						        PreparedStatement pstat1 = con.prepareStatement(qry1);
						        pstat1.setString(1, stdid.getText());
						        ResultSet rs1 = pstat1.executeQuery();
				        	
				        	
				        	 DefaultTableModel model = (DefaultTableModel)table.getModel();
						        
						        while(rs1.next()) {
						        	String Module_Name = rs1.getString("Module_Name");
						        	String Level = rs1.getString("Level");
						        	String Semester = rs1.getString("Semester");
						        	String Marks = rs1.getString("Marks");
						        	String grade = rs1.getString("grade");
						        	
						        	String[] row = {Module_Name,Level,Semester,Marks,grade};
						        	model.addRow(row);
						        	
						        	mark.add(rs1.getInt("Marks"));
						        	
						        }
				        	
				        }
				        
				        System.out.println(mark);
				        java.util.Iterator<Integer> m = mark.iterator();
			            int count = 0; //initializing count
			            float totalmarks = 0;
			            while ( m.hasNext()) {
			                Integer con1 = (Integer) m.next();
			                totalmarks = totalmarks + con1; //to caculated the total marks
			                count++;     // count the total number of module count to calculate the percenatge
			            }
				       
			            mark.clear();
			            
			            total.setText(String.valueOf(Math.round(totalmarks)));
		            	float total = count *100; 
		            	float percentage = (totalmarks)/(total) *100 ; //caculate the percentage
		            	percentage1.setText(String.valueOf(Math.round(percentage))+"%");
		            	
		            	String Grade ="";
			            
			            if (percentage >= 70) {
			                Grade = "First-Class Honours";
			               
			            } else if (percentage >= 60) {
			                Grade = "Upper Second-Class Honours";
			               
			            } else if (percentage >= 50) {
			                Grade = "Lower Second-Class Honours";
			               
			            } else if (percentage >= 40) {
			                Grade = "Third Class Honours";
			               
			            } else {
			                Grade = "Fail";
			               
			            }
				        
			            grade1.setText(Grade);
				        pstat.close();
				        con.close();
			    }catch (Exception exp){
			        System.out.println(exp);
			    }
			}
		});
		searchbtn.setBounds(36, 179, 89, 30);
		contentPane.add(searchbtn);
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
}
