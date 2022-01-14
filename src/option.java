import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class option extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					option frame = new option();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public option() {
		super("Placement Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 457);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 255));
		contentPane.setForeground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(18, Short.MAX_VALUE))
		);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 153));
		tabbedPane.addTab("Admin", null, panel, null);
		
		JLabel lblNewLabel = new JLabel("User:");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user= textField.getText();
				String pwd = passwordField.getText();
                
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo", "root", "happyjoy");
					 String query = "select * from swing_demo.data where uid='"+ pwd+"' and name='"+user+"'" ;
					 
					
					 Statement sta = connection.createStatement();
					 
				 ResultSet x = sta.executeQuery(query);
                 if (x.next()) {
                	 if(user.equals("admin") && pwd.equals("10000")){
                		 JOptionPane.showMessageDialog(btnNewButton, "Welcome Admin!");
                		 dispose();
                		 AdminPanel a = new AdminPanel();
                		 a.setVisible(true);}
				
			}}catch (Exception exception) {
                exception.printStackTrace();
            }}
		});
		btnNewButton.setForeground(SystemColor.textHighlight);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblNewLabel_5 = new JLabel("Admin Section");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap(92, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)))
							.addGap(18))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(166)
							.addComponent(btnNewButton)))
					.addContainerGap(108, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(156)
					.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(189, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(27)
					.addComponent(lblNewLabel_5)
					.addGap(31)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addComponent(btnNewButton)
					.addContainerGap(57, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 153));
		panel_1.setForeground(Color.CYAN);
		tabbedPane.addTab("Student", null, panel_1, null);
		
		JLabel lblNewLabel_2 = new JLabel("UID:");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblNewLabel_3 = new JLabel("Name:");
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		passwordField_1 = new JPasswordField();
		
		JSeparator separator = new JSeparator();
		
		passwordField_2 = new JPasswordField();
		
		JButton btnNewButton_1 = new JButton("Load");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String username=passwordField_2.getText();
					String name=textField_1.getText();
					int usern=Integer.parseInt(username);
					if(username.length()==5) {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo", "root", "happyjoy");
						String query="SELECT * FROM swing_demo.data WHERE uid= '"+usern+"' and name= '"+name +"'" ;
						Statement sta = connection.createStatement();
						 
						ResultSet x = sta.executeQuery(query);
						
						if(x.next()) {
							
							String DOB=x.getString(3);
							String placed=x.getString(6);
							String comp=x.getString(4);
							String pack=x.getString(5);
							
							textField_2.setText(DOB);
							textField_3.setText(placed);
							textField_4.setText(comp);
							textField_5.setText(pack);
							
							
							
							
						}
						else {
							JOptionPane.showMessageDialog(btnNewButton, "Wrong name or ID! Try again..");
							passwordField_2.setText("");
							textField_1.setText("");
						}
						
						
					}
				}catch (Exception exception) {
	                exception.printStackTrace();
	            }
				
				
			}
		});
		btnNewButton_1.setForeground(SystemColor.textHighlight);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblNewLabel_4 = new JLabel("Student Section");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblNewLabel_6 = new JLabel("DOB:");
		lblNewLabel_6.setForeground(Color.BLUE);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_7 = new JLabel("");
		
		JLabel lblNewLabel_8 = new JLabel("Placed(?):");
		lblNewLabel_8.setForeground(Color.BLUE);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_9 = new JLabel("Company:");
		lblNewLabel_9.setForeground(Color.BLUE);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_10 = new JLabel("Package(\u20B9):");
		lblNewLabel_10.setForeground(Color.BLUE);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setEditable(false);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setEditable(false);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setEditable(false);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setEditable(false);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(53, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(93)
									.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_3)
										.addComponent(lblNewLabel_2))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(passwordField_2, Alignment.LEADING)
										.addComponent(textField_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(34)
									.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(71)
									.addComponent(lblNewLabel_10, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(45)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_6, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
										.addGroup(gl_panel_1.createSequentialGroup()
											.addGap(10)
											.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
										.addComponent(lblNewLabel_9, Alignment.TRAILING))))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(2)
									.addComponent(separator, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE))
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
							.addGap(151))))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(25)
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(18)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
										.addComponent(passwordField_2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
									.addGap(7)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panel_1.createSequentialGroup()
											.addGap(28)
											.addComponent(separator, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel_1.createSequentialGroup()
											.addGap(18)
											.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 250, Short.MAX_VALUE)
											.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_7)
									.addGap(4)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_panel_1.createSequentialGroup()
											.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel_1.createSequentialGroup()
											.addComponent(lblNewLabel_8)
											.addGap(18)
											.addComponent(lblNewLabel_9)))
									.addGap(18)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel_10)
										.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(89)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		contentPane.setLayout(gl_contentPane);
	}
}
