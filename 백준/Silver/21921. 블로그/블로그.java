import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int visitor = 0;
        for (int i = 0; i < X; i++) {
            visitor += arr[i];
        }
        int max = visitor;
        int cnt = 1;
        for (int i = X; i < N; i++) {
            visitor += arr[i] - arr[i - X];
            if (max < visitor) {
                max = visitor;
                cnt = 1;
            }
            else if (max == visitor) {
                cnt++;
            }
        }

        if (max == 0) System.out.println("SAD");
        else {
            System.out.println(max);
            System.out.println(cnt);
        }
    }
}