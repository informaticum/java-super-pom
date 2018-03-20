package de.informaticum.ejb.impl;

import static javax.ejb.embeddable.EJBContainer.createEJBContainer;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import de.informaticum.ejb.api.HelloWorld;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class HelloWorldImplIntegrationTest {

    private static EJBContainer ejbContainer;

    @BeforeClass
    public static void setUp() {
        ejbContainer = createEJBContainer();
    }

    @AfterClass
    public static void tearDown() {
        ejbContainer.close();
    }

    @Test
    public void testApp()
    throws NamingException {
        final Context context = ejbContainer.getContext();
        final Object lookup = context.lookup("java:global/classes/HelloWorldBean");
        assertNotNull(lookup);
        assertTrue(lookup instanceof HelloWorld);
        final HelloWorld hw = (HelloWorld) lookup;
        assertEquals("Hello world!", hw.getMessage());
    }

}
