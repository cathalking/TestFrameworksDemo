package examples.login;

public class LoginGreeting {

	private String fullName;
	private String lastSeen;
	private int repPoints;

	public String getFullName() {
		return fullName;
	}
	
	public String getLastSeen() {
		return lastSeen;
	}

	public LoginGreeting(UserDetails userDetails) {
		this.fullName = userDetails.getFullName();
		this.lastSeen = userDetails.getLastSeen();
		this.repPoints = userDetails.getRepPoints();
	}

	@Override
	public String toString() {
		return "Hi " + fullName + ", haven't seen you since " + lastSeen
				+ " (current reputation: " + repPoints + ")";
	}

}
