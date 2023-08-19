import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int N, M, start;
    static int[][] matrix;
    static boolean[] isVisit;

    static void dfs(int v) {
        System.out.print(v + " ");
        for (int i = 1; i <= N; i++) {
            if (matrix[v][i] == 1 && !isVisit[i]) {
                isVisit[i] = true;
                dfs(i);
            }
        }
    }

    static void bfs(int start) {
        Deque<Integer> que = new ArrayDeque<>();
        isVisit[start] = true;
        que.offer(start);
        while (!que.isEmpty()) {
            int now = que.poll();
            System.out.print(now + " ");
            for (int i = 1; i <= N; i++) {
                if (matrix[now][i] == 1 && !isVisit[i]) {
                    isVisit[i] = true;
                    que.offer(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        matrix = new int[N + 1][N + 1];
        isVisit = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            matrix[v1][v2] = 1;
            matrix[v2][v1] = 1;
        }

        isVisit[start] = true;
        dfs(start);
        System.out.println();
        Arrays.fill(isVisit, false);
        bfs(start);

    }//

}//