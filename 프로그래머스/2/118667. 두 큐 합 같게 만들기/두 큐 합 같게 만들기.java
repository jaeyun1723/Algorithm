import java.util.*;

class Solution {
  
    
    public int solution(int[] queue1, int[] queue2) {
        int answer=0;
        Queue<Integer> q1=new ArrayDeque<>();
        Queue<Integer> q2=new ArrayDeque<>();
        long sum1=0;
        long sum2=0;
        long total=0;
        for(int num : queue1){
            q1.offer(num);
            sum1+=num;
        }
        for(int num : queue2){
            q2.offer(num);
            sum2+=num;
        }
        total=sum1+sum2;
        if(total%2!=0) return -1;
        long target=total/2;
        while(true){
            if(answer>(queue1.length+queue2.length)*2){
               return -1;
            }
            if(sum1==target) return answer;
            if(sum1>sum2){
                if(q1.isEmpty()) return -1;
                int num=q1.poll();
                q2.offer(num);
                sum1-=num;
                sum2+=num;
            }
            else{
                if(q2.isEmpty()) return -1;
                int num=q2.poll();
                q1.offer(num);
                 sum1+=num;
                sum2-=num;
            }
            answer++;
        }
    }
}