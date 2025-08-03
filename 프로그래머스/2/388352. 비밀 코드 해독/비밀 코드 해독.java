import java.util.*;

class Solution {

    static int answer = 0;

    public boolean isSecretCode(ArrayList<Integer> code, int[][] q, int[] ans) {
        for (int i = 0; i < q.length; i++) {
            int[] step = q[i];
            int cnt = 0;
            for (int num : step) {
                if (code.contains(num)) {
                    cnt++;
                }
            }
            if (cnt != ans[i]) {
                return false;
            }
        }
        return true;
    }

    public void decode(int start, ArrayList<Integer> code, int n, int[][] q, int[] ans) {
        if (code.size() == 5) {
            if (isSecretCode(code, q, ans)) {
                answer++;
            }
            return;
        }
        for (int i = start; i <= n; i++) {
            code.add(i);
            decode(i + 1, code, n, q, ans);
            code.remove(code.size() - 1);
        }
    }

    public int solution(int n, int[][] q, int[] ans) {
        ArrayList<Integer> code = new ArrayList<>();
        decode(1, code, n, q, ans);
        return answer;
    }
}
