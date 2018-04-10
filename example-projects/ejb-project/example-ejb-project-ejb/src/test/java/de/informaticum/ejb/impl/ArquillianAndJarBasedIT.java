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
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class ArquillianAndJarBasedIT {

    private static final String EJB_FILE = "example-ejb-project-ejb-0.0.1-SNAPSHOT.jar";

    @Deployment
    public static Archive<?> createDeployment() {
        final File archiveFile = new File("./target/" + EJB_FILE);
        assert archiveFile.exists();
        assert archiveFile.isFile();
        assert archiveFile.canRead();
        return ShrinkWrap.createFromZipFile(JavaArchive.class, archiveFile) //
                         .addClass(ArquillianAndJarBasedIT.class);
    }

    @Inject
    HelloWorldAPI hw;

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

    @Inject
    HelloYouAPI hy;

    @Test
    public void testGreeting()
    throws Exception {
        assertNotNull(this.hy);
        assertEquals("Hello Kushim!", this.hy.getGreeting("Kushim"));
    }

}
