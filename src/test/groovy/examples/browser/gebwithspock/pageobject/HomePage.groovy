package examples.browser.gebwithspock.pageobject

class HomePage extends geb.Page {

	static url = "http://idonethis.com"
	
	static content = {
		login =  { $("#login-link")	}
	}

}
