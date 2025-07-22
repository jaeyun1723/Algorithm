import java.util.*;

class Solution {

    static ArrayList<int[]> seq;

    public void hanoi(int n, int start, int via, int end) {
        if (n == 1) {
            seq.add(new int[]{start, end});
        } else {
            hanoi(n - 1, start, end, via);
            seq.add(new int[]{start, end});
            hanoi(n - 1, via, start, end);
        }
    }

    public int[][] solution(int n) {
        int[][] answer = {};
        seq = new ArrayList<>();
        hanoi(n, 1, 2, 3);
        answer = new int[seq.size()][2];
        for (int i = 0; i < seq.size(); i++) {
            answer[i] = seq.get(i);
        }
        return answer;
    }
}