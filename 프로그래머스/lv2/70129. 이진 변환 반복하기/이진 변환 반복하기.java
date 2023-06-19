import java.util.*;
import java.io.*;

class Solution {
	public int[] solution(String s) {
		int[] answer = new int[2];
        while(s.length()>1){
            int num=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0') answer[1]++;
            else num++;
        }
        
        s = Integer.toBinaryString(num);
        answer[0]++;
        }
		return answer;
	}// solution
}// class