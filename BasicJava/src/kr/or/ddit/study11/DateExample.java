package kr.or.ddit.study11;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Calender ,Date, SimpleDateFormat 날짜처리
 */
public class DateExample {
	static boolean debug = false;// 개발단계에선 데이터 출력 잘되는지 잘사용, 개발끝나고 false로 바꾸기

	public static void main(String[] args) {
		DateExample de = new DateExample();
//		de.dateMethod1();
//		de.dateMethod2();
//		de.dateMethod3();//지정한시간->지정한 형식에 넣어줌
		de.dateMethod4();// 내가 원하는 형식->현재시간넣어줌
//		de.dateMethod5();//캘린더 객체로 더하면 간편함
	}

	private void dateMethod5() {
		Calendar cal = Calendar.getInstance();// 캘린더 객체는 싱글톤으로 이루어짐
		cal.set(Calendar.YEAR, 2022);
		cal.set(Calendar.DATE, 1);
		Date date = cal.getTime();
		cal.add(Calendar.MONTH, -1); // Calender.~~: enum이다
		System.out.println(cal.getTime());

	}

	private void dateMethod4() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		Date d = new Date();
		String dateStr = sdf.format(d);
		System.out.println(dateStr);
		long time1 = 1000 * 60 * 60 * 24 * 1; // 7일 뒤
		long time2 = 1000 * 60 * 60 * 24 * 2; // 7일 뒤
		long time3 = 1000 * 60 * 60 * 24 * 3; // 7일 뒤
		long time4 = 1000 * 60 * 60 * 24 * 4; // 7일 뒤
		long time5 = 1000 * 60 * 60 * 24 * 5; // 7일 뒤
		long time6 = 1000 * 60 * 60 * 24 * 6; // 7일 뒤
		long time7 = 1000 * 60 * 60 * 24 * 7; // 7일 뒤
		// 현재 날짜와 시간에 7일을 더한 새로운 Date 객체
		Date d1 = new Date(d.getTime() + time1);
		Date d2 = new Date(d.getTime() + time2);
		Date d3 = new Date(d.getTime() + time3);
		Date d4 = new Date(d.getTime() + time4);
		Date d5 = new Date(d.getTime() + time5);
		Date d6 = new Date(d.getTime() + time6);
		
		SimpleDateFormat newFormat = new SimpleDateFormat("yyyy/dd/MM");
		String dd1 = newFormat.format(d1);
		String dd2 = newFormat.format(d2);
		String dd3 = newFormat.format(d3);
		String dd4 = newFormat.format(d4);
		String dd5 = newFormat.format(d5);
		String dd6 = newFormat.format(d6);
		
		System.out.println(dd1);
		System.out.println(dd2);
		System.out.println(dd3);
		System.out.println(dd4);
		System.out.println(dd5);
	}

	private void dateMethod3() {
		String dateStr = "2023-10-31 15:00";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			Date d = sdf.parse(dateStr);
			System.out.println(d);
			Date cur = new Date();

			long milSec = cur.getTime() - d.getTime();
			System.out.println(milSec);
			System.out.println(milSec / 1000 + "초");
			System.out.println(milSec / 1000 / 60 + "분");
			System.out.p rintln(milSec / 1000 / 60 / 60 + "시간");
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	private void dateMethod2() {
		String dateStr = "2023/10/30";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");// 자바 날짜 포멧 검색해서 쓰기

		try {
			Date yesterday = sdf.parse(dateStr);
			System.out.println(yesterday);
			Date cur = new Date();

			long milSec = cur.getTime() - yesterday.getTime();
			System.out.println(milSec + "ms");
			int sec = (int) (milSec / 1000);
			System.out.println(sec + "sec");
			int min = sec / 60;
			System.out.println(min + "분");
			int hour = min / 60;
			System.out.println(hour + "시간");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void dateMethod1() {
		if (debug)
			System.out.println("메소드");// 메소드 출력 되는지 꼭 확인하기
//		String date = "2023-10-02";
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");

		Date d1 = new Date(); // 객체가 생성된 시간
		System.out.println(d1);// java시간

		try { // 시간차
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Date d2 = new Date();
		System.out.println(d2);

		long time = d2.getTime() - d1.getTime();// 시간:long사용
		System.out.println(time);

		System.out.println(d1.getTime());
		System.out.println(d2.getTime());// 1970~부터 지난 시간

		double timed = (double) time / 1000;// 밀리초는 1/1000초니까
		System.out.println(timed);
	}
}
