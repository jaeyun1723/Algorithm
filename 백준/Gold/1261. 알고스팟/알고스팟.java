import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static int dijkstra(char[][] miro, int N, int M) {
        int[][] dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], 999999);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
        pq.add(new int[]{0, 0, 0});
        dp[0][0] = 0;
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            if (now[0] == N - 1 && now[1] == M - 1) {
                dp[N - 1][M - 1] = Math.min(dp[N - 1][M - 1], now[2]);
                continue;
            }
            if (dp[now[0]][now[1]] < now[2]) continue;
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (miro[nx][ny] == '0' && dp[nx][ny] > now[2]) {
                    dp[nx][ny] = now[2];
                    pq.add(new int[]{nx, ny, now[2]});
                }
                if (miro[nx][ny] == '1' && dp[nx][ny] > now[2] + 1) {
                    dp[nx][ny] = now[2] + 1;
                    pq.add(new int[]{nx, ny, now[2] + 1});
                }
            }
        }
        return dp[N - 1][M - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        char[][] miro = new char[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                miro[i][j] = str.charAt(j);
            }
        }
        System.out.println(dijkstra(miro, N, M));
    }
}