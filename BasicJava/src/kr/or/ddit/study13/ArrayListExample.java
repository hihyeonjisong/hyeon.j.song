package kr.or.ddit.study13;//필기 다시했음

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 도큐먼트주석 : 단축키 alt shift j(보통 본인 이름씀)
 *
 */
/**
 * ArrayList                     //ArrayList 이해하기!!(배열대신 사용! 훨씬 간편)
 * -1차원 배열구조
 * -승복을 허락하고 순서화제공
 * -List 타입의 컬렉션
 * 
 * 주요메서드
 * .add 	: 데이터삽입
 * .clear   : 모든 데이터 삭제
 * .contains: 포함 여부 확인
 * .get 	: idx 자료 반환
 * .remove	: idx 자료 반환후 삭제
 *
 */
public class ArrayListExample {
	public static void main(String[] args) {
		ArrayTest at = new ArrayTest();
		
		for (int i = 0; i < 20; i++) {
			at.add("str"+i);
		}
		String[]arr = at.arr;
		System.out.println(Arrays.toString(at.arr));
		
		/*
		 * 배열중에 str6 이 있는지 검사해보기.
		 */
		
		ArrayList l = new ArrayList();
		l.add("데이터1");
		l.add(10.3);
	
		for (int i = 0; i < l.size(); i++) {
		System.out.println(l.get(i)); //.get으로 자료 반환
		}
		
	}
}
