import java.util.*;

class Solution {


    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        int round = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // 일단 다 넣고 안되는 시점부터 무적권을 가장 높은 거에서 해서 남은 생명을 살리는 것
        for (int e : enemy) {
            pq.add(e);
            n -= e;
            if (n < 0) {
                while (!pq.isEmpty()) {
                    if (k == 0) {
                        break;
                    }

                    n += pq.poll();
                    k--;

                    if (n >= 0) {
                        break;
                    }
                }
                if (n < 0) {
                    return round - 1;
                }

            }
            round++;
        }
        return enemy.length;
    }
}