package start;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

@SuppressWarnings("serial")
public class registration extends JFrame {

	public JPanel contentPane, panel;
	public JLabel background, pic, header, header2, name, cn, eid, college, un, pt, p, cp, rollno;
	public JButton log, reg;
	public JTextField t1,t2,t3,t4,t5;
	public JPasswordField t6,t7;
	static String pt1 = "0";
	static String us;
	@SuppressWarnings("rawtypes")
	JComboBox comboBox;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registration frame = new registration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public registration() {
		setTitle("Registration");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Omkar Kadam\\Desktop\\New folder\\icons8-test-passed-96.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1150, 600);
		contentPane = new JPanel();
		contentPane.setFocusable(false);
		contentPane.setBackground(new Color(0, 0, 128));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel.setBackground(new Color(240, 255, 255));
		panel.setBounds(565, 28, 561, 497);
		contentPane.add(panel);
		panel.setLayout(null);
		
		header2 = new JLabel(" Create An Account...\r\n");
		header2.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 25));
		header2.setHorizontalAlignment(SwingConstants.LEFT);
		header2.setBounds(10, 11, 541, 65);
		panel.add(header2);
		
		name = new JLabel("Name:");
		name.setBackground(new Color(255, 255, 255));
		name.setFont(new Font("Segoe UI", Font.BOLD, 15));
		name.setHorizontalAlignment(SwingConstants.TRAILING);
		name.setBounds(10, 95, 130, 25);
		panel.add(name);
		
		cn = new JLabel("Contact No:");
		cn.setHorizontalAlignment(SwingConstants.TRAILING);
		cn.setFont(new Font("Segoe UI", Font.BOLD, 15));
		cn.setBackground(Color.WHITE);
		cn.setBounds(10, 135, 130, 25);
		panel.add(cn);
		
		eid = new JLabel("Email Id:");
		eid.setHorizontalAlignment(SwingConstants.TRAILING);
		eid.setFont(new Font("Segoe UI", Font.BOLD, 15));
		eid.setBackground(Color.WHITE);
		eid.setBounds(10, 175, 130, 25);
		panel.add(eid);
		
		college = new JLabel("College:");
		college.setHorizontalAlignment(SwingConstants.TRAILING);
		college.setFont(new Font("Segoe UI", Font.BOLD, 15));
		college.setBackground(Color.WHITE);
		college.setBounds(10, 215, 125, 25);
		panel.add(college);
		
		un = new JLabel("Username:");
		un.setHorizontalAlignment(SwingConstants.TRAILING);
		un.setFont(new Font("Segoe UI", Font.BOLD, 15));
		un.setBackground(Color.WHITE);
		un.setBounds(10, 255, 130, 25);
		panel.add(un);
		
		pt = new JLabel("Profile-Type:");
		pt.setHorizontalAlignment(SwingConstants.TRAILING);
		pt.setFont(new Font("Segoe UI", Font.BOLD, 15));
		pt.setBackground(Color.WHITE);
		pt.setBounds(10, 295, 130, 25);
		panel.add(pt);
		
		p = new JLabel("Password:");
		p.setHorizontalAlignment(SwingConstants.TRAILING);
		p.setFont(new Font("Segoe UI", Font.BOLD, 15));
		p.setBackground(Color.WHITE);
		p.setBounds(10, 335, 130, 25);
		panel.add(p);
		
		cp = new JLabel("Confirm Password:");
		cp.setHorizontalAlignment(SwingConstants.LEADING);
		cp.setFont(new Font("Segoe UI", Font.BOLD, 15));
		cp.setBackground(Color.WHITE);
		cp.setBounds(5, 375, 135, 25);
		panel.add(cp);
		
		reg = new JButton("Sign - Up");
		reg.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String jbdcURL = "jdbc:postgresql://localhost:5432/EMS";
				String username = "postgres";
				String password = "Oskadam7002";
				try {
				Connection connection = DriverManager.getConnection(jbdcURL,username,password);
				String sql = "INSERT INTO registration (_name_, contact_no_, email_id, college, username, profiletype, _password_, _confirmpassword_ )"
				+"VALUES(?,?,?,?,?,?,?,?)";
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, t1.getText());
				statement.setString(2, t2.getText());
				statement.setString(3, t3.getText());
				statement.setString(4, t4.getText());
				statement.setString(5, t5.getText());
				statement.setString(6, comboBox.getSelectedItem().toString());
				statement.setString(7, t6.getText());
				statement.setString(8, t7.getText());
				pt1 = comboBox.getSelectedItem().toString();
				us = t5.getText(); 
				statement.executeUpdate();
				JOptionPane.showMessageDialog(null, "You Have Registered Successfully!!");
				connection.close();
				t1.setText(null);
				t2.setText(null);
				t3.setText(null);
				t4.setText(null);
				t5.setText(null);
				t6.setText(null);
				t7.setText(null);
				comboBox.setSelectedIndex(0);
				homepage h = new homepage(us);
				h.setVisible(true);
				dispose();
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "Error in Registration!!!\nUsername might have already been taken.");
				e1.printStackTrace();
			}
			}
		});
		panel.add(reg);
		reg.setFont(new Font("Segoe UI", Font.BOLD, 20));
		reg.setForeground(new Color(255, 255, 255));
		reg.setFocusable(false);
		reg.setBorder(null);
		reg.setBackground(new Color(0, 0, 128));
		reg.setBounds(190, 429, 200, 45);
		
		t1 = new JTextField();
		t1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 128)));
		t1.setBounds(168, 95, 380, 25);
		t1.setOpaque(false);
		panel.add(t1);
		
		t2 = new JTextField();
		t2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 128)));
		t2.setBounds(168, 135, 383, 25);
		t2.setOpaque(false);
		panel.add(t2);
		
		t3 = new JTextField();
		t3.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 128)));
		t3.setBounds(168, 175, 380, 25);
		t3.setOpaque(false);
		panel.add(t3);
		
		t4 = new JTextField();
		t4.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 128)));
		t4.setBounds(168, 215, 380, 25);
		t4.setOpaque(false);
		panel.add(t4);
		
		t5 = new JTextField();
		t5.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 128)));
		t5.setBounds(168, 255, 380, 25);
		t5.setOpaque(false);
		panel.add(t5);
		
		String[] profile1 = {"Select", "Student", "Teacher"}; 
		comboBox = new JComboBox(profile1);
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setBorder(null);
		comboBox.setBounds(168, 295, 380, 29);
		panel.add(comboBox);
		
		t6 = new JPasswordField();
		t6.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 128)));
		t6.setBounds(168, 335, 380, 25);
		t6.setOpaque(false);
		panel.add(t6);
		
		t7 = new JPasswordField();
		t7.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 128)));
		t7.setBounds(168, 375, 380, 25);
		t7.setOpaque(false);
		panel.add(t7);
		
		pic = new JLabel("");
		pic.setIcon(new ImageIcon("C:\\Users\\Omkar Kadam\\Desktop\\New folder\\NicePng_exam-png_745198.png"));
		pic.setBounds(100, 130, 382, 336);
		contentPane.add(pic);
		
	    log = new JButton("Already Have an Account ? Log In!");
	    log.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		login l = new login();
	    		l.setVisible(true);
	    		dispose();
	    	}
	    });
		log.setFocusable(false);
		log.setRequestFocusEnabled(false);
		log.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 15));
		log.setForeground(new Color(255, 255, 255));
		log.setBorder(null);
		log.setBackground(new Color(0, 0, 128));
		log.setBounds(135, 487, 276, 65);
		contentPane.add(log);
		
		header = new JLabel("Welcome  to  GradeX");
		header.setHorizontalTextPosition(SwingConstants.LEADING);
		header.setIcon(new ImageIcon("C:\\Users\\Omkar Kadam\\Desktop\\New folder\\logo.png"));
		header.setForeground(new Color(255, 255, 255));
		header.setFont(new Font("Segoe UI", Font.BOLD, 35));
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setBounds(10, 11, 510, 89);
		contentPane.add(header);

	}
}
