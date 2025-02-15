package Student;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import start.*;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class result_student extends JFrame {

	private JPanel contentPane;
	public static String username1,totalmarks,marksobtained,totalquestions,questionsattempted,name,rollno;
	private JButton btnNewButton;
	public static int a,b;
	float c;
	public static String n,m,q;
	public static Time s,f,du;
	public static Date d;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					result_student frame = new result_student();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public result_student() {
		
		String jbdcURL = "jdbc:postgresql://localhost:5432/EMS";
	    String username = "postgres";
	    String password = "Oskadam7002";
		 try {
			 Connection connection = DriverManager.getConnection(jbdcURL,username,password);
			 String sql = "SELECT * FROM "+result_main.rc+"results WHERE Studentun = '"+homepage.us+"'";
			 PreparedStatement statement2 = connection.prepareStatement(sql);
			 ResultSet rs = statement2.executeQuery();
			 while(rs.next()) {
				 username1 = rs.getString("Studentun");
				 totalmarks = rs.getString("totalmarks");
				 marksobtained = rs.getString("marksobtained");
				 totalquestions = rs.getString("totalquestions");
				 questionsattempted = rs.getString("questionsattempted");
				 String sql2 = "SELECT _name_, rollno FROM registration WHERE username ='"+username1+"'";
					PreparedStatement statement3 = connection.prepareStatement(sql2);
					ResultSet rs2 = statement3.executeQuery();
					while(rs2.next()) {
						 name = rs2.getString("_name_");
						 rollno = rs2.getString("rollno");
					}
					String sql1 = "SELECT name,date,start,finish,dur,marks,ques FROM exams WHERE code = '"+result_main.rc+"'";
					 PreparedStatement statement4 = connection.prepareStatement(sql1);
					 ResultSet rs1 = statement4.executeQuery();
					 while(rs1.next()) {
						 n = rs1.getString("name");
						 d = rs1.getDate("date");
						 s = rs1.getTime("start");
						 f = rs1.getTime("finish");
						 du = rs1.getTime("dur");
						 m = rs1.getString("marks");
						 q = rs1.getString("ques");
					 }
			 }
			 connection.close();

		 }
		 catch (SQLException e) {
			 e.printStackTrace();
		 }
		
		setTitle("Student Result");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Omkar Kadam\\Desktop\\New folder\\icons8-test-passed-96.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50,50,946, 610);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RESULT FOR TEST :  ");
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel.setBounds(219, 11, 634, 48);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Code : ");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setBounds(10, 76, 167, 39);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Date : ");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(352, 76, 167, 39);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Name : ");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(10, 126, 167, 39);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2 = new JLabel(result_main.rc);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_2.setBounds(184, 76, 167, 39);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel(String.valueOf(d));
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(529, 76, 236, 39);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel(n);
		lblNewLabel_2_2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_2_2.setBounds(184, 126, 669, 39);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Time : ");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1_2_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1_2_1.setBounds(10, 176, 167, 39);
		contentPane.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("From "+String.valueOf(s)+" to "+String.valueOf(f));
		lblNewLabel_2_2_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_2_2_1.setBounds(184, 176, 335, 39);
		contentPane.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Duration : ");
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1_2_1_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1_2_1_1.setBounds(72, 226, 105, 39);
		contentPane.add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel(String.valueOf(du));
		lblNewLabel_2_1_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_2_1_1.setBounds(184, 226, 236, 39);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("Total Questions : ");
		lblNewLabel_1_2_1_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1_2_1_2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1_2_1_2.setBounds(10, 292, 167, 39);
		contentPane.add(lblNewLabel_1_2_1_2);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel(totalquestions);
		lblNewLabel_2_2_1_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_2_2_1_1.setBounds(184, 292, 167, 39);
		contentPane.add(lblNewLabel_2_2_1_1);
		
		JLabel lblNewLabel_2_2_1_2 = new JLabel(totalmarks);
		lblNewLabel_2_2_1_2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_2_2_1_2.setBounds(541, 292, 158, 39);
		contentPane.add(lblNewLabel_2_2_1_2);
		
		JLabel lblNewLabel_1_2_1_2_1 = new JLabel("Total Marks : ");
		lblNewLabel_1_2_1_2_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1_2_1_2_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1_2_1_2_1.setBounds(361, 292, 158, 39);
		contentPane.add(lblNewLabel_1_2_1_2_1);
		
		JLabel lblNewLabel_1_2_1_2_2 = new JLabel("Attempted : ");
		lblNewLabel_1_2_1_2_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1_2_1_2_2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1_2_1_2_2.setBounds(10, 342, 167, 39);
		contentPane.add(lblNewLabel_1_2_1_2_2);
		
		JLabel lblNewLabel_2_2_1_1_1 = new JLabel(questionsattempted);
		lblNewLabel_2_2_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_2_2_1_1_1.setBounds(184, 342, 132, 39);
		contentPane.add(lblNewLabel_2_2_1_1_1);
		
		JLabel lblNewLabel_1_2_1_2_1_1 = new JLabel("Marks Obtained : ");
		lblNewLabel_1_2_1_2_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1_2_1_2_1_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1_2_1_2_1_1.setBounds(352, 342, 167, 39);
		contentPane.add(lblNewLabel_1_2_1_2_1_1);
		
		JLabel lblNewLabel_2_2_1_2_1 = new JLabel(marksobtained);
		lblNewLabel_2_2_1_2_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_2_2_1_2_1.setBounds(541, 342, 158, 39);
		contentPane.add(lblNewLabel_2_2_1_2_1);
		
		JLabel lblNewLabel_1_2_1_2_1_1_1 = new JLabel("Percentage : ");
		lblNewLabel_1_2_1_2_1_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1_2_1_2_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1_2_1_2_1_1_1.setBounds(10, 394, 167, 39);
		contentPane.add(lblNewLabel_1_2_1_2_1_1_1);
		
		a = Integer.valueOf(marksobtained);
		b = Integer.valueOf(totalmarks);
		c =(float)(a*100)/b;
		
		
		JLabel lblNewLabel_2_2_1_1_1_1 = new JLabel(c+" %");
		lblNewLabel_2_2_1_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_2_2_1_1_1_1.setBounds(184, 394, 132, 39);
		contentPane.add(lblNewLabel_2_2_1_1_1_1);
		
		JLabel lblNewLabel_1_2_1_2_1_1_1_1 = new JLabel("Status : ");
		lblNewLabel_1_2_1_2_1_1_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1_2_1_2_1_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1_2_1_2_1_1_1_1.setBounds(352, 394, 167, 39);
		contentPane.add(lblNewLabel_1_2_1_2_1_1_1_1);
		
		JLabel lblNewLabel_2_2_1_2_1_1 = new JLabel("");
		lblNewLabel_2_2_1_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_2_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2_1_2_1_1.setOpaque(true);
		lblNewLabel_2_2_1_2_1_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_2_2_1_2_1_1.setBounds(541, 394, 158, 39);
		if(c>=35) {
			lblNewLabel_2_2_1_2_1_1.setBackground(Color.GREEN);
			lblNewLabel_2_2_1_2_1_1.setText("Pass");
		}
		else {
			lblNewLabel_2_2_1_2_1_1.setBackground(Color.RED);
			lblNewLabel_2_2_1_2_1_1.setText("Fail");
		}
		contentPane.add(lblNewLabel_2_2_1_2_1_1);
		
		JLabel lblNewLabel_1_2_1_2_1_1_1_2 = new JLabel("Student Name :");
		lblNewLabel_1_2_1_2_1_1_1_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1_2_1_2_1_1_1_2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1_2_1_2_1_1_1_2.setBounds(10, 444, 167, 39);
		contentPane.add(lblNewLabel_1_2_1_2_1_1_1_2);
		
		JLabel lblNewLabel_1_2_1_2_1_1_1_1_1 = new JLabel("Roll No. :");
		lblNewLabel_1_2_1_2_1_1_1_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1_2_1_2_1_1_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1_2_1_2_1_1_1_1_1.setBounds(352, 444, 167, 39);
		contentPane.add(lblNewLabel_1_2_1_2_1_1_1_1_1);
		
		JLabel lblNewLabel_2_3 = new JLabel(name);
		lblNewLabel_2_3.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_2_3.setBounds(184, 444, 167, 39);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel(rollno);
		lblNewLabel_2_4.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_2_4.setBounds(541, 444, 167, 39);
		contentPane.add(lblNewLabel_2_4);
		
		btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(255, 69, 0));
		btnNewButton.setFocusable(false);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btnNewButton.setBounds(391, 529, 144, 33);
		contentPane.add(btnNewButton);
	}
}
