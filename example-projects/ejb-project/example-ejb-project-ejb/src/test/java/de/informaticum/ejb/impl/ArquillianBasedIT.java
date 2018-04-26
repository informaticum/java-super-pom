package de.informaticum.ejb.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import javax.inject.Inject;
import de.informaticum.ejb.api.HelloEchoAPI;
import de.informaticum.ejb.api.HelloWorldAPI;
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
public class ArquillianBasedIT {

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(JavaArchive.class) //
                         .addClass(HelloWorldEnterpriseJavaBean.class) //
                         .addClass(HelloEchoEnterpriseJavaBean.class) //
                         .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Inject
    private HelloWorldAPI hw;

    @Before
    public void verifyHelloWorldBeanInjection() {
        assertNotNull(this.hw);
    }

    @Test
    public void testHelloWorld()
    throws Exception {
        assertEquals("Hello world!", this.hw.getMessage());
    }

    @Test
    public void testReproducibility()
    throws Exception {
        final String message1 = this.hw.getMessage();
        final String message2 = this.hw.getMessage();
        assertEquals(message1, message2);
    }

    @Inject
    private HelloEchoAPI hy;

    @Before
    public void verifyHelloYouBeanInjection() {
        assertNotNull(this.hy);
    }

    @Test
    public void testEcho()
    throws Exception {
        assertEquals("Echo: Hello myself!", this.hy.getEchoMessage("Hello myself!"));
    }

}
