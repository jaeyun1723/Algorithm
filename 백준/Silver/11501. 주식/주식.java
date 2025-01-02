import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());

            int[] stocks = new int[day];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < day; i++) {
                stocks[i] = Integer.parseInt(st.nextToken());
            }

            long profit = 0;
            int max = stocks[stocks.length - 1];
            for (int i = stocks.length - 2; i >= 0; i--) {
                if (stocks[i] <= max) {
                    profit += max - stocks[i];
                } else
                    max = stocks[i];
            }
            System.out.println(profit);
        }

    }
}