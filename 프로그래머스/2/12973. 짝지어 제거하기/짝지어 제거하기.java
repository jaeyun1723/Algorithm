import java.util.*;

class Solution {

    public int solution(String s) {
        int answer = -1;
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stk.isEmpty()) {
                stk.push(c);
            } else {
                if (stk.peek() == c) {
                    stk.pop();
                } else {
                    stk.push(c);
                }
            }
        }
        if (stk.isEmpty()) {
            answer = 1;
        } else {
            answer = 0;
        }
        return answer;
    }
}