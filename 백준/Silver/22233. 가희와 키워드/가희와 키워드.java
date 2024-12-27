import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            map.put(str, 1);
        }

        for (int i = 0; i < M; i++) {
            String[] keywords = br.readLine().split(",");
            for (String word : keywords) {
                if (map.containsKey(word))
                    map.remove(word);
            }
            System.out.println(map.size());

        }

    }
}