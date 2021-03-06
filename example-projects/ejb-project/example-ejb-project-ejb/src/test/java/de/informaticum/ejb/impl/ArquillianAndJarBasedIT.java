package de.informaticum.ejb.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.io.File;
import javax.inject.Inject;
import de.informaticum.ejb.api.HelloWorldAPI;
import de.informaticum.ejb.api.HelloYouAPI;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class ArquillianAndJarBasedIT {

    private static final String EJB_FILE = "example-ejb-project-ejb-0.0.1-SNAPSHOT.jar";

    @Deployment
    public static Archive<?> createDeployment() {
        final File ejbFile = new File("./target/" + EJB_FILE);
        assert ejbFile.exists();
        assert ejbFile.isFile();
        assert ejbFile.canRead();
        return ShrinkWrap.createFromZipFile(JavaArchive.class, ejbFile) //
                         .addClass(ArquillianAndJarBasedIT.class);
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
    private HelloYouAPI hy;

    @Before
    public void verifyHelloYouBeanInjection() {
        assertNotNull(this.hy);
    }

    @Test
    public void testGreeting()
    throws Exception {
        assertEquals("Hello Kushim!", this.hy.getGreeting("Kushim"));
    }

}
