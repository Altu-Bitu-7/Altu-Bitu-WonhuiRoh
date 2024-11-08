package week11_twoPointer;

import java.util.Scanner;

public class P11659_SumOfSections4 {
    public static int n, m;
    public static int[] sums;
    public static int i, j;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        sums = new int[n + 1];

        for (int k = 1; k <= n; k++)
            sums[k] = sc.nextInt();

        for (int k = 2; k <= n; k++)
            sums[k] += sums[k-1];

        while (m-- > 0) {
            i = sc.nextInt();
            j = sc.nextInt();

            System.out.println(sums[j] - sums[i - 1]);
        }
    }
}
