package start;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;

@SuppressWarnings("serial")
public class acc_teacher extends JFrame {

	public JPanel contentPane, panel_1, panel_2;
	public JButton Done,Edit,Close;
	public JPanel panel;
	public JLabel header,namedisp1,contactdisp1,tiddisp1,eiddisp1,colldisp1,undisp1,deptdisp1,subdisp1,ptdisp1;
	public JLabel nameedit,contactedit,eidedit, colledit, unedit,t_idedit,deptedit,subedit,ptedit;
	public JTextField ntf,ctf,eidtf,cntf,untf,tidtf,depttf,subtf;
	public static String n,c,e1,c1,u1,r,bd,se;
	public JLabel namedisp2,contactdisp2,eiddisp2,colldisp2,undisp2,tiddisp2,deptdisp2,subdisp2,lblTeacher;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					acc_teacher frame = new acc_teacher();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public acc_teacher() {
		setTitle("Teacher Account details");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Omkar Kadam\\Desktop\\New folder\\icons8-test-passed-96.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1150, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(25, 25, 112));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String jbdcURL = "jdbc:postgresql://localhost:5432/EMS";
		String username = "postgres";
		String password = "Oskadam7002";
		try {
			Connection connection = DriverManager.getConnection(jbdcURL,username,password);
			String sql1 = "SELECT _name_, contact_no_, email_id, college, username, t_id, dept, sem FROM registration WHERE username ='"+homepage.us+"'";
			PreparedStatement statement = connection.prepareStatement(sql1);
			 ResultSet rs = statement.executeQuery();
			 while(rs.next()) {
				 n = rs.getString("_name_");
				 c = rs.getString("contact_no_");
				 e1 = rs.getString("email_id");
				 c1 = rs.getString("college");
				 u1 = rs.getString("username");
				 r = rs.getString("t_id");
				 bd = rs.getString("dept");
				 se = rs.getString("sem");
			 }
			 connection.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		panel = new JPanel();
		panel.setBackground(new Color(224, 255, 255));
		panel.setBounds(10, 11, 503, 541);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Edit = new JButton("EDIT");
		Edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(true);
				panel_2.setVisible(true);
			}
		});
		Edit.setFocusable(false);
		Edit.setBorder(null);
		Edit.setBackground(new Color(0, 0, 139));
		Edit.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 25));
		Edit.setForeground(new Color(255, 255, 255));
		Edit.setBounds(26, 487, 192, 43);
		panel.add(Edit);
		
		Close = new JButton("CLOSE");
		Close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		Close.setForeground(Color.WHITE);
		Close.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 25));
		Close.setFocusable(false);
		Close.setBorder(null);
		Close.setBackground(new Color(0, 0, 139));
		Close.setBounds(255, 487, 192, 43);
		panel.add(Close);
		
		header = new JLabel("Account");
		header.setIcon(new ImageIcon("C:\\Users\\Omkar Kadam\\Desktop\\New folder\\account.png"));
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setFont(new Font("Algerian", Font.ITALIC, 30));
		header.setBounds(132, 0, 226, 64);
		panel.add(header);
		
		namedisp1 = new JLabel(" Name : ");
		namedisp1.setHorizontalAlignment(SwingConstants.TRAILING);
		namedisp1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		namedisp1.setBounds(10, 56, 142, 35);
		panel.add(namedisp1);
		
		contactdisp1 = new JLabel(" Contact : ");
		contactdisp1.setHorizontalAlignment(SwingConstants.TRAILING);
		contactdisp1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		contactdisp1.setBounds(10, 102, 142, 35);
		panel.add(contactdisp1);
		
		tiddisp1 = new JLabel(" Teacher ID : ");
		tiddisp1.setHorizontalAlignment(SwingConstants.TRAILING);
		tiddisp1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		tiddisp1.setBounds(10, 286, 142, 35);
		panel.add(tiddisp1);
		
		eiddisp1 = new JLabel(" Email ID : ");
		eiddisp1.setHorizontalAlignment(SwingConstants.TRAILING);
		eiddisp1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		eiddisp1.setBounds(10, 148, 142, 35);
		panel.add(eiddisp1);
		
		colldisp1 = new JLabel(" College Name : ");
		colldisp1.setHorizontalAlignment(SwingConstants.TRAILING);
		colldisp1.setBounds(10, 194, 142, 35);
		colldisp1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		panel.add(colldisp1);
		
		undisp1 = new JLabel(" Username : ");
		undisp1.setHorizontalAlignment(SwingConstants.TRAILING);
		undisp1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		undisp1.setBounds(10, 240, 142, 35);
		panel.add(undisp1);
		
		deptdisp1 = new JLabel(" Department : ");
		deptdisp1.setHorizontalAlignment(SwingConstants.TRAILING);
		deptdisp1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		deptdisp1.setBounds(10, 332, 142, 35);
		panel.add(deptdisp1);
		
		subdisp1 = new JLabel(" Subject : ");
		subdisp1.setHorizontalAlignment(SwingConstants.TRAILING);
		subdisp1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		subdisp1.setBounds(10, 378, 142, 35);
		panel.add(subdisp1);
		
		ptdisp1 = new JLabel(" Profile - Type : ");
		ptdisp1.setHorizontalAlignment(SwingConstants.TRAILING);
		ptdisp1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		ptdisp1.setBounds(10, 424, 142, 35);
		panel.add(ptdisp1);
		
		namedisp2 = new JLabel(n);
		namedisp2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		namedisp2.setHorizontalAlignment(SwingConstants.CENTER);
		namedisp2.setBounds(162, 56, 331, 35);
		panel.add(namedisp2);
		
		contactdisp2 = new JLabel(c);
		contactdisp2.setHorizontalAlignment(SwingConstants.CENTER);
		contactdisp2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		contactdisp2.setBounds(162, 102, 331, 35);
		panel.add(contactdisp2);
		
		eiddisp2 = new JLabel(e1);
		eiddisp2.setHorizontalAlignment(SwingConstants.CENTER);
		eiddisp2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		eiddisp2.setBounds(162, 148, 331, 35);
		panel.add(eiddisp2);
		
		colldisp2 = new JLabel(c1);
		colldisp2.setHorizontalAlignment(SwingConstants.CENTER);
		colldisp2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		colldisp2.setBounds(162, 194, 331, 35);
		panel.add(colldisp2);
		
		undisp2 = new JLabel(u1);
		undisp2.setHorizontalAlignment(SwingConstants.CENTER);
		undisp2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		undisp2.setBounds(162, 240, 331, 35);
		panel.add(undisp2);
		
		tiddisp2 = new JLabel(r);
		tiddisp2.setHorizontalAlignment(SwingConstants.CENTER);
		tiddisp2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		tiddisp2.setBounds(162, 286, 331, 35);
		panel.add(tiddisp2);
		
		deptdisp2 = new JLabel(bd);
		deptdisp2.setHorizontalAlignment(SwingConstants.CENTER);
		deptdisp2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		deptdisp2.setBounds(162, 332, 331, 35);
		panel.add(deptdisp2);
		
		subdisp2 = new JLabel(se);
		subdisp2.setHorizontalAlignment(SwingConstants.CENTER);
		subdisp2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		subdisp2.setBounds(162, 378, 331, 35);
		panel.add(subdisp2);
		
		lblTeacher = new JLabel("Teacher");
		lblTeacher.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeacher.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblTeacher.setBounds(162, 424, 331, 35);
		panel.add(lblTeacher);
		
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(224, 255, 255));
		panel_1.setBounds(623, 11, 503, 541);
		panel_1.setVisible(false);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		Done = new JButton("DONE");
		Done.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String jbdcURL = "jdbc:postgresql://localhost:5432/EMS";
				String username = "postgres";
				String password = "Oskadam7002";
				try {
					Connection connection = DriverManager.getConnection(jbdcURL,username,password);
					String sql = "UPDATE registration SET _name_='"+ntf.getText()+"', contact_no_='"+ctf.getText()+"', email_id ='"+
							eidtf.getText()+"', college='"+cntf.getText()+"', username='"+untf.getText()+"', t_id='"+
							tidtf.getText()+"', dept='"+depttf.getText()+"', sem='"+subtf.getText()+"' WHERE username='"+homepage.us+"'";
					PreparedStatement statement = connection.prepareStatement(sql);
					statement.executeUpdate();
					JOptionPane.showMessageDialog(null, "Profile Updated Successfully!!");
					panel_2.setVisible(false);
					panel_1.setVisible(false);
					 connection.close();
				}
				catch(SQLException e2) {
					e2.printStackTrace();
				}
			}
		});
		Done.setForeground(Color.WHITE);
		Done.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 25));
		Done.setFocusable(false);
		Done.setBorder(null);
		Done.setBackground(new Color(0, 0, 139));
		Done.setBounds(169, 487, 192, 43);
		panel_1.add(Done);
		
		nameedit = new JLabel(" Name : ");
		nameedit.setHorizontalAlignment(SwingConstants.TRAILING);
		nameedit.setFont(new Font("Segoe UI", Font.BOLD, 18));
		nameedit.setBounds(10, 52, 139, 35);
		panel_1.add(nameedit);
		
		contactedit = new JLabel(" Contact : ");
		contactedit.setHorizontalAlignment(SwingConstants.TRAILING);
		contactedit.setFont(new Font("Segoe UI", Font.BOLD, 18));
		contactedit.setBounds(10, 98, 139, 35);
		panel_1.add(contactedit);
		
		eidedit = new JLabel(" Email ID : ");
		eidedit.setHorizontalAlignment(SwingConstants.TRAILING);
		eidedit.setFont(new Font("Segoe UI", Font.BOLD, 18));
		eidedit.setBounds(10, 144, 139, 35);
		panel_1.add(eidedit);
		
		colledit = new JLabel(" College Name : ");
		colledit.setHorizontalAlignment(SwingConstants.TRAILING);
		colledit.setFont(new Font("Segoe UI", Font.BOLD, 18));
		colledit.setBounds(10, 190, 139, 35);
		panel_1.add(colledit);
		
		unedit = new JLabel(" Username : ");
		unedit.setHorizontalAlignment(SwingConstants.TRAILING);
		unedit.setFont(new Font("Segoe UI", Font.BOLD, 18));
		unedit.setBounds(10, 236, 139, 35);
		panel_1.add(unedit);
		
		t_idedit = new JLabel(" Teacher ID  : ");
		t_idedit.setHorizontalAlignment(SwingConstants.TRAILING);
		t_idedit.setFont(new Font("Segoe UI", Font.BOLD, 18));
		t_idedit.setBounds(10, 282, 139, 35);
		panel_1.add(t_idedit);
		
		deptedit = new JLabel(" Department : ");
		deptedit.setHorizontalAlignment(SwingConstants.TRAILING);
		deptedit.setFont(new Font("Segoe UI", Font.BOLD, 18));
		deptedit.setBounds(10, 328, 139, 35);
		panel_1.add(deptedit);
		
		subedit = new JLabel("Subject :");
		subedit.setHorizontalAlignment(SwingConstants.TRAILING);
		subedit.setFont(new Font("Segoe UI", Font.BOLD, 18));
		subedit.setBounds(10, 374, 139, 35);
		panel_1.add(subedit);
		
		ptedit = new JLabel("   Profile - Type :   Teacher");
		ptedit.setFont(new Font("Segoe UI", Font.BOLD, 18));
		ptedit.setBounds(10, 420, 483, 35);
		panel_1.add(ptedit);
		
		ntf = new JTextField();
		ntf.setText(n);
		ntf.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		ntf.setOpaque(false);
		ntf.setBounds(169, 52, 324, 35);
		panel_1.add(ntf);
		ntf.setColumns(10);
		
		ctf = new JTextField();
		ctf.setText(c);
		ctf.setOpaque(false);
		ctf.setColumns(10);
		ctf.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		ctf.setBounds(169, 98, 324, 35);
		panel_1.add(ctf);
		
		eidtf = new JTextField();
		eidtf.setText(e1);
		eidtf.setOpaque(false);
		eidtf.setColumns(10);
		eidtf.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		eidtf.setBounds(169, 144, 324, 35);
		panel_1.add(eidtf);
		
		cntf = new JTextField();
		cntf.setText(c1);
		cntf.setOpaque(false);
		cntf.setColumns(10);
		cntf.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		cntf.setBounds(169, 190, 324, 35);
		panel_1.add(cntf);
		
		untf = new JTextField();
		untf.setText(u1);
		untf.setOpaque(false);
		untf.setColumns(10);
		untf.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		untf.setBounds(169, 236, 324, 35);
		panel_1.add(untf);
		
		tidtf = new JTextField();
		tidtf.setText(r);
		tidtf.setOpaque(false);
		tidtf.setColumns(10);
		tidtf.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		tidtf.setBounds(169, 282, 324, 35);
		panel_1.add(tidtf);
		
		depttf = new JTextField();
		depttf.setText(bd);
		depttf.setOpaque(false);
		depttf.setColumns(10);
		depttf.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		depttf.setBounds(169, 328, 324, 35);
		panel_1.add(depttf);
		
		subtf = new JTextField();
		subtf.setText(se);
		subtf.setOpaque(false);
		subtf.setColumns(10);
		subtf.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		subtf.setBounds(169, 374, 324, 35);
		panel_1.add(subtf);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(240, 248, 255));
		panel_2.setBounds(550, 11, 31, 541);
		panel_2.setVisible(false);
		contentPane.add(panel_2);
	}
}
