package mysql;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.activation.*;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.PasswordAuthentication;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;

import javax.swing.JFormattedTextField;

import java.awt.BorderLayout;
import java.awt.Color;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.sql.ResultSet;
import dbUtil.dbConnection;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JCheckBox;
import javax.swing.border.MatteBorder;

import java.awt.SystemColor;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class Database_Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblLastName;
	private JLabel lblFirstName;
	private JLabel lblRoom;
	private JTextField Resident_LastName_textField;
	private JTextField Resident_FirstName_textField;
	private JTextField Guest_LastName_textField;
	private JTextField Guest_FirstName_textField;
	private JTextField DBstatus_textField;
	private String connected = ""; // string for database status
	private JButton Search_Room_Button, Save_Resident_Button, Preview_Nights_Button, B_Guest_Search_Button;
	private JTextField lastname_textField;
	private JTextField firstanem_textField;
	private JTextField room_textField;
	private JTextField B_Room_textField;
	private JFormattedTextField freenights_formattedField, paidNights_formattedField, B_Nights_formattedTextField,
			Calendar_formattedTextField, Pass_Calendar_formattedTextField;
	private JFormattedTextField total_Nights_formattedField;
	private String room, last, first, guest_last, guest_first;
	private String write; // notes left for the resident and or guest
	private String string_calendar, string_calendarAhead, string_calendar30days; // calendar Dates to save calendar
	private String string_calendar30days_plusOne;
	private Calendar calendar30days_plusOne;
	private String resident_table; // Strings for table's name in the database to use in methods related to the
									// database // dates for use and calculations
	private String guest_table;
	private String n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, n13, n14, n15, n16, n17, n18, n19, n20, n21, n22,
			n23, n24, n25, n26, n27, n28, n29, n30, n31; // variable to be use to hold the date as a string from
															// database, end date

	private String n1d, n2d, n3d, n4d, n5d, n6d, n7d, n8d, n9d, n10d, n11d, n12d, n13d, n14d, n15d, n16d, n17d, n18d,
			n19d, n20d, n21d, n22d, n23d, n24d, n25d, n26d, n27d, n28d, n29d, n30d, n31d, dat;

	private String n1l, n2l, n3l, n4l, n5l, n6l, n7l, n8l, n9l, n10l, n11l, n12l, n13l, n14l, n15l, n16l, n17l, n18l,
			n19l, n20l, n21l, n22l, n23l, n24l, n25l, n26l, n27l, n28l, n29l, n30l, n31l; // variable to be use to hold
																							// the date as a string from
																							// database, start date
	private int free_nights;
	private int paid_nights;
	private int totalnights;
	private int result_nights;
	private int nights;
	private int current;

	private String notes_date;
	private Calendar calendar_date, calendar_ahead, calendar_30days; // calendar variables
	private SimpleDateFormat date; // format for the date
	private JTextField info_textField;
	private JTextField Write_notes_textField;
	private JButton Save_Notes_Button;
	private JButton Save_Night_Button;
	private JButton Search_Records_Button;
	private JButton Close_Button;
	private JButton Current_Guest_Button;
	private JButton SearchGuest_Button;
	private JTextField Date_display_textField;
	private Hashtable<Integer, String> match; // hasttable for match_resi_with_guest
	private JTextArea infofile_textArea, infofile1_textArea;
	private JScrollPane infofile_scrollPane, infofile1_scrollPane;
	private JTextArea Notes_textArea;
	private JScrollPane scrollPane;
	private JTextArea resident_log_textArea;
	private JTextArea guest_log_textArea;
	private JScrollPane resident_log_scrollPane;

	User user;
//	Object rows[];

	private JTextField info_guest_textField;
	private JTextField Records_Found_textField;
	private JCheckBox Add_New_Guest_Night_CheckBox, clog;
	private JCheckBox Add_Night_Guest_CheckBox, clog1;
	private JCheckBox Save_Resident_CheckBox, clog3;
	private JCheckBox Add_curr_guest_night_CheckBox, clog4;
	private JTextField OnDuty_textField;
	private String staff;
	private JTextArea Resident_info_textArea;
	private JScrollPane Resident_info_scrollPane;
	private JTextField Resident_file_info_textField;

	public Database_Frame() throws ClassNotFoundException {
		initComponenets();
		calendar();
		update_nights();

//		show_table();
		// show_data();

	}

	public Database_Frame(String staff) throws ClassNotFoundException {
		initComponenets();
		calendar();
		OnDuty_textField.setText(staff.toUpperCase());

//		show_table();
		// show_data();
	}

	private void initComponenets() throws ClassNotFoundException {
		// connection = sqliteConnection.dbConnector();

		setTitle("Overnight Records");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1311, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Jpanel
		JPanel Resident_panel = new JPanel();
		Resident_panel.setBackground(Color.WHITE);
		Resident_panel.setBorder(new MatteBorder(0, 1, 0, 0, (Color) Color.BLUE));
		Resident_panel.setBounds(830, 30, 461, 211);
		contentPane.add(Resident_panel);
		Resident_panel.setLayout(null);

		// --------------------------------------------------------------
		// JLabel
		lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblLastName.setBackground(Color.LIGHT_GRAY);
		lblLastName.setEnabled(false);
		lblLastName.setBounds(421, 60, 78, 16);
		contentPane.add(lblLastName);

		lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblFirstName.setBackground(Color.LIGHT_GRAY);
		lblFirstName.setEnabled(false);
		lblFirstName.setBounds(576, 60, 78, 16);
		contentPane.add(lblFirstName);

		lblRoom = new JLabel("Room ");
		lblRoom.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblRoom.setBackground(Color.LIGHT_GRAY);
		lblRoom.setEnabled(false);
		lblRoom.setBounds(768, 155, 40, 16);
		contentPane.add(lblRoom);

		JLabel lblResident = new JLabel("Resident");
		lblResident.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblResident.setBackground(Color.LIGHT_GRAY);
		lblResident.setEnabled(false);
		lblResident.setBounds(425, 12, 78, 16);
		contentPane.add(lblResident);

		JLabel Guest_Label = new JLabel("Guest");
		Guest_Label.setBackground(Color.LIGHT_GRAY);
		Guest_Label.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		Guest_Label.setEnabled(false);
		Guest_Label.setBounds(421, 178, 61, 16);
		contentPane.add(Guest_Label);

		JLabel Guest_Last_NameLabel = new JLabel("Last Name");
		Guest_Last_NameLabel.setBackground(Color.LIGHT_GRAY);
		Guest_Last_NameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		Guest_Last_NameLabel.setEnabled(false);
		Guest_Last_NameLabel.setBounds(421, 225, 78, 16);
		contentPane.add(Guest_Last_NameLabel);

		JLabel lblNights_Guest = new JLabel("Night(s) ");
		lblNights_Guest.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblNights_Guest.setBackground(Color.LIGHT_GRAY);
		lblNights_Guest.setEnabled(false);
		lblNights_Guest.setBounds(765, 98, 61, 21);
		contentPane.add(lblNights_Guest);

		JLabel Guest_First_NameLabel = new JLabel("First Name");
		Guest_First_NameLabel.setBackground(Color.LIGHT_GRAY);
		Guest_First_NameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		Guest_First_NameLabel.setEnabled(false);
		Guest_First_NameLabel.setBounds(576, 225, 78, 16);
		contentPane.add(Guest_First_NameLabel);

		JLabel DBStatus_Label = new JLabel("DB Status");
		DBStatus_Label.setBounds(6, 10, 78, 16);
		DBStatus_Label.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(DBStatus_Label);

		// -------------------------------------------------------------
		// -------------------------------------------------------------
		// Buttons
		Search_Records_Button = new JButton("Search History");
		Search_Records_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				room = B_Room_textField.getText().toLowerCase();
				guest_last = Guest_LastName_textField.getText().toLowerCase();

				String[] guest = { "Guest1", "Guest2", "Guest3", "Guest4", "Guest5", "Guest6", "Guest7", "Guest8",
						"Guest9", "Guest10", "Guest11", "Guest12", "Guest13", "Guest14", "Guest15", "Guest16",
						"Guest17", "Guest18", "Guest19", "Guest20" };

				String filename = "infohistory.txt";

				String fileinfo = "loghistory.txt";
				if (e.getSource().equals(Search_Records_Button) && room.length() > 2 && room.length() < 4) {
//					JOptionPane.showMessageDialog(null,
//							"Reminder, to search the guest can be done only by the lastname");

					info_guest_textField.setText("History for room # " + room);
					if (guest_last.length() < 2) {

						try {
							PrintWriter in = new PrintWriter(filename);
							in.close();

							for (int i = guest.length; i-- > 0;) {
//								System.out.println(tables[i]);
								search_history(guest[i], room);
								info_file(filename);

							}
							info_file_show(filename);

							PrintWriter n2 = new PrintWriter(fileinfo);
							n2.close();

							for (int i = guest.length; i-- > 0;) {
//								System.out.println(tables[i]);
								search_history(guest[i], room);
								info_file(fileinfo);
							}
							info_file_show(fileinfo);

//								PrintWriter in = new PrintWriter(filename);
//								in.close();

						} catch (FileNotFoundException e1) {

							e1.printStackTrace();
						} catch (IOException eio) {

							eio.printStackTrace();
						}
					} else {
						JOptionPane.showMessageDialog(null, "Erase the last name of the Guest");
					}

				}
			}
		});

		Search_Records_Button.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		Search_Records_Button.setForeground(Color.BLUE);
		Search_Records_Button.setBounds(731, 28, 97, 35);
		contentPane.add(Search_Records_Button);

		// -----------------------------------------------------------------------
		Search_Room_Button = new JButton("Search Room");
		Search_Room_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				resident_table = "Residents";
				room = B_Room_textField.getText().toLowerCase();
				room.trim();

				String filename = "residentsearch.txt"; // ref. info_file_show method
				String filelog = "logsearch.txt"; // ref. info_file.show method

				if (e.getSource().equals(Search_Room_Button)) {

					try {
						if (room.length() > 2 && room.length() < 4) {
							search_room(room);
							info_textField.setText("Resident Info: ");
							reReset();

							PrintWriter in = new PrintWriter(filename);
							in.close();
							search_history(resident_table, room);
							Resident_file_info_textField.setText("Logs days for room # " + room);
							resident_info_file(filename);
							info_file_show(filename);
							PrintWriter log = new PrintWriter(filelog);
							log.close();
							resident_info_file(filelog);
							info_file_show(filelog);

						} else {
							JOptionPane.showMessageDialog(null, "Check your Input, invalid room number");

						}

					} catch (Exception e2) {
//						JOptionPane.showMessageDialog(null, e2);
						System.out.println(e2);

					}
					// ------------

				}
			}
		});
		Search_Room_Button.setForeground(Color.BLUE);
		Search_Room_Button.setBackground(Color.BLACK);
//		btnSearchRoom.setBorder(new LineBorder(new Color(0, 0, 255)));
		Search_Room_Button.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		Search_Room_Button.setBounds(731, 170, 97, 35);
//		btnSearchRoom.addActionListener(this);
		contentPane.add(Search_Room_Button);

		// --------------------------------------------------------------------
		Save_Resident_Button = new JButton("Save Resident");
		Save_Resident_Button.setEnabled(false);
		Save_Resident_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(Save_Resident_Button)) {
					last = Resident_LastName_textField.getText().toLowerCase();
					first = Resident_FirstName_textField.getText().toLowerCase();
					room = B_Room_textField.getText().toLowerCase();
					resident_table = "Residents";

					if (room.length() < 2 || last.length() < 2 || first.length() < 2) {
						JOptionPane.showMessageDialog(null, "Check your input");
					} else {
						update_name(resident_table, last, first, room);
					}

				}
			}
		});
		Save_Resident_Button.setBackground(Color.GRAY);
		Save_Resident_Button.setForeground(Color.BLUE);
		// btnUpdate.setBorder(new LineBorder(new Color(0, 0, 255)));
		Save_Resident_Button.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		Save_Resident_Button.setBounds(6, 75, 101, 42);
//		btnUpdate.addActionListener(this);
		contentPane.add(Save_Resident_Button);

		// -----------------------------------------------------------------------
		Preview_Nights_Button = new JButton("Preview # Nights");
		Preview_Nights_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(Preview_Nights_Button)) {
					pass_calendar();
				}
			}
		});
		Preview_Nights_Button.setForeground(Color.BLUE);
		Preview_Nights_Button.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		Preview_Nights_Button.setBounds(119, 75, 101, 42);
