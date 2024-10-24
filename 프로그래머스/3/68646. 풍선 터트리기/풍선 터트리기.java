import java.util.*;

class Solution {

    public int solution(int[] a) {
        int answer = 2;

        int[] rightMin = new int[a.length]; // 뒤에서부터 i번째까지 중 최솟값
        rightMin[a.length - 1] = a[a.length - 1];

        for (int i = a.length - 2; i >= 2; i--) {
            rightMin[i] = Math.min(a[i], rightMin[i + 1]);
        }
        int leftMin = a[0];
        for (int i = 1; i < a.length - 1; i++) {
            leftMin = Math.min(leftMin, a[i - 1]);
            if (leftMin > a[i] || rightMin[i + 1] > a[i]) {
                answer++;
            }

        }

        return answer;
    }
}