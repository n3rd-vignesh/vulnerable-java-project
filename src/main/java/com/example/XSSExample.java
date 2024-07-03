package com.example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class XSSExample {
    public void run(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userInput = request.getParameter("input");

        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Welcome, " + userInput + "!</h1>");
        response.getWriter().println("</body></html>");
    }
}
