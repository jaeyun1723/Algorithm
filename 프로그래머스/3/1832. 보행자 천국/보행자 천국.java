class Solution {
    int MOD = 20170805;

    public int solution(int m, int n, int[][] cityMap) {

        // dp[i][j] = dp[i][j-1] + dp[i-1][j];
        int[][][] dp = new int[m][n][2]; // 0 : 왼 -> 오 , 1 : 위 -> 아래

        for (int i = 0; i < m; i++) {
            if (cityMap[i][0] != 1) dp[i][0][1] = 1;
            else break;
        }

        for (int i = 0; i < n; i++) {
            if (cityMap[0][i] != 1) dp[0][i][0] = 1;
            else break;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (cityMap[i][j - 1] != 1) {
                    if (cityMap[i][j - 1] == 2) // 왼쪽 -> 오른쪽 표시판
                        dp[i][j][0] = dp[i][j - 1][0];
                    else // 전체
                        dp[i][j][0] = (dp[i][j - 1][0] + dp[i][j - 1][1]) % MOD;
                }
                if (cityMap[i - 1][j] != 1) {
                    if (cityMap[i - 1][j] == 2) // 위 -> 아래 표시판
                        dp[i][j][1] = dp[i - 1][j][1];
                    else // 전체
                        dp[i][j][1] = (dp[i - 1][j][0] + dp[i - 1][j][1]) % MOD;
                }
            }
        }

        return (dp[m - 1][n - 1][0] + dp[m - 1][n - 1][1]) % MOD;
    }
}