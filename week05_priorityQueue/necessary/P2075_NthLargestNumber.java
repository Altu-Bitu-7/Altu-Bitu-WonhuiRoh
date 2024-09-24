package week05_priorityQueue.necessary;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class P2075_NthLargestNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int x = Integer.parseInt(st.nextToken());
                pq.add(-x); // 마이너스 => 내림차순
            }
        }

        int nthLargestNumber = 0;
        for (int i = 0; i < n; i++) {
            nthLargestNumber = pq.poll();
        }

        System.out.println(-nthLargestNumber);  // 마이너스 => 원래 숫자로 되돌리기
    }
}
