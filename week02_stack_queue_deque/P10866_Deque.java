package week02_stack_queue_deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class P10866_Deque {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String cmd = st.nextToken();

            if (cmd.equals("push_front")) {
                int num = Integer.parseInt(st.nextToken());
                deque.addFirst(num);
            } else if (cmd.equals("push_back")) {
                int num = Integer.parseInt(st.nextToken());
                deque.addLast(num);
            } else if (cmd.equals("pop_front")) {
                if (deque.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(deque.removeFirst());
            } else if (cmd.equals("pop_back")) {
                if (deque.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(deque.removeLast());
            } else if (cmd.equals("size")) {
                System.out.println(deque.size());
            } else if (cmd.equals("empty")) {
                if (deque.isEmpty())
                    System.out.println(1);
                else
                    System.out.println(0);
            } else if (cmd.equals("front")) {
                if (deque.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(deque.peekFirst());
            } else { // "back"
                if (deque.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(deque.peekLast());
            }
        }
    }
}
