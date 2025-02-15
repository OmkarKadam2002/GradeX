package Student;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class exams_student extends JFrame {

	public JPanel contentPane,activepanel;
	public JButton back,active,over,taketest;
	public JLabel title,tc,today;
	public JTextField taketesttf;
	public JTable t1;
	public JScrollPane sp1;
	public DefaultTableModel dm1;
	public JTabbedPane maincontainer;
	public static LocalDate date;
	public static String ac;
	public static int b1,c1,d1;
	public static Time a1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					exams_student frame = new exams_student();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	@SuppressWarnings({ "unused" })
	public exams_student() {
		date = LocalDate.now();
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Omkar Kadam\\Desktop\\New folder\\icons8-test-passed-96.png"));
		setTitle("Student Exam");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1150, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		back = new JButton("\r\n");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		back.setIcon(new ImageIcon("C:\\Users\\Omkar Kadam\\Desktop\\New folder\\Back.png"));
		back.setFocusable(false);
		back.setBorder(null);
		back.setBackground(new Color(240, 248, 255));
		back.setBounds(10, 11, 89, 74);
		contentPane.add(back);
		
		title = new JLabel("EXAMS");
		title.setOpaque(true);
		title.setFont(new Font("Segoe UI", Font.BOLD, 30));
		title.setForeground(new Color(255, 255, 255));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBorder(null);
		title.setBackground(new Color(0, 0, 128));
		title.setBounds(109, 11, 156, 74);
		contentPane.add(title);
		
		active = new JButton(" Active          ");
		active.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maincontainer.setSelectedIndex(0);
			}
		});
		active.setHorizontalTextPosition(SwingConstants.CENTER);
		active.setFocusable(false);
		active.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		active.setBackground(new Color(0,0,128));
		active.setFont(new Font("Segoe UI", Font.BOLD|Font.ITALIC, 25));
		active.setForeground(new Color(255, 255, 255));
		active.setBounds(10, 96, 1116, 49);
		contentPane.add(active);
		
		
		
		maincontainer = new JTabbedPane(JTabbedPane.TOP);
		maincontainer.setBorder(null);
		maincontainer.setBounds(10, 96, 1116, 456);
		contentPane.add(maincontainer);
		
		activepanel = new JPanel();
		activepanel.setBorder(null);
		activepanel.setBackground(new Color(240, 248, 255));
		maincontainer.addTab("New tab", null, activepanel, null);
		activepanel.setLayout(null);
		
		taketest = new JButton("Take Test ");
		taketest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ac = taketesttf.getText();
				String jbdcURL = "jdbc:postgresql://localhost:5432/EMS";
				String username = "postgres";
				String password = "Oskadam7002";
				try {
					Connection connection = DriverManager.getConnection(jbdcURL,username,password);
					String sql = "SELECT dur,marks,ques FROM exams WHERE code = '"+ac+"'";
					PreparedStatement statement = connection.prepareStatement(sql);
					ResultSet rs = statement.executeQuery();
					while(rs.next()) {
						a1 = rs.getTime("dur");
						b1 = Integer.valueOf(rs.getString("marks"));
						c1 = Integer.valueOf(rs.getString("ques"));
						d1 = b1/c1;
					}
				}
				catch (SQLException e3) {
					e3.printStackTrace();
				}
				instructions i = new instructions();
				i.setVisible(true);
			}
		});
		taketest.setBorder(null);
		taketest.setBackground(new Color(0, 255, 127));
		taketest.setFocusable(false);
		taketest.setFont(new Font("Bookman Old Style", Font.BOLD, 25));
		taketest.setForeground(new Color(0, 0, 0));
		taketest.setBounds(10, 33, 139, 31);
		activepanel.add(taketest);
		
		taketesttf = new JTextField();
		taketesttf.setBounds(159, 33, 156, 31);
		activepanel.add(taketesttf);
		taketesttf.setColumns(10);
		
		tc = new JLabel("(Test Code)");
		tc.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		tc.setHorizontalAlignment(SwingConstants.CENTER);
		tc.setBounds(325, 30, 96, 34);
		activepanel.add(tc);
		
		sp1 = new JScrollPane();
		sp1.setBounds(5, 112, 1116, 305);
		activepanel.add(sp1);
		String[] col1 = {"Code:","Name:","Date:","From:","To:","Duration","Marks:","Questions:"};
		dm1 = new DefaultTableModel(col1,0) {
			public boolean isCellEditable(int i, int j) {
				return false;
				}
		};
		t1 = new JTable(dm1);
		sp1.setViewportView(t1);
		t1.getTableHeader().setBackground(new Color(0,0,128));
		t1.getTableHeader().setForeground(new Color(255, 255, 255));
		t1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
		t1.getTableHeader().setResizingAllowed(false);
		t1.getTableHeader().setReorderingAllowed(false);
		t1.getColumnModel().getColumn(0).setPreferredWidth(50);
		t1.getColumnModel().getColumn(1).setPreferredWidth(275);
		t1.getColumnModel().getColumn(2).setPreferredWidth(70);
		t1.getColumnModel().getColumn(3).setPreferredWidth(60);
		t1.getColumnModel().getColumn(4).setPreferredWidth(60);
		t1.getColumnModel().getColumn(5).setPreferredWidth(60);
		t1.getColumnModel().getColumn(6).setPreferredWidth(50);
		t1.getColumnModel().getColumn(7).setPreferredWidth(70);
		t1.setShowVerticalLines(false);
		t1.setFocusable(false);
		t1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		t1.setRowHeight(50);
		t1.setBackground(new Color(240, 255, 255));
		t1.setRowSelectionAllowed(true);
		
		
		today = new JLabel(" Today : ");
		today.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 20));
		today.setHorizontalAlignment(SwingConstants.CENTER);
		today.setBounds(10, 76, 104, 25);
		activepanel.add(today);
		
		String jbdcURL = "jdbc:postgresql://localhost:5432/EMS";
	     String username = "postgres";
	     String password = "Oskadam7002";
		 try {
			 Connection connection = DriverManager.getConnection(jbdcURL,username,password);
			 String sql = "SELECT code,name,date,start,finish,dur,marks,ques,status FROM exams WHERE status = '1'";
			 PreparedStatement statement = connection.prepareStatement(sql);
			 ResultSet rs = statement.executeQuery();
			 while(rs.next()) {
				    String c1 = rs.getString("code");
					String n1 = rs.getString("name");
					Date d1 = rs.getDate("date");
					Time s1 = rs.getTime("start");
					Time f1 = rs.getTime("finish");
					Time du1 = rs.getTime("dur");
					String m1 = rs.getString("marks");
					String q1 = rs.getString("ques");
					String status = rs.getString("status");
						dm1.addRow(new Object[] {c1,n1,d1,s1,f1,du1,m1,q1});
			 }
			 connection.close();
		 }
		 catch(SQLException e) {
			 e.printStackTrace();
		 }
		
	}
}
