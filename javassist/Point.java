package com.example.javassist;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Point {

    void move() {
        Hello hello = new Hello();
        hello.say(1,2);
        System.out.println("zzzzzzzzz");

        try {
            FileInputStream fis = new FileInputStream("TestBean.java");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
