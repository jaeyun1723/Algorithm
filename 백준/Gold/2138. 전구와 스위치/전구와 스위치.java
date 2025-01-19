import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int N;

    public static void switching(int i, int[] arr) {
        arr[i - 1] = 1 - arr[i - 1];
        arr[i] = 1 - arr[i];
        if (i != N - 1)
            arr[i + 1] = 1 - arr[i + 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        String now = br.readLine();
        String result = br.readLine();

        int[] v1 = new int[N];
        int[] v2 = new int[N];
        int[] target = new int[N];

        for (int i = 0; i < N; i++) {
            v1[i] = now.charAt(i) - '0';
            v2[i] = now.charAt(i) - '0';
            target[i] = result.charAt(i) - '0';
        }

        v2[0] = 1 - v2[0];
        v2[1] = 1 - v2[1];

        int answer = Integer.MAX_VALUE;
        int cnt1 = 0;
        int cnt2 = 1;

        for (int i = 1; i < N; i++) {
            if (v1[i - 1] != target[i - 1]) {
                switching(i, v1);
                cnt1++;
            }
            if (v2[i - 1] != target[i - 1]) {
                switching(i, v2);
                cnt2++;
            }
        }

        if (isSame(v1, target))
            answer = cnt1;
        if (isSame(v2, target))
            answer = Math.min(answer, cnt2);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);

    }

    public static boolean isSame(int[] a, int[] b) {
        for (int i = 0; i < N; i++) {
            if (a[i] != b[i])
                return false;
        }
        return true;
    }
}