import java.util.*;

class Solution {

    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());

        list.sort((o1, o2) -> Integer.compare(map.get(o2), map.get(o1)));

        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            if (sum < k) {
                sum += map.get(list.get(i));
                answer++;
            } else {
                break;
            }
        }
        return answer;
    }
}