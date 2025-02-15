package teacher;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class generateresult extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTable table;
	private DefaultTableModel dm;
	public String c1,n1,m1,q1;
	public Time s1,f1,du1;
	public Date d1;
	private JButton btnNewButton;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					generateresult frame = new generateresult();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public generateresult() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Omkar Kadam\\Desktop\\New folder\\icons8-test-passed-96.png"));
		setTitle("Generate Result");
		
		String jbdcURL = "jdbc:postgresql://localhost:5432/EMS";
	    String username = "postgres";
	    String password = "Oskadam7002";
		 try {
			 Connection connection = DriverManager.getConnection(jbdcURL,username,password);
		String sql2 = "SELECT code,name,date,start,finish,dur,marks,ques FROM exams WHERE code = '"+results_teacher.rc+"'";
		PreparedStatement statement2 = connection.prepareStatement(sql2);
		ResultSet rs2 = statement2.executeQuery();
		while(rs2.next()) {
			c1 = rs2.getString("code");
			n1 = rs2.getString("name");
			 d1 = rs2.getDate("date");
			 s1 = rs2.getTime("start");
			 f1 = rs2.getTime("finish");
			 du1 = rs2.getTime("dur");
			m1 = rs2.getString("marks");
			q1 = rs2.getString("ques");
		}
		connection.close();
	 }
	 catch (SQLException e1) {
		 e1.printStackTrace();
	 }
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1150, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Report for Test : "+c1);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(326, 11, 399, 46);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(" Test Name : "+n1);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 68, 715, 46);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel(" Conducted On : "+d1);
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(735, 68, 360, 46);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel(" Time : From "+s1+" to "+f1);
		lblNewLabel_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(10, 125, 360, 46);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel(" Duration : "+du1);
		lblNewLabel_1_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1_1_1_1.setBounds(389, 125, 208, 46);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel(" Marks : "+m1);
		lblNewLabel_1_1_1_2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1_1_1_2.setBounds(607, 125, 146, 46);
		contentPane.add(lblNewLabel_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel(" Questions : "+q1);
		lblNewLabel_1_1_1_2_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1_1_1_2_1.setBounds(773, 125, 159, 46);
		contentPane.add(lblNewLabel_1_1_1_2_1);
		
		JLabel lblNewLabel_2 = new JLabel(" Results : ");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBackground(new Color(0, 0, 128));
		lblNewLabel_2.setBounds(10, 182, 102, 34);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 227, 1116, 269);
		contentPane.add(scrollPane);
		String[] col = {" Name "," Roll No. "," Marks "};
		dm = new DefaultTableModel(col,0) {
			public boolean isCellEditable(int i, int j) {
				return false;
		}
		};
		table = new JTable(dm);
		table.getTableHeader().setBackground(new Color(0,0,128));
		table.getTableHeader().setForeground(new Color(255, 255, 255));
		table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
		table.getTableHeader().setResizingAllowed(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.setShowVerticalLines(false);
		table.setFocusable(false);
		table.setFont(new Font("Segoe UI", Font.BOLD, 15));
		table.setRowHeight(50);
		table.setRowSelectionAllowed(false);
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFocusable(false);
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(255, 69, 0));
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(452, 507, 185, 45);
		contentPane.add(btnNewButton);
		 try {
			 Connection connection = DriverManager.getConnection(jbdcURL,username,password);
		String sql1 = "SELECT Studentun,marksobtained FROM "+results_teacher.rc+"results ";
		PreparedStatement statement1 = connection.prepareStatement(sql1);
		ResultSet rs1 = statement1.executeQuery();
		while(rs1.next()) {
			String us = rs1.getString("Studentun");
			String mo = rs1.getString("marksobtained");
			String sql2 = "SELECT _name_, rollno FROM registration WHERE username ='"+us+"'";
			PreparedStatement statement2 = connection.prepareStatement(sql2);
			ResultSet rs2 = statement2.executeQuery();
			while(rs2.next()) {
				String name = rs2.getString("_name_");
				String rollno = rs2.getString("rollno");
				dm.addRow(new Object[] {name,rollno,mo});
			}
		}
		connection.close();
	 }
	 catch (SQLException e1) {
		 e1.printStackTrace();
	 }

		
	}
}
