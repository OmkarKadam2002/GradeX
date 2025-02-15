package Student;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import start.*;

@SuppressWarnings("serial")
class Q_Button extends JButton
{
	int x1;
	Q_Button(int x1)
	{
		this.x1 = x1;
		this.setPreferredSize(new Dimension(50,35));
		this.setFont(new Font(null,Font.BOLD,10));
		this.setText(String.valueOf(x1));
		this.setBackground(Color.white);
		this.setForeground(Color.black);
		this.setFocusable(false);
		this.setBorder(new MatteBorder(1,1,1,1,Color.black));
	}
}

class S_Options
{
	JRadioButton option1 = new JRadioButton();
	JRadioButton option2 = new JRadioButton();
	JRadioButton option3 = new JRadioButton();
	JRadioButton option4 = new JRadioButton();
	
	ButtonGroup options = new ButtonGroup();
	
	S_Options()
	{
		option1.setFocusable(false);
		option2.setFocusable(false);
		option3.setFocusable(false);
		option4.setFocusable(false);
		
		option1.setFont(new Font(null,Font.PLAIN,20));
		option2.setFont(new Font(null,Font.PLAIN,20));
		option3.setFont(new Font(null,Font.PLAIN,20));
		option4.setFont(new Font(null,Font.PLAIN,20));
		
		option1.setForeground(Color.black);
		option2.setForeground(Color.black);
		option3.setForeground(Color.black);
		option4.setForeground(Color.black);
		
		options.add(option1);
		options.add(option2);
		options.add(option3);
		options.add(option4);
	}
}

class S_Question
{
	public String givenAnswer;
	public boolean Answered;
	public boolean Visited;
	public boolean RightAnswer;
	
	S_Options options = new S_Options();
	String question;
	
	int x;
	String copt;
	
	S_Question(int i)
	{
		String jbdcURL = "jdbc:postgresql://localhost:5432/EMS";
		String username = "postgres";
		String password = "Oskadam7002";
		String q5 = null,opt1=null,opt2=null,opt3=null,opt4=null,copt=null;
		int sqlNext;
		//this.copt=copt;
		try {
			sqlNext = i+1;
			Connection connection = DriverManager.getConnection(jbdcURL,username,password);
			String sql = "SELECT * FROM "+exams_student.ac+" WHERE quesnum = "+sqlNext;
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				q5 = rs.getString("ques");
				opt1 = rs.getString("option1");
				opt2 = rs.getString("option2");
				opt3 = rs.getString("option3");
				opt4 = rs.getString("option4");
				copt = rs.getString("correctopt");
				this.copt=copt;
			}
		}
		catch(SQLException e5) {
			e5.printStackTrace();
		}
		givenAnswer = null;
		Answered = false;
		Visited = false;
		RightAnswer = false;
		
		x = i;
		this.question = q5;
		
		options.option1.setText(opt1);
		options.option2.setText(opt2);
		options.option3.setText(opt3);
		options.option4.setText(opt4);
	}
	

	public void correctAnswer()
	{
		if(givenAnswer==copt)
		{
			RightAnswer = true;
			//AttemptTest.marks++;
		}
	}
	
	public void markAnswered()
	{
		if(givenAnswer != null)
		{
			Answered = true;
		}
	}
	
}


