package examples.login;


public class LoginServiceImpl implements LoginService {

	private UserDetailsRepo userDetailsRepo;

	public LoginServiceImpl(UserDetailsRepo userDetailsRepo) {
		this.userDetailsRepo = userDetailsRepo;
	}

	@Override
	public LoginGreeting login(LoginParams loginParams) {
		UserDetails userDetails = userDetailsRepo.find(loginParams.getLogin());
		return new LoginGreeting(userDetails);
	}

}
