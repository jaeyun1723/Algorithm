import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int N, M;
    static int[][] map;
    static ArrayList<int[]> cloud;
    static int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};

    public static void makeCloud() {
        boolean[][] visited = new boolean[N + 1][N + 1];
        for (int[] c : cloud) {
            visited[c[0]][c[1]] = true;
        }
        cloud = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (!visited[i][j] && map[i][j] >= 2) {
                    cloud.add(new int[]{i, j});
                    map[i][j] -= 2;
                }
            }
        }
    }


    public static void waterCopyBug() {
        for (int[] c : cloud) {
            for (int i = 2; i <= 8; i += 2) {
                int x = c[0] + dx[i];
                int y = c[1] + dy[i];
                if (x < 1 || y < 1 || x > N || y > N || map[x][y] == 0) {
                    continue;
                }
                map[c[0]][c[1]]++;
            }
        }
    }

    public static void move(int d, int s) {
        ArrayList<int[]> moveCloud = new ArrayList<>();
        for (int[] c : cloud) {
            int cx = getDot(c[0], d, s, 1);
            int cy = getDot(c[1], d, s, 2);
            map[cx][cy]++;
            moveCloud.add(new int[]{cx, cy});
        }
        cloud = moveCloud;
    }


    public static int getDot(int x, int d, int s, int c) {
        if (c == 1) {  // 행 좌표
            int nx = (x + dx[d] * s) % N;
            if (nx <= 0) {
                nx += N;  // 1-based에서 음수 처리
            }
            return nx;
        } else {  // 열 좌표
            int ny = (x + dy[d] * s) % N;
            if (ny <= 0) {
                ny += N;  // 1-based에서 음수 처리
            }
            return ny;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        cloud = new ArrayList<>();
        int[][] info = new int[M][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
        }

        cloud.add(new int[]{N, 1});
        cloud.add(new int[]{N, 2});
        cloud.add(new int[]{N - 1, 1});
        cloud.add(new int[]{N - 1, 2});

        for (int i = 0; i < M; i++) {
            move(info[i][0], info[i][1]);
            waterCopyBug();
            makeCloud();
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                answer += map[i][j];
            }
        }
        System.out.println(answer);

    }

}