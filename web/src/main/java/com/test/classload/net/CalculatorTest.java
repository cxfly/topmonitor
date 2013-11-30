package com.test.classload.net;

public class CalculatorTest {

    public static void main(String[] args) {
        String url = "http://localhost:8080/examples/class/";
        NetworkClassLoader ncl = new NetworkClassLoader(url);
        String basicClassName = "com.test.classload.net.impl.CalculatorBasic";
        String advancedClassName = "com.test.classload.net.impl.CalculatorAdvanced";
        try {
            Class<?> clazz = ncl.loadClass(basicClassName);
            ICalculator calculator = (ICalculator) clazz.newInstance();
            System.out.println(calculator.getVersion());
            clazz = ncl.loadClass(advancedClassName);
//            Class<?>  clazzdd = ncl.loadClass("com.test.classload.net.impl.CalculatorAdvanced2");
            Thread.currentThread().setContextClassLoader(ncl);
            calculator = (ICalculator) clazz.newInstance();
            System.out.println(calculator.getVersion());
            print(calculator);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void print(Object obj) throws ClassNotFoundException {
        Class.forName("com.test.classload.net.impl.CalculatorAdvanced", false,  Thread.currentThread().getContextClassLoader());

        ClassLoader classLoader = obj.getClass().getClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent());
    }

}
