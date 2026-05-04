class Solution {

    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        answer[1] = sequence.length - 1;
        int sum = 0;
        int left = 0;

        for (int i = 0; i < sequence.length; i++) {
            sum += sequence[i];
            while (sum > k && i < sequence.length) {
                sum -= sequence[left++];
            }
            if (sum == k) {
                if (i - left < answer[1] - answer[0]) {
                    answer[0] = left;
                    answer[1] = i;
                }
            }
        }
        return answer;
    }
}