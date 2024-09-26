class Solution {

    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, sequence.length - 1};
        int sum = 0;
        int end = 0;
        for (int i = 0; i < sequence.length; i++) {
            while (sum < k && end < sequence.length) {
                sum += sequence[end++];
            }
            if (sum == k) {
                if (end - 1 - i < answer[1] - answer[0]) {
                    answer[0] = i;
                    answer[1] = end - 1;
                }
            }
            sum -= sequence[i];
        }

        return answer;
    }
}