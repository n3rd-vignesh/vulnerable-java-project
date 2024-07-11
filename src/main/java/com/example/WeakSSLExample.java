package com.example;

import javax.net.ssl.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class WeakSSLExample {

    public static void main(String[] args) {
        try {
            // Create an SSLContext that uses SSLv3 (insecure)
            SSLContext sslContext = SSLContext.getInstance("SSLv3");
            sslContext.init(null, new TrustManager[]{new InsecureTrustManager()}, new java.security.SecureRandom());

            // Create a socket factory from the SSLContext
            SSLSocketFactory socketFactory = sslContext.getSocketFactory();

            // Connect to an example server (e.g., www.example.com) on port 443
            try (Socket socket = socketFactory.createSocket("www.example.com", 443)) {
                // Get input and output streams for the socket
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();

                // Send a simple HTTP GET request
                String request = "GET / HTTP/1.1\r\nHost: www.example.com\r\n\r\n";
                outputStream
