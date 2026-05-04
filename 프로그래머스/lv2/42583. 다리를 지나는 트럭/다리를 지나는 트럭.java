import java.util.*;

class Solution {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }
        int bridgeSum = 0;
        int idx = 0;
        while (idx < truck_weights.length) {
            answer++;
            bridgeSum -= bridge.poll();
            if (bridgeSum + truck_weights[idx] <= weight) {
                bridge.offer(truck_weights[idx]);
                bridgeSum += truck_weights[idx++];
            } else {
                bridge.offer(0);
            }
        }

        return answer + bridge_length;
    }
}