package kr.or.ddit.study13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MapExample2 {
	public static void main(String[] args) {
		//emp_no  emp_name  dept     tel
		//100   	송현지	개발1부	010-9917-2815	
		
		//해쉬맵에 각각 입력해보기
		//
		HashMap map = new HashMap();
		         //key ,value
		map.put("emp_no","100");
		map.put("emp_name","장승수");
		map.put("dept","영업부");
		map.put("tel","010-8422-8117");//추가로 데이터 넣을때 만들어진map 에 넣으면 안됌!!
		
		HashMap map2 = new HashMap();
		map2.put("emp_no", "101");
		map2.put("emp_name", "홍성범");
		map2.put("dept", "기획부");
		map2.put("tel", "010-7562-3217");
		
		
//		String emp_no = (String)map.get("emp_no"); //emp_no,tel 꺼내보기 --key값으로 value("100")를 꺼낸다
//		String tel = (String)map.get("tel");
//		System.out.println(emp_no);
//		System.out.println(tel);
		
		Iterator it = map.keySet().iterator();  //전체꺼내기     Iterator(java.util임)-맵에 키셋에 이터레이터
		while(it.hasNext()) {
			String key = (String) it.next();
			String value = (String)map.get(key);
			System.out.println(key +","+value);
		}
		
         //map에 emp_no가져오기
        //map2에 emp_name가져오기
		System.out.println(map.get("emp_no"));
		System.out.println(map2.get("emp_name"));
		
		ArrayList l= new ArrayList();//리스트에 맵 담아보기 .add() 사용
		l.add(map);
		l.add(map2);
		
		System.out.println(l); // (map ,map 2,.....) --> list를 사용해서 담기
		
		
		
	}
}
