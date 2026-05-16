import java.util.*;

class Solution {

    public void dfs(int n, int[][] computers, boolean[] isVisited, int cur) {
        for (int i = 0; i < n; i++) {
            if (computers[cur][i] == 1 && !isVisited[i]) {
                isVisited[i] = true;
                dfs(n, computers, isVisited, i);
            }
        }
    }

    public int solution(int n, int[][] computers) {
        boolean[] isVisited = new boolean[n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                dfs(n, computers, isVisited, i);
                answer++;
            }
        }
        return answer;
    }
}