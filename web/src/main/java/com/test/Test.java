/**
 * 
 */
package com.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lz
 *
 */
public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/test/context.xml");
        A a = (A) ctx.getBean("a");
        
        B b = (B) ctx.getBean("b");

        System.out.println(a);
        System.out.println(b);
    }
}