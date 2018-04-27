package com.souvc.lang;

import org.junit.Test;

/**
 * 考虑到字符串拼接，想了几种方法，但对性能未知，于是用Junit写了个单元测试。
 */
public class TestString {


    /**
     * 测试通过 “+” 来直接拼接
     */
    @Test
    public void testPlus() {
        String s = "";
        long ts = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            s = s + String.valueOf(i);
        }
        long te = System.currentTimeMillis();
        System.out.print("直接拼接需要时间为：");//大概 直接拼接需要时间为：798
        System.out.println(te-ts);
    }

    /**
     * 测试通过 api 的concat来拼接字符串
     */
    @Test
    public void testConcat() {
        String s = "";
        long ts = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            s = s.concat(String.valueOf(i));
        }
        long te = System.currentTimeMillis();
        System.out.print("concat拼接需要时间为：");//大概 concat拼接需要时间为：230
        System.out.println(te-ts);
    }

    /**
     * 通过StringBuffer 来进行拼接字符串
     */
    @Test
    public void testStringBuffer() {
        StringBuffer sb = new StringBuffer();
        long ts = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            sb.append(String.valueOf(i));
        }
        sb.toString();
        long te = System.currentTimeMillis();
        System.out.print("StringBuffer拼接需要时间为：");//大概 StringBuffer拼接需要时间为：6
        System.out.println(te-ts);
    }

    /**
     * StringBuilder 来进行拼接字符串
     */
    @Test
    public void testStringBuilder() {
        StringBuilder sb = new StringBuilder();
        long ts = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            sb.append(String.valueOf(i));
        }
        sb.toString();
        long te = System.currentTimeMillis();
        System.out.print("StringBuilder拼接需要时间为：");//大概 StringBuilder拼接需要时间为：6
        System.out.println(te-ts);
    }



   /* @Test
    public void testJoin() {
        List<String> list = new ArrayList<String>();
        long ts = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            list.add(String.valueOf(i));
        }
        StringUtils.join(list, "");
        long te = System.currentTimeMillis();
        System.out.print("StringUtils join 拼接需要时间为：");
        System.out.println(te-ts);
    }*/



}