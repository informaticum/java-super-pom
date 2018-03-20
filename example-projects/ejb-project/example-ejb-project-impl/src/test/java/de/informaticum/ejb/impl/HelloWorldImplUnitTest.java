package de.informaticum.ejb.impl;

import static org.junit.Assert.assertEquals;
import de.informaticum.ejb.impl.HelloWorldImpl;
import org.junit.Test;

public class HelloWorldImplUnitTest {

    @Test
    public void test() {
        final HelloWorldImpl hw = new HelloWorldImpl();
        assertEquals("Hello world!", hw.getMessage());
    }

}
