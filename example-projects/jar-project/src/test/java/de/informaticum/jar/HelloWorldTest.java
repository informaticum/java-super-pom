package de.informaticum.jar;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class HelloWorldTest {

    @Test
    public void test() {
        final HelloWorld hw = new HelloWorld();
        assertEquals("Hello world!", hw.getMessage());
    }

}