@SuppressWarnings("serial")
public class AttemptTest extends JFrame implements ActionListener {
	public JPanel contentPane, panel,palette,optionpanel,questions;
	public JLabel code,date,subject,timer,quesnum,title;
	public JButton previous,save, submit;
	public JTextArea question;
	public JScrollPane sp1,sp2,sp3;
	public JLabel lblNewLabel;
	public JPanel answered1,unanswered1,notvisited1;
	public JLabel lblQuestionAnswered,lblNewLabel_2,lblNewLabel_3;
	public static String c,n,dur="00:00:00",mks,ques;
	public static Date d;
	public static int m,q;
	private JButton next;
	static int current1 = -1;
	static int next1 = 0;
	static int marks = 0;
	public Timer timer1;
	public int hh,mm,ss;
	public String seconds_string,minutes_string,hours_string;
	S_Question[] sq;
	Q_Button[] b;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AttemptTest frame = new AttemptTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public AttemptTest() {
		setUndecorated(true);
		String jbdcURL = "jdbc:postgresql://localhost:5432/EMS";
		String username = "postgres";
		String password = "Oskadam7002";
		try {
			Connection connection = DriverManager.getConnection(jbdcURL,username,password);
			String sql = "SELECT code,name,date,dur,marks,ques FROM exams WHERE code = '"+exams_student.ac+"'";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				c = rs.getString("code");
				n = rs.getString("name");
				d = rs.getDate("date");
				dur = rs.getString("dur");
				mks = rs.getString("marks");
				m = Integer.valueOf(mks);
				ques = rs.getString("ques");
				q = Integer.valueOf(ques);
			}
			statement.close();
		}
		catch (SQLException e3) {
			e3.printStackTrace();
		}
		sq = new S_Question[q];
		b = new Q_Button[q];
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(5, 5, 1250, 675);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new MatteBorder(2, 2, 0, 2, (Color) new Color(0, 0, 0)));
		panel.setBackground(new Color(25, 25, 112));
		panel.setBounds(0, 0, 1250, 100);
		contentPane.add(panel);
		panel.setLayout(null);
		
		code = new JLabel(" Code : "+c);
		code.setForeground(new Color(255, 255, 255));
		code.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 20));
		code.setBounds(10, 11, 177, 34);
		panel.add(code);
		
		subject = new JLabel(" Name : "+n);
		subject.setForeground(Color.WHITE);
		subject.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 20));
		subject.setBounds(10, 55, 695, 34);
		panel.add(subject);
		
		date = new JLabel(" Date : "+String.valueOf(d));
		date.setForeground(Color.WHITE);
		date.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 20));
		date.setBounds(197, 11, 348, 34);
		panel.add(date);
		
		String parts[] = dur.split(":");
		String hrs = parts[0];
		String min = parts[1];
		String sec = parts[2];
		hh = Integer.valueOf(hrs);
		mm = Integer.valueOf(min);
		ss = Integer.valueOf(sec);
		  seconds_string = String.format("%02d", ss);
		  minutes_string = String.format("%02d", mm);
		  hours_string = String.format("%02d", hh);
		timer1 = new Timer(1000,this);
		timer1.start();
		
		timer = new JLabel(hours_string+":"+minutes_string+":"+seconds_string);
		timer.setHorizontalAlignment(SwingConstants.CENTER);
		timer.setFont(new Font("Segoe UI", Font.BOLD, 25));
		timer.setForeground(new Color(255, 255, 255));
		timer.setBounds(1012, 11, 214, 78);
		panel.add(timer);
		
		palette = new JPanel();
		palette.setBorder(new MatteBorder(0, 2, 2, 2, (Color) new Color(0, 0, 0)));
		palette.setBackground(new Color(224, 255, 255));
		palette.setBounds(869, 100, 381, 575);
		contentPane.add(palette);
		palette.setLayout(null);
		
		sp3 = new JScrollPane();
		sp3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		sp3.setBackground(new Color(224, 255, 255));
		sp3.setBounds(10, 46, 347, 252);
		palette.add(sp3);
		questions = new JPanel();
		questions.setLayout(new WrapLayout(10,12,7));
		questions.setBackground(new Color(224, 255, 255));
		for(int i=0;i<q;i++)
		{
			b[i] = new Q_Button(i+1);
			b[i].addActionListener(this);
			questions.add(b[i]);
			sq[i] = new S_Question(i);
		}
		sp3.setViewportView(questions);
		
		title = new JLabel("Palette");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		title.setBounds(90, 11, 184, 24);
		palette.add(title);
		
		lblNewLabel = new JLabel(" LEGEND : ");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 309, 121, 35);
		palette.add(lblNewLabel);
		
		answered1 = new JPanel();
		answered1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		answered1.setBackground(Color.GREEN);
		answered1.setBounds(10, 355, 59, 51);
		palette.add(answered1);
		
		unanswered1 = new JPanel();
		unanswered1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		unanswered1.setBackground(Color.ORANGE);
		unanswered1.setBounds(10, 416, 59, 51);
		palette.add(unanswered1);
		
		notvisited1 = new JPanel();
		notvisited1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		notvisited1.setBackground(Color.WHITE);
		notvisited1.setBounds(10, 476, 59, 51);
		palette.add(notvisited1);
		
		lblQuestionAnswered = new JLabel(" Question Answered");
		lblQuestionAnswered.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblQuestionAnswered.setBounds(90, 355, 267, 51);
		palette.add(lblQuestionAnswered);
		
		lblNewLabel_2 = new JLabel(" Question Not Answered");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_2.setBounds(90, 416, 267, 51);
		palette.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel(" Question Not Visited");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_3.setBounds(90, 476, 267, 51);
		palette.add(lblNewLabel_3);
		
		quesnum = new JLabel("Question No. :");
		quesnum.setFont(new Font("Segoe UI", Font.BOLD, 25));
		quesnum.setBounds(10, 111, 261, 50);
		contentPane.add(quesnum);
		
		next = new JButton("");
		next.addActionListener(this);
		next.setBorder(null);
		next.setBackground(new Color(240, 248, 255));
		next.setIcon(new ImageIcon("C:\\Users\\Omkar Kadam\\Desktop\\New folder\\nexticon.png"));
		next.setFocusable(false);
		next.setBounds(785, 111, 74, 68);
		contentPane.add(next);
		
		previous = new JButton("");
		previous.addActionListener(this);;
		previous.setBorder(null);
		previous.setBackground(new Color(240, 248, 255));
		previous.setFocusable(false);
		previous.setIcon(new ImageIcon("C:\\Users\\Omkar Kadam\\Desktop\\New folder\\Back.png"));
		previous.setBounds(701, 111, 74, 68);
		contentPane.add(previous);
		
		sp1 = new JScrollPane();
		sp1.setBackground(new Color(240, 248, 255));
		sp1.setBounds(10, 185, 845, 131);
		contentPane.add(sp1);
		question = new JTextArea();
		question.setLineWrap(true);
		question.setWrapStyleWord(true);
		question.setFont(new Font("Segoe UI", Font.BOLD, 20));
		question.setEditable(false);
		question.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		question.setBackground(new Color(240, 248, 255));
		sp1.setViewportView(question);
		
		sp2 = new JScrollPane();
		sp2.setBackground(new Color(240, 248, 255));
		sp2.setBorder(null);
		sp2.setBounds(10, 327, 845, 247);
		contentPane.add(sp2);
		
		optionpanel = new JPanel();
		optionpanel.setBackground(new Color(240, 248, 255));
		optionpanel.setLayout(new BoxLayout(optionpanel, BoxLayout.Y_AXIS));
		optionpanel.setBorder(null);
		sp2.setViewportView(optionpanel);
		
		save = new JButton("SAVE & NEXT");
		save.setFocusable(false);
		save.addActionListener(this);
		save.setFont(new Font("Segoe UI", Font.BOLD, 20));
		save.setForeground(new Color(0, 0, 0));
		save.setBackground(new Color(127, 255, 212));
		save.setBorder(null);
		save.setBounds(205, 594, 189, 50);
		contentPane.add(save);
		
		submit = new JButton("SUBMIT");
		submit.addActionListener(this);
		submit.setForeground(Color.BLACK);
		submit.setFont(new Font("Segoe UI", Font.BOLD, 20));
		submit.setFocusable(false);
		submit.setBorder(null);
		submit.setBackground(Color.YELLOW);
		submit.setBounds(449, 594, 189, 50);
		contentPane.add(submit);
		
		questionAtIndex(current1 ,next1);
	}
	public void questionAtIndex(int current1, int next1) {
		AttemptTest.current1=current1;
		AttemptTest.next1=next1;
		if(AttemptTest.next1==0) {
			previous.setEnabled(false);
		}
		else {
			previous.setEnabled(true);
		}
		if(AttemptTest.next1==q-1) {
			next.setEnabled(false);
		}
		else {
			next.setEnabled(true);
		}
		if(current1!=-1) {
			if(sq[current1].options.option1.isSelected()) {
				sq[current1].givenAnswer = sq[current1].options.option1.getText();
			}
			if(sq[current1].options.option2.isSelected()) {
				sq[current1].givenAnswer = sq[current1].options.option2.getText();
			}
			if(sq[current1].options.option3.isSelected()) {
				sq[current1].givenAnswer = sq[current1].options.option3.getText();
			}
			if(sq[current1].options.option4.isSelected()) {
				sq[current1].givenAnswer = sq[current1].options.option4.getText();
			}
			if(sq[current1].givenAnswer!=null) {
				sq[current1].Answered = true;
				b[current1].setBackground(Color.GREEN);
			}
			//checkAnswer(current1);
		}
		
		quesnum.setText("Question No. : "+(next1+1));
		question.setText(sq[AttemptTest.next1].question);
		
        Component[] components = optionpanel.getComponents();
		
		for(Component c : components)
		{
			if(c instanceof JRadioButton)
			{
				optionpanel.remove(c);
			}
		}
		optionpanel.add(sq[next1].options.option1);
		optionpanel.add(sq[next1].options.option2);
		optionpanel.add(sq[next1].options.option3);
		optionpanel.add(sq[next1].options.option4);
		
		optionpanel.repaint();
		optionpanel.revalidate();
		AttemptTest.current1 = next1;
		
		sq[next1].Visited = true;
		
		if(b[next1].getBackground()==Color.white)
		{
			b[next1].setBackground(Color.orange);
		}
	}
	
	public void checkAnswer(int i)
	{
		if(sq[i].givenAnswer.equals(sq[i].copt))
		{
			marks=marks+1;
		}
		System.out.println(sq[i].copt);
		System.out.println(sq[i].givenAnswer);
		System.out.println("Marks: "+marks);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==timer1) {
			if(hh==0&&mm==0&&ss==0) {
				timer1.stop();
				if(sq[current1].options.option1.isSelected()) {
					sq[current1].givenAnswer = sq[current1].options.option1.getText();
				}
				if(sq[current1].options.option2.isSelected()) {
					sq[current1].givenAnswer = sq[current1].options.option2.getText();
				}
				if(sq[current1].options.option3.isSelected()) {
					sq[current1].givenAnswer = sq[current1].options.option3.getText();
				}
				if(sq[current1].options.option4.isSelected()) {
					sq[current1].givenAnswer = sq[current1].options.option4.getText();
				}
				if(sq[current1].givenAnswer!=null) {
					sq[current1].Answered = true;
					b[current1].setBackground(Color.GREEN);
				}
				
				checkAnswer(current1);
				String jbdcURL = "jdbc:postgresql://localhost:5432/EMS";
				String username = "postgres";
				String password = "Oskadam7002";
				try {
					Connection connection = DriverManager.getConnection(jbdcURL,username,password);
					String sql = "INSERT INTO "+exams_student.ac+"results(Studentun,marksobtained,questionsattempted) VALUES (?,?,?)";
					PreparedStatement statement = connection.prepareStatement(sql);
					statement.setString(1, homepage.us);
					statement.setString(2, String.valueOf(marks));
					statement.setString(3, String.valueOf(marks));
					statement.executeUpdate();
					connection.close();
				}
				catch (SQLException e5) {
					e5.printStackTrace();
				}
				JOptionPane.showMessageDialog(AttemptTest.this, "Duration of the examination is over", "Time up!",JOptionPane.INFORMATION_MESSAGE);
				dispose();
				}
			else if(mm==0&&ss==0) {
				hh--;
				mm = 59;
				ss = 59;
			}
			else if (ss==0) {
				mm--;
				ss = 59;
			}
			else {
				ss--;
			}
			seconds_string = String.format("%02d", ss);
			minutes_string = String.format("%02d", mm);
			hours_string = String.format("%02d", hh);
			
			timer.setText(hours_string+":"+minutes_string+":"+seconds_string);
			timer.repaint();
			timer.revalidate();
		}
		else if(e.getSource()==next) {
			questionAtIndex(current1,current1+1);
		}
		else if(e.getSource()==previous) {
			questionAtIndex(current1,current1-1);
		}
		else if(e.getSource()==submit) {
			
			if(sq[current1].options.option1.isSelected()) {
				sq[current1].givenAnswer = sq[current1].options.option1.getText();
			}
			if(sq[current1].options.option2.isSelected()) {
				sq[current1].givenAnswer = sq[current1].options.option2.getText();
			}
			if(sq[current1].options.option3.isSelected()) {
				sq[current1].givenAnswer = sq[current1].options.option3.getText();
			}
			if(sq[current1].options.option4.isSelected()) {
				sq[current1].givenAnswer = sq[current1].options.option4.getText();
			}
			if(sq[current1].givenAnswer!=null) {
				sq[current1].Answered = true;
				b[current1].setBackground(Color.GREEN);
			}
			
			checkAnswer(current1);
			String jbdcURL = "jdbc:postgresql://localhost:5432/EMS";
			String username = "postgres";
			String password = "Oskadam7002";
			try {
				Connection connection = DriverManager.getConnection(jbdcURL,username,password);
				String sql = "INSERT INTO "+exams_student.ac+"results(Studentun,marksobtained,questionsattempted) VALUES (?,?,?)";
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, homepage.us);
				statement.setString(2, String.valueOf(marks));
				statement.setString(3, String.valueOf(marks));
				statement.executeUpdate();
				connection.close();
			}
			catch (SQLException e5) {
				e5.printStackTrace();
			}
			JOptionPane.showMessageDialog(AttemptTest.this, "Congratulations! Test submitted successfully", "Submit test",JOptionPane.INFORMATION_MESSAGE);
			dispose();
			
		}
		else if(e.getSource()==save) {
			if(sq[current1].options.option1.isSelected())
				sq[current1].givenAnswer = sq[current1].options.option1.getText();
		
			if(sq[current1].options.option2.isSelected())
				sq[current1].givenAnswer = sq[current1].options.option2.getText();
			
			if(sq[current1].options.option3.isSelected())
				sq[current1].givenAnswer = sq[current1].options.option3.getText();
		
			if(sq[current1].options.option4.isSelected())
				sq[current1].givenAnswer = sq[current1].options.option4.getText();
			
			if(sq[current1].givenAnswer!=null)
			{
				sq[current1].Answered = true;
				b[current1].setBackground(Color.green);
						
			}
			
			checkAnswer(current1);
			
			questionAtIndex(current1,current1+1);
		}
		else {
			for(int i=0;i<q;i++)
			{
				if(e.getSource()==b[i])
				{
					next1 = i;
					questionAtIndex(current1, next1);
				}
			}
		}
	}
}