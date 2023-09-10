import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;


public class Main {

    static int N, M, answer = Integer.MAX_VALUE;
    static int[][] lab, actVir;
    static ArrayList<int[]> virus;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    static int[][] deepCopy(int[][] original) {
        int[][] copy = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copy[i][j] = original[i][j];
            }
        }
        return copy;
    }

    static boolean isFull(int[][] arr) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    static void bfs() {
        boolean[][] isVisited = new boolean[N][N];
        Deque<int[]> deq = new ArrayDeque<>();
        int[][] tmp = deepCopy(lab);
        for (int i = 0; i < virus.size(); i++) {
            int[] inact = virus.get(i);
            tmp[inact[0]][inact[1]] = -1;
        }
        for (int i = 0; i < actVir.length; i++) {
            deq.offerLast(new int[]{actVir[i][0], actVir[i][1], 0});
            isVisited[actVir[i][0]][actVir[i][1]] = true;
        }
        int sec = 0;
        while (!deq.isEmpty()) {
            int[] now = deq.pollFirst();
            sec = Math.max(sec, now[2]);
            for (int i = 0; i < 4; i++) {
                int[] next = new int[]{now[0] + dx[i], now[1] + dy[i]};
                if (next[0] < 0 || next[1] < 0 || next[0] >= N || next[1] >= N
                    || isVisited[next[0]][next[1]]
                    || tmp[next[0]][next[1]] > 0) {
                    continue;
                }
                if (isFull(tmp)) {
                    break;
                }
                isVisited[next[0]][next[1]] = true;
                tmp[next[0]][next[1]] = now[2] + 1;
                deq.offerLast(new int[]{next[0], next[1], now[2] + 1});
            }
        }
        if (isFull(tmp)) {
            answer = Math.min(answer, sec);
        }
    }

    static void activeVirus(int cnt, int idx) {
        if (cnt == M) {
            bfs();
            return;
        }
        for (int i = idx; i < virus.size(); i++) {
            actVir[cnt] = virus.get(i);
            activeVirus(cnt + 1, i + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lab = new int[N][N];
        actVir = new int[M][2];
        virus = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 2) {
                    virus.add(new int[]{i, j});
                }
            }
        }
        activeVirus(0, 0);
        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }//

}//