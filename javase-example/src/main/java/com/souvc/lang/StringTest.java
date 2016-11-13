package com.souvc.lang;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.nio.DoubleBuffer;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.Locale;

/**
 * String 类代表字符串。Java 程序中的所有字符串字面值（如 "abc" ）都作为此类的实例实现。
 * 字符串是常量；它们的值在创建之后不能更改。字符串缓冲区支持可变的字符串。因为 String 对象是不可变的，所以可以共享。
 * 例如：
 * String str = "abc";
 * 等效于：
 * char data[] = {'a', 'b', 'c'};
 * String str = new String(data);
 */
public class StringTest {

    /**
     * charAt方法——提取指定字符
     * <p>
     * 返回指定索引处的 char 值。索引范围为从 0 到 length() - 1。序列的第一个 char 值位于索引 0 处，第二个位于索引 1 处，依此类推，这类似于数组索引。
     */
    @Test
    public void charAt() {
        String str = "I like Java!";
        System.out.print(str.charAt(0));
        System.out.print(str.charAt(10));
    }


    /**
     * codePointAt方法——提取索引字符代码点
     * <p>
     * 返回指定索引处的字符（Unicode 代码点）。索引引用 char 值（Unicode 代码单元），其范围从 0 到 length() - 1。
     * <p>
     * 如果给定索引指定的 char 值属于高代理项范围，则后续索引小于此 String 的长度；如果后续索引处的 char 值属于低代理项范围，
     * 则返回该代理项对相应的增补代码点。否则，返回给定索引处的 char 值。
     */
    @Test
    public void codePointAt() {
        String str = "I like Java!";
        System.out.println(str.charAt(0));
        System.out.println(str.codePointAt(8));
    }


    /**
     * codePointBefore方法——获取索引前一个字符的代码点
     * <p>
     * 返回指定索引之前的字符（Unicode 代码点）。索引引用 char 值（Unicode 代码单元），其范围从 1 到 length。
     * <p>
     * 如果 (index - 1) 处的 char 值属于低代理项范围，则 (index - 2) 为非负；如果 (index - 2) 处的 char 值属于高低理项范围，则返回该代理项对的增补代码点值。
     * 如果 index - 1 处的 char 值是未配对的低（高）代理项，则返回代理项值。
     */
    @Test
    public void codePointBefore() {
        String str = "I like Java!";
        System.out.println(str.charAt(8));
        System.out.println(str.codePointBefore(8));
    }


    /**
     * codePointCount方法——获取指定范围文本代码点数
     */
    @Test
    public void codePointCount() {
        String str = "I like Java!";
        System.out.println(str.charAt(0));
        System.out.println(str.charAt(10));
    }

    /**
     * compareTo方法——比较两个字符串
     * <p>
     * 按字典顺序比较两个字符串。该比较基于字符串中各个字符的 Unicode 值。按字典顺序将此 String 对象表示的字符序列与参数字符串所表示的字符序列进行比较。
     * 1. 如果按字典顺序此 String 对象位于参数字符串之前，则比较结果为一个负整数。
     * 2. 如果按字典顺序此 String 对象位于参数字符串之后，则比较结果为一个正整数。
     * 3. 如果这两个字符串相等，则结果为 0；compareTo 只在方法 equals(Object) 返回 true 时才返回 0。
     * <p>
     * 这是字典排序的定义。如果这两个字符串不同，那么它们要么在某个索引处的字符不同（该索引对二者均为有效索引），要么长度不同，或者同时具备这两种情况。
     * 1. 如果它们在一个或多个索引位置上的字符不同，假设 k 是这类索引的最小值；则在位置 k 上具有较小值的那个字符串（使用 < 运算符确定），其字典顺序在其他字符串之前。
     * 在这种情况下，compareTo 返回这两个字符串在位置 k 处两个char 值的差，即值： this.charAt(k)-anotherString.charAt(k)
     * 2. 如果没有字符不同的索引位置，则较短字符串的字典顺序在较长字符串之前。在这种情况下，compareTo 返回这两个字符串长度的差，即值：this.length()-anotherString.length()
     */
    @Test
    public void compareTo() {
        String str = "I LIKE JAVA!";
        String str2 = "I LIKE PHP!";
        //由于字符串从第6个字符开始，字符P按字典排序在J之后，所以字符串 返回值为 -6
        System.out.println(str.compareTo(str2));
        System.out.println(str2.compareTo(str));

        String str3 = "ILIKEJAVA!";
        String str4 = "ILIKEPHP!";
        //以上结果一样
        System.out.println(str3.compareTo(str4));

        String str5 = "I LIKE JAVA!";
        String str6 = "i LIKE PHP!";
        //本函数区分大小写
        System.out.println(str5.compareTo(str6));


    }


