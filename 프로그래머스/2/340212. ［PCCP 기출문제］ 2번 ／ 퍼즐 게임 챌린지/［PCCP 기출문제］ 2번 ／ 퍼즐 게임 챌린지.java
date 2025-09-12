class Solution {

    public boolean isFinished(int[] diffs, int[] times, long limit, int level) {
        long sum = 0;
        for (int i = 0; i < diffs.length; i++) {
            if (limit < sum) {
                return false;
            }
            if (diffs[i] <= level) {
                sum += times[i];
            } else {
                int count = diffs[i] - level;
                long again;
                if (i > 0) {
                    again = (times[i - 1] + times[i]) * count + times[i];
                } else {
                    again = times[i] * count + times[i];
                }
                sum += again;
            }
        }
        if (limit < sum) {
            return false;
        }
        return true;
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
            if (isFinished(diffs, times, limit, mid)) {
                high = mid - 1;
                answer = mid;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }
}