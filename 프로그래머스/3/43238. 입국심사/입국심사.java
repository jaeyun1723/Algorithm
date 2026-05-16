import java.util.*;

class Solution {

    public boolean canEvaluate(int n, int[] times, long limit) {
        long count = 0;
        for (int time : times) {
            count += (limit / time);
            if (count >= n) {
                return true;
            }
        }
        return count >= n;
    }

    public long solution(int n, int[] times) {
        long answer = 0;
        long low = 1;
        long high = 0;
        for (int i = 0; i < times.length; i++) {
            high = Math.max(high, times[i]);
        }
        high *= n;

        while (low <= high) {
            long mid = (low + high) / 2;
            if (canEvaluate(n, times, mid)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }

    public class Inspector {

        int cur;
        int full;

        public Inspector(int cur, int full) {
            this.cur = cur;
            this.full = full;
        }
    }
}