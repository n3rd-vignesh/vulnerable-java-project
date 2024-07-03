package com.example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OpenRedirectExample {
    public void run(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String url = request.getParameter("url");

        response.sendRedirect(url);
    }
}
