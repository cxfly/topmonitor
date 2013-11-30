package com.test.all;

public class TestClassLoader {
    public static void main(String[] args) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println("current loader:" + loader);
        System.out.println("parent loader:" + loader.getParent());
        System.out.println("grandparent loader:" + loader.getParent().getParent());
        
        System.out.println("TestClassLoader: " + TestClassLoader.class.getClassLoader());
    }
    
    public static void printClassLoader() { 
        ClassLoader loader = TestClassLoader.class.getClassLoader(); 
        while (loader != null) { 
            System.out.println(loader.toString()); 
            loader = loader.getParent(); 
        } 
    } 
}
