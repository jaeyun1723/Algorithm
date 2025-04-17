import java.util.*;

class Solution {

    static ArrayList<Integer>[] list;
    static final int INF = 100001;
    static int[] area;

    public static void dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        boolean[] isVisited = new boolean[area.length];
        pq.add(new int[]{start, 0});
        area[start] = 0;

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            if (area[now[0]] < now[1]) {
                continue;
            }
            if (!isVisited[now[0]]) {
                isVisited[now[0]] = true;
                for (int next : list[now[0]]) {
                    if (area[next] > now[1] + 1) {
                        area[next] = now[1] + 1;
                        pq.add(new int[]{next, now[1] + 1});
                    }
                }
            }
        }
    }

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        list = new ArrayList[n + 1];
        area = new int[n + 1];
        Arrays.fill(area, INF);
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int[] road : roads) {
            list[road[0]].add(road[1]);
            list[road[1]].add(road[0]);
        }

        dijkstra(destination);
        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            answer[i] = (area[sources[i]] == INF) ? -1 : area[sources[i]];
        }
        return answer;
    }
}