import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        String[] str=new String[numbers.length];
        
        for(int i=0;i<numbers.length;i++){
            str[i]=String.valueOf(numbers[i]);
        }
        Arrays.sort(str,new Comparator<String>(){
           public int compare(String o1, String o2){
               int n1=Integer.parseInt(o1+o2);
               int n2=Integer.parseInt(o2+o1);
               return n2-n1;
           } 
        });
        String answer="";
        for(int i=0;i<str.length;i++)
            answer+=str[i];
        if(str[0].equals("0"))
            return "0";
        return answer;
    }
}