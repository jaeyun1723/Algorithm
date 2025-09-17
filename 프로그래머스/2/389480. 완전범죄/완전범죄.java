import java.util.*;

class Solution {

    public int solution(int[][] info, int n, int m) {
        // dp[i][b] = i번째 물건까지 고려했을 때, B의 흔적 합이 b일 때 가능한 최소 A 흔적.
        int size = info.length;
        int INF = 1000000;
        int[][] dp = new int[size + 1][m];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], INF);
        }

        dp[0][0] = 0;

        for (int i = 1; i <= size; i++) {
            int a = info[i - 1][0];
            int b = info[i - 1][1];
            for (int j = 0; j < m; j++) {
                if (dp[i - 1][j] == INF) {
                    continue;
                }
                // A가 훔칠 경우,
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + a);
                // B가 훔칠 경우,
                if (j + b < m) {
                    dp[i][j + b] = Math.min(dp[i][j + b], dp[i - 1][j]);
                }
            }
        }
        int answer = INF;
        for (int i = 0; i < m; i++) {
            answer = Math.min(answer, dp[size][i]);
        }
        return answer = answer >= n ? -1 : answer;
    }
}
