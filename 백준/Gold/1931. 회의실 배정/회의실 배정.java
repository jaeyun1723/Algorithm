import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(1);
            return;
        }

        long[][] time = new long[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i][0] = Long.parseLong(st.nextToken());
            time[i][1] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(time, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return Long.compare(o1[0], o2[0]);
            } else {
                return Long.compare(o1[1], o2[1]);
            }
        });

        int count = 1;
        long end = time[0][1];

        for (int i = 1; i < N; i++) {
            if (time[i][0] >= end) {
                count++;
                end = time[i][1];
            }
        }

        System.out.println(count);
    }


}