package examples.browser.gebwithspock;

import static org.fest.assertions.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import org.junit.Test;

import examples.login.*
import geb.spock.GebSpec
import spock.lang.*

class LoginToIDoneThisSpec extends GebSpec {

	def "I provide username and password I can login" () {
		given: "I provide logindetails"
		go "http://idonethis.com"
		
		when: "I login"
		find("#login-link").click();
		$("#id_username") << "cathalking1@gmail.com"
		$("#id_password") << "abc123"
		$("input", value: "Login").click()
	 
		then: "Then I should see the profile page"
		title.contains "Profile"
	}
}



