import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    public static boolean myTitle(int num, int idx, int[] score) {
        if (num <= score[idx])
            return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] title = new String[N];
        int[] score = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            title[i] = st.nextToken();
            score[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int left = 0;
            int right = N - 1;
            int idx = -1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (myTitle(num, mid, score)) {
                    idx = mid;
                    right = mid - 1;
                } else
                    left = mid + 1;
            }
            System.out.println(title[idx]);
        }


    }
}