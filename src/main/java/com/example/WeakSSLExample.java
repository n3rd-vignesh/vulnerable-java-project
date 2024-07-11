package com.example;

import javax.net.ssl.*;
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
                outputStream.write(request.getBytes());

                // Read the response
                byte[] response = new byte[4096];
                int bytesRead = inputStream.read(response);
                System.out.println(new String(response, 0, bytesRead));
            }
        } catch (NoSuchAlgorithmException | KeyManagementException | IOException e) {
            e.printStackTrace();
        }
    }

    // Insecure TrustManager that accepts any certificate
    static class InsecureTrustManager implements X509TrustManager {
        @Override
        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) {
        }

        @Override
        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) {
        }

        @Override
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }
}
