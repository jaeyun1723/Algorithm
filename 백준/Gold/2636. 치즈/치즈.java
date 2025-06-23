import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int R, C, cheese;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int[][] map;

    public static void afterOneHour() {
        boolean[][] isVisited = new boolean[R][C];
        ArrayDeque<int[]> deq = new ArrayDeque<>();
        deq.offerLast(new int[]{0, 0});
        isVisited[0][0] = true;
        while (!deq.isEmpty()) {
            int[] now = deq.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C || isVisited[nx][ny]) {
                    continue;
                }
                isVisited[nx][ny] = true;
                if (map[nx][ny] == 0) {
                    deq.offerLast(new int[]{nx, ny});
                } else {
                    cheese--;
                    map[nx][ny] = 0;
                }
            }
        }

    }

    public static int isMelted() {
        int count = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        cheese = 0;

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    cheese++;
                }
            }
        }

        int hour = 0;
        int lastCheese = 0;

        while (true) {
            if (cheese == 0) {
                break;
            }
            lastCheese = cheese;
            afterOneHour();
            hour++;
        }

        System.out.println(hour);
        System.out.println(lastCheese);
    }

}
