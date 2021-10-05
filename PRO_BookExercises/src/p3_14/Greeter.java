package p3_14;

public class Greeter {
    final private String name;

    public Greeter(String name) {
        this.name = name;
    }

    public String sayHello() {
        return String.format("Hello, %s", this.name);
    }

    public String sayGoodbye() { return String.format("Goodbye, %s", this.name); }

    public String refuseHelp() { return String.format("I'm sorry, %s. I am afraid I can't do that.", this.name); }
}
