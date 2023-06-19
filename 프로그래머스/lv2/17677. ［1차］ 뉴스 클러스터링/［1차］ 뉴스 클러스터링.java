import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1=str1.toLowerCase();
        str2=str2.toLowerCase();
        ArrayList<String> s1 = new ArrayList<>();
        ArrayList<String> s2 = new ArrayList<>();

        for(int i=0;i<str1.length()-1;i++){
            if(str1.charAt(i)>='a'&&str1.charAt(i)<='z'&&
               str1.charAt(i+1)>='a'&&str1.charAt(i+1)<='z')
            s1.add(str1.substring(i,i+2));
        }
         for(int i=0;i<str2.length()-1;i++){
            if(str2.charAt(i)>='a'&&str2.charAt(i)<='z'&&
               str2.charAt(i+1)>='a'&&str2.charAt(i+1)<='z')
            s2.add(str2.substring(i,i+2));
        }
        int like=0;
        for(String element : s1){
            if(s2.remove(element))
                like++;
        }
        
        int diff=s1.size()+s2.size();
        if(diff==0) answer=65536;
        else answer=(int)Math.floor(like/(double)diff*65536);
        return answer;
    }
}