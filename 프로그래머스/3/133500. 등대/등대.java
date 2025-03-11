import java.util.*;

class Solution {
    static int answer = 0;
    static ArrayList<Integer>[] list;

    public int dfs(int node, int prev) {
        if (list[node].size() == 1 && list[node].get(0) == prev) return 1;

        int cnt = 0;
        for (int i = 0; i < list[node].size(); i++) {
            int next = list[node].get(i);
            if (next == prev) continue;
            cnt += dfs(next, node);
        }
        if (cnt == 0)
            return 1;

        answer++;
        return 0;
    }


    public int solution(int n, int[][] lighthouse) {
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            list[i] = new ArrayList<Integer>();
        for (int i = 0; i < lighthouse.length; i++) {
            int[] e = lighthouse[i];
            list[e[0]].add(e[1]);
            list[e[1]].add(e[0]);
        }
        dfs(1, 0);

        return answer;
    }
}