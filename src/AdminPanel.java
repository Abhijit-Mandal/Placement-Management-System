import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.UIManager;

public class AdminPanel extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private String placed;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanel frame = new AdminPanel();
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
	public AdminPanel() {
		super("Admin Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 932, 547);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				try {
				int i= table.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				textField.setText(model.getValueAt(i, 1).toString());
				textField_1.setText(model.getValueAt(i, 2).toString());
				String plc=model.getValueAt(i, 3).toString();
				if(plc.equals("Yes")) {
					rdbtnNewRadioButton.setSelected(true);
					
				}
				else
					rdbtnNewRadioButton_1.setSelected(true);
				
				textField_2.setText(model.getValueAt(i, 4).toString());
				textField_3.setText(model.getValueAt(i, 5).toString());
				}
				catch(NullPointerException a) {
					a.getStackTrace();
				}
				
			}
			
			
		});
		
		JLabel lblNewLabel = new JLabel("Placement Data Management System");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBackground(Color.RED);
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 25));
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setBackground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2 = new JLabel("Date Of Birth:");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		
		JLabel lblNewLabel_3 = new JLabel("Placed: ");
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		
		JLabel lblNewLabel_4 = new JLabel("Company:");
		lblNewLabel_4.setForeground(Color.BLUE);
		lblNewLabel_4.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		
		JLabel lblNewLabel_5 = new JLabel("Package(\u20B9):");
		lblNewLabel_5.setForeground(Color.BLUE);
		lblNewLabel_5.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		 rdbtnNewRadioButton = new JRadioButton("Yes");
		 rdbtnNewRadioButton.setBackground(SystemColor.activeCaption);
		 rdbtnNewRadioButton.setForeground(Color.RED);
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		 rdbtnNewRadioButton_1 = new JRadioButton("No");
		 rdbtnNewRadioButton_1.setBackground(SystemColor.activeCaption);
		 rdbtnNewRadioButton_1.setForeground(Color.RED);
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setForeground(SystemColor.textHighlight);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo", "root", "happyjoy");
					 String query = "insert into swing_demo.data(name, dob, placed, company, package)values(?,?,?,?,?) ";
					 PreparedStatement pst = connection.prepareStatement(query);
					 pst.setString(1, textField.getText());
					 SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
			         java.util.Date udob = sdf1.parse(textField_1.getText());
			         java.sql.Date sqdob = new java.sql.Date(udob.getTime());
					 pst.setDate(2, sqdob);
					 if(rdbtnNewRadioButton.isSelected()) {
						 placed="Yes";
					 }
					 else 
						 placed="No";
					 pst.setString(3, placed);
					 pst.setString(4, textField_2.getText());
					 pst.setString(5, textField_3.getText());
					 
					 pst.executeUpdate();
					 DefaultTableModel model = (DefaultTableModel)table.getModel();
					 model.setRowCount(0);
					 showUser();
					 
					 
					 
					 
					 JOptionPane.showMessageDialog(btnNewButton, "Inserted Successfully!");
					 
				}
				catch (Exception exception) {
	                 exception.printStackTrace();
	             }
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setForeground(SystemColor.textHighlight);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo", "root", "happyjoy");
					 
					 int row = table.getSelectedRow();				 
					 String value = (table.getModel().getValueAt(row, 0).toString());
					 
					 String query = "UPDATE swing_demo.data SET name=?, dob=?, placed=?, company=?, package=? where uid="+value;
					 PreparedStatement pst = connection.prepareStatement(query);
					 pst.setString(1, textField.getText());
					 SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			         java.util.Date udob = sdf1.parse(textField_1.getText());
			         java.sql.Date sqdob = new java.sql.Date(udob.getTime());
					 pst.setDate(2, sqdob);
					 if(rdbtnNewRadioButton.isSelected()) {
						 placed="Yes";
					 }
					 else 
						 placed="No";
					 pst.setString(3, placed);
					 pst.setString(4, textField_2.getText());
					 pst.setString(5, textField_3.getText());
					 
					 pst.executeUpdate();
					 DefaultTableModel model = (DefaultTableModel)table.getModel();
					 model.setRowCount(0);
					 
					 showUser();
					 JOptionPane.showMessageDialog(btnNewButton, "Updated Successfully!");
					 
					 
					 
					 
				}
				catch (ArrayIndexOutOfBoundsException b) {
					b.printStackTrace();
				}
				catch (Exception exception) {
	                 exception.printStackTrace();
	             }
				
				
				
			
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnReset = new JButton("Reset");
		btnReset.setForeground(SystemColor.textHighlight);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");		
				textField_1.setText("");
			    textField_2.setText("");
				textField_3.setText(""); 
				
				
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_6 = new JLabel("Student Details ");
		lblNewLabel_6.setForeground(Color.RED);
		lblNewLabel_6.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		
		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				option a=new option();
				a.setVisible(true);
				
			}
		});
		btnNewButton_1.setForeground(SystemColor.textHighlight);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addContainerGap()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
														.addGroup(gl_contentPane.createSequentialGroup()
															.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
															.addGap(18)
															.addComponent(textField, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
														.addGroup(gl_contentPane.createSequentialGroup()
															.addComponent(lblNewLabel_2)
															.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
															.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)))
													.addGap(16))
												.addGroup(gl_contentPane.createSequentialGroup()
													.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_contentPane.createSequentialGroup()
															.addComponent(lblNewLabel_5)
															.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE))
														.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
														.addComponent(lblNewLabel_3, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
													.addGap(18)
													.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
														.addGroup(gl_contentPane.createSequentialGroup()
															.addComponent(rdbtnNewRadioButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
															.addPreferredGap(ComponentPlacement.UNRELATED)
															.addComponent(rdbtnNewRadioButton_1, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
														.addGroup(gl_contentPane.createSequentialGroup()
															.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																.addComponent(textField_3, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
																.addComponent(textField_2, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
															.addGap(11))))
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(btnNewButton)
													.addGap(18)
													.addComponent(btnUpdate)
													.addGap(20)
													.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(95)
											.addComponent(lblNewLabel_6)))
									.addGap(18))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(141)
									.addComponent(btnNewButton_1)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 507, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(226)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 451, GroupLayout.PREFERRED_SIZE)))
					.addGap(51))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(12)
							.addComponent(lblNewLabel_6)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2))
							.addGap(26)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtnNewRadioButton)
								.addComponent(rdbtnNewRadioButton_1)
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
							.addGap(41)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(btnNewButton)
									.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addComponent(btnNewButton_1))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 409, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(11, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"UID", "Name", "DOB", "Placed(?)", "Company", "Package(\u20B9)"
			}
		));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"UID", "Name", "DOB", "Placed(?)", "Company", "Package"
			}
			
			
		) {/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int column)
	    {
		      return false;//This causes all cells to be not editable
		    }});
		scrollPane.setViewportView(table);
		
		contentPane.setLayout(gl_contentPane);
		table.setVisible(true);
		showUser();
	}
	public ArrayList<StudentData> userList(){
		ArrayList<StudentData> userList = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo", "root", "happyjoy");
			 String query1="SELECT * FROM swing_demo.data";
			 Statement st = connection.createStatement();
			 ResultSet rs = st.executeQuery(query1);
			 StudentData user;
			 while(rs.next()) {
				 user= new StudentData(rs.getInt("UID"), rs.getString("name"), rs.getDate("dob"),rs.getString("placed"), rs.getString("company"), rs.getString("package"));
				 userList.add(user);
				 
			 }
			 
		}
		catch (Exception exception) {
            exception.printStackTrace();
        }
		return userList;
		
		
		
	}
	public void showUser() {
		ArrayList<StudentData> list = userList();
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		
		Object[]row= new Object[6];
		for(int i=1;i<list.size();i++) {
			row[0]=list.get(i).getUID();
			row[1]=list.get(i).getName();
			row[2]=list.get(i).getDOB();
			row[3]=list.get(i).getPlaced();
			row[4]=list.get(i).getCompany();
			row[5]=list.get(i).getpackage();
			model.addRow(row);
			
			
		}
		
}}
