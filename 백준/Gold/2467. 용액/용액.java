import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long[] arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Long.parseLong(st.nextToken());

        long diff = 2_000_000_002, sum, min = 0, max = 0;
        int start = 0, end = N - 1;
        while (start < end) {
            sum = arr[start] + arr[end];
            if (Math.abs(sum) < diff) {
                diff = Math.abs(sum);
                min = arr[start];
                max = arr[end];
            }
            if(sum>0) end--;
            else start++;
        }
        System.out.println(min + " " + max);
    }
}