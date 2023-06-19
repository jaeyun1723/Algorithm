class Solution {
    static int tgt, cnt;
    static int[] num;
    
    static void dfs(int sum, int idx){
        if(idx == num.length){
            if(sum == tgt) cnt++;
            return;
        }
        else{
            dfs(sum+num[idx],idx+1);       
            dfs(sum-num[idx],idx+1);
        }
        
    }
    public int solution(int[] numbers, int target) {
        int answer = 0;
        tgt = target;
        num = numbers;
        dfs(0,0);
        return answer=cnt;
    }
}