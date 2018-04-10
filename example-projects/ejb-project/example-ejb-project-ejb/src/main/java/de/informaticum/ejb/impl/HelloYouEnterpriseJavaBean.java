package de.informaticum.ejb.impl;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.joining;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import de.informaticum.ejb.api.HelloYouAPI;

@Stateless
public class HelloYouEnterpriseJavaBean
implements HelloYouAPI {

    @Override
    public String getGreeting(final String name) {
        // assert statement -- requires Java 1.4
        assert true;
        // static imports -- requires Java 1.5
        final List<String> list = asList("Hello", name);
        // diamond operator -- requires Java 1.7
        final List<String> arrayList = new ArrayList<>(list);
        // lambda expression -- requires Java 1.8
        final String greetings = arrayList.stream().map(s -> s).collect(joining(" "));
        return greetings.concat("!");
    }

}
