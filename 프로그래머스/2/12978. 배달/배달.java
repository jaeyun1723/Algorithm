import java.util.*;

class Solution {

    public int dijkstra(ArrayList<Road>[] list, int N, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> (Integer.compare(p1[1], p2[1])));
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] isVisited = new boolean[N + 1];
        dist[1] = 0;
        pq.add(new int[]{1, 0});
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            if (now[1] > dist[now[0]]) {
                continue; // 이거 왜 필요한지 모르겠음.
            }
            if (now[1] > K) {
                continue;
            }
            if (!isVisited[now[0]]) { // boolean이 필요한가? pq이기 때문에 boolean이필요한가? pq로 인해서 한번도착한 곳은 무조건 가까운 것이 보장되니까?
                isVisited[now[0]] = true;
                for (int i = 0; i < list[now[0]].size(); i++) {
                    Road next = list[now[0]].get(i); // 여기서 visited봐야하나?
                    if (dist[next.dest] > now[1] + next.len) { // > 괄호가 맞나? = 은 생각안해도되나
                        dist[next.dest] = now[1] + next.len;
                        pq.add(new int[]{next.dest, now[1] + next.len});
                    }
                }
            }
        }
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                count++;
            }
        }
        return count;

    }

    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        ArrayList<Road>[] list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int[] r : road) {
            list[r[0]].add(new Road(r[1], r[2]));
            list[r[1]].add(new Road(r[0], r[2]));
        }
        return answer = dijkstra(list, N, K);
    }

    public class Road {

        int dest;
        int len;

        public Road(int dest, int len) {
            this.dest = dest;
            this.len = len;
        }
    }
}