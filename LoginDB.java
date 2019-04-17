import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginDB extends JFrame {

	private JPanel contentPane;
	private JTextField UserName_textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public LoginDB() 
	{
		
		setup_LoginDB();
	}

	/**
	 * Create the frame.
	 */
	private void setup_LoginDB() {
		
		setType(Type.POPUP);
		setTitle("Login");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 304, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDbStatus = new JLabel("DB Status");
		lblDbStatus.setBounds(6, 6, 61, 16);
		contentPane.add(lblDbStatus);
		
		JLabel ID_Label = new JLabel("");
		ID_Label.setBounds(79, 6, 61, 16);
		contentPane.add(ID_Label);
		
		JLabel UserName_Label = new JLabel("User Name");
		UserName_Label.setBounds(6, 77, 78, 16);
		contentPane.add(UserName_Label);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(6, 105, 78, 16);
		contentPane.add(lblPassword);
		
		UserName_textField = new JTextField();
		UserName_textField.setBounds(79, 72, 184, 26);
		contentPane.add(UserName_textField);
		UserName_textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(79, 100, 184, 26);
		contentPane.add(passwordField);
		
		JButton Login_Button = new JButton("Login");
		Login_Button.setBounds(79, 176, 184, 29);
		contentPane.add(Login_Button);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(79, 138, 184, 27);
		contentPane.add(comboBox);
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginDB frame = new LoginDB();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
}// class end
