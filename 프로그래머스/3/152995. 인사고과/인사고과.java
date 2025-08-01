import java.util.*;

class Solution {

    public int solution(int[][] scores) {
        int answer = 0;
        int[] wan = scores[0];
        if (scores.length == 1) {
            return 1;
        }
        Arrays.sort(scores, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o2[0], o1[0]);
        });
        int minScore = scores[0][1];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i][1] < minScore) {
                if (wan[0] == scores[i][0] && wan[1] == scores[i][1]) {
                    return -1;
                }
                scores[i][0] = -1;
                scores[i][1] = -1;
            } else {
                minScore = scores[i][1];
            }
        }

        Arrays.sort(scores, (o1, o2) -> Integer.compare(o2[0] + o2[1], o1[0] + o1[1]));
        for (int[] score : scores) {
            if (wan[0] + wan[1] < score[0] + score[1]) {
                answer++;
            } else {
                break;
            }
        }
        return answer + 1;
    }
}