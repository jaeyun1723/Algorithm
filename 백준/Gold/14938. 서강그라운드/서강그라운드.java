import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int n, m, r;
    static int[] area;
    static ArrayList<Road>[] path;

    public static int dijkstra(int start) {
        int[] distance = new int[n + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        boolean[] isVisit = new boolean[n + 1];
        Arrays.fill(distance, 9999999);
        distance[start] = 0;
        pq.add(new int[]{start, 0});
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            if (distance[now[0]] < now[1]) continue;
            if (isVisit[now[0]]) continue;
            isVisit[now[0]] = true;
            for (int i = 0; i < path[now[0]].size(); i++) {
                Road r = path[now[0]].get(i);
                if (distance[r.to] > distance[now[0]] + r.len) {
                    distance[r.to] = distance[now[0]] + r.len;
                    pq.add(new int[]{r.to, distance[now[0]] + r.len});
                }
            }
        }
        int result = 0;
        for (int i = 1; i <= n; i++)
            if (distance[i] <= m) result += area[i];
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        area = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            area[i] = Integer.parseInt(st.nextToken());
        }

        path = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            path[i] = new ArrayList<Road>();
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            path[a1].add(new Road(a1, a2, len));
            path[a2].add(new Road(a2, a1, len));
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, dijkstra(i));
        }

        System.out.println(answer);


    }

    public static class Road {
        int from;
        int to;
        int len;

        public Road(int from, int to, int len) {
            this.from = from;
            this.to = to;
            this.len = len;
        }
    }
}