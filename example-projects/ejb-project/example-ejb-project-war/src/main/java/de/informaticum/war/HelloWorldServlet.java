package de.informaticum.war;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import de.informaticum.ejb.api.HelloWorld;

@WebServlet(urlPatterns = "/")
public class HelloWorldServlet
extends HttpServlet {

    private static final long serialVersionUID = -8760034787711675431L;

    @EJB
    private HelloWorld helloWorld;

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
    throws ServletException, IOException {
        resp.getWriter().write(this.helloWorld.getMessage());
    }

}
