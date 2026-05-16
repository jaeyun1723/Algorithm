import java.util.*;

class Solution {

    static int answer;

    public void dfs(String begin, String target, String[] words, boolean[] isVisited, int count) {
        if (begin.equals(target)) {
            answer = Math.min(answer, count);
            return;
        }
        for (int i = 0; i < words.length; i++) {
            if (!isVisited[i] && canChange(begin, words[i])) {
                isVisited[i] = true;
                dfs(words[i], target, words, isVisited, count + 1);
                isVisited[i] = false;
            }
        }
    }

    public boolean canChange(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        if (count == 1) {
            return true;
        } else {
            return false;
        }
    }

    public int solution(String begin, String target, String[] words) {
        answer = 1000;
        boolean[] isVisited = new boolean[words.length];
        dfs(begin, target, words, isVisited, 0);
        return answer == 1000 ? 0 : answer;
    }
}