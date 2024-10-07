import java.util.*;

class Solution {

    public int solution(int[][] scores) {
        int answer = 0;
        int[] wonho = scores[0];
        // 근무 내림차순, (같은 경우) 동료 오름차순
        Arrays.sort(scores, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        int maxScore = 0;
        int rank = 1;
        for (int[] score : scores) {
            if (maxScore <= score[1]) {
                maxScore = score[1];
                if (score[0] + score[1] > wonho[0] + wonho[1]) {
                    rank++;
                }
            } else if (score.equals(wonho)) {
                return -1;
            }
        }

        return rank;
    }
}