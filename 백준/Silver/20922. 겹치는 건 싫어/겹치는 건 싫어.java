import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;


class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int max_count = 0;
        int start = 0;
        for (int i = 0; i < N; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            count++;
            if (map.get(arr[i]) > K) { // 넘는다면,
                while (start < i && map.get(arr[i]) > K) {
                    map.put(arr[start], map.get(arr[start]) - 1);
                    start++;
                }
                count = i - start + 1;
            }
            if (count > max_count) {
                max_count = count;
            }
        }
        System.out.println(max_count);

    }


}