import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        String[] str = new String[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            str[i] = st.nextToken();
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int digit = 1;
            for (int j = str[i].length() - 1; j >= 0; j--) {
                char c = str[i].charAt(j);
                map.put(c, map.getOrDefault(c, 0) + digit);
                digit *= 10;
            }
        }

        List<Character> keys = new ArrayList<>(map.keySet());

        keys.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return map.get(o2) - map.get(o1);
            }
        });
        int num = 9;
        for (char key : keys) {
            map.put(key, num--);
        }
        long answer = 0L;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < str[i].length(); j++) {
                char c = str[i].charAt(j);
                if (c >= 'A' && c <= 'Z') {
                    str[i] = str[i].replace(c, (char) (map.get(c) + '0'));
                }
            }
            answer += Long.parseLong(str[i]);
        }
        // 맨 앞자리부터 가장 많은 것 : 9
        System.out.println(answer);
    }
}