package examples.login;

//import cucumber.deps.com.thoughtworks.xstream.annotations.XStreamConverter;
//import cucumber.deps.com.thoughtworks.xstream.converters.javabean.JavaBeanConverter;

//@XStreamConverter(JavaBeanConverter.class)
public class LoginParams {

	private String login;
	private String password;
	    
	public String getLogin() {
		return login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public LoginParams(String username, String password) {
		this.login = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginParams [login=" + login + ", password=" + password + "]";
	}

}
