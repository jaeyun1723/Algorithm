import java.util.*;

class Solution {

    static char[][] map;
    static int row, col;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static int bfs(int[] start, int[] end) {
        Deque<int[]> deq = new ArrayDeque<>();
        boolean[][] visited = new boolean[row][col];
        visited[start[0]][start[1]] = true;
        deq.add(new int[]{start[0], start[1], 0});
        while (!deq.isEmpty()) {
            int[] now = deq.pollFirst();
            if (now[0] == end[0] && now[1] == end[1]) {
                return now[2];
            }
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx < 0 || nx >= row || ny < 0 || ny >= col || visited[nx][ny]
                    || map[nx][ny] == 'X') {
                    continue;
                }
                visited[nx][ny] = true;
                deq.offerLast(new int[]{nx, ny, now[2] + 1});
            }
        }
        return -1;
    }

    public int solution(String[] maps) {
        int answer = 0;
        row = maps.length;
        col = maps[0].length();
        map = new char[maps.length][maps[0].length()];
        int[] start = new int[2];
        int[] end = new int[2];
        int[] lever = new int[2];
        for (int i = 0; i < row; i++) {
            map[i] = maps[i].toCharArray();
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else if (map[i][j] == 'L') {
                    lever[0] = i;
                    lever[1] = j;
                } else if (map[i][j] == 'E') {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }
        int t1 = bfs(start, lever);
        int t2 = bfs(lever, end);
        if (t1 == -1 || t2 == -1) {
            return -1;
        }
        return answer = t1 + t2;
    }
}