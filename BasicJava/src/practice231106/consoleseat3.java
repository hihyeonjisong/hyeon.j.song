package practice231106;

import java.util.Scanner;

public class consoleseat3 {
    public static void main(String[] args) {
        // 초기 기차 좌석 배열 생성
        char[][] trainSeats = new char[16][4];
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 4; j++) {
                trainSeats[i][j] = 'O';
            }
        }

        // 좌석 배열 출력
        printSeatArrangement(trainSeats);

        // 사용자 입력을 받아 좌석 선택
        Scanner scanner = new Scanner(System.in);
        int row;
        char column;

        while (true) {
            // 사용자에게 좌석 선택 입력 받기
            System.out.print("행 번호를 입력하세요 (1~16): ");
            row = scanner.nextInt();
            System.out.print("열 번호를 입력하세요 (a, b, c, d): ");
            column = scanner.next().charAt(0);

            // 선택된 좌석이 유효한지 확인하고 표시
            if (isValidSeat(row, column) && trainSeats[row - 1][column - 'a'] == 'O') {
                trainSeats[row - 1][column - 'a'] = 'X';

                // 좌석 배열 출력
                printSeatArrangement(trainSeats);

                System.out.println(row + "행 " + column + "열 좌석이 선택되었습니다.");
            } else {
                System.out.println("유효하지 않거나 이미 선택된 좌석입니다. 다시 선택해주세요.");
            }
        }
    }

    // 좌석 배열 출력 메서드
    private static void printSeatArrangement(char[][] seats) {
        System.out.println("  a b c d");
        for (int i = 0; i < 16; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 4; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 좌석 유효성 검사 메서드
    private static boolean isValidSeat(int row, char column) {
        return row >= 1 && row <= 16 && (column == 'a' || column == 'b' || column == 'c' || column == 'd');
    }
}