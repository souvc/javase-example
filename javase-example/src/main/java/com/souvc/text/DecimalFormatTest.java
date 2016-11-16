package com.souvc.text;

import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;

import org.junit.Test;

/**
 * 类名: DecimalFormatTest.java</br> 
 * 包名：  com.souvc.text </br> 
 * 描述: DecimalFormat 是 NumberFormat 的一个具体子类，用于格式化十进制数字。该类设计有各种功能，使其能够解析和格式化任意语言环境中的数，包括对西方语言、阿拉伯语和印度语数字的支持。
 * 它还支持不同类型的数，包括整数 (123)、定点数 (123.4)、科学记数法表示的数 (1.23E4)、百分数 (12%) 和金额 ($123)。所有这些内容都可以本地化。</br> 
 * 发布版本号：V1.0</br>
 * 开发人员：souvc </br>
 * 创建时间： 2016年11月16日</br>
 */
public class DecimalFormatTest {

	
	@Test
	public void format(){
		
		/*
		 符号含义： 

		0 一个数字 

		# 一个数字，不包括 0 

		. 小数的分隔符的占位符 

		, 分组分隔符的占位符 

		; 分隔格式。 

		- 缺省负数前缀。 

		% 乘以 100 和作为百分比显示 

		? 乘以 1000 和作为千进制货币符显示；用货币符号代替；如果双写，用 

		国际货币符号代替。如果出现在一个模式中，用货币十进制分隔符代 

		替十进制分隔符。 

		X 前缀或后缀中使用的任何其它字符，用来引用前缀或后缀中的特殊字符。
	 */
		
		
		//0 一个数字 
		DecimalFormat df1 = new DecimalFormat("0.000"); 

		//. 小数的分隔符的占位符 
		DecimalFormat df2 = new DecimalFormat("#.#"); 

		DecimalFormat df3 = new DecimalFormat("000.000"); 

		//# 一个数字，不包括 0 
		DecimalFormat df4 = new DecimalFormat("###.###"); 

		System.out.println(df1.format(12.34)); 

		System.out.println(df2.format(12.34)); 

		System.out.println(df3.format(12.34)); 

		System.out.println(df4.format(12.34)); 
		
		
		
		
		
		
		  DecimalFormat df=new DecimalFormat("0.00");//保留2位小数
		  double d1=123456789.123456;
		  double d2=11987654321.987654321;
		  
		  System.out.println("format1_d1="+df.format(d1));//输出format1_d1=123456789.12
		  System.out.println("format1_d2="+df.format(d2));//format1_d2=987654321.99  四舍五入
		  
		  DecimalFormat dff = new DecimalFormat("#,##0.00");
		  System.out.println("format2_d1="+dff.format(d1));//输出：format2_d1=123,456,789.12
		  System.out.println("format2_d2="+dff.format(d2));//输出：format2_d2=987,654,321.99 四舍五入
		
		
	}
	
	/**
	 * 1。实例化对象，
	 */
	@Test
	public void format2(){
		DecimalFormat df=(DecimalFormat)NumberFormat.getInstance();
		DecimalFormat df1=(DecimalFormat) DecimalFormat.getInstance();
		System.out.println(df);
		System.out.println(df1);
	}
	
	
	/**
	 * 2。设定小数位数,系统默认小数位数为3
	 */
	@Test
	public void format3(){
		
		DecimalFormat df=(DecimalFormat)NumberFormat.getInstance();
		//系统默认小数位数为3
		System.out.println(df.format(12.3456789));//输出：12.346
		
		//把小数为设为两位：
		df.setMaximumFractionDigits(2);
		System.out.println(df.format(12.3456789));
		
	}
	
	
	/**
	 * 3.将数字转化为百分比输出
	 */
	@Test
	public void format4(){
		
		DecimalFormat df=(DecimalFormat)NumberFormat.getInstance();
		df.applyPattern("#.##%");
		System.out.println(df.format(12.3456789));
		System.out.println(df.format(1));
		System.out.println(df.format(0.015));
		//输出分别为：1234.57% 100% 1.5%
		
		df.setMaximumFractionDigits(2);
		System.out.println(df.format(12.3456789*100)+"%");
		System.out.println(df.format(1*100)+"%");
		System.out.println(df.format(0.015*100)+"%");
		
		//输出分别为：1,234.57% 100% 1.5%
	}
	
	
	/**
	 * 4。设置分组大小
	 */
	@Test
	public void format5(){
		DecimalFormat df1=(DecimalFormat) DecimalFormat.getInstance();
		df1.setGroupingSize(3);
		System.out.println(df1.format(123456789.99955558881));
		
		
		//还可以通过df1.setGroupingUsed(false);来禁用分组设置，如：
		DecimalFormat df2=(DecimalFormat) DecimalFormat.getInstance();
		df2.setGroupingSize(2);
		df2.setGroupingUsed(false);
		System.out.println(df1.format(123456789));
		//输出：123456789
		
	}
	
	
	/**
	 * 5。设置小数为必须为2位
	 */
	@Test
	public void format6(){
		DecimalFormat df2=(DecimalFormat) DecimalFormat.getInstance();
		df2.applyPattern("0.00");
		System.out.println(df2.format(1.2));
	}
	
	
	public void format(Object number,
            StringBuffer toAppendTo,
            FieldPosition pos){
		
	}
}




