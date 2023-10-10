import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq=new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2){
                return o2-o1;
            }
        });
        for(int i=0;i<works.length;i++)
            pq.offer(works[i]);
        while(n-->0){
            int work=pq.poll();
            if(work==0) break;
            pq.offer(--work);
        }
        
        while(!pq.isEmpty())
            answer+=Math.pow(pq.poll(),2);
        return answer;
    }
}