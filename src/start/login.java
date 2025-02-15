package start;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.*;
import javax.swing.border.*;


@SuppressWarnings("serial")
public class login extends JFrame {

	public JPanel contentPane, panel, panel1, panel2;
	public JLabel loghead, username,Password, ResetPassword, lbl1, lbl2, lbl3, lbl4, lbl5;
	public JPasswordField t2;
	public JTextField t1;
	public JButton fp,login,reg, SendCode, Verify, Reset, btnDone;
	public JTextField t3, t4;
	public JPasswordField t5, t6;
	public static String pt="0";
	public static String username1;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings("deprecation")
	public login() {
		
		Random random = new Random();
		int rc = random.nextInt(999999);
		
		setTitle("Login");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Omkar Kadam\\Desktop\\New folder\\icons8-test-passed-96.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1150, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 128));
		contentPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(44, 25, 464, 515);
		contentPane.add(panel);
		panel.setLayout(null);
		
		loghead = new JLabel("LOGIN\r\n");
		loghead.setFont(new Font("Segoe UI", Font.BOLD, 20));
		loghead.setHorizontalAlignment(SwingConstants.CENTER);
		loghead.setBounds(140, 11, 142, 44);
		panel.add(loghead);
		
		username = new JLabel("Username:");
		username.setIcon(new ImageIcon("C:\\Users\\Omkar Kadam\\Downloads\\icons8-username-50.png"));
		username.setFont(new Font("Segoe UI", Font.BOLD, 15));
		username.setForeground(new Color(0, 0, 0));
		username.setBounds(7, 57, 142, 37);
		panel.add(username);
		
		t1 = new JTextField();
		t1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 128)));
		t1.setBounds(10, 105, 444, 37);
		panel.add(t1);
		t1.setColumns(10);
		
		Password = new JLabel("Password:");
		Password.setHorizontalAlignment(SwingConstants.LEFT);
		Password.setIcon(new ImageIcon("C:\\Users\\Omkar Kadam\\Downloads\\icons8-password-60.png"));
		Password.setForeground(Color.BLACK);
		Password.setFont(new Font("Segoe UI", Font.BOLD, 15));
		Password.setBounds(0, 153, 142, 60);
		panel.add(Password);
		
		t2 = new JPasswordField();
		t2.setColumns(10);
		t2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 128)));
		t2.setBounds(10, 224, 444, 37);
		panel.add(t2);
		
	    fp = new JButton("Forgot Password?");
	    fp.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		panel1.setVisible(true);
	    		panel2.setVisible(true);
	    	}
	    });
		fp.setFont(new Font("Segoe UI", Font.ITALIC, 15));
		fp.setFocusable(false);
		fp.setBackground(new Color(255, 255, 255));
		fp.setBorder(null);
		fp.setBounds(10, 272, 139, 30);
		panel.add(fp);
		
		login = new JButton("Log In");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				String jbdcURL = "jdbc:postgresql://localhost:5432/EMS";
				String username = "postgres";
				String password = "Oskadam7002";
				try {
					Connection connection = DriverManager.getConnection(jbdcURL,username,password);
					username1 = t1.getText();
				    String password1 = t2.getText();
					String sql = "SELECT username, _password_, profiletype FROM registration where username = ? and _password_ = ?";
					PreparedStatement statement = connection.prepareStatement(sql);
					statement.setString(1, username1);
					statement.setString(2, password1);
					 ResultSet rs = statement.executeQuery();
	                    if (rs.next()) {
	                        JOptionPane.showMessageDialog(null, "You have successfully logged in");
	                        pt = rs.getString("profiletype");
	                        homepage h = new homepage(username1);
	                        h.setVisible(true);
	                        dispose();
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Wrong Username or Password");
	                    }
					connection.close();
					t1.setText(null);
					t2.setText(null);
			}
			 catch (SQLException e1) {
					System.out.println("Error while logging in");
					e1.printStackTrace();
				}
			}
		});
		login.setFocusable(false);
		login.setBackground(new Color(0, 0, 128));
		login.setBorder(null);
		login.setFont(new Font("Segoe UI", Font.BOLD, 15));
		login.setForeground(new Color(255, 255, 255));
		login.setBounds(140, 333, 142, 44);
		panel.add(login);
		
		reg = new JButton("Don't have an Account? Create One!");
		reg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registration r = new registration();
				r.setVisible(true);
				dispose();
			}
		});
		reg.setFocusable(false);
		reg.setBorder(null);
		reg.setBackground(new Color(255, 255, 255));
		reg.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		reg.setBounds(63, 421, 309, 30);
		panel.add(reg);
		
		panel1 = new JPanel();
		panel1.setBackground(new Color(255, 255, 255));
		panel1.setBounds(572, 40, 10, 474);
		contentPane.add(panel1);
		panel1.setVisible(false);
		
		panel2 = new JPanel();
		panel2.setBackground(new Color(255, 255, 255));
		panel2.setBounds(638, 25, 464, 515);
		contentPane.add(panel2);
		panel2.setLayout(null);
		
		ResetPassword = new JLabel("Reset Password:");
		ResetPassword.setHorizontalAlignment(SwingConstants.CENTER);
		ResetPassword.setFont(new Font("Segoe UI", Font.BOLD, 20));
		ResetPassword.setBounds(142, 11, 186, 44);
		panel2.add(ResetPassword);
		
		lbl1 = new JLabel("To Reset your Password, first enter the registered Email Id");
		lbl1.setBorder(null);
		lbl1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lbl1.setBounds(10, 59, 433, 30);
		panel2.add(lbl1);
		
		t3 = new JTextField();
		t3.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		t3.setBounds(10, 97, 433, 30);
		panel2.add(t3);
		t3.setColumns(10);
		
		SendCode = new JButton("Send Code\r\n");
		SendCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					send_email.send_mail(t3.getText(), rc);
					JOptionPane.showMessageDialog(null, "Message Sent Successfully!");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		SendCode.setForeground(Color.WHITE);
		SendCode.setFont(new Font("Segoe UI", Font.BOLD, 15));
		SendCode.setFocusable(false);
		SendCode.setBorder(null);
		SendCode.setBackground(new Color(0, 0, 128));
		SendCode.setBounds(10, 136, 107, 30);
		panel2.add(SendCode);
		
		lbl2 = new JLabel("Enter the Received OTP Below,");
		lbl2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lbl2.setBorder(null);
		lbl2.setBounds(10, 177, 433, 30);
		panel2.add(lbl2);
		
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		t4.setBounds(10, 218, 433, 30);
		panel2.add(t4);
		
		Verify = new JButton("Verify");
		Verify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Integer.valueOf(t4.getText())==rc) {
					JOptionPane.showMessageDialog(null, "Code has been Verified Successfully!");
					t5.enable();
					t6.enable();
				}
				else {
					JOptionPane.showMessageDialog(null, "Entered Code is Wrong\n Please Enter Again!");
				}
			}
		});
		Verify.setForeground(Color.WHITE);
		Verify.setFont(new Font("Segoe UI", Font.BOLD, 15));
		Verify.setFocusable(false);
		Verify.setBorder(null);
		Verify.setBackground(new Color(0, 0, 128));
		Verify.setBounds(10, 259, 107, 30);
		panel2.add(Verify);
		
		lbl3 = new JLabel("Change Password:");
		lbl3.setFont(new Font("Segoe UI", Font.ITALIC, 15));
		lbl3.setBounds(10, 288, 134, 30);
		panel2.add(lbl3);
		
		lbl4 = new JLabel("Enter the New Password");
		lbl4.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lbl4.setBorder(null);
		lbl4.setBounds(10, 314, 433, 30);
		panel2.add(lbl4);
		
		t5 = new JPasswordField();
		t5.setColumns(10);
		t5.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		t5.setBounds(10, 351, 433, 30);
		panel2.add(t5);
		t5.disable();
		
		lbl5 = new JLabel("Confirm Password:");
		lbl5.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lbl5.setBorder(null);
		lbl5.setBounds(10, 386, 433, 30);
		panel2.add(lbl5);
		
		t6 = new JPasswordField();
		t6.setColumns(10);
		t6.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		t6.setBounds(10, 422, 433, 30);
		panel2.add(t6);
		t6.disable();
		
		Reset = new JButton("Reset\r\n");
		Reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String jbdcURL = "jdbc:postgresql://localhost:5432/EMS";
				String username = "postgres";
				String password = "Oskadam7002";
				try {
					Connection connection = DriverManager.getConnection(jbdcURL,username,password);
					String sql = "UPDATE registration SET _password_ = ?, _confirmpassword_ = ? WHERE email_id = ?";
					PreparedStatement statement = connection.prepareStatement(sql);
					statement.setString(1, t5.getText());
					statement.setString(2, t6.getText());
					statement.setString(3, t3.getText());
					statement.executeUpdate();
					JOptionPane.showMessageDialog(null, "Password Reset Successful!");
					connection.close();
					t3.setText(null);
					t4.setText(null);
					t5.setText(null);
					t6.setText(null);
			}
				 catch (SQLException e1) {
						e1.printStackTrace();
					}
			}
		});
		Reset.setForeground(Color.WHITE);
		Reset.setFont(new Font("Segoe UI", Font.BOLD, 15));
		Reset.setFocusable(false);
		Reset.setBorder(null);
		Reset.setBackground(new Color(0, 0, 128));
		Reset.setBounds(10, 463, 107, 30);
		panel2.add(Reset);
		
		btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel1.setVisible(false);
				panel2.setVisible(false);
			}
		});
		btnDone.setForeground(Color.WHITE);
		btnDone.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnDone.setFocusable(false);
		btnDone.setBorder(null);
		btnDone.setBackground(new Color(0, 0, 128));
		btnDone.setBounds(347, 463, 107, 30);
		panel2.add(btnDone);
		panel2.setVisible(false);
		
	}
}
class send_email {
	public static void send_mail(String recepient, int rc) throws Exception {
		Properties p1 = new Properties();
		p1.put("mail.smtp.auth", "true");
		p1.put("mail.smtp.starttls.enable", "true");
		p1.put("mail.smtp.host", "smtp.gmail.com");
		p1.put("mail.smtp.port", "587");
		String acc1 = "abcbacbc8@gmail.com";
		String pass1 = "bcaa8489";
		Session s1 = Session.getInstance(p1, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(acc1, pass1);
				}
		});
		Message message = prepareMessage(s1, acc1, recepient, rc);
		Transport.send(message);
	}

	private static Message prepareMessage(Session s1, String acc1, String recepient, int rc) {
		try {
			int randomcode = rc;
			Message message = new MimeMessage(s1);
			message.setFrom(new InternetAddress(acc1));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
			message.setSubject("Verfication Code to Change Password.");
			message.setText("Your Reset Code is "+randomcode);
			message.saveChanges();
			return message;
		} catch (Exception ex) {
			Logger.getLogger(send_email.class.getName()).log(Level.SEVERE, null, ex);
		} 
		return null;
	}
}

