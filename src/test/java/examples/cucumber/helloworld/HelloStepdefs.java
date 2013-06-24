package examples.cucumber.helloworld;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import examples.helloworld.Hello;

import static org.junit.Assert.assertEquals;

public class HelloStepdefs {

	private Hello hello;
	private String hi;

	@Given("^I have a hello app with \"([^\"]*)\"$")
	public void I_have_a_hello_app_with(String arg) {
		hello = new Hello(arg);
	}

	@When("^I ask it to say hi$")
	public void I_ask_it_to_say_hi() {
		hi = hello.sayHi();
	}

	@When("^I ask it to say hey$")
	public void I_ask_it_to_say_hey() {
		hi = hello.sayHey();
	}

	@Then("^it should answer with \"([^\"]*)\"$")
	public void it_should_answer_with(String arg1) throws Throwable {
		assertEquals(arg1, hi);
	}

}
