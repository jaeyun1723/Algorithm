import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int[] arr;
    static int N, M;

    public static boolean possible(int height) {
        int prev = 0; // 가로등이 비추는 곳
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - height <= prev) {
                prev = arr[i] + height;
            } else {
                return false;
            }
        }

        return N <= prev;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 1;
        int right = N;
        int ans = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (possible(mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(ans);

    }

}