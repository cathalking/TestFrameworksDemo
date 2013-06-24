package examples.browser.gebwithspock.pageobject

class ProfilePage extends geb.Page {

	static url = "http://idonethis.com/cal/team-king"
	static at = { $("title").text() contains "Profile" }
	
}
