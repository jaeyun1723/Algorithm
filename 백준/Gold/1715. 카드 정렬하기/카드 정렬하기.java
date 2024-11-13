import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            pq.add(num);
        }
        int answer = 0;
        if (N == 1) {
            System.out.println(0);
            return;
        }
        while (!pq.isEmpty() && pq.size() >= 2) {
            int cardA = pq.poll();
            int cardB = pq.poll();
            answer += cardA + cardB;
            pq.add(cardA + cardB);
        }
        System.out.println(answer);
    }
}