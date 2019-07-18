package mysql;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.html.Option;

import dbUtil.dbConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.DropMode;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import java.net.Authenticator.RequestorType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.ResolverStyle;
import java.util.Enumeration;
import java.util.Hashtable;
import java.awt.Color;

public class LoginGUI extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField UserName_textField;
	private String[] option = { "Staff", "Admin" };
	private JComboBox<?> comboBox; // new JComboBox<Object>(option);
	private JButton Login_Button;
	private JTextField OnDuty_textField;
	private Hashtable<String, String> pass;
	
	String key;
	private JPasswordField password_passwordField;
	

	
	public LoginGUI() {

		setup_LoginDB();
	}

	
	private void setup_LoginDB() {

		setTitle("Login");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 287, 264);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDbStatus = new JLabel("On Duty");
		lblDbStatus.setBounds(6, 49, 61, 16);
		contentPane.add(lblDbStatus);

		JLabel UserName_Label = new JLabel("User Name");
		UserName_Label.setBounds(6, 77, 78, 16);
		contentPane.add(UserName_Label);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(6, 105, 78, 16);
		contentPane.add(lblPassword);

		UserName_textField = new JTextField();
		UserName_textField.setHorizontalAlignment(SwingConstants.LEFT);
		UserName_Label.setEnabled(true);
		UserName_textField.setBounds(79, 72, 149, 26);
		contentPane.add(UserName_textField);
		UserName_textField.setColumns(1);

		Login_Button = new JButton("Login");
		Login_Button.addActionListener(this);
		Login_Button.setBounds(97, 177, 120, 29);
		contentPane.add(Login_Button);

		comboBox = new JComboBox<Object>(option);
		comboBox.setSelectedIndex(-1);
//		comboBox.setToolTipText("");
		comboBox.setMaximumRowCount(3);
		comboBox.setBounds(79, 138, 149, 27);
		contentPane.add(comboBox);

		OnDuty_textField = new JTextField();
		OnDuty_textField.setEditable(true);
		OnDuty_textField.setBackground(Color.WHITE);
		OnDuty_textField.setHorizontalAlignment(SwingConstants.LEFT);
		OnDuty_textField.setBounds(79, 44, 149, 26);
		contentPane.add(OnDuty_textField);
		OnDuty_textField.setColumns(10);
		
		password_passwordField = new JPasswordField();
		password_passwordField.setHorizontalAlignment(SwingConstants.LEFT);
		password_passwordField.setEchoChar('*');
		password_passwordField.setBounds(79, 100, 149, 26);
		contentPane.add(password_passwordField);
	}

//	// Database Driver
//	public void connect() throws ClassNotFoundException {
//		if(con.getconnect() ) {
//			datastatus_textField.setText("Connected");
//		}
//		else {
//			datastatus_textField.setText("Not Connected");
//		}
//	}
	
	// Methods
	// close window
	private void close() {
		WindowEvent winClsingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClsingEvent);

	}

	public boolean check_Password(String user, String p) {
		Enumeration names;
		pass = new Hashtable<String, String>();

		
		pass.put("password", "username");
		
		
		

		names = pass.keys();			// key() gets the left String of the hash table
		while (names.hasMoreElements()) {
			key = (String) names.nextElement();
			if (key.equals(user) && pass.get(key).equals(p)) {			//.get(key) gets the right String of the hash table
				return true;
			}
		}
		return false;

	}
	
	protected boolean database_login(String user, String p) {		// p will pass the password for verification to the database
		
		Connection conn = dbConnection.connect();
		try {
			PreparedStatement pr = conn.prepareStatement("SELECT * FROM Login WHERE id= ?");
			pr.setString(1, p);
			
			ResultSet rs = pr.executeQuery();
			
			while(rs.next()) {
				if(rs.getString("firstname").equals(user)) {
					conn.close();
					return true;
					
				}
				else {
					conn.close();
					return false;
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String username;
		String password;
		String Duty;
//		String.valueOf(passwordField.getPassword());
		String combo = (String) comboBox.getSelectedItem(); // it gets the value of the combo box setlected

		if (e.getSource().equals(Login_Button)) {
			username = UserName_textField.getText().toLowerCase();
			password = String.valueOf(password_passwordField.getPassword());
			Duty = OnDuty_textField.getText().toUpperCase().toLowerCase();
			
			
//			System.out.println(username);
//			System.out.println(password);
			if (combo.equals("Admin") && check_Password(username, password) && Duty.length() > 4) {
				if(database_login(Duty, password)) {
					try {
//						connect();
						new Edit(Duty).setVisible(true);
						close();
					} catch (ClassNotFoundException e1) {
						System.out.println(e1.getMessage());
						OnDuty_textField.setText("Error");
					}
				}
				
//				System.out.println("it works");
			}
			else if (combo.equals("Staff") && check_Password(username, password) && Duty.length() > 4) {
				if(database_login(Duty, password)) {
					try {
//						connect();
						new Database_Frame(Duty).setVisible(true);
						close();
						
					} catch (ClassNotFoundException e1) {
						System.out.println(e1.getMessage());
						OnDuty_textField.setText("Error");
					}
				}
				
//				System.out.println("it works");
			}
			else {
				JOptionPane.showMessageDialog(null, "Check your input, One input must be incorrent,"+"\n"+"On Duty field must be at least 5 words");
			}
			
			
		}

	}
}// class end
