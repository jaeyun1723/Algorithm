import java.util.*;

class Solution {


    public boolean isMatch(int x, int y, char[][] map, boolean[][] block) {
        if (map[x + 1][y] == map[x][y] && map[x][y + 1] == map[x][y]
            && map[x + 1][y + 1] == map[x][y]) {
            block[x][y] = block[x + 1][y] = block[x][y + 1] = block[x + 1][y + 1] = true;
            return true;
        }
        return false;
    }

    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }
        while (true) {
            boolean[][] block = new boolean[m][n];
            boolean flag = false;
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (map[i][j] != '0' && isMatch(i, j, map, block)) {
                        flag = true;
                    }
                }
            }
            if (flag) {
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (block[i][j]) {
                            map[i][j] = '0';
                            answer++;
                        }
                    }
                }
                for (int i = 0; i < n; i++) {
                    Stack<Character> stk = new Stack<>();
                    for (int j = 0; j < m; j++) {
                        if (map[j][i] != '0') {
                            stk.push(map[j][i]);
                        }
                    }
                    for (int j = m - 1; j >= 0; j--) {
                        if (!stk.isEmpty()) {
                            map[j][i] = stk.pop();
                        } else {
                            map[j][i] = '0';
                        }
                    }
                }
            } else {
                break;
            }
        }
        return answer;
    }
}