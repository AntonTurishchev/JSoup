package com.example.tesparser1.controller;

import com.example.tesparser1.testPackage1.Class1;
import com.example.tesparser1.testPackage2.Class2;

public class Calc {

    public int calculation () {
        Class1 first = new Class1();
        Class2 second = new Class2();

        return first.getX()+ second.getY();
    }
}
