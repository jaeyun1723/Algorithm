import java.util.*;

class Solution {

    public static int block(int n) {
        int q = 1;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (n / i > 10_000_000) {
                    q = i;
                } else {
                    return n / i;
                }
            }
        }
        return q;
    }

    public int[] solution(long begin, long end) {
        // 처음 나눠지는 값
        int be = (int) begin;
        int en = (int) end;

        int[] answer = new int[en - be + 1];
        for (int i = be; i <= en; i++) {
            if (i == 1) {
                answer[0] = 0;
            } else {
                answer[i - be] = block(i);
            }
        }
        return answer;
    }
}