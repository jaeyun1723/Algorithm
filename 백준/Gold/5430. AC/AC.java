import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;


class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String function = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arr = br.readLine();
            Deque<String> deq = new ArrayDeque<>();
            if (n > 0) {
                String[] elements = arr.substring(1, arr.length() - 1).split(",");
                for (String e : elements) {
                    deq.offerLast(e);
                }
            }
            boolean isReverse = false;
            boolean isError = false;
            for (int i = 0; i < function.length(); i++) {
                if (function.charAt(i) == 'R') {
                    isReverse = !isReverse;
                } else { // D
                    if (deq.isEmpty()) {
                        isError = true;
                        break;
                    }
                    if (!isReverse) {
                        deq.pollFirst();
                    } else {
                        deq.pollLast();
                    }
                }
            }
            if (isError) {
                System.out.println("error");
            } else {
                StringBuilder sb = new StringBuilder();
                while (!deq.isEmpty()) {
                    sb.append(isReverse ? deq.pollLast() : deq.pollFirst()).append(",");
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                System.out.println("[" + sb.toString() + "]");
            }
        }
    }
}