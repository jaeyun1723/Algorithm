import java.util.*;

class Solution {
    public static int bfs(int[][] wires, int x){
        int result=1;
        boolean[] isVisit=new boolean[wires.length];
        isVisit[x]=true;
        Deque<Integer> deq=new ArrayDeque<>();
        deq.offerLast(x);
        while(!deq.isEmpty()){
            int now = deq.pollFirst();
            for(int i=1;i<wires.length;i++){
                if(wires[now][i]==1&&!isVisit[i]){
                    deq.offerLast(i);
                    isVisit[i]=true;
                    result++;
                }
            }
        }
        if(x==7){
            for(int i=1;i<isVisit.length;i++)
                if(isVisit[i]) System.out.println(i);
        }
        return result;
        
    }
    public int solution(int n, int[][] wires) {
        int answer=Integer.MAX_VALUE;
        int[][] networks=new int[n+1][n+1];
        for(int i=0;i<wires.length;i++){
            int[] wire=wires[i];
            networks[wire[0]][wire[1]]=1;
            networks[wire[1]][wire[0]]=1;
        }
        for(int i=1;i<n;i++){
            for(int j=i+1;j<=n;j++){
                if(networks[i][j]==1){
                    networks[i][j]=networks[j][i]=0;
                    int a = bfs(networks,i);
                    int b = bfs(networks,j);
                    if(i==3&&j==7){
                        System.out.println(a+" "+b);
                    }
                    networks[i][j]=networks[j][i]=1;
                    answer=Math.min(answer,Math.abs(a-b));
                    if(answer==0) return 0;
                }
            }
        }
        
        return answer;
    }
}