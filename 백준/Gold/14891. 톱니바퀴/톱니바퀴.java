import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static int sixth(int[][] map, int[] std, int num) {
        // 0 - 7  5 -> 3
        return map[num][(std[num] + 6) % 8];
    }

    public static int second(int[][] map, int[] std, int num) {
        return map[num][(std[num] + 2) % 8];
    }

    public static void cw(int[] std, int num) {
        std[num] = (std[num] + 7) % 8;
    }

    public static void ccw(int[] std, int num) {
        std[num] = (std[num] + 1) % 8;
    }

    public static void rotate(int[][] map, int num, int dir, int[] std, boolean[] visited) {
        visited[num] = true;
        // 회전하기 전 극이 다르면 회전 방향과 반대
        // 1 : 시계 -1 : 반시계
        if (num - 1 >= 0 && !visited[num - 1]) { // 좌
            if (second(map, std, num - 1) != sixth(map, std, num)) {
                rotate(map, num - 1, -dir, std, visited);
            }
        }
        if (num + 1 < 4 && !visited[num + 1]) { // 우
            if (second(map, std, num) != sixth(map, std, num + 1)) {
                rotate(map, num + 1, -dir, std, visited);
            }
        }
        if (dir == 1) cw(std, num);
        else ccw(std, num);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] map = new int[4][8];
        int[] std = new int[4];
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < 8; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            boolean[] visited = new boolean[4];
            rotate(map, num - 1, dir, std, visited); // 0-based
        }

        int res = 0;
        for (int i = 0; i < 4; i++) {
            if (map[i][std[i]] == 1)
                res += (int) Math.pow(2, i);
        }
        System.out.println(res);
    }
}