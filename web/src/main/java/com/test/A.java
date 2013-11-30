package com.test;

public class A {
    private B b;
    
    public A() {
        System.out.println("construct aa");
    }

    public A(B b) {
        super();
        this.b = b;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        System.out.println("setB");
        this.b = b;
    }
}
