import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Main {

    static int M, N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static boolean isRipe(int[][] arr) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1[2], o2[2])));

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    pq.add(new int[]{i, j, 0});
                }
            }
        }
        int answer = 0;
        boolean[][] isVisit = new boolean[N][M];
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            answer = Math.max(answer, now[2]);
            if (!isVisit[now[0]][now[1]]) {
                isVisit[now[0]][now[1]] = true;
                for (int i = 0; i < 4; i++) {
                    int nx = now[0] + dx[i];
                    int ny = now[1] + dy[i];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= M || isVisit[nx][ny]) {
                        continue;
                    }
                    if (arr[nx][ny] == 0) {
                        arr[nx][ny] = now[2] + 1;
                        pq.add(new int[]{nx, ny, now[2] + 1});
                    }
                }
            }
        }
        System.out.println(isRipe(arr) ? answer : -1);


    }


}