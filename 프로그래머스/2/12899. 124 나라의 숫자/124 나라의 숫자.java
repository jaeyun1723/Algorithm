import java.util.*;

class Solution {

    public String solution(int n) {
        String answer = "";
        String[] num = {"4", "1", "2"};

        while (n > 0) {
            int idx = n % 3;
            n /= 3;
            answer = num[idx] + answer;
            if (idx == 0) {
                n--;
            }
        }

        return answer;
    }
}