import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int res = 0, N;
    static Map<Integer, List<Integer>> map;
    static boolean[] isCycle;

    public static int bfs(int station) {
        boolean[] isVisit = new boolean[N + 1];
        Deque<int[]> deq = new ArrayDeque<>();
        deq.offerLast(new int[]{station, 0});
        isVisit[station] = true;
        while (!deq.isEmpty()) {
            int[] now = deq.pollFirst();
            List<Integer> list = map.get(now[0]);
            for (int next : list) {
                if (isVisit[next]) continue;
                if (isCycle[next]) {
                    return now[1] + 1;
                }
                deq.offerLast(new int[]{next, now[1] + 1});
                isVisit[next] = true;
            }
        }
        return -1;
    }

    public static boolean circulation(int start, int now, int prev) {
        isCycle[now] = true;
        for (int next : map.get(now)) {
            if (!isCycle[next]) {
                isCycle[next] = true;
                if (circulation(start, next, now)) return true;
            } else if (next != prev && next == start) {
                return true;
            }
        }
        isCycle[now] = false;
        return false;
    }

    public static List<Integer> getList(int station) {
        List<Integer> list = new ArrayList<>();
        list.add(station);
        return list;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            if (!map.containsKey(v1)) {
                map.put(v1, getList(v2));
            } else {
                map.get(v1).add(v2);
            }
            if (!map.containsKey(v2)) {
                map.put(v2, getList(v1));
            } else {
                map.get(v2).add(v1);
            }
        }

        isCycle = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (circulation(i, i, -1)) break;
        }
        int[] answer = new int[N + 1];
        // 2. 최솟값(bfs)
        for (int i = 1; i <= N; i++) {
            if (isCycle[i]) answer[i] = 0;
            else answer[i] = bfs(i);
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(answer[i]+" ");
        }
    }

}