class Solution {

    public boolean isSequence(int start, int target) {
        int sum = 0;
        for (int i = start; i <= target; i++) {
            sum += i;
            if (sum == target) {
                return true;
            }
            if (sum > target) {
                return false;
            }
        }
        return false;
    }

    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (isSequence(i, n)) {
                answer++;
            }
        }
        return answer;
    }
}