import java.util.*;

class Solution {

    static PriorityQueue<int[]> pq;
    static int[] parent;

    public int find(int n) {
        if (parent[n] == n) {
            return n;
        }
        return parent[n] = find(parent[n]);
    }

    public void union(int a, int b) {
        int p1 = find(a);
        int p2 = find(b);
        if (p1 < p2) {
            parent[p1] = p2;
        } else {
            parent[p2] = p1;
        }
    }

    public int solution(int n, int[][] costs) {
        int answer = 0;
        pq = new PriorityQueue<int[]>((o1, o2) -> Integer.compare(o1[2], o2[2]));
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] cost : costs) {
            pq.offer(cost);
        }

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            if (find(now[0]) != find(now[1])) {
                union(now[0], now[1]);
                answer += now[2];
            }
        }
        return answer;
    }
}