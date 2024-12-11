import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[] dy = {-1, 0, 1};
    static int N, M;

    public static int bfs(int k, int[][] map) {
        Deque<int[]> deq = new ArrayDeque<>();
        deq.offerLast(new int[]{0, k, -1, map[0][k]});
        int result = Integer.MAX_VALUE;
        while (!deq.isEmpty()) {
            int[] now = deq.pollFirst();
            if (now[0] == N - 1) {
                result = Math.min(result, now[3]);
                continue;
            }
            int nx = now[0] + 1;
            for (int i = 0; i < 3; i++) {
                if (now[2] == i) continue;
                int ny = now[1] + dy[i];
                if (ny < 0 || ny >= M) continue;
                if (result > now[3] + map[nx][ny]) {
                    deq.offerLast(new int[]{nx, ny, i, now[3] + map[nx][ny]});
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            answer = Math.min(answer, bfs(i, map));
        }
        System.out.println(answer);
    }
}