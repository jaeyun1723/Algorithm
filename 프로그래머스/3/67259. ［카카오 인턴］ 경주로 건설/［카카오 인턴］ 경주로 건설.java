import java.util.*;

class Solution {

    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1}; // 상,하,좌,우
    static int N;
    static int[][] map;

    public int bfs() {
        int ans = Integer.MAX_VALUE;
        int[][][] dp = new int[N][N][4];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 4; k++) {
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        Deque<int[]> deq = new ArrayDeque<>();
        deq.add(new int[]{0, 0, -1, 0});
        while (!deq.isEmpty()) {
            int[] now = deq.poll();
            if (now[0] == N - 1 && now[1] == N - 1) {
                ans = Math.min(ans, now[3]);
            }
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                int cost = now[3];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] == 1) {
                    continue;
                }
                if (now[2] == i || now[2] == -1) {
                    cost += 100;
                } else {
                    cost += 600;
                }
                if (dp[nx][ny][i] >= cost) {
                    dp[nx][ny][i] = cost;
                    deq.add(new int[]{nx, ny, i, cost});
                }
            }
        }
        return ans;
    }

    public int solution(int[][] board) {
        map = board.clone();
        N = board.length;
        return bfs();
    }
}