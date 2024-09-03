package week02_stack_queue_deque.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class P17298_NextGreaterElement {
    public static void getNGEs(int n, int[] nums) {
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && nums[i] > nums[dq.peek()]) {
                nums[dq.pop()] = nums[i];
            }

            dq.push(i);
        }

        while (!dq.isEmpty()) {
            nums[dq.pop()] = -1;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // JAVA 의 메서드 인자 전달 방법 (2가지)
            // 1. '기본 타입(예: int, char)'을 메서드 인자로 전달할 경우 => 값에 의한 전달(pass by value)
            // 2. '객체 (배열 포함)'를 메서드 인자로 전달할 경우 => 참조에 의한 전달(pass by reference)
        getNGEs(n, nums);   // nums => 배열 => nums 의 '참조'가 전달됨

        // 출력
            // 기존 방법: for 문 안에서 System.out.print() 를 반복적으로 호출함
            // 개선 방법: StringBuilder 를 선언한 후, for 문 안에서는 sb.append() 를 반복적으로 호출하고, System.out.println() 은 마지막에 한 번 호출함
            // 결과: 시간 초과 -> 통과
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(nums[i]).append(" ");
        }

        System.out.println(sb);
    }
}
