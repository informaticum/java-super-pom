package de.informaticum.jar;

import static java.lang.String.join;

public class HelloWorld {

    public static void main(final String[] args) {
        final HelloWorld hw = new HelloWorld();
        System.out.println(hw.getMessage());
    }

    public String getMessage() {
        return join(" ", "Hello", "world!");
    }

}
