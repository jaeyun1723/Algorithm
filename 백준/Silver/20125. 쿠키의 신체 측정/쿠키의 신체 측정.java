import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        char[][] map = new char[N + 1][N + 1];

        int[] head = new int[2];
        int[] heart = new int[2];
        boolean flag = false;

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= N; j++) {
                map[i][j] = str.charAt(j - 1);
                if (map[i][j] == '*' && !flag) {
                    head[0] = i;
                    head[1] = j;
                    heart[0] = i + 1;
                    heart[1] = j;
                    flag = true;
                }
            }
        }

        int lArm = 0;
        int rArm = 0;
        int waist = 0;
        int lLeg = 0;
        int rLeg = 0;
        for (int i = heart[1] - 1; i >= 1; i--) {
            if (map[heart[0]][i] == '*') {
                lArm++;
            } else {
                break;
            }
        }
        for (int i = heart[1] + 1; i <= N; i++) {
            if (map[heart[0]][i] == '*') {
                rArm++;
            } else {
                break;
            }
        }
        int legIdx = 0;
        for (int i = heart[0] + 1; i <= N; i++) {
            if (map[i][heart[1]] == '*') {
                waist++;
                legIdx = i;
            } else {
                break;
            }
        }
        // x 가변 y 불변
        for (int i = legIdx + 1; i <= N; i++) {
            if (map[i][heart[1] - 1] == '*') {
                lLeg++;
            } else {
                break;
            }
        }

        for (int i = legIdx + 1; i <= N; i++) {
            if (map[i][heart[1] + 1] == '*') {
                rLeg++;
            } else {
                break;
            }
        }

        System.out.println(heart[0] + " " + heart[1]);
        System.out.println(lArm + " " + rArm + " " + waist + " " + lLeg + " " + rLeg);
    }
}