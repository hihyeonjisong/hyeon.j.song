package kr.or.ddit.study13;

import java.util.HashMap;
import java.util.Iterator;

import oracle.net.aso.e;

/**
 * <HashMap> 매우 중요★★★
 * key와 value로 이루어짐     
 * key값은 중복 허용x, 순서보장x
 * 
 * Map타입의 컬렉션
 * 
 * 주요메소드
 * .put(key,value); : 데이터입력key값은 중복되지않음. value는 중복될수있음 (한 반에 pc번호는 중복x, pc04의 김태원, pc05의 김태원은 중복될수있음)
 * get(key) 		: 입력받은 value값을key값을 통해 꺼내 올수있음.
 * .keySet() 		:key로 이루어진 hashSet 값을 가져옴.
 */
public class MapExample {
	public static void main(String[] args) {
		/*
		 * 제네릭정보
		 * HashMap<key,value> :제너릭타입을 <선언>해주면 밑에(캐스팅할때마다) 타입을 안써줘도됌
		 */      
		HashMap<String,Integer> map = new HashMap();//hashmap선언
		map.put("홍길동",95);
		map.put("이순신",75);
		map.put("정몽주",90);
		map.put("이성계",83);
		
//		int score = (int)map.get("홍길동"); //홍길동의 점수
//		double d_score = (double)map.get("이순신"); //홍길동의 점수
//		System.out.println(score);
//		System.out.println(d_score);
		
		map.put("홍길동",60);
		System.out.println(map);//홍길동 점수가 60으로 덮어씌워짐
		
		Iterator<String> it = map.keySet().iterator(); //Iterator:데이터를 순차적으로 꺼내오는역할
		while(it.hasNext()) {					//데이터가 있어? 있으면 입력
			String key = it.next();	//있으면 입력
			int value = (int)map.get(key);      //get으로 같은값 뽑아옴
			System.out.println(key+","+value);			
		}
		
	}
	
	
}
