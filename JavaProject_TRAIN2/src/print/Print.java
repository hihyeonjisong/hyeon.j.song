package print;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import vo.Classvo;
import vo.Gubun;
import vo.ReserveList;
import vo.Seat;
import vo.Yeojung;

public class Print {
	
	public void printimage() {
		
		System.out.println("###################################################################################################     \r\n" + 
				"#####################################**+++==========++***##########################################      \r\n" + 
				"############################*=---::::::::::::::::::::::::::::--=*##################################      \r\n" + 
				"#####################*+=::::::::::::::::::::::::::::::::::::::::::::=*#############################      \r\n" + 
				"###############*=--:::::::::-=+***###***+-::::::::::::::::::::::::::::::-*#########################      \r\n" + 
				"##########+-:::::::::::-+####################=::::::::::::::::::::::::::::::+######################      \r\n" + 
				"#########-:::::-=+*#############################+-::::::::::::::::::::::::::::-+###################      \r\n" + 
				"##########*+#######################################-:::::::::::::::::::::::::::::=#################      \r\n" + 
				"#####################################################*=-:::::::::::::::::::::::::::=###############      \r\n" + 
				"##########################################################+=-:::::--------------:::::-#############      \r\n" + 
				"#################################################################################*-::::+###########      \r\n" + 
				"##############################################===+#################################+::::-##########      \r\n" + 
				"###############*-:::**=::::::::::::::::=##+==+*######################################=::::*########      \r\n" + 
				"###############=:::-:::-+###::::*###=::+===*##########################****************+::::+#######      \r\n" + 
				"##############*:::::::*####=:::=####*====*########################*********************=:::-*######      \r\n" + 
				"##############::::*::::###*::::+##*====:::*####################*************************-:::+######      \r\n" + 
				"#############=:::=#*::::##=:::=##====+#-:::*################***************************#-:::+######      \r\n" + 
				"#############+==+###*===*#+==+##++++###*+==+#############******************************+:::-*######      \r\n" + 
				"#########################################*********************************************+::::=#######      \r\n" + 
				"############*************************************************************************-::::+########      \r\n" + 
				"##########*-----------------------------------------------------------------------::::::-##########      \r\n" + 
				"##########-::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::-=############      \r\n" + 
				"###########************************************************************************################      \r\n" + 
				"###################################################################################################      \r\n" + 
				"###################################################################################################  ");
	}

	public void printVar() {
		System.out.println("▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩");
	}

	public void printLn(int num) {
		for (int i = 0; i < num; i++)
			System.out.println();
	}
	
	public void printLogout() {
		System.out.println("로그아웃이 완료되었습니다.");
	}
	
	public void printupselect() {
		printVar();
		System.out.println("▩▩ ");
		System.out.println("▩▩       1.날짜 변경하기 ");
		System.out.println("▩▩       2.시간 변경하기");
		System.out.println("▩▩       3.호차 변경하기    ");
		System.out.println("▩▩         4.좌석 변경하기     ");
		System.out.println("▩▩ ");
		printVar();
	}
	
	public void printPlusreserve() {
		printVar();
		System.out.println("▩▩ ");
		System.out.println("▩▩       1.추가 예매하기");
		System.out.println("▩▩       2.홈으로가기");
		System.out.println("▩▩       3.로그아웃하기");
		System.out.println("▩▩ ");
		printVar();
	}
	
	public void reserveList(List<ReserveList> list) {
		printVar();	
		System.out.println();
		System.out.println("			        ☆★☆★☆★☆★【 예 매 내 역 】★☆★☆★☆★☆");
		System.out.println();
		System.out.println("예매번호\t출발지\t도착지\t출발일\t\t출발시간\t도착시간\t호차    (등급)\t좌석번호\t결제금액");
		System.out.println("-----------------------------------------------------------------------------------------");
		for(ReserveList reservelist : list) {
			System.out.printf("%d\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%d원",reservelist.getBy_no(),reservelist.getTr_st(),reservelist.getTr_ed(),reservelist.getBy_date(),reservelist.getTr_si(),reservelist.getTr_ei(),reservelist.getCl_name(),reservelist.getSe_no(),reservelist.getBy_price());
			System.out.println();
			System.out.println();
		}
	
	}
	
	public void printGubunlist(List<Gubun> list) {
		printVar();
		System.out.println("구분번호\t구분명");
		System.out.println("--------------");
		for(Gubun gubun : list) {
			System.out.printf("%d\t%s", gubun.getGu_no(),gubun.getGu_name());
			System.out.println();
		}
	}
	
