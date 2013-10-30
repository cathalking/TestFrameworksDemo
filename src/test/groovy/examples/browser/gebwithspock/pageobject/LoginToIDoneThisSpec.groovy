package examples.browser.gebwithspock.pageobject;

import java.awt.GraphicsConfiguration.DefaultBufferCapabilities;

import org.junit.Test;

import examples.login.*
import geb.spock.GebSpec
import spock.lang.*

//@Ignore
class LoginToIDoneThisSpec extends GebSpec {

	def "I follow Login link on the Homepage I will land on the Login page" () {
		given: "I am on the Homepage"
		to HomePage
		
		when: "I login"
        login.click()

		then: "Then I should see the profile page"
		at LoginPage
	}
		
    def "I enter my login details and go to the profile page" () {
        given:
        to LoginPage

        when:
        username = "cathalking1@gmail.com"
        password = "abc123"
        loginButton.click()

        then:
        at ProfilePage
	}
}

