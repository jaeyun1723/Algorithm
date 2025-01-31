import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[1], o1[1]));

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            pq.add(new int[]{idx, height});
        }

        int[] max = pq.poll();
        int left = max[0];
        int right = max[0];
        int area = max[1];

        while (!pq.isEmpty()) {
            max = pq.poll();
            if (right > max[0]) {
                area += (right - max[0]) * max[1];
                right = max[0];
            }
            if (left < max[0]) {
                area += (max[0] - left) * max[1];
                left = max[0];
            }
        }

        System.out.println(area);
    }


}