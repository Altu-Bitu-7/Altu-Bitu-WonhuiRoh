package week01_sorting_map_set.necessary;

import java.util.Arrays;
import java.util.Scanner;

public class P1431_SerialNumber {
    public static int N;

    public static boolean isNumeric(char c) {
        int num = c - '0';
        return num > 0 && num < 10;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] serialNumbers;

        N = sc.nextInt();
        serialNumbers = new String[N];

        for (int i = 0; i < N; i++)
            serialNumbers[i] = sc.next();

        Arrays.sort(serialNumbers, (o1, o2) -> {
            if (o1.length() != o2.length())
                return o1.length() - o2.length();
            else { // o1.length() == o2.length()
                int sum1 = 0, sum2 = 0;

                for (int i = 0; i < o1.length(); i++) {
                    char c1 = o1.charAt(i), c2 = o2.charAt(i);

                    if (isNumeric(c1))
                        sum1 += Character.getNumericValue(c1);
                    if (isNumeric(c2))
                        sum2 += Character.getNumericValue(c2);
                }

                if (sum1 != sum2)
                    return sum1 - sum2;

                return o1.compareTo(o2);
            }
        });

        for (String s : serialNumbers)
            System.out.println(s);
    }
}
