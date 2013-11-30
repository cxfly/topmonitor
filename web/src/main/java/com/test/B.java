package com.test;

public class B {
    private  A a;

    
    public B(A a) {
        super();
        System.out.println("constructB args:, " +a);
        this.a = a;
    }


    public B() {
        super();
        System.out.println("constructB  " );
    }


    public A getA() {
        return a;
    }

    public void setA(A a) {
        System.out.println("setA ");
        this.a = a;
    }
    
}
