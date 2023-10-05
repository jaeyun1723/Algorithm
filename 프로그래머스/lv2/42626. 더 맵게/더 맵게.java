import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<scoville.length;i++)
            pq.offer(scoville[i]);
        while(pq.peek()<K){
            if(pq.size()<2) return -1;
            int s1=pq.poll(), s2=pq.poll();
            answer++;
            pq.offer(s1+2*s2);
        }
        return answer;
    }
}