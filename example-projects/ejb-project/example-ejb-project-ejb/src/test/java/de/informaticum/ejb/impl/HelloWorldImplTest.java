package de.informaticum.ejb.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import de.informaticum.ejb.api.HelloEchoAPI;
import de.informaticum.ejb.api.HelloWorldAPI;
import org.junit.Before;
import org.junit.Test;

public class HelloWorldImplTest {

    private HelloWorldAPI hw;

    @Before
    public void newHelloWorldBean() {
        this.hw = new HelloWorldEnterpriseJavaBean();
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

    private HelloEchoAPI hy;

    @Before
    public void newHelloYouBean() {
        this.hy = new HelloEchoEnterpriseJavaBean();
    }

    @Test
    public void testEcho()
    throws Exception {
        assertNotNull(this.hy);
        assertEquals("Echo: Hello myself!", this.hy.getEchoMessage("Hello myself!"));
    }

}
