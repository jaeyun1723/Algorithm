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

        int[] board = new int[101];

        for (int i = 1; i <= 100; i++)
            board[i] = i;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            map.put(key, value);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        boolean[] visited = new boolean[101];
        pq.add(new int[]{1, 0});

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            if (now[0] == 100) {
                System.out.println(now[1]);
                return;
            }
            if (visited[now[0]]) continue;
            visited[now[0]] = true;
            if (map.containsKey(now[0])) {
                now[0] = map.get(now[0]);
                visited[now[0]] = true;
            }
            for (int i = 1; i <= 6; i++) {
                int next = now[0] + i;
                if (next > 100 || visited[next]) continue;
                pq.add(new int[]{next, now[1] + 1});
            }
        }

    }
}