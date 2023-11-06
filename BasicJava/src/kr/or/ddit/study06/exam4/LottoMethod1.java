package kr.or.ddit.study06.exam4; //다시 이해하기//원래

import java.util.Arrays;

public class LottoMethod1 {
	public static void main(String[] args) {
		LottoMethod1 lm = new LottoMethod1();
//		lm.generateLotto();
//		int[] lotto = lm.generateLotto();
//		System.out.println(Arrays.toString(lotto));
//		int[][] paper = lm.lottoPaper();
//		for (int i = 0; i < paper.length; i++) {
//			System.out.println(Arrays.toString(paper[i]));
//
//		}
//		for (int i = 0; i < paper.length; i++) {
//			lm.printArray(paper[i]);
//		}
		int[][][] bundle = lm.lottoBundle(20000); //bundle저장소, lottobundle메소드로감
		for (int i = 0; i < bundle.length; i++) {
			int[][] paper = bundle[i];
			for (int j = 0; j < paper.length; j++) {
				int[] lotto = paper[j];
				System.out.println(Arrays.toString(lotto) + "1");
			}
			System.out.println("-----------------");
		}

	}

	public void printArray(int[] arr) {
		System.out.println("[");
		for (int i = 0; i < arr.length; i++) {
			if (arr.length - 1 == i) {
				System.out.print(arr[i] + "] ");
			} else {
				System.out.print(arr[i] + ", ");
			}
		}
		System.out.println();
	}

	public int[][][] lottoBundle(int money) {
		/*
		 * 1000
		 */
		int papers = money / 1000 / 5;
		if (money / 1000 % 5 != 0)
			papers++;

		int[][][] bundle = new int[papers][5][6];

		for (int i = 0; i < bundle.length; i++) {
			bundle[i] = lottoPaper();
		}
		if (money / 1000 % 5 != 0) { // 나머지가 있을시
			bundle[papers - 1] = lottoPaper(money / 1000 % 5); // 나머지 만큼만 출력한다
		}
		;
		return bundle;
	}

	public int[][] lottoPaper(int n) {
		int[][] paper = new int[n][6]; // 1차원 배열은 2차원배열에 담음

		for (int line = 0; line < paper.length; line++) {
			int[] lotto = generateLotto(); // 간단하게 하는 방법!!(코드를 압축함)(밑에 generateLotto가져오는거임)
			paper[line] = lotto; // 배열 0,1,ㅇㅇㅇ에 로또 저장함 차곡차곡 line배열에 저장함
		}

		return paper;
	}

	public int[][] lottoPaper() { // 오버로딩 : 위의 lotto paper 에 5가 들어감
		return lottoPaper(5);
	}

	public int[] generateLotto() {
		int[] lotto = new int[6];// 로또 6자리 저장할수있게

		for (int i = 0; i < 6; i++) { // 로또길이만큼 6번뽑음
			int ran = (int) (Math.random() * 45) + 1;
			lotto[i] = ran;// 배열값저장
			for (int j = 0; j < i; j++) { // 비교for문
				if (lotto[i] == lotto[j]) { // 중복이면 빼기위해서(같으면 다시뽑아야하니까 -임)(그 전값과비교하니까 j<i)
					i--; //
					break;
				}
			}
		}
		Arrays.sort(lotto); // 버블정렬 이걸로 끝! :랜덤으로 나왔으니까 정렬함
//		System.out.println(Arrays.toString(lotto));
		return lotto;
	}

}
