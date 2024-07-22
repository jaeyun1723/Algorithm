import java.util.*;

class Solution {

    public String solution(String number, int k) {
        String answer = "";
        
        StringBuilder sb=new StringBuilder();
        int start=0;
        for(int i=0;i<number.length()-k;i++){
            char max=0;
            for(int j=start;j<=i+k;j++){
                if(max<number.charAt(j)){
                    max=number.charAt(j);
                    start=j+1;
                }
            }
            sb.append(max);
        }
            
        return answer=sb.toString();
    }
}