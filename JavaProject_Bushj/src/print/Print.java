package print;

import java.util.List;

import vo.Bus;


public class Print {
	
	public void printVar() {
		System.out.println("-----------------------");
	}
	
	public void println(int num) {
		for (int i = 0; i < num; i++) {
			System.out.println();
		}
	}
	public void printHome() {
		printVar();
		System.out.println("1. 버스예매");
		System.out.println("2. 예매내역 조회");
		System.out.println("3. 예매취소");
		println(5);
		printVar();
	}
	public void printlist(List<Bus>list) {
		System.out.println("버스번호\t출발지\t도착지\t출발시간\t등급\t회사\t가격\t좌석수");
		for (Bus bus : list) {
			System.out.printf("%d\t%s\t%s\t%s\t%s\t%s\t%d\t%d\t",bus.getNo(),bus.getSt_bus(),bus.getEd_bus(),bus.getDe_time(),bus.getBus_cls(),bus.getCompany(),bus.getPrice(),bus.getSit());
			System.out.println();
		}
	}
	
	
	public void printReserveMenu() {
		printVar();
		System.out.println("1. 예매");
		System.out.println("2. 출발/행선지 변경");
		System.out.println("3. 홈");
		println(5);
		printVar();
	}

	
	public void printAdmin() {
		System.out.println("----------------------------------");
		System.out.println("1. 전체 상품 조회");
		System.out.println("2. 재고 관리");
		System.out.println("3. 신규 상품 등록");
		System.out.println("----------------------------------");
	}
	
//	public void printProdList(List<Bus> list) {
//		System.out.println("no\tname\t가격\t설명\t수량\t날짜");
//		System.out.println("----------------------------------");
//		for(ProdBoard pb: list) {
//		
//			System.out.println(pb);
//		}
//	}
	
	
	public void printMember() {
		System.out.println("----------------------------------");
		System.out.println("1. 전체 상품 조회");
		System.out.println("2. 상품 구매");
		System.out.println("3. 구매 상품 조회");
		System.out.println("4. 장바구니 조회");
		System.out.println("----------------------------------");
	}
	
}
