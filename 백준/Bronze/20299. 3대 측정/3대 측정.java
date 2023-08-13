import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()); // 합
        int L = Integer.parseInt(st.nextToken()); // 최소

        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int x3 = Integer.parseInt(st.nextToken());
            if (x1 >= L && x2 >= L && x3 >= L && x1 + x2 + x3 >= K) {
                cnt++;
                sb.append(x1).append(" ").append(x2).append(" ").append(x3).append(" ");
            }
        }
        System.out.println(cnt);
        System.out.println(sb);
    }//
}//