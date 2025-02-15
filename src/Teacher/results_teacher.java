package teacher;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import start.*;
import java.sql.*;
import java.awt.event.*;
@SuppressWarnings("serial")
public class results_teacher extends JFrame {
	public JPanel contentPane;
	public JButton btnNewButton,btnNewButton_1;
	public JLabel lblNewLabel,lblNewLabel_1;
	public JTextField textField;
	public JTable table;
	public JScrollPane scrollPane;
	public DefaultTableModel dm;
	public static String rc;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					results_teacher frame = new results_teacher();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public results_teacher() {
		setTitle("Result main Student");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Omkar Kadam\\Desktop\\New folder\\icons8-test-passed-96.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1150, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnNewButton.setBorder(null);
		btnNewButton.setFocusable(false);
		btnNewButton.setBackground(new Color(240, 248, 255));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Omkar Kadam\\Desktop\\New folder\\Back.png"));
		btnNewButton.setBounds(10, 11, 75, 64);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("RESULTS");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(0, 0, 128));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(95, 11, 159, 64);
		contentPane.add(lblNewLabel);
		
		btnNewButton_1 = new JButton("Generate Result ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rc = textField.getText();
				generateresult gr = new generateresult();
				gr.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Bookman Old Style", Font.BOLD, 25));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(new Color(221, 160, 221));
		btnNewButton_1.setBounds(10, 89, 244, 43);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(264, 89, 164, 43);
		contentPane.add(textField);
		textField.setColumns(10);
		
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
		String sql2 = "SELECT code,name,date,start,finish,dur,marks,ques FROM exams WHERE teacher = '"+homepage.us+"' AND status = '2'";
		PreparedStatement statement2 = connection.prepareStatement(sql2);
		ResultSet rs2 = statement2.executeQuery();
		while(rs2.next()) {
			String c1 = rs2.getString("code");
			String n1 = rs2.getString("name");
			Date d1 = rs2.getDate("date");
			Time s1 = rs2.getTime("start");
			Time f1 = rs2.getTime("finish");
			Time du1 = rs2.getTime("dur");
			String m1 = rs2.getString("marks");
			String q1 = rs2.getString("ques");
			dm.addRow(new Object[] {c1,n1,d1,s1,f1,du1,m1,q1});	
		}
		connection.close();
	 }
	 catch (SQLException e1) {
		 e1.printStackTrace();
	 }
	}
}
