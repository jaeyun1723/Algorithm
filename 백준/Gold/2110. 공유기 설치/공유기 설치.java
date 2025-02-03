import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int[] arr;

    public static boolean canInstall(int len, int c) {
        int count = 1;
        int prev = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - prev >= len) {
                count++;
                prev = arr[i];
            }
        }
        return count >= c;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int min = 1;
        int max = arr[N - 1] - arr[0];

        while (min <= max) {
            int len = (min + max) / 2;
            if (canInstall(len, C)) {
                min = len + 1;
            } else {
                max = len - 1;
            }
        }

        System.out.println(min - 1);
    }
}