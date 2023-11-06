package kr.or.ddit.study11;//많이 사용하는 String method들

import java.io.File;

public class StringLang {
	public static void main(String[] args) {
//		StringLang sl = new StringLang();
//		sl.method1();//toCharArray
//		sl.method2();//.contains
//		sl.method3();//startsWith , endsWith
//		sl.method4();//toUpperCase,toLowerCase
//		sl.method5();//trim
//		sl.method6();//replace:공백 없앨때, 문자바꿀때
//		sl.method7();//if(str==null || str.isEmpty)
//		sl.method8();//.split
	}

	private void method8() {
		String test = "스플릿테스트,"
		            +"test1," //alt + shift +a :여러줄 한번에 입력
		            +"test2," 
		            +"test3,"
		            +"test4,"
		            +"test5,"
		            +"test6,";
		
		String line[] =test.split(",");//내가 원하는 문자 기준으로 split함
		System.out.println(test);
		for(String s : line) {
			System.out.println(s);
		}
		
	}

	private void method7() {
		
		String str = null; //객체자체가 생성되지 않았음. 비어있다는뜻이 아님
		if(str==null || str.isEmpty()) { //if(str.isEmpty())이 메소드는 사용할수 없음.(객체자체생성x라서)
			System.out.println("해당 문자열은 비어있습니다.");//앞의 것이 참이니까 그냥 실행됨(순서 바꾸면 안됌)
		}
		
//		if(strl!=null && !str.isEmpty()) { //비지 않았다면 사용하겠다는뜻
//			
//		}
	}

	private void method6() {
		String test = "가나다가나다가나다";

		System.out.println(test);
		test = test.replace("가", "*");//replace:공백 없앨때, 문자바꿀때
		System.out.println(test);
//		test.replaceAll("정규직", replacement); //replaceAll:한번에 사용가능함

	}

	private void method5() {
		String test = "    공백제거         ";//trim:공백제거해줌
		System.out.println(test);
		test = test.trim();
		System.out.println(test);

	}

	private void method4() { // 많이씀 알아두면 좋음
		String test = "소문자 abcd";
		System.out.println(test);
		test = test.toUpperCase(); //toUpperCase: 대문자로바꿔줌
		System.out.println(test);

		if (test.contains("abcd")) {
			System.out.println("abcd값이 포함되어있습니다.");
		}

		System.out.println("-----------");
		String test1 = "대문자 ABCD";
		System.out.println(test1);

		test1 = test1.toLowerCase();//toLowerCase: 소문자로 바꿔줌
		System.out.println(test1);
	}

	private void method3() {
		String test = "문자열 test 입니다.";
		String start = "문자열"; // startsWith : 해당문자로 시작하는것 찾을때
		if (test.startsWith(start)) {
			System.out.println(start + "로 시작됩니다.");
		}
		String end = "입니다.";
		if (test.endsWith(end)) { // endsWith: 파일 확장자 검사할때 사용함
			System.out.println(end + "로 끝납니다.");
		}

		// 2023으로 시작하는 엑셀 파일 개수를 구해보시오.

		int cnt = 0;

		File dir = new File("원하는 폴더 경로");
		for (String s : dir.list()) {
			if (s.startsWith("2023")) { // 2023으로 시작하고 .xls로 끝나는 엑셀 파일 개수

			} else
				continue; // 2023파일만 들어감
			if (s.endsWith(".xls") || s.endsWith(".xlsx")) { // if 안에 if 문 써도됌
				cnt++;
			}
		}

	}

	public void method2() {
		String test = "문자열 test 입니다.";
		String search = "test";

		if (test.contains(search)) { // .contains: 찾는 문자가 포함되어있는지
			System.out.println(search + "값이 포함되어있습니다.");
		}

		if (test.equals(search)) { 
			System.out.println(search + "값이 동일합니다.");
		}
	}

	private void method1() {
		String test = "문자열 test 입니다.";

		for (int i = 0; i < test.length(); i++) {

			System.out.print(test.charAt(i));
		}
		char ch[] = test.toCharArray(); // toCharArray: 문자열을 char배열로바꿔줌
		for (int i = 0; i < ch.length; i++) {
			char c = ch[i];
			System.out.print(ch[i]);
		}

		/*
		 * 향상된 for문 : 배열이나 리스트에서 사용됨 char c <-하위타입 test.toCharArray() <-배열혹은리스트 for(char
		 * c : test.toCharArray()){
		 * 
		 */
		for (char c : test.toCharArray()) {// char배열 밑에있는것: char
			System.out.print(c);
		}
	}
}
