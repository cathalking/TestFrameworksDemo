package examples.login;


public interface UserDetailsRepo {

	UserDetails find(String login);

}
