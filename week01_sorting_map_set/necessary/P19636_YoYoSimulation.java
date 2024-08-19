package week01_sorting_map_set.necessary;

import java.util.Scanner;

public class P19636_YoYoSimulation {

    // W0: 다이어트 전 체중
    // I0: 다이어트 전 일일 에너지 섭취량 및 일일 기초 대사량
    // T: 기초 대사량 변화 역치
    public static int W0, I0, T;
    // D: 다이어트 기간
    // I: 다이어트 기간 일일 에너지 섭취량
    // A: 다이어트 기간 일일 활동 대사량
    public static int D, I, A;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        W0 = sc.nextInt();
        I0 = sc.nextInt();
        T = sc.nextInt();

        D = sc.nextInt();
        I = sc.nextInt();
        A = sc.nextInt();

        // W: 다이어트 후 예상 체중
        // Bmr: 다이어트 후 일일 기초 대사량
        int W, Bmr;
        boolean isDead = false;

        // 1. 일일 기초 대사량의 변화를 고려하지 않았을 때의 다이어트
        W = W0;
        Bmr = I0;   // 일일 기초 대사량의 변화에 대한 고려 X

        for (int i = 0; i < D; i++) {
            // C: 일일 에너지 소비량
            int C = Bmr + A;

            // 체중의 변화
            W += I - C;

            if (W <= 0 || Bmr <= 0) {
                isDead = true;
                break;
            }
        }

        // 출력 1
        if (isDead)
            System.out.println("Danger Diet");
        else
            System.out.println(W + " " + Bmr);

        // 2. 일일 기초 대사량의 변화를 고려했을 때의 다이어트
        W = W0;
        Bmr = I0;
        isDead = false;

        for (int i = 0; i < D; i++) {
            // C: 일일 에너지 소비량
            int C = Bmr + A;

            // 체중의 변화
            W += I - C;

            // 일일 기초 대사량의 변화
            if (Math.abs(I - C) > T)
                Bmr += Math.floorDiv(I - C, 2);

            if (W <= 0 || Bmr <= 0) {
                isDead = true;
                break;
            }
        }

        // 출력 2
        if (isDead)
            System.out.println("Danger Diet");
        else {
            System.out.print(W + " " + Bmr + " ");

            // 3. 변화한 일일 기초 대사량을 가지고 다이어트 전 일일 에너지 섭취량과 다이어트 전 일일 활동 대사량으로 돌아갔을 때

            // A0: 다이어트 전 일일 활동 대사량
            int A0 = 0;

            // C: 일일 에너지 소비량
            int C = Bmr + A0;

            int changeInW = I0 - C;
            if (changeInW > 0)
                System.out.println("YOYO");
            else
                System.out.println("NO");
        }
    }
}
