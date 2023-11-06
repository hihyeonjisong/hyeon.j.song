package kr.or.ddit.study13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MapExample3 {
	public static void main(String[] args) {
		MapExample3 me = new MapExample3();
		List<Map> l    = me.dataInput(); //데이터 입력
		int maxSalary  = me.getMaxSalary(l); //최대월급
		System.out.println("직원 최대 월급은 : "+maxSalary);
		List addDept   = me.getAddDept(l);
		me.printEmp_no103(l);
		
	}
	public List<Map> dataInput(){
	
		//  emp_no, emp_name, dept,  tel,           salary
	//		100   	장승수	영업부	010-8422-8117	300
	//		101   	홍성범	기획부	010-7562-3217	350
	//		102   	이만수	기획부	010-5562-6677	500
	//		103   	강나미	영업부	010-4442-5614	350
	//		109   	민병철	총무부	010-2542-8211	250
		
		/*
		 * 5개의 맵을 각각 선언 및 데이터 입력 ---put사용해서( key, value)
		 */
		HashMap m1 = new HashMap();
		m1.put("emp_no","100");
		m1.put("emp_name","장승수");
		m1.put("dept","영업부");
		m1.put("tel","010-8422-8117");
		m1.put("salary","300");
		
		HashMap m2 = new HashMap();
		m2.put("emp_no","101");
		m2.put("emp_name","홍성범");
		m2.put("dept","기획부");
		m2.put("tel","010-7562-3217");
		m2.put("salary","350");
		
		HashMap m3 = new HashMap();
		m3.put("emp_no","102");
		m3.put("emp_name","이만수");
		m3.put("dept","기획부");
		m3.put("tel","010-5562-6677");
		m3.put("salary","500");
		
		HashMap m4 = new HashMap();
		m4.put("emp_no","103");
		m4.put("emp_name","강나미");
		m4.put("dept","영업부");
		m4.put("tel","010-4442-5614");
		m4.put("salary","350");
		
		HashMap m5 = new HashMap();
		m5.put("emp_no","109");
		m5.put("emp_name","민병철");
		m5.put("dept","총무부");
		m5.put("tel","010-2542-8211");
		m5.put("salary","250");
		
		
		
		/*
		 * 5개의 맵을 리스트를 선언해 입력  할 것.
		 */
		ArrayList l = new ArrayList();
		l.add(m1);
		l.add(m2);
		l.add(m3);
		l.add(m4);
		l.add(m5);
		
		return l;
		
		
		/*
		 * 리스트에 각 맵을 입력한후 리턴 해볼 것.
		 */
	
	}
	public int getMaxSalary(List<Map> l) {//데이터 없어서 넣어줘야함:List<Map> l 을 괄호에넣기
		// 제일 높은 월급.
		int max =0;
		for (Map map : l) {       //향상된for문(자기만큼 꺼냄:5번꺼냄)
			String salary = (String) map.get("salary");//salary문자열값 꺼내기
			int salaryInt = Integer.parseInt(salary); //문자열 비교를위해 숫자로바꿈 (레퍼클래스라고 함:int만 Integer임)
			if(salaryInt> max) {    //맥스값과 비교해서 더 크면 max값에 저장하기
				max=salaryInt;
				
			}
		}
		return max; //(max값이 위로 전해짐)
	}
	
	public List getAddDept(List<Map> l ) { //데이터 없어서 넣어줘야함:List<Map> l 을 괄호에넣기
		// 각 부서별 월급 합 구하기.
		ArrayList salSum = new ArrayList(); //{ hashmap, hashmap, hashmap}:hashmap을 담는 공간생성
		HashMap sum = new HashMap();   //hashmap 형태를 만들기위해 생성
		for (Map map : l) {
			String dept = (String) map.get("dept");
			String salary = (String) map.get("salary");//salary에서 꺼낸 문자를 숫자로 바꾸기
			int salaryInt = Integer.parseInt(salary); 
			if(sum.containsKey(dept))salaryInt = (int) sum.get(dept);//부서 입력된 값이 있으면 거기에다가 더해준다
			sum.put(dept, salaryInt);
		}
		System.out.println(sum);
		//sum값 전체 꺼내서 salsum에 넣어보기
		
		Iterator it = sum.keySet().iterator();
		while(it.hasNext()) {
			String key = (String) it.next(); //입력한 값은 문자라고 cast해줘야함
			int value = (int) sum.get(key);
			salSum.add(value);
		}
		return salSum;
	}
	
	public void printEmp_no103(List<Map> l) {
		for(int i=0; i<l.size();i++) {
			Map m = l.get(i);
			//no_103인사람 찾기
			String emp_no = (String) m. get("emp_no");
			//no_103이 아니라면 continue로 다음 for문 진행하기
			if(!emp_no.equals("103"))continue;
			System.out.println(m);
			//모든 정보 출력하기
			//iterator사용해볼것
			Iterator it = m.keySet().iterator();
			while(it.hasNext()) {
				String key = (String) it.next();
				String value = (String) m.get(key);
				System.out.println(value+"\t");
			}
			System.out.println();
			System.out.println("---------------------");
		}
	}
}


