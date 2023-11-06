package kr.or.ddit.study05;

import java.util.Scanner;

public class p_objectArray_231021 {
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		p_objectArray_231021 obj = new p_objectArray_231021();
		obj.method1();
	}
	
	private void method1() {
		Book book = new Book();
		book.price = 1000;
		book.title ="자바";
		book.writer = "신용권";
		System.out.println(book);
		
		Book book2 = new Book();
		book.price = 1100;
		book.title = "파이썬";
		book.writer = "양형운";
		System.out.println(book2);
		System.out.println();
		
		Book[] arr = new Book [2];
		arr[0] = book;
		arr[1] = book2;
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	
	
}

class Book{
	String title;
	String writer;
	int price;
	@Override
	public String toString() {
		return "Book [title=" + title + ", writer=" + writer + ", price=" + price + "]";
	}
	
}