    /**
     * compareToIgnoreCase 方法——忽略大小写比较字符串
     */
    @Test
    public void compareToIgnoreCase() {
        String str = "I LIKE JAVA!";
        String str2 = "i like Java!";
        System.out.println(str.compareToIgnoreCase(str2));
    }


    /**
     * concat 方法——字符串结尾连接
     */
    @Test
    public void concat() {
        String str = "详细的用法请参照：";
        String str2 = "com.souvc.lang.TestString";
        System.out.println(str.concat(str2));


    }


    /**
     * contains 方法——判断是否包含指定字符
     */
    @Test
    public void contains() {
        String str = "I like Java!";
        System.out.println(str.contains("a"));
        System.out.println(str.contains("b"));
    }

    /**
     * copyValueOf 方法——字符数组生成字符串
     */
    @Test
    public void copyValueOf() {
        for (int i = 0; i < 10; i++) {
            System.out.print(String.valueOf(i));
        }
    }


    /**
     * endsWith 方法——判断后缀字符串
     */
    @Test
    public void endsWith() {
        String str = "I like Java!";
        System.out.println(str.endsWith("a"));
        System.out.println(str.endsWith("!"));
    }


    /**
     * equals方法——判断字符串相等
     */
    @Test
    public void equals() {
        String str = "I like Java!";
        String str2 = "I like Java!";
        System.out.println(str.equals(str2));

        String str3 = "I like Java!";
        String str4 = "I like Java !";

        System.out.println(str3.equals(str4));

    }


    /**
     * equalsIgnoreCase方法——忽略大小写判断字符串相等
     */
    @Test
    public void equalsIgnoreCase() {
        String str = "I like Java!";
        String str2 = "I LIKE JAVA!";
        System.out.print(str.equalsIgnoreCase(str2));
    }


    /**
     * format方法——格式化字符串
     **/
    @Test
    public  void format(){
        System.out.print(String.format("详细用法请参照:%s","com.souvc.lang.StringTest"));
    }


