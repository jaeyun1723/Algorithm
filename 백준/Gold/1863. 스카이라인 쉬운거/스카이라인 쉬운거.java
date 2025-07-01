import java.beans.Introspector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Stack<Integer> stk = new Stack<>();
        int buildings = 0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine().split(" ")[1];
            int h = Integer.parseInt(s);
            while (!stk.isEmpty() && stk.peek() > h) {
                buildings++;
                stk.pop();
            }
            if (!stk.isEmpty() && stk.peek() == h) {
                continue;
            }
            stk.push(h);
        }

        while (!stk.isEmpty()) {
            if (stk.pop() > 0) {
                buildings++;
            }
        }
        System.out.println(buildings);

    }

}
