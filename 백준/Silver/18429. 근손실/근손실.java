import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int N, K;
    static int answer;
    static int[] weight;

    public static void training(int day, int total, boolean[] isVisit) {
        if (day == N) {
            answer++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!isVisit[i] && total - K + weight[i] >= 500) {
                isVisit[i] = true;
                training(day + 1, total - K + weight[i], isVisit);
                isVisit[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        weight = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] isVisit = new boolean[N];
        training(0, 500, isVisit);
        System.out.println(answer);

    }

}