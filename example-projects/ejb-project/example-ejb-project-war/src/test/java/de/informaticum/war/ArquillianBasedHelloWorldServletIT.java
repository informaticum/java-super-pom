package de.informaticum.war;

import static javax.ws.rs.client.ClientBuilder.newClient;
import static org.junit.Assert.assertEquals;
import java.net.MalformedURLException;
import java.net.URL;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import de.informaticum.ejb.impl.HelloWorldEnterpriseJavaBean;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class ArquillianBasedHelloWorldServletIT {

    @Deployment(testable = false)
    public static WebArchive create() {
        return ShrinkWrap.create(WebArchive.class) //
                         .addClass(HelloWorldServlet.class) //
                         .addClass(HelloWorldEnterpriseJavaBean.class);
    }

    @Test
    @RunAsClient
    public void testFoobarResponse(@ArquillianResource final URL base)
    throws MalformedURLException {
        final Client client = newClient();
        final String uri = new URL(base, "helloworld").toExternalForm();
        final WebTarget target = client.target(uri);
        final Response response = target.request().get();

        final String actual = response.readEntity(String.class).trim();
        assertEquals("Hello world!", actual);
    }

}
