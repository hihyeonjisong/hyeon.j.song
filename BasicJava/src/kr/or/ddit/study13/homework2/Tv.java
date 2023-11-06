package kr.or.ddit.study13.homework2;

import java.util.ArrayList;

public class Tv {
	/*문제 2 – main 메서드에서 실행시켰을 때 제조사, 생산년도, 크기를 출력하는 Tv클래스를 생성하시오.
		(타입,크기 알아서)
	*/
	String maker;
	int year;
	int size;
	

	public Tv (String maker, int year, int size) {
		this.maker=maker;
		this.year=year;
		this.size=size;
		
	}
	
	
	@Override
	public String toString() {
		return "Tv [maker=" + maker + ", year=" + year + ", size=" + size + "]";
	}
	
	
	
	public static void main(String[] args) {
		Tv t_1 =new Tv("삼성",2023,55);
		Tv t_2 =new Tv("엘지",2022,65);
		System.out.println(t_1);
		System.out.println(t_2);
		
		
		
		
		
		
	}
}
