import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static String[] str;
    static int h;

    // D U R L

    // 1. 접어서 같은 애들끼리 모으기
    // 2. 뚫린 곳이 4분면 중 어디인지 찾기
    static void fold(int x1, int y1, int x2, int y2, int cnt) {
        if (cnt == str.length) {
            if (h == 0) {
                arr[x1][y1] = 1;
            } else if (h == 1) {
                arr[x1][y2] = 1;
            } else if (h == 2) {
                arr[x2][y1] = 1;
            } else if (h == 3) {
                arr[x2][y2] = 1;
            }
            return;
        }
        int xMid = (x1 + x2) / 2;
        int yMid = (y1 + y2) / 2;
        if (str[cnt].equals("D")) {
            fold(xMid + 1, y1, x2, y2, cnt + 1);
            for (int i = 0; i <= (x2 - x1) / 2; i++) {
                for (int j = y1; j <= y2; j++) {
                    arr[x1 + i][j] = arr[x2 - i][j];
                }
            }
        } else if (str[cnt].equals("U")) {
            fold(x1, y1, xMid, y2, cnt + 1);
            for (int i = 0; i <= (x2 - x1) / 2; i++) {
                for (int j = y1; j <= y2; j++) {
                    arr[x2 - i][j] = arr[x1 + i][j];
                }
            }
        } else if (str[cnt].equals("L")) {
            fold(x1, y1, x2, yMid, cnt + 1);
            for (int i = x1; i <= x2; i++) {
                for (int j = 0; j <= (y2 - y1) / 2; j++) {
                    arr[i][y2 - j] = arr[i][y1 + j];
                }
            }
        } else if (str[cnt].equals("R")) {
            fold(x1, yMid + 1, x2, y2, cnt + 1);
            for (int i = x1; i <= x2; i++) {
                for (int j = 0; j <= (y2 - y1) / 2; j++) {
                    arr[i][y1 + j] = arr[i][y2 - j];
                }
            }
        }
    }

    static int convert(int x, int y) {
        if (arr[x][y] == 1) {
            return 0;
        }
        if (arr[x][y + 1] == 1) {
            return 1;
        }
        if (arr[x + 1][y] == 1) {
            return 2;
        }
        if (arr[x + 1][y + 1] == 1) {
            return 3;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        arr = new int[(int) Math.pow(2, k + 1)][(int) Math.pow(2, k + 1)];
        str = new String[2 * k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * k; i++) {
            str[i] = st.nextToken();
        }
        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        int num = 0;
        fold(0, 0, arr.length - 1, arr.length - 1, 0);
        for (int i = 0; i < arr.length; i += 2) {
            for (int j = 0; j < arr.length; j += 2) {
                System.out.print(convert(i,j)+" ");
            }
            System.out.println();
        }
    }

}