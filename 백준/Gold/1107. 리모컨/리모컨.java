import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        if (cnt == 0) {
            System.out.println(Math.min(Math.abs(100 - N), String.valueOf(N).length()));
            return;
        }
        boolean[] breaks = new boolean[10];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cnt; i++) {
            breaks[Integer.parseInt(st.nextToken())] = true;
        }

        int answer = Math.abs(100 - N);
        for (int i = 0; i <= 999999; i++) {
            String str = String.valueOf(i);
            boolean isBreak = false;
            for (int j = 0; j < str.length(); j++) {
                if (breaks[str.charAt(j) - '0']) {
                    isBreak = true;
                    break;
                }
            }
            if (!isBreak) {
                answer = Math.min(str.length() + Math.abs(i - N), answer);
            }
        }
        System.out.println(answer);
    }

}