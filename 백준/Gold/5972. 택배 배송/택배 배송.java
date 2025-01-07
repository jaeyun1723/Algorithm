import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<int[]>[] edge = new ArrayList[N + 1];
        boolean[] visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            edge[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            edge[x].add(new int[]{y, len});
            edge[y].add(new int[]{x, len});
        }

        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        pq.add(new int[]{1, 0});

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            if (now[0] == N) {
                System.out.println(now[1]);
                return;
            }
            if (dp[now[0]] < now[1]) continue;
            if (visited[now[0]]) continue;
            visited[now[0]] = true;
            for (int[] next : edge[now[0]]) {
                if (!visited[next[0]] && dp[next[0]] > now[1] + next[1]) {
                    dp[next[0]] = now[1] + next[1];
                    pq.add(new int[]{next[0], now[1] + next[1]});
                }

            }
        }
    }
}