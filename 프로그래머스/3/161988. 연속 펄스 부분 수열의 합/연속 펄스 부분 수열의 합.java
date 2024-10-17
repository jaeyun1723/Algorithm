import java.util.*;

class Solution {

    public long solution(int[] sequence) {
        long answer = 0;
        long[][] dp = new long[sequence.length + 1][2];
        int a = 1, b = -1;
        // i번째를 포함했을 때 최댓값
        for (int i = 1; i < dp.length; i++) {
            a *= -1;
            b *= -1;
            dp[i][0] = Math.max(sequence[i - 1] * a, dp[i - 1][0] + sequence[i - 1] * a);
            dp[i][1] = Math.max(sequence[i - 1] * b, dp[i - 1][1] + sequence[i - 1] * b);
            answer = Math.max(answer, Math.max(dp[i][0], dp[i][1]));
        }
        return answer;
    }
}