import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        Deque<Integer> deq = new ArrayDeque<>();
        int[] arr = new int[1_000_001];
        Arrays.fill(arr, -1);
        for (int i = 0; i < M; i++) {
            int tPW = Integer.parseInt(st.nextToken());
            arr[tPW] = 0;
            deq.addLast(tPW);
        }
        int sScore = 0;
        while (!deq.isEmpty()) {
            int tPW = deq.pollFirst();
            for (int i = 0; i < 20; i++) {
                int sPW = tPW ^ (1 << i);
                if (sPW > N || arr[sPW] != -1) {
                    continue;
                }
                arr[sPW] = arr[tPW] + 1;
                deq.addLast(sPW);
                sScore = Math.max(sScore, arr[sPW]);
            }
        }

        System.out.println(sScore);
    }//
}//