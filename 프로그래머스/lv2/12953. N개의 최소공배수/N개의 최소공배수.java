class Solution {

    public static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }

    public int solution(int[] arr) {
        int answer = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int result = gcd(answer, arr[i]);
            answer = answer / result * arr[i];
        }

        return answer;
    }
}