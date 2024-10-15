package week08_dfs_bfs.necessary;

import java.util.Scanner;

public class P2615_Omok {

    public static final int ROW = 19, COLUMN = 19;
    public static int[][] board = new int[ROW][COLUMN];

    public static int winner;
    public static int victoryR, victoryC;

    // 우상향, 우향, 우하향, 하향
    public static int[] dr = new int[]{-1, 0, 1, 1};
    public static int[] dc = new int[]{1, 1, 1, 0};

    public static final int EMPTY = 0;

    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < ROW; i++) {
            for (int j = 0 ; j < COLUMN; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        // 연산
        checkBoard();

        // 출력
        System.out.println(winner);
        if (winner != 0)
            System.out.println(victoryR + " " + victoryC);
    }

    public static void checkBoard() {
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COLUMN; c++) {
                int color = board[r][c];

                if (color == EMPTY)
                    continue;

                // 4개 방향(우상향, 우향, 우하향, 하향)에 대해 체크
                for (int dir = 0; dir < 4; dir++) {
                    int prevR = r - dr[dir];
                    int prevC = c - dc[dir];

                    // 6개 이상에 대한 정답 X 판별
                    if (inRange(prevR, prevC) && board[prevR][prevC] == color)
                        continue;

                    int cnt = 1;
                    int nextR = r + dr[dir], nextC = c + dc[dir];
                    while (inRange(nextR, nextC) && board[nextR][nextC] == color) {
                        cnt++;
                        nextR += dr[dir];
                        nextC += dc[dir];
                    }

                    // 승부 결정 됨
                    if (cnt == 5) {
                        winner = color;
                        victoryR = r + 1;   // 1부터 시작 반영
                        victoryC = c + 1;   // 1부터 시작 반영
                        return;
                    }
                }
            }
        }

        // 승부 결정 안 됨
        winner = 0;
    }

    public static boolean inRange(int r, int c) {
        return (r >= 0 && r < ROW && c >= 0 && c < COLUMN);
    }
}
