import java.util.*;

class Solution {

    public long solution(int[] weights) {
        long answer = 0;

        Arrays.sort(weights);

        Map<Double, Integer> map = new HashMap<>();
        for (int w : weights) {
            // 2/3 2/4 3/4
            double wa = w * 1.0;
            double wb = w * 2 / 3.0;
            double wc = w / 2.0;
            double wd = w * 3 / 4.0;
            if (map.containsKey(wa)) {
                answer += map.get(wa);
            }
            if (map.containsKey(wb)) {
                answer += map.get(wb);
            }
            if (map.containsKey(wc)) {
                answer += map.get(wc);
            }
            if (map.containsKey(wd)) {
                answer += map.get(wd);
            }
            map.put(wa, map.getOrDefault(wa, 0) + 1);
        }

        return answer;
    }
}