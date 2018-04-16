package de.informaticum.war;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import de.informaticum.ejb.api.HelloYouAPI;

@WebServlet(urlPatterns = "/helloyou")
public class HelloYouServlet
extends HttpServlet {

    private static final long serialVersionUID = -8227655462405657617L;

    @Inject
    private HelloYouAPI helloYouAPI;

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp)
    throws ServletException, IOException {
        final String name = new BufferedReader(new InputStreamReader(req.getInputStream())).readLine();
        resp.getWriter().println(this.helloYouAPI.getGreeting(name));
    }

}
