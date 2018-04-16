package de.informaticum.war;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import de.informaticum.ejb.api.HelloWorldAPI;

@WebServlet(urlPatterns = "/helloworld")
public class HelloWorldServlet
extends HttpServlet {

    private static final long serialVersionUID = 2918829735012429445L;

    @Inject
    private HelloWorldAPI helloWorldAPI;

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
    throws ServletException, IOException {
        resp.getWriter().println(this.helloWorldAPI.getMessage());
    }

}
