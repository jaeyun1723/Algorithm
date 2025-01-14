import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int N, K, P, X;
    static int[][] display = { // 시계, 가운데
            {1, 1, 1, 1, 1, 1, 0}, // 0
            {0, 1, 1, 0, 0, 0, 0}, // 1
            {1, 1, 0, 1, 1, 0, 1}, // 2
            {1, 1, 1, 1, 0, 0, 1}, // 3
            {0, 1, 1, 0, 0, 1, 1}, // 4
            {1, 0, 1, 1, 0, 1, 1}, // 5
            {1, 0, 1, 1, 1, 1, 1}, // 6
            {1, 1, 1, 0, 0, 0, 0}, // 7
            {1, 1, 1, 1, 1, 1, 1}, // 8
            {1, 1, 1, 1, 0, 1, 1}, // 9
    };

    public static int[] numToDisplay(int num) {
        int[] tmp = new int[K];
        for (int i = K - 1; i >= 0; i--) {
            tmp[i] = num % 10;
            num /= 10;
        }
        return tmp;
    }

    public static int convertDisplay(int a, int b) {
        int count = 0;
        for (int i = 0; i < 7; i++) {
            if (display[a][i] != display[b][i])
                count++;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 1 ~ N층
        K = Integer.parseInt(st.nextToken()); // K자리
        P = Integer.parseInt(st.nextToken()); // 최대 P개 반전 가능
        X = Integer.parseInt(st.nextToken()); // 현재 X층

        int answer = 0;
        int[] std = numToDisplay(X);

        for (int i = 1; i <= N; i++) {
            if (i == X) continue;
            int[] floor = numToDisplay(i);
            int reverse = 0;
            for (int j = 0; j < K; j++) {
                if (reverse > P) break;
                if (floor[j] != std[j]) {
                    reverse += convertDisplay(floor[j], std[j]);
                }
            }
            if (reverse <= P) {
                answer++;
            }
        }

        System.out.println(answer);
    }

}