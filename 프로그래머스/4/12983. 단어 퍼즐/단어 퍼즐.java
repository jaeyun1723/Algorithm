import java.util.*;

class Solution {

    public int solution(String[] strs, String t) {
        int[] dp = new int[t.length() + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < t.length(); i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;
            for (String str : strs) {
                if (t.startsWith(str, i)) {
                    int next = str.length() + i;
                    dp[next] = Math.min(dp[next], dp[i] + 1);
                }
            }
        }

        return dp[t.length()] == Integer.MAX_VALUE ? -1 : dp[t.length()];
    }
}