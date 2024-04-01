package CourseManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Requirements extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Requirements frame = new Requirements();
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
	public Requirements() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 389);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(251, 225, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Entry Reguirements");
		lblNewLabel.setBackground(new Color(0, 255, 64));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 11, 164, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Completion of NEB +2 Qualification with an aggregate \u2265 55% or 2.2/4");
		lblNewLabel_1.setBounds(10, 81, 416, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("For IGCSE A-levels, 3 'A' Level Passes with minimum grades D and above");
		lblNewLabel_1_1.setBounds(10, 106, 416, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("SEE Mathematics Marks \u2265 50% or Grade \u2265 C+");
		lblNewLabel_1_1_1.setBounds(10, 131, 416, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblAcademicLevel = new JLabel("Academic Level");
		lblAcademicLevel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAcademicLevel.setBackground(new Color(0, 255, 64));
		lblAcademicLevel.setBounds(10, 40, 164, 31);
		contentPane.add(lblAcademicLevel);
		
		JLabel lblEnglishProficiency = new JLabel("English Proficiency");
		lblEnglishProficiency.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEnglishProficiency.setBackground(new Color(0, 255, 64));
		lblEnglishProficiency.setBounds(10, 153, 164, 31);
		contentPane.add(lblEnglishProficiency);
		
		JLabel lblNewLabel_1_2 = new JLabel("English NEB XII marks \u2265 50% or Grade \u2265 C+ or GPA \u2265 2.4/4");
		lblNewLabel_1_2.setBounds(10, 184, 416, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Completion of NEB +2 Qualification with an aggregate \u2265 55% or 2.2/4");
		lblNewLabel_1_3.setBounds(10, 209, 416, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("For IGCSE A-levels, Pass in General Paper or English with Grade E above at A or AS Levels");
		lblNewLabel_1_4.setBounds(10, 234, 416, 14);
		contentPane.add(lblNewLabel_1_4);
		setVisible(true);
	}

}
