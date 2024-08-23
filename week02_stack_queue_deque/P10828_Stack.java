package week02_stack_queue_deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P10828_Stack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String cmd = sc.next();

            if (cmd.equals("push")) {
                int num = sc.nextInt();
                stack.push(num);
            } else if (cmd.equals("pop")) {
                if (stack.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(stack.pop());
            } else if (cmd.equals("size")) {
                System.out.println(stack.size());
            } else if (cmd.equals("empty")) {
                if (stack.isEmpty())
                    System.out.println(1);
                else
                    System.out.println(0);
            } else {    // "top"
                if (stack.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(stack.peek());
            }
        }
    }
}
