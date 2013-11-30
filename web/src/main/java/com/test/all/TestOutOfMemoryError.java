package com.test.all;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class TestOutOfMemoryError {
    public static void main(String[] args) {
        test_createThread();
    }

    /**
     * Runtime Constant Pool in Method Area 内存溢出
     * 
     * <pre>
     * 在运行时产生大量常量就可以实现让 Method Area 溢出的目的。
     * 运行是常量可以用 String 类的 intern 方法，不断地产生新的常量
     * </pre>
     */
    static void testOOM_PermGenspace2() {
        List<String> list = new ArrayList<String>(10000000);
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }

    static class MethodAreaOomObject {
    }

    /**
     * Method Area 内存溢出
     * 
     * <pre>
     * java.lang.OutOfMemoryError: PermGen space
     * 也就是 Non-heap，是用来存储 Object Class Data、常量、静态变量、JIT 编译后的代码等。
     * 如果该区域溢出，则说明某种数据创建的实在是太多了。
     * 模拟的话，可以不断创建新的 class，直到溢出为止
     * </pre>
     */
    static void testOOM_PermGenspace1() {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(MethodAreaOomObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                    return proxy.invoke(obj, args);
                }
            });
            enhancer.create();
        }
    }

    /**
     * Java Method Stack 栈溢出
     * 
     * <pre>
     * java.lang.StackOverflowError
     * 什么时候会让 Java Method Stack 栈溢出啊？
     * 栈的基本特点就是 FILO（First In Last Out），
     * 如果 in 的太多而 out 的太少，就好 overflow 了。
     * 而 Java Method Stack 的功能就是保存每一次函数调用时的“现场”，
     * 即为入栈，函数返回就对应着出栈，所以函数调用的深度越大，栈就变得越大，
     * 足够大的时候就会溢出。所以模拟 Java Method Stack 溢出，
     * 只要不断递归调用某一函数就可以
     * </pre>
     */
    static void testOOM_StackOverflowError() {
        testOOM_StackOverflowError();
    }

    /**
     * Method Area 内存溢出
     * 
     * <pre>
     * java.lang.OutOfMemoryError: Java heap space
     * 堆是用来存储对象的，当然对象不一定都存在堆里（由于逃逸技术的发展）。
     * 那么堆如果溢出了，一定是不能被杀掉的对象太多了。
     * 模拟 Heap 内存溢出，只要不断创建对象并保持有引用存在即可
     * </pre>
     */
    static void testOOM_HeapSpace() {
        List<int[]> list = new ArrayList<int[]>(1000000);
        while (true) {
            list.add(new int[10000 * 1000]);
        }
    }

    /**
     * Method Area 内存溢出
     * 
     * <pre>
     * java.lang.OutOfMemoryError: unable to create new native thread
     * 堆是用来存储对象的，当然对象不一定都存在堆里（由于逃逸技术的发展）。
     * 那么堆如果溢出了，一定是不能被杀掉的对象太多了。
     * 模拟 Heap 内存溢出，只要不断创建对象并保持有引用存在即可
     * </pre>
     */
    static void test_createThread() {

        for (int i = 0; i < 10000; i++) {
            System.out.println(i);
            Thread t1 = new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t1.start();
        }
    }
}
