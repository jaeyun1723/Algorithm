import java.util.*;

class Solution {
    static int answer;
    static String[][] set;

    static void dfs(String now, String target, int count) {
        if (now.equals(target)) {
            if (answer == 0) {
                answer = count;
            } else {
                answer = Math.min(answer, count);
            }
            return;
        }
        for (int i = 0; i < set.length; i++) {
            if (set[i][1].equals("1")) {
                continue;
            }
            int cnt = 0;
            for (int j = 0; j < set[i][0].length(); j++) {
                if (now.charAt(j) != set[i][0].charAt(j)) {
                    cnt++;
                }
                if (cnt > 1) {
                    break;
                }
            }
            if (cnt == 1) {
                set[i][1] = "1";
                dfs(set[i][0], target, count + 1);
                set[i][1] = "0";
            }
        }
    }

    public static int solution(String begin, String target, String[] words) {
        set = new String[words.length][2];
        for (int i = 0; i < set.length; i++) {
            set[i][0] = words[i];
            set[i][1] = "0";
        }
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                dfs(begin, target, 0);
                break;
            }
        }
        
        return answer;
    }


}