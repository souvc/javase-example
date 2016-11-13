package com.souvc.lang;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;

public class StringFormat {

    /*
    String.format()用法

    1、转换符
    %s: 字符串类型，如："ljq"
    %b: 布尔类型，如：true
    %d: 整数类型(十进制)，如：99
    %f: 浮点类型，如：99.99
    %%: 百分比类型，如：％
    %n: 换行符
     */
    @Test
    public void test1() {
        String str = null;
        str = String.format("Hi, %s", "林计钦"); // 格式化字符串
        System.out.println(str); // 输出字符串变量str的内容
        System.out.printf("3>7的结果是：%b %n", 3 > 7);
        System.out.printf("100的一半是：%d %n", 100 / 2);
        System.out.printf("50元的书打8.5折扣是：%f 元%n", 50 * 0.85);
        System.out.printf("上面的折扣是%d%% %n", 85);
    }

    /*
    2、常见日期时间格式化
    c: 包括全部日期和时间信息 星期六 十月 27 14:21:20 CST 2007
    F: "年-月-日"格式，如：2007-10-27
    D: "月/日/年"格式，如：10/27/07
    r: "HH:MM:SS PM"格式(12时制)，如：02:25:51 下午
    T: "HH:MM:SS"格式(24时制)，如：14:28:16
    R: "HH:MM"格式(24时制)，如：14:28
     */
    @Test
    public void test2() {
        Date date = new Date(); // 创建日期对象
        System.out.printf("全部日期和时间信息：%tc%n", date);//格式化输出日期或时间
        System.out.printf("年-月-日格式：%tF%n", date);
        System.out.printf("月/日/年格式：%tD%n", date);
        System.out.printf("HH:MM:SS PM格式(12时制)：%tr%n", date);
        System.out.printf("HH:MM:SS格式(24时制)：%tT%n", date);
        System.out.printf("HH:MM格式(24时制)：%tR%n", date);
    }

    /*
    3、格式化日期字符串
    b或者h: 月份简称，如
    中：十月
    英：Oct

    B: 月份全称，如
    中：十月
    英：October

    a: 星期的简称，如
    中：星期六
    英：Sat

    A: 星期的全称，如：
    中：星期六
    英：Saturday

    C: 年的前两位数字(不足两位前面补0)，如：20
    y: 年的后两位数字(不足两位前面补0)，如：07
    Y: 4位数字的年份(不足4位前面补0)，如：2007
    j: 一年中的天数(即年的第几天)，如：300
    m: 两位数字的月份(不足两位前面补0)，如：10
    d: 两位数字的日(不足两位前面补0)，如：27
    e: 月份的日(前面不补0)，如：5
     */
    @Test
    public void test3() {
        Date date = new Date();                                                                             // 创建日期对象
        String str = String.format(Locale.US, "英文月份简称：%tb", date);      // 格式化日期字符串
        System.out.println(str);                                                                              // 输出字符串内容
        System.out.printf("本地月份简称：%tb%n", date);
        str = String.format(Locale.US, "英文月份全称：%tB", date);
        System.out.println(str);
        System.out.printf("本地月份全称：%tB%n", date);
        str = String.format(Locale.US, "英文星期的简称：%ta", date);
        System.out.println(str);
        System.out.printf("本地星期的简称：%tA%n", date);
        System.out.printf("年的前两位数字(不足两位前面补0)：%tC%n", date);
        System.out.printf("年的后两位数字(不足两位前面补0)：%ty%n", date);
        System.out.printf("一年中的天数(即年的第几天)：%tj%n", date);
        System.out.printf("两位数字的月份(不足两位前面补0)：%tm%n", date);
        System.out.printf("两位数字的日(不足两位前面补0)：%td%n", date);
        System.out.printf("月份的日(前面不补0)：%te", date);
    }

