package com.souvc.io;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * FileOutputStream
 */
public class FileOutputStreamTest {

    @Test
    public  void  fileOutputStream() throws IOException {
        //创建两个文件,face.gif是已经存在文件,newFace.gif是新创建的文件
        File inFile = new File("d:/abcd/event.txt");
        File outFile = new File("d:/abcd/event2.txt");

         //创建流文件读入与写出类
        FileInputStream inStream = new FileInputStream(inFile);
        byte[] inOutb = new byte[inStream.available()]; //通过available方法取得流的最大字符数
        inStream.read(inOutb);  //读入流,保存在byte数组

        FileOutputStream outStream = new FileOutputStream(outFile);
        outStream.write(inOutb);  //写出流,保存在文件newFace.gif中

        inStream.close();
        outStream.close();
    }
}
