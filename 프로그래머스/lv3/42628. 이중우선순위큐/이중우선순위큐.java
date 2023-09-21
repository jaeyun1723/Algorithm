import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> maxpq=new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minpq=new PriorityQueue<>();
        for(int i=0;i<operations.length;i++){
            String[] str=operations[i].split(" ");
            if(str[0].equals("I")){
                int num=Integer.parseInt(str[1]);
                maxpq.offer(num);
                minpq.offer(num);
            }
            else{
                if(maxpq.isEmpty()||minpq.isEmpty()) continue;
                if(str[1].equals("1")){
                    int num=maxpq.poll();
                    minpq.remove(num);
                }
                else
                {
                    int num=minpq.poll();
                    maxpq.remove(num);
                }
            }
        }
        
        answer[0]=(maxpq.isEmpty())?0:maxpq.poll();
        answer[1]=(minpq.isEmpty())?0:minpq.poll();
        return answer;
    }
}