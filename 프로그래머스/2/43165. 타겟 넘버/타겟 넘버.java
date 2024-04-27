import java.util.*;

class Solution {
    static int answer;
        
    public static void subset(int[] numbers, int target, int idx, int cnt){
        if(idx==numbers.length){
            if(cnt==target) answer++;
            return;
        }
        subset(numbers,target,idx+1,cnt+numbers[idx]);
        subset(numbers,target,idx+1,cnt-numbers[idx]);
    }
        
    public int solution(int[] numbers, int target) {
       subset(numbers,target,0,0);
        return answer;
    }
}