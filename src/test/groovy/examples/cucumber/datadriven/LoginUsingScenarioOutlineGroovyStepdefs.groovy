package examples.cucumber.datadriven

import cucumber.api.DataTable
import examples.login.*
this.metaClass.mixin(cucumber.api.groovy.EN)

LoginParams userLoggingIn
LoginGreeting loginGreeting
LoginService loginService

Given(~'^I provide "([^"]*)" and "([^"]*)"$') { String login, String password ->
    userLoggingIn = new LoginParams(login, password)
    loginService = new LoginServiceImpl(new UserDetailsRepoStub2())
}

When(~'I login with the provided details$') { ->
    loginGreeting = loginService.login(userLoggingIn)
}
Then(~'^login greeting should mention "([^"]*)" (\\d+) (\\d+)$') { String fullName, int lastSeen, int repPoints ->
    assert loginGreeting.fullName == fullName 
    assert loginGreeting.toString() == "Hi ${fullName}, haven't seen you since ${lastSeen} (current reputation: ${repPoints})"
}

class UserDetailsRepoStub2 implements UserDetailsRepo {
    def repo = ["ralph@email.com":  new UserDetailsImpl("Ralph", "Malph", "20130619", 15),
                "potsie@email.com": new UserDetailsImpl("Potsie", "Webber", "20130617", 19),
                "richie@email.org": new UserDetailsImpl("Richie", "Cunningham", "20130613", 21)]

    public UserDetails find(String login) {
        return repo[login]
    }
}