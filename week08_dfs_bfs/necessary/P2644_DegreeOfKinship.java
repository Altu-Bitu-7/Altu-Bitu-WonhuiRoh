package week08_dfs_bfs.necessary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2644_DegreeOfKinship {

    public static int n;    // 전체 사람의 수
    public static int p1, p2;   // 촌수를 계산해야 하는 서로 다른 두 사람의 번호
    public static int m;    // 부모 자식들 간의 관계의 개수
    public static int[][] graph;

    public static int ans = -1;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        p1 = Integer.parseInt(st.nextToken());
        p2 = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        graph = new int[n+1][n+1]; // 1부터 시작하도록
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            graph[parent][child] = 1;   // 부모
            graph[child][parent] = -1;  // 자식
            // 그 외의 관계: 0
        }

        // 연산
        visited = new boolean[n+1]; // 1부터 시작하도록
        visited[p1] = true;
        dfs(p1, 0);

        // 출력
        System.out.println(ans);
    }

    private static void dfs(int from, int kinshipSoFar) {
        if (from == p2) {
            ans = kinshipSoFar;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (graph[from][i] != 0 && !visited[i]) {
                visited[i] = true;
                dfs(i, kinshipSoFar + 1);
            }
        }
    }
}
