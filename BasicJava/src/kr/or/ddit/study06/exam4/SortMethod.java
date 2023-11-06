package kr.or.ddit.study06.exam4; //다시적기 버블정렬메소드가져와서씀

import java.util.Arrays;

public class SortMethod {
	public static void main(String[] args) {
		SortMethod sort = new SortMethod();
		
		int[]num = {67,55,9,86,98};
		System.out.println(Arrays.toString(num)); 
		int[] result = sort.sort(num);
		System.out.println(Arrays.toString(result)); 
		
		System.out.println("-----------------------");
		
	}
	public int[]sort(int[]arr){ //public은 접근범위 
		for (int i = 0; i < num.length-1; i++) {
			for (int j = 0; j < num.length-1; j++) {//뒷값인 b가 클경우 a b 바꾸는 방법
				if(num[j]>num[j+1]) {
					int temp =num[j];//a b 값 바꿀때
					num[j] = num[j+1];//a값에 b값을 넣음
					num[j+1] = temp;/
		}
		return null;
	}
}
