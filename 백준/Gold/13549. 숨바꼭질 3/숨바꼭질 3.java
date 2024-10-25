import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int[] dx = {1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[100_001]; // i번째 까지 도착하는데 최소 시간.
        Arrays.fill(dp, Integer.MAX_VALUE);
        boolean[] visit = new boolean[100_001];
        dp[N] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        pq.add(new int[]{N, 0});
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            if (dp[now[0]] < now[1]) {
                continue;
            }
            if (now[0] == K) {
                System.out.println(now[1]);
                return;
            }
            if (!visit[now[0]]) {
                visit[now[0]] = true;
                for (int i = 0; i < 3; i++) {
                    int[] next = new int[2];
                    if (i == 2) {
                        next[0] = 2 * now[0];
                        next[1] = now[1];
                    } else {
                        next[0] = now[0] + dx[i];
                        next[1] = now[1] + 1;
                    }
                    if (next[0] < 0 || next[0] > 100_000 || visit[next[0]]) {
                        continue;
                    }
                    if (dp[next[0]] > next[1]) {
                        dp[next[0]] = next[1];
                        pq.add(next);
                    }
                }
            }
        }

    }
}