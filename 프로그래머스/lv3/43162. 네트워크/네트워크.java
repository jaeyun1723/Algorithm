class Solution {
    static int[] parent;
    
    public static int find(int i){
        if(parent[i]==i) return i;
        return parent[i]=find(parent[i]);
    }
    public static void union(int i,int j){
        int p1=find(i), p2=find(j);
        if(p1>p2) parent[p1]=p2;
        else parent[p2]=p1;
    }
    public int solution(int n, int[][] computers) {
        int answer = n;
        parent=new int[n];
        for(int i=0;i<n;i++)
            parent[i]=i;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) continue;
                if(computers[i][j]==1&&find(i)!=find(j)){
                    union(i,j);
                    answer--;
                }
            }
        }
        
        return answer;
    }
}