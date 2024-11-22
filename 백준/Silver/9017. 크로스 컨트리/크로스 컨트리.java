import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            ArrayList<Integer>[] teams = new ArrayList[201];
            // teams[팀번호].get(들어온순서)=idx(전체등수)
            for (int i = 0; i <= 200; i++) {
                teams[i] = new ArrayList<>();
            }
            int[] rank = new int[N + 1]; // 들어온 순서
            Map<Integer, Integer> total = new HashMap<>();
            for (int i = 1; i <= N; i++) {
                int num = Integer.parseInt(st.nextToken());
                rank[i] = num;
                teams[num].add(i);
            }
            int score = 1;
            for (int i = 1; i <= N; i++) {
                if (teams[rank[i]].size() == 6) {
                    for (int j = 0; j < 6; j++) {
                        if (teams[rank[i]].get(j) == i && j < 4)
                            total.put(rank[i], total.getOrDefault(rank[i], 0) + score);
                    }
                    score++;
                }
            }
            PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[1] == o2[1])
                        return Integer.compare(o1[2], o2[2]);
                    return Integer.compare(o1[1], o2[1]);
                }
            });
            for (int key : total.keySet()) {
                int[] e = new int[]{key, total.get(key), teams[key].get(4)};
                pq.add(e);
            }
            System.out.println(pq.peek()[0]);

        }
    }
}