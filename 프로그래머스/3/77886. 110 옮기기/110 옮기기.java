import java.util.*;

class Solution {

    public static String sorting(String str) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stk = new Stack<>();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            stk.push(c);
            if (stk.size() >= 3) {
                char third = stk.pop();
                char second = stk.pop();
                char first = stk.pop();
                if (first == '1' && second == '1' && third == '0') {
                    count++;
                } else {
                    stk.push(first);
                    stk.push(second);
                    stk.push(third);
                }
            }
        }
        while (!stk.isEmpty()) {
            sb.append(stk.pop());
        }
        sb = sb.reverse();
        int idx = sb.lastIndexOf("0");
        for (int i = 0; i < count; i++) {
            sb.insert(idx + 1, "110");
        }
        return sb.toString();
    }

    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        for (int i = 0; i < s.length; i++) {
            answer[i] = sorting(s[i]);
        }
        return answer;
    }
}