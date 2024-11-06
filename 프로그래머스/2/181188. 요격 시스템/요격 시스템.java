import java.util.*;

class Solution {

    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);

        int maxIdx = 0;
        for (int[] t : targets) {
            if (maxIdx <= t[0]) {
                maxIdx = t[1];
                answer++;
            }
        }
        return answer;
    }
}