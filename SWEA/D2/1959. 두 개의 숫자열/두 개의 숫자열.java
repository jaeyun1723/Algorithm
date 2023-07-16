import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int[] a = new int[A];
            int[] b = new int[B];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < A; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < B; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }
            int max = 0;
            if (a.length <= b.length) {
                for (int i = 0; i < b.length - a.length + 1; i++) {    // 시작점
                    int sum = 0;
                    for (int j = 0; j < a.length; j++) {
                        sum += a[j] * b[i + j];
                    }
                    max = Math.max(max, sum);
                }
            } else {
                for (int i = 0; i < a.length - b.length + 1; i++) {    // 시작점
                    int sum = 0;
                    for (int j = 0; j < b.length; j++) {
                        sum += b[j] * a[i + j];
                    }
                    max = Math.max(max, sum);
                }
            }
            System.out.println("#" + t + " " + max);
        } // test_case
    }// main
}// class