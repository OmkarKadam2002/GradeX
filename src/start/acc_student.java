package start;

import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;

@SuppressWarnings("serial")
public class acc_student extends JFrame {

	public JPanel contentPane, panel_1, panel_2;
	public JButton Done,Edit,Close;
	private JPanel panel;
	public JLabel header,namedisplay1,contactdisplay1,rndisp1, eiddisp1,colldisp1,undisp1,bddisp1,semdisp1;
	public JLabel ptdisp1,nameedit1,contactedit1,eidedit,colledit1,unedit,rnedit,bdedit,semedit,ptedit;
	public JTextField nametf,contacttf,eidtf,colltf,untf,rntf,bdtf,semtf;
	public static String n,c,e1,c1,u1,r,bd,se;
	public JLabel namedisplay2,contactdisplay2,eiddisp2, colldisp2,undisp2,rndisp2,bddisp2,semdisp2,ptdisp2;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					acc_student frame = new acc_student();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public acc_student() {
		setTitle("Student Account details");
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
			String sql1 = "SELECT _name_, contact_no_, email_id, college, username, rollno, bd, sem FROM registration WHERE username ='"+homepage.us+"'";
			PreparedStatement statement = connection.prepareStatement(sql1);
			 ResultSet rs = statement.executeQuery();
			 while(rs.next()) {
				 n = rs.getString("_name_");
				 c = rs.getString("contact_no_");
				 e1 = rs.getString("email_id");
				 c1 = rs.getString("college");
				 u1 = rs.getString("username");
				 r = rs.getString("rollno");
				 bd = rs.getString("bd");
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
		
		namedisplay1 = new JLabel("Name : ");
		namedisplay1.setHorizontalAlignment(SwingConstants.TRAILING);
		namedisplay1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		namedisplay1.setBounds(26, 56, 138, 35);
		panel.add(namedisplay1);
		
		contactdisplay1 = new JLabel("Contact : ");
		contactdisplay1.setHorizontalAlignment(SwingConstants.TRAILING);
		contactdisplay1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		contactdisplay1.setBounds(25, 102, 138, 35);
		panel.add(contactdisplay1);
		
		rndisp1 = new JLabel("Roll. No. : ");
		rndisp1.setHorizontalAlignment(SwingConstants.TRAILING);
		rndisp1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		rndisp1.setBounds(26, 286, 137, 35);
		panel.add(rndisp1);
		
		eiddisp1 = new JLabel("Email ID : ");
		eiddisp1.setHorizontalAlignment(SwingConstants.TRAILING);
		eiddisp1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		eiddisp1.setBounds(26, 148, 137, 35);
		panel.add(eiddisp1);
		
		colldisp1 = new JLabel("College Name : ");
		colldisp1.setHorizontalAlignment(SwingConstants.TRAILING);
		colldisp1.setBounds(26, 194, 137, 35);
		colldisp1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		panel.add(colldisp1);
		
		undisp1 = new JLabel("Username : ");
		undisp1.setHorizontalAlignment(SwingConstants.TRAILING);
		undisp1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		undisp1.setBounds(26, 240, 137, 35);
		panel.add(undisp1);
		
		bddisp1 = new JLabel("Branch/Div : ");
		bddisp1.setHorizontalAlignment(SwingConstants.TRAILING);
		bddisp1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		bddisp1.setBounds(26, 332, 137, 35);
		panel.add(bddisp1);
		
		semdisp1 = new JLabel("Semester : ");
		semdisp1.setHorizontalAlignment(SwingConstants.TRAILING);
		semdisp1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		semdisp1.setBounds(26, 378, 137, 35);
		panel.add(semdisp1);
		
		ptdisp1 = new JLabel("Profile - Type : ");
		ptdisp1.setHorizontalAlignment(SwingConstants.TRAILING);
		ptdisp1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		ptdisp1.setBounds(26, 424, 137, 35);
		panel.add(ptdisp1);
		
		namedisplay2 = new JLabel(n);
		namedisplay2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		namedisplay2.setHorizontalAlignment(SwingConstants.CENTER);
		namedisplay2.setBounds(174, 56, 319, 35);
		panel.add(namedisplay2);
		
		contactdisplay2 = new JLabel(c);
		contactdisplay2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		contactdisplay2.setHorizontalAlignment(SwingConstants.CENTER);
		contactdisplay2.setBounds(173, 102, 319, 35);
		panel.add(contactdisplay2);
		
		eiddisp2 = new JLabel(e1);
		eiddisp2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		eiddisp2.setHorizontalAlignment(SwingConstants.CENTER);
		eiddisp2.setBounds(173, 148, 319, 35);
		panel.add(eiddisp2);
		
		colldisp2 = new JLabel(c1);
		colldisp2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		colldisp2.setHorizontalAlignment(SwingConstants.CENTER);
		colldisp2.setBounds(174, 194, 319, 35);
		panel.add(colldisp2);
		
		undisp2 = new JLabel(u1);
		undisp2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		undisp2.setHorizontalAlignment(SwingConstants.CENTER);
		undisp2.setBounds(173, 240, 319, 35);
		panel.add(undisp2);
		
		rndisp2 = new JLabel(r);
		rndisp2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		rndisp2.setHorizontalAlignment(SwingConstants.CENTER);
		rndisp2.setBounds(174, 286, 319, 35);
		panel.add(rndisp2);
		
		bddisp2 = new JLabel(bd);
		bddisp2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		bddisp2.setHorizontalAlignment(SwingConstants.CENTER);
		bddisp2.setBounds(173, 332, 319, 35);
		panel.add(bddisp2);
		
		semdisp2 = new JLabel(se);
		semdisp2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		semdisp2.setHorizontalAlignment(SwingConstants.CENTER);
		semdisp2.setBounds(174, 378, 319, 35);
		panel.add(semdisp2);
		
		ptdisp2 = new JLabel("Student");
		ptdisp2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		ptdisp2.setHorizontalAlignment(SwingConstants.CENTER);
		ptdisp2.setBounds(173, 424, 319, 35);
		panel.add(ptdisp2);
		
		
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
					String sql = "UPDATE registration SET _name_='"+nametf.getText()+"', contact_no_='"+contacttf.getText()+"', email_id ='"+
							eidtf.getText()+"', college='"+colltf.getText()+"', username='"+untf.getText()+"', rollno='"+
							rntf.getText()+"', bd='"+bdtf.getText()+"', sem='"+semtf.getText()+"' WHERE username='"+homepage.us+"'";
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
		
		nameedit1 = new JLabel(" Name : ");
		nameedit1.setHorizontalAlignment(SwingConstants.TRAILING);
		nameedit1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		nameedit1.setBounds(10, 52, 139, 35);
		panel_1.add(nameedit1);
		
		contactedit1 = new JLabel(" Contact : ");
		contactedit1.setHorizontalAlignment(SwingConstants.TRAILING);
		contactedit1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		contactedit1.setBounds(10, 98, 139, 35);
		panel_1.add(contactedit1);
		
		eidedit = new JLabel(" Email ID : ");
		eidedit.setHorizontalAlignment(SwingConstants.TRAILING);
		eidedit.setFont(new Font("Segoe UI", Font.BOLD, 18));
		eidedit.setBounds(10, 144, 139, 35);
		panel_1.add(eidedit);
		
		colledit1 = new JLabel(" College Name : ");
		colledit1.setHorizontalAlignment(SwingConstants.TRAILING);
		colledit1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		colledit1.setBounds(10, 190, 139, 35);
		panel_1.add(colledit1);
		
		unedit = new JLabel(" Username : ");
		unedit.setHorizontalAlignment(SwingConstants.TRAILING);
		unedit.setFont(new Font("Segoe UI", Font.BOLD, 18));
		unedit.setBounds(10, 236, 139, 35);
		panel_1.add(unedit);
		
		rnedit = new JLabel(" Roll. No. : ");
		rnedit.setHorizontalAlignment(SwingConstants.TRAILING);
		rnedit.setFont(new Font("Segoe UI", Font.BOLD, 18));
		rnedit.setBounds(10, 282, 139, 35);
		panel_1.add(rnedit);
		
		bdedit = new JLabel(" Branch/Div : ");
		bdedit.setHorizontalAlignment(SwingConstants.TRAILING);
		bdedit.setFont(new Font("Segoe UI", Font.BOLD, 18));
		bdedit.setBounds(10, 328, 139, 35);
		panel_1.add(bdedit);
		
		semedit = new JLabel(" Semester : ");
		semedit.setHorizontalAlignment(SwingConstants.TRAILING);
		semedit.setFont(new Font("Segoe UI", Font.BOLD, 18));
		semedit.setBounds(10, 374, 139, 35);
		panel_1.add(semedit);
		
		ptedit = new JLabel("   Profile - Type :   Student");
		ptedit.setFont(new Font("Segoe UI", Font.BOLD, 18));
		ptedit.setBounds(10, 420, 483, 35);
		panel_1.add(ptedit);
		
		nametf = new JTextField(n);
		nametf.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		nametf.setOpaque(false);
		nametf.setBounds(169, 52, 324, 35);
		panel_1.add(nametf);
		nametf.setColumns(10);
		
		contacttf = new JTextField(c);
		contacttf.setOpaque(false);
		contacttf.setColumns(10);
		contacttf.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		contacttf.setBounds(169, 98, 324, 35);
		panel_1.add(contacttf);
		
		eidtf = new JTextField(e1);
		eidtf.setOpaque(false);
		eidtf.setColumns(10);
		eidtf.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		eidtf.setBounds(169, 144, 324, 35);
		panel_1.add(eidtf);
		
		colltf = new JTextField(c1);
		colltf.setOpaque(false);
		colltf.setColumns(10);
		colltf.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		colltf.setBounds(169, 190, 324, 35);
		panel_1.add(colltf);
		
		untf = new JTextField(u1);
		untf.setOpaque(false);
		untf.setColumns(10);
		untf.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		untf.setBounds(169, 236, 324, 35);
		panel_1.add(untf);
		
		rntf = new JTextField(r);
		rntf.setOpaque(false);
		rntf.setColumns(10);
		rntf.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		rntf.setBounds(169, 282, 324, 35);
		panel_1.add(rntf);
		
		bdtf = new JTextField(bd);
		bdtf.setOpaque(false);
		bdtf.setColumns(10);
		bdtf.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		bdtf.setBounds(169, 328, 324, 35);
		panel_1.add(bdtf);
		
		semtf = new JTextField(se);
		semtf.setOpaque(false);
		semtf.setColumns(10);
		semtf.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		semtf.setBounds(169, 374, 324, 35);
		panel_1.add(semtf);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(240, 248, 255));
		panel_2.setBounds(550, 11, 31, 541);
		panel_2.setVisible(false);
		contentPane.add(panel_2);
	}
}
