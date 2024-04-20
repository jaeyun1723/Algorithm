import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static int answer = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void bfs(int x, int y, int[][] arr, boolean[][] isVisit) {
        Deque<int[]> deq = new ArrayDeque<>();
        deq.offerLast(new int[]{x, y});
        isVisit[x][y] = true;
        while (!deq.isEmpty()) {
            int[] now = deq.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == 0 || isVisit[nx][ny]) continue;
                isVisit[nx][ny] = true;
                deq.offerLast(new int[]{nx, ny});
            }
        }
    }

    public static void function(int[][] arr) {
        int iceberg = 0;
        int year = 0;
        while (++year > 0) {
            iceberg = 0;
            int[][] next = deepCopy(arr);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] != 0) {
                        int cnt = 0;
                        for (int k = 0; k < 4; k++) {
                            int x = i + dx[k];
                            int y = j + dy[k];
                            if (x < 0 || y < 0 || x >= N || y >= M) continue;
                            if (arr[x][y] == 0) cnt++;
                        }
                        next[i][j] = Math.max(arr[i][j] - cnt, 0);
                    }
                }
            }
            arr = next;
            boolean[][] isVisit = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] != 0 && !isVisit[i][j]) {
                        bfs(i, j, arr, isVisit);
                        iceberg++;
                    }
                }
            }
            if (iceberg == 0) {
                answer = 0;
                return;
            }
            if (iceberg > 1) {
                answer = year;
                return;
            }
        }
    }

    public static int[][] deepCopy(int[][] arr) {
        int[][] tmp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmp[i][j] = arr[i][j];
            }
        }
        return tmp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        function(arr);
        System.out.println(answer);
    }

}