package org.division.biometrics.errors;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.division.biometrics.core.servlets.AbstractServlet;
import org.division.biometrics.core.utils.DeleteClassWhileMavenBuild;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/ncdfe" })
public class NoClassDefFoundErrorServlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        new DeleteClassWhileMavenBuild();
    }
}
