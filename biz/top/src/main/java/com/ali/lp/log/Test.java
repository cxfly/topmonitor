package com.ali.lp.log;

public class Test {
    public static void main(String[] args) {
        // 入队
        ApiInvokeLogQueue.getInstance().push(null); 
        // 出队
        Object obj = ApiInvokeLogQueue.getInstance().poll();
        System.out.println(obj);
    }
}
