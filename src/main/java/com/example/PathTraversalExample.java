package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class PathTraversalExample {
    public void run() {
        String filename = "../../etc/passwd";

        try {
            File file = new File(filename);
            FileInputStream fis = new FileInputStream(file);
            int content;
            while ((content = fis.read()) != -1) {
                System.out.print((char) content);
            }
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
