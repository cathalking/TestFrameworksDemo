package examples.browser.gebwithspock.pageobject;

import static org.fest.assertions.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import org.junit.Test;

import examples.login.*
import geb.spock.GebSpec
import spock.lang.*

//@Ignore
class LoginToIDoneThisSpec extends GebSpec {

	def "I provide username and password I can login" () {
		given: "I provide logindetails"
		
		when: "I login"
		to HomePage

		then: "Then I should see the profile page"
		at HomePage
		
//		when:
//		to LoginPage
//		// login.click()
//		
//		then:
//		at LoginPage
		
//		when:
//		username = "cathalking1@gmail.com"
//		password = "abc123"
////		loginButton.click()
//	 
//		then:
//		at ProfilePage
	}
}



