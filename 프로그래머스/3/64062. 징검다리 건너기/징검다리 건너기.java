class Solution {
    
    public boolean isCrossOver(int cnt, int[] stones, int k){
        int seq=0;
        for(int i=0;i<stones.length;i++){
            if(stones[i]-cnt<0){
                seq++;
                if(seq>=k) return false;
            }
            else
                seq=0;
        }
        return true;
    }
    
    public int solution(int[] stones, int k) {
        int answer = 0;
        int min=1, max=200_000_000;
        while(min<=max){
            int mid=(min+max)/2;
            
            if(isCrossOver(mid,stones,k)){
                answer=Math.max(answer, mid);
                min=mid+1;
            }
            else{
                max=mid-1;
            }
        }
        
        return answer;
    }
}