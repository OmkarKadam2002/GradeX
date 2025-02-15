package teacher;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

@SuppressWarnings("serial")
public class set_Questions extends JFrame {

	public JPanel contentPane,panel1,panel2,panel3;
	public JButton btn1;
	public JLabel header,code,name,date,time,marks,ques,dur,answer;
	public JLabel qno;
	public static int i = 1;
	public JScrollPane scrollPane;
	public JTextPane textPane;
	public JLabel pic, opt1,opt2,opt3,opt4;
	public JTextField t1,t2,t3,t4;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	private JButton btnDone;
	private JButton btnSeeAllQuestions;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					set_Questions frame = new set_Questions();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public set_Questions() {
		setTitle("Set Questions");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Omkar Kadam\\Desktop\\New folder\\icons8-test-passed-96.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1150, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel1 = new JPanel();
		panel1.setBackground(new Color(255, 255, 255));
		panel1.setBounds(10, 11, 1116, 95);
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		header = new JLabel("Set Questions For The Test...");
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setFont(new Font("Segoe UI", Font.BOLD, 15));
		header.setBounds(10, 11, 218, 27);
		panel1.add(header);
		
		code = new JLabel(create_test.code);
		code.setOpaque(true);
		code.setBackground(new Color(224, 255, 255));
		code.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		code.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		code.setForeground(new Color(0, 0, 0));
		code.setHorizontalAlignment(SwingConstants.CENTER);
		code.setBounds(10, 49, 79, 35);
		panel1.add(code);
		
		name = new JLabel(create_test.name);
		name.setOpaque(true);
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setForeground(Color.BLACK);
		name.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		name.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		name.setBackground(new Color(224, 255, 255));
		name.setBounds(99, 49, 388, 35);
		panel1.add(name);
		
		date = new JLabel(create_test.date);
		date.setOpaque(true);
		date.setHorizontalAlignment(SwingConstants.CENTER);
		date.setForeground(Color.BLACK);
		date.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		date.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		date.setBackground(new Color(224, 255, 255));
		date.setBounds(497, 49, 106, 35);
		panel1.add(date);
		
		time = new JLabel("From "+create_test.start1+" to "+create_test.finish1);
		time.setOpaque(true);
		time.setHorizontalAlignment(SwingConstants.CENTER);
		time.setForeground(Color.BLACK);
		time.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		time.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		time.setBackground(new Color(224, 255, 255));
		time.setBounds(613, 49, 201, 35);
		panel1.add(time);
		
		marks = new JLabel(create_test.marks1+" marks");
		marks.setOpaque(true);
		marks.setHorizontalAlignment(SwingConstants.CENTER);
		marks.setForeground(Color.BLACK);
		marks.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		marks.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		marks.setBackground(new Color(224, 255, 255));
		marks.setBounds(898, 49, 89, 35);
		panel1.add(marks);
		
		ques = new JLabel(create_test.ques1+" questions");
		ques.setOpaque(true);
		ques.setHorizontalAlignment(SwingConstants.CENTER);
		ques.setForeground(Color.BLACK);
		ques.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		ques.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		ques.setBackground(new Color(224, 255, 255));
		ques.setBounds(994, 49, 112, 35);
		panel1.add(ques);
		
		dur = new JLabel(create_test.dur1);
		dur.setOpaque(true);
		dur.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		dur.setBackground(new Color(224, 255, 255));
		dur.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		dur.setHorizontalAlignment(SwingConstants.CENTER);
		dur.setBounds(824, 49, 64, 35);
		panel1.add(dur);
		
		
		btn1 = new JButton("Save & Next");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String jbdcURL = "jdbc:postgresql://localhost:5432/EMS";
				String username = "postgres";
				String password = "Oskadam7002";
				try {
					Connection connection = DriverManager.getConnection(jbdcURL,username,password);
					String sql = "INSERT INTO "+create_test.code+" (quesnum,ques,option1,option2,option3,option4,correctopt) VALUES(?,?,?,?,?,?,?)";
					PreparedStatement statement = connection.prepareStatement(sql);
					statement.setInt(1, i);
					statement.setString(2,textPane.getText());
					statement.setString(3,t1.getText());
					statement.setString(4,t2.getText());
					statement.setString(5,t3.getText());
					statement.setString(6,t4.getText());
					if(comboBox.getSelectedIndex()==1) {
						statement.setString(7, t1.getText());
					}
					if(comboBox.getSelectedIndex()==2) {
						statement.setString(7, t2.getText());
					}
					if(comboBox.getSelectedIndex()==3) {
						statement.setString(7, t3.getText());
					}
					if(comboBox.getSelectedIndex()==4) {
						statement.setString(7, t4.getText());
					}
					statement.executeUpdate();
					JOptionPane.showMessageDialog(null, "Question Added successfully!");
					connection.close();
					textPane.setText(null);
					t1.setText(null);
					t2.setText(null);
					t3.setText(null);
					t4.setText(null);
					comboBox.setSelectedIndex(0);
					i+=1;
					qno.setText("Question No. "+i+" :");
				}
				catch(SQLException e1) {
					System.out.println("Error");
					e1.printStackTrace();
				}
			}
		});
		btn1.setFocusable(false);
		btn1.setBorder(null);
		btn1.setBackground(new Color(255, 255, 255));
		btn1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btn1.setForeground(new Color(0, 0, 0));
		btn1.setBounds(384, 504, 170, 48);
		contentPane.add(btn1);
		
		
		panel2 = new JPanel();
		panel2.setBackground(new Color(255, 255, 255));
		panel2.setBorder(null);
		panel2.setBounds(10, 117, 1116, 376);
		contentPane.add(panel2);
		panel2.setLayout(null);
		
		qno = new JLabel("Question No. "+i+" :");
		qno.setHorizontalAlignment(SwingConstants.CENTER);
		qno.setFont(new Font("Segoe UI", Font.BOLD, 20));
		qno.setForeground(new Color(0, 0, 0));
		qno.setBounds(10, 11, 166, 37);
		panel2.add(qno);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 59, 877, 94);
		panel2.add(scrollPane);
		
	    textPane = new JTextPane();
		textPane.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		textPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		textPane.setBackground(new Color(224, 255, 255));
		scrollPane.setViewportView(textPane);
		
		panel3 = new JPanel();
		panel3.setBackground(new Color(224, 255, 255));
		panel3.setBounds(10, 162, 713, 163);
		panel2.add(panel3);
		panel3.setLayout(null);
		
		opt1 = new JLabel("Option 1 :");
		opt1.setHorizontalAlignment(SwingConstants.CENTER);
		opt1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		opt1.setBounds(10, 11, 81, 27);
		panel3.add(opt1);
		
		opt2 = new JLabel("Option 2 :");
		opt2.setHorizontalAlignment(SwingConstants.CENTER);
		opt2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		opt2.setBounds(10, 49, 81, 27);
		panel3.add(opt2);
		
		opt3 = new JLabel("Option 3 :");
		opt3.setHorizontalAlignment(SwingConstants.CENTER);
		opt3.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		opt3.setBounds(10, 87, 81, 27);
		panel3.add(opt3);
		
		opt4 = new JLabel("Option 4 :");
		opt4.setHorizontalAlignment(SwingConstants.CENTER);
		opt4.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		opt4.setBounds(10, 125, 81, 27);
		panel3.add(opt4);
		
		t1 = new JTextField();
		t1.setBounds(101, 11, 602, 27);
		panel3.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(101, 49, 602, 27);
		panel3.add(t2);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(101, 87, 602, 27);
		panel3.add(t3);
		
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(101, 125, 602, 27);
		panel3.add(t4);
		
		answer = new JLabel(" Correct Answer to this Question :");
		answer.setFont(new Font("Segoe UI", Font.BOLD, 15));
		answer.setBounds(10, 336, 246, 29);
		panel2.add(answer);
		
		pic = new JLabel("");
		pic.setIcon(new ImageIcon("C:\\Users\\Omkar Kadam\\Desktop\\New folder\\EXAMS.png"));
		pic.setHorizontalAlignment(SwingConstants.CENTER);
		pic.setBounds(1025, 11, 81, 94);
		panel2.add(pic);
		
		
		String[] op = {"Select Option","Option 1","Option 2","Option 3","Option 4"};
		comboBox = new JComboBox(op);
		comboBox.setForeground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		comboBox.setFocusable(false);
		comboBox.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		comboBox.setBackground(new Color(0, 0, 128));
		comboBox.setBounds(266, 336, 135, 29);
		panel2.add(comboBox);
		
		btnSeeAllQuestions = new JButton("See All Questions");
		btnSeeAllQuestions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editquestions eq = new editquestions();
				eq.setVisible(true);
			}
		});
		btnSeeAllQuestions.setForeground(new Color(255, 255, 255));
		btnSeeAllQuestions.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnSeeAllQuestions.setFocusable(false);
		btnSeeAllQuestions.setBorder(null);
		btnSeeAllQuestions.setBackground(new Color(0, 0, 128));
		btnSeeAllQuestions.setBounds(906, 317, 200, 48);
		panel2.add(btnSeeAllQuestions);
		
		btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i=0;
				dispose();
			}
		});
		btnDone.setForeground(Color.BLACK);
		btnDone.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnDone.setFocusable(false);
		btnDone.setBorder(null);
		btnDone.setBackground(Color.WHITE);
		btnDone.setBounds(609, 504, 170, 48);
		contentPane.add(btnDone);
	}
}
