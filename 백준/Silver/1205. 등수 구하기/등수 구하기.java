import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 등록된 점수 리스트
        int score = Integer.parseInt(st.nextToken()); // 내 점수
        int P = Integer.parseInt(st.nextToken()); // 랭킹 리스트

        if (N == 0) {
            System.out.println(1);
            return;
        }
        Integer[] list = new Integer[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list, Collections.reverseOrder());
        int rank = 1;
        int same = 0;
        for (int i = 0; i < Math.min(list.length, P); i++) { // 현재 등록된 리스트
            if (list[i] > score) {
                rank++;
            } else if (list[i] == score) {
                same++;
            } else {
                break;
            }
        }
        System.out.println((rank + same > P) ? -1 : rank);
    }
}