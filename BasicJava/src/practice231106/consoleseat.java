package practice231106;


	import java.util.Scanner;

	public class consoleseat {
	    private static char[][] seatMap; // 좌석 맵을 저장할 배열
	    private static int numRows = 5;
	    private static int numSeatsPerRow = 10;

	    public static void main(String[] args) {
	        initializeSeatMap(numRows, numSeatsPerRow);

	        while (true) {
	            displaySeatMap();
	            System.out.println("1. 좌석 예매");
	            System.out.println("2. 종료");
	            System.out.print("원하는 작업을 선택하세요: ");

	            Scanner scanner = new Scanner(System.in);
	            int choice = scanner.nextInt();

	            if (choice == 1) {
	                reserveSeat();
	            } else if (choice == 2) {
	                System.out.println("프로그램을 종료합니다.");
	                break;
	            } else {
	                System.out.println("잘못된 선택입니다. 다시 시도하세요.");
	            }
	        }
	    }

	    private static void initializeSeatMap(int numRows, int numSeatsPerRow) {
	        seatMap = new char[numRows][numSeatsPerRow];
	        for (int i = 0; i < numRows; i++) {
	            for (int j = 0; j < numSeatsPerRow; j++) {
	                seatMap[i][j] = 'O';
	            }
	        }
	    }

	    private static void displaySeatMap() {
	        System.out.println("좌석 맵:");
	        for (int i = 0; i < numRows; i++) {
	            for (int j = 0; j < numSeatsPerRow; j++) {
	                System.out.print(seatMap[i][j] + " ");
	            }
	            System.out.println();
	        }
	        System.out.println();
	    }

	    private static void reserveSeat() {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("예매할 좌석의 행을 선택하세요 (1부터 " + numRows + "까지): ");
	        int row = scanner.nextInt();
	        System.out.print("예매할 좌석의 열을 선택하세요 (1부터 " + numSeatsPerRow + "까지): ");
	        int seat = scanner.nextInt();

	        if (row < 1 || row > numRows || seat < 1 || seat > numSeatsPerRow) {
	            System.out.println("잘못된 좌석 번호입니다. 다시 시도하세요.");
	        } else if (seatMap[row - 1][seat - 1] == 'X') {
	            System.out.println("해당 좌석은 이미 예매되었습니다. 다른 좌석을 선택하세요.");
	        } else {
	            seatMap[row - 1][seat - 1] = 'X';
	            System.out.println("좌석 예매가 완료되었습니다.");
	        }
	    }
	}

