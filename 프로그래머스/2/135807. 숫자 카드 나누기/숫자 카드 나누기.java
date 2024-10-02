import java.util.*;

class Solution {

    public boolean notDivisible(int num, int[] arr) {
        for (int e : arr) {
            if (e % num == 0) return false;
        }
        return true;
    }

    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        for (int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }

        if (notDivisible(gcdA, arrayB)) {
            answer = gcdA;
        }
        if (notDivisible(gcdB, arrayA))
            answer = Math.max(answer, gcdB);
        return answer;
    }
}