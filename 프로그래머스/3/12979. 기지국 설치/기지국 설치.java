class Solution {

    public int minStation(int start, int end, int w) {
        int res = (end - start + 1) / (2 * w + 1);
        if ((end - start + 1) % (2 * w + 1) != 0) {
            res++;
        }
        return res;
    }

    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start = 1;
        int end = 0;

        for (int i = 0; i < stations.length; i++) {
            end = stations[i] - w - 1;
            if (start <= end) {
                answer += minStation(start, end, w);
            }
            start = stations[i] + w + 1;
        }

        if (start <= n) {
            answer += minStation(start, n, w);
        }

        return answer;
    }
}