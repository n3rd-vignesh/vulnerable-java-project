package com.example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mockito.Mockito;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

public class App {
    public static void main(String[] args) {
        try {
            // Simulate HttpServletRequest and HttpServletResponse using Mockito
            HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
            HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
            
            // XSS Example
            Mockito.when(request.getParameter("input")).thenReturn("<script>alert('xss');</script>");
            XSSExample xssExample = new XSSExample();
            xssExample.run(request, response);
            
            // Open Redirect Example
            Mockito.when(request.getParameter("url")).thenReturn("http://malicious.com");
            OpenRedirectExample openRedirectExample = new OpenRedirectExample();
            openRedirectExample.run(request, response);
            
            // Insecure Deserialization Example
            byte[] serializedData = serializeObject("test");
            InsecureDeserializationExample insecureDeserializationExample = new InsecureDeserializationExample();
            insecureDeserializationExample.run(serializedData);
            
            // LDAP Injection Example
            LDAPInjectionExample ldapInjectionExample = new LDAPInjectionExample();
            ldapInjectionExample.run("admin)(|(objectClass=*))");
            
            // SSRF Example
            SSRFExample ssrfExample = new SSRFExample();
            ssrfExample.run();

            MissingAuthenticationExample missingAuthExample = new MissingAuthenticationExample();
            missingAuthExample.main(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static byte[] serializeObject(Object obj) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bos);
        out.writeObject(obj);
        out.flush();
        return bos.toByteArray();
    }
}
