package week02_stack_queue_deque.necessary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class P4949_WellBalancedWorld {

    public static Map<Character, Character> map = new HashMap<>() {
        {
            put(')', '(');
            put(']', '[');
        }
    };

    public static boolean isBalancedString(String str) {
        Deque<Character> dq = new ArrayDeque<>();

        for (char c : str.toCharArray()) {
            if (c == '.')
                break;

            switch (c) {
                case '(':
                case '[':
                    dq.push(c);
                    break;
                case ')':
                case ']':
                    if (dq.isEmpty() || dq.peek() != map.get(c))
                        return false;

                    dq.pop();
                    break;
            }
        }

        return dq.isEmpty();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = br.readLine();
            if (str.equals("."))
                return;

            if (isBalancedString(str))
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
}
