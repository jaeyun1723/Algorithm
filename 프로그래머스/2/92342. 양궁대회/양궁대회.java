import java.util.*;

class Solution {

    static int diff = -1;
    static int[] answer = new int[11];

    public void lionArrow(int n, int[] info, int[] lion, int idx) {
        if (idx == 11) {
            int lionSum = 0;
            int apeachSum = 0;
            for (int i = 0; i < info.length; i++) {
                if (lion[i] == 0 && info[i] == 0) continue;
                if (lion[i] > info[i]) {
                    lionSum += 10 - i;
                } else
                    apeachSum += 10 - i;
            }
            if (lionSum > apeachSum) {
                if (diff == lionSum - apeachSum) {
                    for (int i = 10; i >= 0; i--) {
                        if (lion[i] == answer[i]) continue;
                        if (lion[i] < answer[i]) return;
                        if (lion[i] > answer[i]) {
                            answer = Arrays.copyOf(lion, 11);
                            return;
                        }
                    }
                }
                else if (diff < lionSum - apeachSum) {
                    diff = lionSum - apeachSum;
                    answer = Arrays.copyOf(lion, 11);
                }
            }
            return;
        }
        if (idx == 10) {
            lion[idx] = n;
            lionArrow(0, info, lion, idx + 1);
        } else {
            if (n > info[idx]) {
                lion[idx] = info[idx] + 1;
                lionArrow(n - info[idx] - 1, info, lion, idx + 1);
            }
            lion[idx] = 0;
            lionArrow(n, info, lion, idx + 1);
        }
    }

    public int[] solution(int n, int[] info) {
        lionArrow(n, info, new int[11], 0);
        return diff == -1 ? new int[]{-1} : answer;
    }
}