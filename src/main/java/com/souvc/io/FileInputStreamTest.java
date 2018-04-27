package com.souvc.io;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Java.io.FileInputStream 类从文件系统中的一个文件中获取输入字节。那些文件依赖于主机环境。以下是关于文件输入流的要点：
 * 这个类是指对原始字节诸如图像数据读出流。
 * 对于字符读取流，使用FileReader。
 */
public class FileInputStreamTest {


    /**
     * 这通过打开一个到实际文件，命名在文件系统中的File对象文件的文件的连接创建一个FileInputStream
     */
    @Test
    public  void FileInputStream() throws IOException {
        FileInputStream fis =new FileInputStream(new File("d:/abcd/event.txt"));
        //新建一个字节数组
        byte[] b=new byte[fis.available()];
        fis.read(b);//将文件中的内容读取到字节数组中
        fis.close();
        String str2=new String(b);//再将字节数组中的内容转化成字符串形式输出
       System.out.println(str2);
    }





}
