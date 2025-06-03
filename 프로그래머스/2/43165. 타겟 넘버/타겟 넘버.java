class Solution {

    static int answer;

    public void subset(int idx, int[] numbers, int target, int sum) {
        if (idx == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        subset(idx + 1, numbers, target, sum + numbers[idx]);
        subset(idx + 1, numbers, target, sum - numbers[idx]);
    }

    public int solution(int[] numbers, int target) {
        subset(0, numbers, target, 0);
        return answer;
    }
}