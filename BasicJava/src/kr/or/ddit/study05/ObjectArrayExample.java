package kr.or.ddit.study05;

import java.util.Scanner;// ctrl shift o

public class ObjectArrayExample {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ObjectArrayExample obj = new ObjectArrayExample();
		obj.method1();
	}

	private void method1() {
		Book book = new Book(); //배열은 같은 값만을 선언할수있음(단점)
		book.price = 1000;		// book이란 타입이라고봄 (int 같은)
		book.title = "자바";
		book.writer = "신용권";
		System.out.println(book);
		
		Book book2 = new Book(); //배열은 같은 값만을 선언할수있음(단점)
		book2.price = 1100;
		book2.title = "파이썬";
		book2.writer = "양형운";
		System.out.println(book2);
		System.out.println();
		
		Book [] arr = new Book [2];//
		arr[0] = book;
		arr[1] = book2;
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		
	}
}
//class (변수와 메소드로 이뤄져있음 ,변수는 값을 조정하는것)
class Book{						//class는 여러 다양한 값을 선언할수있음
	String title;
	String writer;
	int price;
	@Override // alt+shirt+s->tostring->inherit빼고전체선택 후 생성
	public String toString() {
		return "Book [title=" + title + ", writer=" + writer + ", price=" + price + "]";
	}
	
	
}

