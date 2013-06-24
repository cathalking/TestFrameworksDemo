package examples.cucumber.helloworld
import static org.hamcrest.CoreMatchers.*
import static org.junit.Assert.*
import examples.helloworld.Hello

Hello hello;
String hii;

this.metaClass.mixin(cucumber.api.groovy.EN)

Given(~'I have a hello app with "([^"]*)"$') { someGreeting ->
    hello = new Hello(someGreeting);
}

When(~'I ask it to say hi') { ->
    hi = hello.sayHi();
}

When(~'I ask it to say hey') { ->
    hi = hello.sayHey();
}

Then(~'it should answer with "([^"]*)"$') { hi -> 
    assert "Hey World" == hi
}