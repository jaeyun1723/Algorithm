import java.util.*;

class Solution {

    static ArrayList<Road>[] list;

    public int dijkstra(int N, int K) {
        int[] dp = new int[N + 1];
        Arrays.fill(dp, 10_000_000);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1[1],o2[1]));
        pq.add(new int[]{1, 0});
        dp[1] = 0;
        boolean[] visited = new boolean[N + 1];
        while (!pq.isEmpty()) {
            int[] now = pq.poll(); // 현재 정점, 최소 거리
            if (dp[now[0]] < now[1]) {
                continue;
            }
            if (!visited[now[0]]) {
                visited[now[0]] = true;
                for (int i = 0; i < list[now[0]].size(); i++) {
                    Road next = list[now[0]].get(i);
                    if (dp[next.dest] > dp[now[0]] + next.cost) {
                        dp[next.dest] = dp[now[0]] + next.cost;
                        pq.add(new int[]{next.dest, dp[now[0]] + next.cost});
                    }
                }
            }
        }
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (dp[i] <= K) {
                count++;
            }
        }
        return count;
    }

    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<Road>();
        }
        for (int[] r : road) {
            list[r[0]].add(new Road(r[1], r[2]));
            list[r[1]].add(new Road(r[0], r[2]));
        }

        return answer = dijkstra(N, K);
    }

    public static class Road {

        int dest;
        int cost;

        public Road(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

    }
}