    /*
    4、格式化时间字符串
    h: 2位数字24时制的小时(不足2位前面补0)，如：15
    i: 2位数字12时制的小时(不足2位前面补0)，如：03
    k: 2位数字24时制的小时(前面不补0)，如：15
    l: 2位数字12时制的小时(前面不补0)，如：3
    m: 2位数字的分钟(不足2位前面补0)，如：03
    s: 2位数字的秒(不足2位前面补0)，如：09
    l: 3位数字的毫秒(不足3位前面补0)，如：015
    n: 9位数字的毫秒数(不足9位前面补0)，如：562000000

    p: 小写字母的上午或下午标记，如：
    中：下午
    英：pm

    z: 相对于gmt的rfc822时区的偏移量，如：+0800
    z: 时区缩写字符串，如：cst
    s: 1970-1-1 00:00:00 到现在所经过的秒数，如：1193468128
    q: 1970-1-1 00:00:00 到现在所经过的毫秒数，如：1193468128984

     */
    @Test
    public void test4() {
        Date date = new Date();                               // 创建日期对象
        System.out.printf("2位数字24时制的小时(不足2位前面补0):%tH%n", date);
        System.out.printf("2位数字12时制的小时(不足2位前面补0):%tI%n", date);
        System.out.printf("2位数字24时制的小时(前面不补0):%tk%n", date);
        System.out.printf("2位数字12时制的小时(前面不补0):%tl%n", date);
        System.out.printf("2位数字的分钟(不足2位前面补0):%tM%n", date);
        System.out.printf("2位数字的秒(不足2位前面补0):%tS%n", date);
        System.out.printf("3位数字的毫秒(不足3位前面补0):%tL%n", date);
        System.out.printf("9位数字的毫秒数(不足9位前面补0):%tN%n", date);
        String str = String.format(Locale.US, "小写字母的上午或下午标记(英)：%tp", date);
        System.out.println(str);                          // 输出字符串变量str的内容
        System.out.printf("小写字母的上午或下午标记(中)：%tp%n", date);
        System.out.printf("相对于GMT的RFC822时区的偏移量:%tz%n", date);
        System.out.printf("时区缩写字符串:%tZ%n", date);
        System.out.printf("1970-1-1 00:00:00 到现在所经过的秒数：%ts%n", date);
        System.out.printf("1970-1-1 00:00:00 到现在所经过的毫秒数：%tQ%n", date);
    }


    /**
     * 处理浮点型数据 应用范围float、Float、double、Double 和 BigDecimal
     *  %[argument_index$][flags][width][.precision]conversion
     *   %[index$][标识][最小宽度][保留精度]转换方式
     *      标识：
     *          '-'    在最小宽度内左对齐，不可以与“用0填充”同时使用
     *          '+'    结果总是包括一个符号
     *          '  '    正值前加空格，负值前加负号
     *          '0'    结果将用零来填充
     *          ','    每3位数字之间用“，”分隔（只适用于fgG的转换）
     *          '('    若参数是负数，则结果中不添加负号而是用圆括号把数字括起来（只适用于eEfgG的转换）
     *      最小宽度: 最终该整数转化的字符串最少包含多少位数字
     *      保留精度：保留小数位后面个数
     *      转换方式：
     *          'e', 'E'  --  结果被格式化为用计算机科学记数法表示的十进制数
     *          'f'       --  结果被格式化为十进制普通表示方式
     *          'g', 'G'  --  根据具体情况，自动选择用普通表示方式还是科学计数法方式
     *          'a', 'A'  --  结果被格式化为带有效位数和指数的十六进制浮点数
     *
     */
    @Test
    public  void formatFloat() {
        System.out.println(String.format("%1$e", 1234567890.123456789));//转换为科学记数法表示
        System.out.println(String.format("%1$020e", 1234567890.123456789));//转换为科学记数法表示,长度为20,用0填充
        System.out.println(String.format("%1$g", 12345.123456789));//根据结果制动识别使用转换器e或f
        System.out.println(String.format("%1$a", 12345.123456789));//转换为16进制的浮点数
        System.out.println(String.format("%1$,f", 1234567890.123456789));//转换结果保留默认小数位，3位数字用,隔开，转换为十进制表示
        System.out.println(String.format("%1$,f", 1234567890.123456789));//转换结果保留默认小数位，3位数字用,隔开
        System.out.println(String.format("%1$.10f", 1234567890.123456789));//转换结果是保留10位精度.转换成十进制表示方式
        System.out.println(String.format("%1$,.100f", new BigDecimal("12345678909.1234567890123456789")));//转换结果是保留100位精度,没有精度丢失,整数位3个就用,隔开
        System.out.println(String.format("%1$,.5f", 1234567890.123456789));//转换结果保留5位小数，3位数字用,隔开
    }


