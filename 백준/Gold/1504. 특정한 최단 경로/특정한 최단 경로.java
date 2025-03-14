import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Main {

    static int N;
    static ArrayList<Edge>[] list;
    final static int INF = 1000 * 801;

    public static int[] dijkstra(int start, int end) {
        int[] result = new int[N + 1];
        boolean[] isVisit = new boolean[N + 1];
        Arrays.fill(result, INF);
        result[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        pq.add(new int[]{start, 0});
        while (!pq.isEmpty()) {
            int now[] = pq.poll();
            if (result[now[0]] < now[1]) {
                continue;
            }
            if (!isVisit[now[0]]) {
                isVisit[now[0]] = true;
                for (int i = 0; i < list[now[0]].size(); i++) {
                    Edge next = list[now[0]].get(i);
                    if (result[next.to] > now[1] + next.distance) {
                        result[next.to] = now[1] + next.distance;
                        pq.add(new int[]{next.to, now[1] + next.distance});
                    }
                }
            }
        }
        return result;
    }

    public static boolean isImpossible(int a, int b, int c) {
        return (a == INF || b == INF || c == INF);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<Edge>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Edge(b, c));
            list[b].add(new Edge(a, c));
        }

        st = new StringTokenizer(br.readLine());

        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 1->v1->v2->N && 1->v2->v1->N
        int[] toN = dijkstra(1, N);
        int[] v1ToV2 = dijkstra(v1, v2);
        int[] v2ToV1 = dijkstra(v2, v1);
        int[] v1ToN = dijkstra(v1, N);
        int[] v2ToN = dijkstra(v2, N);
        
        int answer = INF;
        if (!isImpossible(toN[v1], v1ToV2[v2], v2ToN[N])) {
            answer = toN[v1] + v1ToV2[v2] + v2ToN[N];
        }
        if (!isImpossible(toN[v2], v2ToV1[v1], v1ToN[N])) {
            answer = Math.min(answer, toN[v2] + v2ToV1[v1] + v1ToN[N]);
        }
        System.out.println(answer == INF ? -1 : answer);
    }

    public static class Edge {

        int to;
        int distance;

        public Edge(int to, int distance) {
            this.to = to;
            this.distance = distance;
        }
    }
}