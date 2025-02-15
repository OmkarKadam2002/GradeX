package teacher;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import start.homepage;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class exams_main extends JFrame {

	public JPanel contentPane;
	public JLabel title;
	public JButton back, newtest, drafts, Today, Published, Ended;
	public JTabbedPane maincontainer;
	public JPanel draftspanel, today,finished;
	public JTextField deletetf,removetf,endtf,publishtf;
	public JButton publish,end,delete;
	public JLabel ec1,ec2,ec3,ec4;
	public JTable jt1,jt2,jt3,jt4;
	public DefaultTableModel dm1,dm2,dm3,dm4;
	private JScrollPane sp1,sp2,sp4;
	static LocalDate date;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					exams_main frame = new exams_main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public exams_main() {
		
		date = LocalDate.now();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Omkar Kadam\\Desktop\\New folder\\icons8-test-passed-96.png"));
		setTitle("Exam Main");
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
		back.setBounds(10, 11, 74, 63);
		back.setHorizontalAlignment(SwingConstants.CENTER);
		back.setFocusable(false);
		back.setBorder(null);
		back.setOpaque(true);
		back.setBackground(new Color(240, 248, 255));
		back.setIcon(new ImageIcon("C:\\Users\\Omkar Kadam\\Desktop\\New folder\\Back.png"));
		contentPane.add(back);
		
		title = new JLabel("EXAMS");
		title.setBounds(94, 11, 148, 63);
		title.setOpaque(true);
		title.setBackground(new Color(0, 0, 128));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Segoe UI", Font.BOLD, 30));
		title.setForeground(new Color(255, 255, 255));
		contentPane.add(title);
		
		newtest = new JButton("+ Create A Test");
		newtest.setBounds(959, 11, 167, 47);
		newtest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				create_test c = new create_test();
				c.setVisible(true);
			}
		});
		newtest.setForeground(new Color(255, 255, 255));
		newtest.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 20));
		newtest.setFocusable(false);
		newtest.setBackground(new Color(0, 0, 128));
		newtest.setBorder(null);
		contentPane.add(newtest);
		
		drafts = new JButton(" Drafts\r\n");
		drafts.setBounds(10, 85, 368, 75);
		drafts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maincontainer.setSelectedIndex(0);
			}
		});
		drafts.setHorizontalTextPosition(SwingConstants.LEADING);
		drafts.setHorizontalAlignment(SwingConstants.LEADING);
		drafts.setForeground(new Color(255, 255, 255));
		drafts.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 25));
		drafts.setFocusable(false);
		drafts.setBackground(new Color(0, 0, 128));
		drafts.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		contentPane.add(drafts);
		
		Today = new JButton(" Today");
		Today.setBounds(377, 85, 378, 75);
		Today.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maincontainer.setSelectedIndex(1);
			}
		});
		Today.setHorizontalTextPosition(SwingConstants.LEADING);
		Today.setHorizontalAlignment(SwingConstants.LEADING);
		Today.setForeground(new Color(255, 255, 255));
		Today.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 25));
		Today.setFocusable(false);
		Today.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		Today.setBackground(new Color(0, 0, 128));
		contentPane.add(Today);
		
		
		Ended = new JButton(" Ended\r\n");
		Ended.setBounds(752, 85, 378, 75);
		Ended.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maincontainer.setSelectedIndex(2);
			}
		});
		Ended.setHorizontalTextPosition(SwingConstants.LEADING);
		Ended.setHorizontalAlignment(SwingConstants.LEADING);
		Ended.setForeground(new Color(255,255,255));
		Ended.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 25));
		Ended.setFocusable(false);
		Ended.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		Ended.setBackground(new Color(0, 0, 128));
		contentPane.add(Ended);
		
		maincontainer = new JTabbedPane(JTabbedPane.TOP);
		maincontainer.setBounds(10, 85, 1120, 467);
		maincontainer.setBackground(new Color(240, 248, 255));
		contentPane.add(maincontainer);
		
		draftspanel = new JPanel();
		draftspanel.setBackground(new Color(240, 248, 255));
		maincontainer.addTab("New tab", null, draftspanel, null);
		draftspanel.setLayout(null);
		
		publish = new JButton("PUBLISH");
		publish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String jbdcURL = "jdbc:postgresql://localhost:5432/EMS";
			     String username = "postgres";
			     String password = "Oskadam7002";
				 try {
					 Connection connection = DriverManager.getConnection(jbdcURL,username,password);
					 String sql = "UPDATE exams SET status = '1' WHERE code = '"+publishtf.getText()+"'";
					 PreparedStatement statement = connection.prepareStatement(sql);
					 statement.executeUpdate();
					 connection.close();
					 JOptionPane.showMessageDialog(null, "Test has been posted successfully");
				 }
				 catch (SQLException e1) {
					 e1.printStackTrace();
				 }
			}
		});
		publish.setFocusable(false);
		publish.setForeground(Color.WHITE);
		publish.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 25));
		publish.setBorder(null);
		publish.setBackground(new Color(0, 255, 0));
		publish.setBounds(10, 60, 146, 39);
		draftspanel.add(publish);
		
		publishtf = new JTextField();
		publishtf.setColumns(10);
		publishtf.setBounds(166, 60, 207, 40);
		draftspanel.add(publishtf);
		
		ec1 = new JLabel("(Exam Code)");
		ec1.setHorizontalAlignment(SwingConstants.CENTER);
		ec1.setBounds(383, 60, 83, 40);
		draftspanel.add(ec1);
		
		sp1 = new JScrollPane();
		sp1.setBounds(10, 110, 1095, 318);
		draftspanel.add(sp1);
		String[] col = {"Code:","Name:","Date:","From:","To:","Duration","Marks:","Questions:"};
		dm1 = new DefaultTableModel(col,0) {
			public boolean isCellEditable(int i, int j) {
					return false;
			}
		};	
		jt1 = new JTable(dm1);
		jt1.setBackground(new Color(240, 255, 255));
		jt1.getTableHeader().setBackground(new Color(0,0,128));
		jt1.getTableHeader().setForeground(new Color(255, 255, 255));
		jt1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
		jt1.getTableHeader().setResizingAllowed(false);
		jt1.getTableHeader().setReorderingAllowed(false);
		jt1.getColumnModel().getColumn(0).setPreferredWidth(50);
		jt1.getColumnModel().getColumn(1).setPreferredWidth(275);
		jt1.getColumnModel().getColumn(2).setPreferredWidth(70);
		jt1.getColumnModel().getColumn(3).setPreferredWidth(60);
		jt1.getColumnModel().getColumn(4).setPreferredWidth(60);
		jt1.getColumnModel().getColumn(5).setPreferredWidth(60);
		jt1.getColumnModel().getColumn(6).setPreferredWidth(50);
		jt1.getColumnModel().getColumn(7).setPreferredWidth(70);
		jt1.setShowVerticalLines(false);
		jt1.setFocusable(false);
		jt1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		jt1.setRowHeight(50);
		jt1.setRowSelectionAllowed(true);
		sp1.setViewportView(jt1);
		
		today = new JPanel();
		today.setBackground(new Color(240, 248, 255));
		maincontainer.addTab("New tab", null, today, null);
		today.setLayout(null);
		
		end = new JButton("END");
		end.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String jbdcURL = "jdbc:postgresql://localhost:5432/EMS";
			     String username = "postgres";
			     String password = "Oskadam7002";
				 try {
					 Connection connection = DriverManager.getConnection(jbdcURL,username,password);
					 String sql = "UPDATE exams SET status = '2' WHERE code = '"+endtf.getText()+"'";
					 PreparedStatement statement = connection.prepareStatement(sql);
					 statement.executeUpdate();
					 connection.close();
					 JOptionPane.showMessageDialog(null, "Test has ended");
				 }
				 catch (SQLException e1) {
					 e1.printStackTrace();
				 }
			}
		});
		end.setFocusable(false);
		end.setForeground(Color.WHITE);
		end.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 25));
		end.setBorder(null);
		end.setBackground(new Color(255, 0, 0));
		end.setBounds(10, 60, 146, 39);
		today.add(end);
		
		endtf = new JTextField();
		endtf.setColumns(10);
		endtf.setBounds(166, 59, 207, 40);
		today.add(endtf);
		
		ec2 = new JLabel("(Exam Code)");
		ec2.setHorizontalAlignment(SwingConstants.CENTER);
		ec2.setBounds(383, 59, 83, 40);
		today.add(ec2);
		
		sp2 = new JScrollPane();
		sp2.setBounds(10, 110, 1095, 318);
		today.add(sp2);
		String[] col2 = {"Code:","Name:","Date:","From:","To:","Duration","Marks:","Questions:"};
		dm2 = new DefaultTableModel(col2,0) {
			public boolean isCellEditable(int i, int j) {
					return false;
			}
		};	
		jt2 = new JTable(dm2);
		jt2.setBackground(new Color(240, 255, 255));
		jt2.getTableHeader().setBackground(new Color(0,0,128));
		jt2.getTableHeader().setForeground(new Color(255, 255, 255));
		jt2.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
		jt2.getTableHeader().setResizingAllowed(false);
		jt2.getTableHeader().setReorderingAllowed(false);
		jt2.getColumnModel().getColumn(0).setPreferredWidth(50);
		jt2.getColumnModel().getColumn(1).setPreferredWidth(275);
		jt2.getColumnModel().getColumn(2).setPreferredWidth(70);
		jt2.getColumnModel().getColumn(3).setPreferredWidth(60);
		jt2.getColumnModel().getColumn(4).setPreferredWidth(60);
		jt2.getColumnModel().getColumn(5).setPreferredWidth(60);
		jt2.getColumnModel().getColumn(6).setPreferredWidth(50);
		jt2.getColumnModel().getColumn(7).setPreferredWidth(70);
		jt2.setShowVerticalLines(false);
		jt2.setFocusable(false);
		jt2.setFont(new Font("Segoe UI", Font.BOLD, 15));
		jt2.setRowHeight(50);
		jt2.setRowSelectionAllowed(true);
		sp2.setViewportView(jt2);
		
		finished = new JPanel();
		finished.setBackground(new Color(240, 248, 255));
		maincontainer.addTab("New tab", null, finished, null);
		finished.setLayout(null);
		
		delete = new JButton("DELETE");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String jbdcURL = "jdbc:postgresql://localhost:5432/EMS";
			     String username = "postgres";
			     String password = "Oskadam7002";
				 try {
					 Connection connection = DriverManager.getConnection(jbdcURL,username,password);
					 String sql = "DELETE FROM exams WHERE code = '"+deletetf.getText()+"'";
					 PreparedStatement statement = connection.prepareStatement(sql);
					 statement.executeUpdate();
					 connection.close();
					 JOptionPane.showMessageDialog(null, "Test Deleted.");
				 }
				 catch (SQLException e1) {
					 e1.printStackTrace();
				 }
			}
		});
		delete.setFocusable(false);
		delete.setForeground(new Color(255, 255, 255));
		delete.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 25));
		delete.setBorder(null);
		delete.setBackground(new Color(0, 0, 205));
		delete.setBounds(10, 60, 146, 39);
		finished.add(delete);
		
		deletetf = new JTextField();
		deletetf.setBounds(166, 59, 207, 40);
		finished.add(deletetf);
		deletetf.setColumns(10);
		
		ec4 = new JLabel("(Exam Code)");
		ec4.setHorizontalAlignment(SwingConstants.CENTER);
		ec4.setBounds(383, 59, 83, 40);
		finished.add(ec4);
		
		sp4 = new JScrollPane();
		sp4.setBounds(10, 110, 1095, 318);
		finished.add(sp4);
		String[] col4 = {"Code:","Name:","Date:","From:","To:","Duration","Marks:","Questions:"};
		dm4 = new DefaultTableModel(col4,0) {
			public boolean isCellEditable(int i, int j) {
					return false;
			}
		};	
		jt4 = new JTable(dm4);
		jt4.setBackground(new Color(240, 255, 255));
		jt4.getTableHeader().setBackground(new Color(0,0,128));
		jt4.getTableHeader().setForeground(new Color(255, 255, 255));
		jt4.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
		jt4.getTableHeader().setResizingAllowed(false);
		jt4.getTableHeader().setReorderingAllowed(false);
		jt4.getColumnModel().getColumn(0).setPreferredWidth(50);
		jt4.getColumnModel().getColumn(1).setPreferredWidth(275);
		jt4.getColumnModel().getColumn(2).setPreferredWidth(70);
		jt4.getColumnModel().getColumn(3).setPreferredWidth(60);
		jt4.getColumnModel().getColumn(4).setPreferredWidth(60);
		jt4.getColumnModel().getColumn(5).setPreferredWidth(60);
		jt4.getColumnModel().getColumn(6).setPreferredWidth(50);
		jt4.getColumnModel().getColumn(7).setPreferredWidth(70);
		jt4.setShowVerticalLines(false);
		jt4.setFocusable(false);
		jt4.setFont(new Font("Segoe UI", Font.BOLD, 15));
		jt4.setRowHeight(50);
		jt4.setRowSelectionAllowed(true);
		sp4.setViewportView(jt4);
		
		String jbdcURL = "jdbc:postgresql://localhost:5432/EMS";
		String username = "postgres";
		String password = "Oskadam7002";
		try {
			Connection connection = DriverManager.getConnection(jbdcURL,username,password);
			String sql = "SELECT code,name,date,start,finish,dur,marks,ques,status FROM exams WHERE teacher = '"+homepage.us+"'";
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
				if(status.equals("0")) {
					dm1.addRow(new Object[] {c1,n1,d1,s1,f1,du1,m1,q1});
				}
				if(status.equals("2")) {
					dm4.addRow(new Object[] {c1,n1,d1,s1,f1,du1,m1,q1});	
				}
			}
			String sql1 = "SELECT code,name,date,start,finish,dur,marks,ques,status FROM exams WHERE teacher = '"+homepage.us+"'  AND status = '1'";
			PreparedStatement statement1 = connection.prepareStatement(sql1);
			ResultSet rs1 = statement1.executeQuery();
			while(rs1.next()) {
				String c1 = rs1.getString("code");
				String n1 = rs1.getString("name");
				Date d1 = rs1.getDate("date");
				Time s1 = rs1.getTime("start");
				Time f1 = rs1.getTime("finish");
				Time du1 = rs1.getTime("dur");
				String m1 = rs1.getString("marks");
				String q1 = rs1.getString("ques");
				dm2.addRow(new Object[] {c1,n1,d1,s1,f1,du1,m1,q1});	
			}
			connection.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
