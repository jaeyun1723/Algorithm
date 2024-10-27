import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N][2];
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                arr[j][0] = Integer.parseInt(st.nextToken());
                arr[j][1] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr, (o1, o2) -> Integer.compare(o1[0], o2[0]));

            int max = arr[0][1];
            int answer = 1;
            for (int j = 1; j < arr.length; j++) {
                if (arr[j][1] < max) {
                    answer++;
                    max = arr[j][1];
                }
            }
            System.out.println(answer);
        }
    }
}