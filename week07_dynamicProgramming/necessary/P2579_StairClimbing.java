package week07_dynamicProgramming.necessary;

import java.util.Scanner;

public class P2579_StairClimbing {

    public static int n;
    public static int[] scores;

    public static int[] dp;

    public static void climbStairs() {
        dp[1] = scores[1];

        if (n >= 2) {
            dp[2] = scores[1] + scores[2];
        }

        if (n >= 3) {
            for (int i = 3; i <= n; i++) {
                dp[i] = Math.max(dp[i-3] + scores[i-1], dp[i-2]) + scores[i];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        scores = new int[n+1];
        for (int i = 1; i <= n; i++) {
            scores[i] = sc.nextInt();
        }

        dp = new int[n+1];
        climbStairs();

        System.out.println(dp[n]);
    }
}
