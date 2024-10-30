class Solution {

    public static int palindrome(int left, int right, String s, int len) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left--;
            right++;
            len += 2;
        }
        return len;
    }

    public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            int len = 1;
            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                len = palindrome(i - 1, i + 2, s, 2);
            }
            len = Math.max(len, palindrome(i - 1, i + 1, s, 1));
            answer = Math.max(answer, len);
        }

        return answer;
    }
}