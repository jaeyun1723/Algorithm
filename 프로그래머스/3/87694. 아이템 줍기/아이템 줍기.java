import java.util.*;

class Solution {

    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void mark(int[][] rectangle) {
        for (int[] rect : rectangle) {
            int startX = rect[0] * 2;
            int endX = rect[2] * 2;
            int startY = rect[1] * 2;
            int endY = rect[3] * 2;
            for (int i = startX; i <= endX; i++) {
                for (int j = startY; j <= endY; j++) {
                    if (i == startX || i == endX || j == startY || j == endY) {
                        if (map[i][j] == 2) {
                            continue;
                        }
                        map[i][j] = 1;
                    } else {
                        map[i][j] = 2;
                    }
                }
            }
        }
    }

    public static int bfs(int startX, int startY, int endX, int endY) {
        int count = Integer.MAX_VALUE;
        boolean[][] isVisit = new boolean[101][101];
        Deque<int[]> deq = new ArrayDeque<>();
        deq.offerLast(new int[]{startX, startY, 0});
        isVisit[startX][startY] = true;

        while (!deq.isEmpty()) {
            int[] now = deq.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];
                if (nextX < 1 || nextX > 100 || nextY < 1 || nextY > 100) {
                    continue;
                }
                if (isVisit[nextX][nextY]) {
                    continue;
                }
                if (nextX == endX && nextY == endY) {
                    count = Math.min(count, now[2] + 1);
                }
                if (map[nextX][nextY] == 1) {
                    isVisit[nextX][nextY] = true;
                    deq.offerLast(new int[]{nextX, nextY, now[2] + 1});
                }
            }
        }
        return count / 2;
    }

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int[101][101];
        mark(rectangle);
        return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
    }
}