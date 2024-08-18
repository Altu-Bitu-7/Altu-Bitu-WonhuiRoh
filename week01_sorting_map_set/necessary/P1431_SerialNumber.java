package week01_sorting_map_set.necessary;

import java.util.Arrays;
import java.util.Scanner;

public class P1431_SerialNumber {
    public static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] serialNumbers;

        N = sc.nextInt();
        serialNumbers = new String[N];

        for (int i = 0; i < N; i++)
            serialNumbers[i] = sc.next();

        Arrays.sort(serialNumbers, (o1, o2) -> {
            int sumO1 = 0, sumO2 = 0;

            if (o1.length() < o2.length())
                return -1;
            else if (o1.length() > o2.length())
                return 1;
            else {
                String intStrO1 = o1.replaceAll("[^0-9]", "");
                String intStrO2 = o2.replaceAll("[^0-9]", "");

                for (int i = 0; i < intStrO1.length(); i++)
                    sumO1 += Character.getNumericValue(intStrO1.charAt(i));
                for (int i = 0; i < intStrO2.length(); i++)
                    sumO2 += Character.getNumericValue(intStrO2.charAt(i));

                if (sumO1 < sumO2)
                    return -1;
                else if (sumO1 > sumO2)
                    return 1;
                else
                    return o1.compareTo(o2);
            }
        });

        for (String s : serialNumbers)
            System.out.println(s);
    }
}
