import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static boolean isAvailable(int h, int[] height, long min) {
        long result = 0;
        for (int i = 0; i < height.length; i++) {
            result += Math.max(height[i] - h, 0);
        }
        return result >= min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] height = new int[N];

        st = new StringTokenizer(br.readLine());

        int low = 0, high = 0;
        for (int i = 0; i < N; i++) {
            height[i] = Integer.parseInt(st.nextToken());
            high = Math.max(high, height[i]);
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            if (isAvailable(mid, height, M)) {
                low = mid + 1;
            } else
                high = mid - 1;
        }

        System.out.println(low - 1);

    }
}