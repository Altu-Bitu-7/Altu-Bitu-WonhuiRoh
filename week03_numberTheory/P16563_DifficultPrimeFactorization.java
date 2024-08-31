package week03_numberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P16563_DifficultPrimeFactorization {

    public static final int MAX_SIZE = 500_0000;

    public static int[] getPrimes() {
        int[] primes = new int[MAX_SIZE];

        for (int i = 2; i * i < MAX_SIZE; i++) {
            if (primes[i] != 0)
                continue;

            for (int j = i * i; j < MAX_SIZE; j += i) {
                if (primes[j] == 0)
                    primes[j] = i;
            }
        }

        return primes;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] primes = getPrimes();

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            while (primes[num] != 0) {
                sb.append(primes[num]).append(" ");
                num /= primes[num];
            }
            sb.append(num).append("\n");
        }

        System.out.println(sb);
    }
}
