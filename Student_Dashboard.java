package CourseManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Student_Dashboard extends JFrame {

	private JPanel contentPane;

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

	/**
	 * Create the frame.
	 */
	public Student_Dashboard(String username) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 509);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(137, 228, 157));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToHerald = new JLabel("Welcome to Herald College Kathmandu");
		lblWelcomeToHerald.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblWelcomeToHerald.setBounds(50, 28, 384, 20);
		contentPane.add(lblWelcomeToHerald);
		
		JLabel lblNewLabel = new JLabel("Available Course");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(50, 224, 161, 34);
		contentPane.add(lblNewLabel);
		
		JButton btnBit = new JButton("BIT");
		btnBit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(true);
				new CourseChoose_Student();
			}
		});
		btnBit.setForeground(Color.BLACK);
		btnBit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBit.setBounds(241, 197, 127, 34);
		contentPane.add(btnBit);
		
		
		JButton btnIbm = new JButton("IBM");
		btnIbm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(true);
				new CourseChoose_Student();
			}
		});
		btnIbm.setForeground(Color.BLACK);
		btnIbm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnIbm.setBounds(241, 252, 127, 34);
		contentPane.add(btnIbm);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new login_page();
			}
		});
		btnLogOut.setForeground(Color.BLACK);
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogOut.setBounds(127, 405, 127, 34);
		contentPane.add(btnLogOut);
		
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(true);
				new StudentViewResult(username);
			}
		});
		btnView.setForeground(Color.BLACK);
		btnView.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnView.setBounds(241, 324, 127, 34);
		contentPane.add(btnView);
		
		JLabel lblResultSheet = new JLabel("Result Sheet");
		lblResultSheet.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblResultSheet.setBounds(50, 322, 161, 34);
		contentPane.add(lblResultSheet);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Student_Dashboard.class.getResource("/CourseManagementSystem/Image/HCKING.jpg")));
		lblNewLabel_1.setBounds(73, 59, 255, 103);
		contentPane.add(lblNewLabel_1);
		setVisible(true);
	}
}
