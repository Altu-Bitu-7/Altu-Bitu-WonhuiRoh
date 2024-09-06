package week04_bruteForce;

import java.util.Scanner;

public class P2231_DecompositionSum {
    public static void decompositionSum(int n) {
        for (int i = 1; i <= n; i++) {
            int decompositionSum = i;
            int tmp = i;

            while (tmp != 0) {
                decompositionSum += tmp % 10;
                tmp /= 10;
            }

            if (decompositionSum == n) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        decompositionSum(n);
    }
}
