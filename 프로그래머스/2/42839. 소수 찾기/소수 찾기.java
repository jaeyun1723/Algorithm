import java.util.*;

class Solution {

    static boolean[] isVisit;
    static Set<Integer> set;

    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void dfs(int idx, String numbers, String str) {
        if (idx == numbers.length()) {
            return;
        }
        for (int i = 0; i < numbers.length(); i++) {
            if (isVisit[i]) {
                continue;
            }
            isVisit[i] = true;
            set.add(Integer.parseInt(str + numbers.charAt(i)));
            dfs(idx + 1, numbers, str + numbers.charAt(i));
            isVisit[i] = false;
        }
    }

    public int solution(String numbers) {
        int answer = 0;
        set = new HashSet<>();
        isVisit = new boolean[numbers.length()];
        dfs(0, numbers, "");
        for (int num : set) {
            if (isPrime(num)) {
                answer++;
            }
        }
        return answer;
    }
}