//		Preview_Nights_Button.addActionListener(this);
		contentPane.add(Preview_Nights_Button);

		// -----------------------------------------------------------------------
		// Save Guest Button
		B_Guest_Search_Button = new JButton("NEW GUEST");
		B_Guest_Search_Button.setEnabled(false);
		B_Guest_Search_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				guest_last = Guest_LastName_textField.getText().toLowerCase();
				guest_first = Guest_FirstName_textField.getText().toLowerCase();
				room = B_Room_textField.getText().toLowerCase();
				nights = ((Number) B_Nights_formattedTextField.getValue()).intValue();
				resident_table = "Residents";
				String empty = "";
				if (e.getSource().equals(B_Guest_Search_Button) && clog.isSelected()) {

					if (guest_first.length() > 2 && guest_first.length() > 2) {
						if (nights > 0 && nights < 3) {

							int YesOrNo = JOptionPane.showConfirmDialog(null,
									"New guest " + guest_last.toUpperCase() + " " + guest_first.toUpperCase()
											+ " will be saved to room " + room.toUpperCase() + " with " + nights
											+ " night(s).",
									empty, JOptionPane.YES_NO_OPTION);
							if (YesOrNo == 0) {
								addnew_guest(room, guest_last);
								update_name(guest_table, guest_last, guest_first, room);
								save_nights(guest_table, nights, room);
//								System.out.println("Guest_Table: " + guest_table);
								save_nights(resident_table, nights, room);

							}
							if (YesOrNo == 1) {
								JOptionPane.showMessageDialog(null, "The input has been cancelled");

							}

						} else {
							JOptionPane.showMessageDialog(null, "Check your input in nights");
						}

					} else {
						JOptionPane.showMessageDialog(null, "Check your Input");
					}

				}

//					night_to_guest(room, guest_last, guest_first);

//					System.out.println(guest_table);
			}

		});

		B_Guest_Search_Button.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		B_Guest_Search_Button.setForeground(Color.BLUE);
		B_Guest_Search_Button.setBounds(410, 113, 100, 30);
//		B_Guest_Search_Button.addActionListener(this);
		contentPane.add(B_Guest_Search_Button);

		// ------------------------------------------------------------------------
		// Notes Button
		Save_Notes_Button = new JButton("Save Notes");
		Save_Notes_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(Save_Notes_Button)) {
					room = room_textField.getText().toLowerCase();
					write = Write_notes_textField.getText();
					if (room.length() < 3 && room.length() > 3) {
						JOptionPane.showMessageDialog(null, "Enter a three digit room number");
					} else {
						save_notes(write, room);
						reReset();
					}

				}

			}
		});
		Save_Notes_Button.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		Save_Notes_Button.setForeground(Color.BLUE);
		Save_Notes_Button.setBounds(6, 136, 101, 40);
//		Notes_Button.addActionListener(this);
		contentPane.add(Save_Notes_Button);

		// --------------------------------------------------------------------
		Save_Night_Button = new JButton("SAVE NIGHT");
		Save_Night_Button.setEnabled(false);
		Save_Night_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(Save_Night_Button)) {
					nights = ((Number) B_Nights_formattedTextField.getValue()).intValue();
//					guest_first = Guest_FirstName_textField.getText().toLowerCase().trim();
//					guest_last = Guest_LastName_textField.getText().toLowerCase();
//					last = Resident_LastName_textField.getText().toLowerCase();
//					first = Resident_FirstName_textField.getText().toLowerCase();
					room = B_Room_textField.getText().toLowerCase();
					System.out.println(room.length());

					resident_table = "Residents";

					String empty = "";
					if (nights > 0 && nights < 3) {
						int YesOrNo = JOptionPane.showConfirmDialog(null,
								nights + " night(s) will be saved to room " + room, empty, JOptionPane.YES_NO_OPTION);
						if (YesOrNo == 0) {
							if (room.length() > 2 && room.length() < 4) {
								find_guest(room);
								System.out.println("save night night: " + nights);
								System.out.println("save night button guest table: " + guest_table);

								save_nights(guest_table, nights, room);
								save_nights(resident_table, nights, room);
								reReset();
							} else {
								JOptionPane.showMessageDialog(null, "Check your room input");
							}

//							save_nights(resident_table, nights, room);
//							night_to_guest(room, guest_last, guest_first);
//							System.out.println("Save night button: " + guest_table);
//							save_nights(guest_table, nights, room);
//							reReset();

//							if (guest_first.length() > 3 && guest_last.length() > 3) {
//								// number_activation will activate update_name method for guest name
//								
//								save_nights(resident_table);
//								addnight_toguest();
//								save_nights(guest_table);
////								System.out.println("Save Button = " + current);
//								infofile_textArea.setText("");
//								reReset();
//							}
						}

						if (YesOrNo == 1) {
							JOptionPane.showMessageDialog(null, "Nothing was saved");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Check your input, Only 1 or 2 nights are allowed.");
					}

				}
			}
		});
		Save_Night_Button.setFont(new Font("Lucida Grande", Font.BOLD, 11));
		Save_Night_Button.setForeground(Color.BLUE);
		Save_Night_Button.setBounds(410, 78, 100, 30);
//		Save_Night_Button.addActionListener(this);
		contentPane.add(Save_Night_Button);

		// ----------------------------------------------------------------------
		Current_Guest_Button = new JButton("CURR.. GUEST");
		Current_Guest_Button.setEnabled(false);
		Current_Guest_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] guest = { "Guest1", "Guest2", "Guest3", "Guest4", "Guest5", "Guest6", "Guest7", "Guest8",
						"Guest9", "Guest10", "Guest11", "Guest12", "Guest13", "Guest14", "Guest15", "Guest16",
						"Guest17", "Guest18", "Guest19", "Guest20" };

				nights = ((Number) B_Nights_formattedTextField.getValue()).intValue();
				guest_first = Guest_FirstName_textField.getText().toLowerCase();
				guest_last = Guest_LastName_textField.getText().toLowerCase();
				room = B_Room_textField.getText().toLowerCase();

				resident_table = "Residents";

				if (e.getSource().equals(Current_Guest_Button)) {
					if (nights > 0 && nights < 3) {
						for (int i = 0; i < guest.length; i++) {
							current_guest_nights(guest[i], room, guest_last, nights);
//							guest_table = guest[i];
//							save_nights(guest_table, nights, room);
//							save_nights(resident_table, nights, room);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Check your input in Nights");
					}

//					System.out.println(guest_table);
//					save_nights(guest_table, nights, room);
//					save_nights(resident_table, nights, room);
//					JOptionPane.showMessageDialog(null, nights +" night(s) has been saved to room "+ room);
				}
			}
		});
		Current_Guest_Button.setForeground(Color.BLUE);
		Current_Guest_Button.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		Current_Guest_Button.setBounds(410, 148, 100, 30);
		contentPane.add(Current_Guest_Button);

		// ------------------------------------------------------------------
		Add_New_Guest_Night_CheckBox = new JCheckBox("Add New Guest & Night");
//		NewGuest_CheckBox.setSelected(state);
		Add_New_Guest_Night_CheckBox.setEnabled(true);
		Add_New_Guest_Night_CheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clog = (JCheckBox) e.getSource();

				if (clog.isSelected()) {
//					B_Nights_formattedTextField.setEditable(false);
					Resident_FirstName_textField.setEditable(false);
					Resident_LastName_textField.setEditable(false);
					Write_notes_textField.setEditable(false);
					Save_Resident_Button.setEnabled(false);
					B_Guest_Search_Button.setEnabled(true);
					Add_Night_Guest_CheckBox.setEnabled(false);
					Search_Records_Button.setEnabled(false);
					Search_Room_Button.setEnabled(false);
					Save_Resident_CheckBox.setEnabled(false);
					B_Nights_formattedTextField.setValue(0);
					B_Room_textField.setText("");
					Guest_FirstName_textField.setText("");
					Guest_LastName_textField.setText("");
					Add_curr_guest_night_CheckBox.setEnabled(false);

				} else {
//					B_Nights_formattedTextField.setEditable(true);
					Resident_FirstName_textField.setEditable(true);
					Resident_LastName_textField.setEditable(true);
					Write_notes_textField.setEditable(true);
					Save_Resident_Button.setEnabled(true);
					B_Guest_Search_Button.setEnabled(false);
					Add_Night_Guest_CheckBox.setEnabled(true);
					Search_Records_Button.setEnabled(true);
					Search_Room_Button.setEnabled(true);
					Save_Resident_CheckBox.setEnabled(true);
					Add_curr_guest_night_CheckBox.setEnabled(true);

				}

			}
		});
		Add_New_Guest_Night_CheckBox.setForeground(Color.BLUE);
		Add_New_Guest_Night_CheckBox.setBounds(510, 116, 188, 24);
		contentPane.add(Add_New_Guest_Night_CheckBox);

		// -------------------------------------------------------
		Add_Night_Guest_CheckBox = new JCheckBox("Add Night(s) to Guest");
