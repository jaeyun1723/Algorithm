import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int sum=0;
        int[] cnt = new int[10000001];
        for(int i=0;i<tangerine.length;i++)
            cnt[tangerine[i]]++;
        Arrays.sort(cnt);
        for(int i=cnt.length-1;i>=0;i--){
            if(cnt[i]==0)continue;
            if(sum<k) {
                sum+=cnt[i];
                answer++;
            }
            else return answer;
            }
        return answer;
    }
}