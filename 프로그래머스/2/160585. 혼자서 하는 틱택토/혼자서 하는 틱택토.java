import java.util.*;

class Solution {

    public static int win(char[][] map, char e) {
        int result = 0;
        for (int i = 0; i < 3; i++) {
            if (map[i][0] == e && map[i][1] == e && map[i][2] == e) result++;
            if (map[0][i] == e && map[1][i] == e && map[2][i] == e) result++;
        }
        if (map[0][0] == e && map[1][1] == e && map[2][2] == e) result++;
        if (map[2][0] == e && map[1][1] == e && map[0][2] == e) result++;
        return result;
    }

    public int solution(String[] board) {

        char[][] map = new char[3][3];
        int oCnt = 0;
        int xCnt = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map[i][j] = board[i].charAt(j);
                if (board[i].charAt(j) == 'O') oCnt++;
                if (board[i].charAt(j) == 'X') xCnt++;
            }
        }
        // 1. x가 o보다 많으면 안된다. o와 x의 차이는 1이하
        if (xCnt > oCnt || oCnt - xCnt > 1) return 0;
        // 2. 둘 다 완성되는 경우는 없어야 한다.
        if (win(map, 'O') > 0 && win(map, 'X') > 0) return 0;
        // 3. o가 이긴 경우, x와 개수가 같거나 크면 안된다.
        if (win(map, 'O') == 1 && oCnt <= xCnt) return 0;
        // 4. x가 이긴 경우, o보다 개수가 많으면 안된다.
        if (win(map, 'X')==1 && oCnt > xCnt) return 0;

        return 1;

    }
}