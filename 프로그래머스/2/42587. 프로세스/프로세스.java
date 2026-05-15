import java.util.*;

class Solution {

    public int solution(int[] priorities, int location) {
        int answer = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>((p1, p2) -> (Integer.compare(p2, p1)));
        // [우선순위, 인덱스]
        Deque<int[]> deq = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
            deq.offerLast(new int[]{priorities[i], i});
        }
        while (!pq.isEmpty()) {
            int max = pq.poll();
            while (max != deq.peekFirst()[0]) {
                int[] que = deq.pollFirst();
                deq.offerLast(que);
            }
            int[] now = deq.pollFirst();
            if (now[1] == location) {
                return answer;
            } else {
                answer++;
            }
        }
        return answer;
    }


}