import java.util.*;

class Solution {

    static int row, col;
    static int[] oil;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static void bfs(int x, int y, int[][] land, boolean[][] isVisit) {
        int count = 1;
        Deque<int[]> deq = new ArrayDeque<>();
        HashSet<Integer> set = new HashSet<>();
        deq.add(new int[]{x, y});
        set.add(y);
        isVisit[x][y] = true;
        while (!deq.isEmpty()) {
            int[] now = deq.poll();
            set.add(now[1]);
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx < 0 || nx >= row || ny < 0 || ny >= col || isVisit[nx][ny]) {
                    continue;
                }
                if (land[nx][ny] == 1) {
                    isVisit[nx][ny] = true;
                    count++;
                    deq.add(new int[]{nx, ny});
                }
            }
        }
        for (int c : set) {
            oil[c] += count;
        }
    }

    public int solution(int[][] land) {
        int answer = 0;
        row = land.length;
        col = land[0].length;
        boolean[][] isVisit = new boolean[row][col];
        oil = new int[col];
        int label = 2;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (land[i][j] == 1 && !isVisit[i][j]) {
                    bfs(i, j, land, isVisit);
                }
            }
        }

        for (int o : oil) {
            answer = Math.max(answer, o);
        }
        return answer;
    }
}