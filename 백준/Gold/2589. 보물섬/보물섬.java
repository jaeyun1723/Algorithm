import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int R, C, answer;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static char[][] map;

    public static int bfs(int x, int y) {
        boolean[][] visited = new boolean[R][C];
        Deque<int[]> deq = new ArrayDeque<>();
        int cnt = 0;
        deq.offer(new int[]{x, y, 0});
        visited[x][y] = true;

        while (!deq.isEmpty()) {
            int[] now = deq.poll();
            cnt = Math.max(cnt, now[2]);
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == 'W'
                    || visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                deq.offer(new int[]{nx, ny, now[2] + 1});
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'L') {
                    answer = Math.max(answer, bfs(i, j));
                }
            }
        }

        System.out.println(answer);

    }

}