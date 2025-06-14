import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n, m, h, answer;
    private static int[][] map;
    private static boolean finish = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 세로선 수
        m = Integer.parseInt(st.nextToken()); // 가로선 수
        h = Integer.parseInt(st.nextToken()); // 가로줄 수

        map = new int[h][n]; // 0-index: h행, n열

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1; // 행
            int y = Integer.parseInt(st.nextToken()) - 1; // 열
            map[x][y] = 1;
            map[x][y + 1] = 2;
        }

        for (int i = 0; i <= 3; i++) {
            answer = i;
            dfs(0, 0);
            if (finish) break;
        }

        System.out.println(finish ? answer : -1);
    }

    private static void dfs(int x, int count) {
        if (finish) return;
        if (answer == count) {
            if (check()) finish = true;
            return;
        }

        for (int i = x; i < h; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (map[i][j] == 0 && map[i][j + 1] == 0) {
                    map[i][j] = 1;
                    map[i][j + 1] = 2;
                    dfs(i, count + 1);
                    map[i][j] = map[i][j + 1] = 0;
                }
            }
        }
    }

    private static boolean check() {
        for (int i = 0; i < n; i++) {
            int x = 0, y = i;
            for (int j = 0; j < h; j++) {
                if (map[x][y] == 1) y++;
                else if (map[x][y] == 2) y--;
                x++;
            }
            if (y != i) return false;
        }
        return true;
    }
}