//		CurrentGuest_CheckBox.setSelected(state);
		Add_Night_Guest_CheckBox.setEnabled(true);
		Add_Night_Guest_CheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clog1 = (JCheckBox) e.getSource();

				if (clog1.isSelected()) {
					Add_New_Guest_Night_CheckBox.setEnabled(false);
					Save_Night_Button.setEnabled(true);
					Save_Resident_Button.setEnabled(false);
					Search_Records_Button.setEnabled(false);
					Search_Room_Button.setEnabled(false);
					Resident_FirstName_textField.setEnabled(false);
					Resident_LastName_textField.setEnabled(false);
					Guest_FirstName_textField.setEnabled(false);
					Guest_LastName_textField.setEnabled(false);
					Save_Resident_CheckBox.setEnabled(false);
					Add_curr_guest_night_CheckBox.setEnabled(false);

				} else {
					Add_New_Guest_Night_CheckBox.setEnabled(true);
					Save_Night_Button.setEnabled(false);
					Save_Resident_Button.setEnabled(true);
					Search_Records_Button.setEnabled(true);
					Search_Room_Button.setEnabled(true);
					Resident_FirstName_textField.setEnabled(true);
					Resident_LastName_textField.setEnabled(true);
					Guest_FirstName_textField.setEnabled(true);
					Guest_LastName_textField.setEnabled(true);
					Save_Resident_CheckBox.setEnabled(true);
					Add_curr_guest_night_CheckBox.setEnabled(true);

				}

			}
		});
		Add_Night_Guest_CheckBox.setForeground(Color.BLUE);
		Add_Night_Guest_CheckBox.setBounds(511, 80, 204, 23);
		contentPane.add(Add_Night_Guest_CheckBox);
		// --------------------------------------------------------------
		// check Box Save Resident
		Save_Resident_CheckBox = new JCheckBox("Save Resident");
		Save_Resident_CheckBox.setEnabled(true);
		Save_Resident_CheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clog3 = (JCheckBox) e.getSource();

				if (clog3.isSelected()) {

					Add_New_Guest_Night_CheckBox.setEnabled(false);
					Add_Night_Guest_CheckBox.setEnabled(false);
					Guest_FirstName_textField.setEnabled(false);
					Guest_LastName_textField.setEnabled(false);
					Save_Resident_Button.setEnabled(true);
					B_Nights_formattedTextField.setEnabled(false);
					Search_Room_Button.setEnabled(false);
					Search_Records_Button.setEnabled(false);
					B_Room_textField.setText("");
					Save_Notes_Button.setEnabled(false);
					Add_curr_guest_night_CheckBox.setEnabled(false);

				} else {

					Add_New_Guest_Night_CheckBox.setEnabled(true);
					Add_Night_Guest_CheckBox.setEnabled(true);
					Guest_FirstName_textField.setEnabled(true);
					Guest_LastName_textField.setEnabled(true);
					Save_Resident_Button.setEnabled(false);
					B_Nights_formattedTextField.setEnabled(true);
					Search_Room_Button.setEnabled(true);
					Search_Room_Button.setEnabled(true);
					Search_Records_Button.setEnabled(true);
					Save_Notes_Button.setEnabled(true);
					Add_curr_guest_night_CheckBox.setEnabled(true);
				}
			}
		});
		Save_Resident_CheckBox.setForeground(Color.BLUE);
		Save_Resident_CheckBox.setBounds(6, 114, 128, 23);
		contentPane.add(Save_Resident_CheckBox);

		// ------------------------------------------------------------------------
		Add_curr_guest_night_CheckBox = new JCheckBox("Add Current Guest & Night");
		Add_curr_guest_night_CheckBox.setEnabled(true);
		Add_curr_guest_night_CheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clog4 = (JCheckBox) e.getSource();

				if (clog4.isSelected()) {

					Add_New_Guest_Night_CheckBox.setEnabled(false);
					Add_Night_Guest_CheckBox.setEnabled(false);
					Resident_FirstName_textField.setEnabled(false);
					Resident_LastName_textField.setEnabled(false);
					Save_Resident_Button.setEnabled(true);
					Search_Room_Button.setEnabled(false);
					Search_Records_Button.setEnabled(false);
					B_Room_textField.setText("");
					Save_Notes_Button.setEnabled(false);
					Save_Resident_CheckBox.setEnabled(false);
					Current_Guest_Button.setEnabled(true);

				} else {

					Add_New_Guest_Night_CheckBox.setEnabled(true);
					Add_Night_Guest_CheckBox.setEnabled(true);
					Resident_FirstName_textField.setEnabled(true);
					Resident_LastName_textField.setEnabled(true);
					Search_Room_Button.setEnabled(true);
					Search_Room_Button.setEnabled(true);
					Search_Records_Button.setEnabled(true);
					Save_Notes_Button.setEnabled(true);
					Save_Resident_CheckBox.setEnabled(true);
					Current_Guest_Button.setEnabled(false);
				}
			}
		});
		Add_curr_guest_night_CheckBox.setForeground(Color.BLUE);
		Add_curr_guest_night_CheckBox.setBounds(510, 150, 205, 23);
		contentPane.add(Add_curr_guest_night_CheckBox);

		// ------------------------------------------------------------
		// ------------------------------------------------------------
		// Jtextfield
		Resident_LastName_textField = new JTextField(" ");
		Resident_LastName_textField.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		Resident_LastName_textField.setBorder(new LineBorder(Color.BLUE));
		Resident_LastName_textField.setEditable(true);
		Resident_LastName_textField.setBounds(421, 30, 150, 30);
		Resident_LastName_textField.setBackground(Color.WHITE);
		contentPane.add(Resident_LastName_textField);
		Resident_LastName_textField.setColumns(10);

		Resident_FirstName_textField = new JTextField(" ");
		Resident_FirstName_textField.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		Resident_FirstName_textField.setBorder(new LineBorder(Color.BLUE));
		Resident_FirstName_textField.setEnabled(true);
		Resident_FirstName_textField.setBounds(576, 30, 154, 30);
		Resident_FirstName_textField.setBackground(Color.WHITE);
		contentPane.add(Resident_FirstName_textField);
		Resident_FirstName_textField.setColumns(10);

		// Database connectivity
		if (dbConnection.connect1()) {
			connected = "Connected";
		} else {
			connected = "Disconnected";
		}

		DBstatus_textField = new JTextField(connected);
		DBstatus_textField.setBorder(new EmptyBorder(0, 0, 0, 0));
		DBstatus_textField.setEditable(false);
		DBstatus_textField.setBackground(Color.WHITE);
		DBstatus_textField.setBounds(79, 8, 122, 22);
		DBstatus_textField.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		DBstatus_textField.setForeground(new Color(0, 51, 153));
		DBstatus_textField.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(DBstatus_textField);
		DBstatus_textField.setColumns(10);

		B_Room_textField = new JTextField();
		B_Room_textField.setBorder(new LineBorder(Color.BLUE));
		B_Room_textField.setForeground(Color.BLUE);
		B_Room_textField.setHorizontalAlignment(SwingConstants.CENTER);
		B_Room_textField.setBounds(760, 120, 61, 33);
		contentPane.add(B_Room_textField);
		B_Room_textField.setColumns(10);

		Guest_LastName_textField = new JTextField(" ");
		Guest_LastName_textField.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		Guest_LastName_textField.setBorder(new LineBorder(Color.BLUE));
		Guest_LastName_textField.setBounds(417, 195, 154, 32);
		Guest_LastName_textField.setBackground(Color.WHITE);
		contentPane.add(Guest_LastName_textField);
		Guest_LastName_textField.setColumns(10);

		Guest_FirstName_textField = new JTextField(" ");
		Guest_FirstName_textField.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		Guest_FirstName_textField.setBorder(new LineBorder(Color.BLUE));
		Guest_FirstName_textField.setBounds(576, 195, 154, 32);
		Guest_FirstName_textField.setBackground(Color.WHITE);
		contentPane.add(Guest_FirstName_textField);
		Guest_FirstName_textField.setColumns(10);

		freenights_formattedField = new JFormattedTextField();
		freenights_formattedField.setBorder(new EmptyBorder(0, 0, 0, 0));
		freenights_formattedField.setHorizontalAlignment(SwingConstants.CENTER);
		freenights_formattedField.setEditable(false);
		freenights_formattedField.setBounds(115, 85, 52, 21);
		Resident_panel.add(freenights_formattedField);

		paidNights_formattedField = new JFormattedTextField();
		paidNights_formattedField.setBorder(new EmptyBorder(0, 0, 0, 0));
		paidNights_formattedField.setEditable(false);
		paidNights_formattedField.setHorizontalAlignment(SwingConstants.CENTER);
		paidNights_formattedField.setBounds(296, 83, 46, 23);
		Resident_panel.add(paidNights_formattedField);

		total_Nights_formattedField = new JFormattedTextField();
		total_Nights_formattedField.setBorder(new EmptyBorder(0, 0, 0, 0));
		total_Nights_formattedField.setHorizontalAlignment(SwingConstants.CENTER);
		total_Nights_formattedField.setEditable(false);
		total_Nights_formattedField.setBounds(296, 130, 39, 27);
		Resident_panel.add(total_Nights_formattedField);

		B_Nights_formattedTextField = new JFormattedTextField(NumberFormat.getIntegerInstance());
		B_Nights_formattedTextField.setForeground(Color.BLUE);
		B_Nights_formattedTextField.setBorder(new LineBorder(Color.BLUE));
		B_Nights_formattedTextField.setValue(0);
		B_Nights_formattedTextField.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		B_Nights_formattedTextField.setEditable(true);
		B_Nights_formattedTextField.setHorizontalAlignment(SwingConstants.CENTER);
		B_Nights_formattedTextField.setBounds(760, 65, 61, 33);
		B_Nights_formattedTextField.setBackground(Color.WHITE);
		contentPane.add(B_Nights_formattedTextField);

		lastname_textField = new JTextField();
		lastname_textField.setBorder(new EmptyBorder(0, 0, 0, 0));
		lastname_textField.setBackground(new Color(255, 255, 255));
		lastname_textField.setHorizontalAlignment(SwingConstants.LEFT);
		lastname_textField.setEditable(false);
		lastname_textField.setBounds(25, 53, 146, 27);
		Resident_panel.add(lastname_textField);
		lastname_textField.setColumns(10);

		firstanem_textField = new JTextField();
		firstanem_textField.setBorder(new EmptyBorder(0, 0, 0, 0));
		firstanem_textField.setHorizontalAlignment(SwingConstants.LEFT);
		firstanem_textField.setEditable(false);
		firstanem_textField.setBounds(179, 53, 156, 27);
		Resident_panel.add(firstanem_textField);
		firstanem_textField.setColumns(10);

		info_textField = new JTextField();
		info_textField.setBorder(new EmptyBorder(0, 0, 0, 0));
		info_textField.setForeground(Color.BLUE);
		info_textField.setFont(new Font("Iowan Old Style", Font.PLAIN, 14));
		info_textField.setBackground(Color.WHITE);
		info_textField.setEditable(false);
		info_textField.setBounds(25, 6, 140, 27);
		Resident_panel.add(info_textField);
		info_textField.setColumns(10);

		room_textField = new JTextField();
		room_textField.setBorder(new EmptyBorder(0, 0, 0, 0));
		room_textField.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		room_textField.setForeground(Color.BLUE);
		room_textField.setBackground(Color.WHITE);
		room_textField.setEditable(false);
		room_textField.setHorizontalAlignment(SwingConstants.CENTER);
		room_textField.setBounds(347, 53, 62, 27);
		Resident_panel.add(room_textField);
		room_textField.setColumns(10);

		Pass_Calendar_formattedTextField = new JFormattedTextField();
		Pass_Calendar_formattedTextField.setForeground(Color.BLUE);
		Pass_Calendar_formattedTextField.setHorizontalAlignment(SwingConstants.CENTER);
		Pass_Calendar_formattedTextField.setEditable(false);
		Pass_Calendar_formattedTextField.setBounds(121, 134, 101, 42);
		contentPane.add(Pass_Calendar_formattedTextField);

		Write_notes_textField = new JTextField();
		Write_notes_textField.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		Write_notes_textField.setBorder(new LineBorder(Color.BLUE));
		Write_notes_textField.setEditable(true);
		Write_notes_textField.setForeground(Color.BLUE);
		Write_notes_textField.setBounds(6, 195, 403, 32);
		contentPane.add(Write_notes_textField);
		Write_notes_textField.setColumns(10);

		Date_display_textField = new JTextField();
		Date_display_textField.setBorder(new EmptyBorder(0, 0, 0, 0));
		Date_display_textField.setHorizontalAlignment(SwingConstants.CENTER);
		Date_display_textField.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		Date_display_textField.setEditable(false);
		Date_display_textField.setBounds(73, 134, 111, 21);
		Resident_panel.add(Date_display_textField);
		Date_display_textField.setColumns(10);

		OnDuty_textField = new JTextField(staff);
		OnDuty_textField.setBorder(new EmptyBorder(0, 0, 0, 0));
		OnDuty_textField.setHorizontalAlignment(SwingConstants.CENTER);
		OnDuty_textField.setEditable(false);
		OnDuty_textField.setForeground(Color.BLUE);
		OnDuty_textField.setBounds(79, 40, 122, 21);
		contentPane.add(OnDuty_textField);
		OnDuty_textField.setColumns(10);

		// --------------------------------------------------------
		// JLabels
		JLabel lastname_Label = new JLabel("Last Name:");
		lastname_Label.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lastname_Label.setEnabled(false);
		lastname_Label.setBackground(Color.LIGHT_GRAY);
		lastname_Label.setHorizontalAlignment(SwingConstants.LEFT);
		lastname_Label.setBounds(25, 37, 85, 16);
		Resident_panel.add(lastname_Label);

		JLabel firstname_Label = new JLabel("First Name:");
		firstname_Label.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		firstname_Label.setBackground(Color.LIGHT_GRAY);
		firstname_Label.setEnabled(false);
		firstname_Label.setHorizontalAlignment(SwingConstants.LEFT);
		firstname_Label.setBounds(179, 37, 77, 16);
		Resident_panel.add(firstname_Label);

		JLabel room_Label = new JLabel("Room:");
		room_Label.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		room_Label.setBackground(Color.LIGHT_GRAY);
		room_Label.setEnabled(false);
		room_Label.setHorizontalAlignment(SwingConstants.LEFT);
		room_Label.setBounds(349, 37, 61, 16);
		Resident_panel.add(room_Label);

		JLabel NightsUsed_Label = new JLabel("Free Night #");
		NightsUsed_Label.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		NightsUsed_Label.setBackground(Color.LIGHT_GRAY);
		NightsUsed_Label.setEnabled(false);
		NightsUsed_Label.setBounds(25, 80, 93, 30);
		Resident_panel.add(NightsUsed_Label);

		JLabel PaidNights_Label = new JLabel("Charged Night #");
		PaidNights_Label.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		PaidNights_Label.setBackground(Color.LIGHT_GRAY);
		PaidNights_Label.setEnabled(false);
		PaidNights_Label.setBounds(179, 80, 120, 30);
		Resident_panel.add(PaidNights_Label);

		JLabel Notes_Label = new JLabel("Notes");
		Notes_Label.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		Notes_Label.setBackground(Color.LIGHT_GRAY);
		Notes_Label.setEnabled(false);
		Notes_Label.setBounds(30, 135, 52, 16);
		Resident_panel.add(Notes_Label);

		scrollPane = new JScrollPane();
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setBounds(25, 157, 392, 48);
		Resident_panel.add(scrollPane);

		Notes_textArea = new JTextArea();
		Notes_textArea.setBorder(new EmptyBorder(0, 0, 0, 0));
		Notes_textArea.setEditable(false);
		scrollPane.setViewportView(Notes_textArea);

		JLabel Total_Nights_Label = new JLabel("Total Nights #");
		Total_Nights_Label.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		Total_Nights_Label.setHorizontalAlignment(SwingConstants.CENTER);
		Total_Nights_Label.setEnabled(false);
		Total_Nights_Label.setBounds(179, 133, 120, 21);
		Resident_panel.add(Total_Nights_Label);

		JPanel info_panel = new JPanel();
		info_panel.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(0, 0, 255)));
		info_panel.setBackground(Color.WHITE);
		info_panel.setForeground(Color.BLACK);
		info_panel.setBounds(421, 242, 874, 347);
		contentPane.add(info_panel);
		info_panel.setLayout(null);

		infofile_scrollPane = new JScrollPane();
		infofile_scrollPane.setBounds(248, 36, 360, 305);
		info_panel.add(infofile_scrollPane);

		// display info from database
		infofile_textArea = new JTextArea();
		infofile_textArea.setTabSize(9);
		infofile_textArea.setFont(new Font("Iowan Old Style", Font.PLAIN, 14));
		infofile_textArea.setForeground(Color.BLUE);
		infofile_scrollPane.setViewportView(infofile_textArea);
		infofile_textArea.setEditable(false);

		// display label
		info_guest_textField = new JTextField();
		info_guest_textField.setBorder(new EmptyBorder(0, 0, 0, 0));
		info_guest_textField.setFont(new Font("Iowan Old Style", Font.PLAIN, 14));
		info_guest_textField.setForeground(Color.BLUE);
		info_guest_textField.setEditable(false);
		info_guest_textField.setBounds(248, 8, 252, 25);
		info_panel.add(info_guest_textField);
		info_guest_textField.setColumns(10);

		Records_Found_textField = new JTextField();
		Records_Found_textField.setBorder(new EmptyBorder(0, 0, 0, 0));
		Records_Found_textField.setFont(new Font("Iowan Old Style", Font.PLAIN, 14));
		Records_Found_textField.setForeground(Color.BLUE);
		Records_Found_textField.setEditable(false);
		Records_Found_textField.setBounds(10, 8, 211, 25);
		info_panel.add(Records_Found_textField);
		Records_Found_textField.setColumns(10);

		infofile1_scrollPane = new JScrollPane();
		infofile1_scrollPane.setBounds(10, 36, 211, 305);
		info_panel.add(infofile1_scrollPane);

		infofile1_textArea = new JTextArea();
		infofile1_textArea.setForeground(Color.BLUE);
		infofile1_textArea.setFont(new Font("Iowan Old Style", Font.PLAIN, 14));
		infofile1_textArea.setEditable(false);
		infofile1_scrollPane.setViewportView(infofile1_textArea);

		Close_Button = new JButton("Log Out");
		Close_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		Close_Button.setHorizontalAlignment(SwingConstants.LEADING);
		Close_Button.setHorizontalTextPosition(SwingConstants.LEADING);
		Close_Button.setBounds(792, 5, 79, 26);
		info_panel.add(Close_Button);

		JScrollPane guest_log_scrollPane = new JScrollPane();
		guest_log_scrollPane.setBounds(620, 36, 247, 305);
		info_panel.add(guest_log_scrollPane);

		guest_log_textArea = new JTextArea();
		guest_log_textArea.setForeground(Color.BLUE);
		guest_log_textArea.setFont(new Font("Iowan Old Style", Font.PLAIN, 14));
		guest_log_textArea.setEditable(false);
		guest_log_scrollPane.setViewportView(guest_log_textArea);

		JLabel lblNewLabel_1 = new JLabel("On Duty");
		lblNewLabel_1.setBounds(16, 41, 68, 16);
		contentPane.add(lblNewLabel_1);

		Calendar_formattedTextField = new JFormattedTextField();
		Calendar_formattedTextField.setBorder(new EmptyBorder(0, 0, 0, 0));
		Calendar_formattedTextField.setForeground(Color.BLUE);
		Calendar_formattedTextField.setBounds(1169, 7, 122, 29);
		contentPane.add(Calendar_formattedTextField);
		Calendar_formattedTextField.setHorizontalAlignment(SwingConstants.CENTER);
		Calendar_formattedTextField.setEditable(false);

		JPanel Resident_Info_panel = new JPanel();
		Resident_Info_panel.setBackground(Color.WHITE);
		Resident_Info_panel.setBorder(new MatteBorder(0, 1, 1, 0, (Color) new Color(0, 0, 255)));
		Resident_Info_panel.setBounds(6, 242, 403, 347);
		contentPane.add(Resident_Info_panel);
		Resident_Info_panel.setLayout(null);

		Resident_info_scrollPane = new JScrollPane();
		Resident_info_scrollPane.setBounds(6, 36, 198, 305);
		Resident_Info_panel.add(Resident_info_scrollPane);

		Resident_info_textArea = new JTextArea();
		Resident_info_textArea.setFont(new Font("Iowan Old Style", Font.PLAIN, 14));
		Resident_info_textArea.setForeground(Color.BLUE);
		Resident_info_textArea.setEditable(false);
		Resident_info_scrollPane.setViewportView(Resident_info_textArea);

		Resident_file_info_textField = new JTextField();
		Resident_file_info_textField.setBorder(new EmptyBorder(0, 0, 0, 0));
		Resident_file_info_textField.setForeground(Color.BLUE);
		Resident_file_info_textField.setFont(new Font("Iowan Old Style", Font.PLAIN, 14));
		Resident_file_info_textField.setEditable(false);
		Resident_file_info_textField.setBounds(6, 7, 189, 29);
		Resident_Info_panel.add(Resident_file_info_textField);
		Resident_file_info_textField.setColumns(10);

		resident_log_scrollPane = new JScrollPane();
		resident_log_scrollPane.setBounds(208, 36, 189, 305);
		Resident_Info_panel.add(resident_log_scrollPane);

		resident_log_textArea = new JTextArea();
		resident_log_textArea.setForeground(Color.BLUE);
		resident_log_textArea.setFont(new Font("Iowan Old Style", Font.PLAIN, 14));
		resident_log_textArea.setEditable(false);
		resident_log_scrollPane.setViewportView(resident_log_textArea);

		SearchGuest_Button = new JButton("Search Guest");
		SearchGuest_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (e.getSource().equals(SearchGuest_Button)) {
					guest_last = Guest_LastName_textField.getText().toLowerCase().trim();
					guest_first = Guest_FirstName_textField.getText().toLowerCase().trim();

					String[] guest = { "Guest1", "Guest2", "Guest3", "Guest4", "Guest5", "Guest6", "Guest7", "Guest8",
							"Guest9", "Guest10", "Guest11", "Guest12", "Guest13", "Guest14", "Guest15", "Guest16",
							"Guest17", "Guest18", "Guest19", "Guest20" };

					String guestfile = "guest.txt";

					Records_Found_textField.setText("Guest " + guest_last.toUpperCase() + " History");

					try {

						// iterate thru the tables in the database
						for (int i = guest.length; i-- > 0;) {
//							System.out.println(tables[i]);
							guest_search_info(guest[i], guest_last);

//							info_file_show(guestfile);

						}
						info_file_show(guestfile);
						PrintWriter in = new PrintWriter(guestfile);
						in.close();

					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
			}
		});
		SearchGuest_Button.setForeground(Color.BLUE);
		SearchGuest_Button.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		SearchGuest_Button.setBounds(732, 205, 97, 35);
		contentPane.add(SearchGuest_Button);

	}

