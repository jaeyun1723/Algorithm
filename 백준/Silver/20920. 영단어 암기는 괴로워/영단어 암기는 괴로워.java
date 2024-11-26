import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (str.length() < M) {
                continue;
            }
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet, (o1, o2) -> {
            if (map.get(o1) == map.get(o2)) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return Integer.compare(o2.length(), o1.length());
            }
            return Integer.compare(map.get(o2), map.get(o1));
        });

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out
        ));

        for (String key : keySet) {
            writer.write(key + "\n");
        }
            writer.flush();
    }

}