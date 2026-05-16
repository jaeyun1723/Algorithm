class Solution {


    public boolean canSolve(int[] diffs, int[] times, int level, long limit) {
        long timer = 0;
        for (int i = 0; i < diffs.length; i++) {
            if (diffs[i] <= level) {
                timer += times[i];
            } else {
                int cnt = diffs[i] - level; // 틀린 개수
                if (i > 0) {
                    timer += (times[i - 1] + times[i]) * cnt + times[i];
                } else {
                    timer += times[i] * (cnt + 1);
                }
            }
            if (timer > limit) {
                return false;
            }
        }
        return timer <= limit;
    }

    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int low = 1;
        int high = 0;
        for (int i = 0; i < diffs.length; i++) {
            high = Math.max(high, diffs[i]);
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            if (canSolve(diffs, times, mid, limit)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }
}