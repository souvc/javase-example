package com.souvc.io;

import org.junit.Test;

import java.io.File;

/**
 * File
 */
public class FileTest {


    /**
     * 如果该文件可以通过它的抽象名称可执行
     */
    @Test
    public  void canExecute(){
        File f = null;
        String[] strs = {"test.txt", "/test.txt"};
        // for each string in string array
        for(String s:strs )
        {
            // create new file
            f= new File(s);
            // true if the file is executable
            boolean bool = f.canExecute();
            // find the absolute path
            String a = f.getAbsolutePath();
            // prints absolute path
            System.out.print(a);
            // prints
            System.out.println(" is executable: "+ bool);
        }
    }


    /**
     * 测试应用程序是否可以读取表示此抽象路径名的文件。
     */
    @Test
    public  void canRead(){
        File f = null;
        // create new file
        f = new File("d:/event.txt");
        // returns true if the file can be read
        boolean bool = f.canRead();
        // print
        System.out.print("File can be read: "+bool);
    }

}
