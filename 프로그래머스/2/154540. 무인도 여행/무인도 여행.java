import java.util.*;
class Solution {

    static int n, m;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static char[][] map;

    public int bfs(int x, int y, boolean[][] isVisit) {
        Deque<int[]> deq=new ArrayDeque<>();
        isVisit[x][y]=true;
        deq.add(new int[]{x,y});
        int answer=map[x][y]-'0';
        while(!deq.isEmpty()){
            int[] now=deq.pollFirst();
            for(int i=0;i<4;i++){
                int nx=now[0]+dx[i];
                int ny=now[1]+dy[i];
                if(nx<0||ny<0||nx>=n||ny>=m||isVisit[nx][ny]) continue;
                if(map[nx][ny]=='X') continue;
                answer+=map[nx][ny]-'0';
                isVisit[nx][ny]=true;
                deq.add(new int[]{nx,ny});
            }
        }
        return answer;

    }

    public int[] solution(String[] maps) {
        int[] answer = {};
        n = maps.length;
        m = maps[0].length();
        // X : 바다, 숫자 : 무인도
        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = maps[i].toCharArray();
        }
        boolean[][] isVisit = new boolean[n][m];
        ArrayList<Integer> res=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 'X' && !isVisit[i][j]) {
                    res.add(bfs(i, j, isVisit));
                }
            }
        }
        if(res.isEmpty()) res.add(-1);
        res.sort(null);
        answer= res.stream().mapToInt(i->i).toArray();
        return answer;
    }
}