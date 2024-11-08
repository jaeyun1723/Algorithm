import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static boolean isEqual(List<Integer> o1, List<Integer> o2) {
        for (int i = 1; i <= 3; i++) {
            if (!Objects.equals(o1.get(i), o2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if (Objects.equals(o1.get(1), o2.get(1))) {
                    if (Objects.equals(o1.get(2), o2.get(2))) {
                        return Integer.compare(o2.get(3), o1.get(3));
                    }
                    return Integer.compare(o2.get(2), o1.get(2));
                }
                return Integer.compare(o2.get(1), o1.get(1));
            }
        });

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            List<Integer> nation = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                nation.add(Integer.parseInt(st.nextToken()));
            }
            pq.add(nation);
        }

        int rank = 1; // 현재 안붙인 가장 마지막 등수
        int same = 0;
        List<Integer> prev = pq.poll();
        if (prev.get(0) == K) {
            System.out.println(1);
            return;
        }
        while (!pq.isEmpty()) {
            List<Integer> now = pq.poll();
            if (isEqual(prev, now)) {
                same++;
            } else {
                rank += same + 1; // 등수 붙여주고 다시 안붙인 가장 마지막 등수
                same = 0;
            }
            if (now.get(0) == K) {
                System.out.println(rank);
                return;
            }
            prev = now;
        }
    }
}