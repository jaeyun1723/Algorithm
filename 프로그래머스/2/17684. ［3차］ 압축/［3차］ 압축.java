import java.util.*;

  class Solution {

        public int[] solution(String msg) {
            ArrayList<Integer> answers = new ArrayList<>();
            Map<String, Integer> map = new HashMap<>();
            int cnt = 1;
            for (int i = 0; i < 26; i++) {
                char c = (char) (65 + i);
                map.put(String.valueOf(c), cnt++);
            }
            for (int i = 0; i < msg.length();) {
                StringBuilder sb = new StringBuilder();
                sb.append(msg.charAt(i));
                int value = map.get(sb.toString());
                while (map.containsKey(sb.toString()) && ++i < msg.length()) {
                    value = map.get(sb.toString());
                    sb.append(msg.charAt(i));
                }
                if(i>=msg.length()) value=map.get(sb.toString());
                answers.add(value);
                if (i < msg.length()) {
                    map.put(sb.toString(), cnt++);
                }
            }
            int[] answer = answers.stream().mapToInt(i -> i).toArray();
            return answer;
        }
    }