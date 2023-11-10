package kr.or.ddit.study11;

import java.util.Date;

public class StringBufferTest {
	public static void main(String[] args) {
		Date d1 = new Date();
		stringTest();
		stringBufferTest();
		Date d2 = new Date();
		long time = (d2.getTime()-d1.getTime());
		System.out.println(time);
	}
	
	public static void stringTest() {
		String str = "";
		for (int i = 0; i < 100000; i++) {
			str +="a";
		}
	}
	//문자열 더할땐 stringBufferTest사용하시오
	public static void stringBufferTest() {
		StringBufferTest sb = new StringBufferTest();
		for (int i = 0; i < 100000; i++) {
			sb.append("a/n");
		}
		String str = sb.toString();
		System.out.println(str);
	}
}
