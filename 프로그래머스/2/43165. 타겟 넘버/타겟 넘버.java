class Solution {

    static int answer;

    public void subset(int[] numbers, int target, int idx, int sum) {
        if (idx == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        subset(numbers, target, idx + 1, sum + numbers[idx]);
        subset(numbers, target, idx + 1, sum + (-1) * numbers[idx]);
    }

    public int solution(int[] numbers, int target) {
        subset(numbers, target, 0, 0);
        return answer;
    }
}