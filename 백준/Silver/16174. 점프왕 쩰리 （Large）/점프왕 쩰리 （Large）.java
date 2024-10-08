import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int N;
    static int[] dx = {0, 1}, dy = {1, 0};

    public static boolean bfs(int[][] board) {
        boolean[][] visited = new boolean[N][N];
        Deque<int[]> deq = new ArrayDeque<>();
        deq.add(new int[]{0, 0});
        visited[0][0] = true;
        while (!deq.isEmpty()) {
            int[] now = deq.pollFirst();
            int len = board[now[0]][now[1]];
            for (int i = 0; i < 2; i++) {
                int nx = now[0] + dx[i] * len;
                int ny = now[1] + dy[i] * len;
                if (nx >= N || ny >= N || visited[nx][ny]) {
                    continue;
                }
                if (nx == N - 1 && ny == N - 1) {
                    return true;
                }
                visited[nx][ny] = true;
                deq.offerLast(new int[]{nx, ny});
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (bfs(board)) {
            System.out.println("HaruHaru");
        } else {
            System.out.println("Hing");
        }
    }

}