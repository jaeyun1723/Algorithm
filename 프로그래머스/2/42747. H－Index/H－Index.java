import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer=0;
        for(int i=citations.length;i>=0;i--){
            int cnt=0;
            for(int j=0;j<citations.length;j++){
                if(citations[j]>=i) cnt++;
            }
            if(cnt>=i){
                return i;
            }
        }
        
        return answer;
    }
}