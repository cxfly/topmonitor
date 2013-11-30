package com.alibaba.lp;



public class ThreadTest extends Thread {
    
    public ThreadTest() {
    }
    /** *//**
     * 线程的run方法，它将和其他线程同时运行
     */
    @Override
    public void run(){
        for(int i = 1; i <= 10; i++){
            System.out.println(i);
            try{
                Thread.sleep(100);
                
            } catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
        System.out.println("exit run");
    }
    public static void main(String [] args){
        ThreadTest test = new ThreadTest();
        // 如果不设置daemon，那么线程将输出100后才结束
        test.setDaemon(true);
        test.start();
        System.out.println("isDaemon = " + test.isDaemon());
    }
}       
