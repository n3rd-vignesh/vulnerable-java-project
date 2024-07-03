package com.example;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

public class InsecureDeserializationExample {
    public void run(byte[] serializedData) {
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(serializedData);
            ObjectInputStream ois = new ObjectInputStream(bis);
            Object obj = ois.readObject();
            System.out.println("Deserialized object: " + obj);
            ois.close();
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
