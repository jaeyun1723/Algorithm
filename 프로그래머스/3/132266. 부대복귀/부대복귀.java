import java.util.*;

class Solution {

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        int[] dp = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        ArrayList<Integer>[] list = new ArrayList[n + 1];
        for (int i = 1; i < list.length; i++) {
            list[i] = new ArrayList<>();
            dp[i] = Integer.MAX_VALUE;
        }
        for (int[] road : roads) {
            list[road[0]].add(road[1]);
            list[road[1]].add(road[0]);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        pq.add(new int[]{destination, 0});
        dp[destination] = 0;

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            if (dp[now[0]] < now[1]) {
                continue;
            }
            if (!visited[now[0]]) {
                visited[now[0]] = true;
                for (int next : list[now[0]]) {
                    if (!visited[next] && dp[next] > dp[now[0]] + 1) {
                        dp[next] = dp[now[0]] + 1;
                        pq.add(new int[]{next, dp[next]});
                    }
                }
            }
        }

        for (int i = 0; i < sources.length; i++) {
            if (dp[sources[i]] == Integer.MAX_VALUE) {
                answer[i] = -1;
            } else {
                answer[i] = dp[sources[i]];
            }
        }
        return answer;
    }
}