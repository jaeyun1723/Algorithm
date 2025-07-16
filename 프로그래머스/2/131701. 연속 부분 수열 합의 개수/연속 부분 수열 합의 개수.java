import java.util.*;

class Solution {

    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        for (int e : elements) {
            set.add(e);
        }
        for (int i = 0; i < elements.length; i++) {
            int sum = 0;
            for (int j = 0; j < elements.length; j++) {
                sum += elements[(i + j) % elements.length];
                set.add(sum);
            }
        }

        return answer = set.size();
    }
}