package examples.cucumber.datadriven;

import java.util.*;
import cucumber.api.DataTable;
import cucumber.api.java.en.*;
import examples.login.*;

public class LoginStepdefs {

    private List<LoginParams> usersLoggingIn;
    private List<LoginGreeting> loginGreetings;
    private LoginService loginService;
    private UserDetailsRepo userDetailsRepoStub;

    @Given("^I provide logindetails$")
    public void I_provide_logindetails(DataTable loginRequests) {
        usersLoggingIn = loginRequests.asList(LoginParams.class);
        userDetailsRepoStub = new UserDetailsRepoStub();
        loginService = new LoginServiceImpl(userDetailsRepoStub);
        loginGreetings = new ArrayList<LoginGreeting>();
    }

    @When("^I login$")
    public void I_login() {
        for (LoginParams loginParams : usersLoggingIn) {
            loginGreetings.add(loginService.login(loginParams));
        }
    }

    @Then("^I should see fullname greeting$")
    public void I_should_see_fullname_greeting(DataTable expectedGreetings) {
        List<Map<String, String>> actualGreetings = new ArrayList<Map<String, String>>();
        for (LoginGreeting greeting : loginGreetings) {
            Map<String, String> greetingMsg = new HashMap<String, String>();
            greetingMsg.put("fullname", greeting.getFullName());
            greetingMsg.put("lastseen", greeting.getLastSeen());
            actualGreetings.add(greetingMsg);
        }
        expectedGreetings.diff(actualGreetings);
    }

    class UserDetailsRepoStub implements UserDetailsRepo {
        private Map<String, UserDetails> repo = new HashMap<String, UserDetails>();
        {
            repo.put("aslak@email.com", new UserDetailsImpl("Aslak", "Hellesoy", "20130619"));
            repo.put("joe@email.com", new UserDetailsImpl("Joe", "Bloggs", "20130617"));
            repo.put("bryan@email.org", new UserDetailsImpl("Bryan", "Jones", "20130613"));
        }

        @Override
        public UserDetails find(String login) {
            return repo.get(login);
        }
    }
}