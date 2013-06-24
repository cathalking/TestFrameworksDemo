package examples.browser.gebwithspock.pageobject

class LoginPage extends geb.Page {

	static url = "http://idonethis.com/accounts/login"
	static at = { $("title").text() contains "Profile" }
	
	static content = {
		
		username = {
			$("#id_username")
		}
		password = {
			$("#id_password")
		}
		
		loginButton =  {
			$("input", value: "Login")
		}
	}

}
