import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String str = br.readLine();

        int cnt = 0;
        boolean[] table = new boolean[str.length()];

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'P') {
                for (int j = Math.max(i - K, 0); j <= Math.min(i + K, str.length() - 1); j++) {
                    if (str.charAt(j) == 'H' && !table[j]) {
                        table[j] = true;
                        cnt++;
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}