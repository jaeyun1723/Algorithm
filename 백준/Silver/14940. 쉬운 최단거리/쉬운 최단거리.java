import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int[][] answer = new int[n][m];
        int[] start = new int[2];

        for (int i = 0; i < n; i++) {
            Arrays.fill(answer[i], -1);
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    answer[i][j] = 0;
                }
                if (map[i][j] == 2) {
                    start[0] = i;
                    start[1] = j;
                    answer[i][j] = 0;
                }
            }
        }

        boolean[][] isVisit = new boolean[n][m];
        Deque<int[]> deq = new ArrayDeque<>();
        deq.add(new int[]{start[0], start[1], 0});
        isVisit[start[0]][start[1]] = true;

        while (!deq.isEmpty()) {
            int[] now = deq.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || isVisit[nx][ny] || map[nx][ny] == 0) {
                    continue;
                }
                isVisit[nx][ny] = true;
                answer[nx][ny] = now[2] + 1;
                deq.offerLast(new int[]{nx, ny, now[2] + 1});
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }

    }
}