import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int ans = 0;

        for (int i = 0; i < N; i++) {
            int start = 0;
            int end = N - 1;
            int target = arr[i];
            while (start < end) {
                if (start == i) {
                    start++;
                } else if (end == i) {
                    end--;
                } else {
                    int sum = arr[start] + arr[end];
                    if (sum == target) {
                        ans++;
                        break;
                    } else if (sum > target) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
        }

        System.out.println(ans);
    }

}