//	public static void email() throws MessagingException {
//		String to;
//		String user;
//		String password;
//		String port;
//
//		to = "email";
//		user = "email";
//		password = "password";
//		port = "587";
//
//		Properties prop = System.getProperties();
//		prop.put("mail.imap.ssl.enable", "true");
//		prop.put("mail.smtp.host", "smtp.gmail.com");
//		prop.put("mail.smtp.auth", "true");
//		prop.put("mail.smtp.port", 587);
//		prop.put("mail.imap.auth.mechanism", "XOAUTH2");
//		prop.put("mail.smtp.starttls.enable", "true");
//
//		Session s = Session.getDefaultInstance(prop, new Authenticator() {
//
//			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
//				return new javax.mail.PasswordAuthentication(user, password);
//			}
//		});
//		Store store = s.getStore("imap");
//		store.connect("imap.gmail.com", user, preparedMessage(s, user, to));
//		Message message = preparedMessage(s, to, user);
//		Transport.send(message);
//		System.out.print("Message Sent.....");
//	}
//
//	protected static Message preparedMessage(Session s, String to, String from) {
//
//		try {
//			MimeMessage message = new MimeMessage(s);
//			message.setFrom(new InternetAddress(from));
//			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//			message.setSubject("Testing B");
//			message.setText("Hi there");
//			return message;
//
////				BodyPart mbodypart1 = new MimeBodyPart();
////				mbodypart1.setText("Hello There");
//
////				MimeBodyPart mbodypart2 = new MimeBodyPart();
////				DataSource  source = new FileDataSource(filename);
////				mbodypart2.setDataHandler(new DataHandler(source));
////				mbodypart2.setFileName(filename);
////				
////				Multipart mulripart = new MimeMultipart();
////				mulripart.addBodyPart(mbodypart1);
////				mulripart.addBodyPart(mbodypart2);
//
//		} catch (MessagingException e) {
//			System.out.println(e);
//
//		}
//		return null;
//	}

	// Methods
	// -------------------------------------------------------------

	// check days left for the resident and guest
	protected void addnew_guest(String room, String glast) {

//		nights = ((Number) B_Nights_formattedTextField.getValue()).intValue();
		String[] guest = { "Guest0", "Guest1", "Guest2", "Guest3", "Guest4", "Guest5", "Guest6", "Guest7", "Guest8",
				"Guest9", "Guest10", "Guest11", "Guest12", "Guest13", "Guest14", "Guest15", "Guest16", "Guest17",
				"Guest18", "Guest19", "Guest20" };

		Connection conn = dbConnection.connect();

		try {
			PreparedStatement pr = conn
					.prepareStatement("SELECT currentguest, totalnights FROM Residents WHERE room= ?");
			pr.setString(1, room);

			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				current = rs.getInt("currentguest");
				totalnights = rs.getInt("totalnights");

//				System.out.println("addnew_guest: " + current);
				for (int i = 0; i < guest.length; i++) {
//					System.out.println(guest[i]);

					if (current < i) {
						guest_table = guest[i];
//						System.out.println(guest.length);
						PreparedStatement update = conn
								.prepareStatement("UPDATE Residents SET currentguest= ? WHERE room= ?");
						update.setInt(1, i); // add 1, indicating guest1 as a number to database
						update.setString(2, room);
						update.executeUpdate();
//						save_nights(guest_table);
						rs.close();
						update.close();
						conn.close();
						break;

					}

					if (current == 20) {
						guest_table = "Guest1";
						PreparedStatement update = conn
								.prepareStatement("UPDATE Residents SET currentguest= ? WHERE room= ?");
						update.setInt(1, 1); // add 1, indicating guest1 as a number to database
						update.setString(2, room);
						update.executeUpdate();
//						save_nights(guest_table);
						rs.close();
						update.close();
						conn.close();
						break;

					}

				}

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	protected void Jtext_Field(String last, String first, String room, int free, int paid, String write,
			String notedate, int totaln) {

		lastname_textField.setText(last.toUpperCase());
		firstanem_textField.setText(first.toUpperCase());
		room_textField.setText(room.toUpperCase());
		Notes_textArea.setText(write);
		freenights_formattedField.setValue(free);
		paidNights_formattedField.setValue(paid);
		Date_display_textField.setText(notedate);
		total_Nights_formattedField.setValue(totaln);

	}

	protected void find_guest(String room1) {

		Connection conn = dbConnection.connect();
		String[] guest = { "Guest0", "Guest1", "Guest2", "Guest3", "Guest4", "Guest5", "Guest6", "Guest7", "Guest8",
				"Guest9", "Guest10", "Guest11", "Guest12", "Guest13", "Guest14", "Guest15", "Guest16", "Guest17",
				"Guest18", "Guest19", "Guest20" };
		try {

			for (int i = 0; i < guest.length; i++) {
				PreparedStatement pr = conn.prepareStatement("SELECT currentguest FROM Residents WHERE room= ?");
				pr.setString(1, room1);
				ResultSet rs = pr.executeQuery();
				current = rs.getInt("currentguest");
//				System.out.println("find table current " + current);
				if (current == i) {
					guest_table = guest[i];
//					System.out.println("find guest table "+guest_table);
					conn.close();
					break;
				}
			}

//			ResultSet rs = pr.executeQuery();
//			while (rs.next()) {
//				current = rs.getInt("currentguest");
//				for (int i = 0; i < guest.length; i++) {
//					if (current == i) {
//						guest_table = guest[i];
//
//						System.out.println(guest_table);
//						break;
//					}
//				}
//			}
		} catch (Exception e) {

		}
	}

	// save the nights in the room number of the resident and guest
	// database related
	// save_night - currentguest in database must be set in 0
	protected void save_nights(String table, int nights, String room) {

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

				if (free_nights < 7 && nights == 2) {

					if (n1.length() < 3 && n2.length() < 3) {
						n1 = string_calendar30days;
						n2 = string_calendar30days_plusOne;
						n1l = string_calendar;
						n2l = string_calendar;
						free_nights += 2;
						totalnights += 2;
						break;

					}
					if (n2.length() < 3 && n3.length() < 3) {
						n2 = string_calendar30days;
						n3 = string_calendar30days_plusOne;
						n2l = string_calendar;
						n3l = string_calendar;
						free_nights += 2;
						totalnights += 2;
						break;

					}
					if (n3.length() < 3 && n4.length() < 3) {
						n3 = string_calendar30days;
						n4 = string_calendar30days_plusOne;
						n3l = string_calendar;
						n4l = string_calendar;
						free_nights += 2;
						totalnights += 2;
						break;

					}
					if (n4.length() < 3 && n5.length() < 3) {
						n4 = string_calendar30days;
						n5 = string_calendar30days_plusOne;
						n4l = string_calendar;
						n5l = string_calendar;
						free_nights += 2;
						totalnights += 2;
						break;

					}
					if (n5.length() < 3 && n6.length() < 3) {
						n5 = string_calendar30days;
						n6 = string_calendar30days_plusOne;
						n5l = string_calendar;
						n6l = string_calendar;
						free_nights += 2;
						totalnights += 2;
						break;

					}
					if (n6.length() < 3 && n7.length() < 3) {
						n6 = string_calendar30days;
						n7 = string_calendar30days_plusOne;
						n6l = string_calendar;
						n7l = string_calendar;
						free_nights += 1;
						paid_nights += 1;
						totalnights += 2;
						break;
					}

				}
				if (totalnights >= 6 && nights == 2) {

					if (n7.length() < 3 && n8.length() < 3) {
						n7 = string_calendar30days;
						n8 = string_calendar30days_plusOne;
						n7l = string_calendar;
						n8l = string_calendar;
						paid_nights += 2;
						totalnights += 2;
						break;

					}
					if (n8.length() < 3 && n9.length() < 3) {
						n8 = string_calendar30days;
						n9 = string_calendar30days_plusOne;
						n8l = string_calendar;
						n9l = string_calendar;
						paid_nights += 2;
						totalnights += 2;
						break;

					}
					if (n9.length() < 3 && n10.length() < 3) {
						n9 = string_calendar30days;
						n10 = string_calendar30days_plusOne;
						n9l = string_calendar;
						n10l = string_calendar;
						paid_nights += 2;
						totalnights += 2;
						break;

					}
					if (n10.length() < 3 && n11.length() < 3) {
						n10 = string_calendar30days;
						n11 = string_calendar30days_plusOne;
						n10l = string_calendar;
						n11l = string_calendar;
						paid_nights += 2;
						totalnights += 2;
						break;

					}
					if (n11.length() < 3 && n12.length() < 3) {
						n11 = string_calendar30days;
						n12 = string_calendar30days_plusOne;
						n11l = string_calendar;
						n12l = string_calendar;
						paid_nights += 2;
						totalnights += 2;
						break;
					}
					if (n12.length() < 3 && n13.length() < 3) {
						n12 = string_calendar30days;
						n13 = string_calendar30days_plusOne;
						n12l = string_calendar;
						n13l = string_calendar;
						paid_nights += 2;
						totalnights += 2;
						break;
					}
					if (n13.length() < 3 && n14.length() < 3) {
						n13 = string_calendar30days;
						n14 = string_calendar30days_plusOne;
						n13l = string_calendar;
						n14l = string_calendar;
						paid_nights += 2;
						totalnights += 2;
						break;
					}
					if (n14.length() < 3 && n15.length() < 3) {
						n14 = string_calendar30days;
						n15 = string_calendar30days_plusOne;
						n14l = string_calendar;
						n14l = string_calendar;
						paid_nights += 2;
						totalnights += 2;
						break;
					}
					if (n15.length() < 3 && n16.length() < 3) {
						n15 = string_calendar30days;
						n16 = string_calendar30days_plusOne;
						n15l = string_calendar;
						n16l = string_calendar;
						paid_nights += 2;
						totalnights += 2;
						break;
					}
					if (n16.length() < 3 && n17.length() < 3) {
						n16 = string_calendar30days;
						n17 = string_calendar30days_plusOne;
						n16l = string_calendar;
						n17l = string_calendar;
						paid_nights += 2;
						totalnights += 2;
						break;
					}
					if (n17.length() < 3 && n18.length() < 3) {
						n17 = string_calendar30days;
						n18 = string_calendar30days_plusOne;
						n17l = string_calendar;
						n18l = string_calendar;
						paid_nights += 2;
						totalnights += 2;
						break;
					}
					if (n18.length() < 3 && n19.length() < 3) {
						n18 = string_calendar30days;
						n19 = string_calendar30days_plusOne;
						n18l = string_calendar;
						n19l = string_calendar;
						paid_nights += 2;
						totalnights += 2;
						break;
					}
					if (n19.length() < 3 && n20.length() < 3) {
						n19 = string_calendar30days;
						n20 = string_calendar30days_plusOne;
						n19l = string_calendar;
						n20l = string_calendar;
						paid_nights += 2;
						totalnights += 2;
						break;
					}
					if (n20.length() < 3 && n21.length() < 3) {
						n20 = string_calendar30days;
						n21 = string_calendar30days_plusOne;
						n20l = string_calendar;
						n21l = string_calendar;
						paid_nights += 2;
						totalnights += 2;
						break;
					}
					if (n21.length() < 3 && n22.length() < 3) {
						n21 = string_calendar30days;
						n22 = string_calendar30days_plusOne;
						n21l = string_calendar;
						n22l = string_calendar;
						paid_nights += 2;
						totalnights += 2;
						break;
					}
					if (n22.length() < 3 && n23.length() < 3) {
						n22 = string_calendar30days;
						n23 = string_calendar30days_plusOne;
						n22l = string_calendar;
						n23l = string_calendar;
						paid_nights += 2;
						totalnights += 2;
						break;
					}
					if (n23.length() < 3 && n24.length() < 3) {
						n23 = string_calendar30days;
						n24 = string_calendar30days_plusOne;
						n23l = string_calendar;
						n24l = string_calendar;
						paid_nights += 2;
						totalnights += 2;
						break;
					}
					if (n24.length() < 3 && n25.length() < 3) {
						n24 = string_calendar30days;
						n25 = string_calendar30days_plusOne;
						n24l = string_calendar;
						n25l = string_calendar;
						paid_nights += 2;
						totalnights += 2;
						break;
					}
					if (n25.length() < 3 && n26.length() < 3) {
						n25 = string_calendar30days;
						n26 = string_calendar30days_plusOne;
						n25l = string_calendar;
						n26l = string_calendar;
						paid_nights += 2;
						totalnights += 2;
						break;
					}
					if (n26.length() < 3 && n27.length() < 3) {
						n26 = string_calendar30days;
						n27 = string_calendar30days_plusOne;
						n26l = string_calendar;
						n27l = string_calendar;
						paid_nights += 2;
						totalnights += 2;
						break;
					}
					if (n27.length() < 3 && n28.length() < 3) {
						n27 = string_calendar30days;
						n28 = string_calendar30days_plusOne;
						n27l = string_calendar;
						n28l = string_calendar;
						paid_nights += 2;
						totalnights += 2;
						break;
					}
					if (n28.length() < 3 && n29.length() < 3) {
						n28 = string_calendar30days;
						n29 = string_calendar30days_plusOne;
						n28l = string_calendar;
						n29l = string_calendar;
						paid_nights += 2;
						totalnights += 2;
						break;
					}
					if (n29.length() < 3 && n30.length() < 3) {
						n29 = string_calendar30days;
						n30 = string_calendar30days_plusOne;
						n29l = string_calendar;
						n30l = string_calendar;
						paid_nights += 2;
						totalnights += 2;
						break;
					}

//					if (n14.length() < 3) {
//						n14 = string_calendar30days;
//						totalpaid = total - 1;
//						break;
//
//					}
				}
				if (free_nights < 7 && nights == 1) {

					if (n1.length() < 3) {
						n1 = string_calendar30days;
						n1l = string_calendar;
						free_nights += 1;
						totalnights += 1;
						break;
					}
					// database only have 1 night on the system, total is with the new nights being
					// added to the database
					if (n2.length() < 3) {
						n2 = string_calendar30days;
						n2l = string_calendar;
						free_nights += 1;
						totalnights += 1;
						break;
					}
					if (n3.length() < 3) {
						n3 = string_calendar30days;
						n3l = string_calendar;
						free_nights += 1;
						totalnights += 1;
						break;
					}
					if (n4.length() < 3) {
						n4 = string_calendar30days;
						n4l = string_calendar;
						free_nights += 1;
						totalnights += 1;
						break;
					}

					if (n5.length() < 3) {
						n5 = string_calendar30days;
						n5l = string_calendar;
						free_nights += 1;
						totalnights += 1;
						break;
					}
					if (n6.length() < 3) {
						n6 = string_calendar30days;
						n6l = string_calendar;
						free_nights += 1;
						totalnights += 1;
						break;
					}

				}
				if (totalnights >= 6 && nights == 1) {

					if (n7.length() < 3) {
						n7 = string_calendar30days;
						n7l = string_calendar;
						paid_nights += 1;
						totalnights += 1;
						break;
					}
					if (n8.length() < 3) {
						n8 = string_calendar30days;
						n8l = string_calendar;
						paid_nights += 1;
						totalnights += 1;
						break;

					}
					if (n9.length() < 3) {
						n9 = string_calendar30days;
						n9l = string_calendar;
						paid_nights += 1;
						totalnights += 1;
						break;

					}
					if (n10.length() < 3) {
						n10 = string_calendar30days;
						n10l = string_calendar;
						paid_nights += 1;
						totalnights += 1;
						break;

					}
					if (n11.length() < 3) {
						n11 = string_calendar30days;
						n11l = string_calendar;
						paid_nights += 1;
						totalnights += 1;
						break;
					}
					if (n12.length() < 3) {
						n12 = string_calendar30days;
						n12l = string_calendar;
						paid_nights += 1;
						totalnights += 1;
						break;
					}
					if (n13.length() < 3) {
						n13 = string_calendar30days;
						n13l = string_calendar;
						paid_nights += 1;
						totalnights += 1;
						break;

					}
					if (n14.length() < 3) {
						n14 = string_calendar30days;
						n14l = string_calendar;
						paid_nights += 1;
						totalnights += 1;
						break;
					}
					if (n15.length() < 3) {
						n15 = string_calendar30days;
						n15l = string_calendar;
						paid_nights += 1;
						totalnights += 1;
						break;
					}
					if (n16.length() < 3) {
						n16 = string_calendar30days;
						n16l = string_calendar;
						paid_nights += 1;
						totalnights += 1;
						break;
					}
					if (n17.length() < 3) {
						n17 = string_calendar30days;
						n17l = string_calendar;
						paid_nights += 1;
						totalnights += 1;
						break;
					}
					if (n18.length() < 3) {
						n18 = string_calendar30days;
						n18l = string_calendar;
						paid_nights += 1;
						totalnights += 1;
						break;
					}
					if (n19.length() < 3) {
						n19 = string_calendar30days;
						n19l = string_calendar;
						paid_nights += 1;
						totalnights += 1;
						break;
					}
					if (n20.length() < 3) {
						n20 = string_calendar30days;
						n20l = string_calendar;
						paid_nights += 1;
						totalnights += 1;
						break;
					}
					if (n21.length() < 3) {
						n21 = string_calendar30days;
						n21l = string_calendar;
						paid_nights += 1;
						totalnights += 1;
						break;
					}
					if (n22.length() < 3) {
						n22 = string_calendar30days;
						n22l = string_calendar;
						paid_nights += 1;
						totalnights += 1;
						break;
					}
					if (n23.length() < 3) {
						n23 = string_calendar30days;
						n23l = string_calendar;
						paid_nights += 1;
						totalnights += 1;
						break;
					}
					if (n24.length() < 3) {
						n24 = string_calendar30days;
						n24l = string_calendar;
						paid_nights += 1;
						totalnights += 1;
						break;
					}
					if (n25.length() < 3) {
						n25 = string_calendar30days;
						n25l = string_calendar;
						paid_nights += 1;
						totalnights += 1;
						break;
					}
					if (n26.length() < 3) {
						n26 = string_calendar30days;
						n26l = string_calendar;
						paid_nights += 1;
						totalnights += 1;
						break;
					}
					if (n27.length() < 3) {
						n27 = string_calendar30days;
						n27l = string_calendar;
						paid_nights += 1;
						totalnights += 1;
						break;
					}
					if (n28.length() < 3) {
						n28 = string_calendar30days;
						n28l = string_calendar;
						paid_nights += 1;
						totalnights += 1;
						break;
					}
					if (n29.length() < 3) {
						n29 = string_calendar30days;
						n29l = string_calendar;
						paid_nights += 1;
						totalnights += 1;
						break;
					}
					if (n30.length() < 3) {
						n30 = string_calendar30days;
						n30l = string_calendar;
						paid_nights += 1;
						totalnights += 1;
						break;
					}

				}

//					System.out.println("totalnights: " + totalnights);
//				System.out.println("n1 : " +n1);
//				System.out.println("nights: " +nights);

//					System.out.println("totalnights: " +totalnights);
//					System.out.println("freenights : " + totalfree);

			}
//			System.out.println("nights: " + nights);

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
//			JOptionPane.showMessageDialog(null, nights + " night(s) saved in room " + room);

		} catch (SQLException e1) {
//			JOptionPane.showMessageDialog(null, e1.getMessage() + "Night saved");
			e1.printStackTrace();
		}

	}

	protected void current_guest_nights(String table, String room1, String last1, int nights) {

		resident_table = "Residents"; // for save_nights for the resident table
		Connection conn = dbConnection.connect();

		try {

			PreparedStatement pr = conn.prepareStatement("SELECT firstname, lastname FROM " + table + " WHERE room= ?");
			pr.setString(1, room1);
			ResultSet rs = pr.executeQuery();

			if (rs.getString("lastname").equals(last1)) {
				rs.close();
				JOptionPane.showMessageDialog(null, nights + " night(s) will be saved to room " + room1);
				save_nights(table, nights, room1);
				save_nights(resident_table, nights, room1);
				B_Nights_formattedTextField.setValue(0);
			}
			conn.close();

//				ResultSet rs = pr.executeQuery();

//				
//				if (last1.equals(rs.getString("lastname")) && first1.equals("firstname")) {
//					guest_table = guest[i];
//					System.out.println("Current guest nights: " + guest_table);
//					save_nights(guest_table, nights, room);
//
//				}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// -----------------------------------------------------------------------
	// will delete the nights based on criteria of 30 days in every table
	// located in search room button
	protected void update_nights() {

//		System.out.println("first statement nights: " + nights);

		Connection conn = dbConnection.connect();
		String[] guest = { "Residents", "Guest1", "Guest2", "Guest3", "Guest4", "Guest5", "Guest6", "Guest7", "Guest8",
				"Guest9", "Guest10", "Guest11", "Guest12", "Guest13", "Guest14", "Guest15", "Guest16", "Guest17",
				"Guest18", "Guest19", "Guest20" };

		try {
			for (int i = 0; i < guest.length; i++) {
//				System.out.println(guest[i]);
				guest_table = guest[i];
				PreparedStatement pr = conn.prepareStatement("SELECT * FROM " + guest[i] + " ");
//				pr.setString(1, room);
				ResultSet rs = pr.executeQuery();

				while (rs.next()) {
					last = rs.getString("lastname");
//					first = rs.getString("firstname");
					room = rs.getString("room");		// loops thru all the rooms on each table
					paid_nights = rs.getInt("paidnights");
					free_nights = rs.getInt("freenights");
					totalnights = rs.getInt("totalnights");
					n1 = rs.getString("one");
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

					if (n1.equals(string_calendar)) {
						PreparedStatement update = conn.prepareStatement("UPDATE " + guest_table
								+ " SET one= ?, oneL= ?, freenights= ?, totalnights= ? WHERE room= ?");
//						System.out.println("room: " + room);
						update.setString(1, "");
						update.setString(2, "");
						update.setInt(3, free_nights - 1);
						update.setInt(4, totalnights - 1);
						update.setString(5, room);
						update.executeUpdate();
						update.close();

					}
					if (n2.equals(string_calendar)) {
						PreparedStatement update = conn.prepareStatement("UPDATE " + guest_table
								+ " SET two= ?, twoL= ?, freenights= ?, totalnights= ?  WHERE room= ?");
//						System.out.println("room: " + room);
						update.setString(1, "");
						update.setString(2, "");
						update.setInt(3, free_nights - 1);
						update.setInt(4, totalnights - 1);
						update.setString(5, room);
						update.executeUpdate();
						update.close();

					}
					if (n3.equals(string_calendar) && last.length() > 3) {
						PreparedStatement update = conn.prepareStatement("UPDATE " + guest_table
								+ " SET three= ?, threeL= ?, freenights= ?, totalnights= ?  WHERE room= ?");
//						System.out.println("room: " + room);
						update.setString(1, "");
						update.setString(2, "");
						update.setInt(3, free_nights - 1);
						update.setInt(4, totalnights - 1);
						update.setString(5, room);
						update.executeUpdate();
						update.close();

					}
					if (n4.equals(string_calendar)) {
						PreparedStatement update = conn.prepareStatement("UPDATE " + guest_table
								+ " SET four= ?, fourL= ?, freenights= ?, totalnights= ? WHERE room= ?");
						System.out.println("room: " + room);
						update.setString(1, "");
						update.setString(2, "");
						update.setInt(3, free_nights - 1);
						update.setInt(4, totalnights - 1);
						update.setString(5, room);
						update.executeUpdate();
						update.close();

					}
					if (n5.equals(string_calendar)) {
						PreparedStatement update = conn.prepareStatement("UPDATE " + guest_table
								+ " SET five= ?, fiveL= ?, freenights= ?, totalnights= ? WHERE room= ?");
						System.out.println("room: " + room);
						update.setString(1, "");
						update.setString(2, "");
						update.setInt(3, free_nights - 1);
						update.setInt(4, totalnights - 1);
						update.setString(5, room);
						update.executeUpdate();
						update.close();

					}
					if (n6.equals(string_calendar)) {
						PreparedStatement update = conn.prepareStatement("UPDATE " + guest_table
								+ " SET six= ?, sixL= ?, freenights= ?, totalnights= ? WHERE room= ?");
						System.out.println("room: " + room);
						update.setString(1, "");
						update.setString(2, "");
						update.setInt(3, free_nights - 1);
						update.setInt(4, totalnights - 1);
						update.setString(5, room);
						update.executeUpdate();
						update.close();

					}
					if (n7.equals(string_calendar)) {
						PreparedStatement update = conn.prepareStatement("UPDATE " + guest_table
								+ " SET seven= ?, sevenL= ?, freenights= ?, totalnights= ? WHERE room= ?");
						System.out.println("room: " + room);
						update.setString(1, "");
						update.setString(2, "");
						update.setInt(3, free_nights - 1);
						update.setInt(4, totalnights - 1);
						update.setString(5, room);
						update.executeUpdate();
						update.close();

					}
					if (n8.equals(string_calendar)) {
						PreparedStatement update = conn.prepareStatement("UPDATE " + guest_table
								+ " SET eight= ?, eightL= ?, freenights= ?, totalnights= ? WHERE room= ?");
						System.out.println("room: " + room);
						update.setString(1, "");
						update.setString(2, "");
						update.setInt(3, free_nights - 1);
						update.setInt(4, totalnights - 1);
						update.setString(5, room);
						update.executeUpdate();
						update.close();

					}
					if (n9.equals(string_calendar)) {
						PreparedStatement update = conn.prepareStatement("UPDATE " + guest_table
								+ " SET nine= ?, nineL= ?, freenights= ?, totalnights= ? WHERE room= ?");
						System.out.println("room: " + room);
						update.setString(1, "");
						update.setString(2, "");
						update.setInt(3, free_nights - 1);
						update.setInt(4, totalnights - 1);
						update.setString(5, room);
						update.executeUpdate();
						update.close();

					}
					if (n10.equals(string_calendar)) {
						PreparedStatement update = conn.prepareStatement("UPDATE " + guest_table
								+ " SET ten= ?, tenL= ?, freenights= ?, totalnights= ? WHERE room= ?");
						System.out.println("room: " + room);
						update.setString(1, "");
						update.setString(2, "");
						update.setInt(3, free_nights - 1);
						update.setInt(4, totalnights - 1);
						update.setString(5, room);
						update.executeUpdate();
						update.close();

					}
					if (n11.equals(string_calendar)) {
						PreparedStatement update = conn.prepareStatement("UPDATE " + guest_table
								+ " SET eleven= ?, elevenL= ?, freenights= ?, totalnights= ? WHERE room= ?");
						System.out.println("room: " + room);
						update.setString(1, "");
						update.setString(2, "");
						update.setInt(3, free_nights - 1);
						update.setInt(4, totalnights - 1);
						update.setString(5, room);
						update.executeUpdate();
						update.close();

					}
					if (n12.equals(string_calendar)) {
						PreparedStatement update = conn.prepareStatement("UPDATE " + guest_table
								+ " SET twelve= ?, twelveL= ?, freenights= ?, totalnights= ? WHERE room= ?");
						System.out.println("room: " + room);
						update.setString(1, "");
						update.setString(2, "");
						update.setInt(3, free_nights - 1);
						update.setInt(4, totalnights - 1);
						update.setString(5, room);
						update.executeUpdate();
						update.close();

					}
					if (n13.equals(string_calendar)) {
						PreparedStatement update = conn.prepareStatement("UPDATE " + guest_table
								+ " SET thirteen= ?, thirteenL= ?, freenights= ?, totalnights= ? WHERE room= ?");
						System.out.println("room: " + room);
						update.setString(1, "");
						update.setString(2, "");
						update.setInt(3, free_nights - 1);
						update.setInt(4, totalnights - 1);
						update.setString(5, room);
						update.executeUpdate();
						update.close();

					}
					if (n14.equals(string_calendar)) {
						PreparedStatement update = conn.prepareStatement("UPDATE " + guest_table
								+ " SET fourteen= ?, fourteenL= ?, freenights= ?, totalnights= ? WHERE room= ?");
						System.out.println("room: " + room);
						update.setString(1, "");
						update.setString(2, "");
						update.setInt(3, free_nights - 1);
						update.setInt(4, totalnights - 1);
						update.setString(5, room);
						update.executeUpdate();
						update.close();

					}
					if (n15.equals(string_calendar)) {
						PreparedStatement update = conn.prepareStatement("UPDATE " + guest_table
								+ " SET fifteen= ?, fifteenL= ?, freenights= ?, totalnights= ? WHERE room= ?");
						System.out.println("room: " + room);
						update.setString(1, "");
						update.setString(2, "");
						update.setInt(3, free_nights - 1);
						update.setInt(4, totalnights - 1);
						update.setString(5, room);
						update.executeUpdate();
						update.close();

					}
					if (n16.equals(string_calendar)) {
						PreparedStatement update = conn.prepareStatement("UPDATE " + guest_table
								+ " SET sixteen= ?, sixteenL= ?, freenights= ?, totalnights= ? WHERE room= ?");
						System.out.println("room: " + room);
						update.setString(1, "");
						update.setString(2, "");
						update.setInt(3, free_nights - 1);
						update.setInt(4, totalnights - 1);
						update.setString(5, room);
						update.executeUpdate();
						update.close();

					}
					if (n17.equals(string_calendar)) {
						PreparedStatement update = conn.prepareStatement("UPDATE " + guest_table
								+ " SET seventeen= ?, seventeenL= ?, freenights= ?, totalnights= ? WHERE room= ?");
						System.out.println("room: " + room);
						update.setString(1, "");
						update.setString(2, "");
						update.setInt(3, free_nights - 1);
						update.setInt(4, totalnights - 1);
						update.setString(5, room);
						update.executeUpdate();
						update.close();

					}
					if (n18.equals(string_calendar)) {
						PreparedStatement update = conn.prepareStatement("UPDATE " + guest_table
								+ " SET eighteen= ?, eighteenL= ?, freenights= ?, totalnights= ? WHERE room= ?");
						System.out.println("room: " + room);
						update.setString(1, "");
						update.setString(2, "");
						update.setInt(3, free_nights - 1);
						update.setInt(4, totalnights - 1);
						update.setString(5, room);
						update.executeUpdate();
						update.close();

					}
					if (n19.equals(string_calendar)) {
						PreparedStatement update = conn.prepareStatement("UPDATE " + guest_table
								+ " SET nineteen= ?, nineteenL= ?, freenights= ?, totalnights= ? WHERE room= ?");
						System.out.println("room: " + room);
						update.setString(1, "");
						update.setString(2, "");
						update.setInt(3, free_nights - 1);
						update.setInt(4, totalnights - 1);
						update.setString(5, room);
						update.executeUpdate();
						update.close();

					}
					if (n20.equals(string_calendar)) {
						PreparedStatement update = conn.prepareStatement("UPDATE " + guest_table
								+ " SET twenty= ?, twentyL= ?, freenights= ?, totalnights= ? WHERE room= ?");
						System.out.println("room: " + room);
						update.setString(1, "");
						update.setString(2, "");
						update.setInt(3, free_nights - 1);
						update.setInt(4, totalnights - 1);
						update.setString(5, room);
						update.executeUpdate();
						update.close();

					}
					if (n21.equals(string_calendar)) {
						PreparedStatement update = conn.prepareStatement("UPDATE " + guest_table
								+ " SET twentyone= ?, twentyoneL= ?, freenights= ?, totalnights= ? WHERE room= ?");
						System.out.println("room: " + room);
						update.setString(1, "");
						update.setString(2, "");
						update.setInt(3, free_nights - 1);
						update.setInt(4, totalnights - 1);
						update.setString(5, room);
						update.executeUpdate();
						update.close();

					}
					if (n22.equals(string_calendar)) {
						PreparedStatement update = conn.prepareStatement("UPDATE " + guest_table
								+ " SET twentytwo= ?, twentytwoL= ?, freenights= ?, totalnights= ? WHERE room= ?");
						System.out.println("room: " + room);
						update.setString(1, "");
						update.setString(2, "");
						update.setInt(3, free_nights - 1);
						update.setInt(4, totalnights - 1);
						update.setString(5, room);
						update.executeUpdate();
						update.close();

					}
					if (n23.equals(string_calendar)) {
						PreparedStatement update = conn.prepareStatement("UPDATE " + guest_table
								+ " SET twentythree= ?, twentythreeL= ?, freenights= ?, totalnights= ? WHERE room= ?");
						System.out.println("room: " + room);
						update.setString(1, "");
						update.setString(2, "");
						update.setInt(3, free_nights - 1);
						update.setInt(4, totalnights - 1);
						update.setString(5, room);
						update.executeUpdate();
						update.close();

					}
					if (n24.equals(string_calendar)) {
						PreparedStatement update = conn.prepareStatement("UPDATE " + guest_table
								+ " SET twentyfour= ?, twentyfourL= ?, freenights= ?, totalnights= ? WHERE room= ?");
						System.out.println("room: " + room);
						update.setString(1, "");
						update.setString(2, "");
						update.setInt(3, free_nights - 1);
						update.setInt(4, totalnights - 1);
						update.setString(5, room);
						update.executeUpdate();
						update.close();

					}
					if (n25.equals(string_calendar)) {
						PreparedStatement update = conn.prepareStatement("UPDATE " + guest_table
								+ " SET twentyfive= ?, twentyfiveL= ?, freenights= ?, totalnights= ? WHERE room= ?");
						System.out.println("room: " + room);
						update.setString(1, "");
						update.setString(2, "");
						update.setInt(3, free_nights - 1);
						update.setInt(4, totalnights - 1);
						update.setString(5, room);
						update.executeUpdate();
						update.close();

					}
					if (n26.equals(string_calendar)) {
						PreparedStatement update = conn.prepareStatement("UPDATE " + guest_table
								+ " SET twentysix= ?, twentysixL= ?, freenights= ?, totalnights= ? WHERE room= ?");
						System.out.println("room: " + room);
						update.setString(1, "");
						update.setString(2, "");
						update.setInt(3, free_nights - 1);
						update.setInt(4, totalnights - 1);
						update.setString(5, room);
						update.executeUpdate();
						update.close();

					}
					if (n27.equals(string_calendar)) {
						PreparedStatement update = conn.prepareStatement("UPDATE " + guest_table
								+ " SET twentyseven= ?, twentysevenL= ?, freenights= ?, totalnights= ? WHERE room= ?");
						System.out.println("room: " + room);
						update.setString(1, "");
						update.setString(2, "");
						update.setInt(3, free_nights - 1);
						update.setInt(4, totalnights - 1);
						update.setString(5, room);
						update.executeUpdate();
						update.close();

					}
					if (n28.equals(string_calendar)) {
						PreparedStatement update = conn.prepareStatement("UPDATE " + guest_table
								+ " SET twentyeight= ?, twentyeightL= ?, freenights= ?, totalnights= ? WHERE room= ?");
						System.out.println("room: " + room);
						update.setString(1, "");
						update.setString(2, "");
						update.setInt(3, free_nights - 1);
						update.setInt(4, totalnights - 1);
						update.setString(5, room);
						update.executeUpdate();
						update.close();

					}
					if (n29.equals(string_calendar)) {
						PreparedStatement update = conn.prepareStatement("UPDATE " + guest_table
								+ " SET twentynine= ?, twentynineL= ?, freenights= ?, totalnights= ? WHERE room= ?");
						System.out.println("room: " + room);
						update.setString(1, "");
						update.setString(2, "");
						update.setInt(3, free_nights - 1);
						update.setInt(4, totalnights - 1);
						update.setString(5, room);
						update.executeUpdate();
						update.close();

					}
					if (n30.equals(string_calendar)) {
						PreparedStatement update = conn.prepareStatement("UPDATE " + guest_table
								+ " SET thirty= ?, thirtyL= ?, freenights= ?, totalnights= ? WHERE room= ?");
						System.out.println("room: " + room);
						update.setString(1, "");
						update.setString(2, "");
						update.setInt(3, free_nights - 1);
						update.setInt(4, totalnights - 1);
						update.setString(5, room);
						update.executeUpdate();
						update.close();

					}
				}
			}
			conn.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	// save notes with the date into the database
	protected void save_notes(String write, String room) {

//		write = Write_notes_textField.getText().toLowerCase();
//		room = B_Room_textField.getText().toLowerCase();

		Connection conn = dbConnection.connect();

//		System.out.println(write.length());
		if (write.length() > 100) {
			JOptionPane.showMessageDialog(null, "100 characters or less are allowed");

		} else {

			try {
				PreparedStatement pr = conn.prepareStatement("SELECT * FROM Residents WHERE room== ?");
				pr.setString(1, room);
				ResultSet rs = pr.executeQuery();

				while (rs.next()) {
					if (room.equals(rs.getString("room"))) {

						PreparedStatement update_r = conn
								.prepareStatement("UPDATE Residents SET notes= ?, notedate= ? WHERE room== ?");

						update_r.setString(1, write.trim());
						update_r.setString(2, string_calendar);
						update_r.setString(3, room);
						update_r.executeUpdate();
						update_r.close();

						JOptionPane.showMessageDialog(null, "Note has been saved for room " + room);

					}
				}
				conn.close();

			} catch (SQLException e) {
//				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			Write_notes_textField.setText(" ");
		}
	}

	// cleans the display info board
	protected void resetInfo_board() {

		lastname_textField.setText(" ");
		firstanem_textField.setText(" ");
		room_textField.setText(" ");
		freenights_formattedField.setValue(0);
		paidNights_formattedField.setValue(0);
		Date_display_textField.setText(" ");
		Notes_textArea.setText(" ");

	}

	// Reset variables to "" and 0
	// reSeset
	protected void reReset() {
		free_nights = 0;
		paid_nights = 0;
		result_nights = 0;
//		last = "";
//		first = "";
//		room = "";
		B_Room_textField.setText("");
		Resident_FirstName_textField.setText("");
		Resident_LastName_textField.setText("");
		B_Nights_formattedTextField.setValue(0);
		Write_notes_textField.setText("");
		Guest_LastName_textField.setText("");
		Guest_FirstName_textField.setText("");

	}

	// Gives today's day
	// calendar
	protected void calendar() {
		// actual date
		calendar_date = Calendar.getInstance();
		date = new SimpleDateFormat("MM-dd-yyyy");

		Calendar_formattedTextField.setValue(date.format(calendar_date.getTime()));
		string_calendar = date.format(calendar_date.getTime());

		// adding 30 days into the calendar with new variables from
		// Calendar.calendar30days and string_calendar30days
		calendar_30days = Calendar.getInstance();
		calendar_30days.add(Calendar.DAY_OF_MONTH, 0);
		string_calendar30days = date.format(calendar_30days.getTime());

		// adding 30 days plus one
		calendar30days_plusOne = Calendar.getInstance();
		calendar30days_plusOne.add(Calendar.DAY_OF_MONTH, 30 + 1);
		string_calendar30days_plusOne = date.format(calendar30days_plusOne.getTime());

	}

	// provide the given day based on the user's input 
	// pass_calendar
	protected void pass_calendar() {
		nights = ((Number) B_Nights_formattedTextField.getValue()).intValue();

		calendar_ahead = Calendar.getInstance();
		date = new SimpleDateFormat("MM-dd-yyyy");
		calendar_ahead.add(Calendar.DAY_OF_MONTH, nights);
		Pass_Calendar_formattedTextField.setValue(date.format(calendar_ahead.getTime()));

		string_calendarAhead = date.format(calendar_ahead.getTime());

	}

	// free_nights, nights, paid_nights and over_nights are local variables
	// update_resident
	// data from the sqlite database.
	protected void update_name(String table, String last1, String first1, String room) {

//		System.out.println("number activation: " + number_activation + " "+last +" " + first);

		// ------------------------------------------------------------
		Connection conn = dbConnection.connect();

		try {
			PreparedStatement pr = conn
					.prepareStatement("SELECT lastname, firstname FROM " + table + " WHERE room== ?");
			pr.setString(1, room);
			ResultSet rs = pr.executeQuery();
			String empty = "";
//			System.out.println(room);
			while (rs.next()) {
				if (rs.getString("lastname").equals(last1) && rs.getString("firstname").equals(first1)) {
					int YesOrNo = JOptionPane.showConfirmDialog(null, first1 + " " + last1
							+ " is already in the system for room " + room + " Do you want to update it?", empty,
							JOptionPane.YES_NO_OPTION);

					if (YesOrNo == 0) {
						PreparedStatement update = conn
								.prepareStatement("UPDATE " + table + " SET lastname= ?, firstname= ? WHERE room= ?");

						// System.out.println("number activation: " + number_activation);
						update.setString(1, last1.trim());
						update.setString(2, first1.trim());
						update.setString(3, room.trim());
						update.executeUpdate();
						update.close();
						rs.close();
						conn.close();
						JOptionPane.showMessageDialog(null, first1 + " " + last1 + " was saved to room " + room);
						reReset();
						break;
					}
					if (YesOrNo == 1) {
						JOptionPane.showMessageDialog(null, first1 + " " + last1 + " was NOT saved to room " + room);
						break;
					}
//				} else if (rs.getString("lastname").length() > 3 && rs.getString("firstname").length() > 3) {
//					String last = rs.getString("lastname");
//					String first = rs.getString("firstname");
//					// -------------------------------------------------------------------------------
//					PreparedStatement p = conn.prepareStatement("SELECT currentguest FROM Residents WHERE room= ?");
//					p.setString(1, room);
//					ResultSet r = p.executeQuery();
//					current = r.getInt("currentguest");
//					// -------------------------------------------------------------------------------
//					int YesOrNo = JOptionPane.showConfirmDialog(null,
//							first + " " + last + " is already a guest for room " + room + " Do you want to update it?",
//							empty, JOptionPane.YES_NO_OPTION);
//					// -------------------------------------------------------------------------------
//					if (YesOrNo == 0) {
//						PreparedStatement update = conn
//								.prepareStatement("UPDATE Residents SET lastname= ?, firstname= ? WHERE room= ?");
//
//						// System.out.println("number activation: " + number_activation);
//						update.setString(1, last1.trim());
//						update.setString(2, first1.trim());
//						update.setString(3, room.trim());
//						update.executeUpdate();
//						update.close();
//						rs.close();
//						conn.close();
//						JOptionPane.showMessageDialog(null, first1 + " " + last1 + " was saved to room " + room);
//						reReset();
//						break;
//
//					}
//					if (YesOrNo == 1) {
//						PreparedStatement update = conn
//								.prepareStatement("UPDATE Residents SET currentguest= ?  WHERE room= ?");
//
//						// System.out.println("number activation: " + number_activation);
//						update.setInt(1, current + 1);
//						update.setString(3, room.trim());
//						update.executeUpdate();
//						update.close();
//						rs.close();
//						conn.close();
//						JOptionPane.showMessageDialog(null, first1 + " " + last1 + " was saved to room " + room);
//						reReset();
//						break;
//					}
				} else {
					int YesOrNo = JOptionPane.showConfirmDialog(null,
							first1 + " " + last1 + " will be saved to room " + room, empty, JOptionPane.YES_NO_OPTION);

					if (YesOrNo == 0) {
						PreparedStatement update = conn
								.prepareStatement("UPDATE " + table + " SET lastname= ?, firstname= ? WHERE room= ?");

						// System.out.println("number activation: " + number_activation);
						update.setString(1, last1.trim());
						update.setString(2, first1.trim());
						update.setString(3, room.trim());
						update.executeUpdate();
						update.close();
						rs.close();
						conn.close();
						JOptionPane.showMessageDialog(null, first1 + " " + last1 + " was saved to room " + room);
						reReset();
						break;
					}
					if (YesOrNo == 1) {
						JOptionPane.showMessageDialog(null, "Input has been cancelled");
					}
				}

			}
//				System.out.println(current);

		} catch (SQLException e1) {
//				JOptionPane.showMessageDialog(null, e1.getMessage());
			e1.printStackTrace();
		}

	}

	// search info based on the room number
	// database related
	// check_room
	protected void search_room(String room1) {

		Connection conn = dbConnection.connect();
//		lastname, firstname, paidnights, freenights, notes, notedate, totalnights
		try {
			PreparedStatement ps = conn.prepareStatement(
					"SELECT lastname, firstname, freenights, paidnights, notes, notedate, totalnights FROM Residents WHERE room= ?");
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
				notes_date = rs.getString("notedate");
				totalnights = rs.getInt("totalnights");
				rs.close();

				if (last.length() < 3 && first.length() < 3) {
					JOptionPane.showMessageDialog(null, "Must Assign Name to room " + room1);

				}
				if (last.length() > 3 && first.length() > 3) {
					Jtext_Field(last, first, room1, free_nights, paid_nights, write, notes_date, totalnights);

				}

			}
			ps.close();

		} catch (SQLException e1) {
//			JOptionPane.showMessageDialog(null, e1.getMessage());
			e1.printStackTrace();
		}

	}

	// -------------------------------------------------------------------
	// search last name of the resident or guest
	// check_lastname
	protected void search_history(String table, String room1) {

		Connection conn = dbConnection.connect();

		// Resident Search

		try {

			Statement pr = conn.createStatement();
//					pr.setString(1, room);
//					pr.setString(2, last);
//				System.out.println(guest_last);
			ResultSet rs = pr.executeQuery("SELECT * FROM " + table + " WHERE room= " + room1 + "");

//				System.out.println(room);

			while (rs.next()) {
				last = rs.getString("lastname");
				first = rs.getString("firstname");
				room = rs.getString("room");
				paid_nights = rs.getInt("paidnights");
				free_nights = rs.getInt("freenights");
				totalnights = rs.getInt("totalnights");
				n1 = rs.getString("one");
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

//				System.out.println("resident info:  " + n1);

			}
			conn.close();
//				System.out.println(n1);
//						
////						System.out.println(room);
//						rs.close();
//					}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		// create a file with all the records for display

	}

	// search guest info and connected to guest_info_file method
	protected void guest_search_info(String table, String glast) {

		Connection conn = dbConnection.connect();
		String guestfile = "guest.txt";

		try {
			PreparedStatement ps = conn
					.prepareStatement("SELECT room, firstname, totalnights FROM " + table + " WHERE lastname= ? ");
			ps.setString(1, glast);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
//				first = rs.getString("firstname");
				room = rs.getString("room");
				first = rs.getString("firstname");
				totalnights = rs.getInt("totalnights");
				System.out.println(room + "  " + glast);
				guest_info_file(guestfile, glast, room, first, totalnights);

			}

			conn.close();

		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	// Guest individual history from guest_search_info method
	protected void guest_info_file(String filename, String glast, String room, String first, int totaln) {

		try {

			BufferedWriter out = new BufferedWriter(new FileWriter(filename, true));
			if (glast.length() > 2 && room.length() > 2) {
				out.write("  GUEST:" + "\n");
				out.write("  " + first.toUpperCase() + "  " + glast.toUpperCase() + "\n");
				out.write("  Room# " + room + "\n");
				out.write("  Total Nights: " + totaln + "\n");
				out.write("\n");
//					out.write("\n");
//					out.write("\n");
				out.close();
			}
//				last = "";
//				first = "";

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	// history of the the resident's profile
	protected void resident_info_file(String filename) {
//		String filename = "resident.text";
//		String filelog = "log.txt";

		String[] n = { n1, n2, n3, n4, n5, n6, n6, n7, n8, n9, n10, n11, n12, n13, n14, n15, n16, n17, n18, n19, n20,
				n21, n22, n23, n24, n25, n26, n27, n28, n29, n30 };

		String[] nl = { n1l, n2l, n3l, n4l, n5l, n6l, n7l, n8l, n9l, n10l, n11l, n12l, n13l, n14l, n15l, n16l, n17l,
				n18l, n19l, n20l, n21l, n22l, n23l, n24l, n25l, n26l, n27l, n28l, n29l, n30l, n31l };
		if (filename.equals("residentsearch.txt")) {
//			System.out.println(filename);

			try {
				BufferedWriter out = new BufferedWriter(new FileWriter(filename, true));

				out.write(" Next Available Night: " + "\n");
				out.write("\n");
				for (int i = 0; i < n.length - 1 && n[i].length() > 2; i++) {
					out.write(" Night " + (i + 1) + ": " + n[i] + "\n");
//					System.out.println(n[i]);
					out.write("\n");
				}

				out.close();

			} catch (IOException e) {
				System.out.print(e);
			}
		}
		if (filename.equals("logsearch.txt")) {
//			System.out.println(filename);
			try {
				BufferedWriter log = new BufferedWriter(new FileWriter(filename, true));

				log.write(" Log in day: " + "\n");
				log.write("\n");
				for (int i = 0; i < nl.length - 1 && nl[i].length() > 2; i++) {
					log.write(" Night " + (i + 1) + ": " + nl[i] + "\n");
					log.write("\n");
				}
				log.close();

			} catch (IOException e) {
				System.out.println(e);
			}

		}

	}

	protected void info_file(String filename) {
//		String filename = "infohistory.txt";
		String[] n = { n1, n2, n3, n4, n5, n6, n6, n7, n8, n9, n10, n11, n12, n13, n14, n15, n16, n17, n18, n19, n20,
				n21, n22, n23, n24, n25, n26, n27, n28, n29, n30 };

		String[] nl = { n1l, n2l, n3l, n4l, n5l, n6l, n7l, n8l, n9l, n10l, n11l, n12l, n13l, n14l, n15l, n16l, n17l,
				n18l, n19l, n20l, n21l, n22l, n23l, n24l, n25l, n26l, n27l, n28l, n29l, n30l, n31l };

		if (filename.equals("infohistory.txt")) {

			try {

				BufferedWriter out = new BufferedWriter(new FileWriter(filename, true));

				if (last.length() > 2) {

					out.write(" " + "GUEST" + "\n");
					out.write(" Last Name: " + last.toUpperCase() + ",   First Name: " + first.toUpperCase() + "\n");
					out.write(
							" Free Night #:  " + free_nights + "        " + "Charged Night #:  " + paid_nights + "\n");
					out.write(" Total Nighs #:  " + totalnights + "    " + "\n");
					out.write(" Room #:  " + room + "\n");
					out.write("\n");
					out.write(" Next Available Night: " + "\n");
					for (int i = 0; i < n.length - 1 && n[i].length() > 2; i++) {
						out.write(" Night " + (i + 1) + ": " + n[i] + "\n");
						out.write("\n");
					}
					out.write("\n");
					out.close();

				}

//				last = "";
//				first = "";

			} catch (IOException e) {

				e.printStackTrace();
			}

		}
		if (filename.equals("loghistory.txt")) {

			try {

				BufferedWriter out = new BufferedWriter(new FileWriter(filename, true));

				if (last.length() > 2) {

					out.write(" " + "GUEST <-----" + "\n");
					out.write(" Last Name: " + last.toUpperCase() + "\n");
					out.write(" First Name: " + first.toUpperCase() + "\n");
					out.write("\n");
					out.write(" Room #:  " + room + "\n");
					out.write(" Log in day: " + "\n");
					for (int i = 0; i < nl.length - 1 && nl[i].length() > 2; i++) {
						out.write(" Night " + (i + 1) + ": " + nl[i] + "\n");
						out.write("\n");
					}
					out.write("\n");
					out.close();

				}

//				last = "";
//				first = "";

			} catch (IOException e) {

				e.printStackTrace();
			}

		}

	}

	// show info file
	protected void info_file_show(String filename) throws IOException {

//		String filename = "logsearch.txt";
//		String filename = "infohistory.txt";
//		String filename = "loghistory.txt";
		if (filename.equals("infohistory.txt")) {
			try {
				FileReader read = new FileReader(filename);
				BufferedReader br = new BufferedReader(read);
				infofile_textArea.read(br, null);
				br.close();

//				PrintWriter in = new PrintWriter(filename);
//				in.close();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		if (filename.equals("guest.txt")) {
			try {
				FileReader read = new FileReader(filename);
				BufferedReader br = new BufferedReader(read);
				infofile1_textArea.read(br, null);
				br.close();

//				PrintWriter in = new PrintWriter(filename);
//				in.close();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		if (filename.equals("residentsearch.txt")) {
			try {
				FileReader read = new FileReader(filename);
				BufferedReader br = new BufferedReader(read);
				Resident_info_textArea.read(br, null);
				br.close();

//				PrintWriter in = new PrintWriter(filename);
//				in.close();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		if (filename.equals("logsearch.txt")) {
			try {
				FileReader read = new FileReader(filename);
				BufferedReader br = new BufferedReader(read);
				resident_log_textArea.read(br, null);
				br.close();

//				PrintWriter in = new PrintWriter(filename);
//				in.close();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		if (filename.equals("loghistory.txt")) {
			try {
				FileReader read = new FileReader(filename);
				BufferedReader br = new BufferedReader(read);
				guest_log_textArea.read(br, null);
				br.close();

//				PrintWriter in = new PrintWriter(filename);
//				in.close();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

	}

	// close window
	private void close() {
		WindowEvent winClsingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClsingEvent);

	}

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

