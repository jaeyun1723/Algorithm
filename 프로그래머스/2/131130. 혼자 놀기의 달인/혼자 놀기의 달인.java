import java.util.*;

class Solution {

    public int solution(int[] cards) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        boolean[] isGroup = new boolean[cards.length + 1];
        // cards[0] : 1번째
        for (int i = 0; i < cards.length; i++) {
            if (!isGroup[i]) {
                int idx = i;
                int cnt = 0;
                while (!isGroup[idx]) {
                    isGroup[idx] = true;
                    idx = cards[idx] - 1;
                    cnt++;
                }
                pq.add(cnt);
            }
        }
        if (pq.size() < 2) {
            answer = 0;
        } else {
            answer = pq.poll() * pq.poll();
        }

        return answer;
    }
}