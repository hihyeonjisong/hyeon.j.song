package kr.or.ddit.study13.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class HistoGramSEM {
	/*
	 * 요구사항. 
	 * 
	 * 주사위 2개를 던져서 총 주사위 합을 구한후 
	 * 
	 * 1000번 시행후 해당 값을 저장 할것 
	 * 전체 히스토 그램을 구해 볼것
	 * 주사위 눈은 1~6으로 구현되어 있음.
	 * 
	 */
	
	List<Integer> diceList =new ArrayList<Integer>();
	//Map<주사위 눈금 합, 개수> 
	Map<Integer, Integer> map = new HashMap();
	
	public static void main(String[] args) {
		HistoGram hg = new HistoGram();
//		for(int i=0; i<1000; i++) {
//		}
		hg.process();
	}
	
	private void process() {
		doThrow(100000);
		print();
	}
	
	public void doThrow(int enforcement) {
//		for(int i=0; i<enforcement; i++) {
//			int num = throwDice()+throwDice();
//			diceList.add(num);
//		}
		
		for(int i=0; i<enforcement; i++) {
			int num = throwDice()+throwDice();
			int cnt = 1;
			if(map.containsKey(num)) cnt+=map.get(num);
			map.put(num, cnt);
		}
	}
	

	public int throwDice() {
		return new Random().nextInt(6)+1;
	}
	
	public int getDiceNumCount(int num) {
		int cnt = 0;
		for(int dice : diceList) {
			if(dice == num) cnt++;
		}
		return cnt;
	}
	
	public void print() {
//		for(int i=2; i<=12;i++) {
//			int count = getDiceNumCount(i);
//			System.out.print("주사위 합 "+i+" 는 \t"+count+"\t");
//			for(int j= 0; j<count/1000; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		
		
		for(int i=2; i<=12;i++) {
			int count = map.get(i);
			System.out.print("주사위 합 "+i+" 는 \t"+count+"\t");
			for(int j= 0; j<count/1000; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