    /**
     * getBytes方法——获取字符串的字节数组
     */
    @Test
    public void getBytes() {
        String str = "I like Java!";
        byte [] test=str.getBytes();
        for (int i=0;i<test.length;i++ ) {
            System.out.print(""+test[i]+",");
        }
        System.out.print("\n");

        String str2 = "I like PHP !";
        byte [] test2=str2.getBytes(Charset.defaultCharset());
        for (int j=0;j<test2.length;j++ ) {
            System.out.print(""+test2[j]+",");
        }

        System.out.print("\n");

        try {
            byte [] test3=str2.getBytes("GBK");
            for (int j=0;j<test2.length;j++ ) {
                System.out.print(""+test2[j]+",");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        // string with numbers and some special characters
        String str4 = "!$0123@";

        // byte array with charset
        byte bval[] = new byte[0];
        try {
            bval = str4.getBytes("UTF8");
            // prints the byte array
            for (int i = 0; i < bval.length; i++) {
                System.out.println(bval[i]);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }



    }


    /**
     * getChars方法——获取字符数组
     */
    @Test
    public void getChars() {
        String str = "Website:www.souvc.com";
        System.out.println(str);
        System.out.println(str.length());
        char[] chararr = new char[30];
        // getChars(int srcBegin, int srcEnd, char dst[], int dstBegin)
        str.getChars(8, 21, chararr, 0);
        System.out.print("Value of character array : ");
        System.out.println(chararr);
    }

    /**
     * hashCode方法——生成字符串哈希表
     */
    @Test
    public void hashCode1() {
        Integer i = new Integer(50);
        Long l = new Long(50);
        Float f = new Float(50);
        Integer i2 = new Integer(0);

        // hash codes of different objects with same value are always same
        System.out.println("Hash code of " + i + " is =  " + i.hashCode());
        System.out.println("Hash code of " + l + " is =  " + l.hashCode());

        // hash code for float value i.e different from Integer and Long
        System.out.println("Hash code of " + f + " is =  " + f.hashCode());

        // hash code value of number zero(0) is zero(0)
        System.out.println("Hash code of " + i2 + " is = " + i2.hashCode());

        String str = "this is souvc";

        // hash code of string str
        System.out.println("Hash code of string is = " + str.hashCode());
    }


    /**
     * indexOf方法——获取字符第一个索引
     */
    @Test
    public void indexOf() {
        String str = "This is souvc,this is a blog website!";
        System.out.println("index of letter 's' = " + str.indexOf('s'));
        System.out.println("index of letter 'e' = " + str.indexOf('e'));


        System.out.println("index of letter 't' =  " + str.indexOf('t', 14));
        System.out.println("index of letter 's' =  " + str.indexOf('s', 10));
        System.out.println("index of letter 'e' =  " + str.indexOf('e', 5));


        String str1 = "Collections of tutorials at tutorials point";
        System.out.println("index =  " + str1.indexOf("tutorials"));
        System.out.println("index =  " + str1.indexOf("admin"));

        System.out.println("index = " + str1.indexOf("admin", 9));// 9是该指数开始搜索.
    }


    /**
     * intern方法——获取规范化字符串
     */
    @Test
    public void intern() {
        String str1 = "This is TutorialsPoint";
        String str2 = str1.intern();
        System.out.println(str2);
        System.out.println("Is str1 equal to str2 ? = " + (str1 == str2));
    }


    /**
     * isEmpty方法——判断字符串是否为空
     */
    @Test
    public void isEmpty() {
        String str = "souvc";
        System.out.println("length of string = " + str.length());
        System.out.println("is this string empty? = " + str.isEmpty());
    }


    /**
     * lastIndexOf方法——方法返回指数在此字符串中最后一次出现的指定字符
     */
    @Test
    public void lastIndexOf() {
        String str = "This is souvc, I like it !";
        System.out.println("last index of letter 'i' =  " + str.lastIndexOf('i'));
        System.out.println("last index of letter 'e' =  "+ str.lastIndexOf('e'));

        System.out.println("last index of letter 't' =  " + str.lastIndexOf('t', 14));
        System.out.println("last index of letter 's' =  " + str.lastIndexOf('s', 2));
        System.out.println("last index of letter 'e' =  " + str.lastIndexOf('e', 5));
    }

    /**
     * length方法——获取字符串长度
     */
    @Test
    public void length() {
        String str = "tutorials point";
        System.out.println("length of string =  " + str.length());
        System.out.println("is this string empty? = " + str.isEmpty());

        str = "";
        System.out.println("length of string =  " + str.length());
        System.out.println("is this string empty? = " + str.isEmpty());
    }


    /**
     * matches方法——匹配正则表达式
     */
    @Test
    public void matches() {
        String str1 = "tutorials", str2 = "learning";

        boolean retval = str1.matches(str2);
        System.out.println("Value returned = " + retval);

        retval = str2.matches("learning");
        System.out.println("Value returned = " + retval);

        retval = str1.matches("tuts");
        System.out.println("Value returned = " + retval);
    }


    /**
     * offsetByCodePoints方法——获取索引偏移后指定代码点的索引
     */
    @Test
    public void offsetByCodePoints() {
        String str = "aacdefaa";
        System.out.println("string = " + str);

        // returns the index within this String
        int retval = str.offsetByCodePoints(2, 4);
        // prints the index
        System.out.println("index = " + retval);
    }


    /**
     * regionMatches方法——测试两个字符串区域是否相等
     */
    @Test
    public void regionMatches() {
        String str1 = "Collection of tutorials";
        String str2 = "Consists of different tutorials";

        /* matches characters from index 14 in str1 to characters from
        index 22 in str2 considering same case of the letters */
        boolean match1 = str1.regionMatches(14, str2, 22, 9);
        System.out.println("region matched = " + match1);

        /* considering different case, "true" is set which will ignore
        case when matched */
        str2 = "Consists of different Tutorials";
        match1 = str1.regionMatches(true, 14, str2, 22, 9);
        System.out.println("region matched = " + match1);
    }


    /**
     * replace方法——替换字符序列
     */
    @Test
    public void replace() {
        String str = "aacdeaa";
        System.out.println("string = " + str);

        // replace all 'a' characters with 'b' characters.
        String replaceStr = str.replace('a', 'b');

        // prints the strings after replacement
        System.out.println("new string = " + replaceStr);
    }


    /**
     * replaceAll 方法——正则表达式匹配替换所有字符串
     */
    @Test
    public void replaceAll() {
        String str1 = "!!Tutorials!!Point", str2;
        String substr = "**", regex = "!!";

        // prints string1
        System.out.println("String = " + str1);

        /* replaces each substring of this string that matches the given
        regular expression with the given replacement */
        str2 = str1.replaceAll(regex, substr);
        System.out.println("After Replacing = " + str2);
    }


    /**
     * replaceFirst方法——正则表达式替换第一个匹配的字符串
     */
    @Test
    public void replaceFirst() {
        String str1 = "!!Tutorials!!Point", str2;
        String substr = "**", regex = "!!";

        // prints string1
        System.out.println("String = " + str1);

        /* replaces the first substring of this string that matches the given
        regular expression with the given replacement */
        str2 = str1.replaceFirst(regex,substr);
        System.out.println("After Replacing = " + str2);
    }

    /**
     * split方法——字符串分割成数组
     */
    @Test
    public void split() {
        String str = "a d, m, i.n";
        String delimiters = "\\s+|,\\s*|\\.\\s*";

        // analyzing the string
        String[] tokensVal = str.split(delimiters);

        // prints the number of tokens
        System.out.println("Count of tokens = " + tokensVal.length);

        for(String token : tokensVal) {
            System.out.print(token);
        }
    }


    /**
     * startsWith方法——判断前缀字符串
     */
    @Test
    public void startsWith() {
        String str = "www.souvc.com";
        System.out.println(str);

        // the start string to be checked
        String startstr1 = "www";
        String startstr2 = "http://";

        // checks that string starts with given substring
        boolean retval1 = str.startsWith(startstr1);
        boolean retval2 = str.startsWith(startstr2);

        // prints true if the string starts with given substring
        System.out.println("starts with " + startstr1 + " ? " + retval1);
        System.out.println("starts with " + startstr2 + " ? " + retval2);
    }


    /**
     * subSequence方法——获取子字符串序列
     */
    @Test
    public void subSequence() {
        String str = "Tutorials Point!";

        System.out.println("string = " + str);

        // returns the specified subsequence from index 2 to 9
        System.out.println("string subsequence = " + str.subSequence(2,9));
    }


    /**
     * substring方法——获取子字符串
     */
    @Test
    public void substring() {
        String str = "This is tutorials point";
        String substr = "";

        // prints the substring after index 7
        substr = str.substring(7);
        System.out.println("substring = " + substr);

        // prints the substring after index 0 i.e whole string gets printed
        substr = str.substring(0);
        System.out.println("substring = " + substr);


        // prints the substring after index 7 till index 17
        substr = str.substring(7, 17);
        System.out.println("substring = " + substr);

        // prints the substring after index 0 till index 7
        substr = str.substring(0, 7);
        System.out.println("substring = " + substr);

    }


    /**
     * toCharArray方法——字符串变字符数组
     */
    @Test
    public void toCharArray() {
        // converts String value to character array type value
        String str = " Java was developed by James Gosling";
        char retval[] = str.toCharArray();

        // displays the converted value
        System.out.println("Converted value to character array = ");
        System.out.println(retval);
    }


    /**
     * toLowerCase方法——转换成小写字符串
     */
    @Test
    public void toLowerCase() {
        // converts all upper case letters in to lower case letters
        String str1 = "Self Learning Center";
        System.out.println("string value = " + str1.toLowerCase());

        str1 = "www.souvc.com";
        System.out.println("string value = " + str1.toLowerCase());


        // using the default system Locale
        Locale defloc = Locale.getDefault();

        // converts all upper case letters in to lower case letters
        System.out.println("string value = " + str1.toLowerCase(defloc));

        str1 = "WWW.SOUVC.COM";
        System.out.println("string value = " + str1.toLowerCase(defloc));
    }

    /**
     * toUpperCase方法——转换成大写字符串
     */
    @Test
    public void toUpperCase() {
        // converts all lower case letters in to upper case letters
        String str1 = "This is souvc";
        System.out.println("string value = " + str1.toUpperCase());

        str1 = "www.souvc.com";
        System.out.println("string value = " + str1.toUpperCase());
    }

    @Test
    public  void trim(){
        // string with leading and trailing white space
        String str = " This is Souvc ";

        System.out.print("Before trim = ");
        System.out.println(".." + str + "..");

        // leading and trailing white space removed
        System.out.print("After trim = ");
        System.out.println(".." + str.trim() + "..");
    }

    /**
     * valueOf方法——基本数据类型转成字符串
     */
    @Test
    public void valueOf() {
        String str1 = String.valueOf(true);
        String str2 = String.valueOf(false);

        // print the string representation of boolean
        System.out.println(str1);
        System.out.println(str2);

        String str3 = String.valueOf('k');
        String str4 = String.valueOf('m');

        // print the string representation of char
        System.out.println(str3);
        System.out.println(str4);



        // character array chararray1
        char[] chararr1 = new char[] { 't', 'u', 't', 's' };
        String str5 = String.valueOf(chararr1);

        // character array chararray2
        char[] chararr2 = new char[] { '2', '1', '5' };
        String str6 = String.valueOf(chararr2);

        // prints the string representations
        System.out.println(str5);
        System.out.println(str6);

    }

}
