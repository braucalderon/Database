import javax.swing.Spring;

public class User {
	
	private String room;
	private String lastname;
	private String firstname;
	private int nights;
	
	public User() {
		room = " ";
		lastname = " ";
		firstname = " ";
		nights = 0;
	}
	public User(int nights) {
		setNights(nights);
	}
	public User(String room) {
		setRoom(room);
	}
	public User(String lastname, String firstname, String room, int nights) {
		
		setLastname(lastname);
		setFirstname(firstname);
		setRoom(room);
		setNights(nights);
		
	}
	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public int getNights() {
		return nights;
	}

	public void setNights(int nights) {
		this.nights = nights;
	}
	 

}//end class
