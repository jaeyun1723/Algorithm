import java.util.*;

class Solution {

    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public int solution(int[][] maps) {
        int answer = -1;
        int n = maps.length;
        int m = maps[0].length;
        Deque<int[]> deq = new ArrayDeque<>();
        boolean[][] isVisited = new boolean[n][m];
        deq.offerLast(new int[]{0, 0, 1}); // x,y,sum 
        isVisited[0][0] = true;
        while (!deq.isEmpty()) {
            int[] now = deq.pollFirst();
            if (now[0] == n - 1 && now[1] == m - 1) {
                answer = (answer == -1) ? now[2] : Math.min(answer, now[2]);
            } else {
                for (int i = 0; i < 4; i++) {
                    int nx = now[0] + dx[i];
                    int ny = now[1] + dy[i];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m || isVisited[nx][ny]) {
                        continue;
                    }
                    if (maps[nx][ny] == 1) {
                        isVisited[nx][ny] = true;
                        deq.offerLast(new int[]{nx, ny, now[2] + 1});
                    }
                }
            }
        }
        return answer;
    }
}