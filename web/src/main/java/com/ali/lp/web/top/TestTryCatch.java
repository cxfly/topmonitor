package com.ali.lp.web.top;

import java.util.ArrayList;
import java.util.List;
@SuppressWarnings({"rawtypes", "unchecked"})
public class TestTryCatch {
    static int i = 0;
    public static void main(String[] args) {
        List a = new ArrayList();
        
        a.add("dd");
        
        
        
        System.out.println("i的值为。。。" + test(a));
        
        System.out.println(a.size());
    }


    private static int test(List a) {
        i = 1;
        try {
            a.add("22");
            return a.size();
        } finally {
            ++i;
          //  a.clear();
            
            System.out.println("finally is Executed…" + a.size());
            
            a = new ArrayList();
            
            a.add(11);
            a.add(11);
            a.add(11);
            a.add(11);
        }
    }
}
