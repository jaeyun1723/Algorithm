import java.util.*;

class Solution {

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;

        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], 200*100000+1);
            dp[i][i] = 0;
        }

        for (int i = 0; i < fares.length; i++) {
            dp[fares[i][0]][fares[i][1]] = fares[i][2];
            dp[fares[i][1]][fares[i][0]] = fares[i][2];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    dp[j][k] = Math.min(dp[j][k], dp[j][i] + dp[i][k]);
                }
            }
        }
        answer = dp[s][a] + dp[s][b];
        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, dp[s][i] + dp[i][a] + dp[i][b]);
        }
        return answer;
    }


}