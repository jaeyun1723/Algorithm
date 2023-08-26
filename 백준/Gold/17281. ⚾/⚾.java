import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static int N;
    static int[] sequence = new int[10];
    static int[][] playerInfo;
    static int answer, now;
    static boolean[] isPlayer = new boolean[10];

    static int inning(int idx) {
        int score, out;
        score = out = 0;
        boolean[] base = new boolean[4];
        while (out < 3) {
            now = now <= 9 ? now : 1;
            int result = playerInfo[idx][sequence[now++]];
            if (result == 0) {
                out++;
            } else {
                base[0] = true;
                for (int i = 3; i >= 0; i--) {
                    if (!base[i]) {
                        continue;
                    }
                    base[i] = false;
                    if (i + result >= 4) {
                        score++;
                    } else {
                        base[i + result] = true;
                    }
                }
            }

        }
        return score;
    }

    static int gameStart() {
        int score = 0;
        for (int i = 1; i <= N; i++) {
            score += inning(i);
        }
        return score;
    }

    static void arrangePlayer(int cnt) {
        // 1. 타자 순서 정하기
        if (cnt == 4) {
            sequence[cnt] = 1;
            arrangePlayer(cnt + 1);
        }
        if (cnt == 10) {
            // 2. 게임 시작
            now = 1;
            answer = Math.max(answer, gameStart());
            return;
        }
        for (int i = 2; i <= 9; i++) {  // 2번 선수~9번선수
            if (isPlayer[i]) {
                continue;
            }
            isPlayer[i] = true;
            sequence[cnt] = i;
            arrangePlayer(cnt + 1);
            isPlayer[i] = false;

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        playerInfo = new int[N + 1][10];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                playerInfo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        isPlayer[1] = true;
        arrangePlayer(1);
        System.out.println(answer);
    }

}