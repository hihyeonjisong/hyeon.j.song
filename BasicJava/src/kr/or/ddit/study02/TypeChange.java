package kr.or.ddit.study02;

public class TypeChange {
	public static void main(String[] args) {
		int i = 10;		
		long l = (long)i; //long이 없어도 실행됨.int가 long보다 작은값이라서 (자동타입변환)
		System.out.println("롱 타입 입니다."+l);
		
		
		long l2 = 1000;
		int i2 = (int)l2;// int로 강제타입변환해야함
		System.out.println("인트 타입입니다."+i2);
		
		// 타입 변환시 범위 밖을 넘기게 되면 문제가 발생하기 때문에
		// 강제 타입 변환을 하도록 유도함.(컴파일 에러)
		long l3 = 1000000000000l;
		int i3 = (int)l3;
		System.out.println("인트 타입입니다"+i3); // int범위 밖이라서:오버플로우
		
		double d4 = 3.412;
		int	   i4 = (int)d4;
		System.out.println(" 더블 -> 인트 변환입니다. "+i4); //실수를 정수로 나타냄
		
		int    i5 = 4;
		double d5 = i5;
		System.out.println(" 인트 -> 더블 변환입니다."+d5);
		
		//*
		char	c6 = 'a';
		int		i6 = c6;
		System.out.println(" char -> 인트 변환입니다."+i6); //a의 아스키값인 97이 나옴
		
		int		i7= 41300;
		char	c7= (char)i7; //int가 범위가 더 커서 
		System.out.println(" int -> char 변환입니다."+c7);
		
	
		int		i8= c6+10; 
		char	c8= (char)i8; //int가 범위가 더 커서 
		System.out.println(" int 숫자값은 "+i8);// int 숫자값은 107
		System.out.println(" int -> char 변환입니다."+c8);
		
		int		i9= c6-32;
		char	c9= (char)i9; //int가 범위가 더 커서 
		System.out.println(" int 숫자값은 "+i9);
		System.out.println(" int -> char 변환입니다."+c9);
	
		
	}

}
