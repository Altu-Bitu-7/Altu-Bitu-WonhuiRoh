package week05_priorityQueue.necessary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2607_SimilarWord {

    public static final int ALPHABETS = 26;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String strA = br.readLine();
        int[] alphaA = new int[ALPHABETS];
        for (int i = 0; i < strA.length(); i++) {
            alphaA[strA.charAt(i) - 'A']++;
        }

        int count = 0;
        for (int i = 1; i < n; i++) {
            String strB = br.readLine();
            int[] alphaB = new int[ALPHABETS];
            for (int j = 0; j < strB.length(); j++) {
                alphaB[strB.charAt(j) - 'A']++;
            }

            int diff = 0;
            for (int j = 0; j < ALPHABETS; j++) {
                if (alphaA[j] != alphaB[j])
                    diff += Math.abs(alphaA[j] - alphaB[j]);
            }

            if (diff == 0 || diff == 1 || diff == 2 && strA.length() == strB.length())
                count++;
        }

        System.out.println(count);
    }
}
