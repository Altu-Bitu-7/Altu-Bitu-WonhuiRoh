package week08_dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1260_DfsAndBfs {

    // N: 정점의 개수, M: 간선의 개수, V: 탐색을 시작할 정점의 번호
    public static int N, M, V;
    public static int[][] vertexes;

    public static boolean[] visited;
    public static StringBuilder sb;

    public static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        vertexes = new int[N + 1][N + 1];   // 1 부터 시작하도록

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            vertexes[n1][n2] = 1;
            vertexes[n2][n1] = 1;
        }

        // 연산 및 출력
        printDfs();
        printBfs();
    }

    public static void printDfs() {
        // 초기화
        visited = new boolean[N+1];
        visited[V] = true;

        sb = new StringBuilder();
        sb.append(V).append(" ");

        int from = V;

        // 연산
        dfs(from);

        // 출력
        System.out.println(sb);
    }

    // dfs() 함수의 재귀호출
    public static void dfs(int from) {
        for (int i = 1; i <= N; i++) {
            if (vertexes[from][i] == 1 && !visited[i]) {
                visited[i] = true;
                sb.append(i).append(" ");

                dfs(i);
            }
        }
    }

    public static void printBfs() {
        // 초기화
        visited = new boolean[N+1];

        sb = new StringBuilder();

        int from = V;

        // 연산
        bfs(from);

        // 출력
        System.out.println(sb);
    }

    public static void bfs(int from) {
        queue.add(from);

        while (!queue.isEmpty()) {
            from = queue.poll();
            sb.append(from).append(" ");
            visited[from] = true;

            for (int i = 1; i <= N; i++) {
                if (vertexes[from][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
