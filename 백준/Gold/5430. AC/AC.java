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

            Deque<Integer> deq = new ArrayDeque<>();

            // 배열이 빈 배열이 아닐 때만 처리
            if (n > 0) {
                String[] elements = arr.substring(1, arr.length() - 1).split(",");
                for (String element : elements) {
                    deq.offerLast(Integer.parseInt(element));
                }
            }

            boolean isReverse = false;
            boolean isError = false;

            for (char cmd : function.toCharArray()) {
                if (cmd == 'R') {
                    isReverse = !isReverse;
                } else { // 'D'
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
                sb.append("[");

                while (!deq.isEmpty()) {
                    sb.append(isReverse ? deq.pollLast() : deq.pollFirst());
                    if (!deq.isEmpty()) {
                        sb.append(",");
                    }
                }

                sb.append("]");
                System.out.println(sb.toString());
            }
        }
    }
}
