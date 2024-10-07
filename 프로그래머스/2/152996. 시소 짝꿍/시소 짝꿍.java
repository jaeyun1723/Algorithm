import java.util.*;

class Solution {

    public long solution(int[] weights) {
        long answer = 0;
        
        Arrays.sort(weights);
        
        Map<Double, Integer> map=new HashMap<>();
        
        for(int w : weights){
            
            double w1=w*1.0;
            double w2=w/2.0;
            double w3=w*2/3.0;
            double w4=w*3/4.0;
            
            if(map.containsKey(w1)){
                answer+=map.get(w1);
            }
            if(map.containsKey(w2)){
                answer+=map.get(w2);
            }
            if(map.containsKey(w3)){
                answer+=map.get(w3);
            }
            if(map.containsKey(w4)){
                answer+=map.get(w4);
            }
            map.put(w1,map.getOrDefault(w1,0)+1);
        }
        
        return answer;
    }
}