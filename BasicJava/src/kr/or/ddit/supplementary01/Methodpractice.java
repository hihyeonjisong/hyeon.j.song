package kr.or.ddit.supplementary01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Methodpractice {
	public static void main(String[] args) {
		MethodVo m = new MethodVo();
		m.setA(10);
		m.setName("현지");
		m.getA();
		System.out.println(m.getA());
		System.out.println(m.getName());
		
		//생성자에 값 넣어보기
		MethodVo ssl = new MethodVo(11,"이수");
		System.out.println(ssl.name);
		//맵 
		Map <String,String>map = new HashMap();
		map.put("pc11", "송현지");
		map.put("pc11", "성이수");
		map.put("pc12", "장지원");
		
		System.out.println(map.get("pc11"));
		//key값 다 나오게하기
		System.out.println(map.keySet());
		
		//while사용해서 value값 다 나오게하기
		Iterator it = map.keySet().iterator();
		while(it.hasNext()) {
			String k =(String) it.next();
			System.out.println(map.get(k));
		}
		
		List l = new ArrayList();
		l.add(7);
		l.add(10);
		l.add("송지원");
		System.out.println(l.get(1));
		
		for (int i = 0; i < l.size(); i++) {
			l.get(i);
			System.out.println(l.get(i));
		}
			
		}
			
		
		
	}
}
