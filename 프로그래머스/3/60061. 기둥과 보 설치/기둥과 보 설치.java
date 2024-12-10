import java.util.*;

class Solution {
    static int[][][] map;

    public boolean canDelete(int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (map[i][j][0] == 1 && !checkPillar(i, j)) return false;
                if (map[i][j][1] == 1 && !checkBo(i, j)) return false;
            }
        }
        return true;
    }

    public boolean checkPillar(int x, int y) {
        // 기둥(0)은 바닥 위에 있거나 보의 한쪽 끝 부분 위에 있거나, 또는 다른 기둥 위에 있어야 합니다.
        return y == 0
                || map[x][y - 1][0] == 1
                || map[x][y][1] == 1
                || (x > 0 && map[x - 1][y][1] == 1);
    }

    public boolean checkBo(int x, int y) {
        // 보(1)는 한쪽 끝 부분이 기둥 위에 있거나, 또는 양쪽 끝 부분이 다른 보와 동시에 연결되어 있어야 합니다.
        return map[x][y - 1][0] == 1
                || map[x + 1][y - 1][0] == 1
                || (x > 0 && map[x - 1][y][1] == 1 && map[x + 1][y][1] == 1);
    }

    public int[][] solution(int n, int[][] build_frame) {
        ArrayList<int[]> arr = new ArrayList<>();

        map = new int[n + 1][n + 1][2];

        for (int[] frame : build_frame) {
            int x = frame[0];
            int y = frame[1];
            int type = frame[2]; // 기둥(0), 보(1)
            int state = frame[3]; // 삭제(0), 설치(1)
            if (type == 0) { // 기둥
                if (state == 1) {
                    if (checkPillar(x, y)) {
                        map[x][y][0] = 1;
                        arr.add(new int[]{x, y, type});
                    }
                } else {
                    map[x][y][0] = 0;
                    if (!canDelete(n)) {
                        map[x][y][0] = 1;
                    } else
                        arr.removeIf(item -> item[0] == x && item[1] == y && item[2] == type);
                }
            } else { // 보
                // 보(1)는 한쪽 끝 부분이 기둥 위에 있거나, 또는 양쪽 끝 부분이 다른 보와 동시에 연결되어 있어야 합니다.
                if (state == 1) {
                    if (checkBo(x, y)) {
                        map[x][y][1] = 1;
                        arr.add(new int[]{x, y, type});
                    }
                } else {
                    map[x][y][1] = 0;
                    if (!canDelete(n)) {
                        map[x][y][1] = 1;
                    } else
                        arr.removeIf(item -> item[0] == x && item[1] == y && item[2] == type);
                }
            }
        }

        arr.sort((o1, o2) -> {
            if (o1[0] == o2[0]) {
                if (o1[1] == o2[1])
                    return Integer.compare(o1[2], o2[2]);
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });


        return arr.toArray(new int[arr.size()][]);
    }
}