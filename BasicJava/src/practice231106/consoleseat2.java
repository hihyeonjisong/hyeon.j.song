package practice231106;

import java.util.Scanner;

public class consoleseat2 {
    private static char[][] seatMatrix;

    public static void main(String[] args) {
        initializeSeatMatrix(5, 4);  // 예시로 5행 4열의 좌석 행렬을 초기화
        displaySeatMatrix();

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n1. 예매 / 2. 취소 / 3. 나가기");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    reserveSeat(scanner);
                    break;
                case 2:
                    cancelReservation(scanner);
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
            }

            displaySeatMatrix();
        }

        System.out.println("프로그램을 종료합니다.");
    }

    private static void initializeSeatMatrix(int rows, int cols) {
        seatMatrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                seatMatrix[i][j] = 'O';  // 'O'는 빈 좌석을 나타냅니다.
            }
        }
    }

    private static void displaySeatMatrix() {
        System.out.println("========== 좌석 행렬 ==========");
        for (char[] row : seatMatrix) {
            for (char seat : row) {
                System.out.print(seat + " ");
            }
            System.out.println();
        }
    }

    private static void reserveSeat(Scanner scanner) {
        System.out.println("예약할 좌석의 행과 열을 입력하세요 (행 열): ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();

        if (isValidSeat(row, col) && seatMatrix[row - 1][col - 1] == 'O') {
            seatMatrix[row - 1][col - 1] = 'X';  // 'X'는 예약된 좌석을 나타냅니다.
            System.out.println("예약이 완료되었습니다.");
        } else {
            System.out.println("잘못된 좌석이거나 이미 예약된 좌석입니다. 다시 시도하세요.");
        }
    }

    private static void cancelReservation(Scanner scanner) {
        System.out.println("취소할 좌석의 행과 열을 입력하세요 (행 열): ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();

        if (isValidSeat(row, col) && seatMatrix[row - 1][col - 1] == 'X') {
            seatMatrix[row - 1][col - 1] = 'O';  // 'O'로 다시 빈 좌석으로 변경
            System.out.println("예약이 취소되었습니다.");
        } else {
            System.out.println("잘못된 좌석이거나 이미 빈 좌석입니다. 다시 시도하세요.");
        }
    }

    private static boolean isValidSeat(int row, int col) {
        return row > 0 && row <= seatMatrix.length && col > 0 && col <= seatMatrix[0].length;
    }
}