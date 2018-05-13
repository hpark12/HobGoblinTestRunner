package com.worldgate.request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletAngular extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ServletAngular() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            RequestHelper.process(request, response);

        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
