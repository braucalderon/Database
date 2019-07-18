package mysql;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dbUtil.dbConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JEditorPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JCheckBox;

public class Edit extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField DB_status_textField;
	private JTextField Manager_textField;
	private JTextField Resident_LastName_textField;
	private JTextField Resident_FirstName_textField;
	private JTextField Room_textField;
	private JTextField Guest_LastName_textField;
	private JTextField Guest_FirstName_textField;
	private JFormattedTextField Resident_totalnights_formattedField;
	private JFormattedTextField Resident_chargenights_formattedField;
	private JFormattedTextField Resident_Freenights_formattedField;
	private JFormattedTextField Guest_chargednights_formattedField;
	private JFormattedTextField Guest_freenights_formattedField;
	private JFormattedTextField Guest_totalnights_formattedField;
	private JTextField search_textField;
	private JTextField search_lastname_textField;
	private JTextField search_firstname_textField;
	private JTextField Notes_textField;
	private JButton Search_room_Button;
	private JButton Search_Guest_Button;
	private JScrollPane Notes_scrollPane;
	private JTextArea Notes_textArea;
	private int rtotal, gtotal, resi_free, resi_paid, guest_free, guest_paid;
	private String connect;
	private String room;
	private String rfirst, rlast, write, gfirst, glast;
	private String first, last;
	private String id;
	private String resident_table, guest_table;
	private int paid_nights, free_nights, totalnights;
	private JTextField register_lastname_textField;
	private JTextField register_firstname_textField;
	private JTextField register_id_textField;
	private JButton Register_Button;
	private JButton Log_Out_Button;
	private JButton UpdateDatabase_Button;
	private JButton Save_resident_Button;
	private JButton Save_guest_Button;
	private JButton Preview_Button;
	private JButton Clear_Button;
	private JButton Delete_Button;
	private JCheckBox Guest_CheckBox, clog;
	private JCheckBox Resident_CheckBox, clog1;

	private String n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, n13, n14, n15, n16, n17, n18, n19, n20, n21, n22,
			n23, n24, n25, n26, n27, n28, n29, n30, n31;

	private String n1l, n2l, n3l, n4l, n5l, n6l, n7l, n8l, n9l, n10l, n11l, n12l, n13l, n14l, n15l, n16l, n17l, n18l,
			n19l, n20l, n21l, n22l, n23l, n24l, n25l, n26l, n27l, n28l, n29l, n30l, n31l;

	public Edit() throws ClassNotFoundException {
		initEdit();
	}

	public Edit(String m) throws ClassNotFoundException {

		initEdit();
		Manager_textField.setText(m.toUpperCase());

	}

	private void initEdit() throws ClassNotFoundException {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 621, 446);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel DBStatus_Label = new JLabel("DB Status: ");
		DBStatus_Label.setEnabled(false);
		DBStatus_Label.setBounds(6, 6, 73, 16);
		contentPane.add(DBStatus_Label);

		if (dbConnection.connect1()) {
			connect = "Connected";
		} else {
			connect = "Disconnected";
		}
		DB_status_textField = new JTextField(connect);
		DB_status_textField.setForeground(Color.BLUE);
		DB_status_textField.setHorizontalAlignment(SwingConstants.CENTER);
		DB_status_textField.setEditable(false);
		DB_status_textField.setBounds(78, 1, 110, 26);
		contentPane.add(DB_status_textField);
		DB_status_textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Manager:");
		lblNewLabel.setEnabled(false);
		lblNewLabel.setBounds(251, 6, 61, 16);
		contentPane.add(lblNewLabel);

		Manager_textField = new JTextField();
		Manager_textField.setForeground(Color.BLUE);
		Manager_textField.setHorizontalAlignment(SwingConstants.CENTER);
		Manager_textField.setEditable(false);
		Manager_textField.setBounds(318, 1, 110, 26);
		contentPane.add(Manager_textField);
		Manager_textField.setColumns(10);

		JPanel Resident_info_panel = new JPanel();
		Resident_info_panel.setBorder(new MatteBorder(0, 1, 1, 0, (Color) Color.BLUE));
		Resident_info_panel.setBackground(Color.WHITE);
		Resident_info_panel.setBounds(251, 53, 364, 128);
		contentPane.add(Resident_info_panel);
		Resident_info_panel.setLayout(null);

		JLabel Resident_lastName_Label = new JLabel("Last Name");
		Resident_lastName_Label.setEnabled(false);
		Resident_lastName_Label.setBounds(6, 6, 72, 16);
		Resident_info_panel.add(Resident_lastName_Label);

		JLabel Resident_firstName_Label = new JLabel("First Name");
		Resident_firstName_Label.setEnabled(false);
		Resident_firstName_Label.setBounds(6, 39, 72, 16);
		Resident_info_panel.add(Resident_firstName_Label);

		Resident_LastName_textField = new JTextField();
		Resident_LastName_textField.setFont(new Font("Iowan Old Style", Font.PLAIN, 13));
		Resident_LastName_textField.setBounds(78, 1, 130, 26);
		Resident_info_panel.add(Resident_LastName_textField);
		Resident_LastName_textField.setColumns(10);

		Resident_FirstName_textField = new JTextField();
		Resident_FirstName_textField.setFont(new Font("Iowan Old Style", Font.PLAIN, 13));
		Resident_FirstName_textField.setBounds(78, 34, 130, 26);
		Resident_info_panel.add(Resident_FirstName_textField);
		Resident_FirstName_textField.setColumns(10);

		JLabel Room_Label = new JLabel("Room ");
		Room_Label.setEnabled(false);
		Room_Label.setBounds(6, 77, 40, 16);
		Resident_info_panel.add(Room_Label);

		Room_textField = new JTextField();
		Room_textField.setHorizontalAlignment(SwingConstants.CENTER);
		Room_textField.setEditable(false);
		Room_textField.setBounds(46, 72, 56, 26);
		Resident_info_panel.add(Room_textField);
		Room_textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Total Nights #");
		lblNewLabel_1.setEnabled(false);
		lblNewLabel_1.setBounds(222, 72, 100, 16);
		Resident_info_panel.add(lblNewLabel_1);

		Resident_totalnights_formattedField = new JFormattedTextField(NumberFormat.getIntegerInstance());
		Resident_totalnights_formattedField.setEditable(false);
		Resident_totalnights_formattedField.setHorizontalAlignment(SwingConstants.CENTER);
		Resident_totalnights_formattedField.setBounds(313, 67, 45, 26);
		Resident_info_panel.add(Resident_totalnights_formattedField);

		JLabel Free_Nights_Label = new JLabel("Free Nights #");
		Free_Nights_Label.setEnabled(false);
		Free_Nights_Label.setBounds(222, 39, 90, 16);
		Resident_info_panel.add(Free_Nights_Label);

		Resident_Freenights_formattedField = new JFormattedTextField(NumberFormat.getIntegerInstance());
		Resident_Freenights_formattedField.setHorizontalAlignment(SwingConstants.CENTER);
		Resident_Freenights_formattedField.setBounds(313, 34, 45, 26);
		Resident_info_panel.add(Resident_Freenights_formattedField);

		JLabel lblNewLabel_2 = new JLabel("Charged Night #");
		lblNewLabel_2.setEnabled(false);
		lblNewLabel_2.setBounds(209, 6, 113, 16);
		Resident_info_panel.add(lblNewLabel_2);

		Resident_chargenights_formattedField = new JFormattedTextField(NumberFormat.getIntegerInstance());
		Resident_chargenights_formattedField.setHorizontalAlignment(SwingConstants.CENTER);
		Resident_chargenights_formattedField.setBounds(313, 1, 45, 26);
		Resident_info_panel.add(Resident_chargenights_formattedField);

		Save_resident_Button = new JButton("Save");
		Save_resident_Button.setEnabled(false);
		Save_resident_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				rfirst = Resident_FirstName_textField.getText().toLowerCase();
				rlast = Resident_LastName_textField.getText().toLowerCase();
				room = Room_textField.getText().toLowerCase();
				resident_table = "Residents";

				if (e.getSource().equals(Save_resident_Button)) {
					update_name(resident_table, rlast, rfirst, resi_free, resi_paid, rtotal, room);
					delete_nights(resident_table, room);
				}
			}
		});
		Save_resident_Button.setForeground(Color.BLUE);
		Save_resident_Button.setBounds(0, 98, 117, 29);
		Resident_info_panel.add(Save_resident_Button);

		Resident_CheckBox = new JCheckBox("Check to Save");
		Resident_CheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clog1 = (JCheckBox) e.getSource();

				if (clog1.isSelected()) {
					Save_resident_Button.setEnabled(true);
				} else {
					Save_resident_Button.setEnabled(false);
				}
			}
		});
		Resident_CheckBox.setBounds(119, 100, 128, 23);
		Resident_info_panel.add(Resident_CheckBox);

		JPanel Guest_info_panel = new JPanel();
		Guest_info_panel.setBackground(Color.WHITE);
		Guest_info_panel.setBorder(new MatteBorder(0, 1, 1, 0, (Color) Color.BLUE));
		Guest_info_panel.setBounds(251, 209, 364, 147);
		contentPane.add(Guest_info_panel);
		Guest_info_panel.setLayout(null);

		JLabel Guest_lastName_Label = new JLabel("Last Name");
		Guest_lastName_Label.setEnabled(false);
		Guest_lastName_Label.setBounds(6, 6, 77, 16);
		Guest_info_panel.add(Guest_lastName_Label);

		Guest_LastName_textField = new JTextField();
		Guest_LastName_textField.setFont(new Font("Iowan Old Style", Font.PLAIN, 13));
		Guest_LastName_textField.setBounds(79, 1, 130, 26);
		Guest_info_panel.add(Guest_LastName_textField);
		Guest_LastName_textField.setColumns(10);

		JLabel Guest_FirstName_Label = new JLabel("First Name");
		Guest_FirstName_Label.setEnabled(false);
		Guest_FirstName_Label.setBounds(6, 41, 77, 16);
		Guest_info_panel.add(Guest_FirstName_Label);

		Guest_FirstName_textField = new JTextField();
		Guest_FirstName_textField.setFont(new Font("Iowan Old Style", Font.PLAIN, 13));
		Guest_FirstName_textField.setBounds(79, 36, 130, 26);
		Guest_info_panel.add(Guest_FirstName_textField);
		Guest_FirstName_textField.setColumns(10);

		JLabel Guest_Chargednight_Label = new JLabel("Charged Night #");
		Guest_Chargednight_Label.setEnabled(false);
		Guest_Chargednight_Label.setBounds(213, 6, 109, 16);
		Guest_info_panel.add(Guest_Chargednight_Label);

		Guest_chargednights_formattedField = new JFormattedTextField(NumberFormat.getIntegerInstance());
		Guest_chargednights_formattedField.setHorizontalAlignment(SwingConstants.CENTER);
		Guest_chargednights_formattedField.setBounds(317, 1, 41, 26);
		Guest_info_panel.add(Guest_chargednights_formattedField);

		JLabel Guest_Freenights_Label = new JLabel("Free Nights #");
		Guest_Freenights_Label.setEnabled(false);
		Guest_Freenights_Label.setBounds(231, 41, 91, 16);
		Guest_info_panel.add(Guest_Freenights_Label);

		Guest_freenights_formattedField = new JFormattedTextField(NumberFormat.getIntegerInstance());
		Guest_freenights_formattedField.setHorizontalAlignment(SwingConstants.CENTER);
		Guest_freenights_formattedField.setBounds(317, 36, 41, 26);
		Guest_info_panel.add(Guest_freenights_formattedField);

		JLabel Guest_totalnights_Label = new JLabel("Total Nights #");
		Guest_totalnights_Label.setEnabled(false);
		Guest_totalnights_Label.setBounds(225, 79, 97, 16);
		Guest_info_panel.add(Guest_totalnights_Label);

		Guest_totalnights_formattedField = new JFormattedTextField(NumberFormat.getIntegerInstance());
		Guest_totalnights_formattedField.setEditable(false);
		Guest_totalnights_formattedField.setHorizontalAlignment(SwingConstants.CENTER);
		Guest_totalnights_formattedField.setBounds(317, 74, 41, 26);
		Guest_info_panel.add(Guest_totalnights_formattedField);

		Save_guest_Button = new JButton("Save");
		Save_guest_Button.setEnabled(false);
		Save_guest_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				gfirst = Guest_FirstName_textField.getText().toLowerCase();
				glast = Guest_LastName_textField.getText().toLowerCase();
				room = Room_textField.getText().toLowerCase();

				if (e.getSource().equals(Save_guest_Button)) {
//					System.out.println(guest_table);
					update_name(guest_table, glast, gfirst, guest_free, guest_paid, gtotal, room);

				}
			}
		});
		Save_guest_Button.setForeground(Color.BLUE);
		Save_guest_Button.setBounds(0, 118, 117, 29);
		Guest_info_panel.add(Save_guest_Button);

		Preview_Button = new JButton("Preview");
		Preview_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					guest_paid = ((Number) Guest_chargednights_formattedField.getValue()).intValue();
					guest_free = ((Number) Guest_freenights_formattedField.getValue()).intValue();
					resi_free = ((Number) Resident_Freenights_formattedField.getValue()).intValue();
					resi_paid = ((Number) Resident_chargenights_formattedField.getValue()).intValue();

					if (e.getSource().equals(Preview_Button)) {
						gtotal = guest_free - guest_paid;
						Guest_totalnights_formattedField.setValue(Math.abs(gtotal));

						rtotal = resi_free - resi_paid;
						Resident_totalnights_formattedField.setValue(Math.abs(rtotal));
					}
				} catch (NullPointerException n) {
					JOptionPane.showMessageDialog(null, "The Guest Info must be upload");
//					System.out.println(n);
				}
			}
		});
		Preview_Button.setForeground(Color.BLUE);
		Preview_Button.setBounds(0, 90, 117, 29);
		Guest_info_panel.add(Preview_Button);

		Guest_CheckBox = new JCheckBox("Check to Save");
		Guest_CheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clog = (JCheckBox) e.getSource();
				if (clog.isSelected()) {
					Save_guest_Button.setEnabled(true);
				} else {
					Save_guest_Button.setEnabled(false);
				}
			}
		});
		Guest_CheckBox.setBounds(117, 119, 128, 23);
		Guest_info_panel.add(Guest_CheckBox);

		Clear_Button = new JButton("Clear");
		Clear_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (e.getSource().equals(Clear_Button)) {
					clear();
				}
			}
		});
		Clear_Button.setForeground(Color.BLUE);
		Clear_Button.setBounds(261, 118, 97, 29);
		Guest_info_panel.add(Clear_Button);

		JLabel Resident_info_Label = new JLabel("Resident Info:");
		Resident_info_Label.setEnabled(false);
		Resident_info_Label.setBounds(251, 30, 104, 16);
		contentPane.add(Resident_info_Label);

		JLabel lblNewLabel_4 = new JLabel("Guest Info:");
		lblNewLabel_4.setEnabled(false);
		lblNewLabel_4.setBounds(251, 188, 82, 16);
		contentPane.add(lblNewLabel_4);

		Search_room_Button = new JButton("Search Room");
		Search_room_Button.setForeground(Color.BLUE);
		Search_room_Button.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		Search_room_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				room = search_textField.getText().toLowerCase();

				resident_table = "Residents";
				if (e.getSource().equals(Search_room_Button)) {
					search_room(room.trim(), resident_table, last);
//					System.out.println(room);
				}

			}
		});
		Search_room_Button.setBounds(57, 79, 117, 29);
		contentPane.add(Search_room_Button);

		search_textField = new JTextField();
		search_textField.setHorizontalAlignment(SwingConstants.CENTER);
		search_textField.setBounds(78, 53, 77, 29);
		contentPane.add(search_textField);
		search_textField.setColumns(10);

		JLabel Search_Label = new JLabel("Enter Room Number");
		Search_Label.setEnabled(false);
		Search_Label.setBounds(57, 39, 135, 16);
		contentPane.add(Search_Label);

		JLabel search_lastname_Label = new JLabel("Last Name");
		search_lastname_Label.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		search_lastname_Label.setEnabled(false);
		search_lastname_Label.setBounds(6, 137, 61, 16);
		contentPane.add(search_lastname_Label);

		search_lastname_textField = new JTextField();
		search_lastname_textField.setBounds(3, 113, 124, 29);
		contentPane.add(search_lastname_textField);
		search_lastname_textField.setColumns(10);

		search_firstname_textField = new JTextField();
		search_firstname_textField.setBounds(125, 113, 124, 29);
		contentPane.add(search_firstname_textField);
		search_firstname_textField.setColumns(10);

		JLabel search_firstname_Label = new JLabel("First Name");
		search_firstname_Label.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		search_firstname_Label.setEnabled(false);
		search_firstname_Label.setBounds(127, 136, 61, 16);
		contentPane.add(search_firstname_Label);

		JLabel lblNotes = new JLabel("Notes");
		lblNotes.setEnabled(false);
		lblNotes.setBounds(6, 191, 47, 16);
		contentPane.add(lblNotes);

		Search_Guest_Button = new JButton("Search Guest");
		Search_Guest_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String[] guest = { "Guest1", "Guest2", "Guest3", "Guest4", "Guest5", "Guest6", "Guest7", "Guest8",
						"Guest9", "Guest10", "Guest11", "Guest12", "Guest13", "Guest14", "Guest15", "Guest16",
						"Guest17", "Guest18", "Guest19", "Guest20" };

				room = search_textField.getText().toLowerCase();
				glast = search_lastname_textField.getText().toLowerCase();

				if (e.getSource().equals(Search_Guest_Button)) {
					for (int i = 0; i < guest.length; i++) {
						search_lastname(room, guest[i], glast);
					}

				}
			}
		});
		Search_Guest_Button.setForeground(Color.BLUE);
		Search_Guest_Button.setBounds(57, 152, 117, 29);
		contentPane.add(Search_Guest_Button);

		Notes_scrollPane = new JScrollPane();
		Notes_scrollPane.setBounds(6, 209, 240, 44);
		contentPane.add(Notes_scrollPane);

		Notes_textArea = new JTextArea();
		Notes_textArea.setFont(new Font("Iowan Old Style", Font.PLAIN, 13));
		Notes_scrollPane.setViewportView(Notes_textArea);

		JLabel Register_Label = new JLabel("Registration");
		Register_Label.setEnabled(false);
		Register_Label.setBounds(6, 349, 82, 16);
		contentPane.add(Register_Label);

		register_lastname_textField = new JTextField();
		register_lastname_textField.setFont(new Font("Iowan Old Style", Font.PLAIN, 13));
		register_lastname_textField.setBounds(4, 365, 120, 36);
		contentPane.add(register_lastname_textField);
		register_lastname_textField.setColumns(10);

		register_firstname_textField = new JTextField();
		register_firstname_textField.setFont(new Font("Iowan Old Style", Font.PLAIN, 13));
		register_firstname_textField.setBounds(125, 365, 120, 36);
		contentPane.add(register_firstname_textField);
		register_firstname_textField.setColumns(10);

		JLabel reg_lastname_Label = new JLabel("Last Name");
		reg_lastname_Label.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		reg_lastname_Label.setEnabled(false);
		reg_lastname_Label.setBounds(8, 401, 61, 16);
		contentPane.add(reg_lastname_Label);

		JLabel lblNewLabel_3 = new JLabel("First Name");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblNewLabel_3.setEnabled(false);
		lblNewLabel_3.setBounds(128, 402, 61, 16);
		contentPane.add(lblNewLabel_3);

		register_id_textField = new JTextField();
		register_id_textField.setFont(new Font("Iowan Old Style", Font.PLAIN, 13));
		register_id_textField.setBounds(251, 365, 110, 36);
		contentPane.add(register_id_textField);
		register_id_textField.setColumns(10);

		JLabel staff_or_manager_Label = new JLabel("Staff or Manager");
		staff_or_manager_Label.setEnabled(false);
		staff_or_manager_Label.setBounds(255, 400, 110, 16);
		contentPane.add(staff_or_manager_Label);

		Register_Button = new JButton("Register");
		Register_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					id = register_id_textField.getText().toLowerCase().trim();
					last = register_lastname_textField.getText().toLowerCase().trim();
					first = register_firstname_textField.getText().toLowerCase().trim();
					
					if (e.getSource().equals(Register_Button) && id.equals("free")) {
						register_sum(id);
					}
					
					
					if(e.getSource().equals(Register_Button) && !(id.equals("free")) && last.length() == 0) {
						JOptionPane.showMessageDialog(null, "Input must be [ free ]"+"\n"+"to check free spots");
					}
					
					if (e.getSource().equals(Register_Button) && last.length() > 3) {
						if (first.length() > 3) {
							register(last, first, id);
							

						} else {
							JOptionPane.showMessageDialog(null, "Please enter the firstname");
						}
					}
					

					
				} catch (NullPointerException e2) {
					System.out.println(e2);
				}

			}
		});
		Register_Button.setForeground(Color.BLUE);
		Register_Button.setBounds(360, 389, 117, 29);
		contentPane.add(Register_Button);

		Log_Out_Button = new JButton("Log Out");
		Log_Out_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(Log_Out_Button)) {
					close();
				}
			}
		});
		Log_Out_Button.setForeground(Color.BLUE);
		Log_Out_Button.setBounds(500, 389, 117, 29);
		contentPane.add(Log_Out_Button);

		UpdateDatabase_Button = new JButton("Update Database");
		UpdateDatabase_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String filedata = "file path";

				if (e.getSource().equals(UpdateDatabase_Button)) {

					try {
						read_file_update(filedata);

					} catch (IOException e1) {

						e1.printStackTrace();
					}
				}
			}
		});
		UpdateDatabase_Button.setForeground(Color.BLUE);
		UpdateDatabase_Button.setBounds(114, 284, 135, 29);
		contentPane.add(UpdateDatabase_Button);

		JLabel FileUpdated_Label = new JLabel("File Update");
		FileUpdated_Label.setBounds(8, 289, 82, 16);
		contentPane.add(FileUpdated_Label);

		Delete_Button = new JButton("Delete");
		Delete_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				last = register_lastname_textField.getText().toLowerCase();
				first = register_firstname_textField.getText().toLowerCase();
				id = register_id_textField.getText().toLowerCase();

				if (e.getSource().equals(Delete_Button)) {
					delete(last, first, id);
				}
			}
		});
		Delete_Button.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		Delete_Button.setForeground(Color.BLUE);
		Delete_Button.setBounds(360, 359, 117, 29);
		contentPane.add(Delete_Button);

	}

	protected void Jtext_Field_res(String rlast, String rfirst, String room, int rfree, int rpaid, int rtotaln,
			String notes) {

		Room_textField.setText(room.toUpperCase());
		// Resident Info
		Resident_FirstName_textField.setText(rfirst.toUpperCase());
		Resident_LastName_textField.setText(rlast.toUpperCase());
		Resident_Freenights_formattedField.setValue(rfree);
		Resident_chargenights_formattedField.setValue(rpaid);
		Resident_totalnights_formattedField.setValue(rtotaln);
		Notes_textArea.setText(notes);

	}

	protected void Jtext_Field_guest(String glast, String gfirst, String room, int gfree, int gpaid, int gtotaln) {

		// Guest Info
		Guest_FirstName_textField.setText(gfirst.toUpperCase());
		Guest_LastName_textField.setText(glast.toUpperCase());
		Guest_freenights_formattedField.setValue(gfree);
		Guest_chargednights_formattedField.setValue(gpaid);
		Guest_totalnights_formattedField.setValue(gtotaln);
	}

	protected void clear() {
		Room_textField.setText("");

		// Guest Info
		Guest_FirstName_textField.setText("");
		Guest_LastName_textField.setText("");
		Guest_freenights_formattedField.setValue(0);
		Guest_chargednights_formattedField.setValue(0);
		Guest_totalnights_formattedField.setValue(0);

		Resident_FirstName_textField.setText("");
		Resident_LastName_textField.setText("");
		Resident_Freenights_formattedField.setValue(0);
		Resident_chargenights_formattedField.setValue(0);
		Resident_totalnights_formattedField.setValue(0);
		Notes_textArea.setText("");

	}

	protected void search_room(String room1, String table, String last1) {

		Connection conn = dbConnection.connect();
//		lastname, firstname, paidnights, freenights, notes, notedate, totalnights
		try {
			PreparedStatement ps = conn.prepareStatement(
					"SELECT lastname, firstname, freenights, paidnights, notes, notedate, totalnights FROM " + table
							+ " WHERE room= ?");
			ps.setString(1, room1);
//			pr.setString(1, room);
//			pr.setString(2, last);
//			System.out.println(guest_last);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				last = rs.getString("lastname");
				first = rs.getString("firstname");
				paid_nights = rs.getInt("paidnights");
				free_nights = rs.getInt("freenights");
				write = rs.getString("notes");
				totalnights = rs.getInt("totalnights");

				Jtext_Field_res(last, first, room1, free_nights, paid_nights, totalnights, write);

			}
			ps.close();

		} catch (SQLException e1) {
//			JOptionPane.showMessageDialog(null, e1.getMessage());
			e1.printStackTrace();
		}

	}

	protected void search_lastname(String room1, String table, String lastg) {

		Connection conn = dbConnection.connect();
//		lastname, firstname, paidnights, freenights, notes, notedate, totalnights
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT firstname, freenights, paidnights, totalnights FROM "
					+ table + " WHERE room= ? AND lastname= ?");
			ps.setString(1, room1);
			ps.setString(2, lastg);
