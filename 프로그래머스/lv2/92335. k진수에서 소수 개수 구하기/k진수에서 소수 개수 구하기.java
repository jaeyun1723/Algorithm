import java.util.*;

class Solution {
    static boolean isPrime(long num){
        if(num==1) return false;
      for(int i=2;i<=Math.sqrt(num);i++)
          if(num%i==0) return false;
        return true;
    }
    static String convert(int n, int k){
        StringBuilder sb=new StringBuilder();
        while(n/k>0){
            sb.insert(0,n%k);
            n/=k;
        }
        sb.insert(0,n%k);
        return sb.toString();
    }
    public int solution(int n, int k) {
        int answer = 0;
        String num=convert(n,k);
        String[] str=num.split("0");
        for(int i=0;i<str.length;i++){
            if(str[i].equals(""))continue;
            if(isPrime(Long.parseLong(str[i])))
                answer++;
            }   
        
        return answer;
    }
}