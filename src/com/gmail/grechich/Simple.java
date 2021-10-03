package com.gmail.grechich;


import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@interface Save{}


public class Simple {

    @Save
    private String str;

    @Save
    private int a;

    private int b;

    public Simple() {
    }

    public Simple(String str, int a, int b) {
        this.str = str;
        this.a = a;
        this.b = b;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void settings (){
        System.out.println(a);
    }
}
