import java.util.*;

class Solution {

    static String[] map;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int[] start, lever, end;

    public static int bfs(int[] a, char s) {
        int row = map.length;
        int col = map[0].length();
        boolean[][] isVisit = new boolean[row][col];
        Deque<int[]> deq = new ArrayDeque<>();
        deq.add(new int[]{a[0], a[1], 0});
        isVisit[a[0]][a[1]] = true;
        while (!deq.isEmpty()) {
            int[] now = deq.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= row || ny >= col) {
                    continue;
                }
                if (map[nx].charAt(ny) == 'X' || isVisit[nx][ny]) {
                    continue;
                }
                if (map[nx].charAt(ny) != 'X' && !isVisit[nx][ny]) {
                    isVisit[nx][ny] = true;
                    deq.offerLast(new int[]{nx, ny, now[2] + 1});
                }
                if (map[nx].charAt(ny) == s) {
                    return now[2] + 1;
                }
            }
        }
        return -1;
    }

    public int solution(String[] maps) {
        map = maps;
        start = new int[2];
        lever = new int[2];
        end = new int[2];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length(); j++) {
                if (map[i].charAt(j) == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else if (map[i].charAt(j) == 'L') {
                    lever[0] = i;
                    lever[1] = j;
                } else if (map[i].charAt(j) == 'E') {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }
        int sToL = bfs(start, 'L');
        int lToE = bfs(lever, 'E');
        if (sToL == -1 || lToE == -1) {
            return -1;
        }
        return sToL + lToE;
    }
}