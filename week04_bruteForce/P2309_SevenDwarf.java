package week04_bruteForce;

import java.util.Arrays;
import java.util.Scanner;

public class P2309_SevenDwarf {
    public static final int DWARFS = 9;

    public static void printRealDwarfs(int[] dwarfs) {
        int sum = 0;
        for (int i = 0; i < DWARFS; i++) {
            sum += dwarfs[i];
        }

        // 9C7 = 9C2
        for (int i = 0; i < DWARFS - 1; i++) {
            for (int j = i + 1; j < DWARFS; j++) {
                if (sum - dwarfs[i] - dwarfs[j] == 100) {
                    dwarfs[i] = 0;
                    dwarfs[j] = 0;

                    Arrays.sort(dwarfs);

                    for (int k = 2; k < DWARFS; k++) {
                        System.out.println(dwarfs[k]);
                    }

                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dwarfs = new int[DWARFS];

        for (int i = 0; i < DWARFS; i++) {
            dwarfs[i] = sc.nextInt();
        }

        printRealDwarfs(dwarfs);
    }
}
