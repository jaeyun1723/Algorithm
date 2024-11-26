import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.HashMap;
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

        PriorityQueue<Word> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.count == o2.count) {
                if (o1.w.length() == o2.w.length()) {
                    return o1.w.compareTo(o2.w);
                }
                return Integer.compare(o2.w.length(), o1.w.length());
            }
            return Integer.compare(o2.count, o1.count);
        });

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out
        ));
        for (String key : map.keySet()) {
            pq.add(new Word(key, map.get(key)));
        }

        while (!pq.isEmpty()) {
            writer.write(pq.poll().w + "\n");
        }
        writer.flush();
    }

    public static class Word {

        String w;
        int count;

        public Word(String w, int count) {
            this.w = w;
            this.count = count;
        }
    }
}