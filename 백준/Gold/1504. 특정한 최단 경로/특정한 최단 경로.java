import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int INF = 200_000_001;
    static int N, E;
    static ArrayList<Info>[] list;

    public static int dijkstra(int start, int end) {
        int[] distance = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        Arrays.fill(distance, INF);
        distance[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            if (distance[now[0]] < now[1]) {
                continue;
            }
            if (!visited[now[0]]) {
                visited[now[0]] = true;
                for (Info info : list[now[0]]) {
                    if (distance[info.end] > distance[now[0]] + info.distance) {
                        distance[info.end] = distance[now[0]] + info.distance;
                        pq.add(new int[]{info.end, distance[info.end]});
                    }
                }
            }
        }

        return distance[end];

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<Info>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list[u].add(new Info(v, e));
            list[v].add(new Info(u, e));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 1 -> v1 -> v2 -> N
        int res1 = 0;
        res1 += dijkstra(1, v1);
        res1 += dijkstra(v1, v2);
        res1 += dijkstra(v2, N);
        // 1 -> v2 -> v1 -> N
        int res2 = 0;
        res2 += dijkstra(1, v2);
        res2 += dijkstra(v2, v1);
        res2 += dijkstra(v1, N);
        int ans = (res1 >= INF && res2 >= INF) ? -1 : Math.min(res1, res2);
        System.out.println(ans);
    }

    public static class Info {

        int end;
        int distance;

        public Info(int end, int distance) {
            this.end = end;
            this.distance = distance;
        }
    }
}
