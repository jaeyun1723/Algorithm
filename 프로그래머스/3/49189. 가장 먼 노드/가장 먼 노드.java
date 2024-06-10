import java.util.*;

class Solution {

    public int solution(int n, int[][] edge) {
        int answer = 0;
        ArrayList<Integer>[] arr = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < edge.length; i++) {
            int[] vertex = edge[i];
            arr[vertex[0]].add(vertex[1]);
            arr[vertex[1]].add(vertex[0]);
        }

        int[] dist = new int[n + 1];
        int max = 0;
        Arrays.fill(dist, Integer.MAX_VALUE);
        Deque<int[]> deq = new ArrayDeque<>();
        deq.offerLast(new int[]{1, 0});
        dist[1] = 0;
        while (!deq.isEmpty()) {
            int[] now = deq.pollFirst();
            for (int i = 0; i < arr[now[0]].size(); i++) {
                if (dist[arr[now[0]].get(i)] > now[1] + 1) {
                    dist[arr[now[0]].get(i)] = now[1] + 1;
                    max = Math.max(max, now[1] + 1);
                    deq.offerLast(new int[]{arr[now[0]].get(i), now[1] + 1});
                }

            }
        }
        for (int i = 1; i <= n; i++) {
            if (max == dist[i]) {
                answer++;
            }
        }
        return answer;
    }
}