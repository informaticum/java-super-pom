package de.informaticum.war;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/hellome")
public class StandAloneServlet
extends HttpServlet {

    private static final long serialVersionUID = 5803671935884740955L;

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
    throws ServletException, IOException {
        resp.getWriter().println("Hello me!");
    }

}
