import java.util.*;

class Solution {
    static int[] dx={-1,1,0,0}, dy={0,0,-1,1};
    static boolean[][] isVisited;
    static int bfs(int x,int y,String[] maps){
        Deque<int[]>deq=new ArrayDeque<>();
        isVisited[x][y]=true;
        deq.offerLast(new int[]{x,y});
        int sum=maps[x].charAt(y)-'0';
        while(!deq.isEmpty()){
            int[] now=deq.pollFirst();
            for(int i=0;i<4;i++){
                int[] next={now[0]+dx[i],now[1]+dy[i]};
                if(next[0]<0||next[1]<0||next[0]>=maps.length||next[1]>=maps[1].length()||isVisited[next[0]][next[1]]||maps[next[0]].charAt(next[1])=='X') continue;
                isVisited[next[0]][next[1]]=true;
                sum+=maps[next[0]].charAt(next[1])-'0';
                deq.offerLast(new int[]{next[0],next[1]});
            }
        }
        return sum;
    }
    public int[] solution(String[] maps) {
        ArrayList<Integer> answer=new ArrayList<>();
        isVisited=new boolean[maps.length][maps[0].length()];
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[i].length();j++){
                if(maps[i].charAt(j)!='X'&&!isVisited[i][j]){
                    answer.add(bfs(i,j,maps));
                }
            }
        }
        if(answer.isEmpty()) return new int[]{-1};
        Collections.sort(answer);
        int[] result=new int[answer.size()];
        for(int i=0;i<answer.size();i++)
            result[i]=answer.get(i);
        return result;
    }
}