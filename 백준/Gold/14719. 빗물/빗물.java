import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        ArrayList<Integer>[] block = new ArrayList[H]; // 높이가 H인 블록
        for (int i = 0; i < block.length; i++) {
            block[i] = new ArrayList<>();
        }

        for (int i = 0; i < W; i++) {
            int h = Integer.parseInt(st.nextToken());
            for (int j = 0; j < h; j++) {
                block[j].add(i);
            }
        }

        int answer = 0;
        for (int i = 0; i < block.length; i++) {
            if (block[i].size() >= 2) {
                for (int j = 0; j < block[i].size() - 1; j++) {
                    answer += block[i].get(j + 1) - block[i].get(j) - 1;
                }
            }
        }

        System.out.println(answer);
    }
}