package de.informaticum.ejb.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import de.informaticum.ejb.api.HelloWorldAPI;
import de.informaticum.ejb.api.HelloYouAPI;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class ArquillianBasedJndiIT {

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(JavaArchive.class) //
                         .addClass(HelloWorldEnterpriseJavaBean.class) //
                         .addClass(HelloYouEnterpriseJavaBean.class) //
                         .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    private static final String BEAN_PREFIX = "java:global/test/";

    private HelloWorldAPI hw;

    @Before
    public void lookupHelloWorldBean()
    throws NamingException {
        final Context context = new InitialContext();
        final Object bean = context.lookup(BEAN_PREFIX + HelloWorldEnterpriseJavaBean.class.getSimpleName());
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

    private HelloYouAPI hy;

    @Before
    public void lookupHelloYouBean()
    throws NamingException {
        final Context context = new InitialContext();
        final Object bean = context.lookup(BEAN_PREFIX + HelloYouEnterpriseJavaBean.class.getSimpleName());
        assertNotNull(bean);
        assertTrue(bean instanceof HelloYouAPI);
        this.hy = (HelloYouAPI) bean;
    }

    @Test
    public void testGreeting()
    throws Exception {
        assertNotNull(this.hy);
        assertEquals("Hello Kushim!", this.hy.getGreeting("Kushim"));
    }

}
