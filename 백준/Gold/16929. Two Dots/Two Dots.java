import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;


class Main {

    static int N, M;
    static char[][] dots;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static boolean isCycle(int[] start, int[] now, boolean[][] isVisit, int count) {
        for (int i = 0; i < 4; i++) {
            int nx = now[0] + dx[i];
            int ny = now[1] + dy[i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                continue;
            }
            if (dots[nx][ny] != dots[start[0]][start[1]]) {
                continue;
            }
            if (isVisit[nx][ny]) {
                if (start[0] == nx && start[1] == ny && count >= 4) {
                    return true;
                }
            } else {
                isVisit[nx][ny] = true;
                if (isCycle(start, new int[]{nx, ny}, isVisit, count + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dots = new char[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < M; j++) {
                dots[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int[] start = new int[]{i, j};
                int[] now = new int[]{i, j};
                boolean[][] isVisit = new boolean[N][M];
                isVisit[i][j] = true;
                if (isCycle(start, now, isVisit, 1)) {
                    System.out.println("Yes");
                    return;
                }
            }
        }
        System.out.println("No");
    }


}