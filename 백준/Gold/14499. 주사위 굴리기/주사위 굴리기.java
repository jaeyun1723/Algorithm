import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {

    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};
    static int[] dice;

    //  2
//4 1 3
//  5
//  6
    public static void diceState(int direction) {
        dice[0] = dice[1];
        switch (direction) {
            case 1: // 동 (1,6) => (4,3)
                dice[1] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[3];
                dice[3] = dice[0];
                break;
            case 2: // 서 (1,6) => (3,4)
                dice[1] = dice[3];
                dice[3] = dice[6];
                dice[6] = dice[4];
                dice[4] = dice[0];
                break;
            case 3: // 남
                dice[1] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[5];
                dice[5] = dice[0];
                break;
            case 4: // 북
                dice[1] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[2];
                dice[2] = dice[0];

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] command = new int[K];

        int[][] map = new int[N][M];

        dice = new int[7];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            command[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < K; i++) {
            int nx = x + dx[command[i]];
            int ny = y + dy[command[i]];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                continue;
            }
            x = nx;
            y = ny;
            diceState(command[i]);
            if (map[nx][ny] == 0) {
                map[nx][ny] = dice[6];
            } else {
                dice[6] = map[nx][ny];
                map[nx][ny] = 0;
            }
            System.out.println(dice[1]);
        }
    }


}