package week06_greedy;

import java.util.Scanner;

public class P11047_Coin0 {
    public static final int MAX = 10;

    public static int n, k;
    public static int[] coins = new int[MAX];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        for (int i = n - 1; i >= 0; i--) {
            coins[i] = sc.nextInt();
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += k / coins[i];
            k %= coins[i];
        }

        System.out.println(cnt);
    }
}
