import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    public static void dijkstra(int[] dist, ArrayList<Road>[] list, int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        boolean[] visit = new boolean[dist.length];
        pq.add(new int[]{start, 0});
        dist[start] = 0;
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            if (dist[now[0]] < now[1] || visit[now[0]]) {
                continue;
            }
            visit[now[0]] = true;
            for (int i = 0; i < list[now[0]].size(); i++) {
                Road next = list[now[0]].get(i);
                if (dist[next.to] >= now[1] + next.time) {
                    dist[next.to] = now[1] + next.time;
                    pq.add(new int[]{next.to, now[1] + next.time});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        ArrayList<Road>[] list = new ArrayList[N + 1];
        ArrayList<Road>[] rList = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
            rList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            list[from].add(new Road(from, to, time));
            rList[to].add(new Road(to, from, time));
        }

        // 한 정점 -> X 까지 최단 경로 = X에서 한 정점까지 rList 최단 경로
        int[] vToX = new int[N + 1];
        Arrays.fill(vToX, Integer.MAX_VALUE);
        dijkstra(vToX, rList, X);
        // X -> 다른 정점까지 최단 경로 = list 최단 경로
        int[] xToV = new int[N + 1];
        Arrays.fill(xToV, Integer.MAX_VALUE);
        dijkstra(xToV, list, X);
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, vToX[i] + xToV[i]);
        }
        System.out.println(answer);
    }


    public static class Road {

        int from;
        int to;
        int time;

        public Road(int from, int to, int time) {
            this.from = from;
            this.to = to;
            this.time = time;
        }

    }
}