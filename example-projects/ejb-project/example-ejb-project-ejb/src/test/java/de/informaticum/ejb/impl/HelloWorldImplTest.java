package de.informaticum.ejb.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import de.informaticum.ejb.api.HelloWorldAPI;
import de.informaticum.ejb.api.HelloYouAPI;
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

    private HelloYouAPI hy;

    @Before
    public void newHelloYouBean() {
        this.hy = new HelloYouEnterpriseJavaBean();
    }

    @Test
    public void testGreeting()
    throws Exception {
        assertNotNull(this.hy);
        assertEquals("Hello Kushim!", this.hy.getGreeting("Kushim"));
    }

}