    /**
     * 处理整数型数据 应用范围 byte、Byte、short、Short、int、Integer、long、Long 和 BigInteger
     *
     * %[argument_index$][flags][width]conversion
     *  %[index$][标识][最小宽度]转换方式
     *     标识：
     *          '-'    在最小宽度内左对齐，不可以与“用0填充”同时使用
     *          '#'   只适用于8进制和16进制，8进制时在结果前面增加一个0，16进制时在结果前面增加0x
     *          '+'   结果总是包括一个符号（一般情况下只适用于10进制，若对象为BigInteger才可以用于8进制和16进制）
     *          '  '  正值前加空格，负值前加负号（一般情况下只适用于10进制，若对象为BigInteger才可以用于8进制和16进制）
     *          '0'   结果将用零来填充
     *          ','   只适用于10进制，每3位数字之间用“,”分隔
     *          '('   若参数是负数，则结果中不添加负号而是用圆括号把数字括起来（同‘+’具有同样的限制）
     *     最小宽度: 最终该整数转化的字符串最少包含多少位数字
     *     转换方式：d-十进制   o-八进制   x或X-十六进制
     */
    @Test
    public  void formatNumber() {
        System.out.println(String.format("%1$d", -31)); //格式化成数值表示使用十进制，结果"-31"
        System.out.println(String.format("%1$o", -31)); //格式化成数值表示使用八进制，结果"37777777741"
        System.out.println(String.format("%1$19d", -31));//格式化成数值表示使用十进制，总长度显示19位结果"                -31"
        System.out.println(String.format("%1$-19d", -31));//格式化成数值表示使用十进制，总长度显示19位,左靠齐结果"-31                "
        System.out.println(String.format("%1$09d", -31));//格式化成数值表示,使用十进制，结果"-00000031"
        System.out.println(String.format("%1$,9d", -3123));//每3位数字用,隔开,总长度9位，结果"   -3,123"
        System.out.println(String.format("%1$,09d", -3123));//每3位数字用,隔开,用0填充总长度9位，结果"-0003,123"
        System.out.println(String.format("%1$(9d", -3123));//每3位数字用,用0填充总长度9位，结果"     (3123)"
        System.out.println(String.format("%1$ 9d", -31));
    }


    /**
     * 处理字符型数据
     *  对字符进行格式化是非常简单的，c C表示字符，标识中'-'表示左对齐，其他就没什么了
     */
    @Test
    public  void formatChar() {
        System.out.println(String.format("%1$c", 97));//转换为字符
        System.out.println(String.format("%1$10c", '鄒'));//转换为字符,十位
        System.out.println(String.format("%1$-10c", '鸿'));//转换为字符，十位，靠左
    }

    /**
     * 格式化百分比.%特殊字符。转义格式为 %%而不是  */
    @Test
    public  void formatBaiFenBi() {
        System.out.println(String.format("%1$f%%", 12.123456));
        System.out.println(String.format("%1$.4f%%", 12.123456));//留取4位小数,4舍5入
        BigDecimal a = new BigDecimal("12.12"),b = new BigDecimal("13.13");
        BigDecimal c = a.divide(b,28,BigDecimal.ROUND_HALF_UP);//保留28位小数
        System.out.println(c + "");
        System.out.println(String.format("%1$.28f", c));//格式为保留28位小数
    }

