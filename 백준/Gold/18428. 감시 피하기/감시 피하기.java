import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int N;
    static ArrayList<int[]> xList;
    static ArrayList<int[]> tList;
    static int[] idxList;
    static char[][] map;

    public static boolean up(char[][] arr, int x, int y) {
        while (x >= 0) {
            if (arr[x][y] == 'O') {
                return true;
            }
            if (arr[x][y] == 'S') {
                return false;
            }
            x--;
        }
        return true;
    }

    public static boolean down(char[][] arr, int x, int y) {
        while (x < N) {
            if (arr[x][y] == 'O') {
                return true;
            }
            if (arr[x][y] == 'S') {
                return false;
            }
            x++;
        }
        return true;
    }

    public static boolean left(char[][] arr, int x, int y) {
        while (y >= 0) {
            if (arr[x][y] == 'O') {
                return true;
            }
            if (arr[x][y] == 'S') {
                return false;
            }
            y--;
        }
        return true;
    }

    public static boolean right(char[][] arr, int x, int y) {
        while (y < N) {
            if (arr[x][y] == 'O') {
                return true;
            }
            if (arr[x][y] == 'S') {
                return false;
            }
            y++;
        }
        return true;
    }

    public static char[][] deepCopy(char[][] arr) {
        char[][] tmp = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tmp[i][j] = arr[i][j];
            }
        }
        return tmp;
    }

    public static boolean isFree(char[][] arr) {
        for (int index : idxList) {
            int[] x = xList.get(index);
            arr[x[0]][x[1]] = 'O';
        }
        for (int[] t : tList) {
            int tx = t[0];
            int ty = t[1];
            if (!up(arr, tx - 1, ty) || !down(arr, tx + 1, ty) || !left(arr, tx, ty - 1) || !right(
                arr,
                tx, ty + 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean installObstacle(int idx) {
        if (idx == 3) {
            char[][] arr = deepCopy(map);
            if (isFree(arr)) {
                return true;
            }
            return false;
        }
        for (int i = idx; i < xList.size(); i++) {
            idxList[idx] = i;
            if (installObstacle(idx + 1)) {
                return true;
            }
        }
        return false;
    }

    // 선:T 학:S 장:O
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        map = new char[N][N];
        xList = new ArrayList<>();
        tList = new ArrayList<>();
        idxList = new int[3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if (map[i][j] == 'X') {
                    xList.add(new int[]{i, j});
                }
                if (map[i][j] == 'T') {
                    tList.add(new int[]{i, j});
                }
            }
        }

        if (installObstacle(0)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

}