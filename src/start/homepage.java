package start;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import Student.*;
import teacher.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class homepage extends JFrame {
	private JPanel contentPane,panel;
	public JLabel headerlogo, lbl1, headname, pic,profile,line1,description;
	private JButton btn1, btn2, btn3;
	public static String q;
	public static String us;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homepage frame = new homepage(us);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public homepage(String u) {
		us = u;
		setTitle("HomeScreen\r\n");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Omkar Kadam\\Desktop\\New folder\\icons8-test-passed-96.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1150, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lbl1 = new JLabel("");
		lbl1.setBounds(0, 0, 1136, 563);
		lbl1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		lbl1.setIcon(new ImageIcon("C:\\Users\\Omkar Kadam\\Desktop\\New folder\\background.jpg"));
		contentPane.add(lbl1);
		
		panel = new JPanel();
		panel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel.setBackground(new Color(0, 0, 128));
		panel.setBounds(0, 0, 1136, 125);
		lbl1.add(panel);
		panel.setLayout(null);
		
		headerlogo = new JLabel("");
		headerlogo.setIcon(new ImageIcon("C:\\Users\\Omkar Kadam\\Desktop\\New folder\\logo.png"));
		headerlogo.setBounds(10, 0, 64, 80);
		panel.add(headerlogo);
		
		headname = new JLabel("GradeX");
		headname.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 40));
		headname.setForeground(new Color(255, 255, 255));
		headname.setHorizontalAlignment(SwingConstants.CENTER);
		headname.setBounds(69, 13, 165, 67);
		panel.add(headname);
		
		line1 = new JLabel("- A Exam Management System");
		line1.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 15));
		line1.setForeground(new Color(255, 255, 255));
		line1.setBounds(10, 70, 224, 30);
		panel.add(line1);
		
		btn1 = new JButton("EXAMS");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(q.equals("Teacher")) {
					exams_main t = new exams_main();
					t.setVisible(true);
					//dispose();
				}
				else {
					exams_student s = new exams_student();
					s.setVisible(true);
					//dispose();
				}
			}
		});
		btn1.setForeground(new Color(255, 255, 255));
		btn1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btn1.setFocusable(false);
		btn1.setBackground(new Color(0, 0, 128));
		btn1.setBorder(null);
		btn1.setBounds(290, 10, 90, 30);
		panel.add(btn1);
		
		btn2 = new JButton("REPORTS");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(q.equals("Teacher")) {
					results_teacher rt = new results_teacher();
					rt.setVisible(true);
					//dispose();
				}
				else {
					result_main rm = new result_main();
					rm.setVisible(true);
					//dispose();
				}
			}
		});
		btn2.setForeground(new Color(255, 255, 255));
		btn2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btn2.setFocusable(false);
		btn2.setBackground(new Color(0, 0, 128));
		btn2.setBorder(null);
		btn2.setBounds(420, 10, 95, 30);
		panel.add(btn2);
		
		btn3 = new JButton("ACCOUNT\r\n");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(q.equals("Teacher")) {
					acc_teacher a1 = new acc_teacher();
					a1.setVisible(true);
					//dispose();
				}
				else {
					acc_student a2 = new acc_student();
					a2.setVisible(true);
					//dispose();
				}
			}
		});
		btn3.setForeground(new Color(255, 255, 255));
		btn3.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btn3.setFocusable(false);
		btn3.setBackground(new Color(0, 0, 128));
		btn3.setBorder(null);
		btn3.setBounds(550, 10, 100, 30);
		panel.add(btn3);
		
		if(login.pt.equals("Teacher")) {
			q = "Teacher";
		}
		else if (registration.pt1.equals("Teacher")) {
			q = "Teacher";
		}
		else {
			q = "Student";
		}
		
		profile = new JLabel(q+" Profile\r\n");
		profile.setHorizontalAlignment(SwingConstants.CENTER);
		profile.setFont(new Font("Segoe UI", Font.ITALIC, 15));
		profile.setForeground(new Color(255, 255, 255));
		profile.setBounds(1018, 0, 118, 30);
		panel.add(profile);
				
		description = new JLabel("<html>GradeX is an online, user-friendly Examination System Application!!!<br><br>\r\nIt has been developed to computerize the process of conducting exams......<br><br>\r\nAnd also to make the entire process more advantageous in various aspects.");
		description.setVerticalAlignment(SwingConstants.TOP);
		description.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 25));
		description.setForeground(new Color(0, 0, 0));
		description.setHorizontalAlignment(SwingConstants.CENTER);
		description.setHorizontalTextPosition(SwingConstants.CENTER);
		description.setOpaque(true);
		description.setBackground(new Color(255, 255, 240));
		description.setBounds(517, 202, 528, 272);
		lbl1.add(description);
		
		pic = new JLabel("");
		pic.setVerticalAlignment(SwingConstants.TOP);
		lbl1.add(pic);
		pic.setHorizontalAlignment(SwingConstants.CENTER);
		pic.setIcon(new ImageIcon("C:\\Users\\Omkar Kadam\\Desktop\\New folder\\homepage.jpg"));
		pic.setBounds(47, 202, 428, 272);
	}
}
