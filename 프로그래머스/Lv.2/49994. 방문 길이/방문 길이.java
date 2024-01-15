class Solution {
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,1,-1}; // 상하좌우
    public int solution(String dirs) {
        int answer = 0;
        boolean[][][] roads=new boolean[11][11][4];
        int x=5,y=5;
        for(int i=0;i<dirs.length();i++){
            int d=0;
            if(dirs.charAt(i)=='U')
                d=0;
            else if(dirs.charAt(i)=='D')
                d=1;
            else if(dirs.charAt(i)=='L')
                d=2;
            else
                d=3;
            int nx=x+dx[d], ny=y+dy[d];
            if(nx<0||ny<0||nx>10||ny>10) continue;
            if(!roads[nx][ny][d]){
                roads[nx][ny][d]=true;
                d = (d%2==0) ? d+1 : d-1; //0->1 2->3
                roads[x][y][d]=true;
                answer++;
            }
            
            x=nx;
            y=ny;
        }
        return answer;
    }
}