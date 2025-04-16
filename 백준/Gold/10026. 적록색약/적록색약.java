import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Main {

    static int N;
    static char[][] grid;

    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static boolean isEqual(char a, char b) {
        if (a != b && (a == 'B' || b == 'B')) {
            return false;
        }
        return true;
    }

    public static void bfs(int x, int y, boolean[][] isVisited, int type) {
        Deque<int[]> deq = new ArrayDeque<>();
        deq.add(new int[]{x, y});
        isVisited[x][y] = true;
        while (!deq.isEmpty()) {
            int[] now = deq.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N || isVisited[nx][ny]) {
                    continue;
                }
                if (type == 0 && grid[x][y] == grid[nx][ny]) {
                    isVisited[nx][ny] = true;
                    deq.offerLast(new int[]{nx, ny});
                }
                if (type == 1 && isEqual(grid[x][y], grid[nx][ny])) {
                    isVisited[nx][ny] = true;
                    deq.offerLast(new int[]{nx, ny});
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        grid = new char[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                grid[i][j] = str.charAt(j);
            }
        }

        boolean[][] isVisited1 = new boolean[N][N];
        boolean[][] isVisited2 = new boolean[N][N];
        int answer1 = 0;
        int answer2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!isVisited1[i][j]) {
                    answer1++;
                    bfs(i, j, isVisited1, 0);
                }
                if (!isVisited2[i][j]) {
                    answer2++;
                    bfs(i, j, isVisited2, 1);
                }
            }
        }

        System.out.println(answer1 + " " + answer2);
    }


}