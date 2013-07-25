package examples.helloworld;

public class Hello {
    private final String greeting;
    private String name;

    public Hello(String greeting) {
        this.greeting = greeting;
    }

    public String sayHi() {
        return greeting + " World";
    }

	public String sayHey() {
		return greeting + " y'all!";
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public boolean mindBlown() {
        return true;
    }
    
    public boolean isTimAmazing() {
        return true; // obviously
    }
}