//			pr.setString(1, room);
//			pr.setString(2, last);
//			System.out.println(guest_last);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				first = rs.getString("firstname");
				paid_nights = rs.getInt("paidnights");
				free_nights = rs.getInt("freenights");
				totalnights = rs.getInt("totalnights");
				guest_table = table;
//				System.out.println(guest_table);

				Jtext_Field_guest(lastg, first, room1, free_nights, paid_nights, totalnights);

			}
			ps.close();

		} catch (SQLException e1) {
//			JOptionPane.showMessageDialog(null, e1.getMessage());
			e1.printStackTrace();
		}

	}

	protected void register_sum(String idl) {
		Connection conn = dbConnection.connect();
		String id2;

		try {
			PreparedStatement ps = conn.prepareStatement("SELECT id, lastname, firstname FROM Login");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				id2 = rs.getString("id");
				first = rs.getString("firstname");
				last = rs.getString("lastname");
				
//				System.out.println(id2);
				String empty = "";
				int YesOrNo = JOptionPane.showConfirmDialog(null, id2 +" registered as " + first + " " + last,
						empty, JOptionPane.YES_NO_OPTION);
				if(YesOrNo == 1) {
					break;
				}
				
				
//				if (idl.equals(id2) && first.length() < 2 && last.length() < 2) {
//
//					JOptionPane.showMessageDialog(null, id2 + " is free for registry.");
//					break;
//				}
//				else {
//					JOptionPane.showConfirmDialog(null, id2 + " is registered with "+ first + " "+ last);
//					
//				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	protected void register(String lastl, String firstl, String idl) {
		String[] identification = { array of Strings of passwords when adding new persimisions };

		Connection conn = dbConnection.connect();
		String id2;

		try {
			PreparedStatement ps = conn.prepareStatement("SELECT lastname, firstname, id FROM Login");
//			ps.setString(1, idl);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				last = rs.getString("lastname");
				first = rs.getString("firstname");
				id2 = rs.getString("id");
				System.out.println(id2);
//				System.out.println(last.length());
				if (last.equals(lastl) && first.equals(firstl)) {
					JOptionPane.showMessageDialog(null, firstl + " " + lastl + " is already registered as " + id2);
					ps.close();
					break;

				}
//				if (last.equals(lastl) && first.equals(firstl) && id2.equals(idl)) {
//					JOptionPane.showMessageDialog(null, first + " " + last + " is already registered as " + id2);
//					break;
//				}
//
//				if (last.equals(lastl) && first.equals(firstl) && !(id2.equals(idl))) {
//					JOptionPane.showMessageDialog(null, first + " " + last + " is registered as " + id2);
//					break;
//				}
				for(int i = 0; i < identification.length; i++) {
					if(identification[i].equals(idl) && !(last.equals(lastl)) && !(first.equals(firstl))) {
						
						PreparedStatement update = conn
								.prepareStatement("UPDATE Login SET lastname= ?, firstname= ? WHERE id= ?");
						update.setString(1, lastl);
						update.setString(2, firstl);
						update.setString(3, idl);
						update.executeUpdate();
						update.close();
						ps.close();
						JOptionPane.showMessageDialog(null, firstl + " " + lastl + " has been registered.");
						register_firstname_textField.setText("");
						register_lastname_textField.setText("");
						register_id_textField.setText("");
						break;
					}
				}
			}		

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void delete(String lastl, String firstl, String idl) {

		String[] identification = { array of Strings of passwords };

		Connection conn = dbConnection.connect();

		for (int i = 0; i < identification.length; i++) {
			if (identification[i].equals(idl) && firstl.length() > 3 && lastl.length() > 3) {

				String empty = "";
				int YesOrNo = JOptionPane.showConfirmDialog(null, " Do you want to delete " + firstl + " " + lastl,
						empty, JOptionPane.YES_NO_OPTION);
				if (YesOrNo == 0) {
					try {
						PreparedStatement update = conn
								.prepareStatement("UPDATE Login SET lastname= ?, firstname= ? WHERE id= ?");
						update.setString(1, "");
						update.setString(2, "");
						update.setString(3, idl);
						update.executeUpdate();
						update.close();
						JOptionPane.showMessageDialog(null, firstl + " " + lastl + " has been deleted.");
						register_firstname_textField.setText("");
						register_lastname_textField.setText("");
						register_id_textField.setText("");

					} catch (SQLException e) {

						e.printStackTrace();
					}
				}
				if (YesOrNo == 1) {
					JOptionPane.showMessageDialog(null, firstl + " " + lastl + " still in the system.");
					register_firstname_textField.setText("");
					register_lastname_textField.setText("");
					register_id_textField.setText("");

				}
			}
		}
	}

	// update the names of the resident and guest
	protected void update_name(String table, String last1, String first1, int free, int paid, int total, String room) {

//		System.out.println("number activation: " + number_activation + " "+last +" " + first);

		// ------------------------------------------------------------
		Connection conn = dbConnection.connect();

		try {

			if (last1.length() > 2 && first1.length() > 2) {
				PreparedStatement update = conn
						.prepareStatement("UPDATE " + table + " SET lastname= ?, firstname= ?, freenights= ?,"
								+ "paidnights= ?, totalnights= ? WHERE room= ?");
				update.setString(1, last1);
				update.setString(2, first1);
				update.setInt(3, free);
				update.setInt(4, paid);
				update.setInt(5, total);
				update.setString(6, room);
				update.executeUpdate();
				update.close();
				conn.close();
				JOptionPane.showMessageDialog(null, "Room " + room + " has been updated.");
			}

//				System.out.println(current);

		} catch (SQLException e1) {
//				JOptionPane.showMessageDialog(null, e1.getMessage());
			e1.printStackTrace();
		}

	}

	protected void delete_nights(String table, String room) {

		Connection conn = dbConnection.connect();

		try {
			PreparedStatement pr = conn.prepareStatement("SELECT * FROM " + table + " WHERE room= ?");
			pr.setString(1, room);
			ResultSet rs = pr.executeQuery();

			while (rs.next()) {

//					System.out.println("Paidnights: " + paid_nights);
				// totalnights variable is the sum from totalnights from database plus nights by
				// the user
				totalnights = rs.getInt("totalnights"); // column must be set on 0
				free_nights = rs.getInt("freenights");
				paid_nights = rs.getInt("paidnights");
				n1 = rs.getString("one"); // column must be set as ""
				n2 = rs.getString("two");
				n3 = rs.getString("three");
				n4 = rs.getString("four");
				n5 = rs.getString("five");
				n6 = rs.getString("six");
				n7 = rs.getString("seven");
				n8 = rs.getString("eight");
				n9 = rs.getString("nine");
				n10 = rs.getString("ten");
				n11 = rs.getString("eleven");
				n12 = rs.getString("twelve");
				n13 = rs.getString("thirteen");
				n14 = rs.getString("fourteen");
				n15 = rs.getString("fifteen");
				n16 = rs.getString("sixteen");
				n17 = rs.getString("seventeen");
				n18 = rs.getString("eighteen");
				n19 = rs.getString("nineteen");
				n20 = rs.getString("twenty");
				n21 = rs.getString("twentyone");
				n22 = rs.getString("twentytwo");
				n23 = rs.getString("twentythree");
				n24 = rs.getString("twentyfour");
				n25 = rs.getString("twentyfive");
				n26 = rs.getString("twentysix");
				n27 = rs.getString("twentyseven");
				n28 = rs.getString("twentyeight");
				n29 = rs.getString("twentynine");
				n30 = rs.getString("thirty");
				n1l = rs.getString("oneL");
				n2l = rs.getString("twoL");
				n3l = rs.getString("threeL");
				n4l = rs.getString("fourL");
				n5l = rs.getString("fiveL");
				n6l = rs.getString("sixL");
				n7l = rs.getString("sevenL");
				n8l = rs.getString("eightL");
				n9l = rs.getString("nineL");
				n10l = rs.getString("tenL");
				n11l = rs.getString("elevenL");
				n12l = rs.getString("twelveL");
				n13l = rs.getString("thirteenL");
				n14l = rs.getString("fourteenL");
				n15l = rs.getString("fifteenL");
				n16l = rs.getString("sixteenL");
				n17l = rs.getString("seventeenL");
				n18l = rs.getString("eighteenL");
				n19l = rs.getString("nineteenL");
				n20l = rs.getString("twentyL");
				n21l = rs.getString("twentyoneL");
				n22l = rs.getString("twentytwoL");
				n23l = rs.getString("twentythreeL");
				n24l = rs.getString("twentyfourL");
				n25l = rs.getString("twentyfiveL");
				n26l = rs.getString("twentysixL");
				n27l = rs.getString("twentysevenL");
				n28l = rs.getString("twentyeightL");
				n29l = rs.getString("twentynineL");
				n30l = rs.getString("thirtyL");

				if (free_nights < 7) {
					if (free_nights == 1) {
						n2 = "";
						n3 = "";
						n2l = "";
						n3l = "";
						break;
					}
					if (free_nights == 2) {
						n3 = "";
						n4 = "";
						n3l = "";
						n4l = "";
						break;
					}
					if (free_nights == 3) {
						n4 = "";
						n5 = "";
						n4l = "";
						n5l = "";
						break;
					}
					if (free_nights == 4) {
						n5 = "";
						n6 = "";
						n5l = "";
						n6l = "";
						break;
					}
					if (free_nights == 5) {
						n6 = "";
						n6l = "";
						break;
					}

				}
				if (totalnights > 6) {
					if (paid_nights == 1) {
						n7 = "";
						n8 = "";
						n7l = "";
						n8l = "";
						break;
					}
					if (paid_nights == 2) {
						n8 = "";
						n9 = "";
						n8l = "";
						n9l = "";
						break;
					}
					if (paid_nights == 3) {
						n9 = "";
						n10 = "";
						n9l = "";
						n10l = "";
						break;
					}
					if (paid_nights == 4) {
						n10 = "";
						n11 = "";
						n10l = "";
						n11l = "";
						break;
					}
					if (paid_nights == 5) {
						n11 = "";
						n12 = "";
						n11l = "";
						n12l = "";
					}
					if (paid_nights == 6) {
						n12 = "";
						n13 = "";
						n12l = "";
						n13l = "";
						break;
					}
					if (paid_nights == 7) {
						n13 = "";
						n14 = "";
						n13l = "";
						n14l = "";
						break;
					}
					if (paid_nights == 8) {
						n14 = "";
						n15 = "";
						n14l = "";
						n15l = "";
						break;
					}
					if (paid_nights == 9) {
						n15 = "";
						n16 = "";
						n15l = "";
						n16l = "";
						break;
					}
					if (paid_nights == 10) {
						n16 = "";
						n17 = "";
						n16l = "";
						n17l = "";
						break;
					}
					if (paid_nights == 11) {
						n17 = "";
						n18 = "";
						n17l = "";
						n18l = "";
						break;
					}
					if (paid_nights == 12) {
						n18 = "";
						n19 = "";
						n18l = "";
						n19l = "";
						break;
					}
					if (paid_nights == 13) {
						n19 = "";
						n20 = "";
						n19l = "";
						n20l = "";
						break;
					}
					if (paid_nights == 14) {
						n20 = "";
						n21 = "";
						n20l = "";
						n21l = "";
						break;
					}
					if (paid_nights == 15) {
						n21 = "";
						n22 = "";
						n21l = "";
						n22l = "";
						break;
					}
					if (paid_nights == 16) {
						n22 = "";
						n23 = "";
						n22l = "";
						n23l = "";
						break;
					}
					if (paid_nights == 17) {
						n23 = "";
						n24 = "";
						n23l = "";
						n24l = "";
						break;
					}
					if (paid_nights == 18) {
						n24 = "";
						n25 = "";
						n24l = "";
						n25l = "";
						break;
					}
					if (paid_nights == 19) {
						n25 = "";
						n26 = "";
						n25l = "";
						n26l = "";
						break;
					}
					if (paid_nights == 20) {
						n26 = "";
						n27 = "";
						n26l = "";
						n27l = "";
						break;
					}
					if (paid_nights == 21) {
						n27 = "";
						n28 = "";
						n27l = "";
						n28l = "";
						break;
					}
					if (paid_nights == 22) {
						n28 = "";
						n29 = "";
						n28l = "";
						n29l = "";
						break;
					}
					if (paid_nights == 23) {
						n29 = "";
						n30 = "";
						n29l = "";
						n30l = "";
						break;
					}

				}
			}

			PreparedStatement update = conn.prepareStatement("UPDATE " + table
					+ " SET totalnights= ?, freenights= ?, paidnights=?, one= ?, two= ?, three= ?, four= ?, five= ?,"
					+ " six= ?, seven= ?, eight= ?, nine= ?, ten= ?, eleven= ?, twelve= ?, thirteen= ?, fourteen= ?,"
					+ " fifteen= ?, sixteen= ?, seventeen= ?, eighteen= ?, nineteen= ?, twenty= ?, twentyone= ?,"
					+ " twentytwo= ?, twentythree= ?, twentyfour= ?, twentyfive= ?, twentysix= ?, twentyseven= ?,"
					+ " twentyeight= ?, twentynine= ?, thirty= ?, oneL= ?, twoL= ?, threeL= ?, fourL= ?, fiveL= ?,"
					+ " sixL= ?, sevenL= ?, eightL= ?, nineL= ?, tenL= ?, elevenL= ?, twelveL= ?, thirteenL= ?, fourteenL= ?,"
					+ " fifteenL= ?, sixteenL= ?, seventeenL= ?, eighteenL= ?, nineteenL= ?, twentyL= ?, twentyoneL= ?,"
					+ " twentytwoL= ?, twentythreeL= ?, twentyfourL= ?, twentyfiveL= ?, twentysixL= ?, twentysevenL= ?,"
					+ " twentyeightL= ?, twentynineL= ?, thirtyL= ? WHERE room= ?");
			update.setInt(1, totalnights);
			update.setInt(2, free_nights);
			update.setInt(3, paid_nights);
			update.setString(4, n1);
			update.setString(5, n2);
			update.setString(6, n3);
			update.setString(7, n4);
			update.setString(8, n5);
			update.setString(9, n6);
			update.setString(10, n7);
			update.setString(11, n8);
			update.setString(12, n9);
			update.setString(13, n10);
			update.setString(14, n11);
			update.setString(15, n12);
			update.setString(16, n13);
			update.setString(17, n14);
			update.setString(18, n15);
			update.setString(19, n16);
			update.setString(20, n17);
			update.setString(21, n18);
			update.setString(22, n19);
			update.setString(23, n20);
			update.setString(24, n21);
			update.setString(25, n22);
			update.setString(26, n23);
			update.setString(27, n24);
			update.setString(28, n25);
			update.setString(29, n26);
			update.setString(30, n27);
			update.setString(31, n28);
			update.setString(32, n29);
			update.setString(33, n30);
			update.setString(34, n1l);
			update.setString(35, n2l);
			update.setString(36, n3l);
			update.setString(37, n4l);
			update.setString(38, n5l);
			update.setString(39, n6l);
			update.setString(40, n7l);
			update.setString(41, n8l);
			update.setString(42, n9l);
			update.setString(43, n10l);
			update.setString(44, n11l);
			update.setString(45, n12l);
			update.setString(46, n13l);
			update.setString(47, n14l);
			update.setString(48, n15l);
			update.setString(49, n16l);
			update.setString(50, n17l);
			update.setString(51, n18l);
			update.setString(52, n19l);
			update.setString(53, n20l);
			update.setString(54, n21l);
			update.setString(55, n22l);
			update.setString(56, n23l);
			update.setString(57, n24l);
			update.setString(58, n25l);
			update.setString(59, n26l);
			update.setString(60, n27l);
			update.setString(61, n28l);
			update.setString(62, n29l);
			update.setString(63, n30l);
			update.setString(64, room);
			update.executeUpdate();
			update.close();
			conn.close();

		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	protected void current_guest_nights(String table, String room1, String last1, int nights, int freenights,
			int paidnights, int totalnights) {

		Connection conn = dbConnection.connect();

		try {

			PreparedStatement update = conn.prepareStatement("UPDATE " + table
					+ " SET freenights= ?, paidnights= ?, totalnights= ? WHERE room= ? AND lastname= ?");
			update.setInt(1, freenights);
			update.setInt(2, paidnights);
			update.setInt(3, totalnights);
			update.setString(4, room1);
			update.setString(5, last1);
			update.executeUpdate();

			update.close();
			conn.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	protected void read_file_update(String filename) throws IOException {
		Connection conn = dbConnection.connect();

		int comma;

		try {
			List<String> lines = Files.readAllLines(Paths.get(filename));
			PreparedStatement ps = conn.prepareStatement("SELECT room FROM Residents"); // loops thru the rooms in the
																						// database
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				room = rs.getString("room");
				for (String line : lines) {
					line = line.replace("\"", "").toLowerCase(); // clears the quotes
					line = line.replaceAll("[,,]", "$0 ").replaceAll("\\s", "     "); // space after each comma
//					System.out.println(line);
//					System.out.println("room: " + room);
					if (line.contains(room)) {
//						System.out.println("room: " + room);
//						System.out.print(line.substring(0,line.length() -4));
						comma = line.indexOf(","); // index position where the comma is
//						System.out.println(comma);
						last = line.substring(0, comma).trim();
						first = line.substring(comma + 1, line.length() - 10).trim();
						PreparedStatement update = conn
								.prepareStatement("UPDATE Residents SET lastname= ?, firstname= ? WHERE room= ?");
						update.setString(1, last);
						update.setString(2, first);
						update.setString(3, room);
						update.executeUpdate();

//						System.out.println();
//						System.out.println(last.trim());
//						System.out.println(first.trim());

					}

				}

//				String[] result = line.split(",");
//				for(String s : result) {
//					System.out.println(s + " - ");
//				}
			}
			conn.close();
			JOptionPane.showMessageDialog(null, "File has been updated into the database.");

//			Scanner inputSteam = new Scanner(new File(filename));
//			inputSteam.next();		//ignores the first line 
//			while(inputSteam.hasNext()) {
//				String data = inputSteam.next().toLowerCase();
//				if(data.equals("7f2")) {
//					System.out.println(data);
//				}
//				
//				
//			}
//			
//			
//			inputSteam.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Log Out
	private void close() {
		WindowEvent winClsingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClsingEvent);

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Edit frame = new Edit();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
