import java.util.*;

class Solution {

    static int n, m, idx = 0;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static List<Integer> oils = new ArrayList<>();

    public void bfs(int r, int c, int[][] land, int[][] map, boolean[][] visited) {
        Deque<int[]> deq = new ArrayDeque<>();
        deq.offerLast(new int[]{r, c});
        visited[r][c] = true;
        int result = 1;
        map[r][c] = idx;
        while (!deq.isEmpty()) {
            int[] now = deq.pollFirst();
            for (int i = 0; i < 4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                if (x < 0 || y < 0 || x >= n || y >= m || visited[x][y]) {
                    continue;
                }
                if (land[x][y] == 1) {
                    result++;
                    visited[x][y] = true;
                    deq.offerLast(new int[]{x, y});
                    map[x][y] = idx;
                }
            }
        }
        oils.add(result);
        idx++;
    }

    public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;
        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int j = 0; j < m; j++) {
            int sum = 0;
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (land[i][j] == 1) {
                    if (!visited[i][j]) {
                        bfs(i, j, land, map, visited);
                    }
                    set.add(map[i][j]);
                }
            }
            for (int num : set) {
                sum += oils.get(num);
            }
            answer = Math.max(answer, sum);
        }
        return answer;
    }
}