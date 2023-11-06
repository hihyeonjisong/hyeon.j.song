package kr.or.ddit.study13;

import java.util.HashSet;

/*
 * <HashSet>
 * key로 이루어짐
 * key값은 중복을 허용하지 않고 순서가 보장되지 않음
 * 
 * set 타입의 대표 컬렉션
 * 
 * 주요메소드
 * .add(key);  <-값추가
 * .remove(key); <-값삭제
 * .contains(key); <-포함여부
 * .iterator();<-전체출력을 위한 이터레이터
 */
public class SetExample {
	public static void main(String[] args) {
	HashSet set = new HashSet(); 
	set.add("가");
	set.add("라");
	set.add(1);
	set.add(10.3);
	set.add("가");
	System.out.println(set);// ->출력시 순서는 랜덤이라서
	
	HashSet lotto = new HashSet(); //HashSet선언
	while(lotto.size()<6) {
		int ran = (int)(Math.random()*45)+1;
		lotto.add(ran);
	}
 
	System.out.println(lotto);
}
}
