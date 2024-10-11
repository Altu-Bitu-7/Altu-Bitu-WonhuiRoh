package week07_dynamicProgramming.necessary;

import java.util.Scanner;

public class P11053_LongestIncreasingSubsequence {

    public static int n;
    public static int[] numbers;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        numbers = new int[n];
        for (int i = 0; i < n; i++)
            numbers[i] = sc.nextInt();

        int[] dp = new int[n];
        for (int i = 0; i < n; i++)
            dp[i] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (numbers[i] > numbers[j])
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
        }

        int ans = dp[0];
        for (int i = 1; i < n; i++)
            ans = Math.max(ans, dp[i]);

        System.out.println(ans);
    }
}
