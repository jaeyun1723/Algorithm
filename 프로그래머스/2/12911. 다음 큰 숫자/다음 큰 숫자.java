class Solution {

    public int solution(int n) {
        int answer = 0;
        int bitCount = Integer.bitCount(n);
        while (true) {
            n++;
            if (bitCount == Integer.bitCount(n)) {
                answer = n;
                break;
            }
        }
        return answer;
    }
}