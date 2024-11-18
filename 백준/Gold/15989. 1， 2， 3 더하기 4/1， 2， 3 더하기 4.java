import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        int[][] dp = new int[10001][4];
        // dp[n][x] : 임의의 정수 n이 x로 끝나는 방법 수
        dp[1][1] = 1; // 1

        dp[2][1] = 1; // 1 + 1
        dp[2][2] = 1; // 2

        dp[3][1] = 1; // 1+1+1
        dp[3][2] = 1; // 1+2
        dp[3][3] = 1; // 3

        for (int i = 4; i <= 10000; i++) {
            dp[i][1] = dp[i - 1][1]; // i = i-1 + 1
            dp[i][2] = dp[i - 2][1] + dp[i - 2][2]; // i = i-2의 경우의 수 + 2
            dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3]; // i = i-3의 경우의 수 + 3
        }

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            System.out.println(dp[num][1] + dp[num][2] + dp[num][3]);
        }
    }
}