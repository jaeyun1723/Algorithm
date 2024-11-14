class Solution {

    public int solution(int[] money) {
        int answer = 0;
        int len = money.length;
        int[] dp1 = new int[len]; // 첫 집을 털 경우, 마지막 집 못텀.
        int[] dp2 = new int[len]; // 첫 집을 안털 경우, 마지막 집 털 수 있음.
        dp1[0] = money[0];
        dp1[1] = money[0];
        dp2[1] = money[1];
        for (int i = 2; i < len; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + money[i]);
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + money[i]);
        }

        return answer = Math.max(dp1[len - 2], dp2[len - 1]);
    }
}