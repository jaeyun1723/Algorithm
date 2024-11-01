import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main {

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        Arrays.fill(arr, -1);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if (str.equals("KBS1")) {
                arr[i] = 1;
            }
            if (str.equals("KBS2")) {
                arr[i] = 2;
            }
        }
        int channel = 0;
        while (arr[channel] != 1) {
            channel++;
            System.out.print("1");
        }
        while (channel != 0) {
            swap(arr, channel - 1, channel);
            channel--;
            System.out.print("4");
        }
        while (arr[channel] != 2) {
            channel++;
            System.out.print("1");
        }
        while (channel != 1) {
            swap(arr, channel - 1, channel);
            channel--;
            System.out.print("4");
        }
        // 1 1 * i 4
    }
}