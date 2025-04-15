import java.util.*;

class Solution {

    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < works.length; i++) {
            pq.add(works[i]);
        }

        while (n-- > 0 && !pq.isEmpty()) {
            int k = pq.poll();
            if (k != 0) {
                pq.add(--k);
            }
        }
        int size = pq.size();
        for (int i = 0; i < size; i++) {
            if (!pq.isEmpty()) {
                answer += (long) Math.pow(pq.poll(), 2);
            }
        }
        return answer;
    }
}