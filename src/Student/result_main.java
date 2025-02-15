package Student;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import start.homepage;

import java.sql.*;
import java.awt.event.*;
@SuppressWarnings("serial")
public class result_main extends JFrame {
	public JPanel contentPane;
	public JButton back,genres;
	public JLabel header,lblNewLabel_1;
	public JTextField codetf;
	public JTable table;
	public JScrollPane scrollPane;
	public DefaultTableModel dm;
	public static String rc,c1,n1,m1,q1;
	public static Time s1,f1,du1;
	public static Date d1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					result_main frame = new result_main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public result_main () {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Omkar Kadam\\Desktop\\New folder\\icons8-test-passed-96.png"));
		setTitle("Result main student");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1150, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		back = new JButton("");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		back.setBorder(null);
		back.setFocusable(false);
		back.setBackground(new Color(240, 248, 255));
		back.setIcon(new ImageIcon("C:\\Users\\Omkar Kadam\\Desktop\\New folder\\Back.png"));
		back.setBounds(10, 11, 75, 64);
		contentPane.add(back);
		
		header = new JLabel("RESULTS");
		header.setOpaque(true);
		header.setBackground(new Color(0, 0, 128));
		header.setForeground(new Color(255, 255, 255));
		header.setFont(new Font("Segoe UI", Font.BOLD, 35));
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setBounds(95, 11, 159, 64);
		contentPane.add(header);
		
		genres = new JButton("Generate Result ");
		genres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rc = codetf.getText();
				result_student gr = new result_student();
				gr.setVisible(true);
			}
		});
		genres.setFont(new Font("Bookman Old Style", Font.BOLD, 25));
		genres.setForeground(new Color(255, 255, 255));
		genres.setBorder(null);
		genres.setBackground(new Color(221, 160, 221));
		genres.setBounds(10, 89, 244, 43);
		contentPane.add(genres);
		
		codetf = new JTextField();
		codetf.setBounds(264, 89, 164, 43);
		contentPane.add(codetf);
		codetf.setColumns(10);
		
		lblNewLabel_1 = new JLabel("(Exam Code)");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(438, 89, 80, 43);
		contentPane.add(lblNewLabel_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 153, 1116, 399);
		contentPane.add(scrollPane);
		String[] col = {"Code:","Name:","Date:","From:","To:","Duration","Marks:","Questions:"};
		dm = new DefaultTableModel(col,0) {
			public boolean isCellEditable(int i, int j) {
				return false;
		}
		};
		table = new JTable(dm);
		table.setBackground(new Color(240, 255, 255));
		table.getTableHeader().setBackground(new Color(0,0,128));
		table.getTableHeader().setForeground(new Color(255, 255, 255));
		table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
		table.getTableHeader().setResizingAllowed(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(275);
		table.getColumnModel().getColumn(2).setPreferredWidth(70);
		table.getColumnModel().getColumn(3).setPreferredWidth(60);
		table.getColumnModel().getColumn(4).setPreferredWidth(60);
		table.getColumnModel().getColumn(5).setPreferredWidth(60);
		table.getColumnModel().getColumn(6).setPreferredWidth(50);
		table.getColumnModel().getColumn(7).setPreferredWidth(70);
		table.setShowVerticalLines(false);
		table.setFocusable(false);
		table.setFont(new Font("Segoe UI", Font.BOLD, 15));
		table.setRowHeight(50);
		table.setRowSelectionAllowed(true);
		scrollPane.setViewportView(table);
		
		String jbdcURL = "jdbc:postgresql://localhost:5432/EMS";
	    String username = "postgres";
	    String password = "Oskadam7002";
		 try {
			 Connection connection = DriverManager.getConnection(jbdcURL,username,password);
		String sql2 = "SELECT code,name,date,start,finish,dur,marks,ques FROM exams WHERE status = '2'";
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
			 String sql3 = "SELECT Studentun FROM "+c1+"results ";
				PreparedStatement statement3 = connection.prepareStatement(sql3);
				ResultSet rs3 = statement3.executeQuery();
				while(rs3.next()) {
					String uns = rs3.getString("Studentun");
					if(uns.equals(homepage.us)) {
			dm.addRow(new Object[] {c1,n1,d1,s1,f1,du1,m1,q1});	
					}
				}
			}
		connection.close();
	 }
	 catch (SQLException e1) {
		 e1.printStackTrace();
	 }
	}
}