    /**
     * 格式化日期 (可用范围long,Long,Calendar,java.util.Date)
     * %[index$][标识][最小宽度]转换方式
     *   标识：
     *      日期和时间转换字符的前缀 t或者T
     *   转换方式：
     *      格式化日期转换字符
     *          'B'  特定于语言环境的月份全称，例如 "January" 和 "February"。
     *          'b'  特定于语言环境的月份简称，例如 "Jan" 和 "Feb"。
     *          'h'  与 'b' 相同。
     *          'A'  特定于语言环境的星期几全称，例如 "Sunday" 和 "Monday"
     *          'a'  特定于语言环境的星期几简称，例如 "Sun" 和 "Mon"
     *          'C'  除以 100 的四位数表示的年份，被格式化为必要时带前导零的两位数，即 00 - 99
     *          'Y'  年份，被格式化为必要时带前导零的四位数（至少），例如，0092 等于格里高利历的 92 CE。
     *          'y'  年份的最后两位数，被格式化为必要时带前导零的两位数，即 00 - 99。
     *          'j'  一年中的天数，被格式化为必要时带前导零的三位数，例如，对于格里高利历是 001 - 366。
     *          'm'  月份，被格式化为必要时带前导零的两位数，即 01 - 13。
     *          'd'  一个月中的天数，被格式化为必要时带前导零两位数，即 01 - 31
     *          'e'  一个月中的天数，被格式化为两位数，即 1 - 31。
     *
     *      格式化时间字符
     *          'H'  24 小时制的小时，被格式化为必要时带前导零的两位数，即 00 - 23。
     *          'I'  12 小时制的小时，被格式化为必要时带前导零的两位数，即 01 - 12。
     *          'k'  24 小时制的小时，即 0 - 23。
     *          'l'  12 小时制的小时，即 1 - 12。
     *          'M'  小时中的分钟，被格式化为必要时带前导零的两位数，即 00 - 59。
     *          'S'  分钟中的秒，被格式化为必要时带前导零的两位数，即 00 - 60 （"60" 是支持闰秒所需的一个特殊值）。
     *          'L'  秒中的毫秒，被格式化为必要时带前导零的三位数，即 000 - 999。
     *          'N'  秒中的毫微秒，被格式化为必要时带前导零的九位数，即 000000000 - 999999999。
     *          'p'  特定于语言环境的 上午或下午 标记以小写形式表示，例如 "am" 或 "pm"。使用转换前缀 'T' 可以强行将此输出转换为大写形式。
     *          'z'  相对于 GMT 的 RFC 822 格式的数字时区偏移量，例如 -0800。
     *          'Z'  表示时区缩写形式的字符串。Formatter 的语言环境将取代参数的语言环境（如果有）。
     *          's'  自协调世界时 (UTC) 1970 年 1 月 1 日 00:00:00 至现在所经过的秒数，即 Long.MIN_VALUE/1000 与 Long.MAX_VALUE/1000 之间的差值。
     *          'Q'  自协调世界时 (UTC) 1970 年 1 月 1 日 00:00:00 至现在所经过的毫秒数，即 Long.MIN_VALUE 与 Long.MAX_VALUE 之间的差值
     *      格式化时间组合字符
     *          'R'  24 小时制的时间，被格式化为 "%tH:%tM"
     *          'T'  24 小时制的时间，被格式化为 "%tH:%tM:%tS"。
     *          'r'  12 小时制的时间，被格式化为 "%tI:%tM:%tS %Tp"。上午或下午标记 ('%Tp') 的位置可能与语言环境有关。
     *          'D'  日期，被格式化为 "%tm/%td/%ty"。
     *          'F'  ISO 8601 格式的完整日期，被格式化为 "%tY-%tm-%td"。
     *          'c'  日期和时间，被格式化为 "%ta %tb %td %tT %tZ %tY"，例如 "Sun Jul 20 16:17:00 EDT 1969"。
     *
     */

    @Test
    public  void formatDate() {
        long c = System.currentTimeMillis();
        System.out.println(String.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", c));
        System.out.println(String.format("%1$ty-%1$tm-%1$td %1$tI:%1$tM:%1$tS %1$tp %1$tb %1$ta", c));
        System.out.println(String.format("%1$tF %1$tT", 1244943575031l));
    }

    /**
     * 规转换可应用于任何参数类型
     *      'b或B'  '\u0062'  将生成 "true" 或 "false"， 如果参数为 null，则结果为 "false"。如果参数是一个 boolean 值或 Boolean，那么结果是由 String.valueOf() 返回的字符串。否则结果为 "true"。
     *      'h或H'  '\u0068'  生成一个表示对象的哈希码值的字符串。  如果参数 arg 为 null，则结果为 "null"。否则，结果为调用 Integer.toHexString(arg.hashCode()) 得到的结果。
     *      's或S'  '\u0073'  生成一个字符串。 如果参数为 null，则结果为 "null"。如果参数实现了 Formattable，则调用其 formatTo 方法。否则，结果为调用参数的 toString() 方法得到的结果。
     */
    @Test
    public  void formatAny() {
        System.out.println(String.format("%b %b %b %b", null,"","true",true));
        String pattern = "%1$s 在 %4$tF %4$tT 说了 \"%1$s 爱 %2$s %3$d 年\"";
        System.out.println(String.format(pattern, "mingming","shuilian",10000,System.currentTimeMillis()));
    }


    /**
     * 获取独立平台行分隔符
     */
    @Test
    public  void getSeparator() {
        System.out.println(String.format("%n"));
        System.out.println( System.getProperty("line.separator"));
    }

}