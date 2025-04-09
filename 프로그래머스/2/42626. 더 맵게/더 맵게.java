import java.util.*;

class Solution {

  public int solution(int[] scoville, int K) {
    int answer = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int food : scoville) {
      pq.add(food);
    }
      if (K == 0) {
          return 0;
      }
    while (!pq.isEmpty() && pq.peek() < K && pq.size() >= 2) {
      int food1 = pq.poll();
      int food2 = pq.poll();
      pq.add(food1 + food2 * 2);
      answer++;
    }

    return pq.peek() >= K ? answer : -1;
  }
}