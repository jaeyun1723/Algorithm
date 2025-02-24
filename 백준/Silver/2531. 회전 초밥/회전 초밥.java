import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
        int k = Integer.parseInt(st.nextToken()); // 연속 먹는 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++)
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

        int answer = map.size() + (map.containsKey(c) ? 0 : 1);

        for (int i = 0; i < N; i++) {
            if (map.get(arr[i]) > 1) {
                map.put(arr[i], map.get(arr[i]) - 1);
            } else
                map.remove(arr[i]);
            map.put(arr[(i + k) % N], map.getOrDefault(arr[(i + k) % N], 0) + 1);
            answer = Math.max(answer, map.size() + (map.containsKey(c) ? 0 : 1));
        }

        System.out.println(answer);
    }
}