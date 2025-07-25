import java.util.*;

class Solution {

    static int n, m;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public void releaseByTruck(String request) {
        char req = request.charAt(0);
        boolean[][] visit = new boolean[n][m];
        Set<Point> set = new HashSet<>();
        Deque<int[]> deq = new ArrayDeque<>();
        deq.add(new int[]{0, 0});
        visit[0][0] = true;
        while (!deq.isEmpty()) {
            int[] now = deq.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx < 0 || nx >= n || ny < 0 | ny >= m || visit[nx][ny]) {
                    continue;
                }
                if (map[nx][ny] == '0') {
                    visit[nx][ny] = true;
                    deq.offerLast(new int[]{nx, ny});
                } else {
                    set.add(new Point(nx, ny));
                }
            }
        }
        for (Point p : set) {
            if (map[p.x][p.y] == req) {
                map[p.x][p.y] = '0';
            }
        }
    }

    public void releaseByCrane(String request) {
        char req = request.charAt(0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == req) {
                    map[i][j] = '0';
                }
            }
        }
    }

    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        n = storage.length + 2;
        m = storage[0].length() + 2;
        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i][0] = '0';
            map[i][m - 1] = '0';
        }
        for (int i = 0; i < m; i++) {
            map[0][i] = '0';
            map[n - 1][i] = '0';
        }
        for (int i = 0; i < storage.length; i++) {
            for (int j = 0; j < storage[i].length(); j++) {
                map[i + 1][j + 1] = storage[i].charAt(j);
            }
        }

        for (String request : requests) {
            if (request.length() == 1) {
                releaseByTruck(request);
            } else {
                releaseByCrane(request);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != '0') {
                    answer++;
                }
            }
        }
        return answer;
    }

    public class Point {

        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Object o) {
            Point p = (Point) o;
            return this.x == p.x && this.y == p.y;
        }

        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}