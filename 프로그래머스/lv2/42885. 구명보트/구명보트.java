import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
       int answer=0, start=0,end=people.length-1;
        Arrays.sort(people);
        while(start<=end){
            if(people[start]+people[end]<=limit){
                start++;
                end--;
            }
            else
                end--;
            answer++;
        }
        return answer;
    }
}