import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N;

    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static void bfs(int x, int y, int std, int[][] map, boolean[][] isFlood) {
        Deque<int[]> deq = new ArrayDeque<>();
        isFlood[x][y] = true;
        deq.offerLast(new int[]{x, y});
        while (!deq.isEmpty()) {
            int[] now = deq.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N || isFlood[nx][ny]) continue;
                if (map[nx][ny] > std) {
                    isFlood[nx][ny] = true;
                    deq.offerLast(new int[]{nx, ny});
                }
            }
        }
    }

    public static int section(int std, int[][] map) {
        boolean[][] isFlood = new boolean[N][N];
        int zone = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] > std && !isFlood[i][j]) {
                    zone++;
                    bfs(i, j, std, map, isFlood);
                }
            }
        }
        return zone;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];

        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
            }
        }

        int answer = 1;
        for (int i = min; i < max; i++) {
            answer = Math.max(answer, section(i, map));
        }

        System.out.println(answer);
    }
}