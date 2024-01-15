import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer,-1);
        ArrayDeque<Integer> deq=new ArrayDeque<>();
        deq.offerLast(0);
        for(int i=0;i<numbers.length;i++){
            while(!deq.isEmpty()&&numbers[i]>numbers[deq.peekLast()]){
                answer[deq.pollLast()]=numbers[i];
            }
            deq.offerLast(i);
        }
        return answer;
    }
}