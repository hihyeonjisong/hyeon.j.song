package kr.or.ddit.study13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MapExample4 {

	public static void main(String[] args) {
//		기본 시간(분)	기본 요금(원)	단위 시간(분)	단위 요금(원)
//		180	5000	10	600
		MapExample4 me = new MapExample4();
		List<Map> l = me.dataInput();
//		me.printAll(l);
		int min = me.getMin(l, "5961");
		System.out.println("5961번에 총 주차시간은" + min + "분");
		int pay = me.pay(min);
		System.out.println("5961번에 총 주차요금은 "+pay+"원");

	}
	
	public int pay(int min) {
		int money=0;
		if(min<=180){
			money = 5000;
		}else money =5000 + ((min-180)/10*600);
		min=money;
		return money;
	}

	public int getMin(List<Map> l, String number) {
		// list 에서 for문을 이용해서 map값 꺼내기
		ArrayList selectList = new ArrayList(); // 선택된차량 출력

		// map값이 number랑 같은지 비교하기
		// 아닐경우 continue 하기
		for (Map m : l) { // list에서 map꺼내기
			String car_no = (String) m.get("차량번호");// 차량번호 꺼내기
			if (!car_no.equals(number)) {
				continue; // 차량번호랑 number 비교(string에선 equals)
			}
			selectList.add(m);
			System.out.println(m);
		}
		String in = "";
		String out = "";

		int result = 0;
		for (int i = 0; i < selectList.size(); i++) {
			Map m = (Map) selectList.get(i);
			String time = (String) m.get("시각");// map에서 시각 꺼내기
//			System.out.println(time);
			// 내역이 입차라면 in에 시각입력
			// 출차 out
			// 내역이 출차일 경우 주차시간구하기
			String inout = (String) m.get("내역");// map에서 내역 꺼내기
			if (inout.equals("입차"))
				in = time;
			if (inout.equals("출차")) {
				out = time;
				int t1 = getTime(in);
				int t2 = getTime(out);
				result += t2 - t1;
				System.out.println(result);

			}
		}

		return result;
	}

	public int getTime(String t) {// 메소드로 뺌 (in out두번할필요x)
		String[] token = t.split(":"); // split: 문자를 쪼갬-배열로 쪼갬
		// token[0] 값 숫자로 변환해서 넣기
		int hour = Integer.parseInt(token[0]);
		// token[1] 값 숫자로 변환해서 넣기
		int min = Integer.parseInt(token[1]);
		return hour * 60 + min;
	}

	public List<Map> dataInput() {

//		시각          차량 번호	 내역
//		05:34	5961	 입차
//		06:00	0000	 입차
//		06:34	0000	 출차
//		07:59	5961	 출차
//		07:59	0148	 입차
//		18:59	0000	 입차
//		19:09	0148	 출차
//		22:59	5961	 입차
//		23:00	5961	 출차
		HashMap m1 = new HashMap();
		m1.put("시각", "05:32");
		m1.put("차량번호", "5961");
		m1.put("내역", "입차");

		HashMap m2 = new HashMap();
		m2.put("시각", "06:00");
		m2.put("차량번호", "0000");
		m2.put("내역", "입차");

		HashMap m3 = new HashMap();
		m3.put("시각", "06:34");
		m3.put("차량번호", "0000");
		m3.put("내역", "출차");

		HashMap m4 = new HashMap();
		m4.put("시각", "07:59");
		m4.put("차량번호", "5961");
		m4.put("내역", "출차");

		HashMap m5 = new HashMap();
		m5.put("시각", "07:59");
		m5.put("차량번호", "0148");
		m5.put("내역", "입차");

		HashMap m6 = new HashMap();
		m6.put("시각", "18:59");
		m6.put("차량번호", "0000");
		m6.put("내역", "입차");

		HashMap m7 = new HashMap();
		m7.put("시각", "19:09");
		m7.put("차량번호", "0148");
		m7.put("내역", "출차");

		HashMap m8 = new HashMap();
		m8.put("시각", "22:59");
		m8.put("차량번호", "5961");
		m8.put("내역", "입차");

		HashMap m9 = new HashMap();
		m9.put("시각", "23:00");
		m9.put("차량번호", "5961");
		m9.put("내역", "출차");

		ArrayList l = new ArrayList();
		l.add(m1);
		l.add(m2);
		l.add(m3);
		l.add(m4);
		l.add(m5);
		l.add(m6);
		l.add(m7);
		l.add(m8);
		l.add(m9);

		return l;
	}

	public void printAll(List<Map<String,String>> l) {
		// 전체값 출력 해볼것
		for (int i = 0; i < l.size(); i++) { // map꺼내려고 for 문사용
			Map m = l.get(i);
			Iterator it = m.keySet().iterator();
			while (it.hasNext()) {
				String key = (String) it.next();
				String value = (String) m.get(key);

//				String key = (String) it.next();
//				String value = (String) m.get(key);
				System.out.print(key + "," + value + "\t");
			}
			System.out.println();
		}
	}
}
