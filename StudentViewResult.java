package CourseManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class StudentViewResult extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ArrayList<Integer> mark ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public StudentViewResult(String username) {
		// TODO Auto-generated constructor stub
		initilize(username);
	}
	


	/**
	 * Create the frame.
	 */
	public void initilize(String username) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 576, 624);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGradeSheet = new JLabel("Grade Sheet");
		lblGradeSheet.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblGradeSheet.setBounds(201, 139, 145, 41);
		contentPane.add(lblGradeSheet);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(StudentViewResult.class.getResource("/CourseManagementSystem/Image/Hck.jpg")));
		lblNewLabel.setBounds(10, 11, 267, 105);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(StudentViewResult.class.getResource("/CourseManagementSystem/Image/Wlv.jpg")));
		lblNewLabel_1.setBounds(287, 11, 267, 105);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblModuleName_1 = new JLabel("Student Name");
		lblModuleName_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModuleName_1.setBounds(25, 207, 101, 20);
		contentPane.add(lblModuleName_1);
		
		JLabel lblModuleName_1_1 = new JLabel("Student ID");
		lblModuleName_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModuleName_1_1.setBounds(297, 205, 114, 20);
		contentPane.add(lblModuleName_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 270, 527, 175);
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
		lblModuleName_1_2.setBounds(25, 494, 70, 20);
		contentPane.add(lblModuleName_1_2);
		
		JLabel lblModuleName_1_2_2 = new JLabel("Grade");
		lblModuleName_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModuleName_1_2_2.setBounds(339, 494, 70, 20);
		contentPane.add(lblModuleName_1_2_2);
		
		JLabel lblModuleName_1_2_1 = new JLabel("Percentage");
		lblModuleName_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModuleName_1_2_1.setBounds(339, 525, 86, 20);
		contentPane.add(lblModuleName_1_2_1);
		
		JLabel stdname = new JLabel("");
		stdname.setBounds(136, 210, 135, 17);
		contentPane.add(stdname);
		
		JLabel stdid = new JLabel("");
		stdid.setBounds(390, 207, 101, 17);
		contentPane.add(stdid);
		
		JLabel total = new JLabel("");
		total.setBounds(79, 498, 101, 19);
		contentPane.add(total);
		
		JLabel grade1 = new JLabel("");
		grade1.setBounds(406, 496, 101, 19);
		contentPane.add(grade1);
		
		JLabel total1 = new JLabel("");
		total1.setBounds(89, 494, 101, 22);
		contentPane.add(total1);
		
		JLabel stdname_1_1 = new JLabel("");
		stdname_1_1.setBounds(419, 494, 101, 22);
		contentPane.add(stdname_1_1);
		
		JLabel percentage1 = new JLabel("");
		percentage1.setBounds(422, 527, 101, 22);
		contentPane.add(percentage1);
		
		System.out.println(username);
		mark = new ArrayList<>();
		try{
	    	Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
		        
		        String qry = "SELECT Student_ID, First_Name, Last_Name, "
		        		+ "Module_Name, Level, Semester, Marks, grade FROM result WHERE First_Name = ?";
		        PreparedStatement pstat = con.prepareStatement(qry);
		        pstat.setString(1, username);
		        ResultSet rs = pstat.executeQuery();
		        
		        if(rs.next()) {
		        	
		        	stdname.setText(rs.getString("First_Name")+" "+rs.getString("Last_Name"));
		        	stdid.setText(rs.getString("Student_ID"));
		        	
		        	 String qry1 = "SELECT Module_Name, Level, Semester, Marks, grade FROM result WHERE First_Name = ?";
				        PreparedStatement pstat1 = con.prepareStatement(qry1);
				        pstat1.setString(1, username);
				        ResultSet rs1 = pstat1.executeQuery();
		        	
		        	
		        	 DefaultTableModel model = (DefaultTableModel)table.getModel();
				        
				        while(rs1.next()) {
				        	String Module_Name = rs1.getString("Module_Name");
				        	String Level = rs1.getString("Level");
				        	String Semester = rs1.getString("Semester");
				        	String Marks = rs1.getString("Marks");
				        	String grade3 = rs1.getString("grade");
				        	
				        	String[] row = {Module_Name,Level,Semester,Marks,grade3};
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
            	float total2 = count *100; 
            	float percentage = (totalmarks)/(total2) *100 ; //caculate the percentage
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
		setVisible(true);
	}

	
}
