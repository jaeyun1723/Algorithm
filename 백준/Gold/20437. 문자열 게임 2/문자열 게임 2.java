import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            String str = br.readLine();
            ArrayList<Integer>[] list = new ArrayList[26];
            for (int i = 0; i < 26; i++) {
                list[i] = new ArrayList<>();
            }
            for (int i = 0; i < str.length(); i++) {
                list[str.charAt(i) - 'a'].add(i);
            }
            int K = Integer.parseInt(br.readLine());
            int sol3 = 99999;
            int sol4 = 0;
            for (int i = 0; i < 26; i++) {
                if (list[i].size() >= K) {
                    for (int j = K - 1; j < list[i].size(); j++) {
                        sol3 = Math.min(sol3, list[i].get(j) - list[i].get(j - (K - 1)));
                        sol4 = Math.max(sol4, list[i].get(j) - list[i].get(j - (K - 1)));
                    }
                }
            }
            if (sol3 == 99999) {
                System.out.println(-1);
                continue;
            } else {
                System.out.println(++sol3 + " " + ++sol4);
            }
        }
    }
}