package examples.spock.datadriven;

import spock.lang.*
import examples.login.*

class LoginSpecTest extends Specification {


	@Unroll
	def "login greeting should include #expectedFullName, LastSeen:#expectedLastSeen and #expectedRepPoints" () {
				
		given: "I provide login details"
		LoginParams userLoggingIn = new LoginParams(login, password)
		def userDetailsRepoStub = Stub(UserDetailsRepo) {
			def repo = ['ralph@email.com':	new UserDetailsImpl('Ralph', 'Malph', '20130619', 15),
						'potsie@email.com':	new UserDetailsImpl('Potsie', 'Webber', '20130617', 19),
						'richie@email.org':	new UserDetailsImpl('Richie', 'Cunningham', '20130613', 21)]
			find(login) >> repo[login]
		}
		LoginService loginService = new LoginServiceImpl(userDetailsRepoStub)

		when: "I login"
		LoginGreeting loginGreeting = loginService.login(userLoggingIn)

		then: "Then greeting should use fullname and 'last seen' date"
        loginGreeting.fullName == expectedFullName
		loginGreeting.toString() == "Hi ${expectedFullName}, haven't seen you since ${expectedLastSeen} (current reputation: ${expectedRepPoints})"

		where: 'Login inputs + Expected Login greetings are:'
		login             	| password || 	expectedFullName  	| expectedLastSeen 	| expectedRepPoints
		'ralph@email.com' 	| '123'    || 	'Ralph Malph'		| '20130619'		| '15'
		'potsie@email.com'	| '234'    || 	'Potsie Webber'		| '20130617'		| '19'
		'richie@email.org' 	| '456'    || 	'Richie Cunningham'	| '20130613'		| '21'

	}
}
