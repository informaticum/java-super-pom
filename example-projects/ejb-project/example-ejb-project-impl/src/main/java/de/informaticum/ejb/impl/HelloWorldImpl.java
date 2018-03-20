package de.informaticum.ejb.impl;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.joining;
import java.util.ArrayList;
import java.util.List;
import de.informaticum.ejb.api.HelloWorld;

public class HelloWorldImpl
implements HelloWorld {

    @Override
    public String getMessage() {
        // assert statement requires Java 1.4
        assert true;
        // static imports requires Java 1.5
        final List<String> list = asList("Hello", "world!");
        // diamond operator requires Java 1.7
        final List<String> arrayList = new ArrayList<>(list);
        // lambda expression requires Java 1.8
        return arrayList.stream().map(s -> s).collect(joining(" "));
    }

}