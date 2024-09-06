import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // bridge_length >= deq.size()
        int answer = 0;
        int limit = weight;
        Deque<Integer> deq = new ArrayDeque<>();
        for (int i = 0; i < bridge_length; i++) {
            deq.offerLast(0);
        }
        int deqSum = 0, sec = 0, idx = 0;

        while (idx < truck_weights.length) {
            sec++;
            int arrival = deq.pollFirst();
            deqSum -= arrival;
            if (deqSum + truck_weights[idx] <= limit) {
                deq.offerLast(truck_weights[idx]);
                deqSum += truck_weights[idx++];
            } else {
                deq.offerLast(0);
            }

        }

        return answer = sec + bridge_length;
    }
}