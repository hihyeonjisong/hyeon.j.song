package kr.or.ddit.study10;

public class ExceptionExample02 {
	public static void main(String[] args) {
		int[]arr = new int[10];
		
		try {
			for(int i =0;i<arr.length;i++) {//ArrayIndexOutOfBounds에러
				System.out.println(arr[i]);
			
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("에러 발생");
		}catch(Exception e) { //Exception
			System.out.println("에러 발생2");
		}
		
		System.out.println("?");
	}
}
