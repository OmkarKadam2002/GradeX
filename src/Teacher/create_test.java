package teacher;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;
import com.toedter.calendar.*;
import start.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@SuppressWarnings("serial")
public class create_test extends JFrame {

	public JPanel contentPane, instructionborder;
	public JTextField t1,t2,t3,t4,t5,t6,t7;
	public JLabel testcode, testDate, testname;
	public JDateChooser dateChooser;
	public JLabel header,dur, from, to, marks, ques, instructions, instructionsheader;
	public JButton Create,Cancel, btnDone;
	static SimpleDateFormat startf = new SimpleDateFormat("HH:mm:ss");
	static SimpleDateFormat finishf = new SimpleDateFormat("HH:mm:ss");
	static SimpleDateFormat durf = new SimpleDateFormat("HH:mm:ss");
	public String start,finish, duration;
	public JTextFieldDateEditor dateChooserEditor;
	public static int qu,n;
	public static String code,name,date, start1, finish1,dur1, marks1,ques1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					create_test frame = new create_test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public create_test() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Omkar Kadam\\Desktop\\New folder\\icons8-test-passed-96.png"));
		setTitle("Create A Test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 600, 450);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		start = startf.format(Calendar.getInstance().getTime());
		finish = finishf.format(Calendar.getInstance().getTime());
		duration = durf.format(Calendar.getInstance().getTime());
		
		header = new JLabel("Enter Test Details");
		header.setOpaque(true);
		header.setBackground(new Color(0, 0, 128));
		header.setIcon(new ImageIcon("C:\\Users\\Omkar Kadam\\Desktop\\New folder\\Tests-icon.png"));
		header.setFont(new Font("Segoe UI", Font.BOLD, 25));
		header.setForeground(new Color(255, 255, 255));
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setBounds(10, 11, 294, 59);
		contentPane.add(header);
		
		testcode = new JLabel("Test Code:");
		testcode.setFont(new Font("Segoe UI", Font.BOLD, 15));
		testcode.setHorizontalAlignment(SwingConstants.CENTER);
		testcode.setBounds(10, 81, 82, 31);
		contentPane.add(testcode);
		
		t1 = new JTextField();
		t1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		t1.setOpaque(false);
		t1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		t1.setBounds(102, 81, 187, 31);
		contentPane.add(t1);
		t1.setColumns(10);
		
		testname = new JLabel("Test Name:");
		testname.setHorizontalAlignment(SwingConstants.CENTER);
		testname.setFont(new Font("Segoe UI", Font.BOLD, 15));
		testname.setBounds(299, 81, 82, 31);
		contentPane.add(testname);
		
		t2 = new JTextField();
		t2.setOpaque(false);
		t2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		t2.setColumns(10);
		t2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		t2.setBounds(391, 82, 185, 31);
		contentPane.add(t2);
		
		testDate = new JLabel("Test Date:");
		testDate.setHorizontalAlignment(SwingConstants.CENTER);
		testDate.setFont(new Font("Segoe UI", Font.BOLD, 15));
		testDate.setBounds(10, 123, 82, 31);
		contentPane.add(testDate);
		
		dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setBounds(166, 0, 21, 31);
		dateChooser.setBounds(102, 123, 187, 31);
		dateChooser.setBackground(new Color(176, 224, 230));
		dateChooser.setOpaque(true);
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		contentPane.add(dateChooser);
		
		dur = new JLabel("Duration:");
		dur.setHorizontalAlignment(SwingConstants.CENTER);
		dur.setFont(new Font("Segoe UI", Font.BOLD, 15));
		dur.setBounds(299, 123, 82, 31);
		contentPane.add(dur);
		
		t3 = new JTextField();
		t3.setOpaque(false);
		t3.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		t3.setColumns(10);
		t3.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		t3.setBounds(391, 124, 185, 31);
		contentPane.add(t3);
		
		from = new JLabel("Time(From):");
		from.setHorizontalAlignment(SwingConstants.CENTER);
		from.setFont(new Font("Segoe UI", Font.BOLD, 15));
		from.setBounds(10, 165, 95, 31);
		contentPane.add(from);
		
		to = new JLabel("Time(To):");
		to.setHorizontalAlignment(SwingConstants.CENTER);
		to.setFont(new Font("Segoe UI", Font.BOLD, 15));
		to.setBounds(299, 165, 82, 31);
		contentPane.add(to);
		
		t4 = new JTextField();
		t4.setOpaque(false);
		t4.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		t4.setColumns(10);
		t4.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		t4.setBounds(112, 165, 175, 31);
		contentPane.add(t4);
		
		t5 = new JTextField();
		t5.setOpaque(false);
		t5.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		t5.setColumns(10);
		t5.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		t5.setBounds(391, 166, 175, 31);
		contentPane.add(t5);
		
		marks = new JLabel("Marks:");
		marks.setHorizontalAlignment(SwingConstants.CENTER);
		marks.setFont(new Font("Segoe UI", Font.BOLD, 15));
		marks.setBounds(10, 207, 82, 31);
		contentPane.add(marks);
		
		ques = new JLabel("Questions:");
		ques.setHorizontalAlignment(SwingConstants.CENTER);
		ques.setFont(new Font("Segoe UI", Font.BOLD, 15));
		ques.setBounds(299, 207, 82, 31);
		contentPane.add(ques);
		
		t6 = new JTextField();
		t6.setOpaque(false);
		t6.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		t6.setColumns(10);
		t6.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		t6.setBounds(102, 207, 185, 31);
		contentPane.add(t6);
		
		t7 = new JTextField();
		t7.setOpaque(false);
		t7.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		t7.setColumns(10);
		t7.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		t7.setBounds(391, 208, 185, 31);
		contentPane.add(t7);
		
		Create = new JButton("Create\r\n");
		Create.setFocusable(false);
		Create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String jbdcURL = "jdbc:postgresql://localhost:5432/EMS";
				String username = "postgres";
				String password = "Oskadam7002";
				try {
					start = t4.getText();
					finish = t5.getText();
					duration = t3.getText();
					Connection connection = DriverManager.getConnection(jbdcURL,username,password);
					String sql1 = "INSERT INTO exams(code,name,date,start,finish,dur,marks,ques,teacher) VALUES(?,?,?::date,?::time,?::time,?::time,?,?,?)";
					PreparedStatement statement = connection.prepareStatement(sql1);
					statement.setString(1, t1.getText());
					statement.setString(2, t2.getText());
					statement.setString(3, ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText());
					statement.setString(4, start);
					statement.setString(5, finish);
					statement.setString(6, duration);
					statement.setString(7, t6.getText());
					statement.setString(8, t7.getText());
					statement.setString(9, homepage.us);
					statement.executeUpdate();
					//JOptionPane.showMessageDialog(null, "Test Created Successfully!!!");
					//connection.close();
					code = String.valueOf(t1.getText());
					name = String.valueOf(t2.getText());
					date = String.valueOf(((JTextField)dateChooser.getDateEditor().getUiComponent()).getText());
					start1 = String.valueOf(start);
					finish1 = String.valueOf(finish); 
					dur1 = String.valueOf(t3.getText());
					marks1 = String.valueOf(t6.getText());
					ques1 = String.valueOf(t7.getText());
					n = Integer.valueOf(t7.getText());
					String sql2 = "CREATE TABLE "+code+" ( quesnum integer PRIMARY KEY,ques text, option1 text, option2 text, option3 text, option4 text, correctopt text)";
					PreparedStatement statement2 = connection.prepareStatement(sql2);
					statement2.executeUpdate();
					String sql3 = "CREATE TABLE "+code+"results (Studentun text PRIMARY KEY, totalmarks text DEFAULT '"+marks1+"', marksobtained text, totalquestions text DEFAULT '"+ques1+"', questionsattempted text)";
					PreparedStatement statement3 = connection.prepareStatement(sql3);
					statement3.executeUpdate();
					JOptionPane.showMessageDialog(null, "Test Created Successfully!!!");
					connection.close();
					t1.setText(null);
					t2.setText(null);
					t3.setText(null);
					t4.setText(null);
					t5.setText(null);
					t6.setText(null);
					t7.setText(null);
					dateChooserEditor.setText(null);
					/*set_Questions s = new set_Questions();
					s.setVisible(true);
					dispose();*/
				}
				catch(SQLException e1) {
					JOptionPane.showMessageDialog(null,"Error!!! \n Enter the Values in Correct Format!! \n Test code may have been duplicated! ");
					e1.printStackTrace();
				}
			}
		});
		Create.setBorder(null);
		Create.setBackground(new Color(0, 0, 128));
		Create.setFont(new Font("Segoe UI", Font.BOLD, 15));
		Create.setForeground(new Color(255, 255, 255));
		Create.setBounds(61, 270, 107, 31);
		contentPane.add(Create);
		
		Cancel = new JButton("Cancel");
		Cancel.setFocusable(false);
		Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		Cancel.setForeground(Color.WHITE);
		Cancel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		Cancel.setBorder(null);
		Cancel.setBackground(new Color(0, 0, 128));
		Cancel.setBounds(217, 270, 107, 31);
		contentPane.add(Cancel);
		
		btnDone = new JButton("Done");
		btnDone.setFocusable(false);
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				set_Questions s = new set_Questions();
				s.setVisible(true);
				dispose();
			}
		});
		btnDone.setForeground(Color.WHITE);
		btnDone.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnDone.setBorder(null);
		btnDone.setBackground(new Color(0, 0, 128));
		btnDone.setBounds(364, 270, 107, 31);
		contentPane.add(btnDone);
		
		instructionborder = new JPanel();
		instructionborder.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		instructionborder.setOpaque(false);
		instructionborder.setBounds(10, 317, 566, 85);
		contentPane.add(instructionborder);
		instructionborder.setLayout(null);
		
		instructions = new JLabel("<html>i] Please enter the fields 'Duration', 'Time(From)', 'Time(to)' in 'hh:mm:ss' format<br> ii] Duplicated Test Code will not be accepted.");
		instructions.setBounds(14, 24, 542, 50);
		instructionborder.add(instructions);
		instructions.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		instructions.setForeground(Color.RED);
		
		instructionsheader = new JLabel("Instructions:");
		instructionsheader.setBounds(10, 0, 130, 31);
		instructionborder.add(instructionsheader);
		instructionsheader.setHorizontalAlignment(SwingConstants.CENTER);
		instructionsheader.setFont(new Font("Segoe UI", Font.BOLD, 20));
		instructionsheader.setForeground(new Color(0, 0, 0));
		
		dateChooserEditor = ((JTextFieldDateEditor)dateChooser.getDateEditor());
		dateChooserEditor.setBackground(new Color(176, 224, 230));
		dateChooserEditor.setBorder(null);
	}
}
