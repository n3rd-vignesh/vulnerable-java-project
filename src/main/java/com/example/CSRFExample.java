package com.example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CSRFExample {
    public void run(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");

        if ("transferMoney".equals(action)) {
            // Perform money transfer
            System.out.println("Money transferred!");
        }
    }
}
