import java.util.*;

class Solution {

    public static ArrayList<Integer>[] list; // 조직도
    public static int[] sale;
    public static int[][] dp = new int[300001][2];

    // dp[idx][0] → idx번 팀장이 회의에 **참석하지 않을 때**의 최소 비용
    // dp[idx][1] → idx번 팀장이 회의에 **참석할 때**의 최소 비용
    public static void dfs(int[] sales, int idx) {
        dp[idx][0] = 0;
        dp[idx][1] = sales[idx - 1];

        if (list[idx].isEmpty()) {
            return;
        }
        int extra = Integer.MAX_VALUE;
        for (int child : list[idx]) {
            dfs(sales, child);

            if (dp[child][0] < dp[child][1]) { //자식이 참석 안해도 되는 것이 더 싸면
                dp[idx][0] += dp[child][0];
                dp[idx][1] += dp[child][0];
                extra = Math.min(extra, dp[child][1] - dp[child][0]);
            } else {
                dp[idx][0] += dp[child][1];
                dp[idx][1] += dp[child][1];
                extra = 0;
            }
        }
        dp[idx][0] += extra;
        return;
    }

    public int solution(int[] sales, int[][] links) {
        int answer = 0;
        int size = sales.length + 1;
        list = new ArrayList[size];
        sale = new int[size];
        for (int i = 1; i < size; i++) {
            sale[i] = sales[i - 1];
        }
        for (int i = 1; i < size; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < links.length; i++) {
            list[links[i][0]].add(links[i][1]);
        }
        dfs(sales, 1);
        answer = Math.min(dp[1][0], dp[1][1]);
        return answer;
    }
}