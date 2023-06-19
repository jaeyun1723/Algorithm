import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] str=s.split(" ");
        int max,min;
        max=min=Integer.parseInt(str[0]);
        for(int i=0;i<str.length;i++)
        {
            int num=Integer.parseInt(str[i]);
            if(min>num) min=num;
            if(max<num) max=num;
        }
        answer=min+" "+max;
        return answer;
    }
}