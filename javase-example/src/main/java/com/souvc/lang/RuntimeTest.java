package com.souvc.lang;

import org.junit.Test;

import java.io.IOException;

/**
 * Runtime类封装了运行时的环境。每个 Java 应用程序都有一个 Runtime 类实例，使应用程序能够与其运行的环境相连接。
 * 一般不能实例化一个Runtime对象，应用程序也不能创建自己的 Runtime 类实例，但可以通过 getRuntime 方法获取当前Runtime运行时对象的引用。
 * 一旦得到了一个当前的Runtime对象的引用，就可以调用Runtime对象的方法去控制Java虚拟机的状态和行为。
 */
public class RuntimeTest {


    /**
     *  返回 Java 虚拟机中的内存总量。
     * @throws IOException
     */
    @Test
    public void totalMemory() throws IOException {
        //getRuntime()返回与当前 Java 应用程序相关的运行时对象。
        Runtime r = Runtime.getRuntime();
        System.out.println(r.totalMemory());
    }

    /**
     * 返回 Java 虚拟机中的空闲内存量。
     * @throws IOException
     */
    @Test
    public void freeMemory() throws IOException {
        Runtime r = Runtime.getRuntime();
        System.out.println(r.freeMemory());
    }


    /**
     * ecec()方法返回一个Process对象，可以使用这个对象控制Java程序与新运行的进程进行交互。ecec()方法本质是依赖于环境。
     * 使用ecec()方法启动windows的记事本notepad。这个例子必须在Windows操作系统上运行。
     */
    @Test
    public void exec(){
        Runtime r = Runtime.getRuntime();
        Process p = null;
        try{
            //  exec(String command) 在单独的进程中执行指定的字符串命令。
            p = r.exec("notepad");
        } catch (Exception e) {
            System.out.println("Error executing notepad.");
        }
    }


    /**
     * ecec()方法返回Process对象后，在新程序开始运行后就可以使用Process的方法了。
     * 可以用destory()方法杀死子进程，也可以使用waitFor()方法等待程序直到子程序结束，
     * exitValue()方法返回子进程结束时返回的值。
     * 如果没有错误，将返回0，否则返回非0。
     */
    @Test
    public void exec2(){
        Runtime r = Runtime.getRuntime();
        Process p = null;
        try{
            p = r.exec("notepad");
            p.waitFor();
        } catch (Exception e) {
            System.out.println("Error executing notepad.");
        }

        //当关闭记事本后，会接着运行程序，打印信息
        System.out.println("Notepad returned " + p.exitValue());
    }




}
