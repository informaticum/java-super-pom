package de.informaticum.war;

import static javax.ws.rs.client.ClientBuilder.newClient;
import static javax.ws.rs.client.Entity.text;
import static org.jboss.shrinkwrap.api.ShrinkWrap.createFromZipFile;
import static org.junit.Assert.assertEquals;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class ArquillianAndWarBasedHelloYouServletIT {

    private static final String WAR_FILE = "example-ejb-project-war-0.0.1-SNAPSHOT.war";

    private static final String EJB_FILE = "example-ejb-project-ejb-0.0.1-SNAPSHOT.jar";

    @Deployment(testable = false)
    public static Archive<?> createDeployment() {
        final File ejbFile = new File("../example-ejb-project-ejb/target/" + EJB_FILE);
        assert ejbFile.exists();
        assert ejbFile.isFile();
        assert ejbFile.canRead();
        final EnterpriseArchive ejbArchive = createFromZipFile(EnterpriseArchive.class, ejbFile);
        final File warFile = new File("./target/" + WAR_FILE);
        assert warFile.exists();
        assert warFile.isFile();
        assert warFile.canRead();
        return createFromZipFile(WebArchive.class, warFile).addAsLibrary(ejbArchive);
    }

    @Test
    @RunAsClient
    public void testFoobarResponse(@ArquillianResource final URL base)
    throws MalformedURLException {
        final Client client = newClient();
        final String uri = new URL(base, "helloyou").toExternalForm();
        final WebTarget target = client.target(uri);
        final Response response = target.request().post(text("Kushim"));

        final String actual = response.readEntity(String.class).trim();
        assertEquals("Hello Kushim!", actual);
    }

}
