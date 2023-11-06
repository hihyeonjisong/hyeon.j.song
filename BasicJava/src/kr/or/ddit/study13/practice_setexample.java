package kr.or.ddit.study13;

import java.util.HashSet;

public class practice_setexample {
	public static void main(String[] args) {
		HashSet set = new HashSet();
		set.add("가");
		set.add("가");//중복안됌. 덮어쓰면서 원래값 없게됌
		System.out.println(set);
		
		HashSet lotto = new HashSet();
		while(lotto.size()<6) {
			int ran = (int) ((Math.random()*45)+1);//Math.random()*45 (*숫자: 범위)
//			 											    (0이되는것을 막아주려고 +1)
			lotto.add(ran);
		}
		System.out.println(lotto);
		
	}
}
