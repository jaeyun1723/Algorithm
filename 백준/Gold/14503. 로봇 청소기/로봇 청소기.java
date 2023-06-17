
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, x, y, see;
    static int[][] arr;
    static int[] rx = {0, 0, 1, -1};
    static int[] ry = {1, -1, 0, 0};

    static boolean isClean(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + rx[i];
            int ny = y + ry[i];
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if (arr[nx][ny] == 0) return false;
        }
        return true;
    }

    static boolean isRange(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= M) return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        see = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 0 - 청소 안된 칸
        // 0-북, 1-동, 2-남, 3-서
        int cnt = 0;
        while (true) {
            if (arr[x][y] == 0) {   // 청소되지 않은 경우
                cnt++;
                arr[x][y] = 2;
            }
            if (!isClean(x, y)) {   // 청소되지 않은 빈칸이 있는 경우
                //반시계
                if (see == 0) see = 3;
                else see--;
                //바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
                if (see == 0 && isRange(x - 1, y) && arr[x - 1][y] == 0)
                    x--;
                else if (see == 1 && isRange(x, y + 1) && arr[x][y + 1] == 0)
                    y++;
                else if (see == 2 && isRange(x + 1, y) && arr[x + 1][y] == 0)
                    x++;
                else if (see == 3 && isRange(x, y - 1) && arr[x][y - 1] == 0)
                    y--;
            } else {    // 청소되지 않은 빈 칸이 없는 경우
                if (see == 0 && x + 1 < N && arr[x + 1][y] != 1)  // 북
                    x++;
                else if (see == 1 && y - 1 >= 0 && arr[x][y - 1] != 1) // 동
                    y--;
                else if (see == 2 && x - 1 >= 0 && arr[x - 1][y] != 1) // 남
                    x--;
                else if (see == 3 && y + 1 < M && arr[x][y + 1] != 1) // 서
                    y++;
                else break;
            }
        }
        System.out.println(cnt);
    }//
}//
