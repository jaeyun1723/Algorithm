import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] tomato = new int[N][M];
        boolean[][] isDone = new boolean[N][M];

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == 1) {
                    pq.add(new int[]{i, j, 0});
                    tomato[i][j] = -2;
                    isDone[i][j] = true;
                }
            }
        }

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M || isDone[nx][ny]) {
                    continue;
                }
                if (tomato[nx][ny] == -1) {
                    continue;
                }
                isDone[nx][ny] = true;
                tomato[nx][ny] = now[2] + 1;
                pq.add(new int[]{nx, ny, now[2] + 1});
            }
        }
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomato[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                answer = Math.max(answer, tomato[i][j]);
            }
        }
        System.out.println(answer);
    }
}