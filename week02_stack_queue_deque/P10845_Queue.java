package week02_stack_queue_deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P10845_Queue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String cmd = st.nextToken();

            if (cmd.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                q.add(num);
            } else if (cmd.equals("pop")) {
                if (q.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(q.remove());
            } else if (cmd.equals("size")) {
                System.out.println(q.size());
            } else if (cmd.equals("empty")) {
                if (q.isEmpty())
                    System.out.println(1);
                else
                    System.out.println(0);
            } else if (cmd.equals("front")) {
                if (q.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(q.peek());
            } else if (cmd.equals("back")) {// "back"
                if (q.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(((LinkedList<Integer>) q).peekLast());
            }
        }
    }
}
