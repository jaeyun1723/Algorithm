import java.util.*;

class Solution {
    static int N, M, endX, endY;
    static int[] dx = {1, 0, 0, -1}, dy = {0, -1, 1, 0};
    static char[] command = {'d', 'l', 'r', 'u'};
    static String answer = "impossible";

    public boolean dfs(int r, int c, String str, int distance, int k) {
        if (distance == 0 && k == 0) {
            answer = str;
            return true;
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = r + dx[i];
                int ny = c + dy[i];
                int diff = Math.abs(nx - endX) + Math.abs(ny - endY);
                if (nx < 1 || ny < 1 || nx > N || ny > M || diff > k) continue;
                if ((diff % 2 == 0 && (k - 1) % 2 == 0) || (diff % 2 == 1 && (k - 1) % 2 == 1)) {
                    if (dfs(nx, ny, str + command[i], diff, k - 1))
                        return true;
                }
            }
        }
        return false;
    }


    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        N = n;
        M = m;
        endX = r;
        endY = c;
        int dist = Math.abs(x - r) + Math.abs(y - c);
        dfs(x, y, "", dist, k);
        return answer;
    }


}