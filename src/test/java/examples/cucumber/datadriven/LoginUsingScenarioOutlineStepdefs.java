package examples.cucumber.datadriven;

import java.util.*;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import examples.login.*;
import static org.fest.assertions.api.Assertions.*;

public class LoginUsingScenarioOutlineStepdefs {

    private LoginParams userLoggingIn;
    private LoginGreeting loginGreeting;
    private LoginService loginService;

    @Given("^I provide \"([^\"]*)\" and \"([^\"]*)\"$")
    public void I_provide_and(String login, String password) throws Throwable {
        userLoggingIn = new LoginParams(login, password);
        UserDetailsRepo  userDetailsRepoStub = new UserDetailsRepoStub();
        loginService = new LoginServiceImpl(userDetailsRepoStub);
    }
    
    @When("^I login with the provided details$")
    public void I_login_with_the_provided_details() {
        loginGreeting = loginService.login(userLoggingIn);
    }

    @Then("^login greeting should mention \"([^\"]*)\" (\\d+) (\\d+)$")
    public void login_greeting_should_mention(String fullName, int lastSeen, int repPoints) throws Throwable {
        assertThat(loginGreeting.getFullName()).isEqualTo(fullName);
        assertThat(loginGreeting.toString()).isEqualTo(String.format("Hi %s, haven't seen you since %d (current reputation: %d)", fullName, lastSeen, repPoints));
    }

    class UserDetailsRepoStub implements UserDetailsRepo {
        private Map<String, UserDetails> repo = new HashMap<String, UserDetails>();
        {
            repo.put("ralph@email.com", new UserDetailsImpl("Ralph", "Malph", "20130619"));
            repo.put("potsie@email.com", new UserDetailsImpl("Potsie", "Webber", "20130617"));
            repo.put("richie@email.org", new UserDetailsImpl("Richie", "Cunningham", "20130613"));
        }

        @Override
        public UserDetails find(String login) {
            return repo.get(login);
        }
    }
}