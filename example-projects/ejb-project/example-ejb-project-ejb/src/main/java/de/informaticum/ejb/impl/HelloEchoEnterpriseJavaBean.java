package de.informaticum.ejb.impl;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.joining;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import de.informaticum.ejb.api.HelloEchoAPI;

@Stateless
public class HelloEchoEnterpriseJavaBean
implements HelloEchoAPI {

    @Override
    public String getEchoMessage(final String message) {
        // assert statement -- requires Java 1.4
        assert true;
        // static imports -- requires Java 1.5
        final List<String> list = asList("Echo:", message);
        // diamond operator -- requires Java 1.7
        final List<String> arrayList = new ArrayList<>(list);
        // lambda expression -- requires Java 1.8
        return arrayList.stream().map(s -> s).collect(joining(" "));
    }

}