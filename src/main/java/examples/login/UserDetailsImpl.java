package examples.login;

public class UserDetailsImpl implements UserDetails {

	private String firstName;
	private String lastName;
	private String lastSeen;
	private int repPoints;
	
	public UserDetailsImpl(String firstName, String lastName, String lastSeen, int repPoints) {
		this(firstName, lastName, lastSeen);
		this.repPoints = repPoints;
	}
	
	public UserDetailsImpl(String firstName, String lastName, String lastSeen) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.lastSeen = lastSeen;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getLastSeen() {
		return lastSeen;
	}
	
	public int getRepPoints() {
		return repPoints;
	}

	@Override
	public String getFullName() {
		return firstName + " " + lastName;
	}

}
