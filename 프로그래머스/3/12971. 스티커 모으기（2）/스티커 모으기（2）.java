class Solution {
    public int solution(int sticker[]) {
        int answer = 0;

        int size = sticker.length;

        if(size==1) return sticker[0];
        
        int[] dp1 = new int[size]; // 첫 원소를 선택했을 경우
        int[] dp2 = new int[size]; // 첫 원소를 선택하지 않았을 경우
        dp1[0] = dp1[1] = sticker[0];
        dp2[1] = sticker[1];
        
        for (int i = 2; i < size; i++) {
            if (i != size - 1)
                dp1[i] = Math.max(dp1[i - 2] + sticker[i], dp1[i - 1]);
            dp2[i] = Math.max(dp2[i - 2] + sticker[i], dp2[i - 1]);
        }

        answer = Math.max(dp1[size - 2], dp2[size - 1]);
        return answer;

    }
}