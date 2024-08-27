package week01_sorting_map_set.necessary;

import java.util.HashSet;
import java.util.Scanner;

public class P14425_StringSet {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n, m;
        int cnt = 0;

        n = sc.nextInt();
        m = sc.nextInt();

        HashSet<String> s = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String word = sc.next();
            s.add(word);
        }

        for (int i = 0; i < m; i++) {
            String word = sc.next();
            if (s.contains(word))
                cnt++;
        }

        System.out.println(cnt);
    }
}
