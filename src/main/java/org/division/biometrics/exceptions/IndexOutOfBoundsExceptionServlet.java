package org.division.biometrics.exceptions;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.division.biometrics.core.servlets.AbstractServlet;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/ioobe" })
public class IndexOutOfBoundsExceptionServlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        new ArrayList<String>().get(1);
    }
}
