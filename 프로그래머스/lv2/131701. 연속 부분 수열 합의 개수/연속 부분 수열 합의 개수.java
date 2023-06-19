import java.util.*;

class Solution {

    public int solution(int[] elements) {
        int answer = 0;
        int[] arr= new int[elements.length*2];
        Set<Integer> set= new HashSet<>();
        for(int i=0;i<elements.length;i++){
            arr[i]=arr[i+elements.length]=elements[i];
            set.add(arr[i]);
        }
        
        for(int start=0;start<elements.length;start++){
            int value=0;
            for(int j=start;j<start+elements.length;j++){
                value+=arr[j];
                set.add(value);
            }
        }
        answer=set.size();
  return answer;
    }
}