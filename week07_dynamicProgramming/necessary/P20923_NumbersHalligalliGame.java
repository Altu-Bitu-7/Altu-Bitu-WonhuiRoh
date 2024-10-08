package week07_dynamicProgramming.necessary;

import java.util.ArrayDeque;
import java.util.Deque;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class P20923_NumbersHalligalliGame {

    // n: 카드의 개수, m: 게임 진행 횟수
    public static int n, m;

    // 덱
    public static Deque<Integer> dqDodo = new ArrayDeque<>();
    public static Deque<Integer> dqSuyeon = new ArrayDeque<>();

    // 그라운드
    public static Deque<Integer> gdDodo = new ArrayDeque<>();
    public static Deque<Integer> gdSuyeon = new ArrayDeque<>();

    public static String DODO_NAME = "do";
    public static String SUYEON_NAME = "su";

    public static int DODO = -1;
    public static int SUYEON = 1;
    public static int NO_ONE = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int dodo = Integer.parseInt(st.nextToken());
            int suyeon = Integer.parseInt(st.nextToken());

            dqDodo.push(dodo);
            dqSuyeon.push(suyeon);
        }

        String result = playGame();

        System.out.println(result);
    }

    private static String playGame() {
        int turn = DODO;
        int ringer;

        while (m-- > 0) {
            placeCard(turn);

            // 게임 진행 도중 자신의 덱에 있는 카드의 수가 0개가 되었다면 => 상대방이 승리
            if (dqDodo.isEmpty()) {
                return SUYEON_NAME;
            }
            if (dqSuyeon.isEmpty()) {
                return DODO_NAME;
            }

            ringer = ringBell();
            if (ringer != NO_ONE)
                takeCardDummies(ringer);

            turn *= -1;
        }

        if (dqDodo.size() > dqSuyeon.size())
            return DODO_NAME;
        else if (dqDodo.size() < dqSuyeon.size())
            return SUYEON_NAME;
        else
            return DODO_NAME + SUYEON_NAME;
    }

    private static void placeCard(int turn) {
        Deque<Integer> dq = turn == DODO ? dqDodo : dqSuyeon;
        Deque<Integer> gd = turn == DODO ? gdDodo : gdSuyeon;

        gd.push(dq.pop());
    }

    private static int ringBell() {
        // 수연이가 종 치는 경우
        if (!gdDodo.isEmpty() && !gdSuyeon.isEmpty()) {
            if (gdDodo.peek() + gdSuyeon.peek() == 5)
                return SUYEON;
        }

        // 도도가 종 치는 경우
        if (!gdDodo.isEmpty() && gdDodo.peek() == 5 || !gdSuyeon.isEmpty() && gdSuyeon.peek() == 5)
            return DODO;

        return NO_ONE;
    }

    private static void takeCardDummies(int ringer) {
        Deque<Integer> ringerDq = ringer == DODO ? dqDodo : dqSuyeon;
        Deque<Integer> ringerGd = ringer == DODO ? gdDodo : gdSuyeon;
        Deque<Integer> opponentGd = ringer == DODO ? gdSuyeon : gdDodo;

        while (!opponentGd.isEmpty()) {
            ringerDq.addLast(opponentGd.removeLast());
        }
        while (!ringerGd.isEmpty()) {
            ringerDq.addLast(ringerGd.removeLast());
        }
    }
}
