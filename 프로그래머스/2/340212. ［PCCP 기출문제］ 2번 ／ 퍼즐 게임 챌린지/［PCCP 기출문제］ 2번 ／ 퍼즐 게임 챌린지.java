class Solution {

    public boolean isSolved(int[] diffs, int[] times, int level, long limit) {
        long time = 0;
        for (int i = 0; i < diffs.length; i++) {
            if (time > limit) return false;
            if (diffs[i] <= level) {
                time += times[i];
            } else {
                int turn = diffs[i] - level;
                if (i == 0) {
                    time += (long) (turn + 1) * times[i];
                } else {
                    time += (long) turn * (times[i - 1] + times[i]) + times[i];
                }
            }
        }
        if (time <= limit) return true;
        return false;
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
            if (isSolved(diffs, times, mid, limit)) {
                high = mid - 1;
                answer = mid;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }
}