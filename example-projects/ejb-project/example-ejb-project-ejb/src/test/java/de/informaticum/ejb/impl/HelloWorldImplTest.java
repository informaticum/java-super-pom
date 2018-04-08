package de.informaticum.ejb.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import de.informaticum.ejb.api.HelloWorldAPI;
import org.junit.Before;
import org.junit.Test;

public class HelloWorldImplTest {

    private HelloWorldAPI hw;

    @Before
    public void newInstance() {
        this.hw = new HelloWorldImpl();
    }

    @Test
    public void testHelloWorld()
    throws Exception {
        assertNotNull(this.hw);
        assertEquals("Hello world!", this.hw.getMessage());
    }

    @Test
    public void testReproducibility()
    throws Exception {
        assertNotNull(this.hw);
        final String message1 = this.hw.getMessage();
        final String message2 = this.hw.getMessage();
        assertEquals(message1, message2);
    }

    @Test
    public void testGreeting()
    throws Exception {
        assertNotNull(this.hw);
        assertEquals("Hello Kushim!", this.hw.getGreeting("Kushim"));
    }

}
