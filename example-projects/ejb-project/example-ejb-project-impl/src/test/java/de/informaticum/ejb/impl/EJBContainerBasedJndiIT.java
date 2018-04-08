package de.informaticum.ejb.impl;

import static javax.ejb.embeddable.EJBContainer.createEJBContainer;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import de.informaticum.ejb.api.HelloWorldAPI;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EJBContainerBasedJndiIT {

    private static EJBContainer ejbContainer;

    @BeforeClass
    public static void setUp() {
        final Map<String, File[]> properties = new HashMap<>();
        properties.put(EJBContainer.MODULES, new File[] { new File("target/classes"), new File("target/test-classes") });
        ejbContainer = createEJBContainer(properties);
        assertNotNull(ejbContainer);
    }

    @AfterClass
    public static void tearDown() {
        ejbContainer.close();
    }

    private HelloWorldAPI hw;

    private static final String BEAN_PREFIX = "java:global/classes/";

    @Before
    public void newInstance()
    throws NamingException {
        final Context context = ejbContainer.getContext();
        final Object bean = context.lookup(BEAN_PREFIX + HelloWorldImpl.class.getSimpleName());
        assertNotNull(bean);
        assertTrue(bean instanceof HelloWorldAPI);
        this.hw = (HelloWorldAPI) bean;
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
