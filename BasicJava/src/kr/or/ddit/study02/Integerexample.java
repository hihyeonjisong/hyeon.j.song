package kr.or.ddit.study02;

public class Integerexample {
	public static void main(String[]args ) {
	    //정수형
		// 1 byte	: 1byte (-128~127) 가장 기본!
		// 2 short	: 2byte (-32768~32767)
		// 3 int	: 4byte 			많이 사용!
		// 4 long	: 8byte
		
		byte b1 = 127;
		System.out.println("b1 = "+ b1);
		
	//	byte b2 = 128;	컴파일에러: 범위 밖이라서
		
		short s1 = 128;
		System.out.println("s1 = "+ s1);//128은 byte 범위 밖이라서 short사용
		
	//*	short s2 = s1+ 10; //에러:숫자를 사용하면 int로 인식함! 작은것에 큰것을 넣으려한다고 생각해서
		short s2 = (short)(s1+ 10); //타입변환
		
		int var1 =200;	//10진수
		int var2 = 0203;//8진수	8진수는 앞에 0을 씀 
		int var3 =0x74a;//16진수	
		int var4 = 0b11011;//2진수	1,0만사용가능함
		
		System.out.println("var1 = " + var1);
		System.out.println("var2 = " + var2);
		System.out.println("var3 = " + var3);
		System.out.println("var4 = " + var4);
		
		long l1 = 1000;
	//	long l2 = 1000000000000;// int범위 밖을 넣으려해서,오류로뜸
		long l2 = 1000000000000L; //큰 숫자 쓰려면 L을 써줌
		
		System.out.println("l1 = " + l1);
		System.out.println("l2 = " + l2);
	}

}
