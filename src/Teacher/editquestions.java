package teacher;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class editquestions extends JFrame {

	public JPanel contentPane;
	public JTable table;
	public JScrollPane scrollPane;
	public DefaultTableModel dm;
	public JButton btnNewButton,btnUpdateQuestion,btnClose;
	private JTextField textField, textField_1,textField_2,textField_3,textField_4,textField_5;
	private JLabel lblNewLabel,lblQuestion,lblOption_3,lblOption_4,lblOption_2,lblOption,lblOption_1;
	private JTextArea textArea;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editquestions frame = new editquestions();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public editquestions() {
		setTitle("Edit/View Questions");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Omkar Kadam\\Desktop\\New folder\\icons8-test-passed-96.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1150, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 360, 1116, 192);
		contentPane.add(scrollPane);
		String[] col = {"Ques No.","Question","Option 1","Option 2","Option 3","Option 4","Correct Option"};
		dm = new DefaultTableModel(col,0) {
			public boolean isCellEditable(int i, int j) {
				return false;
			}
		};
		table = new JTable(dm);
		table.getTableHeader().setBackground(new Color(0,0,128));
		table.getTableHeader().setForeground(new Color(255, 255, 255));
		table.getTableHeader().setFont(new Font("Segoe UI", Font.PLAIN, 15));
		table.getTableHeader().setResizingAllowed(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(25);
		table.getColumnModel().getColumn(1).setPreferredWidth(300);
		table.getColumnModel().getColumn(2).setPreferredWidth(75);
		table.getColumnModel().getColumn(3).setPreferredWidth(75);
		table.getColumnModel().getColumn(4).setPreferredWidth(75);
		table.getColumnModel().getColumn(5).setPreferredWidth(75);
		table.getColumnModel().getColumn(6).setPreferredWidth(75);
		table.setShowVerticalLines(true);
		table.setFocusable(false);
		table.setFont(new Font("Segoe UI", Font.BOLD, 15));
		table.setRowHeight(25);
		table.setRowSelectionAllowed(true);
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("Edit Question");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String jbdcURL = "jdbc:postgresql://localhost:5432/EMS";
			    String username = "postgres";
			    String password = "Oskadam7002";
			     try {
			    	 Connection connection = DriverManager.getConnection(jbdcURL,username,password);
			    	 String sql = "SELECT Ques,option1,option2,option3,option4,correctopt FROM "+create_test.code+" WHERE quesnum = '"+Integer.valueOf(textField.getText())+"'";
			    	 PreparedStatement statement = connection.prepareStatement(sql);
			    	 ResultSet rs = statement.executeQuery();
			    	 while(rs.next()) {
			    		 String ques = rs.getString("Ques");
			    		 String opt1 = rs.getString("option1");
			    		 String opt2 = rs.getString("option2");
			    		 String opt3 = rs.getString("option3");
			    		 String opt4 = rs.getString("option4");
			    		 String copt = rs.getString("correctopt");
			    		 textArea.setText(ques);
			    		 textField_1.setText(opt1);
			    		 textField_2.setText(opt2);
			    		 textField_3.setText(opt3);
			    		 textField_4.setText(opt4);
			    		 textField_5.setText(copt);
			    	 }
			     }
			     catch(SQLException e1) {
			    	 e1.printStackTrace();
			     }
			}
		});
		btnNewButton.setFocusable(false);
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(10, 11, 214, 38);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		textField.setBounds(381, 11, 67, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblNewLabel = new JLabel("Question No.");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(234, 10, 137, 43);
		contentPane.add(lblNewLabel);
		
		btnUpdateQuestion = new JButton("Update Question");
		btnUpdateQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String jbdcURL = "jdbc:postgresql://localhost:5432/EMS";
			    String username = "postgres";
			    String password = "Oskadam7002";
			    try {
			    	 Connection connection = DriverManager.getConnection(jbdcURL,username,password);
			    	 String sql = "UPDATE "+create_test.code+" SET Ques = '"+textArea.getText()+"', option1 = '"+textField_1.getText()+"', option2 = '"+
			    			 textField_2.getText()+"', option3 = '"+textField_3.getText()+"', option4 = '"+textField_4.getText()+"', correctopt = '"+textField_5.getText()+"' WHERE quesnum ="+Integer.valueOf(textField.getText());
			    	 PreparedStatement statement = connection.prepareStatement(sql);
					 statement.executeUpdate();
					 connection.close();
					 JOptionPane.showMessageDialog(null, "Question Updated Successfully!");
			    }
			    catch(SQLException e1) {
			    	e1.printStackTrace();
			    }
			}
		});
		btnUpdateQuestion.setForeground(Color.WHITE);
		btnUpdateQuestion.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btnUpdateQuestion.setFocusable(false);
		btnUpdateQuestion.setBorder(null);
		btnUpdateQuestion.setBackground(new Color(0, 0, 128));
		btnUpdateQuestion.setBounds(687, 11, 214, 38);
		contentPane.add(btnUpdateQuestion);
		
		lblQuestion = new JLabel("Question :");
		lblQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestion.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 20));
		lblQuestion.setBounds(10, 60, 137, 43);
		contentPane.add(lblQuestion);
		
		textArea = new JTextArea();
		textArea.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		textArea.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setBounds(167, 60, 959, 104);
		contentPane.add(textArea);
		
		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setForeground(Color.WHITE);
		btnClose.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btnClose.setFocusable(false);
		btnClose.setBorder(null);
		btnClose.setBackground(new Color(0, 0, 128));
		btnClose.setBounds(912, 11, 214, 38);
		contentPane.add(btnClose);
		
		lblOption = new JLabel("Option 1 :");
		lblOption.setHorizontalAlignment(SwingConstants.CENTER);
		lblOption.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 20));
		lblOption.setBounds(10, 177, 137, 43);
		contentPane.add(lblOption);
		
		lblOption_1 = new JLabel("Option 2 :");
		lblOption_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblOption_1.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 20));
		lblOption_1.setBounds(10, 231, 137, 43);
		contentPane.add(lblOption_1);
		
		textField_1 = new JTextField();
		textField_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		textField_1.setBounds(165, 175, 405, 45);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		textField_2.setBounds(165, 231, 405, 45);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		textField_3.setBounds(721, 175, 405, 45);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		textField_4.setBounds(721, 231, 405, 45);
		contentPane.add(textField_4);
		
		lblOption_3 = new JLabel("Option 3 :");
		lblOption_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblOption_3.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 20));
		lblOption_3.setBounds(574, 175, 137, 43);
		contentPane.add(lblOption_3);
		
		lblOption_4 = new JLabel("Option 4 :");
		lblOption_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblOption_4.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 20));
		lblOption_4.setBounds(574, 231, 137, 43);
		contentPane.add(lblOption_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		textField_5.setBounds(524, 287, 405, 45);
		contentPane.add(textField_5);
		
		lblOption_2 = new JLabel("Correct Option");
		lblOption_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblOption_2.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 20));
		lblOption_2.setBounds(331, 287, 183, 43);
		contentPane.add(lblOption_2);
		String jbdcURL = "jdbc:postgresql://localhost:5432/EMS";
	    String username = "postgres";
	    String password = "Oskadam7002";
	     try {
	    	 Connection connection = DriverManager.getConnection(jbdcURL,username,password);
	    	 String sql = "SELECT * FROM "+create_test.code+"";
	    	 PreparedStatement statement = connection.prepareStatement(sql);
	    	 ResultSet rs = statement.executeQuery();
	    	 while(rs.next()) {
	    		 int q = rs.getInt("quesnum");
	    		 String ques = rs.getString("Ques");
	    		 String opt1 = rs.getString("option1");
	    		 String opt2 = rs.getString("option2");
	    		 String opt3 = rs.getString("option3");
	    		 String opt4 = rs.getString("option4");
	    		 String copt = rs.getString("correctopt");
	    		 dm.addRow(new Object[] {q,ques,opt1,opt2,opt3,opt4,copt});
	    	 }
	     }
	     catch(SQLException e) {
	    	 e.printStackTrace();
	     }
	}
}