	public void printClasslist(List<Classvo> list) {
		printVar();
		System.out.println("선택번호\t호차    (구분)");
		System.out.println("--------------------");
		for(Classvo classlist : list) {
			System.out.printf("%d\t%s", classlist.getTr_ci(),classlist.getCl_name());
			System.out.println();
		}
	}
	
	public void printSeatnUm(List<Seat> list) {
		printVar();
		System.out.println("좌석명");
		for(Seat seat : list) {
			System.out.printf("%s\n",seat.getSe_nm());
		}
		printVar();
	}
	
	
	public void printTimelist(List<Yeojung> list) {
		System.out.println("번호\t출발시간\t도착시간");
		System.out.println("----------------------");
		for(Yeojung yeojung : list) {
			System.out.printf("%d\t%s\t%s",yeojung.getYj_no(),yeojung.getTr_si(),yeojung.getTr_ei());
			System.out.println();
		}
	}
	
	
	public void printreserveService() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
        Calendar cal = Calendar.getInstance();
        Date date1 = cal.getTime();
        cal.add(Calendar.DATE, 1);
        Date date2 = cal.getTime();
        cal.add(Calendar.DATE, 1);
        Date date3 = cal.getTime();
        cal.add(Calendar.DATE, 1);
        Date date4 = cal.getTime();
        printVar();
        System.out.println("[   출발 일자      ]");
        System.out.println("1."+sdf.format(date1) + "\n" +
        		"2." + sdf.format(date2) + "\n" +
        		"3."+sdf.format(date3) + "\n" +
        		"4."+sdf.format(date4));
	}

	
	public void printDatechoice() {
		printVar();
		System.out.println("▩▩ ");
		System.out.println("▩▩       1.행선지 다시 선택하기");
		System.out.println("▩▩       2.날짜 선택하기");
		System.out.println("▩▩ ");
		printVar();
	}
	
	public void printReserveMenu() {
		printVar();
		System.out.println("▩▩");
		System.out.println("▩▩    °◑┻┻━━━┑┍━━━━┑┍━━━━┑┍━━━━┑ ☆\r\n" + 
				"▩▩    ˙▣▣▨▨▨▨││▣▣▣▣││▣▣▣▣││▣▣▣▣│ ∞\r\n" + 
				"▩▩    ★ ///●≒●≒●≒●≒●≒≒●≒≒●≒≒●≒≒●≒≒● ˚ 。·");
		System.out.println("▩▩ ");
		System.out.println("▩▩       1.기차 예매하기");
		System.out.println("▩▩       2.내 예매내역 조회하기");
		System.out.println("▩▩       3.내 예매내역 수정하기");
		System.out.println("▩▩       4.내 예매내역 취소하기");
		System.out.println("▩▩       5.로그아웃하기");
		System.out.println("▩▩ ");
		printVar();
	}
	
	public void printTrainend() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("[ 도착지 ]");
		System.out.println("● 서 울");
		System.out.println("● 대 전");
		System.out.println("● 부 산");
		System.out.println("● 여 수");
		System.out.println("● 전 주");
		System.out.println("● 경 주");
	} 
	
	public void printTrainstart() {
		printVar();
		System.out.println("[ 출발지 ]");
		System.out.println("● 서 울");
		System.out.println("● 대 전");
		System.out.println("● 부 산");
		System.out.println("● 여 수");
		System.out.println("● 전 주");
		System.out.println("● 경 주");
	}
	
	
	public void printLoginfalse() {
		printVar();
		System.out.println("▩▩                                                                                                                                                 ");
		System.out.println("▩▩       1. 회원가입하기");
		System.out.println("▩▩       2. 비회원등록하기");
		System.out.println("▩▩       3. 홈으로 가기");
		System.out.println("▩▩                                                                                                                                                 ");
		printVar();
	}


	public void printHome() {
		printVar();
		System.out.println("▩▩                                                                                                                                                                                                          ");
		System.out.println("▩▩       <열차예매 홈페이지>                                                                                                                                                                                         ");
		System.out.println("▩▩                                                                                                                                                                                ");
		System.out.println("▩▩        1. 회원 로그인                                                                             ");
		System.out.println("▩▩        2. 비회원 로그인                                                                                                                           ");
		System.out.println("▩▩        3. 회원 가입하기                                                                                              ");
		System.out.println("▩▩        4. 비회원 등록하기                                                                         ");
		System.out.println("▩▩                                                                                                                                                               ");
		printVar();
	}

}
