mport java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.Panel;
import javax.swing.JFormattedTextField;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JSeparator;
import javax.swing.JEditorPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JCheckBox;
import java.awt.ScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JMenuBar;
import javax.swing.border.LineBorder;

public class Database_Frame extends JFrame {

	private JPanel contentPane;
	private JLabel lblLastName;
	private JLabel lblFirstName;
	private JLabel lblRoom;
	private JTextField textFieldLastName;
	private JTextField textField_1FirstName;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table_Resident;
	private JTable table_Guest;
//	Connection con = null;
//	PreparedStatement pst = null;
//	ResultSet rs = null; 
//	

	public Database_Frame() {
		initComponenets();
		// show_data();
	}

//	public Connection getConnection() {
//		
//		Connection con;
//		try {
//			con =  DriverManager.getConnection("student.db", "root", "");
//			
//			return con;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//			
//		}
//	}
//	// connect to the database and create and arrayList
//	public ArrayList<User> getuserList(){
//		
//		ArrayList<User> userList = new ArrayList<User>();
//		
//		Connection connect = getConnection();
//		String query = "SELECT * FROM students";
//		Statement st;
//		ResultSet rs;
//		
//		try {
//			st = connect.createStatement();
//			rs =st.executeQuery(query);
//			User user;
//			while(rs.next()) {
//				user = new User(rs.getString("lastname"), rs.getString("firstname"), rs.getString("room"), rs.getInt("nights"));
//				userList.add(user);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			
//		}
//		return userList;
//	}
//	

	// Display data in table

//	public void show_data() {
//		ArrayList<User> list = getuserList();
//		DefaultTableModel model = (DefaultTableModel) table_Resident.getModel();
//		Object[] row = new Object[4];
//		for(int i = 0; i < list.size(); i++) {
//			row[0] = list.get(i).getLastname();
//			row[1] = list.get(i).getFirstname();
//			row[2] = list.get(i).getRoom();
//			row[3] = list.get(i).getNights();
//			
//			model.addRow(row);
//			
//		}
//	}
	/**
	 * Create the frame.
	 */
	public void initComponenets() {
		// connection = sqliteConnection.dbConnector();

		setTitle("Overnight Records");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 829, 473);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(6, 48, 78, 16);
		contentPane.add(lblLastName);

		lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(6, 76, 78, 16);
		contentPane.add(lblFirstName);

		lblRoom = new JLabel("Room #:");
		lblRoom.setBounds(29, 176, 61, 16);
		contentPane.add(lblRoom);

		textFieldLastName = new JTextField();
		textFieldLastName.setBackground(Color.LIGHT_GRAY);
		textFieldLastName.setBounds(79, 43, 130, 26);
		contentPane.add(textFieldLastName);
		textFieldLastName.setColumns(10);

		textField_1FirstName = new JTextField();
		textField_1FirstName.setBackground(Color.LIGHT_GRAY);
		textField_1FirstName.setBounds(79, 71, 130, 26);
		contentPane.add(textField_1FirstName);
		textField_1FirstName.setColumns(10);

		JLabel lblResident = new JLabel("Resident:");
		lblResident.setBounds(229, 6, 61, 16);
		contentPane.add(lblResident);

		JButton btnInsert = new JButton("Insert");
		btnInsert.setBounds(6, 413, 67, 16);
		contentPane.add(btnInsert);

		JLabel lblGuest = new JLabel("Guest:");
		lblGuest.setBounds(229, 226, 61, 16);
		contentPane.add(lblGuest);

		JLabel lblNewLabel_Guest_Last_Name = new JLabel("Last Name:");
		lblNewLabel_Guest_Last_Name.setBounds(6, 304, 78, 16);
		contentPane.add(lblNewLabel_Guest_Last_Name);

		JLabel lblNewLabel_1_Guest_First_Name = new JLabel("First Name:");
		lblNewLabel_1_Guest_First_Name.setBounds(6, 351, 78, 16);
		contentPane.add(lblNewLabel_1_Guest_First_Name);

		textField = new JTextField();
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setBounds(79, 299, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBackground(Color.LIGHT_GRAY);
		textField_1.setBounds(79, 346, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNights_Guest = new JLabel("Nights:");
		lblNights_Guest.setBounds(32, 104, 52, 16);
		contentPane.add(lblNights_Guest);

		JFormattedTextField formattedTextField_Nights = new JFormattedTextField();
		formattedTextField_Nights.setBackground(Color.LIGHT_GRAY);
		formattedTextField_Nights.setBounds(79, 99, 37, 26);
		contentPane.add(formattedTextField_Nights);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(79, 413, 67, 16);
		contentPane.add(btnUpdate);

		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(38, 147, 46, 16);
		contentPane.add(lblDate);

		// scrollpane_resident linked to table_resident to view the info from database
		JScrollPane scrollPane_Resident_room = new JScrollPane();
		scrollPane_Resident_room.setBounds(87, 176, 88, 16);
		contentPane.add(scrollPane_Resident_room);

		table_Resident = new JTable();
		table_Resident.setFillsViewportHeight(true);
		table_Resident.setBorder(new LineBorder(new Color(0, 0, 255)));
		table_Resident.setBounds(228, 24, 595, 190);
		// scrollPane_Resident_room.setViewportView(table_Resident);
		contentPane.add(table_Resident);

		table_Guest = new JTable();
		table_Guest.setFillsViewportHeight(true);
		table_Guest.setBorder(new LineBorder(Color.BLUE));
		table_Guest.setBounds(229, 250, 594, 195);
		contentPane.add(table_Guest);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(150, 413, 67, 17);
		contentPane.add(btnDelete);

	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}

	public JLabel getLblLastName() {
		return lblLastName;
	}

	public void setLblLastName(JLabel lblLastName) {
		this.lblLastName = lblLastName;
	}

	public JLabel getLblFirstName() {
		return lblFirstName;
	}

	public void setLblFirstName(JLabel lblFirstName) {
		this.lblFirstName = lblFirstName;
	}

	public JLabel getLblRoom() {
		return lblRoom;
	}

	public void setLblRoom(JLabel lblRoom) {
		this.lblRoom = lblRoom;
	}

	public JTextField getTextFieldLastName() {
		return textFieldLastName;
	}

	public void setTextFieldLastName(JTextField textFieldLastName) {
		this.textFieldLastName = textFieldLastName;
	}

	public JTextField getTextField_1FirstName() {
		return textField_1FirstName;
	}

	public void setTextField_1FirstName(JTextField textField_1FirstName) {
		this.textField_1FirstName = textField_1FirstName;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}

	public JTable getTable_Resident() {
		return table_Resident;
	}

	public void setTable_Resident(JTable table_Resident) {
		this.table_Resident = table_Resident;
	}

	public JTable getTable_Guest() {
		return table_Guest;
	}

	public void setTable_Guest(JTable table_Guest) {
		this.table_Guest = table_Guest;
	}

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Database_Frame frame = new Database_Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
} // end class
