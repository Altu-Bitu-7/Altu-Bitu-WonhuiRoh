package week05_priorityQueue.necessary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P14235_ChristmasPresent {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());

            if (a == 0) {   // 아이들을 만난 경우
                if (pq.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(-pq.poll()); // 내림차순
            } else {    // 거점지를 방문한 경우
                for (int j = 0; j < a; j++) {
                    int presentValue = Integer.parseInt(st.nextToken());
                    pq.add(-presentValue);  // 내림차순
                }
            }
        }
    }
}
