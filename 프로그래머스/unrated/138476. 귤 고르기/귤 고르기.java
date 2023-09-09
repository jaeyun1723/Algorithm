import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer=0;
        Map<Integer,Integer> ggul=new HashMap<>();
        for(int i=0;i<tangerine.length;i++){
            ggul.put(tangerine[i],ggul.getOrDefault(tangerine[i],0)+1);
        }
         List<Integer> list=new ArrayList<>(ggul.keySet());
        Collections.sort(list,(o1,o2)->ggul.get(o2)-ggul.get(o1));
        
        int sum=0;
        for(int i=0;i<list.size();i++){
            sum+=ggul.get(list.get(i));
            answer++;
            if(sum>=k) break;
        }
        
        return answer;
    }
}