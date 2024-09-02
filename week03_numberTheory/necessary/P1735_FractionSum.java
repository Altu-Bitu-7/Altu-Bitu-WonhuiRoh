package week03_numberTheory.necessary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1735_FractionSum {

    public static int getGcd(int numerator, int denominator) {
        // EX) 18 30 -> 12 18 -> 6 12 -> 0 6
        if (numerator == 0)
            return denominator;

        return getGcd(denominator % numerator, numerator);
    }

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            // 분수 1: a / b
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

            // 분수 2: c / d
        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        // 덧셈 (분자들끼리)
        int numerator = a * d + b * c;
        // 통분 -- 최소공배수 (X), 직접 곱셈 (O)
        int denominator = b * d;

        // 약분 (분모, 분자의 최대공약수)
        int gcd = getGcd(numerator, denominator);

        // 출력
        System.out.println(numerator / gcd + " " + denominator / gcd);
    }
}
