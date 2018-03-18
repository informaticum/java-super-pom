package de.informaticum.jar;

public class HelloWorld {

    public static void main(final String[] args) {
        final HelloWorld hw = new HelloWorld();
        System.out.println(hw.getMessage());
    }

    public String getMessage() {
        return "Hello world!";
    }

}
