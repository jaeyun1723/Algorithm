import java.util.*;

class Solution {
    static int piro, answer;
    static boolean[] isvisited;
    static int[][] dun;
    static void pirodo(int remain, int cnt){
        for(int i=0;i<dun.length;i++){
            if(remain>=dun[i][0]&& !isvisited[i]){
                isvisited[i]=true;
                pirodo(remain-dun[i][1],cnt+1);
                        isvisited[i]=false;
            }
        }
        answer=Math.max(answer,cnt);
    }
        
    public int solution(int k, int[][] dungeons) {
        piro=k;
        dun=dungeons;
        isvisited=new boolean[dungeons.length];
        pirodo(k,0);
        return answer;
    }
}