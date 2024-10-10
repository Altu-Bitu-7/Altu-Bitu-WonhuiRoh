package week08_dfs_bfs.necessary;

import java.util.Scanner;

public class P2606_Virus {

    public static int computers;
    public static int networkConnections;
    public static boolean[][] graph;
    public static boolean[] visited;

    public static int infections = 0;

    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);

        computers = sc.nextInt();
        networkConnections = sc.nextInt();
        graph = new boolean[computers+1][computers+1];  // 1부터 시작하도록
        visited = new boolean[computers+1]; // 1부터 시작하도록
        for (int i = 0; i < networkConnections; i++) {
            int c1 = sc.nextInt();
            int c2 = sc.nextInt();

            graph[c1][c2] = true;
            graph[c2][c1] = true;
        }

        // 연산
        int initialComputer = 1;
        visited[initialComputer] = true;
        dfs(initialComputer);

        // 출력
        System.out.println(infections);
    }

    public static void dfs(int computer) {
        for (int i = 1; i <= computers; i++) {
            if (graph[computer][i] && !visited[i]) {
                visited[i] = true;
                infections++;
                dfs(i);
            }
        }
    }
}
