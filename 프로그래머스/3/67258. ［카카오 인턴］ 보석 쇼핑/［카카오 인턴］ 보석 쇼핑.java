import java.util.*;

class Solution {

    public int[] solution(String[] gems) {
        int len = gems.length;
        int[] answer = new int[]{1, len};
        Set<String> set = new HashSet<>();
        for (String gem : gems) {
            set.add(gem);
        }

        int start = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < gems.length; i++) {
            map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);

            while (map.get(gems[start]) > 1) {
                map.put(gems[start], map.get(gems[start]) - 1);
                start++;
            }

            if (map.size() == set.size()) {
                if (i - start < answer[1] - answer[0]) {
                    answer[0] = start + 1;
                    answer[1] = i + 1;
                }
            }
        }

        return answer;
    }
}