package week06_greedy.necessary;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class GearWheel {
    String state;

    public GearWheel(String state) {
        this.state = state;
    }
}

public class P15662_GearWheels2 {

    public static int T;    // 톱니바퀴 개수
    public static GearWheel[] gearWheels;
    public static int[] directions;

    public static final int N = 0;
    public static final int S = 1;

    public static int K;    // 회전 횟수

    public static final int CLOCKWISE = 1;
    public static final int COUNTER_CLOCKWISE = -1;

    public static final int STATE = 8;
    public static final int RIGHT = 2;
    public static final int LEFT = 6;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        gearWheels = new GearWheel[T];
        for (int i = 0; i < T; i++) {
            String state = br.readLine();
            gearWheels[i] = new GearWheel(state);
        }

        K = Integer.parseInt(br.readLine());

        for (int k = 0; k < K; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int wheelNumber = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());

            directions = new int[T-1];
            for (int i = 0; i < T-1; i++) {
                char gw1Right = gearWheels[i].state.charAt(RIGHT);
                char gw2Left = gearWheels[i+1].state.charAt(LEFT);
                if (gw1Right != gw2Left)
                    directions[i] = -1;
            }

            turnWheel(wheelNumber, direction);
            turnRightWheels(wheelNumber, direction);
            turnLeftWheels(wheelNumber, direction);
        }

        int cnt = 0;
        for (GearWheel gw : gearWheels) {
            if (gw.state.charAt(0) - '0' == S)
                cnt++;
        }

        System.out.println(cnt);
    }

    private static void turnRightWheels(int wheelNumber, int direction) {
        int d = direction;
        // 현재의 오른쪽에 톱니바퀴가 더 있을 경우
        while (wheelNumber < T - 1) {
            // '같은' 톱니 => 더이상 진행 X
            if (directions[wheelNumber] == 0)
                return;

            // 현재 톱니바퀴 방향의 '반대쪽'으로 오른쪽 톱니바퀴 돌리기
            d *= directions[wheelNumber];
            wheelNumber++;
            turnWheel(wheelNumber, d);
        }
    }

    private static void turnLeftWheels(int wheelNumber, int direction) {
        int d = direction;
        // 현재의 왼쪽에 톱니바퀴가 더 있을 경우
        while (wheelNumber > 0) {
            // '같은' 톱니 => 더이상 진행 X
            if (directions[wheelNumber - 1] == 0)
                return;

            // 현재 톱니바퀴 방향의 '반대쪽'으로 왼쪽 톱니바퀴 돌리기
            d *= directions[wheelNumber - 1];
            wheelNumber--;
            turnWheel(wheelNumber, d);
        }
    }

    private static void turnWheel(int wheelNumber, int direction) {
        GearWheel gw = gearWheels[wheelNumber];

        // 시계 방향
        if (direction == CLOCKWISE) {
            char lastChar = gw.state.charAt(STATE - 1);
            String remainingStr = gw.state.substring(0, STATE - 1);
            gw.state = lastChar + remainingStr;
        }
        // 시계 반대 방향
        else if (direction == COUNTER_CLOCKWISE) {
            char firstChar = gw.state.charAt(0);
            String remainingStr = gw.state.substring(1);
            gw.state = remainingStr + firstChar;
        }
    }

}