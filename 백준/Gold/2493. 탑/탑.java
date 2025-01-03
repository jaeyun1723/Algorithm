import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Stack<int[]> stk = new Stack<>();

        for (int i = 1; i <= N; i++) {
            int tower = Integer.parseInt(st.nextToken());
            while (!stk.isEmpty()) {
                if (stk.peek()[1] >= tower) {
                    System.out.print(stk.peek()[0] + " ");
                    break;
                }
                stk.pop();
            }
            if (stk.isEmpty()) {
                System.out.print("0 ");
            }
            stk.push(new int[]{i, tower});
        }

    }
}