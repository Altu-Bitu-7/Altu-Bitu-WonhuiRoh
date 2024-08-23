package week02_stack_queue_deque.necessary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class P1158_JosephusProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        Queue<Integer> d = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++)
            d.add(i);

        while (!d.isEmpty()) {
            for (int i = 1; i < k; i++)
                d.add(d.remove());

            if (d.size() > 1)
                sb.append(d.remove()).append(", ");
            else
                sb.append(d.remove()).append(">");
        }

        System.out.println(sb);
    }
}
