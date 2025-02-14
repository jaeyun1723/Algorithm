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

    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] distance = new int[D + 1];
        Arrays.fill(distance, 10002);

        ArrayList<int[]>[] list = new ArrayList[D + 1];
        for (int i = 0; i <= D; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            if (end > D) {
                continue;
            }
            if (end - start > len) { // 지름길
                list[start].add(new int[]{end, len});
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        pq.add(new int[]{0, 0});
        distance[0] = 0;
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            if (now[0] == D) {
                continue;
            }
            if (distance[now[0]] < now[1]) {
                continue;
            }
            if (distance[now[0] + 1] > now[1] + 1) {
                distance[now[0] + 1] = now[1] + 1;
                pq.add(new int[]{now[0] + 1, now[1] + 1});
            }
            for (int[] next : list[now[0]]) {
                if (distance[next[0]] > now[1] + next[1]) {
                    distance[next[0]] = now[1] + next[1];
                    pq.add(new int[]{next[0], now[1] + next[1]});
                }
            }
        }
        System.out.println(distance[D]);
    }
}