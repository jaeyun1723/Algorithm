import java.util.*;
import java.awt.*;
class Solution {
    static int[] dx={0,0,-1,1},dy={-1,1,0,0};
    public int solution(int[][] maps) {
        int answer = 0;
        boolean[][] isVisited= new boolean[maps.length][maps[0].length];
        Deque<int[]> deq=new ArrayDeque<>();
        deq.offer(new int[]{0,0,1});
        isVisited[0][0]=true;
        while(!deq.isEmpty()){
            int[] now=deq.pollFirst();
            if(now[0]==maps.length-1&&now[1]==maps[0].length-1)
            {answer = now[2]; break;}
            for(int i=0;i<4;i++){
                int nextX=now[0]+dx[i], nextY=now[1]+dy[i];
                if(nextX<0||nextY<0||nextX>=maps.length||nextY>=maps[0].length||isVisited[nextX][nextY]) continue;
                if(maps[nextX][nextY]==0) continue;
                isVisited[nextX][nextY]=true;
                deq.offerLast(new int[]{nextX,nextY,now[2]+1});
            }
        }
        if(answer==0) answer=-1;
        return answer;
    }
}