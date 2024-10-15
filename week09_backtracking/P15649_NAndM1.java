package week09_backtracking;

import java.util.Scanner;

public class P15649_NAndM1 {

    public static int N, M;
    public static boolean[] used;
    public static int[] sequence;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        used = new boolean[N + 1]; // 1부터 시작하도록
        sequence = new int[M];

        backtrack(0);
    }

    public static void backtrack(int index) {
        if (index == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(sequence[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int num = 1; num <= N; num++) {
            if (used[num])
                continue;

            sequence[index] = num;
            used[num] = true;
            backtrack(index + 1);
            used[num] = false;
        }
    }
}
