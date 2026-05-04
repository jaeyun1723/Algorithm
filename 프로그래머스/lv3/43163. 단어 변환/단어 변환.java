class Solution {

  static int answer = Integer.MAX_VALUE;

  public int difference(String w1, String w2) {
    int result = 0;
    for (int i = 0; i < w1.length(); i++) {
      if (w1.charAt(i) != w2.charAt(i)) {
        result++;
      }
    }
    return result;
  }

  public void dfs(String start, String end, String[] words, boolean[] isChange, int count) {
    if (start.equals(end)) {
      answer = Math.min(answer, count);
      return;
    }
    for (int i = 0; i < words.length; i++) {
      if (!isChange[i] && difference(start, words[i]) == 1) {
        isChange[i] = true;
        dfs(words[i], end, words, isChange, count + 1);
        isChange[i] = false;
      }
    }
  }

  public int solution(String begin, String target, String[] words) {
    dfs(begin, target, words, new boolean[words.length], 0);
    return answer == Integer.MAX_VALUE ? 0 : answer;
  }
}