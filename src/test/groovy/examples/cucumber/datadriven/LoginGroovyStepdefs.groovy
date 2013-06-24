package examples.cucumber.datadriven

import cucumber.api.DataTable
import examples.login.*
this.metaClass.mixin(cucumber.api.groovy.EN)

UserDetailsRepo userDetailsRepoStub = new UserDetailsRepoStub()
LoginService loginService = new LoginServiceImpl(userDetailsRepoStub)

List<LoginParams> usersLoggingIn
List<LoginGreeting> loginGreetings

Given(~'^I provide logindetails$') { loginRequests ->
	usersLoggingIn = loginRequests.asList(LoginParams.class)
}

When(~'I login$') { ->
	loginGreetings = usersLoggingIn.collect { loginService.login(it) }
}

Then(~'^I should see fullname greeting$') { expected ->
	def actual = loginGreetings.collect {
		["fullname":it.fullName, "lastseen":it.lastSeen]}
	expected.diff(actual)
}

class UserDetailsRepoStub implements UserDetailsRepo {
	def repo = ["aslak@email.com":	new UserDetailsImpl("Aslak", "Hellesoy", "20130619"),
				"joe@email.com":	new UserDetailsImpl("Joe", "Bloggs", "20130617"),
				"bryan@email.org":	new UserDetailsImpl("Bryan", "Jones", "20130613")]

	public UserDetails find(String login) {
		return repo[login]
	}
}


