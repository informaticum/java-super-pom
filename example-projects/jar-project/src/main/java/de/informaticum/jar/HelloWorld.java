package de.informaticum.jar;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.joining;
import java.util.ArrayList;
import java.util.List;

public class HelloWorld {

    public static void main(final String[] args) {
        final HelloWorld hw = new HelloWorld();
        System.out.println(hw.getMessage());
    }

    public String getMessage() {
        // static imports requires Java 1.5
        final List<String> list = asList("Hello", "world!");
        // diamond operator requires Java 1.7
        final List<String> arrayList = new ArrayList<>(list);
        // lambda expression requires Java 1.8
        return arrayList.stream().map(s -> s).collect(joining(" "));
    }

}
