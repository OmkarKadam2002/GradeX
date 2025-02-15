package Student;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
@SuppressWarnings("serial")
public class instructions extends JFrame {
	public JPanel contentPane;
	public JButton start;
	public JLabel title,point1, heading,point4,point3,point2,point5,point6, point7,point8;
	public JCheckBox iagree;
	public JPanel green,orange,white;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					instructions frame = new instructions();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public instructions() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 650, 544);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		title = new JLabel("Please Read The Instructions Carefully!");
		title.setFont(new Font("Segoe UI", Font.ITALIC, 15));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(163, 5, 306, 38);
		contentPane.add(title);
		
		heading = new JLabel("General Instructions:");
		heading.setFont(new Font("Segoe UI", Font.BOLD, 20));
		heading.setBounds(10, 43, 200, 26);
		contentPane.add(heading);
		
		point1 = new JLabel("1] The total Duration of the exam is "+exams_student.a1+" (hh:mm:ss)");
		point1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		point1.setBounds(10, 80, 616, 21);
		contentPane.add(point1);
		
		point4 = new JLabel("<html>4] The timer is available at the top right corner of the screen and will display the total <br>remaining time you have to complete the examination. ");
		point4.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		point4.setBounds(10, 194, 616, 42);
		contentPane.add(point4);
		
		point5 = new JLabel("<html>5] The question palette will be visible to the right side of screen.<br>\r\nYou will be able to see the status of each question indicated in the following ways:\r\n<br>WHITE    -> Question has not been visited.\r\n<br>GREEN    -> Question has been answered.\r\n<br>ORANGE -> Question was visited but not answered.\r\n\r\n\r\n");
		point5.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		point5.setBounds(10, 247, 616, 138);
		contentPane.add(point5);
		
		point6 = new JLabel("6] The forward and backward arrows can be used to navigate through the questions.");
		point6.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		point6.setBounds(10, 383, 616, 21);
		contentPane.add(point6);
		
		point7 = new JLabel("7] The test can only be closed by clicking on 'Submit test.'");
		point7.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		point7.setBounds(10, 415, 616, 21);
		contentPane.add(point7);
		
		white = new JPanel();
		white.setBorder(new LineBorder(new Color(0, 0, 0)));
		white.setBackground(Color.WHITE);
		white.setBounds(295, 310, 17, 15);
		contentPane.add(white);
		
		orange = new JPanel();
		orange.setBackground(new Color(255, 165, 0));
		orange.setBounds(362, 352, 17, 15);
		contentPane.add(orange);
		
		green = new JPanel();
		green.setBorder(new LineBorder(new Color(0, 0, 0)));
		green.setBackground(new Color(0, 255, 127));
		green.setBounds(295, 332, 17, 15);
		contentPane.add(green);
		
		iagree = new JCheckBox("I Agree");
		iagree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				start.setVisible(true);
			}
		});
		iagree.setOpaque(false);
		iagree.setFocusable(false);
		iagree.setHorizontalAlignment(SwingConstants.CENTER);
		iagree.setBounds(163, 500, 99, 23);
		contentPane.add(iagree);
		
		point8 = new JLabel("8] Click on 'I agree' to start the test");
		point8.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		point8.setBounds(10, 450, 616, 21);
		contentPane.add(point8);
		
		point2 = new JLabel("2] The Test is of "+exams_student.b1+" marks");
		point2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		point2.setBounds(10, 112, 616, 21);
		contentPane.add(point2);
		
		point3 = new JLabel("<html>3] There are total "+exams_student.c1+" question<br>[Every Question has been alloted "+exams_student.d1+" marks]");
		point3.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		point3.setBounds(10, 144, 616, 39);
		contentPane.add(point3);
		
		start = new JButton("Start");
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//AttemptTest a5 = new AttemptTest();
				//attempt a5 = new attempt();
				//a5.setVisible(true);
				AttemptTest te = new AttemptTest();
				te.setVisible(true);
				dispose();
			}
		});
		start.setBorder(null);
		start.setFont(new Font("Segoe UI", Font.BOLD, 20));
		start.setForeground(new Color(255, 255, 255));
		start.setBackground(new Color(0, 0, 128));
		start.setBounds(295, 495, 114, 33);
		contentPane.add(start);
		start.setVisible(false);
	}
}