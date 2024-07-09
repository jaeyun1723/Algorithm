import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int res = 0, N, M;
    static int[][] arr;

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void bfs(int i, int j) {
        boolean[][] isVisit = new boolean[N][M];
        Deque<int[]> deq = new ArrayDeque<>();
        deq.offerLast(new int[]{i, j, 0});
        isVisit[i][j] = true;
        while (!deq.isEmpty()) {
            int[] now = deq.pollFirst();
            for (int k = 0; k < 8; k++) {
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (isVisit[nx][ny]) continue;
                if (arr[nx][ny] == 1) {
                    res = Math.max(res, now[2] + 1);
                    return;
                } else {
                    deq.offerLast(new int[]{nx, ny, now[2] + 1});
                    isVisit[nx][ny] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) bfs(i, j);
            }
        }
        System.out.println(res);
    }

}