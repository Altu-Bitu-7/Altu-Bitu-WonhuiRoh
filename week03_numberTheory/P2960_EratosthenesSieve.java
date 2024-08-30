package week03_numberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2960_EratosthenesSieve {
    public static int getPrime(int n, int k) {
        boolean[] nums = new boolean[n+1];
        nums[0] = true;
        nums[1] = true;

        int cnt = 0;

        for (int i = 2; i <= n; i++) {
            if (nums[i])
                continue;

            for (int j = i; j <= n; j += i) {
                if (nums[j])
                    continue;

                cnt++;
                nums[j] = true;

                if (cnt == k)
                    return j;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int prime = getPrime(n, k);

        System.out.println(prime);
    }
}
