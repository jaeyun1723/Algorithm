import java.util.*;

class Solution {

    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0}; // 우 하 좌 상

    public static int bfs(int[][] board) {
        int res = Integer.MAX_VALUE;
        int size = board.length;
        int[][][] dp = new int[size][size][4];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < 4; k++) {
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        Deque<int[]> deq = new ArrayDeque<>();
        deq.add(new int[]{0, 0, 0, 0});
        deq.add(new int[]{0, 0, 0, 1});

        while (!deq.isEmpty()) {
            int[] now = deq.pollFirst();
            if (now[0] == size - 1 && now[1] == size - 1) {
                res = Math.min(res, now[2]);
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= size || ny >= size) {
                    continue;
                }
                if (board[nx][ny] == 0) {
                    // 직선 방향이 같고, 최솟값이면 가라
                    if (now[3] == i && now[2] + 100 < dp[nx][ny][i]) {
                        dp[nx][ny][i] = now[2] + 100;
                        deq.offerLast(new int[]{nx, ny, now[2] + 100, i});
                    } else if (now[3] != i && now[2] + 600 < dp[nx][ny][i]) {
                        dp[nx][ny][i] = now[2] + 600;
                        deq.offerLast(new int[]{nx, ny, now[2] + 600, i});
                    }
                }
            }
        }
        return res;
    }

    public int solution(int[][] board) {
        int size = board.length;
        int[][][] dp = new int[size][size][4];
        Deque<int[]> deq = new ArrayDeque<>();

        return bfs(board);
    }
}