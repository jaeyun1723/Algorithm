import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;


public class Main {

    static int M, N;
    static int[][] arr;
    static boolean[][] isVisit;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static int bfs(int x, int y) {
        int result = 1;
        Deque<int[]> deq = new ArrayDeque<>();
        deq.add(new int[]{x, y});
        isVisit[x][y] = true;
        while (!deq.isEmpty()) {
            int[] now = deq.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= M || ny >= N || arr[nx][ny] == 1 || isVisit[nx][ny]) continue;
                isVisit[nx][ny] = true;
                result++;
                deq.offerLast(new int[]{nx, ny});
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            for (int x = r1; x < r2; x++) {
                for (int y = c1; y < c2; y++){
                    arr[x][y] = 1;
                }
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 0;
        isVisit = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 0 && !isVisit[i][j]) {
                    count++;
                    pq.add(bfs(i, j));
                }
            }
        }
        System.out.println(count);
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
    }
}