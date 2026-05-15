class Solution {

    boolean solution(String s) {
        boolean answer = false;
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }
        if (count == 0) {
            answer = true;
        }
        return answer;
    }
}