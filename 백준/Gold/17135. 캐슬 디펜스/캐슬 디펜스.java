import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M, D, enemy, answer;
    static int[][] grid;

    static int[] archor = new int[3];

    static int distance(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

    static int castleDefense(int[] team) {
        int[][] situation = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                situation[i][j] = grid[i][j];
            }
        }
        int kill = 0, remain = enemy, turn = 0;
        while (remain > 0 && turn < N) {    // 해당 라운드 시작
        //    System.out.println("========" + turn + "round start!======");
            int start = N - 1 - turn;   // 격자판 맨 밑
            int[][] dist = new int[3][3];
            dist[0][2] = dist[1][2] = dist[2][2] = D + 1;
            for (int i = start; i >= Math.max(start - D, 0); i--) {
                for (int j = 0; j < M; j++) {
                    if (situation[i][j] == 1) {
                        // 거리가 가장 가까운 적을 찾기
                        for (int k = 0; k < 3; k++) {
                            int len = distance(start + 1, archor[k], i, j);
                            if (len < dist[k][2]) {    // <= D && min값보다 작으면
                                dist[k][0] = i;
                                dist[k][1] = j;
                                dist[k][2] = len;
                            }
                            if (len == dist[k][2] && dist[k][1] > j) {  // 가장 왼쪽에 있는 적
                                dist[k][0] = i;
                                dist[k][1] = j;
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < 3; i++) {
                if (dist[i][2] <= D) {
                    if (situation[dist[i][0]][dist[i][1]] == 1) {
                //        System.out.println(
                //            archor[i] + " kills (" + dist[i][0] + "," + dist[i][1] + ")");
                        situation[dist[i][0]][dist[i][1]] = 0;
                        kill++;
                        remain--;
                    }
                }
            }
            // 해당 라운드 끝난 후 궁수 위로 전진 배치(=적 밑으로 이동)
//            System.out.println("-----------" + turn + "round finish!! now----------");
//            System.out.println(
//                "total kill : " + kill + " | " + "remain : "
//                    + remain);
//            for (int i = 0; i <= start; i++) {
//                for (int j = 0; j < M; j++) {
//                    System.out.print(situation[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//            for (int i = 0; i < M; i++) {
//                if (i == archor[0] || i == archor[1] || i == archor[2]) {
//                    System.out.print(1 + " ");
//                } else {
//                    System.out.print(0 + " ");
//                }
//            }
//            System.out.println();
//            System.out.println("------------------------");
            turn++;
        }
        return kill;
    }

    static void placeArcher(int cnt, int idx) {
        if (cnt == 3) {
            //  System.out.println("궁수 위치 : " + archor[0] + ", " + archor[1] + ", " + archor[2]);
            int a = castleDefense(archor);
            // System.out.println("====================  " + a);
            answer = Math.max(answer, a);
            return;
        }

        for (int i = idx; i < M; i++) {
            archor[cnt] = i;
            placeArcher(cnt + 1, i + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        grid = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 1) {
                    enemy++;
                }
            }
        }
        placeArcher(0, 0);
        System.out.println(answer);

    }//

}//